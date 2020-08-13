import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    potluck: { 
      username: "",
      potluck_id: "",
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
    dish: [],
    users: {
      username: "",
      firstname: "",
      lastname: "",
        }
  },

  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_POTLUCK(state, data) {
      state.potluck = data;
    },
    SET_ACTIVE_POTLUCK(state, data) {
      state.potluck = data;
    },
    SET_DISH(state, data) {
      state.dish = data;
    },
    SET_USERS(state, data) {
      state.users = data;
    }
  }
})
