let loginForm = document.getElementById('login_form');
loginForm.addEventListener('submit', submitListener);

let databaseTitle = document.getElementById('display_database');
databaseTitle.addEventListener("click", displayDatabase);

let displayCanvas = document.getElementById("canvas");

function submitListener(e) {
    e.preventDefault();
    console.log(e.type);

    let retUsername = document.getElementById("username_entry_field").value;
    let retPassword = document.getElementById("password_entry_field").value;

    let loginObject = {
        "password": retPassword,
        "username": retUsername
    };

    console.log(retUsername, retPassword);

    //1. Create XMLHttpRequest object
    let xhr = new XMLHttpRequest();

    //2. Open the Connection
    xhr.open("POST", "http://localhost:8000/login");

    //3. Tell Server, this request is going to contain a JSON
    xhr.setRequestHeader("Content-Type", "application/json");

    //4. Set the onreadystatechange
    xhr.onreadystatechange = function () {
        if(this.readyState == 4) {
            let response = this.responseText;
            let status = this.status;

            console.log("res: ", response);
            console.log("status: ", status);
        }
    }

    //5. Send the Request
    xhr.send(JSON.stringify(loginObject));
}

function displayDatabase (e) {
    e.preventDefault;
    
    let xhr = new XMLHttpRequest();

    xhr.open("GET", "http://localhost:8000/display");

    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            let response = this.responseText;
            let status = this.status;

            console.log("res: ", response);
            console.log("status: ", status);

            if(status == 200) {
                let dbArray = response.split("}");

                for (let i = 0; i < dbArray.length; i++) {


                    let entry = document.createElement("p");
                    entry.innerText = dbArray[i];
                    displayCanvas.append(entry);

                    
                }
            }
        }
    }

    //5. Send the Request
    xhr.send();
}