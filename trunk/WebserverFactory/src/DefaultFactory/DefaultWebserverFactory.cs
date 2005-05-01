using System;
using Palladio.Webserver.BibTeXProvider;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.FTPRequestProcessor;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.HTTPRequestProcessorTools;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;
using Palladio.Webserver.HTTPRequestParser;

namespace Palladio.Webserver.WebserverFactory
{
	/// <summary>
	/// Encapsulates the creational process of the webserver-components.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.15  2005/05/01 17:23:26  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.14  2005/05/01 10:41:05  kelsaka
	/// - added gzip file compression
	///
	/// Revision 1.13  2005/04/30 12:38:24  kelsaka
	/// - extended cvs ignore lists
	/// - added first version of zip compressing request processor tools
	///
	/// Revision 1.12  2005/01/07 16:58:02  kelsaka
	/// Added TimeConsumingProcessor including its documentation and configuration.
	/// Integrated the new processor into the COR.
	///
	/// Revision 1.11  2004/12/18 10:06:48  kelsaka
	/// Added CVS-logs and some comments.
	///
	/// Revision 1.10  2004/12/15 00:32:33  sliver
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
	/// Revision 1.9  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.8  2004/11/21 17:10:04  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	/// Revision 1.7  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.6  2004/10/27 05:52:49  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.5  2004/10/25 06:35:51  kelsaka
	/// added XML-reading-abilities
	///
	/// Revision 1.4  2004/10/23 11:55:08  kelsaka
	/// added some parts of the building process
	///
	/// Revision 1.3  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.2  2004/10/22 14:18:17  kelsaka
	/// interface-update
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultWebserverFactory : IWebserverFactory
	{
		public DefaultWebserverFactory()
		{

		}

		#region Dispatcher

		/// <summary>
		/// Creates the DefaultDispatcher.
		/// </summary>
		/// <param name="requestParser">A component that fullfills the required-interface.</param>
		/// <returns>IDispatcher, using the services from the reqestParser.</returns>
		/// <param name="webserverMonitor">the monitor to use.</param>
		/// <param name="webserverConfiguration">the configuration to use.</param>
		/// <param name="requestFactory">Factory used to create requests.</param>
		/// <param name="portListenerFactory">Factory used to create new port listeners.</param>
		public IDispatcher CreateDispatcher (IRequestParser requestParser, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IRequestFactory requestFactory, IPortListenerFactory portListenerFactory)
		{
			return new DefaultDispatcher(requestParser, webserverMonitor, webserverConfiguration, requestFactory, portListenerFactory);
		}

		#endregion

		#region WebserverMonitor

		/// <summary>
		/// Creates a WebserverMonitor: a component for logging- and debuggin-features. 
		/// </summary>
		/// <returns></returns>
		public IWebserverMonitor CreateWebserverMonitor (IWebserverConfiguration webserverConfiguration)
		{
			return new DefaultWebserverMonitor(webserverConfiguration);
		}

		#endregion

		#region ConfigReader

		/// <summary>
		/// Creates a ConfigReader to get settings for the webserver.
		/// </summary>
		/// <returns></returns>
		public IConfigReader CreateConfigReader ()
		{
			return new XMLConfigReader();
		}

		#endregion

		#region RequestParsers



		/// <summary>
		/// Creates a HTTPRequestParser. This component can handle requests in a Chain Of Responsibility (COR).
		/// </summary>
		/// <param name="requestProcessor">The component used as HTTPRequestProcessor.</param>
		/// <param name="CorSuccessor">The successor in the COR to handle requests by using the IRequestParser-Interface.</param>
		/// <returns>HTTPRequestParser</returns>
		public IRequestParser CreateHTTPRequestParser (IHTTPRequestProcessor requestProcessor, IRequestParser CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IRequestFactory requestFactory)
		{
			return new HTTPRequestParser.HTTPRequestParser(requestProcessor, CorSuccessor, webserverMonitor, webserverConfiguration, requestFactory);
			
		}

		/// <summary>
		/// Creates a FTPRequestParser. This component can handle requests in a Chain Of Responsibility (COR).
		/// </summary>
		/// <param name="requestProcessor">The component used as FTPRequestProcessor.</param>
		/// <param name="CorSuccessor">The successor in the COR to handle requests by using the IRequestParser-Interface.</param>
		/// <returns>FTPRequestParser</returns>
		public IRequestParser CreateFTPRequestParser (IFTPRequestProcessor requestProcessor, IRequestParser CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			return new FTPRequestParser.FTPRequestParser(requestProcessor, CorSuccessor, webserverMonitor, webserverConfiguration);
		}

		/// <summary>
		/// This parser does not use other components as it catches errors on parsing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be parsed. It should be the last link in the COR.
		/// </summary>
		/// <returns>ErrorRequestParser</returns>
		public IRequestParser CreateDefaultRequestParser (IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			return new DefaultRequestParser(webserverMonitor, webserverConfiguration);
		}



		#endregion

		#region RequestProcessors

		/// <summary>
		/// Creates a TimeConsumingProcessor. This component is able to consume a defineable amount of time.
		/// </summary>
		/// <param name="corSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <param name="requestProcessorTools">General tools.</param>
		/// <returns>TimeConsumingProcessor</returns>
		public IHTTPRequestProcessor CreateTimeConsumingProcessor (IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			return new TimeConsumingProcessor.TimeConsumingProcessor(corSuccessor, webserverMonitor, webserverConfiguration, requestProcessorTools);
		}


		/// <summary>
		/// Creates a BibTeXProvider. This component makes a bibtex-db accessible.
		/// </summary>
		/// <param name="bibTexDB">The bibTexDB to use.</param>
		/// <param name="corSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <param name="requestProcessorTools">General tools.</param>
		/// <returns>BibTeXProvider</returns>
		public IHTTPRequestProcessor CreateBibTeXProvider (IBibTexDB bibTexDB, IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			return new BibTeXProvider.BibTeXProvider(bibTexDB, corSuccessor, webserverMonitor, webserverConfiguration, requestProcessorTools);
		}

		/// <summary>
		/// Creates a SimpleTemplateFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <returns>SimpleTemplateFileProvider</returns>
		public IHTTPRequestProcessor CreateSimpleTemplateFileProvider (IHTTPRequestProcessor CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			return new SimpleTemplateFileProvider.SimpleTemplateFileProvider(CorSuccessor, webserverMonitor, webserverConfiguration, requestProcessorTools);
		}


		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <returns>StaticFileProvider</returns>
		public IHTTPRequestProcessor CreateStaticFileProvider (IHTTPRequestProcessor CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			return new StaticFileProvider.StaticFileProvider(CorSuccessor, webserverMonitor, webserverConfiguration, requestProcessorTools);
		}

		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <returns>StaticFileProvider</returns>
		public IHTTPRequestProcessor CreateDynamicFileProvider (IHTTPRequestProcessor CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			return new DynamicFileProvider.DynamicFileProvider(CorSuccessor, webserverMonitor, webserverConfiguration, requestProcessorTools);
		}

		/// <summary>
		/// This processor does not use other components as it catches errors on processing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be processed. It should be the last link in the COR.
		/// </summary>
		/// <returns>DefaultRequestProcessor</returns>
		public IHTTPRequestProcessor CreateDefaultRequestProcessor (IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			return new HTTPRequestProcessor.DefaultHTTPRequestProcessor(webserverMonitor, webserverConfiguration, requestProcessorTools);
		}
		#endregion

		#region IHTTPRequestProcessorTools

		/// <summary>
		/// Creates new <c>IHTTPRequestProcessorTools</c>.
		/// </summary>
		/// <param name="webserverMonitor">The monitor to use.</param>
		/// <param name="webserverConfiguration">The configuration to use.</param>
		/// <returns>Default implementation that returns data to the client.</returns>
		public IHTTPRequestProcessorTools CreateRequestProcessorTools(IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			return new DefaultHTTPRequestProcessorTools(webserverMonitor, webserverConfiguration);
		}

		/// <summary>
		/// Creates IHTTPRequestProcessorTools that compresses the content to be sent to the client
		/// before passing it to the successor.
		/// </summary>
		/// <param name="successor">The successor to pass zipped content to.</param>
		/// <param name="webserverMonitor">The monitor zu use.</param>
		/// <returns>Content compressing IHTTPRequestProcessorTools.</returns>
		public IHTTPRequestProcessorTools CreateZipRequestProcessorTools (IHTTPRequestProcessorTools successor, IWebserverMonitor webserverMonitor)
		{
			return new ZipHTTPRequestProcessorTools.ZipHTTPRequestProcessorTools(successor, webserverMonitor);
		}

		#endregion

		#region WebserverConfiguration

		public IWebserverConfiguration CreateWebserverConfiguration(IConfigReader configReader, string pathToConfigFile, string xmlConfigFile)
		{
			IWebserverConfiguration webserverConfiguration = new WebserverConfiguration(
				configReader.ReadConfiguration(pathToConfigFile + xmlConfigFile));
			// Set the pathToConfigFile manually, because otherwise this would be a hen egg-problem: the
			// configuration-file can't (or shouldn't have to) know it own position:
			webserverConfiguration.ConfigFilesPath = pathToConfigFile;
			return webserverConfiguration;
		}

		#endregion

		#region BibTexDB

		public IBibTexDB CreateBibTexDB()
		{
			return new BibTexDB("");
		}

		#endregion
	}
}
