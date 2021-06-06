<template>
  <div>
    <h1>QnA 게시판</h1>
    <div class="board-content">
      <div class="board-write-button">
        <button @click="movePage" >글쓰기</button>
      </div>
      <div class="board-list">
        <qn-a-list/>
      </div>
    </div>
  </div>
</template>

<script>
import QnAList from '../components/qna/QnAList.vue'
export default {
  components: { QnAList },
  methods: {
    movePage: function() {
      this.$router.push("/qnawrite");
    }
  }
}
</script>

<style scoped>
/* .button {
  float:right;
  margin-bottom: 20px;
}
button {
  background-color:#faccf8;
  border:none;
  padding:10px;
  border-radius:10px;
  width:80px;
  height:50px;
  font-size: 18px;
  cursor:pointer;
}
#content {
  margin-right:100px;
  margin-left:100px;
  text-align:center;
}

#qnalist {
  text-align:center;
  height:100px;
}
h1 {
  font-weight: bolder;
  font-size: 38px;
  margin-top:30px;
} */
</style>