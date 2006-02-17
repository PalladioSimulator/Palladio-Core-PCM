using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.WebserverFactory
{
	/// <summary>
	/// Creates a set of standard configurations of the webserver using
	/// the given factory.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.8  2004/11/21 17:10:04  kelsaka
	/// </pre>
	/// </remarks>
	public class WebserverConfigurator
	{
		/// <summary>
		/// Factory used for the construction of the webserver.
		/// </summary>
		private IWebserverFactory webserverFactory;

		private IRequestFactory requestFactory;

		/// <summary>
		/// (Relative) Path to the xml-config-file. All other settings should be read out from the xml-file.
		/// </summary>
		private const string DEFAULT_XML_CONFIGURATION_FILE = "WebserverXML.xml";

		/// <summary>
		/// Where the config-xml-file(s) can be found.
		/// </summary>
		private string pathToConfigFile;

		public WebserverConfigurator(IWebserverFactory webserverFactory, IRequestFactory requestFactory, string pathToConfigFile)
		{
			this.webserverFactory = webserverFactory;
			this.requestFactory = requestFactory;
			this.pathToConfigFile = pathToConfigFile;
		}

		public void CreateDefaultConfiguration()
		{
			IConfigReader configReader = webserverFactory.CreateConfigReader();
			IWebserverConfiguration webserverConfiguration = webserverFactory.CreateWebserverConfiguration(configReader, pathToConfigFile, DEFAULT_XML_CONFIGURATION_FILE);
			IWebserverMonitor webserverMonitor = webserverFactory.CreateWebserverMonitor(webserverConfiguration);

			IHTTPRequestProcessorTools requestProcessorTools = webserverFactory.CreateRequestProcessorTools(webserverMonitor, webserverConfiguration);


			// RequestProcessor-COR: Dynamic -> SimpleTemplate -> BibTeX -> Static -> Default.
			IHTTPRequestProcessor defaultHttpRequestProcessor = webserverFactory.CreateDefaultRequestProcessor(webserverMonitor, webserverConfiguration, requestProcessorTools);
			IHTTPRequestProcessor staticFileProvider = webserverFactory.CreateStaticFileProvider(defaultHttpRequestProcessor, webserverMonitor, webserverConfiguration, requestProcessorTools);
			IHTTPRequestProcessor bibTeXProvider = webserverFactory.CreateBibTeXProvider(staticFileProvider, webserverMonitor, webserverConfiguration, requestProcessorTools);
			IHTTPRequestProcessor simpleTemplateFileProver = webserverFactory.CreateSimpleTemplateFileProvider(bibTeXProvider, webserverMonitor, webserverConfiguration, requestProcessorTools);
			IHTTPRequestProcessor dynamicFileProvider = webserverFactory.CreateDynamicFileProvider(simpleTemplateFileProver, webserverMonitor, webserverConfiguration, requestProcessorTools);


			// RequestParser-COR: HTTP -> Default (currently FTP is not implemented)
			IRequestParser defaultRequestParser = webserverFactory.CreateDefaultRequestParser(webserverMonitor, webserverConfiguration);
			IRequestParser httpRequestParser = webserverFactory.CreateHTTPRequestParser(dynamicFileProvider, defaultRequestParser, webserverMonitor, webserverConfiguration, requestFactory);

			IDispatcher dispatcher = webserverFactory.CreateDispatcher(httpRequestParser, webserverMonitor, webserverConfiguration, requestFactory);
			dispatcher.Run();
		}

	}
}