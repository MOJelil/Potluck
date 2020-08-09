<template class="home">
  <div>
  <div class="nav-box">
      <head>
  <meta name="viewport" content="width=device-width">
</head>
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

     <div class="page-name">
      <header class="head">Home</header>
    </div>
    <div class="potluck-user-flexbox">
    <div class="user-details-box">
      <div class="user-details-container">
        <h2>My Profile</h2>
      </div>
    </div>
    <div class="potluck-details-box">
      <div class="potluck-details-container">
        <span class="potlucks">
          <div>
            <h2>My Potlucks</h2>
          </div>
          <div
            v-for="currentPotluck in allPotlucks"
            v-bind:key="currentPotluck.name"
            v-bind:potluck="currentPotluck"
          >
            <router-link
              v-bind:to="{ name: 'potluck-detail', params: { potluck_id: currentPotluck.potluck_id } }"
            >{{ currentPotluck.name }}</router-link>
          </div>
        </span>
      </div>
    </div>
  </div>
</div>
</template>


<script>

import Potluck from "@/services/Potluck";

export default {
  name: "home",
  data() {
    return {
      allPotlucks: []
    }
  },
  created() {
    Potluck.list().then(response => this.allPotlucks = response.data);
  }
};
</script>
<style scoped>
body {
  background: url("../images/wooden-bg.jpg") no-repeat center fixed !important;
  background-size: cover;
  font-family: "Ubuntu", Gadget, sans-serif;
  margin: 0;
}

h2 {
   color: dimgray;
  text-shadow: 2px 4px 4px rgba(0,0,0,0.2),
                 0px -5px 10px rgba(255,255,255,0.15);
}

.page-name {
   position: absolute;
  left: 25px;
  top: 25px;
}
.decor {
  background:#d2b48c;
  background: -webkit-linear-gradient(left, #f6e3bd 50%,#d2b48c 50%);
  background: -moz-linear-gradient(left, #f6e3bd 50%, #d2b48c 50%);
  background: -o-linear-gradient(left, #f6e3bd 50%, #d2b48c 50%);
  background: linear-gradient(left, white 50%, #d2b48c 50%);
  background-size: 50px 25%;
  box-shadow: 2px 2px 3px rgba(245, 245, 245, 0.788);
  padding: 2px;
  display: block;
}
.potluck-user-flexbox {
  display: flex;
  justify-content: space-evenly;
}
.potluck-details-container {
  display: flex;
  justify-content: space-around;
  align-content: center;
  background-color: rgba(245, 245, 245, 0.575);
  padding-top: 5px;
  width: 400px;
  height: 715px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
 
}

.potluck-details-box {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
  margin-right: 25px;
  margin-bottom: 50px;
}
.user-details-container {
  display: flex;
  justify-content: space-around;
  background-color: rgba(245, 245, 245, 0.575);
  padding-top: 5px;
  width: 400px;
  height: 715px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
 
}

.user-details-box {
  display: flex;
  justify-content: flex-start;
  margin-top: 20px;
  margin-right: 25px;
  margin-bottom: 50px;
}
</style>
