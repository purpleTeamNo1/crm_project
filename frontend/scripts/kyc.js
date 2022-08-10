document.addEventListener(
  "DOMContentLoaded",
  loadClientInfo(),
  loadIntoTableTDL(),
  loadIntoTableCC()
);
//vvvvvvvvvvvvvvv Filling Forms & Tables vvvvvvvvvvvvvv

async function loadClientInfo() {
  fetch("http://localhost:8080/client/findByDync", {
    body: JSON.stringify({firstName: "Alice"}),
    headers: {
      Accept: "*/*",
      "Content-Type": "application/json",
    },
    method: "POST",
  })
  .then( response => response.json() )
  .then( response => {
    if(response.code == "200") {
        //response.code isn't logged? Investigate.
    }
    else{
        data = response;
        console.log(data);
    }
} );
}


async function loadIntoTableTDL() {
  let url = "http://localhost:8080/todos/findById?page=0&size=50&clientId=1";

  const response = await fetch(url); //waits until completion
  const data = await response.json(); //waits until completion

  //   console.log(url);
  console.log(data);

  //Checks to see how many columns the table needs

  var col = [];
  for (var i = 0; i < data.length; i++) {
    for (var key in data[i]) {
      if (col.indexOf(key) === -1) {
        col.push(key);
      }
    }
  }

  console.log(col);

  //Gets the pre-existing table (with predetermined headers) ready by wiping it before insertion.

  const table = document.getElementById("tableTDL");
  const tableBody = table.querySelector("tbody");
  tableBody.innerHTML = "";
  var tr = tableBody.insertRow(-1);

  //Printing rows
  for (var i = 0; i < data.length; i++) {
    tr = table.insertRow(-1);

    //Printing columns
    for (var j = 0; j < col.length; j++) {
      if (j == 0) {
        //makes the tr's ID = todoID. This is used later when searching by todoID.
        tr.setAttribute("id", data[i][col[j]]);
      }
      var tabCell = tr.insertCell(-1);

      if (j == 7) {
        //special condition for Client column (7), which is a nested JSON and also needs to be concat for fullname
        data2 = data[i].client;
        fullName = data2.firstname + " " + data2.lastName;
        tabCell.innerHTML = fullName;
      } else if (j == 8) {
        //note column isn't currently used, filling with next column's data instead
        tabCell.innerHTML = data[i][col[j + 1]];
        j++;
      } else {
        tabCell.innerHTML = data[i][col[j]];
      }
    }
  }
}

async function loadIntoTableCC() {
  let url =
    "http://localhost:8080/insurance/findall?orderBy=insuranceId&page=0&size=50";

  const response = await fetch(url); //waits until completion
  const data = await response.json(); //waits until completion

  //   console.log(url);
  //   console.log(data);

  //Checks to see how many columns the table needs. Not useful for this iteration, easier to hardcode col.
  //   var col = [];
  //   for (var i = 0; i < data.length; i++) {
  //     for (var key in data[i]) {
  //       if (col.indexOf(key) === -1) {
  //         col.push(key);
  //       }
  //     }
  //   }
  //Gets the pre-existing table (with predetermined headers) ready by wiping it before insertion.

  const table = document.getElementById("tableCC");
  const tableBody = table.querySelector("tbody");
  tableBody.innerHTML = "";
  var tr = tableBody.insertRow(-1);

  //Printing rows
  for (var i = 0; i < data.length; i++) {
    tr = table.insertRow(-1);
    //Printing columns
    for (var j = 0; j < 13; j++) {
      const data2 = data[i].insurance;
      const data3 = Object.values(data2); //Need to convert ObjectObject to array of its values. This is fine because we don't need the keys.
      var tabCell = tr.insertCell(-1);

      tabCell.innerHTML = data3[j];
    }
  }
}
