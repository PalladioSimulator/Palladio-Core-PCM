using System;
using System.IO;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.FTPRequestProcessor;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverFactory;
using Palladio.Webserver.WebserverMonitor;
using WebserverXML;

namespace Palladio.Webserver
{
	/// <summary>
	/// This is the main webserver-component which provides the ability to create a default configuration of the webserver.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.14  2004/11/21 17:10:04  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	/// Revision 1.13  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.12  2004/11/03 18:52:48  kelsaka
	/// Added ability to get the full content-data of post-requests
	///
	/// Revision 1.11  2004/10/30 11:42:08  kelsaka
	/// Added full support for static websites using the get-method; added several test-documents; changed CoR for HTTP-Processing: dynamic files are delivered first
	///
	/// Revision 1.10  2004/10/29 16:30:39  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.9  2004/10/27 15:05:06  kelsaka
	/// added more request handling-abilities
	///
	/// Revision 1.8  2004/10/27 13:40:43  kelsaka
	/// added component-interconnections; added tcp-listening
	///
	/// Revision 1.7  2004/10/27 05:52:49  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.6  2004/10/25 06:35:51  kelsaka
	/// added XML-reading-abilities
	///
	/// Revision 1.5  2004/10/23 14:08:36  kelsaka
	/// first steps on reading xml-config-files
	///
	/// Revision 1.4  2004/10/23 11:55:08  kelsaka
	/// added some parts of the building process
	///
	/// Revision 1.3  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.2  2004/10/22 09:52:43  kelsaka
	/// extended xml-config-files by logging-file-definitions
	///
	/// Revision 1.1  2004/10/22 09:37:19  kelsaka
	/// minor changes
	///
	///
	/// </pre>
	/// </remarks>
	public class Webserver
	{
		/// <summary>
		/// (Relative) Path to the xml-config-file. All other settings should be read out from the xml-file.
		/// </summary>
		private const string DEFAULT_XML_CONFIGURATION_FILE = "WebserverXML.xml";

		/// <summary>
		/// Where the config-xml-file(s) can be found.
		/// </summary>
		private string pathToConfigFile;



		public Webserver()
		{

		}


		/// <summary>
		/// Main webserver-application start.
		/// </summary>
		/// <param name="args">
		/// First position: path to the config-files, including last backspace.</br>
		/// Second position: configuration-number</br>
		/// Example-usage: Webserver "..\..\..\Config\" 1</param>
		public static void Main(string[] args) 
		{
			Webserver webserver = new Webserver();
			Console.WriteLine("# Main-Thread: Webserver.Run started...");
			webserver.Run(args);
			Console.WriteLine("# Main-Thread: Webserver.Run exited...");
		}


		/// <summary>
		/// Decides which component-configuration shall be built.
		/// </summary>
		private void Run(string[] args)
		{
			
			// Get the config-path:
			try 
			{
				pathToConfigFile = args[0];
			}
			catch(IndexOutOfRangeException)
			{
				pathToConfigFile = ""; //use default path
			}
			


			// The kind of component-configuration:
			string configType;

			try 
			{
				configType = args[1];
			}
			catch(IndexOutOfRangeException)
			{
				configType = ""; //use default configuration
			}


			// Check for the desired configuration type:
			switch(configType)
			{
				// default case; no special config-advices:
				case "":
					DefaultConfiguration();
					break;

				default:
					DefaultConfiguration();
					break;
			}
		}


		/// <summary>
		/// Creates a default component-configuration of the webserver.
		/// Builds and starts a running webserver using the webserver-factory.
		/// </summary>
		private void DefaultConfiguration()
		{

			DefaultWebserverFactory webserverFactory = new DefaultWebserverFactory();

			IConfigReader configReader = webserverFactory.CreateConfigReader();
			IWebserverConfiguration webserverConfiguration = new WebserverConfiguration(
				configReader.ReadConfiguration(pathToConfigFile + DEFAULT_XML_CONFIGURATION_FILE));
			// Set the pathToConfigFile manually, because otherwise this would be a hen egg-problem: the
			// configuration-file can't (or shouldn't have to) know it own position:
			webserverConfiguration.ConfigFilesPath = pathToConfigFile;

			IWebserverMonitor webserverMonitor = webserverFactory.CreateWebserverMonitor(webserverConfiguration);
			

			// RequestProcessor-COR: Dynamic -> SimpleTemplate -> BibTeX -> Static -> Default.
			HTTPRequestProcessor.IHTTPRequestProcessor defaultHttpRequestProcessor = webserverFactory.CreateDefaultRequestProcessor(webserverMonitor, webserverConfiguration);			
			HTTPRequestProcessor.IHTTPRequestProcessor staticFileProvider = webserverFactory.CreateStaticFileProvider(defaultHttpRequestProcessor, webserverMonitor, webserverConfiguration);
			HTTPRequestProcessor.IHTTPRequestProcessor bibTeXProvider = webserverFactory.CreateBibTeXProvider(staticFileProvider, webserverMonitor, webserverConfiguration);
			HTTPRequestProcessor.IHTTPRequestProcessor simpleTemplateFileProver = webserverFactory.CreateSimpleTemplateFileProvider(bibTeXProvider, webserverMonitor, webserverConfiguration);
			HTTPRequestProcessor.IHTTPRequestProcessor dynamicFileProvider = webserverFactory.CreateDynamicFileProvider(simpleTemplateFileProver, webserverMonitor, webserverConfiguration);
			
			

			// RequestParser-COR: HTTP -> Default (currently FTP is not implemented)
			IRequestParser defaultRequestParser = webserverFactory.CreateDefaultRequestParser(webserverMonitor, webserverConfiguration);
			IRequestParser httpRequestParser = webserverFactory.CreateHTTPRequestParser(dynamicFileProvider, defaultRequestParser, webserverMonitor, webserverConfiguration);
			
			IDispatcher dispatcher = webserverFactory.CreateDispatcher(httpRequestParser,webserverMonitor, webserverConfiguration);
			dispatcher.Run();
			
		}
	}
}
