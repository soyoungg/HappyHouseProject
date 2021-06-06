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
              <notice-list-row v-for="(item, index) in noticelist"
              :key="`${index}`"
              v-bind="item"
              :notice="item"/> 
          </tbody>
      </table>
  </div>
</template>

<script>
import NoticeListRow from "@/components/notice/NoticeListRow"
import {mapGetters} from "vuex";
export default {
    name:"NoticeList",
    data: function() {
        return {
            items:[]
        }
    },
    components : {
        NoticeListRow
    },
    computed: {
      ...mapGetters(["noticelist"])
    },
    created() {
      this.$store.dispatch("getNoticeList");
    }
}
</script>

<style lang="scss">
$pink:#f3c2db;
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
.board-table thead th {
	background-color:$pink; 
    // #55608f;
}
</style>