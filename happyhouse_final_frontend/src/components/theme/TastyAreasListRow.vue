<template>
  <tr>
      <td>{{ tastyAreasList.restaurant_name }}</td>
      <td>{{ tastyAreasList.restaurant_type }} </td>
      <td>{{ tastyAreasList.restaurant_address }} </td>
  </tr>
</template>

<script>
export default {
    name: "TastyAreasListRow",
    props: {"tastyAreasList":Object}
}
</script>

<style>

</style>