<template>
  <div>
    <h3><router-link :to="`/tastylist?addr=${obj.addr}`"><span id="rank-title">{{ obj.addr }}</span></router-link></h3>
    <span id="count">{{obj.cnt}}개</span>
    
  </div>
</template>

<script>
export default {
    name: "tastyListRow",
    props: {
      obj: Object
    },
    mounted() {
      console.log(this.obj);
    }
 
}
</script>

<style>
  #rank-title {
    text-decoration: none;
    color: #f9faa9;
    font-size:25px;
    /* rgb(104, 121, 214); */
    font-weight:bold;
  }
  #count {
    color:rgb(255, 185, 104);
    font-size: 20px;
    font-weight: bold;
  }
</style>