<template>
  <div>
    <div>
      <!-- graph, sentence-->
      <!-- <h2>graph</h2> -->
      <div id="graph"></div>
      <div id="content">
        <span>
          <!-- 고객님과 같은 user. -->
        </span>
      </div>
    </div>
    <div class="dashboard-list">
      <user-dashboard-list/>
    </div>
  </div>
</template>

<script>
import UserDashboardList from "@/components/dashboard/UserDashboardList"
// import { mapGetters } from 'vuex'
export default {
    name:"userDashBoard",
    components: {
        UserDashboardList
    },
    data: function() {
      return{

      }
    },

}
</script>

<style>

</style>