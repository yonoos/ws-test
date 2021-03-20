<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Open ID</title>
</head>
<body>
	
	

	<form method="post">
		<table>
		   <tr>
			   <td><p>${user_info}</p></td>
			   <td><p>${user_groups}</p></td>
		   <tr>
			   <td>
					<select name="identity_provider" >
					<%
					String [] availableIPs = (String [])request.getAttribute("available_identity_providers");
					String  selectedIP = (String)request.getAttribute("identity_provider");
					if ( availableIPs != null){
						int i = 0;
						for (String identityProvider : availableIPs) {
							boolean selected = selectedIP != null && selectedIP.equals(identityProvider);
							selected = !selected ? i==0 : selected;
							out.append("<option value=\""+identityProvider+"\""+ (selected?" selected":"")+ ">"+identityProvider+"</option>\n");
							i++;
						}
					}
					%>
					</select>
			   </td>
			   <td><input type="submit" value="authenticate"></td>
		   </tr>
		</table>
	</form>
</body>
</html>