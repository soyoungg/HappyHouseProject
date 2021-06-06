import { createInstance } from "./index.js";

const instance = createInstance();
// const config = {
//   headers: { "access-token": localStorage.getItem("access-token") }
// };

function login(user, success, fail) {
  instance.defaults.headers["access-token"] =
    window.localStorage.getItem("access-token");
  const body = {
    user_id: user.user_id,
    user_password: user.user_password,
  };

  instance.post("/login", JSON.stringify(body)).
    then(success).
    catch(fail);
}

// async function findById(user_id, success, fail) {
//   instance.defaults.headers["access-token"] = window.localStorage.getItem(
//     "access-token"
//   );
//   await instance
//     .get(`/user/${user_id}`)
//     .then(success)
//     .catch(fail);
// }

async function findById(user_id, success, fail) {
  instance.defaults.headers["access-token"] =
    window.localStorage.getItem("access-token");
  await instance.get(`/user/${user_id}`).then(success).catch(fail);
}

export { login, findById };
