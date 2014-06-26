<%@ include file="/WEB-INF/jsp/Include.jsp"%>

<html>

	<div>
	
	
		<table border="1">
			<thead>
				<tr>
					<td>
						First Name
					</td>
					<td>
						Last Name
					</td>
					<td colspan = 2>
						Email Address
					</td>				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>
							${employee.firstName}
						</td>
						<td>
							${employee.lastName}
						</td>	
						<td>
							${employee.email}
						</td>	
					</tr>
				</c:forEach>
			</tbody>		
		</table>
		
	</div>

</html>