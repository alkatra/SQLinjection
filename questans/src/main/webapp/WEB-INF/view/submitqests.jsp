<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Question Submission Form</title>

	<!--  Inline CCS -->
	<style>
		.error {color:red}
	</style>

</head>
<body>
	<h1> Submit Question </h1>
	<form:form action="${pageContext.request.contextPath}/question/processForm" 
		modelAttribute="question" >
		Question: <form:input path="question" />
		<form:errors path="question" cssClass="error" />
		
		<br><br>
		
		Answer: <form:input path="answer" />
		<form:errors path="answer" cssClass="error" />
		
		<br><br>

		Area: <form:input path="area" />
		<form:errors path="area" cssClass="error" />
		
		<br><br>
		
		<input type="submit" value="Submit" />
	</form:form>
	
	<h1> Query Questions </h1>
	<form:form action="${pageContext.request.contextPath}/question/getQuestions" 
		modelAttribute="question" >

		Area: <form:input path="area" />
		<form:errors path="area" cssClass="error" />
		
		<br><br>
		
		<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>
