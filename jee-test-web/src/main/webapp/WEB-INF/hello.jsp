<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculator</title>
</head>
<body>
	
	

	<form method="post">
		<table>
		    <tr>
			   <td><p>${heapInfo}</p></td>
		   <tr>
		   <tr>
			   <td><p>${results}</p></td>
		   <tr>
			   <td> <input type="number" name="left_operand"  value="<%  out.append(""+request.getAttribute("left_operand"));%>"></td>
			   <td>
					<select name="operator" >
					<%
					String [] availableOperatros = (String [])request.getAttribute("available_operatros");
					String  selectedOperator = (String)request.getAttribute("operator");
					if ( availableOperatros != null){
						int i = 0;
						for (String operator : availableOperatros) {
							boolean selected = selectedOperator != null && selectedOperator.equals(operator);
							selected = !selected ? i==0 : selected;
							out.append("<option value=\""+operator+"\""+ (selected?" selected":"")+ ">"+operator+"</option>\n");
							i++;
						}
					}
					%>
					</select>
			   </td>
			   <td><input type="number" name="right_operand"  value="<% out.append(""+request.getAttribute("right_operand"));%>"></td>
			   <td><input type="submit" value="submit"></td>
		   </tr>
		</table>
	</form>
</body>
</html>