<template>
  <div>
    <div class="page-name">
    <header>Create Potluck</header>
    </div>
    
    <div class="potluck-box">
    <div class="potluck-container">
      <div class="host-name">
      <h1>{{ $store.state.user.firstName }}'s Potluck</h1>
    </div>
    <div>Potluck Name</div>
    <input v-model="message" placeholder="Potluck Name" />
    <div>Location</div>
    <input v-model="message" placeholder="Location" />
    <div>Date</div>
    <input v-model="message" placeholder="Date" />
    <div>Time</div>
    <input v-model="message" placeholder="Time" />
    <div>Description</div>
    <textarea type="text" v-model="comment" placeholder="Description"></textarea>
    <datetime v-model="date"></datetime>
    <div>Number of Guests</div>
    <input v-model="message" placeholder="0" />
    <div>Appetizers</div>
    <input v-model="message" placeholder="0" />
    <div>Entrees</div>
    <input v-model="message" placeholder="0" />
    <div>Side Dishes</div>
    <input v-model="message" placeholder="0" />
    <div>Desserts</div>
    <input v-model="message" placeholder="0" />
    <div>Non-Alcoholic Beverages</div>
    <input v-model="message" placeholder="0" />
    <div>Alcoholic Beverages</div>
    <input v-model="message" placeholder="0" />
    <div>
      </div>
      <div class="button-position">
      <button type="submit" class="gradient-button gradient-button-color">Create</button>
      </div>
    </div>
    </div>
  </div>
</template>

<script>
export default {
  components: {},
};
</script>

<style>


.page-name {
  display: flex;
  justify-content: flex-end;
  
  font-size: 45px;
  margin-right: 25px;
}
.host-name {
  display: flex;
  justify-content: flex-end;
  margin-left: auto; 
  margin-top: 5px;
  font-size: 15px;
  margin-right: 25px;
}
.potluck-container {
  display: flex;
  flex-direction: column;
  align-content: space-between;
  background-color: rgba(245, 245, 245, 0.575);
  padding-right: 40px;
  padding-left: 40px;
  padding-top: 5px;
  width: 250px;
  height: 740px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);  
}
.potluck-box {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
  margin-right: 25px;
  margin-bottom: 50px;
}
.button-position {
  margin-top: 5px;
}
textarea {
  resize: none;
  width: 80%;
  border: 2px solid #ccc;
  border-radius: 7px;
  height: 70px;
  font-family: Verdana, Helvetica, sans-serif;
  padding: 5px;
}


</style>