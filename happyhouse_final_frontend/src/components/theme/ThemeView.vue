<template>
    <div>

    <div id="healthymap">
        <GmapMap
      ref="mapRef"
      :center="center"
      :zoom="16"
      style="width:500px; height:500px"
      name="locMap"></GmapMap>
      </div>
    </div> 
</template>
<script>
import { mapGetters} from "vuex";
export default {
    name:"themeview", 
    computed: {
        ...mapGetters([])
    }
}

</script>
