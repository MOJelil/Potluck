<template>
  <div class="guest-list">
    <!-- <h1>{{ this.$route.potluck.name }}</h1> -->
    <p>Username: {{ users.username }}</p>
    <p>Name {{ users.firstname }}</p>
    <p>Last Name {{ users.lastname }}</p>
    
  </div>
</template>
 

<script>
export default {
  name: "guest-list",
  props: {
    users: Object,
  },
};
</script>

<style>
</style>