<template>
  <div class="potluck-details">
    <h1>{{ this.$store.state.potluck.name }}</h1>
    <h1>{{ this.$store.state.potluck.location }}</h1>
    <h1>{{ this.$store.state.potluck.date_created }}</h1>
    <h1>{{ this.$store.state.potluck.potluck_time }}</h1>
    <h1>{{ this.$store.state.potluck.description }}</h1>
    <h1>{{ this.$store.state.potluck.guests }}</h1>
    <h1>{{ this.$store.state.potluck.appetizers }}</h1>
    <h1>{{ this.$store.state.potluck.entrees }}</h1>
    <h1>{{ this.$store.state.potluck.side_dishes }}</h1>
    <h1>{{ this.$store.state.potluck.desserts }}</h1>
    <h1>{{ this.$store.state.potluck.non_alcohol }}</h1>
    <h1>{{ this.$store.state.potluck.alcohol }}</h1>

  </div>
</template>

<script>
import potluck from "@/services/Potluck.js";

export default {
  name: "topic-details",
  props: {
    potluck_id: Number,
  },
  created() {
    potluck
      .getPotluck(this.potluck_id)
      .then(response => {
        this.$store.commit("SET_ACTIVE_POTLUCK", response.data);
      })
      .catch(error => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
      });

       
  }
};
</script>

<style>
</style>