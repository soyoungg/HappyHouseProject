<template>
    <div>
        <h1>이름 기반 검색</h1>
        <input type="text" v-model="searchkey" id="nameSearchBar"/>
        <button id="searchButton" @click="search">검색</button>
        <div class="search-content-div">
            <div class="search-map-div">
            <GmapMap
            ref="mapRef"
            :center="center"
            :zoom="16"
            style="width:100%; height:60vh"
            name="search-map">
                <GmapMarker
                :key="index"
                v-for="(m, index) in markers"
                :position="m.position"
                class="googlemap search-map-div"/>
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
                            :housedealobj="item"
                        />
                    </tbody>
                </table>
            </div>
        </div>
    </div>
  
</template>

<script>
import SearchListRow from './SearchListRow.vue'
import {mapGetters} from "vuex";
export default {
    name: "NameSearch",
    components: { SearchListRow },
    data: function() {
        return {
            items: [],
            center: {
                lat:37.500131499999995,
                lng:127.03242579999998,
            },
            markers: [
                {
                    position: {
                        lat:37.500131499999995,
                        lng:127.03242579999998,
                    }
                }
            ],
            searchkey:"",
        };
    },
    created() {
        
    },
    methods: {
        search() {
            console.log("search " , this.searchkey);
            this.$store.dispatch("getHouseDealsByName", this.searchkey);
        }
    },
    computed: {
        //...mapGetters(["housedeals"])
        ...mapGetters(["housedeals"])
        //this.$store.dispatch("getHouseDeals", "길동");
    },
}
</script>

<style>
/* #search-map {
  width:55%;
  height:30%;
  text-align:center;
  margin:10px;
  float:left;
} */
/* .search-resList {
  width:40%;
  float:right;
  margin-top:20px;
} */
th {
}
#nameSearchBar {
    margin:10px;
    width:30%;
    height:30px;
}
#searchButton {
    height:35px;
    width:50px;
}
</style>