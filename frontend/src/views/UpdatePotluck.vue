<template>
  <div>
    <h1>Update Potluck</h1>
    <edit-potluck v-bind:potluck_id="parseInt($route.params.potluck_id)" />
  </div>
</template>

<script>
import EditPotluck from "@/components/EditPotluck";

export default {
  components: {
    EditPotluck
  }
};
</script>

<style>
</style>
