<template>
<div class="guest-available-box">
  <div class="guest-available-container">
  <div class="guests">
    <guest-list v-bind:users="allUsers" />
  </div>
  </div>
  </div>
</template>

<script>
import GuestList from "@/components/GuestList.vue";
import PotluckService from "@/services/Potluck.js";

export default {
  name: "guest",
  data() {

    return {
      allUsers: [],
     availableUsers: {
        username: "",
        firstname: "",
        lastname: "",
      }
    }
  },
  components: {
    GuestList,
  },
  created() {
/*  PotluckService
      .inviteGuest(this.$route.params.id)
      .then((response) => {
       this.availableUsers = response.data;
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
      }); */

      PotluckService
      .getAllUsers()
      .then((response) => {
       this.allUsers = response.data;
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