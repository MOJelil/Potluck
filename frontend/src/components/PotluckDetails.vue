<template>
<div class="potluck-details">
<h1>{{ potluck.name }}</h1>
<h1>Location: {{ potluck.location }}</h1>
<h1>Date: {{potluck.date_created }}</h1>
<h1>Time: {{ potluck.potluck_time }}</h1>
<h1>Decription: {{potluck.description }}</h1>
<h1>Guests({{ potluck.guests }}):</h1>
<h1>Appetizers({{ potluck.appetizers }}):</h1>
<h1>Entrees({{ potluck.entrees }}):</h1>
<h1>Side Dishes({{ potluck.side_dishes }}):</h1>
<h1>Desserts({{ potluck.desserts }}):</h1>
<h1>Beverages({{ potluck.non_alcohol }}):</h1>
<h1>Alcohol({{ potluck.alcohol }}):</h1>
</div>
</template>

<script>

export default {
name: "topic-details",
props: {
potluck: Object,
},

};
</script>

<style>
</style>