<template>
<body class="details">
  <div>
    <div class="nav-box">
      <div class="nav-container">
        <span class="decor"></span>
        <nav>
          <ul class="primary">
            <li>
              <router-link to="/">My Potlucks</router-link>
            </li>
            <li>
              <router-link to="/potluck">Create Potluck</router-link>
            </li>
            <li>
              <router-link to="/logout">Logout</router-link>
            </li>
          </ul>
        </nav>
      </div>
    </div>
    <div class="page-name-details">
      <header class="head">Potluck Details</header>
    </div>
    <div class="detail-box">
      <div class="detail-container">
        <div class="details-container-1">
          <div class="item">
            <h2 class="category-1">{{ displayedPotluck.name }}</h2>
          </div>
          <div class="item">
            <h3 class="category">Location:</h3>
            <h4 id="item">{{ displayedPotluck.location }}</h4>
          </div>
          <div class="item">
            <h3 class="category">Date:</h3>
            <h4 id="item">{{displayedPotluck.potluck_date }}</h4>
          </div>
          <div class="item">
            <h3 class="category">Time:</h3>
            <h4 id="item">{{ displayedPotluck.potluck_time }}</h4>
          </div>
          <div class="item">
            <h3 class="category">Description:</h3>
            <h4 id="item">{{displayedPotluck.description }}</h4>
          </div>
        </div>
        <div class="details-container-2">
          <h3>Guests({{ displayedPotluck.guests }}):</h3>
          <h3>Appetizers({{ displayedPotluck.appetizers }}):</h3>
          <dish-list v-bind:allDishes="dishDetails" selectedCategory="Appetizer" />
          <h3>Entrees({{ displayedPotluck.entrees }}):</h3>
          <dish-list v-bind:allDishes="dishDetails" selectedCategory="Entree" />
          <h3>Side Dishes({{ displayedPotluck.side_dishes }}):</h3>
          <dish-list v-bind:allDishes="dishDetails" selectedCategory="Side Dish" />
          <h3>Desserts({{ displayedPotluck.desserts }}):</h3>
          <dish-list v-bind:allDishes="dishDetails" selectedCategory="Dessert" />
          <h3>Beverages({{ displayedPotluck.non_alcohol }}):</h3>
          <dish-list v-bind:allDishes="dishDetails" selectedCategory="Non-Alcoholic Beverage" />
          <h3>Alcohol({{ displayedPotluck.alcohol }}):</h3>
          <dish-list v-bind:allDishes="dishDetails" selectedCategory="Alcoholic Beverage" />
        </div>
      </div>
    </div>
    <div class="button-box">
      <div class="button-container">
        <div id="bring">
          <router-link
            v-bind:to="{ name: 'bring-dish', params: { id: displayedPotluck.potluck_id } }"
          >Bring a Dish</router-link>
        </div>

        <div id="invite">
          <router-link
            v-bind:to="{ name: 'invite-guest', params: { id: displayedPotluck.potluck_id } }"
          >Invite guests</router-link>
        </div>
      </div>
    </div>
  </div>
</body>
</template>

<script>
import PotluckService from "@/services/Potluck.js";
import DishList from "@/components/DishList.vue";

export default {
  name: "Potlucks",
  data() {
    return {
      displayedPotluck: {
        username: "",
        name: "",
        location: "",
        potluck_date: "",
        potluck_time: "",
        description: "",
        guests: "",
        appetizers: "",
        entrees: "",
        side_dishes: "",
        desserts: "",
        non_alcohol: "",
        alcohol: "",
      },
      dishDetails: [],
    };
  },
  components: {
    DishList,
  },
  created() {
    PotluckService.getPotluck(this.$route.params.id)
      .then((response) => {
        this.displayedPotluck = response.data;
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
      });
    PotluckService.getDish(this.$route.params.id).then(
      (response) => (this.dishDetails = response.data)
    );
  },
};
</script>
<style>
.details {
  background: url("../images/wooden-bg.jpg") no-repeat center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;
}

.detail-container {
  display: flex;
  flex-direction: column;
  /* justify-content: space-evenly; */
  background-color: rgba(245, 245, 245, 0.575);
  padding-top: 5px;
  width: 80%;
  height: 940px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}

.detail-box {
  display: flex;
  justify-content: space-around;
  margin-top: 20px;
  margin-bottom: 50px;
}
.page-name-details {
  display: flex;
  justify-content: flex-start;
  font-size: 45px;
  margin-left: 25px;
  margin-top: -75px;
}
.item {
  display: flex;
  flex-direction: row;
  margin-bottom: -25px;
}
.category-1 {
  color: black;
  margin-right: 5px;
  text-shadow: 2px 4px 4px rgba(0, 0, 0, 0.2),
    0px -5px 10px rgba(255, 255, 255, 0.15);
}
.category {
  color: dimgray;
  margin-right: 5px;
}
.details-container-1 {
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
  text-align: left;
  margin-left: 35px;
  background-color: rgba(245, 245, 245, 0.541);
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
  width: 90%;
  margin-right: 25px;
  margin-top: 15px;
  padding-left: 15px;
  padding-right: 15px;
  padding-bottom: 25px;
  margin-bottom: 50px;
}
.details-container-2 {
  display: flex;
  justify-content: flex-end;
  flex-direction: column;
  text-align: left;
  padding-top: 5px;
  background-color: rgba(105, 105, 105, 0.425);
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
  width: 90%;
  margin-left: 35px;
  margin-right: 25px;
  padding-left: 15px;
  padding-right: 15px;
}

.button-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  background: whitesmoke;
  border-radius: 1em;
  width: 40%;
  box-shadow: 2px 4px 4px rgba(0, 0, 0, 0.2),
    0px -5px 10px rgba(255, 255, 255, 0.15);
}
.button-box {
  display: flex;
  justify-content: space-around;
  margin-top: 10px;
  margin-bottom: 40px;
}

#bring {
  font-style: oblique;
  padding-left: 15px;
  padding-bottom: 10px;
  padding-top: 10px;
  font-size: 20px;
}
#invite {
  font-style: oblique;
  padding-right: 15px;
  padding-bottom: 10px;
  padding-top: 10px;
  font-size: 20px;
}
</style>