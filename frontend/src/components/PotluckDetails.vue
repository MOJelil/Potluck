<template>
  <div class="potluck-details">
    <h1>{{ this.$store.state.potluck.name }}</h1>
    <h1>{{ this.$store.state.potluck.location }}</h1>
    <h1>{{ this.$store.state.potluck.description }}</h1>
    <h1>{{ this.$store.state.potluck.guests }}</h1>
    <h1>{{ this.$store.state.potluck.appetizers }}</h1>
    <h1>{{ this.$store.state.potluck.entrees }}</h1>
    <h1>{{ this.$store.state.potluck.side_dishes }}</h1>
    <h1>{{ this.$store.state.potluck.desserts }}</h1>
    <h1>{{ this.$store.state.potluck.non_alcohol }}</h1>
    <h1>{{ this.$store.state.potluck.alcohol }}</h1>

    
    <!-- <router-link
      :to="{ name: 'AddMessage', params: {topicId: $store.state.activePotluck.potluck_id} }"
      class="addMessage"
    >Add New Message</router-link>
    <div
      v-for="message in this.$store.state.activeTopic.messages"
      v-bind:key="message.id"
      class="topic-message bubble"
    >
      <h3 class="message-title">{{ message.title }}</h3>
      <p class="message-body">{{ message.messageText }}</p>
      <router-link
        :to="{name: 'EditMessage', params: {topicId: $store.state.activeTopic.id, messageId: message.id} }"
        tag="button"
        class="btnEditMessage"
      >Edit</router-link>
      <button class="btnDeleteMessage" v-on:click="deleteMessage(message.id)">Delete</button>
    </div> -->
  </div>
</template>

<script>
import potluck from "@/services/Potluck.js";

export default {
  name: "topic-details",
  props: {
    potluck_id: Number
  },
  created() {
    potluck
      .getPotluck(this.potluck_id)
      .then(response => {
        this.$store.commit("SET_ACTIVE_POTLUCK", response.data);
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