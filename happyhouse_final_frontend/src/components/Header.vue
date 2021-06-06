<template>
  <div>
      <div id="nav-menu">
        <router-link to="/">Home</router-link> 
        <router-link to="/notice">공지사항</router-link>  
        <router-link to="/qna">자유게시판</router-link>  
        <router-link to="/dashboard">사용자 대시보드</router-link> 
        <router-link to="/theme">테마별 추천</router-link> 
      </div>
      <div id="nav-user">
        <router-link v-if="isLogin" to="/" @click.prevent="onClickLogout"> 로그아웃 </router-link>
        <router-link v-else to="/login">로그인</router-link> 
        <router-link  v-if="isLogin" to="/mypage">마이페이지</router-link> 
        <router-link  v-else to="/signup">회원가입</router-link> 
      </div>
      <span v-if="userInfo && isLogin">{{ userInfo.user_id }}님 안녕하세요</span>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "NavHeader",
  props: {
    checkLogin: {
      checkLogin: Boolean,
    },
  },
  watch: {
    isLogin() {
      console.log(this.isLogin);
    },
    ...mapGetters(["userInfo", "isLogin"]),
  },
  computed: {
    ...mapGetters(["userInfo", "isLogin"]),
  },
  methods: {
    onClickLogout() {
      this.$store
        .dispatch("LOGOUT")
        .then(() => {
          // this.$router.push({ name: "" });
          if (this.$route.path !== "/") this.$router.replace("/");
        })
        .catch(() => {
          console.log("로그아웃 문제!!!");
        });
    },
  },
};
</script>

<style>
#nav-menu {
  float:left
}
#nav-user {
  float:right
}
</style>