<template>
    <div class="board-list-div">

        <div id="healthymap">
        <GmapMap
      ref="mapRef"
      :center="center"
      :zoom="12"
      style="width:800px; height:500px"
      name="locMap">
      <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
      />
      </GmapMap>
      </div>
      <div>
        <table class="board-table">
            <thead> 
                <th>공원 이름</th>
                <th>공원 주소</th>
            </thead>
            <tbody>
                <healthy-areas-list-row v-for="(item, index) in healthyAreasList"
                :key="`${index}`"
                v-bind="item"
                :healtyAreasList="item"/>
            </tbody>
        </table>
      </div>
    </div> 
</template>
<script>
// import HealthyAreasListRow from "@/components/theme/HealtyAreasListRow"
import { mapGetters} from "vuex";
import take from "lodash/take";

import HealthyAreasListRow from './HealthyAreasListRow.vue';
export default {
    name:"healthyarealistview", 
    data: function(){
        return {
            center: {
                lat: 37.500131499999995,
                lng: 127.03242579999998,
            },
            markers:[],
            items:[],
        }
    },
    components : {
        HealthyAreasListRow
    },
    computed:{
        ...mapGetters(["healthyAreasList"]),
        data(){
            return this.$store.state.healthyAreasList;
        }
    },
    created() {
        this.$store.dispatch("getHealthyAreasList", `/${this.$route.query.addr}`);
    },

  watch: {
      data() {
          // 집 마커 추가
      this.clearMarkers();
      if (this.data.length > 0) {
          this.setCenter({
            lat: parseFloat(this.data[0].latitude),
            lng: parseFloat(this.data[0].longtitude),
        });
        take(this.data, this.data.length).map(({latitude, longtitude }) => {
            var mar = {
                position: {
                    lat: parseFloat(latitude),
                    lng: parseFloat(longtitude),
            },
          };
          this.markers.push(mar);
        });
      }
    },
  },
    methods: {
    clearMarkers() {
        this.markers = [];
    },
    setCenter(position) {
        this.center = position;
        this.zoom = 12;
    },
},
};
</script>

<style scoped lang="scss" >
$pink:#f3c2db;
$black:black;
.board-table{
    width:800px;
    margin:auto;
    border-collapse: collapse;
   overflow: hidden;
   box-shadow: 0 0 20px rgba(0,0,0,0.1);
   
   margin-top:10px;
  }
.board-list-div {
    margin-top:10px;
    // position: absolute;
   // top: 50%;
   // left: 50%;
   // transform: translate(-50%, -50%);
   text-align: center;
}
.board-table th {
   padding: 15px;
   background-color: rgba($pink,0.2);
   color: #fff;
}
.board-table td {
   padding: 15px;
   background-color: rgba($black,0.05);
   color: black;
   
  position: relative;
      &:hover {
         &:before {
            content: "";
            position: absolute;
            left: 0;
            right: 0;
            top: -9999px;
            bottom: -9999px;
            // background-color: rgba($black,0.3);
            z-index: -1;
         }
      }
}
.board-table thead th {
   background-color:$pink; 
    // #55608f;
}
#healthymap {
    width:800px;
    height:500px;
    text-align:center;
    margin:auto;
}

</style>