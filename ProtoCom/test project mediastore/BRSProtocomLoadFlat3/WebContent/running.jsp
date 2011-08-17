<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Protocom - Measurement</title>
</head>
<body>
	<p>The measurement is running. Check the server log and the config folder in your Glassfish's domain for the output. The results in the config folder can be opened as a file datasource with the PCM Result View.</p>
	<a href="index.jsp">Return to the main page</a>
	<p>Press Stop to stop any currently running measurements. 
       This is normally used only for passive servers. Set the option -P in your ScenarioStarter
       to make your server passive so that it generates no load when pressing start above, but 
       only measures incoming requests.  <br> 
       Measurements of active servers stop automatically after the configured load scenarios have finished. Check you server log to find out.
    </p>
    <form action="StopMeasurement" method="post">
    	<input type="submit" value="Stop"></input>
    </form>
</body>
</html>