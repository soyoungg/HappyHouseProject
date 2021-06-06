<template>
  <div>
    <user-dashboard v-if="type==='user'"/>
    <admin-dashboard v-if="type==='admin'"/>
  </div>
</template>

<script>
import AdminDashboard from '../components/dashboard/AdminDashboard.vue'
import UserDashboard from '../components/dashboard/UserDashboard.vue'
export default {
  name:"dashboard",
  data:function() {
    return {
      type:"user"
    }
  },
  components: {
    UserDashboard,
    AdminDashboard,
  }
}
</script>

<style>

</style>
UserDashboardList