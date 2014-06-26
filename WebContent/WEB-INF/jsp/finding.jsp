<%@ include file="/WEB-INF/jsp/Include.jsp"%>

<html>

	<div>
	
	
		<table border="1">
			<thead>
				<tr>
					<td>
						Description
					</td>
					<td>
						F Type
					</td>
					<td>
						Approved
					</td>	
					<td>
						Manufacturer ID
					</td>>			
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${findings}" var="finding">
					<tr>
						<td>
							${finding.description}
						</td>
						<td>
							${finding.fType}
						</td>	
						<td>
							${finding.approved}
						</td>
						<td>
							${finding.manufacturerId}
						</td>
					</tr>
				</c:forEach>
			</tbody>		
		</table>
		
	</div>

</html>