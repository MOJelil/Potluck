<template>
  <div class="potlucks">
    <potluck-details v-bind:potluck-id="parseInt($route.params.potluck_id)" />
  </div>
</template>

<script>
import PotluckDetails from "@/components/PotluckDetails.vue";

export default {
  name: "Potlucks",
  components: {
    PotluckDetails
  }
};
</script>
