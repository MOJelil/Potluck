<template>
  <div>
    <table>
        <thead>
      <tr>
        <th>Dish name | Serving Size  |  Recipe |   Name of Food Bringer

</th>
        
      </tr>
        </thead>
     <tbody>
        <div v-for="currentDish in selectedDishes" v-bind:key="currentDish.dish_id">
             <tr>
          
          <td>{{currentDish.dish_name}} |</td>
          <td>{{currentDish.servings}} |</td>
          <td>{{currentDish.recipe}} |</td>
          <td>{{currentDish.firstname}} {{currentDish.lastname}}</td>

           </tr>
        </div>
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