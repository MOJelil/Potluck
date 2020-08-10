<template>
<div>
  <div class="nav-box">
    <head>
      <meta name="viewport" content="width=device-width" />
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
    <header class="head">Create Potluck</header>
  </div>

  <div class="potluck-box">
    <div class="potluck-container">
      <form class="form-create">
        <div class="host-name">
          <h2>{{ $store.state.user.firstName }}'s Potluck</h2>
        </div>
        
        <div>Potluck Name</div>
        <input v-model="potluck.name" class="form-field" />
       

        <div>Location</div>
        <input v-model="potluck.location"  class="form-field" />
        
        <div>Date</div>
        <input type="date" v-model="potluck.potluck_date" class="form-field" id="date"/>


        
        <div>Time</div>
        <input type ="text" v-model="potluck.potluck_time"  class="form-field" />
        

        <div>Description</div>
       
        <input type="text" v-model="potluck.description" placeholder=" " class="form-field" id="description"/>
       
        
    

        
<div class="slider-labels"> Number of Guests </div> 
 <input class="guest-slider" type="range" min="0" max="50" step="1" v-model="potluck.guests" /> 
<input type="number" v-model="potluck.guests" class="field" id="field"/>

     

<div class="slider-labels">Appetizers </div>
     <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.appetizers"/> 
     <input type="number" v-model="potluck.appetizers" class="field" id="field" /> 



    <div class="slider-labels">Number of Entrees </div> 
 <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.entrees"/> 
 <input type="number" v-model="potluck.entrees" class="field" id="field"/> 
 



   <div class="slider-labels">Side Dishes </div> 
    <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.side_dishes"/> 
     <input type="number" v-model="potluck.side_dishes" class="field" id="field"/>
    



  <div class="slider-labels"> Desserts </div>
        <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.desserts"/> 
        <input type="number" v-model="potluck.desserts" class="field" id="field"/> 
      



  <div class="slider-labels"> Non-Alcoholic Beverages </div>
       <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.non_alcohol"/> 
       <input type="number" v-model="potluck.non_alcohol" class="field" id="field"/> 



  <div class="slider-labels"> Alcoholic Beverages </div> 
       <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.alcohol"/> 
      <input type="number" v-model="potluck.alcohol" class="field"/>



        
        <div class="button-position">
          <button
            type="submit"
            v-on:click.prevent="createPotluck()"
            class="gradient-button gradient-button-color"
          >Create</button>
        </div>
      </form>
    </div>
  </div>
</div>
</template>

<script>
import PotluckService from "../services/Potluck";


export default {
  name: "createPotluck",
 
  data() {
    return {
      potluck: {
        username: "",
        name: "",
        location: "",
        date_created: "",
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
  methods: {
    createPotluck() {
      PotluckService.createPotluck(this.potluck).then(()  => {
      this.$store.commit("SET_POTLUCK", this.potluck);
       this.$router.push("/");
     
      });

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
  text-shadow: 2px 4px 4px rgba(0, 0, 0, 0.2),
    0px -5px 10px rgba(255, 255, 255, 0.15);
}
.potluck-container {
  display: flex;
  justify-content: space-around;
  background-color: rgba(245, 245, 245, 0.575);
  padding-top: 5px;
  width: 350px;
  height: 920px;
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
.form-field {
  margin-bottom: 5px;
}
#field {
  margin-bottom: 5px;
}
.slider-labels {
  text-align: left;
}
.guest-slider {
  width: 200px;
 
}
.sliders {
  width: 100px;
  
}
.field {
  width: 30px;
}
#description {
 width: 100%;
 padding: 40px;
 box-sizing: border-box;
}
#date {
  width: 98%
  
}

.form-create {
  display: flex;
  flex-direction: column;
  color: black;
  text-align: left;
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
  background: #d2b48c;
  background: -webkit-linear-gradient(left, #f6e3bd 50%, #d2b48c 50%);
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
  background-image: -webkit-linear-gradient(bottom, #2b2b2b 7%, #333333 100%);
  background-image: -moz-linear-gradient(bottom, #2b2b2b 7%, #333333 100%);
  background-image: -o-linear-gradient(bottom, #2b2b2b 7%, #333333 100%);
  background-image: linear-gradient(bottom, #2b2b2b 7%, #333333 100%);
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
  border-right: 1px solid #3d3d3d;
}

ul.primary li:last-child a {
  border-right: none;
}

.head {
  color: whitesmoke;
  font-weight: bold;
  text-shadow: 2px 3px 5px rgba(0, 0, 0, 0.5);
}
/*
input[type=range] {
    -webkit-appearance: none;
    display: block;
    background: #3e3e3f;
    background-image: -webkit-gradient(linear, 20% 0%, 20% 100%, color-stop(0%, #ADD8E6), color-stop(100%, #ADD8E6));
    background-image: -webkit-linear-gradient(left, #ADD8E6 0%,#ADD8E6 100%);
    background-image: -moz-linear-gradient(left, #ADD8E6 0%, #ADD8E6 100%);
    background-image: -o-linear-gradient(to right, #ADD8E6 0%,#ADD8E6 100%);
    background-image: linear-gradient(to right, #ADD8E6 0%,#ADD8E6 100%);
    background-repeat: no-repeat;
}
 
input[type=range]:focus {
  outline: none;
}
input[type=range]::-webkit-slider-runnable-track {
  width: 100%;
  height: 4px;
  cursor: pointer;
  box-shadow: none;
  background: transparent;
  border-radius: 0px;
  border: none;
}
input[type=range]::-webkit-slider-thumb {
  box-shadow: none;
  border: 4px solid #ADD8E6;
  height: 16px;
  width: 16px;
  border-radius: 2px;
  background: #3e3e3f;
  cursor: pointer;
  -webkit-appearance: none;
  margin-top: -6px;
}
input[type=range]:focus::-webkit-slider-runnable-track {
  background: transparent;
}
input[type=range]::-moz-range-track {
  width: 100%;
  height: 4px;
  cursor: pointer;
  box-shadow: none;
  background: transparent;
  border-radius: 0px;
  border: none;
}
input[type=range]::-moz-range-thumb {
  box-shadow: none;
  border: 4px solid #ADD8E6;
  height: 16px;
  width: 16px;
  border-radius: 2px;
  background: #ffffff;
  cursor: pointer;
}
input[type=range]::-ms-track {
  width: 100%;
  height: 4px;
  cursor: pointer;
  background: transparent;
  border-color: transparent;
  color: transparent;
}
input[type=range]::-ms-fill-lower {
  background: transparent;
  border: none;
  border-radius: 0px;
  box-shadow: none;
}
input[type=range]::-ms-fill-upper {
  background: transparent;
  border: none;
  border-radius: 0px;
  box-shadow: none;
}
input[type=range]::-ms-thumb {
  box-shadow: none;
  border: 4px solid #ADD8E6;
  height: 16px;
  width: 16px;
  border-radius: 2px;
  background: #ffffff;
  cursor: pointer;
  height: 4px;
}
input[type=range]:focus::-ms-fill-lower {
  background: transparent;
}
input[type=range]:focus::-ms-fill-upper {
  background: transparent;
} */
</style>