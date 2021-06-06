<template>
  <div style="text-align:center" id="login-div">
    <label for="user_id">아이디</label>
    <input
      type="text"
      id="user_id"
      v-model="user.user_id"
      @keyup.enter="confirm"
    /><br />
    <label for="user_password">비밀번호</label>
    <input
      type="password"
      id="user_password"
      v-model="user.user_password"
      @keyup.enter="confirm"
    /><br />
    <button @click="confirm">로그인</button>
  </div>
</template>

<script>
import { login } from "@/api/user.js";

export default {
  name: "Login",
  components: {},
  data() {
    return {
      user: {
        user_id: null,
        user_password: null,
      },
      isLoginError: false,
    };
  },

  // watch:{
  //   isLogin(){
  //     console.log("chekc");
  //     console.log(this.isLogin);
  //   }
  // },
  methods: {
    confirm() {
      localStorage.setItem("access-token", "");
      login(
        this.user,

        (response) => {
          if (response.data.message === "success") {
            let token = response.data["access-token"];
            this.$store.commit("setIsLogined", true);

            console.log(this.$store.state.isLogin);
            localStorage.setItem("access-token", token);

            this.$store.dispatch("GET_MEMBER_INFO", token);

            //this.$router.push("/");
          } else {
            this.isLoginError = true;
          }
        },
        (error) => {
          console.log("아이디");
          console.log(this.user.user_id);
          console.error(error);
          alert("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
      );
    },
  },
};
</script>

<style scoped>
#user_id, #user_password {
  margin:10px;
}
input {
  margin-top:30px;
}
#login-div {
  margin:auto;
}.
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 3px solid #ccc;
  -webkit-transition: 0.5s;
  transition: 0.5s;
  outline: none;
}

input[type=text]:focus {
  border: 3px solid #555;
}
</style>
