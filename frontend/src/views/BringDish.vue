<template>
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
  <div>
    <div>Name</div>
    <input v-model="dish.dish_name" type="text" />

    <!-- <div>Category</div>
    <input type="text"/>-->
    <div>Category</div>
    <select v-model="dish.category">
      <option disabled value>Please select category</option>
      <option>Appetizer</option>
      <option>Entree</option>
      <option>Side Dish</option>
      <option>Dessert</option>
      <option>Non-Alcoholic Beverage</option>
      <option>Alcoholic Beverage</option>
    </select>

    <div>Number of Servings</div>
    <input v-model="dish.servings" type="text" />

    <div>Compatible Dietary Restrictions</div>
    <input v-model="dish.dietary_id" type="text" />

    <div>Recipe (Optional)</div>
    <input v-model="dish.recipe" type="text" />
  </div>

  <div class="button-position">
    <button type="submit" class="gradient-button gradient-button-color" v-on:click="bringDish">Create</button>
  </div>
</div>
</template>

<script>
import PotluckService from "../services/Potluck";

export default {
  data() {
    return {
      dish: {
        dish_name: "",
        category: "",
        servings: "",
        dietary_id: "",
        potluck_id: this.$route.params.id,
        recipe: "",
      },
    };
  },
  methods: {
    bringDish() {
      PotluckService.bringDish(this.dish).then(() => {
        this.$store.commit("SET_DISH", this.dish);
        this.$router.push("/potluck/" + this.dish.potluck_id);
      });
    },
  },
}; //comment
</script>

<style>
</style>