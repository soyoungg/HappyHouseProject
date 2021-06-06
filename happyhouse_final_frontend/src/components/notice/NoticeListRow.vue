<template>
  <tr>
      <td>{{ notice.notice_no }}</td>
      <td><router-link :to="`/noticeview?no=${notice.notice_no}`">{{ notice.notice_title }} </router-link></td>
      <td>{{ notice.notice_author }} </td>
      <td>{{ notice.notice_date }} </td>
  </tr>
</template>

<script  >
export default {
    name: "NoticeListRow",
    props: {"notice":Object},
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
	// #fff;
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