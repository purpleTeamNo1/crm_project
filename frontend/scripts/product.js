var products = [];

function clearSearch() {
    document.getElementById("insuranceID").value = "";
    document.getElementById("policyNum").value = "";
}

function productSearch(field){

    if (field == 0) {
    // let insuranceID = document.getElementById("insuranceID").value;
    // const params = {
    //     firstName ,
    //     lastName,
    //     cellPhone,
    //     homePhone,
    //     email
    // };
    // //console.log(params);
    // const options = {
    //     method: 'POST',
    //     headers: {
    //         // 'Accept': 'application/json, text/plain, */*',
    //         'Content-Type': 'application/json'
    //     },
    //     body: JSON.stringify( params )
    // };
    fetch( 'http://localhost:8080/insurance/findall?orderBy=insuranceId&page=0&size=50')
        .then( response => response.json() ).then( response => {
            products = response;
            console.log(response)
            console.log(products)  
            if(response != []) {
                document.getElementById("searchResult").innerHTML = "";
                response.forEach(element => {
                    let trData = document.createElement("tr");
                    document.getElementById("searchResult").appendChild(trData);
                    let tdProductId = document.createElement("td");
                    tdProductId.innerHTML = element.productId;
                    trData.appendChild(tdProductId);
                    let tdProductCode = document.createElement("td");
                    tdProductCode.innerHTML = element.productCode;
                    trData.appendChild(tdProductCode);
                    let tdInsuranceID = document.createElement("td");
                    tdInsuranceID.innerHTML = element.insurance.insuranceId;
                    trData.appendChild(tdInsuranceID);
                    let tdPolicyNum = document.createElement("td");
                    tdPolicyNum.innerHTML = element.insurance.policyNumber;
                    trData.appendChild(tdPolicyNum);
                    let tdApplicationNum = document.createElement("td");
                    tdApplicationNum.innerHTML = element.insurance.applicationNumber;
                    trData.appendChild(tdApplicationNum);
                    let tdUpdate = document.createElement("td");
                    trData.appendChild(tdUpdate);
                    let linkUpdate = document.createElement("td");
                    linkUpdate.innerHTML = "Details";
                    linkUpdate.className = "btn";
                    linkUpdate.style.backgroundColor = "LightSteelBlue";
                    linkUpdate.id = element.productId;
                    linkUpdate.setAttribute('onclick', `productDetail(${element.productId})`);
                    tdUpdate.appendChild(linkUpdate);                  
                });
            }
            else{
             console.log("User wrong")
            }
        } );
    }
    else {}
}

function productDetail(productID) {
    //document.location = "./KYC.html";
    // console.log(clientID)
    // clients.forEach(client => {
    //     if (client.clientId == clientID)
    //     console.log(client)
    // });
    products.forEach(product => {
        if (product.productId === productID) {
            //console.log(`${client.clientId}`)
            console.log(product)

            // for (const key in client) {
            //     document.getElementById(`${key}`).value = `${client[key]}`;
            //  }
            document.getElementById("address").value = client.address;
            document.getElementById("age").value = client.age;
            document.getElementById("cellPhone").value = client.cellPhone;
            document.getElementById("citizenship").value = client.citizenship;
            document.getElementById("clientId").value = client.clientId;
            document.getElementById("dateOfBirth").value = client.dateOfBirth;
            document.getElementById("email").value = client.email;
            document.getElementById("facebookId").value = client.facebookId;
            document.getElementById("firstname").value = client.firstname;
            document.getElementById("gender").value = client.gender;
            document.getElementById("homePhone").value = client.homePhone;
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
            document.getElementById("lastName").value = client.lastName
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