<template>
  <div>
   <table>
       <thead>
      <tr class="table-headers">
        <th class="table-header">Dish name</th>
        <th class="table-header">Serving Size</th>
        <th class="table-header">Contributor</th>
        <th class="table-header">Recipe</th>
      </tr>
       </thead>
     <tbody
         v-for="currentDish in selectedDishes" v-bind:key="currentDish.dish_id">
             <tr class="dish-details">
          
          <td class="dish-item">{{currentDish.dish_name}} </td>
          <td class="dish-item">{{currentDish.servings}} </td>
        
          <td class="dish-item">{{currentDish.firstname}} {{currentDish.lastname}}</td>
            <td class="dish-item">{{currentDish.recipe}} </td>

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
table, th, td {

  border: 1px solid black;
  text-align: center;
}
table {
  width: 100%;
}

th {
  
  height: 50px;
 
}
td {
  width: 25%;
}

</style>