<template>
  <div>
   <table>
       <thead>
      <tr>
        <th>Dish name</th>
        <th>Serving Size</th>
        
        <th>Contributor</th>
        <th>Recipe</th>
      </tr>
       </thead>
     <tbody
         v-for="currentDish in selectedDishes" v-bind:key="currentDish.dish_id">
             <tr>
          
          <td>{{currentDish.dish_name}} </td>
          <td>{{currentDish.servings}} </td>
        
          <td>{{currentDish.firstname}} {{currentDish.lastname}}</td>
            <td>{{currentDish.recipe}} </td>

           </tr>
       
     </tbody>
    </table>
  </div>
</template>



<script>
export default {
  props: {
    allDishes: Array,
    selectedCategory: String,
  },
  computed: {
    selectedDishes() {
      return this.allDishes.filter(
        (dish) => dish.category === this.selectedCategory
      );
    },
  },
};
</script>

<style>
</style>