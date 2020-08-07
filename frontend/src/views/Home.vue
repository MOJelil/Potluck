<template>
  <div class="home">
    <nav>
      <ul class="primary">
        <li>
          <router-link to="/potluck">Create Potluck</router-link>
        </li>
        <li>
          <router-link to="/logout">Logout</router-link>
        </li>
      </ul>
    </nav>

    <h1>Home</h1>
    <div>
      <potluck-details />
    </div>
    
    <div v-for="currentPotluck in allPotlucks" v-bind:key="currentPotluck.name" v-bind:potluck="currentPotluck">
      <router-link v-bind:to="{ name: 'Potluck', params: { id: currentPotluck.id } }">
        {{ currentPotluck.name }}
      </router-link>     
    </div>

    


    <p>You must be authenticated to see this.</p>
  </div>
</template>

<script>
import PotluckDetails from "../components/PotluckDetails";
import Potluck from "@/services/Potluck";

export default {
  name: "home",
  components: {
    PotluckDetails,
  },
  data() {
    return {
      allPotlucks: []
    }
  },
  created() {
    Potluck.list().then(response => this.allPotlucks = response.data);
  }
};
</script>
