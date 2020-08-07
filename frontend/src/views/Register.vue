<template>
  <div class="register-box">
    <div class="register-container">
      <div id="register" class="text-center">
        <form class="form-register" @submit.prevent="register">
          <h1 class="box-heading">Create Account</h1>
          <div
            class="alert alert-danger"
            role="alert"
            v-if="registrationErrors"
          >{{ registrationErrorMsg }}</div>

          <label for="firstName" class="sr-only">First Name</label>
          <input
            type="text"
            id="firstName"
            class="form-control"
            placeholder="First Name"
            v-model="user.firstName"
            required
          />

          <label for="lastName" class="sr-only">Last Name</label>
          <input
            type="text"
            id="lastName"
            class="form-control"
            placeholder="Last Name"
            v-model="user.lastName"
            required
          />

          <label for="phone" class="sr-only">Phone Number</label>
          <input
            type="text"
            id="phone"
            class="form-control"
            placeholder="Phone Number"
            v-model="user.phone"
          />

          <label for="email">Email</label>
          <input
            type="text"
            id="email"
            class="form-control"
            placeholder="Email"
            v-model="user.email"
            required
          />

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

          <label for="confirmPassword" class="sr-only">Confirm Password</label>
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />

          <p>Dietary Restrictions</p>

          <div v-for="dietRestriction in allDietaryRestrictions" :key="dietRestriction">
            <label>{{ dietRestriction }}</label>
            <input type="checkbox" v-model="user.diet" :value="dietRestriction" />
          </div>
          <router-link :to="{ name: 'login' }">Have an account?</router-link>
          <div>
            <button type="submit" class="gradient-button gradient-button-color">Create Account</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        firstName: "",
        lastName: "",
        phone: "",
        email: "",
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
        diet: [],
      },
      allDietaryRestrictions: ["Vegan", "Vegetarian", "Lactose Intolerant", "Nut Allergy", "Gluten Allergy", "Halal", "Kosher", "Shellfish Allergy"],
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>

body {
  background: url("../images/charcuterie_board.jpeg") no-repeat center fixed;
  background-size: cover;
  font-family: "Ubuntu", Gadget, sans-serif;
}
.box-heading {
    color: dimgray;
 text-shadow: 2px 4px 4px rgba(0,0,0,0.2),
                 0px -5px 10px rgba(255,255,255,0.15);
}
.register-container {
  display: flex;
  margin-top: 350px;
  background-color: rgba(245, 245, 245, 0.575);
  justify-content: space-around;
  width: 300px;
  height: 700px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
  padding-bottom: 10px;
}
.register-box {
  display: flex;
  justify-content: flex-end;
  margin-top: -325px;
  margin-right: 40px;
  margin-bottom: 50px;
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
  color: black;
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

.gradient-button-color {
  background-image: linear-gradient(to right, #d2b48c, #f6e3bd);
}
.gradient-button-1:hover {
  background-position: right center;
}

.form-register {
  display: flex;
  flex-direction: column;
  color: black;
  text-align: right;
  padding-bottom: 10px;
}
</style>
