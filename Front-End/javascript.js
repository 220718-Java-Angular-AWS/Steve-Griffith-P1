//function to handle employee registration
async function signupEmp(){

let user = {
    userName: document.getElementById("userName").value,
    email: document.getElementById("email").value,
    password: document.getElementById("password").value
}

let url = 'http://localhost:8080/P1-Backend/users?user-id='

let response = await fetch(url, {
    method: 'post',
    headers: {
        'ContentType' : 'Application/json; charset= UTF-8'
    },
    body: JSON.stringify(user)
});
if(document.getElementById("password") == document.getElementById("passwordConf")){
    window.location = './reimbursements.html'; 
}
else{
    alert("Passwords Must Match")
}

if(response.status == 200){
  
}
else{
    alert("Something happened");
}
}

//function to handle admin registration
async function signupAdmin(){

    let user = {
        userName: document.getElementById("userName").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    }
    
    let url = 'http://localhost:8080/P1-Backend/users?user-id='
    
    let response = await fetch(url, {
        method: 'post',
        headers: {
            'ContentType' : 'Application/json; charset= UTF-8'
        },
        body: JSON.stringify(user)
    });
    
    if(response.status == 200){
        window.location = './reimbursements.html';
    }
    else{
        alert("Something happened");
    }
    }

async function getuserName(userid){
   let url = 'http://localhost:8080/P1-Backend/users' + userid;
    let response = await fetch(url, {method: 'GET', headers: {'Content-Type': 'application/json; Charset=UTF-8'}

});

    let array = await response.json();
    let htmlElement = document.getElementById('empName');
    htmlElement.innerHTML += userid;
}

function backToHome(){
    let clicked = false;
    document.getElementById('cancelBtn').addEventListener("click", function(){
        if(clicked == true){
            window.location = './Index.html';
        }
    });
}

async function displayReimbursements(userid){
    let url = 'http://localhost:8080/P1-Backend/reimbursements?user-id=' + userid;
    let response = await fetch(url, {method: 'GET', headers: {'Content-Type': 'application/Json; charset=UTF-8'
        }
    });
    let array = response.json();
    let htmlElement = document.getElementById('reimbursements');

    for(let i = 0; i < array.length; i++){
        let reimbursement = array[i];

        
        htmlElement.innerHTML += "<h3>UserId: " + reimbursement.userId + "</h3>";
        htmlElement.innerHTML += "<h3>Employee Name: " + reimbursement.type + "</h3>";
        htmlElement.innerHTML += "<h3>Status: " +reimbursement.status + "</h3>";
        htmlElement.innerHTML += "<h3>Cost: " + reimbursement.cost + "</h3>"; 
    }
}

