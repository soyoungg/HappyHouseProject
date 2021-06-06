<template>
  <div class="app">
      <!-- <router-link to="locSearch">위치 기반 검색</router-link> |
      <router-link to="nameSearch">이름 기반 검색</router-link> -->
      <input type="radio" id="locationSearch" value="location" v-model="searchType"  />
      <div class="locSearch box" @click="changeType('location')"><span>위치</span></div> 
      <input type="radio" id="nameSearch" value="name" v-model="searchType" />
      <div class="nameSearch box" @click="changeType('name')"><span>이름</span></div> 
      
      <location-search v-if="searchType==='location'"/>
      <name-search v-if="searchType==='name'"/>
  </div>
</template>

<script>
import LocationSearch from './LocationSearch.vue'
import NameSearch from './NameSearch.vue'
export default {
  name:"Search",
  data: function(){
    return {
      searchType: "location"
    }
  },
  components: { LocationSearch, NameSearch },
  methods: {
    changeType(type) {
      this.searchType = type;
    }
  }

}
</script>

<style lang="scss" scoped>
  @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Nanum+Gothic+Coding&display=swap');
  .app {
    font-family: "Nanum Gothic Coding", sans-serif;
  }
  html {
  background-color: #1a1a1a;
  overflow: hidden;
}
$white: #fff;
// $green: #007e90;
$selected: #F4978E;


input[type="radio"] {
  display: none;
  &:checked {
    + .box {
      background-color: $selected;
      span {
        color: white;
        transform: translateY(70px);
        &:before {
          transform: translateY(0px);
          opacity: 1;
        }
      }
    }
  }
}
.box {
  width: 100px;
  height: 30px;
  padding: 5px;
  background-color: $white;
  transition: all 250ms ease;
  will-change: transition;
  display: inline-block;
  text-align: center;
  cursor: pointer;
  // position: relative;
  font-weight: 900;
  border-radius: 5px;
  &:active {
    transform: translateY(10px);
  }
  span {
    // position: absolute;
    transform: translate(0, 60px);
    left: 10;
    right: 10;
    transition: all 300ms ease;
    font-size: 1.5em;
    user-select: none;
    color: $selected;
    line-height:30px;
    &:before {
      font-size: 1.2em;
      font-family: FontAwesome;
      display: block;
      transform: translateY(-80px);
      opacity: 0;
      transition: all 300ms ease-in-out;
      font-weight: normal;
      color: white;
    }
  }
}
// .locSearch {
//   span {
//     &:before {
//       // content: "\f121";
//     }
//   }
// }
// .nameSearch {
//   span {
//     &:before {
//       // content: "\f0f4";
//     }
//   }
// }



</style>