<!-- Author: Jack Young.  Purpose: This page is displayed after a user submits the survey form, if the users raffle mean was below 90.  -->

<%@ taglib prefix="s" uri="/struts-tags"%>

	<div id="contentArea">
		<div id="b_container">
			
		<div class="message">
			<fieldset>
			<h1 class="center"><s:property value="firstName" />  <s:property value="lastName" /></h1>
			<h2 class="center">Thank you for taking the time to fill out the survey!</h2>
				<p>- The information has been successfully stored</p>
					<table border="1">
						<tr>
							<th colspan="2">Raffle Stats</th>
						</tr>
						<tr>
							<th>Mean</th>
							<td class="result"><s:property value="#application.compMean"/></td>
						</tr>
						<tr>
							<th>Standard Deviation</th>
							<td class="result"><s:property value="#application.compStdv"/></td>
						</tr>
					</table>
					<a href="index.jsp"><button id="backToHome" class="green">Return to Home</button></a>
			</fieldset>
		</div>

		
			<a href="index.jsp"></a>
		
		</div>  <!-- end div b_container -->

	</div>  <!-- end div contentArea -->
