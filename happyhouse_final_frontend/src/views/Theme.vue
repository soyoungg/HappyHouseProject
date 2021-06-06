<template>
  <div>
      <div id="healthy-div">
          <div id="healthy-div-title">
            <h2></h2>
            <button type="button" @click="movePage('/healthy')">건강한 라이프를 유지할 수 있는 곳~~!<br><br>알아보러 가기</button>
          </div>
      </div>
      <div id="tasty-div">
          <h2></h2>
          <button type="button" @click="movePage('/tasty')">블루리본 선정 맛집 가장 많은 지역<br><br> 알아보러 가기</button>
          <!-- <router-link tag="a" to="/tasty">알아보러 가기</router-link> -->
      </div>
      <!-- <router-view/> -->
  </div>
</template>

<script>
export default {
    name:"theme",
    data: function() {
        return {};
    },
    methods: {
        movePage(link) {
            this.$router.push(link);
        }
    }

}
</script>

<style >
#healthy-div {
    background-image: url("../assets/healthy.jpg");
    height:500px;
    margin-top:0px;
}
#healthy-div h2, #tasty-div h2 {
    color:white;
    margin:auto;
    line-height:300px;
    font-size:30px;
}
#healthy-div-title button, #tasty-div button {
    margin:auto;
    background-color: rgba(0, 0, 0, 0.3);
    color:rgb(255, 255, 255);
    padding:30px;
    border-style:dotted;;
    font-size: 30px;
    width:100%;
    height:500px;
}
#tasty-div {
    background-image: url("../assets/tasty.jpg");
    height:500px;
    margin-top:0px;
}
</style>