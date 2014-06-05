<%@page import="java.io.ObjectOutputStream"%>
<%@page import="org.palladiosimulator.protocom.framework.jee.servlet.registry.RegistryEntry"%>
<%@page import="java.util.HashMap"%>
<%@page language="java" pageEncoding="UTF-8"%>

<%! @SuppressWarnings("unchecked") %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Reference Implementation</title>
	</head>
	<body>
		<h1>Registry</h1>
		<h2>Registered Objects</h2>
		<ul>
			<%
			HashMap<String, RegistryEntry> objects;
			objects = (HashMap<String, RegistryEntry>)request.getAttribute("registeredObjects");
			
			for (RegistryEntry entry : objects.values()) {
				out.print("<li>");
				
				out.print(entry.getName());
				out.print(" at ");
				out.print(entry.getLocation());
				out.print(" (");
				out.print(entry.getInterface().toString());
				out.print(")");
				
				out.println("</li>");
			}
			%>
		</ul>
	</body>
</html>
