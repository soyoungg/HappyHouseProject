<template>
  <div class="search-div">
      <h1>위치 기반 검색</h1>
      <div id="searchBar">
          <select name="city" v-model="city" id="city" @change="makeGuOptions">
              <option >시를 선택하세요.</option>
              <option v-for="(city, index) in cities" :value="city" :key="`${index}`">{{city}}</option>
          </select>
          <select name="gu" id="gu" v-model="gugun" @change="makeDongOptions">
              <option >구를 선택하세요.</option>
              <option v-for="(gugun, index) in guguns" :value="gugun" :key="`${index}`">{{gugun}}</option>
            </select> 
          <select name="dong" v-model="dong" id="dong" @change="search(dong)">
              <option >동을 선택하세요.</option>
              <option v-for="(dong, index) in dongs" :value="dong" :key="`${index}`">{{dong}}</option>
            
            </select>
      </div>
      <div style="width:100%" class="search-content-div">
        <div class="search-map-div" id="locMap">
            <GmapMap
            ref="mapRef"
            :center="center"
            :zoom="16"
            style="width:100%; height:60vh"
            class="googleMap search-map-div"
            name="locMap" id="locMap"
            >
            <GmapMarker
              :key="index"
              v-for="(m, index) in markers"
              :position="m.position"
            />
            </GmapMap>
        </div>
        <div class="search-resList">
          <table class="search-resList-table">
              <thead>
                  <th>매매 번호</th>
                  <th>이름</th>
                  <th>거래 가격</th>
                  <th>거래 일자</th>
                  <th>즐겨찾기</th>
              </thead>
              <tbody>
                  <search-list-row
                    v-for="(item, index) in housedeals"
                    :key="`${index}_items`"
                    :dealno="`${item.no}`"
                    :aptName="`${item.aptName}`"
                    :housedealobj="item"
                  />
              </tbody>
          </table>
        </div>
      </div>
  </div>
</template>

<script>
import take from "lodash/take";
import SearchListRow from './SearchListRow.vue'
import {mapGetters} from "vuex";
import http from "@/util/http-common";
// import {mapState} from "vuex";

export default {
    name: "LocationSearch",
    components: { SearchListRow },
    data: function() {
        return {
             center: {
                lat:37.500131499999995,
                lng:127.03242579999998,
            },
            cities: [],
            markers:[],
            city:"시를 선택하세요",
            guguns: [],
            gugun:"구를 선택하세요.",
            dongs:[],
            dong:"동을 선택하세요",
        };
    },
    computed: {
        //...mapGetters(["housedeals"])
        ...mapGetters(["housedeals"]),
        //this.$store.dispatch("getHouseDeals", "길동");
       data() {
          return this.$store.state.housedeals;
        },
    },
    watch: {
      data(){
        this.clearMarkers();
        if(this.data.length > 0){
          this.setCenter({
            lat: parseFloat(this.data[0].lat),
            lng: parseFloat(this.data[0].lng),
          });
          take(this.data, this.data.length).map(({ aptname, lat, lng }) => {
            var mar = {
              position:{
                lat: parseFloat(lat),
                lng: parseFloat(lng),
              },
              aptname: aptname,
            };
            this.markers.push(mar);
          });
        }
      }
    },
    created() {
        // this.$store.dispatch("getCity", "서울");
        // console.log("HI");
        http
        .post("/apt/city_list", { "city": "서울특별시" }, {
          headers: {
            "access-token": window.localStorage.getItem("access-toekn")
          },
        })
        .then((response) => {
          console.log(response);
          this.cities = response.data;
        })
        .catch(() => {
          alert("시티 생성 에러 발생!");
        })
    },
   
    methods: {
      clearMarkers(){
          this.markers = [];
        },
        setCenter(position){
          this.center = position;
          this.zoom = 18;
        },
        search(_dong) {
            this.$store.dispatch("getHouseDeals", _dong);
        },
        makeGuOptions() {
            http
        .post("/apt/gugun_list", { "city": "서울특별시" })
        .then((response) => {
          console.log(response);
          this.guguns = response.data;
        })
        .catch(() => {
          alert("구,군 생성 에러 발생!");
        })
        },
        makeDongOptions() {
            http
        .post("/apt/dong_list", { "city": "서울특별시", "gugun":this.gugun })
        .then((response) => {
          console.log(response);
          this.dongs = response.data;
        })
        .catch(() => {
          alert("구,군 생성 에러 발생!");
        })
        }
    }
}
</script>

<style lang="scss">
$pink:#f3c2db;
.search-content-div {
  margin:10px;
  width:100%;
}
.search-map-div, .search-map-div GmapMap {
  width:45%;
  height:30%;
  text-align:center;
  margin-left:30px;
  float:left;
}
.search-resList {
  width:45%;
  float:right;
  margin-right:30px;
  text-align:center;
}
select {
  width:20%;
  height:50px;
  margin-left:5px;
  margin-right:5px;
}
#searchBar {
  margin-bottom: 30px;
}
.search-div {

}
.googleMap {

}
.search-resList-table {
  border-collapse: collapse;
  width:100%;
  overflow: scroll;
}
.search-resList-table th {
  padding: 15px;
	background-color: rgba($pink,0.2);
	color: rgb(90, 88, 88);
  font-size:0.7em;
}
</style>