    <%@ taglib prefix="s" uri="/struts-tags"%>


	<div id="contentArea">
	
		<s:url action="takeSurvey" var="takeURL"></s:url>
		
		<a href="<s:property value='#takeURL'/>"><button class="greenBig">Create A New Record</button></a>
		
		<s:url action="viewListPage" var="listURL"></s:url>
			
		<a href="<s:property value='#listURL'/>"><button class="greenBig">List All Records</button></a>

		<s:url action="searchRecordsPage" var="searchURL"></s:url>
			
		<a href="<s:property value='#searchURL'/>"><button class="greenBig">Search Records</button></a>


	</div>  <!-- end div contentArea -->