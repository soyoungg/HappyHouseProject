<template>
  <div id="healthy-rank-div">
      <h3 id="healthy-rank-title"> 공원이 많은 동네 랭킹</h3>
      <span>공원이 많으면 건강한 삶을 살 수 있죠~~!<br>클릭 시 상세 정보를 보실 수 있습니다.<br></span>
      <!-- 맛집 많은 순 리스트 뽑기 -->
      <div id="healthylist">
          <theme-list ></theme-list>
      </div>

      <!-- 지도와 상세 맛집 리스트 -->

  </div>
</template>

<script>
import {mapGetters} from "vuex";
import ThemeList from '@/components/theme/HealthyThemeList';
export default {
  components: {  ThemeList },
  name:"healthy",
  created() {
    console.log("healthy theme");
    this.$store.dispatch("getParks");
  },
  computed: {
    ...mapGetters(["parks"])
  },
  data: function() {
    return {
      center: {
        lat:37.500131499999995,
        lng:127.03242579999998,
      },
    }
  },
}
</script>

<style>
  /* #healthymap {
    float:right;
    margin:50px;
  } */
  #healthylist {
    text-align:center;
    /* width:50%; */
    height:1000px;
    margin-top:50px;
  }
  #healthy-rank-div {
    height:1000px;
    margin-top:0px;
    padding:50px;
  }

  #healthy-rank-title {
    font-size:30px;
    color:black;
  }

</style>