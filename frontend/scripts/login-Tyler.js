// function login() {
//   const username = document.getElementById("username").value;
//   const password = document.getElementById("password").value;
//
//   const userReq = [
//     {
//       password: password,
//       token: "string",
//       username: username,
//     }
//   ];
//
//   var xhr = new XMLHttpRequest();
//   var url = "http://localhost:8080/user/login";
//   xhr.open("POST", url, true);
//   xhr.setRequestHeader("Content-Type", "application/json");
//   xhr.onreadystatechange = function () {
//     if (xhr.readyState === 4 && xhr.status === 200) {
//       var json = JSON.parse(xhr.responseText);
//       console.log(json.username + ", " + json.password);
//     }
//   };
//   var data = JSON.stringify({username: username, password: password });
//   xhr.send(data);
// }
