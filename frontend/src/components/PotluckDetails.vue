<template>
<div>
  <div class="details-container-1">
   <div class="item"> <h2 class="category-1">{{ potluck.name }}</h2> </div>
   <div class="item"> <h3 class="category">Location:</h3> <h4 id="item">{{ potluck.location }}</h4></div>
    <div class="item"><h3 class="category">Date:</h3> <h4 id="item">{{potluck.potluck_date }}</h4></div>
   <div class="item"> <h3 class="category">Time:</h3> <h4 id="item">{{ potluck.potluck_time }}</h4></div>
   <div class="item"> <h3 class="category">Description:</h3> <h4 id="item">{{potluck.description }}</h4></div>
    </div>
    <div class="details-container-2">
    <h3>Guests({{ potluck.guests }}):</h3>
    <h3>Appetizers({{ potluck.appetizers }}):</h3>
    <h3>Entrees({{ potluck.entrees }}):</h3>
    <h3>Side Dishes({{ potluck.side_dishes }}):</h3>
    <h3>Desserts({{ potluck.desserts }}):</h3>
    <h3>Beverages({{ potluck.non_alcohol }}):</h3>
    <h3>Alcohol({{ potluck.alcohol }}):</h3>
  </div>
</div>
</template>

<script>
export default {
  name: "potluck-details",
  props: {
    potluck: Object,
  },
};
</script>

<style>
.item {
  display: flex;
  flex-direction: row;
  margin-bottom: -25px;
}
.category-1 {
  color: black;
  margin-right: 5px;
     text-shadow: 2px 4px 4px rgba(0,0,0,0.2),
                 0px -5px 10px rgba(255,255,255,0.15);
}
.category {
 color: dimgray;
  margin-right: 5px;

}
.details-container-1 {
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
  text-align: left;
  margin-left: 25px;
  margin-bottom: 20px;
   background-color: rgba(245, 245, 245, 0.541);
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
  width: 100%;
  margin-left: 10px;
  margin-top: 15px;
  padding-left: 15px;
  padding-right: 15px;
  padding-bottom: 25px;
 
}
.details-container-2 {
  display: flex;
  justify-content: flex-end;
  flex-direction: column;
  text-align: left;
  padding-top: 5px;
  background-color:rgba(105, 105, 105, 0.425);
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
  width: 100%;
  margin-left: 10px;
  padding-left: 15px;
  padding-right: 15px;
}


</style>