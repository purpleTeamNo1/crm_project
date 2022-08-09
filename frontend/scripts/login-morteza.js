
function login() {
    let username = document.getElementById("user").value
    let password = document.getElementById("password").value
    const params = {
        username ,
        password
    };
    // console.log(params);
    const options = {
        method: 'POST',
        headers: {
            // 'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
          },
        body: JSON.stringify( params ) 
    };
    fetch( 'http://localhost:8080/user/login', options )
        .then( response => response.json() )
        .then( response => {
            console.log(response )
            alert("done")
            // Do something with response.
        } );
}
