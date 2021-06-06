<template>
  <tr>
      <td>{{ qna.qna_no }} </td>
      <td><router-link :to="`/qnaview?no=${qna.qna_no}`">{{ qna.qna_title }} </router-link></td>
      <td>{{ qna.qna_author }} </td>
      <td>{{ qna.qna_date }} </td>
  </tr>
</template>

<script>
export default {
  name: "QnAListRow",
  props: {"qna":Object}
}
</script>

<style lang="scss" scoped>
$black: black;
$pink:#faccf8;
td a {
    text-decoration: none;
    // color:black;
    color: black;
}
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

	tr {
		&:hover {
			// background-color: rgba($black,0.2);
		}
	}
</style>