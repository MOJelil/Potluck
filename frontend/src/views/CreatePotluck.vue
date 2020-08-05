<template>
  <div>
    <h1>Create Potluck</h1>

    <div id="title">
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
      <button type="submit" class="gradient-button gradient-button-color">Continue</button>
    </div>
  </div>
</template>

<script>
export default {
  components: {},
};
</script>

<style>
textarea {
  resize: none;
  width: 25%;
  border: 2px solid #ccc;
  border-radius: 7px;
  height: 70px;
  font-family: Verdana, Helvetica, sans-serif;
  padding: 5px;
}
</style>