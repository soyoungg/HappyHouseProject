<template>
  <div class="board-view-div">
      <div class="board-view-title">{{notice.notice_title}} 
          <span class="board-view-author">{{notice.notice_author}}</span><hr>
          </div>
      <div class="board-view-date">{{notice.notice_date}}</div><br>
      <div class="board-view-content">
          {{notice.notice_content}}
      </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
    name:"contentview",
    computed: {
        ...mapGetters(["notice"])
    },
    created() {
        this.$store.dispatch("getNotice", `${this.$route.query.no}`);
    }
    
}
</script>

<style lang="scss">
$pink:#f3c2db;
.board-view-div {
    width:60%;
    margin:auto;
    margin-top:50px;
    background:rgba($pink, 0.3);
    border-radius:20px;
    padding:30px;
    box-shadow: 0 0 20px rgba(0,0,0,0.2);
}
.board-view-title {
    font-weight: bold;
    text-align:left;
    font-size:20px;
}
.board-view-author {
    float:right;
}
.board-view-date {
    float:right;
    width:100%;
    text-align:right;
}
.board-view-content {
    text-align: left;
    min-height: 300px;
    margin-bottom:50px;
}
</style>