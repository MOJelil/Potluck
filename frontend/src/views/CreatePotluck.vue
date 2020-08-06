<template>
  <div>
    <div class="page-name">
      <header>Create Potluck</header>
    </div>

    <div class="potluck-box">
      <div class="potluck-container">
        <form class="form-create" @submit.prevent="register">
          <div class="host-name">
            <h1>{{ $store.state.user.firstName }}'s Potluck</h1>
          </div>
          <div>Potluck Name</div>
          <input v-model="potluck.name" placeholder="Potluck Name" />

          <!--<div v-model="{{ $store.state.user.username }}"></div>-->

          <div>Location</div>
          <input v-model="potluck.location" placeholder="Location" />

          <div>Date</div>
          <vuejs-datepicker></vuejs-datepicker>
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
import authService from "../services/AuthService";
//import Datepicker from 'vuejs-datepicker';
export default {
  name: "createPotluck",
  components: {
    //Datepicker
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
      }
    }
  },
  methods: {
    createPotluck(){
    authService
        .createPotluck(this.potluck)
        .then((response) => {
          if (response.status == 201) {
            //this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          
          }else {
            console.log("failed to store data");
          }
        
         })
    }
  }
    
  }   
</script>



<style>
.page-name {
  display: flex;
  justify-content: flex-end;

  font-size: 45px;
  margin-right: 25px;
}
.host-name {
  display: flex;
  justify-content: flex-end;
  margin-left: auto;
  margin-top: 5px;
  font-size: 15px;
  margin-right: 25px;
}
.potluck-container {
  display: flex;
  justify-content: space-around;
  background-color: rgba(245, 245, 245, 0.575);
  padding-right: 40px;
  padding-left: 40px;
  padding-top: 5px;
  width: 250px;
  height: 740px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
  text-align: right;
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
  width: 80%;
  border: 2px solid #ccc;
  border-radius: 7px;
  height: 70px;
  font-family: Verdana, Helvetica, sans-serif;
  padding: 5px;
}

::-webkit-input-placeholder {
  text-align: right;
}
   
</style>