var products = [];

function clearSearch() {
    document.getElementById("insuranceID").value = "";
    document.getElementById("policyNum").value = "";
}

function productSearch(){

    let field = document.getElementById("insuranceId").value;
    console.log(field);
    let field2 = document.getElementById("policyNumber").value;

    if (field!= '') {
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
    fetch( 'http://localhost:8080/insurance/findbyid?insuranceId=' + field)
        .then( response => response.json() ).then( response => {
            products = response;
            console.log(response)
            console.log(products)
            if(response != []) {
                document.getElementById("searchResult").innerHTML = "";
                element = response;
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
                ;
            }
            else{
             console.log("User wrong")
            }
        } );
    }
    else if (field2!= ''){    // let insuranceID = document.getElementById("insuranceID").value;
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
        fetch( 'http://localhost:8080/insurance/findbypolicynumber?policyNumber=' + field2)
            .then( response => response.json() ).then( response => {
                products = response;
                console.log(response)
                console.log(products)
                if(response != []) {
                    document.getElementById("searchResult").innerHTML = "";
                    element = response;
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
                    ;
                }
                else{
                 console.log("User wrong")
                }
            } );
        }
}

function productDetail(productID) {
    //document.location = "./KYC.html";
    // console.log(clientID)
    // clients.forEach(client => {
    //     if (client.clientId == clientID)
    //     console.log(client)
    // });
    console.log(products);
    //products.forEach(product => {
        // if (product.productId === productID) {
            //console.log(`${client.clientId}`)
            //console.log(products)
            //console.log(product.insurance.insuranceId)

            // for (const key in client) {
            //     document.getElementById(`${key}`).value = `${client[key]}`;
            //  }
            document.getElementById("productcode").value = products.productCode;
            document.getElementById("productID").value = products.productId;
            document.getElementById("insuranceId2").value = products.insurance.insuranceId;
            document.getElementById("policyNum2").value = products.insurance.policyNumber;
            document.getElementById("applicationNum").value = products.insurance.applicationNumber;
            document.getElementById("applicationDate").value = products.applicationDate;
            document.getElementById("enforcementDate").value = products.insurance.enforcementDate;
            document.getElementById("coverageAmount").value = products.insurance.coverageAmount;
            document.getElementById("additionalDeposit").value = products.insurance.additionalDeposit;
            document.getElementById("paymentTime").value = products.insurance.paymentTime;
            document.getElementById("riders").value = products.insurance.riders;
            document.getElementById("province").value = products.insurance.province;
            // document.getElementById("productList").value = client.productList;
    //
    //
    //
    //
    //
    //         // let count = 0;
    //         // let divRow = document.createElement("div");
    //         // divRow.className = "row";
    //         // document.getElementById("clientDetail").appendChild(divRow);
    //         // for (const key in client) {
    //             // console.log(key)
    //             // console.log(client[key])
    //             // let tdHeader =  document.createElement("td")
    //             // tdHeader.innerHTML = key
    //             // let tdBody =  document.createElement("td")
    //             // tdBody.innerHTML = client[key]
    //             // document.getElementById("clientDetailTableHeader").appendChild(tdHeader);
    //             // document.getElementById("clientDetailTableBody").appendChild(tdBody);
    //             // if (count % 5 === 0) {
    //             //     let divRow2 = document.createElement("div");
    //             //     divRow.className = "row";
    //             //     document.getElementById("clientDetail").appendChild(divRow);
    //             // }
    //             // let divColumn = document.createElement("div");
    //             // divColumn.className = "col"
    //             // console.log(key)
    //             // console.log(client[key])
    //             // let labelKey =  document.createElement("label")
    //             // labelKey.innerHTML = key
    //             // let inputValue =  document.createElement("input")
    //             // inputValue.value = client[key]
    //             // inputValue.className = "form-control";
    //             // divColumn.appendChild(labelKey);
    //             // divColumn.appendChild(inputValue);
    //             // divRow.appendChild(divColumn);
    //             // count = count + 1;
    //
    //         //}
            //}
        //}
    //);


    
    
    //console.log(cleintInfo)
    // cleintInfo.forEach(element => {
    //     console.log(element.key + " " + element.value)
    // });

    
    //location.replace("./KYC.html")

}