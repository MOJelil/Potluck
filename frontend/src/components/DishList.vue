<template>
  <div>
              <tr>
            <td>Name of Dish:  </td>
            <td>Serving Size:  </td>
            <td>Recipe: </td>
            <td>Name of contributor: </td>
            </tr>
           <div v-for="currentDish in selectedDishes"
            v-bind:key="currentDish.dish_id">
            <table>
                <thead>
           
            
             
            <tr>
            <td>{{currentDish.dish_name}} </td>
            <td>{{currentDish.servings}} </td>
            <td>{{currentDish.recipe}}</td>
            <td>{{currentDish.firstname}} {{currentDish.lastname}}</td>
            </tr>
                </thead>
            </table>
        </div>
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
        return this.allDishes.filter(dish => dish.category === this.selectedCategory);
    }
}
}
</script>

<style>

</style>