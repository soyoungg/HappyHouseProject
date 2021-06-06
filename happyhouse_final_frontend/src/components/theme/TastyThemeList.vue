<template>
  <div>
      <theme-list-row v-for="(item, index) in tastyAreas" :key="index" :obj="item"/>
  </div>
</template>

<script>
import ThemeListRow from './ThemeListRow.vue';
import { mapGetters } from "vuex";
export default {
    name:"themeList",
    components: {
        ThemeListRow,
    },
    computed: {
        ...mapGetters(["tastyAreas"])
    },
    created() {
        this.$store.dispatch("getTastyAreas");
    }
}
</script>

<style>

</style>