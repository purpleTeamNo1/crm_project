var clients = [];

function clearSearch() {
    document.getElementById("firstName").value = "";
    document.getElementById("lastName").value = "";
    document.getElementById("email").value = "";
    document.getElementById("cellPhone").value = "";
    document.getElementById("homePhone").value = "";
}

function clientSearch(){
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let cellPhone = document.getElementById("cellPhone").value;
    let homePhone = document.getElementById("homePhone").value;
    const params = {
        firstName ,
        lastName,
        cellPhone,
        homePhone,
        email
    };
    //console.log(params);
    const options = {
        method: 'POST',
        headers: {
            // 'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify( params )
    };
    fetch( 'http://localhost:8080/client/findByDync', options )
        .then( response => response.json() ).then( response => {
            clients = response;
            console.log(response)
            console.log(clients)  
            if(response != []) {
                document.getElementById("searchResult").innerHTML = "";
                response.forEach(element => {
                    let trData = document.createElement("tr");
                    document.getElementById("searchResult").appendChild(trData);
                    let tdName = document.createElement("td");
                    tdName.innerHTML = element.firstname + " " + element.lastName;
                    trData.appendChild(tdName);
                    let tdClientID = document.createElement("td");
                    tdClientID.innerHTML = element.clientId;
                    trData.appendChild(tdClientID);
                    let tdPlanID = document.createElement("td");
                    tdPlanID.innerHTML = element.planId;
                    trData.appendChild(tdPlanID);
                    let tdCellPhone = document.createElement("td");
                    tdCellPhone.innerHTML = element.cellPhone;
                    trData.appendChild(tdCellPhone);
                    let tdAddress = document.createElement("td");
                    tdAddress.innerHTML = element.address;
                    trData.appendChild(tdAddress);
                    let tdUpdate = document.createElement("td");
                    trData.appendChild(tdUpdate);
                    let linkUpdate = document.createElement("td");
                    linkUpdate.innerHTML = "Details";
                    linkUpdate.className = "btn";
                    linkUpdate.style.backgroundColor = "LightSteelBlue";
                    linkUpdate.id = element.clientId;
                    linkUpdate.setAttribute('onclick', `clientDetail(${element.clientId})`);
                    tdUpdate.appendChild(linkUpdate);                  
                });
            }
            else{
             console.log("User wrong")
            }
        } );
}

function clientDetail(clientID) {
    //document.location = "./KYC.html";
    // console.log(clientID)
    // clients.forEach(client => {
    //     if (client.clientId == clientID)
    //     console.log(client)
    // });
    clients.forEach(client => {
        if (client.clientId === clientID) {
            //console.log(`${client.clientId}`)
            console.log(client)

            // for (const key in client) {
            //     document.getElementById(`${key}`).value = `${client[key]}`;
            //  }
            document.getElementById("address").value = client.address;
            document.getElementById("age").value = client.age;
            document.getElementById("cellPhone2").value = client.cellPhone;
            document.getElementById("citizenship").value = client.citizenship;
            document.getElementById("clientId").value = client.clientId;
            document.getElementById("dateOfBirth").value = client.dateOfBirth;
            document.getElementById("email2").value = client.email;
            document.getElementById("facebookId").value = client.facebookId;
            document.getElementById("firstname").value = client.firstname;
            document.getElementById("gender").value = client.gender;
            document.getElementById("homePhone2").value = client.homePhone;
            document.getElementById("instagramId").value = client.instagramId;
            document.getElementById("lastUpdate").value = client.lastUpdate;
            document.getElementById("linkedinId").value = client.linkedinId;
            document.getElementById("maritalStatus").value = client.maritalStatus;
            document.getElementById("planId").value = client.planId;
            document.getElementById("postalCode").value = client.postalCode;
            document.getElementById("referredBy").value = client.referredBy;
            document.getElementById("segfundNum").value = client.segfundNum;
            document.getElementById("sin").value = client.sin;
            document.getElementById("source").value = client.source;
            document.getElementById("status").value = client.status;
            document.getElementById("twitterId").value = client.twitterId;
            document.getElementById("wechatId").value = client.wechatId;
            document.getElementById("lastname").value = client.lastName
            document.getElementById("giftGiven").value = client.giftGiven;
            // document.getElementById("productList").value = client.productList;





            // let count = 0;
            // let divRow = document.createElement("div");
            // divRow.className = "row";
            // document.getElementById("clientDetail").appendChild(divRow);  
            // for (const key in client) {
                // console.log(key)
                // console.log(client[key])
                // let tdHeader =  document.createElement("td")
                // tdHeader.innerHTML = key
                // let tdBody =  document.createElement("td")
                // tdBody.innerHTML = client[key]
                // document.getElementById("clientDetailTableHeader").appendChild(tdHeader);
                // document.getElementById("clientDetailTableBody").appendChild(tdBody);
                // if (count % 5 === 0) {
                //     let divRow2 = document.createElement("div");
                //     divRow.className = "row";
                //     document.getElementById("clientDetail").appendChild(divRow);  
                // }
                // let divColumn = document.createElement("div");
                // divColumn.className = "col"
                // console.log(key)
                // console.log(client[key])
                // let labelKey =  document.createElement("label")
                // labelKey.innerHTML = key
                // let inputValue =  document.createElement("input")
                // inputValue.value = client[key]
                // inputValue.className = "form-control";
                // divColumn.appendChild(labelKey);
                // divColumn.appendChild(inputValue);
                // divRow.appendChild(divColumn);
                // count = count + 1;

            //}
            }
        }
    );
    

    
    
    //console.log(cleintInfo)
    // cleintInfo.forEach(element => {
    //     console.log(element.key + " " + element.value)
    // });

    
    //location.replace("./KYC.html")

}