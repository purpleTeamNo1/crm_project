//THINGS THAT NEED TO BE FIXED
// 1. Make it so that loadIntoTable() is run when the page is loaded

// document.addEventListener('DOMContentLoaded', getSort(1));

//vvvvvvvvvvvvvvv Adding & Editing Table vvvvvvvvvvvvvvv

function openAddForm() {
  document.getElementById("myAddForm").style.display = "block";
}

function closeAddForm() {
  document.getElementById("myAddForm").style.display = "none";
}

function openEditForm() {
  document.getElementById("myEditForm").style.display = "block";
}

function closeEditForm() {
  document.getElementById("myEditForm").style.display = "none";
}

function searchResults() {
  const todoID = document.getElementById("searchTodoID").value;
  console.log(todoID);
  const table = document.getElementById(todoID);
  const row = table.getElementsByTagName("td");
  console.log(row);
  console.log(row[1].innerText);
  document.getElementById("editTitle").value = row[1].innerText;
  document.getElementById("editTitle").disabled = false;
  document.getElementById("editDescription").value = row[2].innerText;
  document.getElementById("editDescription").disabled = false;
  document.getElementById("editPriority").value = row[3].innerText;
  document.getElementById("editPriority").disabled = false;
  let date = row[5].innerText; //required to change timestamp to date
  date = date.substring(0, date.length - 19);
  console.log(date);
  document.getElementById("editDueDate").value = date;
  document.getElementById("editDueDate").disabled = false;
  document.getElementById("editLocation").value = row[6].innerText;
  document.getElementById("editLocation").disabled = false;
  document.getElementById("editClientID").value = row[9].innerText;
  // document.getElementById("editClientID").disabled = false;
  // can be altered later, right now it's best if clientID can only be set automatically
  document.getElementById("completeTrue").disabled = false;
  document.getElementById("completeFalse").disabled = false;
  if (row[8].innerText == "true") {
    document.getElementById("completeTrue").checked = true;
  } else {
    document.getElementById("completeFalse").checked = true;
  }
}

function addToDoListItem() {
  const title = document.getElementById("addTitle").value;
  const description = document.getElementById("addDescription").value;
  const location = document.getElementById("addLocation").value;
  const clientID = document.getElementById("addClientID").value;
  const priority = document.getElementById("addPriority").value;
  const dueDate = document.getElementById("addDueDate").value;
  const todoID = document.getElementById("searchTodoID").value;

  const data = {
    clientId: clientID,
    complete: false,
    description: description,
    dueDate: dueDate,
    location: location,
    priority: priority,
    title: title,
    todoId: todoID,
  };
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
}

function editToDoListItem() {
  const title = document.getElementById("editTitle").value;
  const description = document.getElementById("editDescription").value;
  const location = document.getElementById("editLocation").value;
  const clientID = document.getElementById("editClientID").value;
  const priority = document.getElementById("editPriority").value;
  const dueDate = document.getElementById("editDueDate").value;
  const todoID = document.getElementById("searchTodoID").value;
  let completeStatus;
  if (document.getElementById("completeTrue").checked == true) {
    completeStatus = true;
  }
  if (document.getElementById("completeFalse").checked == true) {
    completeStatus = false;
  }

  const data = {
    clientId: clientID,
    complete: completeStatus,
    description: description,
    dueDate: dueDate,
    location: location,
    priority: priority,
    title: title,
    todoId: todoID,
  };
  const xhr = new XMLHttpRequest();
  const url = "http://localhost:8080/todos/update";
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
}

//vvvvvvvvvvvvvvv Sorting & Filling Table vvvvvvvvvvvvvv

let urlSort = 1;

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
      // Due Date
      url = "http://localhost:8080/todos/findAll?page=0&size=50&sortBy=dueDate";
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
    for (var j = 0; j < col.length + 1; j++) {
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
      } else if (j == 10) {
        //extra column used to record clientID, won't be rendered
        clientID = data2.clientId;
        console.log(clientID);
        tabCell.innerHTML = clientID;
      } else {
        tabCell.innerHTML = data[i][col[j]];
      }
    }
    //add extra column for Action (Need to find a way to give these elements unique IDs.)
    //   var tabCell = tr.insertCell(-1);
    //   selectName = "todoactions" + i;
    //   tabCell.innerHTML = `<select name="todoactions" id="todoactions">
    //   <option value="actiondefault">Choose:</option>
    //   <option value="edit">Edit</option>
    //   <option value="markcomplete">Mark Complete</option>
    //   <option value="markincomplete">Mark Incomplete</option>
    //   <option value="delete">Delete</option>
    // </select>`;
  }
}
