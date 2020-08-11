<template>

  <form class="form-update" v-on:submit.prevent>
    <div>
       <div>Potluck Name</div>
        <input v-model="potluck.name" class="form-field" />
       

        <div>Location</div>
        <input v-model="potluck.location"  class="form-field" />
        
        <div>Date</div>
        <input type="date" v-model="potluck.potluck_date" class="form-field" id="date"/>


        
        <div>Time</div>
        <input type ="time" v-model="potluck.potluck_time"  class="form-field" />
        

        <div>Description</div>
       
        <textarea cols="50" rows="10" v-model="potluck.description" class="form-field" id="description">
      
        </textarea>
       
        
    

        
<div class="slider-labels"> Number of Guests </div> 
 <input class="guest-slider" type="range" min="0" max="50" step="1" v-model="potluck.guests" /> 
<input type="number" v-model="potluck.guests" class="field" id="field"/>

     

<div class="slider-labels">Appetizers </div>
     <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.appetizers"/> 
     <input type="number" v-model="potluck.appetizers" class="field" id="field" /> 



    <div class="slider-labels">Number of Entrees </div> 
 <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.entrees"/> 
 <input type="number" v-model="potluck.entrees" class="field" id="field"/> 
 



   <div class="slider-labels">Side Dishes </div> 
    <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.side_dishes"/> 
     <input type="number" v-model="potluck.side_dishes" class="field" id="field"/>
    



  <div class="slider-labels"> Desserts </div>
        <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.desserts"/> 
        <input type="number" v-model="potluck.desserts" class="field" id="field"/> 
      



  <div class="slider-labels"> Non-Alcoholic Beverages </div>
       <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.non_alcohol"/> 
       <input type="number" v-model="potluck.non_alcohol" class="field" id="field"/> 



  <div class="slider-labels"> Alcoholic Beverages </div> 
       <input class="sliders" type="range" min="0" max="10" step="1" v-model="potluck.alcohol"/> 
      <input type="number" v-model="potluck.alcohol" class="field" id="field"/>


    <div class="actions">
      <button type="submit" v-on:click.prevent="updatePotluck()"
      class="gradient-button gradient-button-color"
      >Save Changes</button>
    </div>
    </div>
  </form>
      
</template>

<script>
import PotluckService from "../services/Potluck";

export default {
  name: "create-potluck",
  props: ["potluck"],
  data() {
    return {
    }
  },
  methods: {
    updatePotluck() {
      PotluckService.update(this.potluck.potluck_id, this.potluck)
      .then(response => {
        if (response.status == 200) {
          this.$router.push("/");
        }
      })
    }
  },
  created() {

  }
};
</script>

<style>
.form-update {
  display: flex;
  flex-direction: column;
  color: black;
  text-align: left;
  padding-bottom: 10px;
  width: 80%;
  margin-top: 20px;
}

</style>
