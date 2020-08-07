<template>
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
      <router-link to="/createpotluck">Create Potluck</router-link>
    </li>
    <li>
      <router-link to="/logout">Logout</router-link>
    </li>
  </ul>
</nav>
</div>
      </div>
    <div class="page-name">
      <header class="head">Create Potluck</header>
    </div>
    

    <div class="potluck-box">
      <div class="potluck-container">
        <form class="form-create">
          <div class="host-name">
            <h1>{{ $store.state.user.firstName }}'s Potluck</h1>
          </div>
          <div>Potluck Name</div>
          <input v-model="potluck.name" placeholder="Potluck Name" />

          <div>Location</div>
          <input v-model="potluck.location" placeholder="Location" />

          <div>Date</div>

          <input v-model="potluck.date" placeholder="Date" />

          <div>Time</div>
          <input v-model="potluck.time" placeholder="Time" />

          <div>Description</div>
          <textarea type="text" v-model="potluck.description" placeholder="Description"></textarea>

          <div>Number of Guests</div>
          <input v-model="potluck.guests" placeholder="0" />

          <div>Appetizers</div>
          <input v-model="potluck.appetizers" placeholder="0" />

          <div>Entrees</div>
          <input v-model="potluck.entrees" placeholder="0" />

          <div>Side Dishes</div>
          <input v-model="potluck.side_dishes" placeholder="0" />

          <div>Desserts</div>
          <input v-model="potluck.desserts" placeholder="0" />

          <div>Non-Alcoholic Beverages</div>
          <input v-model="potluck.non_alcohol" placeholder="0" />

          <div>Alcoholic Beverages</div>
          <input v-model="potluck.alcohol" placeholder="0" />

          <div></div>
          <div class="button-position">
            <button
              type="submit"
              v-on:click="createPotluck()"
              class="gradient-button gradient-button-color"
            >Create</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Potluck from "../services/Potluck";


export default {
  name: "createPotluck",
  components: {
 
  },
  data() {
    return {
      potluck: {
        username: "",
        name: "",
        location: "",
        date: "",
        time: "",
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
  methods: {
    createPotluck() {
          Potluck.createPotluck(this.potluck)
              this.$store.commit("SET_POTLUCK", this.potluck)
              this.$router.push("/");
        },
  },
};
</script>



<style>

.page-name {
  display: flex;
  justify-content: flex-end;
  font-size: 45px;
  margin-right: 47px;
}
.host-name {
  display: flex;
  justify-content: center;
  margin-left: auto;
  margin-top: 5px;
  font-size: 15px;
  margin-right: auto;
   color: dimgray;
 text-shadow: 2px 4px 4px rgba(0,0,0,0.2),
                 0px -5px 10px rgba(255,255,255,0.15);
}
.potluck-container {
  display: flex;
  justify-content: space-around;
  background-color: rgba(245, 245, 245, 0.575);
  padding-top: 5px;
  width: 350px;
  height: 715px;
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
.button-position {
  margin-top: 5px;
}
textarea {
  resize: none;
  width: 95%;
  border: 2px solid #ccc;
  border-radius: 7px;
  height: 50px;
  font-family: Verdana, Helvetica, sans-serif;
  padding: 5px;
}

.form-create {
  display: flex;
  flex-direction: column;
  color: black;
  text-align: right;
  padding-bottom: 10px;
  width: 80%;
}

.nav-box {
  display: flex;
  margin-bottom: 10px;
  justify-content: flex-end;
  margin-right: 25px;
  
}
.nav-container {
  margin-top: 10px;
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
ul {
  list-style: none;
  position: relative;
  text-align: left;
}

li {
  display: inline-block;
  font-style: oblique;
  
}

nav {
 
  position: relative;
  background: rgba(245, 245, 245, 0.856);
  background-image: -webkit-linear-gradient(bottom, #2B2B2B 7%, #333333 100%);
  background-image: -moz-linear-gradient(bottom, #2B2B2B 7%, #333333 100%);
  background-image: -o-linear-gradient(bottom, #2B2B2B 7%, #333333 100%);
  background-image: linear-gradient(bottom, #2B2B2B 7%, #333333 100%);
  text-align: center;
  letter-spacing: 1px;
  -webkit-box-shadow: 2px 2px 3px #888;
  -moz-box-shadow: 2px 2px 3px #888;
  box-shadow: 2px 2px 3px #888;
  border-bottom-right-radius: 8px;
  border-bottom-left-radius: 8px;
  margin-top: -7px;
}
ul.primary li a {
  display: block;
  padding-right: 15px;
  padding-left: 15px;
  padding-top: 5px;
  padding-bottom: 12px;
  border-right: 1px solid #3D3D3D;
}

ul.primary li:last-child a {
  border-right: none;
}

.head {
  color: whitesmoke;
  font-weight: bold;
  text-shadow: 2px 3px 5px rgba(0,0,0,0.5);
}


</style>