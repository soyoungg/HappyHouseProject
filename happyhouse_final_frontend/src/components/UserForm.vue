<template>
  <div>
      <label for="id">아이디</label>
      <input type="text"/><br>
      <label for="id">이름</label>
      <input type="text"/><br>
      <label for="id">비밀번호</label>
      <input type="password"/><br>
      <label for="id">성별</label>
      <select name="sex" id="sex">
        <option value="female">여</option>
        <option value="male">남</option>
      </select><br>
      <label for="age">연령</label>
      <select name="age" id="age">
        <option value="10">10~19세</option>
        <option value="10">20~29세</option>
        <option value="10">30~39세</option>
        <option value="10">40~49세</option>
        <option value="10">50~59세</option>
        <option value="10">60~69세</option>
        <option value="10">70~79세</option>
        <option value="10">80~89세</option>
        <option value="10">90~99세</option>
        <option value="10">100~109세</option>
      </select><br>
      <label for="id">휴대폰 번호</label>
      <input type="text"/><br>
      <label for="id">이메일</label>
      <input type="text"/><br>
      <button v-if="type==='signup'">회원가입</button>
      <button v-if="type==='modify'">수정</button>
  </div>
</template>

<script>
export default {
  props: {
    type:{ type:String}
  }
}
</script>

<style>

</style>