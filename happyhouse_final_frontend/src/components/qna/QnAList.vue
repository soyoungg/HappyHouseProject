<template>
  <div class="board-list-div">
      <table class="board-table">
          <thead>
              <th>글 번호</th>
              <th>글 제목</th>
              <th>글 작성자</th>
              <th>일시</th>
          </thead>
          <tbody>
              <qna-list-row v-for="(item, index) in qnalist"
              :key="`${index}`"
              v-bind="item"
              :qna="item"/> 
          </tbody>
      </table>
  </div>
</template>

<script>
import QnaListRow from "@/components/qna/QnAListRow"
import {mapGetters} from "vuex";
export default {
    name:"BoardList",
    data:function() {
        return{
            items:[]
        }
    },
    components: {
        QnaListRow
    },
    computed: {
      ...mapGetters(["qnalist"])
    },
    created() {
      this.$store.dispatch("getQnAList");
    }
}
</script>

<style lang="scss" scoped>
// $pink:#f3c2db;
// table{
//     width:800px;
//     margin:auto;
//     border-collapse: collapse;
// 	overflow: hidden;
// 	box-shadow: 0 0 20px rgba(0,0,0,0.2);
//   }
// #app {
//     margin-top:10px;
//     position: absolute;
// 	top: 50%;
// 	left: 50%;
// 	transform: translate(-50%, -50%);
// }
// th {
// 	padding: 15px;
// 	background-color: rgba($pink,0.2);
// 	color: #fff;
// }
// thead th {
// 	background-color:$pink; 
//     // #55608f;
// }
</style>