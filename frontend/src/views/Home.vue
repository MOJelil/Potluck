<template>
  <div class="home">
    <nav>
  <ul class="primary">
    <li>
      <router-link to="/createpotluck">Create Potluck</router-link>
    </li>
    <li>
      <router-link to="/logout">Logout</router-link>
    </li>
  </ul>
</nav>
   
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
