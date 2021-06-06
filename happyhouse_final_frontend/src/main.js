import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import * as VueGoogleMaps from "vue2-google-maps"
import * as d3 from "d3";

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");

Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyABwYiaF1z5HHkXxtQixqfgen2Nm_2G6FQ",
    installComponents: true,
    libraries: "places",
    
  }
});

Vue.use(d3);
