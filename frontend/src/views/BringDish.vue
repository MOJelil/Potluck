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
  <input type="text"/>

 <!-- <div>Category</div>
  <input type="text"/>  -->
  <div>Category</div>
  <select v-model="selected">
  <option disabled value="">Please select category</option>
  <option>Appetizer</option>
  <option>Entree</option>
  <option>Side Dish</option>
  <option>Desserth</option>
  <option>Non-Alcoholic Beverage</option>
  <option>Alcoholic Beverage</option>
</select>

  <div>Number of Servings</div>
  <input type="text"/>

  <div>Compatible Dietary Restrictions</div>
  <input type="text"/>

  <div>Recipe (Optional)</div>
  <input type="text"/>
  </div>

<div class="button-position">
          <button
            type="submit"
            class="gradient-button gradient-button-color"
          >Create</button>
        </div>

</div>
</template>

<script>
export default {
  data() {
    return {
      selected: "",
    }
  }
   
};
</script>

<style>
</style>