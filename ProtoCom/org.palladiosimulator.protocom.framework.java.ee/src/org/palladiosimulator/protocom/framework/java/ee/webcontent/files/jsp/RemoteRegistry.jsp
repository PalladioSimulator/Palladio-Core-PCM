<%@page import="java.io.ObjectOutputStream"%>
<%@page import="org.palladiosimulator.protocom.framework.java.ee.protocol.RegistryEntry"%>
<%@page import="java.util.HashMap"%>
<%@page language="java" pageEncoding="UTF-8"%>

<%! @SuppressWarnings("unchecked") %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Registry</title>
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
					out.print("<br>Interfaces: ");
					
					Class<?>[] ifaces = entry.getInterfaces();
					out.print(ifaces[0].getSimpleName());
					
					for (int i = 1; i < ifaces.length; i++) {
						out.print(", " + ifaces[i].getSimpleName());
					}

					out.println("</li>");
				}
			%>
		</ul>
	</body>
</html>
