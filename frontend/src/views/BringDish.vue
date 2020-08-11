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

    <div class="slider-labels">Number of Servings</div>
    <input class="sliders" type="range" min="0" max="39" step="1" v-model="dish.servings" />
    <input type="number" v-model="dish.servings" class="field" id="field" />

    <div>Dietary Restrictions [Select all that apply]</div>
    <div v-for="dietRestriction in allDietaryRestrictions" :key="dietRestriction">
      <input type="checkbox" v-model="dish.diet" :value="dietRestriction" />
      <label>{{ dietRestriction }}</label>
    </div>
    <br />
    <div>Recipe (Optional)</div>
    <input v-model="dish.recipe" type="textarea" />
    <br />
    <input type="file" />
  </div>

  <div class="button-position">
    <button
      type="submit"
      class="gradient-button gradient-button-color"
      v-on:click="bringDish"
    >Create</button>
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
        potluck_id: this.$route.params.id,
        recipe: "",
        diet: [],
      },
      allDietaryRestrictions: [
        "Vegan",
        "Vegetarian",
        "Lactose Intolerant",
        "Nut Allergy",
        "Gluten Allergy",
        "Halal",
        "Kosher",
        "Shellfish Allergy",
      ],
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
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