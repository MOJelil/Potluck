<template>
  <div>
    <h1>Update Potluck</h1>
    <edit-potluck v-bind:potluck="potluckToEdit" />
  </div>
</template>

<script>
import EditPotluck from "@/components/EditPotluck";
import PotluckService from "@/services/Potluck.js";

export default {
  data() {
    return {
      potluckToEdit: {
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
    EditPotluck
  },
  created() {
     PotluckService
      .getPotluck(this.$route.params.id)
      .then((response) => {
       this.potluckToEdit = response.data;
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
      });
  }
};
</script>

<style>
</style>
