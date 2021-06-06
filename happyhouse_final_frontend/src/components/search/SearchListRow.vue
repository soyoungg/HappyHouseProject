<template>
  <tr>
    <td>{{housedealobj.no}}</td>
    <td style="font-weight:bold;">{{ housedealobj.aptName}}</td>
    <td>{{ housedealobj.dealAmount}}</td>
    <td>{{ housedealobj.dealYear}}년 {{ housedealobj.dealMonth}}월 {{ housedealobj.dealDay}}일</td>
    <td><input type="button" value = "" @click="addFavorite(housedealobj.no)"/></td>
  </tr>
</template>

<script>
import { mapGetters, mapState } from "vuex";
export default {
    name: "searchListRow",
    props: {
      dealno: String,
      aptName: String,
      housedealobj: Object
    },
    mounted() {
      
    },
    computed: {
      ...mapGetters(["userInfo"]),
      ...mapState(["userInfo"])
    },
    async creted() {
      let token = localStorage.getItem("access-token");
        if (this.$store.state.userInfo == null && token) {
          await this.$store.dispatch("GET_MEMBER_INFO", token);
        }
    },
    methods: {
      async addFavorite(dealno) {
        console.log("add ", dealno);
        let token = localStorage.getItem("access-token");
        if (this.$store.state.userInfo == null && token) {
          await this.$store.dispatch("GET_MEMBER_INFO", token);
        }
        console.log("after getting user info")
        console.log(this.$store.state.userInfo.user_id)
        let userid = this.$store.state.userInfo.user_id;
        this.$store.dispatch("addFavorite", {"user_id": userid, "deal_no":dealno});
        console.log("done adding")
      }
    }
}
</script>

<style lang="scss" scoped>
$black: black;
$pink:#faccf8;
$white:#fff;
td {
	padding: 15px;

	color: $black;
  position: relative;
  font-size:12px;
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

tr:nth-child(even) {
	background-color: rgba($black,0.1);
}

tr {
  &:hover {
    // background-color: rgba($black,0.2);
  }
}
</style>