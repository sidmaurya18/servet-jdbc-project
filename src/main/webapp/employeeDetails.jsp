<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	
	<style type="text/css">
        *{
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body{
            background: grey;
        }
        form{
            height: 59vh;
            width: 30vw;
            border: 4px solid red;
            margin: auto;
            padding-left: 3%;
            background-color: rgba(255, 228, 196, 0.381);
            font-size: medium;
        }
        
        form :last-child{
            background-color: rgba(255, 0, 0, 0.491);
        }
        form :nth-child(33){
            background-color: rgba(0, 128, 0, 0.817);
        }  
        form :first-child{
            color: rgb(112, 53, 12);
        }
        a:active{
             background-color: yellow;
        }
	</style>
	
</head>
<body>
	 <form action="employeeDetails" method="post">
        <h2>Employee Details</h2><br>
        
        <label for="id11">Emp Id:</label><br>
        <input type="text" id="id11" name="empId" placeholder="Emp Id"><br><br>

        <label for="name">Emp Name:</label><br>
        <input type="text" id="name" name="empName" placeholder="Emp Name"><br><br>
        
        <label for="email">Emp Email:</label><br>
        <input type="email" id="email" name="empEmail" placeholder="Emp Email"><br><br>
        
        <label for="address">Emp Address:</label><br>
        <input type="text" id="address" name="empAddress" placeholder="Emp Address"><br><br>
        
        <label for="phone">Emp Phone:</label><br>
        <input type="tel" id="phone" name="empPhone" placeholder="Emp Phone"><br><br>
        
        <label for="salary">Emp Salary:</label><br>
        <input type="text" id="salary" name="empSalary" placeholder="Emp Salary"><br><br>
        
        <input type="submit"  value="Submit Details">
        <input type="reset"><br>
        <button><a id="" href="allEmployee" >All Employee</a></button>
     </form>
	
</body>
</html>