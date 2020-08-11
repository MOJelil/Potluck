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

  <div>Category</div>
  <input type="text"/>

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
export default {};
</script>

<style>
</style>