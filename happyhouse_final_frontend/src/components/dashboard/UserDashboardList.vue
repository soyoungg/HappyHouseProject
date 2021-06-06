<template>
  <div>
    <h2>나의 즐겨찾기 목록</h2>
    <span>내가 즐겨찾기 한 집의 가격 변동 지표를 확인하실 수 있습니다.</span>
    <user-dashboard-list-item v-for="(item, index) in favorite"
    :key="index"
    :house="item"/>
  </div>
</template>

<script>
import UserDashboardListItem from './UserDashboardListItem.vue'
import {mapGetters} from "vuex";
export default {
  components: { UserDashboardListItem },
  computed: {
     ...mapGetters(["favorite"])
  },
  created() {
    // this.$store.dispatch("getPriceChange");
    this.$store.dispatch("getFavoriteList");
    // ...mapGetters(["getFavoriteList"])
    
  }
}
</script>

<style scoped>
h2 {
  font-weight:bold;
}
</style>