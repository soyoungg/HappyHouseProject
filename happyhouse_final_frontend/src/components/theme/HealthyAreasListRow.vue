<template>
  <tr>
       <td>{{ healtyAreasList.park_name }} </td>
      <td>{{ healtyAreasList.park_address }} </td>
  </tr>
</template>

<script>
export default {
    name: "healtyAreasListRow",
    props: {"healtyAreasList":Object}
}
</script>

<style scoped lang="scss">
$black:black;
td {
   padding: 15px;
   background-color: rgba($black,0.05);
   color: black;
   
  position: relative;
      &:hover {
         &:before {
            content: "";
            position: absolute;
            left: 0;
            right: 0;
            top: -9999px;
            bottom: -9999px;
            // background-color: rgba($black,0.3);
            z-index: -1;
         }
      }
}
</style>