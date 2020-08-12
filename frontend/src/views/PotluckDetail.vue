<template>
<body class="details">
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
    <div class="page-name-details">
      <header class="head">Potluck Details</header>
    </div>
    <div class="detail-box">
      <div class="detail-container">
        <div class="detail-items">
          <potluck-details v-bind:potluck="displayedPotluck" />
        </div>
      </div>
    </div>
    <div class="button-box">
    <div class="button-container">
      <div id="bring">
      <router-link
        v-bind:to="{ name: 'bring-dish', params: { id: displayedPotluck.potluck_id } }"
      >Bring a Dish</router-link>
      </div>

      <div id="invite">
      <router-link
        v-bind:to="{ name: 'invite-guest', params: { id: displayedPotluck.potluck_id } }"
      >Invite guests</router-link>
      </div>
    </div>
    </div>
  </div>
</body>
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
      },
    };
  },
  components: {
    PotluckDetails,
  },
  created() {
    PotluckService.getPotluck(this.$route.params.id)
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
.details {
  background: url("../images/wooden-bg.jpg") no-repeat center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;
}

.detail-container {
  display: flex;
  justify-content: space-between;
  background-color: rgba(245, 245, 245, 0.575);
  padding-top: 5px;
  width: 90%;
  height: 940px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}

.detail-box {
  display: flex;
  justify-content: space-around;
  margin-top: 20px;
  margin-bottom: 50px;
}
.page-name-details {
  display: flex;
  justify-content: flex-start;
  font-size: 45px;
  margin-left: 25px;
  margin-top: -75px;
}
.button-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  background: whitesmoke;
  border-radius: 1em;
  width: 40%;
  box-shadow: 2px 4px 4px rgba(0, 0, 0, 0.2),
    0px -5px 10px rgba(255, 255, 255, 0.15);
}
.button-box {
  display: flex;
  justify-content: space-around;
  margin-top: 10px;
  margin-bottom: 40px;
}

#bring {
font-style: oblique;
padding-left: 15px;
padding-bottom: 10px;
padding-top: 10px;
font-size: 20px;
}
#invite {
font-style: oblique;
padding-right: 15px;
padding-bottom: 10px;
padding-top: 10px;
font-size: 20px;
}
</style>