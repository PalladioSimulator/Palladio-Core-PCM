This project contains a base class that templates can derive from to gain specialized functionality.  Creating base templates in Visual Studio allows you to use all of the features of the VS.NET IDE while writing code for your templates.  These base classes can then be referenced in your template by adding an "Assembly" directive that points to the .dll (The .dll must be placed in the same directory as the template file or in the main application directory) and then specifying the "Inherits" property on the "CodeTemplate" directive.  This is exactly the same functionality that ASP.NET gives you. Here is an example of using this base class.

** NOTE: If you compile this project in debug mode and then copy the .dll and .pdb to the CodeSmith directory, you will be able to step through the code in the base class when using the Debugger.Break() statement in your template.

<%@ CodeTemplate ... Inherits="CodeSmith.BaseTemplates.SqlCodeTemplate" ... %>
<%@ Assembly Name="CodeSmith.BaseTemplates" %>
