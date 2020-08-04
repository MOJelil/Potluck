<template>
 <!-- <div class="loading" v-if="isLoading">
        <img src="../images/loading.gif" />
 </div>
      <div v-else> -->
<div class="login-container">
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <div>
        <button type="submit" class="gradient-button gradient-button-1">Continue</button>
      </div>
    </form>
    </div>
  </div>
 <!-- </div> -->
 
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      isLoading: true,
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
         
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>
body {
  background: url("../images/charcuterie_board.jpeg") no-repeat center fixed;
  background-size: cover;
        
}
.login-container {
  position: fixed;
  bottom: 0;
  right: 0;
  display: flex;
  margin: auto;
  background-color: none;;
  justify-content: space-around;
  width: 300px;
  height: 300px;
  /* border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);  */
  
 
  
}

.gradient-button {
  margin: 20px auto;
  font-family: "Ubuntu", Gadget, sans-serif;
  font-size: 20px;
  padding: 15px;
  text-align: center;
  text-transform: uppercase;
  transition: 0.5s;
  background-size: 200% auto;
  color: #fff;
  box-shadow: 0 0 20px #eee;
  border-radius: 10px;
  border-color: #ffffff;
  width: 200px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
  cursor: pointer;
  display: block;
  border-radius: 25px;
}
.gradient-button:hover {
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.23);
  margin: 0 auto;
}

.gradient-button-1 {
  background-image: 
  linear-gradient(to right, #53868B, #67E6EC);
 
}
.gradient-button-1:hover {
  background-position: right center;
}

.form-signin {
  display:flex;
  flex-direction: column;
  align-content: left;
  color: black;
  text-align: right;
  
  
}
</style>