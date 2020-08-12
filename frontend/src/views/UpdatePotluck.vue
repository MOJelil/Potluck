<template>
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

      <div class="page-name-update">
    <header class="head">Update Potluck</header>
    </div>
  <div class="potluck-box-update">
      <div class="potluck-container-update">
    <edit-potluck v-bind:potluck="potluckToEdit" />
      </div>
      </div>
  </div>
</template>

<script>
import EditPotluck from "@/components/EditPotluck";
import PotluckService from "@/services/Potluck.js";

export default {
  data() {
    return {
      potluckToEdit: {
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
      }
    }
  },
  components: {
    EditPotluck
  },
  created() {
     PotluckService
      .getPotluck(this.$route.params.id)
      .then((response) => {
       this.potluckToEdit = response.data;
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
      });
  }
};
</script>

<style>

.page-name-update {
  display: flex;
  justify-content: flex-end;
  font-size: 45px;
  margin-right: 40px;
}
.potluck-container-update {
   display: flex;
  justify-content: space-around;
  background-color: rgba(245, 245, 245, 0.575);
  padding-top: 5px;
  width: 350px;
  height: 890px;
  border-radius: 1.5em;
  box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}
.potluck-box-update {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
  margin-right: 25px;
  margin-bottom: 50px;
}

</style>
