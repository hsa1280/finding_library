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
				<c:forEach items="${Employees}" var="employee">
					<tr>
						<td>
							${employee.FIRST_NAME}
						</td>
						<td>
							${employee.LAST_NAME}
						</td>	
						<td>
							${employee.EMAIL}
						</td>	
					</tr>
				</c:forEach>
			</tbody>		
		</table>
		
	</div>

</html>