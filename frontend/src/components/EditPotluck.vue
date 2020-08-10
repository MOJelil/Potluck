<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="name">Name</label>
      <input type="text" v-model="name" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click="updateTopic()">Save Changes</button>
    </div>
  </form>
</template>

<script>
import potluck from "../services/Potluck";

export default {
  name: "create-potluck",
  props: ["potluck_id"],
  data() {
    return {
      name: ""
    };
  },
  methods: {
    updateTopic() {
      const potluck = { id: this.potluck_id, name: this.name };
      // call topic service update method
      potluck.updateTopic(potluck.potluck_id, name)
      .then(response => {
        if (response.status == 200) {
          this.$router.push("/");
        }
      })
    }
  },
  created() {
    potluck
      .get(this.potluck_id)
      .then(response => {
        this.$store.commit("SET_ACTIVE_POTLUCK", response.data);
        this.name = response.data.name;
      })
      .catch(error => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
      });
  }
};
</script>

<style>
</style>
