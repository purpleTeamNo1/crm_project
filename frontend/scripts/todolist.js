//THINGS THAT NEED TO BE FIXED
// 1. Make it so that loadIntoTable() is run when the page is loaded
// 2. Add functionality so that the dropdown lists in the Action column can get todoId for Editing/Mark Complete/Incomplete
// 3. closeForm() doesn't close the form
// 4. addToDoListItem() doesn't get a response,.

// document.addEventListener('DOMContentLoaded', getSort(1));

//vvvvvvvvvvvvvvv Adding & Editing Table vvvvvvvvvvvvvvv

function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}

function addToDoListItem() {
  const title = document.getElementById("addTitle").value;
  const description = document.getElementById("addDescription").value;
  const location = document.getElementById("addLocation").value;
  const clientID = document.getElementById("addClientID").value;
  const priority = document.getElementById("addPriority").value;
  const dueDate = document.getElementById("addDueDate").value;

  const data = 
    {
      clientId: clientID,
      complete: false,
      description: description,
      dueDate: dueDate,
      location: location,
      priority: priority,
      title: title,
      todoId: "0",
    }
  ;

     const xhr = new XMLHttpRequest();
     const url = "http://localhost:8080/todos/add";
     xhr.open("POST", url, true);
     xhr.setRequestHeader("Content-Type", "application/json");
     xhr.onreadystatechange = function () {
       if (xhr.readyState === 4 && xhr.status === 200) {
        const json = JSON.parse(xhr.responseText);
         console.log(xhr.status);
       }
     };

     const body = JSON.stringify(data);
     xhr.send(body);

//   const options = {
//     method: "POST",
//     headers: {
//       // 'Accept': 'application/json, text/plain, */*',
//       "Content-Type": "application/json",
//     },
//     body: JSON.stringify(data),
//   };
//   fetch("http://localhost:8080/todos/add", options)
//     .then((response) => response.json())
//     .then((response) => {
//       console.log(response);
//       alert("done");
//       // Do something with response.
//     });
//   console.log(response);
}

//vvvvvvvvvvvvvvv Sorting & Filling Table vvvvvvvvvvvvvv

let urlSort;

function getSort(sort) {
  //gets value of chosen Sort
  urlSort = sort;
  loadIntoTable();
}
async function loadIntoTable() {
  let url;

  switch (
    urlSort //changes fetch URL depending on sort type
  ) {
    case "1":
      // ID
      url = "http://localhost:8080/todos/findAll?page=0&size=50&sortBy=todoId";
      break;
    case "2":
      // Priority
      url =
        "http://localhost:8080/todos/findAll?page=0&size=50&sortBy=priority";
      break;
    case "3":
      // Name
      url =
        "http://localhost:8080/todos/findAll?page=0&size=50&sortBy=client.lastName";
      break;
    case "4":
      // Last Update
      url =
        "http://localhost:8080/todos/findAll?page=0&size=50&sortBy=lastUpdate";
      break;
    default:
    // code block
  }

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

  const table = document.getElementById("table");
  const tableBody = table.querySelector("tbody");
  tableBody.innerHTML = "";
  var tr = tableBody.insertRow(-1);

  //Printing rows
  for (var i = 0; i < data.length; i++) {
    tr = table.insertRow(-1);

    //Printing columns
    for (var j = 0; j < col.length; j++) {
      var tabCell = tr.insertCell(-1);

      if (j == 7) {
        //special condition for Client column (7), which is a nested JSON and also needs to be concat for fullname
        data2 = data[i].client;
        fullName = data2.firstname + " " + data2.lastName;
        tabCell.innerHTML = fullName;
      } else {
        tabCell.innerHTML = data[i][col[j]];
      }

      if (j == 8) {
        tabCell.innerHTML = "N/A"
      }
    }
    //add extra column for Action (Need to find a way to give these elements unique IDs.)
    var tabCell = tr.insertCell(-1);
    selectName = "todoactions" + i;
    tabCell.innerHTML = `<select name="todoactions" id="todoactions">
    <option value="actiondefault">Choose:</option>
    <option value="edit">Edit</option>
    <option value="markcomplete">Mark Complete</option>
    <option value="markincomplete">Mark Incomplete</option>
    <option value="delete">Delete</option>
  </select>`;
  }
}
