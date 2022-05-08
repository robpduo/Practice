let loginForm = document.getElementById('login_form');
loginForm.addEventListener('submit', submitListener);

let databaseTitle = document.getElementById('display_database');
databaseTitle.addEventListener("click", displayDatabase);

let displayCanvas = document.getElementById("canvas");

function submitListener (e) {
    e.preventDefault;
    
    let retUsername = document.getElementById("username_entry_field").value;
    let retPassword = document.getElementById("password_entry_field").value;

    let loginObject = {
        password: retPassword,
        username: retUsername
    };

    fetch("http://localhost:8000/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(loginObject)
    })

}

function displayDatabase (e) {
    e.preventDefault;

    /*What does it mean to consume*/
    fetch("http://localhost:8000/display")  //Get a promise from the server
    .then( (resp) => resp.json())   //takes the promise and converts it to a json
    .then((data) => {   //takes the data from the json and consumes it
        console.log(data);

        while (displayCanvas.firstChild) { //clear the canvas
            displayCanvas.removeChild(displayCanvas.firstChild);
        }

        for(let i = 0; i < data.length; i++) { //display updated database
            let printToCanvas = document.createElement("p");
            printToCanvas.innerText = i + ". Username: " + data[i].username + " Password: " + data[i].password;
            displayCanvas.append(printToCanvas);
        }
    });

}