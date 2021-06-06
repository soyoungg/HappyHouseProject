<template>
  <div>
      <theme-list-row v-for="(item, index) in healthyAreas" :key="index" :obj="item"/>
 
  </div>
</template>

<script>
import ThemeListRow from './HealthyThemeRow.vue';
import {mapGetters} from "vuex";
export default {
    name:"themeList",
    components: {
        ThemeListRow,
    },
    computed: {
        ...mapGetters(["healthyAreas"])
    },
    created() {
        this.$store.dispatch("getHealthyAreas",`/${this.$route.query.addr}`);
    },


}
</script>

<style>

</style>