import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);
// const onlyAuthUser = async (to, from, next) => {
//   let token = localStorage.getItem("access-token");
//   if (this.$store.state.userInfo == null && token) {
//     await this.$store.dispatch("GET_MEMBER_INFO", token);
//   }
//   if (this.$store.state.userInfo === null) {
//     alert("로그인이 필요한 페이지입니다..");
//     // next({ name: "login" });
//     router.push({ name: "login" });
//   } else {
//     next();
//   }
// };
const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Home.vue"),
  },
  {
    path: "/notice",
    name: "Notice",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Notice.vue"),
  },
  {
    path: "/qna",
    name: "QnA",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/QnA.vue"),
  },
  {
    path: "/qnawrite",
    name: "QnAWrite",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/qna/QnAWrite.vue"),
  },
  {
    path: "/noticeview",
    name: "NoticeView",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/notice/NoticeView.vue"),
  },
  {
    path: "/qnaview",
    name: "QnAView",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/qna/QnAView.vue"),
  },
  {
    path: "/dashboard",
    name: "dashboard",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Dashboard.vue"),
  },
  {
    path: "/theme",
    name: "theme",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Theme.vue"),
    // children: [
    //   {
    //     path: "",
    //     name:"theme",
    //     component: () =>
    //       import("../views/ThemeList.vue")
    //   },
      // {
      //   path: "theme/healthy",
      //   name: 'healthy',
      //   component: () =>
      //     import("../components/theme/HealthyTheme.vue"),
      // }, 
      // {
      //   path: "theme/tasty",
      //   name: 'tasty',
      //   component: () =>
      //     import("../components/theme/TastyTheme.vue"),
      // },
    // ]
  },
  {
    path: "/healthy",
    name: 'healthy',
    component: () =>
      import("../components/theme/HealthyTheme.vue"),
  },
  {
    path: "/healthylist",
    name: 'healthylist',
    component: () =>
      import("../components/theme/HealthyThemeView.vue"),
  },
  {
    path: "/tastylist",
    name: 'tastylist',
    component: () =>
      import("../components/theme/TastyThemeView.vue"),
  },
  {
    path: "/tasty",
    name: 'tasty',
    component: () =>
      import("../components/theme/TastyTheme.vue"),
  },
  {
    path: "/login",
    name: "Login",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Login.vue"),
  },
  // {
  //   path: "/logout",
  //   name: "Logout",
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () =>
  //     import(/* webpackChunkName: "about" */ "../views/Logout.vue"),
  // },
  {
    path: "/signup",
    name: "Signup",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/SignUp.vue"),
  },
  {
    path: "/mypage",
    name: "mypage",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/MyPage.vue"),
  },
  {
    path: "/locSearch",
    name: "LocationSearch",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/search/LocationSearch.vue"),
  },
  {
    path: "/nameSearch",
    name: "NameSearch",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/search/NameSearch.vue"),
  },

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
