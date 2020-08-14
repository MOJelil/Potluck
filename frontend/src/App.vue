<template>
  <div id="app" class="links">
  
    
    <router-view />
  
  </div>
  
</template>


<style>

a:link {
  
  color: black;
  text-decoration: none;
  text-align: center;
  margin-top: 10px;
}
 a:visited {
  color: black;
  text-decoration: none;
  font-weight: bold;
}
a:hover {
  color: black;
  text-decoration: none;
  background:white;
  border-radius: 5px;
  padding: 5px;
  box-shadow: 0px 5px 15px 1px rgba(0, 0, 0, 0.14);
  font-weight: bold;
}

.target {
   color: black;
  text-decoration: none;
  background:white;
  border-radius: 5px;
  padding: 5px;
  box-shadow: 0px 5px 15px 1px rgba(0, 0, 0, 0.14);
  font-weight: bold;
}


.head {
  font-weight: bold;
}

</style>