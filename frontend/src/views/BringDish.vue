<template>

  <div>
                

    <div class="nav-box">
 
      <div class="nav-container">
        <span class="decor"></span>
        <nav>
          <ul class="primary">
            <li>
              <router-link  to="/">My Potlucks</router-link>
            </li>
            <li>
              <router-link  to="/potluck">Create Potluck</router-link>
            </li>
            <li>
              <router-link to="/logout">Logout</router-link>
            </li>
          </ul>
        </nav>
      </div>
    </div>
    <div class="page-name-bring-dish">
      <header class="head">Bring a Dish to Share</header>
    </div>

    <div class="bring-dish-box">
      <div class="bring-dish-container">
        <form class="form-bring-dish">
          <div>Name</div>
          <input v-model="dish.dish_name" type="text" class="form-field" />
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

          <div class="slider-labels"  id="top-margin" >Number of Servings</div>
          <input class="sliders" type="range" min="0" max="15" step="1" v-model="dish.servings" />
          <input type="number" min="0" max="15" step="1" v-model="dish.servings" class="field" id="field" />

          <div id="top-margin" >Dietary Restrictions [Select all that apply]</div>
          <div v-for="dietRestriction in allDietaryRestrictions" :key="dietRestriction">
            <input type="checkbox" v-model="dish.diet" :value="dietRestriction" />
            <label>{{ dietRestriction }}</label>
          </div>
          <br />
          <div>Recipe (Optional)</div>
          <input v-model="dish.recipe" type="textarea" />
          <br />
         
          

          <div class="button-position">
            <button
              type="submit"
              class="gradient-button gradient-button-color"
              v-on:click="bringDish"
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
};
</script>

<style>
.page-name-bring-dish {
  display: flex;
  justify-content: flex-end;
  font-size: 45px;
  margin-right: 25px;
}
.bring-dish-box {
  display: flex;
  justify-content: flex-end;
  margin-top: 150px;
  margin-right: 25px;
}
.bring-dish-container {
  display: flex;
  padding-top: 15px;
  margin-top: -120px;
  background-color: rgba(245, 245, 245, 0.575);
  justify-content: space-around;
  width: 350px;
  height: 540px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
  margin-bottom: 25px;
}
.form-bring-dish {
  display: flex;
  flex-direction: column;
  color: black;
  text-align: left;
  padding-bottom: 10px;
  
}
#top-margin {
  margin-top: 10px;
}


</style>