function CheckTeam( ){
	var teamName=document.getElementById("teamName");
	var teamTel=document.getElementById("teamTel");
	var teamEmail=document.getElementById("teamEmail");
	var teamAdd=document.getElementById("teamAdd");
	if(teamName.value==""|| teamTel.value==""||teamEmail.value==""||teamAdd.value=="")
		{
	            alert("所有输入项都不能为空");
	           return ;
		}
}
/*
   之后用正则限制每一项的输入条件.

*/