<template>
  <div class="guest-list">
    <!-- <h1>{{ this.$route.potluck.name }}</h1> -->
    <div v-for="user in users" :key="user.user_id">
   
    <input type="checkbox" v-model="invitedGuests" :value="user"/>
    <label>Name: {{ user.firstName }}</label>
    <label>Last Name: {{ user.lastName }}</label>
     <label>Email: {{ user.email }}</label>
    </div>
    <button
            type="submit"
            v-on:click.prevent="updateGuestList()"
            class="gradient-button gradient-button-color"
          >Invite!</button>
  </div>
</template>

<script>
import PotluckService from "../services/Potluck";

export default {
  data() {
    return {
      invitedGuests:[],
    }
  },
  name: "guest-list",
  props: {
    users:[]
  },

methods: {
    updateGuestList() {
      PotluckService.inviteGuest(this.$route.params.id, this.invitedGuests)
      .then(response => {
        if (response.status == 200) {
          this.$router.push("/");
        }
      })
    }
  },
};
</script>

<style>
</style>