<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="name">Name</label>
      <input  type="text" v-model="potluck.name" />
    </div>
    <div class="field">
      <label for="location">Location</label>
      <input type="text" v-model="potluck.location" />
    </div>
    <div class="field">
      <label for="date_created">Date</label>
      <input type="text" v-model="potluck.date_created" />
    </div><div class="field">
      <label for="potluck_time">Time</label>
      <input type="text" v-model="potluck.potluck_time" />
    </div>
    <div class="field">
      <label for="description">Description</label>
      <input type="text" v-model="potluck.description" />
    </div>
    <div class="field">
      <label for="guests">Guests</label>
      <input type="text" v-model="potluck.guests" />
    </div>
    <div class="field">
      <label for="appetizers">Appetizers</label>
      <input type="text" v-model="potluck.appetizers" />
    </div>
    <div class="field">
      <label for="entrees">Entrees</label>
      <input type="text" v-model="potluck.entrees" />
    </div><div class="field">
      <label for="side_dishes">Side Dishes</label>
      <input type="text" v-model="potluck.side_dishes" />
    </div>
    <div class="field">
      <label for="desserts">Desserts</label>
      <input type="text" v-model="potluck.desserts" />
    </div>
    <div class="field">
      <label for="non_alcohol">Non-Alcoholic Beverages</label>
      <input type="text" v-model="potluck.non_alcohol" />
    </div>
    <div class="field">
      <label for="alcohol">Alcoholic Beverages</label>
      <input type="text" v-model="potluck.alcohol" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click.prevent="updatePotluck()">Save Changes</button>
    </div>
  </form>
</template>

<script>
import PotluckService from "../services/Potluck";

export default {
  name: "create-potluck",
  props: ["potluck"],
  data() {
    return {
    }
  },
  methods: {
    updatePotluck() {
      PotluckService.update(this.potluck.potluck_id, this.potluck)
      .then(response => {
        if (response.status == 200) {
          this.$router.push("/");
        }
      })
    }
  },
  created() {

  }
};
</script>

<style>
</style>
