<template>
  <div>
      <h1>공지사항</h1>
      <div class="board-content">
        <div class ="board-write-button">
          <button @click="movePage" >글쓰기</button>
        </div>
        <div class="board-list">
          <notice-list/> 
        </div>
      </div>
  </div>
</template>

<script>
import NoticeList from "@/components/notice/NoticeList"
export default {
    components: {
        NoticeList
    },
    methods: {
    movePage: function() {
      this.$router.push("/qnawrite");
    },
    
  }
}
</script>

<style>
.board-write-button {
  float:right;
  margin-bottom: 20px;
  width:80%;
  margin-right:150px;
}
.board-write-button button {
  background-color:#faccf8;
  border:none;
  padding:10px;
  border-radius:10px;
  width:80px;
  height:50px;
  font-size: 18px;
  cursor:pointer;
  float:right;
}
.board-content {
  margin-right:100px;
  margin-left:100px;
  text-align:center;
}

.board-list {
  text-align:center;
  height:100px;
}
h1 {
  font-weight: bolder;
  font-size: 38px;
  margin-top:30px;
}
</style>