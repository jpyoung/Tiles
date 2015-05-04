
    <%@ taglib prefix="s" uri="/struts-tags"%>

	<div class="contentArea2">

		<div id="b_container">
			<h2>List of Completed Surveys.</h2>
			
			<table border="1">
			<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Street Address</th>
			<th>City</th>
			<th>State</th>
			<th>Zip</th>
			<th>Telephone #</th>
			<th>Email</th>
			<th>Survey Date</th>
			<th>Campus Likes</th>
			<th>Interest Origin</th>
			<th>Chance of Recommendation</th>
			<th>Raffle</th>
			<th>Comments</th>
			</tr>
			<s:iterator value="foundResults" var="tt">
			<tr>
				<td><s:property value="#tt.firstName"/></td>
				<td><s:property value="#tt.lastName"/></td>
				<td><s:property value="#tt.streetAddress"/></td>
				<td><s:property value="#tt.city"/></td>
				<td><s:property value="#tt.state"/></td>
				<td><s:property value="#tt.zip"/></td>
				<td><s:property value="#tt.telephoneNumber"/></td>
				<td><s:property value="#tt.email"/></td>
				<td><s:property value="#tt.dataOfSurvey"/></td>
				<td><s:property value="#tt.likedAboutCampus"/></td>
				<td><s:property value="#tt.originOfInterest"/></td>
				<td><s:property value="#tt.likelyhoodOfRecommendation"/></td>
				<td><s:property value="#tt.raffle"/></td>
				<td><s:property value="#tt.comments"/></td>
			</tr>
			</s:iterator>
			
			
			</table>
		
		<br/>
		
		<a href="index.jsp"><button class="green">Return to Homepage</button></a>
		
		
		</div>  <!-- end div b_container -->

	</div>  <!-- end div contentArea -->