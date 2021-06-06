<template>
  <div id="tasty-rank-div">
    <div>
      <span class="tasty-detail">
      <h3>블루리본 서베이란?</h3><hr><br>

    국제적인 대도시라면 어디나 그 도시를 대표하는 세계적인 맛집 가이드북이 있습니다.<br><br>
    블루리본 서베이는 이러한 가이드북과 어깨를 나란히 하고 있는 우리나라 최초의, 그리고 최고의 맛집 가이드북입니다.
  <br><br>
    2005년 당시 전문적인 음식 평론에 대한 기반도 취약하고 맛에 대한 평가 기준이 아직 모호한 상황에서 시작한 "블루리본 서베이"는 15년이 넘는 시간 동안 축적된 평가를 바탕으로 대한민국의 객관적인 맛집 평가 기준을 만들어 왔습니다. "블루리본 서베이"는 매 해 11월에 가이드북을 발행하고 있습니다.

    "블루리본 서베이"는 국내 최초로 다수의 의견을 수렴하는 서베이 방식을 채택하여 보다 객관적인 데이터를 수집하고 있습니다.

    블루리본 서베이에 수록된 맛집은 모두 방문할 만한 가치가 있다고 판단되는 곳입니다.
    </span>
    </div>
    <br><br>
    <h3 style="font-size:30px;">블루리본 선정 맛집이 가장 많은 지역은?</h3>
    <span class="tasty-detail">지역 클릭 시 상세 정보를 확인하실 수 있습니다.</span>
    <div id="tastylist" >
    <!-- style="float:left; margin:50px;"> -->
      <tasty-theme-list></tasty-theme-list>
    </div>
    <!-- <div id="tastymap" style="float:right; margin:50px;">
      <GmapMap
      ref="mapRef"
      :center="center"
      :zoom="16"
      style="width:500px; height:500px"
      name="locMap"></GmapMap>
    </div> -->
  </div>
</template>

<script>
import TastyThemeList from './TastyThemeList.vue'
export default {
  data: function() {
    return {
      center: {
        lat:37.500131499999995,
        lng:127.03242579999998,
      },
    }
  },
  components: { TastyThemeList },

}
</script>

<style >
  #tastylist {
    text-align:center;
    margin-top:50px;
  },
  #tastymap{
    position:relative;
    display:inline-block;
    width:500px;
  }
  #tasty-rank-div {
    background-image: url("../../assets/blueribbon.jpg");
    height:1000px;
    margin-top:0px;
    padding:50px;
  }
  h3{
    color:white;
  }
  .tasty-detail {
    color:white;
    margin:10px;
    letter-spacing: 2px;
  }
</style>