<%@ taglib prefix="s" uri="/struts-tags"%>

    <div id="searchContainer">
    	<s:form action="searchForThis" cssClass="searchForm">
		
				<label>Last Name:</label>
				<s:textfield cssClass="medium tField" name="searchFields.lastname" theme="simple"/>
	
				<label>First Name:</label>
				<s:textfield cssClass="medium tField" name="searchFields.firstname" theme="simple"/>
	
				<label>City:</label>
				<s:textfield cssClass="medium tField" name="searchFields.city" theme="simple"/>
	
				<label>State:</label>
				<s:textfield cssClass="medium tField" name="searchFields.state" theme="simple"/>
	
				<!-- <button class="green2">Search</button> -->
				<input class="green2" type="SUBMIT" value="Search" />
		</s:form>
	</div> <!-- end div searchContainer -->