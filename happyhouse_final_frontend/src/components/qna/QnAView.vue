<template>
  <div class="board-view-div">
       <div class="board-view-title">{{qna.qna_title}}
           <span class="board-view-author">{{qna.qna_author}}</span><hr>
       </div>
       <div class="board-view-date">{{qna.qna_date}}</div><br>
      <div class="board-view-content">
          {{qna.qna_content}}
      </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
    name:"contentview",
    computed: {
        ...mapGetters(["qna"])
    },
    created() {
        this.$store.dispatch("getQnA", `/${this.$route.query.no}`);
    }
    
}
</script>

<style >

</style>