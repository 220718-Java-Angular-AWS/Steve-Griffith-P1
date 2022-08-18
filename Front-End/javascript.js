

async function login(){
    userName = document.getElementById("userName").value;
    password = document.getElementById("password").value;


    let url = 'http://localhost:8080/P1-Backend/verification?userName=' + userName + '&password=' + password;
    let response = await fetch(url, {method: 'GET', headers:{'Content-Type': 'application/json; charset=utf-8'}});

    if(response.status == 200){
        let user = await response.json();
        if(localStorage == null){
            document.getElementById("login").addEventListener("click", function(){
                window.localStorage.setItem('userStatus', user.roleType);
            });
        }
        else{
            localStorage.getItem('userId');
            localStorage.getItem('userName');
            localStorage.setItem('userId', user.userId);
            localStorage.setItem('userStatus', user.roleType);
        }
        if(user.roleType == 'Administrator'){
            window.location = './adminDashboard.html';
        }
        else{
            user.roleType = 'Employee';
            window.location = './employeeTicketing.html';
        }

    }
}

//function to handle employee registration
async function signupEmp(){

    let user = {
        userName: document.getElementById("userName").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        roleType: document.getElementById("roleEmp").value
    }
    
    let url = 'http://localhost:8080/P1-Backend/users';
    
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'ContentType' : 'Application/json; charset= UTF-8'
        },
        body: JSON.stringify(user)
    });


    
    if(response.status == 200){
        if(localStorage.getItem == null){
            document.getElementById("login").addEventListener("click", function(){
                window.localStorage.setItem('userId', user.userId);
            });
        }
        else{
            localStorage.getItem('userId');
            localStorage.setItem('userId', user.userId);
        }
        window.location = './login.html';
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
        password: document.getElementById("password").value,
        roleType: document.getElementById("roleAdmin").value
    }
    
    let url = 'http://localhost:8080/P1-Backend/users';
    
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'ContentType' : 'Application/json; charset= UTF-8'
        },
        body: JSON.stringify(user)
    });


    
    if(response.status == 200){
        if(localStorage.getItem == null){
            document.getElementById("login").addEventListener("click", function(){
                window.localStorage.setItem('userId', user.userId);
            });
        }
        else{
            localStorage.getItem('userId');
            localStorage.setItem('userId', user.userId);
        }
        window.location = './login.html';
    }
    else{
        alert("Something happened");
    }
    }

function backToHome(){
    let clicked = true;
    document.getElementById('cancelBtn').addEventListener("click", function(){
        if(clicked == true){
            window.location = './Index.html';
        }
    });
}

