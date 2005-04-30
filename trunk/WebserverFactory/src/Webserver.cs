using System;
using System.IO;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.FTPRequestProcessor;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
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
	/// Revision 1.5  2005/04/30 12:38:24  kelsaka
	/// - extended cvs ignore lists
	/// - added first version of zip compressing request processor tools
	///
	/// Revision 1.4  2005/04/25 13:20:27  kelsaka
	/// - fixed wrong order in CoR: Templates were not handled any more
	///
	/// Revision 1.3  2005/04/14 13:44:34  sliver
	/// *** empty log message ***
	///
	/// Revision 1.2  2005/01/07 16:58:02  kelsaka
	/// Added TimeConsumingProcessor including its documentation and configuration.
	/// Integrated the new processor into the COR.
	///
	/// Revision 1.1  2004/12/15 00:32:33  sliver
	/// Thread handling changed:
	///   Instead of calling the Thread.Abort() method, each
	///   thread instance contains a variable IsRunning which is
	///   checked after each iteration through the loop.
	///   If it is set to false, the tread terminates. This has been introduced to
	///   establish a clean thread exit. The call of the Abort () method causes
	///   an exeption in the aborted thread. This execption is forwarded through
	///   the whole call stack, even if it is catched. So, every method on the stack
	///   is informed about the thread exit. However, this causes some trouble
	///   for the logging of the Webserver behaviour. Furthermore, the
	///   Thread.Abort() and Thread.Interrupt() methods do not terminate
	///   threads that are blocked. The call of the method TcpListener.AcceptSocket()
	///   blocks the thread until a new connection is opened. So, the running
	///   threads are not aborted until a new connection is opened.
	///
	///  Now, we proceed as follows to terminate the Webserver. For all
	///  listening treads, we set the IsRunning variable to false. Next, we need
	///  to unblock the threads. Therfore, we open a dummy connection to the
	///  IP and port the tread is listening on. When re-iterating the the loop, the
	///  check of the IsRunning variable causes the thread to terminate.
	///
	/// ListeningTread war renamed to PortListener
	/// interfaces 'IPortListener' and IBibTexDB' added
	///
	/// Revision 1.15  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
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

		private IConfigReader configReader;
		private IWebserverConfiguration webserverConfiguration;
		private IWebserverMonitor webserverMonitor;
		private IHTTPRequestProcessorTools requestProcessorTools;
		private IHTTPRequestProcessor[] httpRequestProcessors;
		private IRequestParser[] requestParsers;
		public IDispatcher dispatcher;


		public IConfigReader ConfigReader
		{
			get { return configReader; }
		}

		public IWebserverConfiguration WebserverConfiguration
		{
			get { return webserverConfiguration; }
		}

		public IWebserverMonitor WebserverMonitor
		{
			get { return webserverMonitor; }
		}

		public IHTTPRequestProcessorTools RequestProcessorTools
		{
			get { return requestProcessorTools; }
		}

		public IHTTPRequestProcessor[] HttpRequestProcessors
		{
			get { return httpRequestProcessors; }
		}

		public IRequestParser[] RequestParsers
		{
			get { return requestParsers; }
		}

		public IDispatcher Dispatcher
		{
			get { return dispatcher; }
		}


		/// <summary>
		/// Hide the default constructor.
		/// </summary>
		private Webserver() {}


		/// <summary>
		/// Starts the server.
		/// </summary>
		public void Start()
		{
			webserverMonitor.InitializeWriteAccess();
			dispatcher.Start();
		}

		public void Stop()
		{
			dispatcher.Stop();
			webserverMonitor.FinishWriteAccess();
		}

		public static Webserver CreateDefaultConfiguration(IWebserverFactory webserverFactory, IRequestFactory requestFactory, IPortListenerFactory portListenerFactory, string pathToConfigFile, string xmlConfigFile)
		{
			Webserver webserver = new Webserver();
			webserver.configReader = webserverFactory.CreateConfigReader();
			webserver.webserverConfiguration = webserverFactory.CreateWebserverConfiguration(webserver.configReader, pathToConfigFile, xmlConfigFile);
			webserver.webserverMonitor = webserverFactory.CreateWebserverMonitor(webserver.webserverConfiguration);

			
			webserver.requestProcessorTools = webserverFactory.CreateRequestProcessorTools(webserver.webserverMonitor, webserver.webserverConfiguration);


			// RequestProcessor-COR: TimeConsuming -> Dynamic -> SimpleTemplate -> BibTeX -> Static -> Default.
			webserver.httpRequestProcessors = new IHTTPRequestProcessor[6];
			webserver.httpRequestProcessors[0] = webserverFactory.CreateDefaultRequestProcessor(webserver.webserverMonitor, webserver.webserverConfiguration, webserver.requestProcessorTools);
			webserver.httpRequestProcessors[1] = webserverFactory.CreateStaticFileProvider(webserver.httpRequestProcessors[0], webserver.webserverMonitor, webserver.webserverConfiguration, webserver.requestProcessorTools);
			webserver.httpRequestProcessors[2] = webserverFactory.CreateBibTeXProvider(webserverFactory.CreateBibTexDB(), webserver.httpRequestProcessors[1], webserver.webserverMonitor, webserver.webserverConfiguration, webserver.requestProcessorTools);
			webserver.httpRequestProcessors[3] = webserverFactory.CreateSimpleTemplateFileProvider(webserver.httpRequestProcessors[2], webserver.webserverMonitor, webserver.webserverConfiguration, webserver.requestProcessorTools);
			webserver.httpRequestProcessors[4] = webserverFactory.CreateDynamicFileProvider(webserver.httpRequestProcessors[3], webserver.webserverMonitor, webserver.webserverConfiguration, webserver.requestProcessorTools);


			// RequestParser-COR: HTTP -> Default (currently FTP is not implemented)
			webserver.requestParsers = new IRequestParser[2];
			webserver.requestParsers[0] = webserverFactory.CreateDefaultRequestParser(webserver.webserverMonitor, webserver.webserverConfiguration);
			webserver.requestParsers[1] = webserverFactory.CreateHTTPRequestParser(webserver.httpRequestProcessors[4], webserver.requestParsers[0], webserver.webserverMonitor, webserver.webserverConfiguration, requestFactory);

			webserver.dispatcher = webserverFactory.CreateDispatcher(webserver.requestParsers[1], webserver.webserverMonitor, webserver.webserverConfiguration, requestFactory, portListenerFactory);
			return webserver;
		}
	}
}
