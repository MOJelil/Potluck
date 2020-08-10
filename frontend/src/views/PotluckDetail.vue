<template>
  <div class="potlucks">
    <potluck-details v-bind:potluck="displayedPotluck" />
  </div>
</template>

<script>
import PotluckDetails from "@/components/PotluckDetails.vue";
import PotluckService from "@/services/Potluck.js";

export default {
  name: "Potlucks",
  data() {
    return {
      displayedPotluck: {
        username: "",
        name: "",
        location: "",
        date_created: "",
        potluck_time: "",
        description: "",
        guests: "",
        appetizers: "",
        entrees: "",
        side_dishes: "",
        desserts: "",
        non_alcohol: "",
        alcohol: "",
      }
    }
  },
  components: {
    PotluckDetails,
  },
  created() {
 PotluckService
      .getPotluck(this.$route.params.id)
      .then((response) => {
       this.displayedPotluck = response.data;
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
      });
  },
};
</script>