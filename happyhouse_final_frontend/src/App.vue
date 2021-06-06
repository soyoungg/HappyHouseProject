<template>
  <div id="app">
    <div id="navDiv">
      <NavHeader id="nav" checkLogin="false"/>
    </div>
    <router-view />
  </div>
</template>

<script>
import NavHeader from '@/components/Header.vue'

export default {
  name: 'App',
  components: {
    NavHeader 
  },
  data() {
    return {};
  },
  methods: {},
}
</script>

<style lang="scss">
 @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Nanum+Gothic+Coding&display=swap');

#app {
  font-family: "Nanum Gothic", Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
  height:25px;
}

#navDiv {
  background-color: #faccf8;
  margin-bottom:10px;
}

html, body {
  margin: 0px !important;
}

// #nav a {
//   font-weight: bold;
//   color: #2c3e50;
//   text-decoration: none;
//   margin: 20px;
//   transition: all 0.5s ease-in-out;
//   text-transform: uppercase;
 
// }

#nav a.router-link-exact-active {
  color: #F08080;
  /* #42b983; */
}
#nav {
    // display: block;
    // padding: 120px 0 0 0;  
    text-align: center;
    font-size: 16px;

    router-link {
      // list-style: none;
      // margin: 0 auto;
      border-left: 2px solid #3ca0e7;
      // display: inline-block;
      // padding: 0 30px;
      // position: relative;
      text-decoration: none;
      text-align: center;
      // font-family: arvo;
    }

    a {
      color: black;
      font-weight: bold;
      text-decoration: none;
      margin: 20px;
      transition: all 0.3s ease-in-out;
      text-transform: uppercase;
    }

    a:hover {
      color: #3ca0e7;
    }

    a:hover {
      cursor: pointer;
    }

    router-link a {
      visibility: hidden;
      opacity: 0;
      position: absolute;
      padding-left: 0;
      left: 0;
      display: none;
      background: white;
    }

  
}

a {
  text-decoration: none;
  &:hover {
      color: #3CA0E7;
  }
}

.title {
 text-decoration-style: bold;
}
</style>
