<template>
  <div>
      <h3><router-link :to="`/healthylist?addr=${obj.addr}`">{{ obj.addr }} </router-link></h3><br>
    <span> {{obj.cnt}}개 </span>

  </div>
</template>

<script>
export default {
    name: "healthyListRow",
    props: {
      obj: Object
    },

    mounted() {
      console.log(this.obj);
    },


}
</script>

<style>
    
</style>