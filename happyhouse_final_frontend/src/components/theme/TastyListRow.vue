<template>
  <div>
    <h3><router-link :to="`/tastylist?addr=${obj.addr}`">{{ obj.addr }}</router-link></h3><br>
    <span>{{obj.cnt}}</span>
    
  </div>
</template>

<script>
export default {
    name: "TastyListRow",
    props: {
      obj: Object
    },
    mounted() {
      console.log(this.obj);
    }
 
}
</script>

<style>
    
</style>