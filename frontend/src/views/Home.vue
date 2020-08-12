<template>
<body class="home">
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
  </div>

  <div class="page-name">
    <header class="head">Home</header>
  </div>
 
    <div class="potluck-detail-box">
      <div class="potluck-detail-container">
        <span class="potlucks">
          <div>
            <h2>Upcoming Events</h2>
          </div>
          <div
            v-for="currentPotluck in allPotlucks"
            v-bind:key="currentPotluck.potluck_id"
            v-bind:potluck="currentPotluck">
            <div class="potluck-actions-container">
            <div class="potluck-name">
            <router-link
              v-bind:to="{ name: 'potluck-detail', params: { id: currentPotluck.potluck_id } }"
            >{{ currentPotluck.name }}</router-link>
            </div>
            <div class="edit-button">
            <router-link
              :to="{ name: 'update-potluck', params: {id: currentPotluck.potluck_id} }"
            >Edit</router-link>
            </div>
            <div class="sign-up-button">
              <router-link
                v-bind:to="{ name: 'bring-dish', params: { id: currentPotluck.potluck_id } }"
              >Bring a Dish</router-link> 
            </div>
            <div class="invite-button">
              <router-link
               v-bind:to="{ name: 'invite-guest', params: { id: currentPotluck.potluck_id } }"
              >Invite Guests</router-link>
              </div>
              </div>
          
            
            </div>
        </span>
      </div>
    </div>
</body>
</template>

<script>
import Potluck from "@/services/Potluck";

export default {
  name: "home",
  data() {
    return {
      allPotlucks: [],
    };
  },
  created() {
    Potluck.list().then((response) => (this.allPotlucks = response.data));
  },
};
</script>
<style>

h2 {
  text-align: center;
  color: dimgray;
}
.potluck-detail-container {
  display: flex;
  justify-content: space-around;
  background-color: rgba(245, 245, 245, 0.575);
  padding-top: 5px;
  width: 625px;
  height: 500px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}
.potluck-detail-box {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
  margin-right: 25px;
  margin-bottom: 50px;
}

.potluck-actions-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  background: whitesmoke;
  border-radius: 1em;
  width: 575px;
  margin-bottom: 10px;
  box-shadow: 2px 4px 4px rgba(0, 0, 0, 0.2),
    0px -5px 10px rgba(255, 255, 255, 0.15);
}
 .potluck-name {
 font-weight: bold;
 padding-left: 10px;
 padding-bottom: 7px;
 padding-top: 7px;
}

.edit-button {
 font-style: oblique;
 padding-bottom: 7px;
 padding-top: 7px;
}
.sign-up-button {
font-style: oblique;
padding-bottom: 7px;
padding-top: 7px;
 
}
.invite-button {
font-style: oblique;
padding-right: 10px;
padding-bottom: 7px;
padding-top: 7px;
} 

</style>
