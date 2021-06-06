<template>
    <div class="board-list-div">
         <table class="board-table">
            <thead> 
                <th>레스토랑 이름</th>
                <th>레스토랑 타입</th>
                <th>레스토랑 주소</th>
            </thead>
            <tbody>
                <tasty-areas-list-row v-for="(item, index) in tastyAreasList"
                :key="`${index}`"
                v-bind="item"
                :tastyAreasList="item"/>
            </tbody>
        </table>
        </div>

</template>
<script>
import { mapGetters} from "vuex";
import TastyAreasListRow from './TastyAreasListRow.vue';
export default {
  components: { TastyAreasListRow },
    name:"tastyThemeview", 
    computed: {
        ...mapGetters(["tastyAreasList"])
    }, 
    created(){
        this.$store.dispatch("getTastyAreasList", `/${this.$route.query.addr}`);
    }
}

</script>

<style scpoed lang="scss">
$pink:#faccf8;
$black:black;
.board-table{
    width:800px;
    margin:auto;
    border-collapse: collapse;
   overflow: hidden;
   box-shadow: 0 0 20px rgba(0,0,0,0.1);
  }
.board-list-div {
    margin-top:10px;
    // position: absolute;
   // top: 50%;
   // left: 50%;
   // transform: translate(-50%, -50%);
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
</style>