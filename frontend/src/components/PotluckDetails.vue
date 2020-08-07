<template>
  <div class="details">
    <table>
      <thead>
        <tr>
          <th>Potluck</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="potluck in this.$store.state.myPotlucks" v-bind:key="potluck.name">
          <td width="80%">
            <router-link
              v-bind:to="{ name: 'name'}"
            >{{ potluck.name }}</router-link>
          </td>
          <td>
            <router-link :to="{ name: 'username'}">Edit</router-link>
          </td>
          <td>
            <a href="#" v-on:click="deleteTopic(potluck.name)">Delete</a>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import Potluck from "@/services/Potluck.js";

export default {
  name: "potluck-details",

  methods: {
    getPotluck() {
      Potluck.list().then((response) => {
        this.$store.commit(response.data);
           this.$router.push("/");
      });
    },
    deletePotluck(id) {
      Potluck.delete(id).then((response) => {
        if (response.status ==  200) {
          this.getPotluck();
        }
      });
    },
  },

  // created() {
  //   this.myPotlucks = this.$store.state.myPotlucks;
  // },
};
</script>

<style>

</style>
