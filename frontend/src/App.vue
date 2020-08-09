<template>
  <div id="app" class="links">
   
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    
    <router-view />
   
  </div>
  
</template>

<<<<<<< Updated upstream
<style>
=======

<style scoped>
>>>>>>> Stashed changes
/* .links {
  display: flex;
  justify-content: flex-end;
} */

a:link {
  
  color: black;
  text-decoration: none;
  text-align: center;
  margin-top: 10px;
}
a:visited {
  color: black;
  text-decoration: none;
}
a:hover {
  color: black;
  text-decoration: none;
  background:white;
  border-radius: 5px;
  padding: 5px;
  box-shadow: 0px 5px 15px 1px rgba(0, 0, 0, 0.14);
}
a:active {
  font-weight: bold;
}
.head {
  font-weight: bold;
}

</style>