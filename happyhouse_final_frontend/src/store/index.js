import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";
import jwt_decode from "jwt-decode";
import { findById } from "@/api/user.js";
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin: false,
    userInfo: null,
    housedeals: [

    ],
    noticelist: [],
    qnalist: [],
    housedeal: {},
    favorite: [],
    gu: [],
    dong: [],
    qna: {},
    notice: {},
    parks: [],
    restaurants: [],
    tastyAreas: [],
    healthyAreas: [],
    priceChange: [],
    houses: [],
    healthyAreasList: [],
    tastyAreasList: [],
  },
  getters: {
    housemarkers(state) {
      return state.housemarkers;
    },
    housedeals(state) {
      return state.housedeals;
    },
    noticelist(state) {
      return state.noticelist;
    },
    qnalist(state) {
      return state.qnalist;
    },
    parks(state) {
      return state.parks;
    },
    notice(state) {
      return state.notice;
    },
    qna(state) {
      return state.qna;
    },
    tastyAreas(state) {
      return state.tastyAreas;
    },
    healthyAreas(state) {
      return state.healthyAreas;
    },
    priceChange(state) {
      return state.priceChange;
    },
    isLogin(state) {
      return state.isLogin;
    },
    userInfo(state) {
      return state.userInfo;
    },
    favorite(state) {
      return state.favorite;
    },
    houses(state) {
      return state.houses;
    },
    healthyAreasList(state) {
      return state.healthyAreasList;
    },
    tastyAreasList(state) {
      return state.tastyAreasList;
    },
  },
  mutations: {
    etHouses(state, payload) {
      state.houses = payload.data;
    },
    setIsLogined(state, isLogin) {
      state.isLogin = isLogin;
    },
    setUserInfo(state, userInfo) {
      state.isLogin = true;
      state.userInfo = userInfo;
      console.log("set user info ", state.userInfo);
    },
    logout(state) {
      state.isLogin = false;
      state.userInfo = null;
    },
    setHouseDeals(state, payload) {
      state.housedeals = payload.data;
      console.log(state.housedeals);
    },
    // setCity(state, payload) {
    //   state.city = payload.data;
    // }
    setNoticeList(state, payload) {
      state.noticelist = payload.data;
      console.log("notice ", state.noticelist);
    },
    setQnAList(state, payload) {
      state.qnalist = payload.data;
      console.log("qna ", state.qnalist);
    },
    setUserBoard(state, payload) {
      state.favorite = payload.data;
    },
    setParks(state, payload) {
      state.parks = payload.data;
    },
    setNotice(state, payload) {
      state.notice = payload;
      console.log("notice ", state.notice);
    },
    setQnA(state, payload) {
      state.qna = payload;
    },
    setTastyAreas(state, payload) {
      state.tastyAreas = payload;
      console.log("tasty ", state.tastyAreas);
    },
    setHealthyAreas(state, payload) {
      state.healthyAreas = payload;
      console.log("healthy", state.healthyAreas);
    },
    setPriceChange(state, payload) {
      state.priceChange = payload.data;
      console.log("price change ", state.priceChange);
    },
    setFavorite(state, payload) {
      console.log("setFavorite ", payload);
      state.favorite = payload;
      console.log("favorite ", state.favorite, payload);
    },
    setHealthyAreasList(state, payload) {
      state.healthyAreasList = payload;
      console.log("healthyAreasList", state.healthyAreasList);
    },
    setTastyAreasList(state, payload) {
      state.tastyAreasList = payload;
      console.log("tastyAreasList", state.tastyAreasList);
    },
  },
  actions: {
    // add
    getHouseDeals({ commit }, data) {
      http
        .post("/apt/apart_list", { "dong": data })
        .then((response) => {
          commit("setHouseDeals", response);
        })
        .catch(() => {
          console.log("hi", data);
          alert("에러발생!");
        });
    },
    getHouseDealsByName({ commit }, data) {
      http
        .post("/apt/apt_list", { "apt": data })
        .then((response) => {
          commit("setHouseDeals", response);
        })
        .catch(() => {
          console.log(data);
          alert("에러발생!");
        });
    },
    getNoticeList({ commit }) {
      http
        .post("/notice/list", { "offset": "1", "limit": "10" })
        .then((response) => {
          console.log(response.data);
          commit("setNoticeList", response);
        })
        .catch(() => {
          console.log("에러")
          alert("에러 발생");
        })
    },
    getQnAList({ commit }) {
      http
        .post("/qna/list", { "offset": "1", "limit": "10" })
        .then((response) => {
          //console.log(response.data);
          commit("setQnAList", response);
        })
        .catch(() => {
          console.log("에러")
          alert("에러 발생");
        })
    },

    getPriceChange({ commit }, payload) {
      http
        .post("/userboard/" + this.getters.userInfo.user_id,
          {"user_id":this.getters.userInfo.user_id, "aptname": payload})
        .then((response) => {
          commit("setPriceChange", response);
        })
        .catch(() => {
          alert("가격 변동 에러 발생");
        })
    },

    getParks({ commit }) {
      http
        .get("/park")
        .then((response) => {
          commit("setParks", response);
        })
        .catch(() => {
          alert("공원 데이터 로드 에러 발생");
        })
    },
    
    getNotice({ commit }, payload) {
      console.log("payload get notice ", payload)
      http
        .get("/notice/ " + payload)
        .then(({ data }) => {
          commit("setNotice", data);
        })
        .catch(() => {
          alert("notice load fail")
        })
    },
    getQnA({ commit }, payload) {
      http
        .get("/qna" + payload).then(({ data }) => {
          commit("setQnA", data);
        })
    },
    getTastyAreas({ commit }) {
      http
        .get("/restaurant")
        .then(({ data }) => {
          commit("setTastyAreas", data);
        })
    },

    getHealthyAreas({ commit }) {
      http
        .get("/park", {
          headers: {
            "access-token": window.localStorage.getItem("access-toekn")
          },
        })
        .then(({ data }) => {
          commit("setHealthyAreas", data);
        })
    },
    async GET_MEMBER_INFO({ commit }, token) {
      let decode = jwt_decode(token);
      console.log("여기는 오나?")
      console.log(decode);
      await findById(
        decode.user_id,
        
        (response) => {
          if (response.data.message === "success") {
            console.log("test");
            commit("setUserInfo", response.data.userInfo);
            // console.log(response.data.userInfo);
            // http.defaults.headers.common['access-token'] = window.localStorage.getItem("access-toekn");
            // router.push("/");
            // router.go(router.currentRoute);
          } else {
            console.log("유저 정보 없음!!");
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    LOGOUT({ commit }) {
      commit("logout");
      localStorage.removeItem("access-token");
      // axios.defaults.headers.common["auth-token"] = undefined;
    },
    addFavorite({ commit }, data) {
      console.log("add favorite user info ", this.getters.userInfo);
      if (this.getters.userInfo == null) {
        alert("로그인이 필요한 서비스 입니다.")
      } else {
        http
          .post("/like", data)
          .then(({ response }) => {
            console.log("response", response);
            commit("setFavorite", response);
          })
          .catch((error) => {
            alert("즐겨찾기 등록 에러.")
            console.log(error)
          })
      }
    },
    getFavoriteList({ commit }) {
      http
        .get("/like/"+this.getters.userInfo.user_id)
        .then(({ data }) => {
          console.log("response ", data);
          commit("setFavorite", data);
        })
        .catch((error) => {
          console.log(error);
        })
    },

    getHealthyAreasList({ commit }, payload) {
      http
        .get("/park/" + payload, {
          headers: {
            "access-token": window.localStorage.getItem("access-toekn")
          },
        }).then(({ data }) => {
          commit("setHealthyAreasList", data);
        })
    },

    getTastyAreasList({ commit }, payload) {
      http
        .get("/restaurant/" + payload, {
          headers: {
            "access-token": window.localStorage.getItem("access-toekn")
          },
        }).then(({ data }) => {
          commit("setTastyAreasList", data);
      }) 
    },
  },
  modules: {},
});
