<%@ taglib prefix="s" uri="/struts-tags"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> 

<script type="text/javascript">

$(function() {
    $("#SURVEYDATE_PLH").attr("placeholder", "02-03-2014");
    $("#TELEPHONENUMBER_PLH").attr("placeholder", "703-993-4622");
});

</script>

<s:if test="fieldErrors.size() > 0">
	<div id="leftBar">
		<span id="Survey">
			<s:fielderror />
		</span>
	</div>
</s:if>

	<div id="contentArea">

		<div id="b_container">
			<h2>Please fill out the below survey form.</h2>


			<s:form action="hello">

				<tr>
					<td><label>First Name:</label></td>
					<td>
						<s:textfield name="student.firstName" cssClass="full tField" theme="simple"/>
					</td>
				</tr>
				<tr>
					<td><label>Last Name:</label></td>
					<td>
						<s:textfield name="student.lastName" cssClass="full tField" theme="simple"/>
					</td>
				</tr>
				<tr>
					<td><label>Street Address:</label></td>
					<td>
						<s:textfield name="student.streetAddress" cssClass="full tField" theme="simple"/>
					</td>
				</tr>
				<tr>
					<td><label>City:</label></td>
					<td>
						<s:textfield name="student.city" cssClass="full tField" theme="simple"/>
					</td>
				</tr>
				<tr>
					<td><label>State:</label></td>
					<td>
					 	<s:textfield name="student.state" cssClass="full tField" theme="simple" placeholder="VA"/>
					 </td>
				</tr>
				<tr>
					<td><label>Zip:</label></td>
					<td>
					 	<s:textfield name="student.zip" cssClass="full tField" theme="simple" placeholder="20120"/>
					</td>
				</tr>
				<tr>
					<td><label>Telephone #:</label></td>
					<td>
						 <s:textfield name="student.telephoneNumber" cssClass="full tField" theme="simple" id="TELEPHONENUMBER_PLH"/>
					</td>
				</tr>
				<tr>
					<td><label>E-mail:</label></td>
					<td>
						 <s:textfield name="student.email" cssClass="full tField" theme="simple" placeholder="johnDoe@gmu.edu"/>
					</td>
				</tr>
				<tr>
					<td><label>Survey Date</label></td>
					<td>
						<s:textfield cssClass="full tField" name="student.dataOfSurvey" theme="simple" id="SURVEYDATE_PLH"/>
					</td>
				</tr>


				<tr>
	<td colspan="2">
	<s:checkboxlist name="likedAboutCampus" label="What did you like most about this campus?"
	list="{'Students','Location','Campus', 'Atmosphere', 'Dorm Rooms', 'Sports'}" />
</tr>



				
				<tr>				
					<s:radio name="originOfInterest" label="How did you become interested in the University?" list="{'Friends','Television', 'Internet', 'Other'}" />							
				</tr>
				<tr>
					<s:select name="likelyhoodOfRecommendation" label="Likelihood you would recommend this school to a friend?" list="{'VeryLikely','likely','unlikely'}"  />
				</tr>
				<tr>
					<td><label>Raffle</label></td>
					<td>
						<s:textfield name="raffle" cssClass="full tField" theme="simple"/>
					</td>
				</tr>
				<tr>
					<td colspan="2"><label>Additional Comments:</label><br /> <s:textarea theme="simple" name="student.comments" class="tArea" rows="3" /></td>
				</tr>

				<tr>
					<td><input type="SUBMIT" value="Submit" /></td>
					<td><s:submit value="Cancel" action="cancelAction" theme="simple" /></td>
				</tr>
			</s:form>


		</div>
		<!-- end div b_container -->

	</div>
	<!-- end div contentArea -->