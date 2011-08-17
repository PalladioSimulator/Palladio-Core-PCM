<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>Protocom - Performance Measurement</title>
  </head>
  <body>
    <p>Press Init to initialise the resources.</p>
    <form action="InitResources" method="post">
    	<input type="submit" value="Init"></input>
    </form>
  	<p>Press Start to start the measurements. Before doing so, initialise the resources above. <br>
  	If this is an active server, this starts the load generators, including warmup.<br>
  	If this is a passive server, this only sets up the measurement infrastucture.</p>
    <form action="StartMeasurement" method="post">
    	<input type="submit" value="Start"></input>
    </form>
    <p>Press Warmup Only to only execute some warmup runs. Before doing so, initialise the resources above.</p>
    <form action="WarmupOnlyServlet" method="post">
    	<input type="submit" value="Warmup Only"></input>
    </form>
    <p>Press Stop to stop any currently running measurements. 
       This is normally used only for passive servers. Set the option -P in your ScenarioStarter
       to make your server passive so that it generates no load when pressing start above, but 
       only measures incoming requests.   
       Measurements of active servers stop automatically after the configured load scenarios have finished. 
    </p>
    <form action="StopMeasurement" method="post">
    	<input type="submit" value="Stop"></input>
    </form>
  </body>
</html> 
