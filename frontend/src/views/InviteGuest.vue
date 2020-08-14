<template>
<div>

      <div class="nav-box">
      <div class="nav-container">
        <span class="decor"></span>
        <nav>
          <ul class="primary">
            <li>
              <router-link to="/">My Potlucks</router-link>
            </li>
            <li>
              <router-link to="/potluck">Create Potluck</router-link>
            </li>
            <li>
              <router-link to="/logout">Logout</router-link>
            </li>
          </ul>
        </nav>
      </div>
    </div>
     <div class="page-name-invite-guest">
      <header class="head">Invite a Guest</header>
    </div>
    <div class="guest-available-box">
  <div class="guest-available-container">
  <div class="guests">

    <guest-list v-bind:users="allUsers" />
    
  </div>
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
.page-name-invite-guest {
  display: flex;
  justify-content: flex-end;
  font-size: 45px;
  margin-right: 130px;
}
.guest-available-box {
  display: flex;
  justify-content: flex-end;
  margin-top: 150px;
  margin-right: 25px;
}
.guest-available-container {
  display: flex;
  padding-top: 15px;
  margin-top: -120px;
  background-color: rgba(245, 245, 245, 0.575);
  justify-content: space-around;
  width: 525px;
  height: 460px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
  margin-bottom: 25px;
}

</style>