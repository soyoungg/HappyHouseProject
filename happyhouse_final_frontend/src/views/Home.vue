<template>
  <div class="home">
    <!--<img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js App" />-->
    <Search />
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from "@/components/HelloWorld.vue";
import Search from "@/components/search/Search.vue";

export default {
  name: "Home",
  components: {
    Search
  },
};
</script>
