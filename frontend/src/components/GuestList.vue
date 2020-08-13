<template>
  <div class="guest-list">
    <!-- <h1>{{ this.$route.potluck.name }}</h1> -->
    <div class="user-info" v-for="user in users" :key="user.user_id">
   
    <div class="user-details-row">
   <div class="name-check-row"> <input type="checkbox" v-model="invitedGuests" :value="user"/>  <label>Name: {{ user.firstName }} {{ user.lastName }}</label> </div>
    
     <label>Email: {{ user.email }}</label> </div>
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
.guest-list {
  /* padding-right: 10px;
  padding-left: 25px; */
  padding-bottom: 10px;
  width: 480px;
}
.user-info {
  margin-bottom: 10px;
}
.user-details-row {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  background: whitesmoke;
  border-radius: 1em;
   margin-bottom: 10px;
  box-shadow: 2px 4px 4px rgba(0, 0, 0, 0.2),
    0px -5px 10px rgba(255, 255, 255, 0.15);
    padding-right: 10px;
    padding-left: 10px;
    padding-top: 5px;
    padding-bottom: 5px;
}
.name-check-row {
  display: flex;
  flex-direction: row;
}
</style>