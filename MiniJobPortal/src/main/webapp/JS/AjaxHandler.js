let checkUserExistance=(str)=>{
		let xhttp=new XMLHttpRequest();
		xhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200)
				{
					document.getElementById("s").innerHTML=this.responseText;
				}
		};
		
		xhttp.open("GET","/MiniJobPortal/CheckUserExistence?username="+str,true);
		xhttp.send();
	
}
let updateProfile=(str)=>{
		let xhttp=new XMLHttpRequest();
		xhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200)
				{
					document.getElementById("s").innerHTML=this.responseText;
				}
		};
		
		xhttp.open("GET","/MiniJobPortal/updateprofileuser?s="+str,true);
		xhttp.send();
	
}
let updateJobs=(jobId)=>{
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200)
			{
				document.getElementById("s").innerHTML=this.responseText;
			}
	};
	
	xhttp.open("GET","/MiniJobPortal/UpdateJobAdmin?jobId="+jobId,true);
	xhttp.send();
}
function fetchUserDetails(UserId) {
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("UserId").innerHTML = this.responseText;
        }
    };

    xhttp.open("GET","/MiniJobPortal/viewprofile?u="+userId,true);
    xhttp.send();
}

function adminRegister(){

    let email = document.getElementById("regEmail").value;
    let password = document.getElementById("regPassword").value;

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("msg").innerHTML = this.responseText;
        }
    };

    xhttp.open("GET", "/MiniJobPortal/adminregister?email=" + email + "&password=" + password, true);
    xhttp.send();
}

function adminLogin(){

    let email = document.getElementById("loginEmail").value;
    let password = document.getElementById("loginPassword").value;

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
			if(this.responseText.trim() === "SUCCESS"){
			             window.location = "AdminDashboard.html"; 
			         }
			         else{
			             document.getElementById("msg").innerHTML = "Invalid Email or Password";
			         }
			     }
			 };
    xhttp.open("GET", "/MiniJobPortal/AdminLoginServlet?email=" + email + "&password=" + password, true);
    xhttp.send();
}

let showJobs=()=>{
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200)
			{
				document.getElementById("jobData").innerHTML=this.responseText;	
			}
	
	};
	xhttp.open("GET","/MiniJobPortal/ViewJobs",true);
	xhttp.send();
}

function applyJob(jobId) {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {

            let res = this.responseText.trim();

            if (res === "APPLIED") {
                alert("Job Applied Successfully (PENDING)");
            }
            else if (res === "ALREADY") {
                alert("You already applied for this job");
            }
            else if (res === "LOGIN") {
                alert("Please login first");
                window.location = "UserLogin.html";
            }
        }
    };

    xhttp.open("GET", "/MiniJobPortal/applicationservlet?jobId="+ jobId, true);
    xhttp.send();
}

let updateStatusUser=(id)=>{
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200)
			{
				document.getElementById("s").innerHTML=this.responseText;
			}
	};
	alert(id);
	xhttp.open("GET","/MiniJobPortal/Shortlisted?id="+id,true);
	xhttp.send();
}
let updateStatusReject=(id)=>{
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200)
			{
				document.getElementById("s").innerHTML=this.responseText;
			}
	};
	alert(id);
	xhttp.open("GET","/MiniJobPortal/RejectedCandidates?id="+id,true);
	xhttp.send();
}