async function createReimbursement(){
   
    let reimbursement = {
        reimbursementType: document.getElementById('expenseType').value,
        reimbursementCost: document.getElementById('expenseCost').value,
        reimbursementStatus: document.getElementById('RStatus').value,
        userId: window.localStorage.getItem('userId')
    }

    let userId = window.localStorage.setItem('userId');


    let url = 'http://localhost:8080/P1-Backend/reimbursements?user-id=' + userId;
    
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'content-Type' : 'Application/json; charset=UTF-8'
        },
        body: JSON.stringify(reimbursement)
    });

    
}
   
    async function editReimbursement(){
        
   
        let reimbursement = {
            reimbursementType: document.getElementById('expenseType').value,
            reimbursementCost: document.getElementById('expenseCost').value,
            userId: window.localStorage.getItem('userId'),
            reimbursementId: document.getElementById('reimbursementId').value
        }
        
        let userId = window.localStorage.getItem('userId');
        let url = 'http://localhost:8080/P1-Backend/reimbursements?reimbursement-id=' + reimbursement.reimbursementId + '&user-id=' + userId;
        
        let response = await fetch(url, {
            method: 'PUT',
            headers: {
                'contentType' : 'Application/json; charset= UTF-8'
            },
            body: JSON.stringify(reimbursement)
        });
        

        if(response.status == 200){
    
            window.location.reload();
          
        }
        else{
            alert("Something happened");
        }
        }
        async function editReimbursementAdmin(){
        
   
            let reimbursement = {
                reimbursementType: document.getElementById('expenseType').value,
                reimbursementCost: document.getElementById('expenseCost').value,
                reimbursementStatus: document.getElementById('RStatus'),
                userId: window.localStorage.getItem('userId'),
                reimbursementId: document.getElementById('reimbursementId').value
            }
            
            let userId = window.localStorage.getItem('userId');
            let url = 'http://localhost:8080/P1-Backend/reimbursements?reimbursement-id=' + reimbursement.reimbursementId + '&user-id=' + userId;
            
            let response = await fetch(url, {
                method: 'PUT',
                headers: {
                    'contentType' : 'Application/json; charset= UTF-8'
                },
                body: JSON.stringify(reimbursement)
            });
            
    
            if(response.status == 200){
        
                window.location.reload();
              
            }
            else{
                alert("Something happened");
            }
            }

    async function delEmp(){
        let userId = document.getElementById("userId").value;
        let url = 'http://localhost:8080/P1-Backend/users?user-id=' + userId;

        let response = await fetch(url, {
            method: 'DELETE', headers:{
                'content-type': 'application/json; charset=utf-8'
            }
        });

        if(response == 200){
            document.location.reload();
        }
        else{
        }

    }

    async function getEmpSingle(){
        let userId = document.getElementById("empNum").value;
        let url = 'http://localhost:8080/P1-Backend/users?user-id=' + userId;

        let response = await fetch(url, {
            method: 'GET',
            headers:{
                'Content-Type': 'application/json; charset=utf-8'
            }
        });

        let user = await response.json()
        let htmlElement = document.getElementById("empSingle");
        
        if(user.userName != null){
            htmlElement.innerHTML += "<p>UserIdNumber: " + user.userId + "</p>";
            htmlElement.innerHTML += "<p>Username: " + user.userName + "</p>";
            htmlElement.innerHTML += "<p>Email: " + user.email + "</p>";   
            htmlElement.innerHTML += "<p>Password: " + user.password + "</p>";
        }else{
            alert("Employee Does Not Live Here!")
        }
        
        
    }

    async function clrList() {
        
        window.location.reload(true);
    }
    
    async function clrRequest(){
        
        window.location.reload(true);

    }

    async function getAllEmp(){

        let url = 'http://localhost:8080/P1-Backend/users';

        let response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        });
            
            let array = await response.json();
            let htmlElement = document.getElementById('empAll');

            for(let i = 0; i < array.length; i++){
                let user = array[i];
                htmlElement.innerHTML += "<p>UserIdNumber: " + user.userId + "</p>";
                htmlElement.innerHTML += "<p>Username: " + user.username + "</p>";
                htmlElement.innerHTML += "<p>Email: " + user.email + "</p>";   
                htmlElement.innerHTML += "<p>Password: " + user.password + "</p>";
            }
    }


    async function getAllReimbursements() {

        let userId = window.localStorage.getItem('userId');
        let url = 'http://localhost:8080/P1-Backend/reimbursements';

        let response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        });
 
            let array = await response.json();
            let htmlElement = document.getElementById('List');

            for(let i = 0; i < array.length; i++){
                let reimbursementList = array[i];
                htmlElement.innerHTML += "<p>Reimbursement Id Number: " + reimbursementList.reimbursementId;
                htmlElement.innerHTML += "<p hidden>User Id: " + reimbursementList.userId + "</p>";
                htmlElement.innerHTML += "<p>Reimbursement Type: " + reimbursementList.reimbursementType + "</p>"
                htmlElement.innerHTML += "<p>Reimburesement Cost: " + reimbursementList.reimbursementCost + "</p>";
                htmlElement.innerHTML += "<p> Reimbursement Status: " + reimbursementList.status + "</p>"
            }
    };

    async function editReimbursementsEmp(){

        let htmlElement = document.getElementById('ListEdit');
        
        htmlElement.innerHTML += "<p>Enter the Reimbursement Id you would like to edit</p>"
        htmlElement.innerHTML += "<input id='reimbursementId' type= 'number'> "
        htmlElement.innerHTML += "<label for='expenseType'>Choose an Expense Type:</label>"
        htmlElement.innerHTML+= "<select name='expenseTypeDrop' id='expenseType'><option value='default'>Choose:</option><option value='food'>Food</option> <option value='travel'>Travel</option><option value='lodging'>Lodging</option></select>"
            htmlElement.innerHTML+= "<br><label for='expenseCost'>Expense Cost:</label>"
            htmlElement.innerHTML+= "<input type='number' id='expenseCost' name='expenseCost' step='.01' min='0' max='10' placeholder='$0.00'>"

            htmlElement.innerHTML += "<button type= 'submit' onclick= 'editReimbursement()'>Submit Changes</button>"
        }


        async function editReimbursementsAdmin(){

            let htmlElement = document.getElementById('ListEdit');
            
            htmlElement.innerHTML += "<p>Enter the Reimbursement Id you would like to edit</p>"
            htmlElement.innerHTML += "<input id='reimbursementId' type= 'number'> "
            htmlElement.innerHTML += "<label for='expenseType'>Choose an Expense Type:</label>"
            htmlElement.innerHTML+= "<select name='expenseTypeDrop' id='expenseType'><option value='default'>Choose:</option><option value='food'>Food</option> <option value='travel'>Travel</option><option value='lodging'>Lodging</option></select>"

            htmlElement.innerHTML +="<select name='expenseStatusDrop' id='expenseStatusDrop'><option value='default'>Choose:</option><option value='Accepted' id= 'RStatus'>Accepted</option><option value='Rejected' id= 'RStatus'>Rejected</option><option value='Completed' id= 'RStatus'>Completed</option></select>"

                htmlElement.innerHTML+= "<br><label for='expenseCost'>Expense Cost:</label>"
                htmlElement.innerHTML+= "<input type='number' id='expenseCost' name='expenseCost' step='.01' min='0' max='10' placeholder='$0.00'>"
    
                htmlElement.innerHTML += "<button type= 'submit' onclick= 'editReimbursement()'>Submit Changes</button>"
            }

    async function logout(){
        window.localStorage.clear();
        window.location = './Index.html'
    }
