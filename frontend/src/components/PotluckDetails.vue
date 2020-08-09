<template>
  <div class="details">
    <!-- <div v-for="currentPotluck in allPotlucks" v-bind:key="currentPotluck.name" v-bind:potluck="currentPotluck">
   <p>{{ currentPotluck.name }}</p>
   <p>{{currentPotluck.location}}</p>
    </div>
    -->
  </div>     
</template>

<script>
import Potluck from "@/services/Potluck.js";

export default {
  name: "potluck-details",
   data() {
    return {
     allPotlucks: []
    }
  },
  methods: {
  
    deletePotluck() {
      Potluck.delete().then((response) => {
        if (response.status ==  200) {
          this.delete();
        }
      });
    },
  },

  created() {
    Potluck.list().then(response => this.allPotlucks = response.data);
  },
};
</script>

<style>

</style>
