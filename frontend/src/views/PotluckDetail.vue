<template>
<div class="potluck-detail-box">
  <div class="potluck-detail-container">
  <div class="potlucks">
    <potluck-details v-bind:potluck="displayedPotluck" />
    <router-link
                v-bind:to="{ name: 'bring-dish', params: { id: displayedPotluck.potluck_id } }"
              >Sign Up To Bring Dish</router-link>

              
  </div>
  </div>
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
        potluck_date: "",
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
<style>
.potluck-container {
  display: flex;
  justify-content: space-around;
  background-color: rgba(245, 245, 245, 0.575);
  padding-top: 5px;
  width: 350px;
  height: 940px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}

.potluck-box {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
  margin-right: 25px;
  margin-bottom: 50px;
}
</style>