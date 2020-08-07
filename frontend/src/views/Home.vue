<template>
  <div class="home">
   
    <h1>Home</h1>
     <div>
        <potluck-details/>
     </div>

    <p>You must be authenticated to see this.</p>
  </div>
</template>

<script>

import PotluckDetails from '../components/PotluckDetails';

export default {
  name: 'home',
  components: {
    PotluckDetails
}
}
</script>
