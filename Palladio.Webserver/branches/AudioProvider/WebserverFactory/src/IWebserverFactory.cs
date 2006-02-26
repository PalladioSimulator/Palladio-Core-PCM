using System;
using Palladio.Webserver.BibTeXProvider;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.FTPRequestProcessor;
using Palladio.Webserver.HTTPRequestProcessorTools;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;

namespace Palladio.Webserver.WebserverFactory
{
	/// <summary>
	/// IWebserverFactory. Interface for the factory that is creating the webserver.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.15  2005/05/01 18:27:44  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.14  2005/05/01 17:23:26  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.13  2005/04/30 12:38:24  kelsaka
	/// - extended cvs ignore lists
	/// - added first version of zip compressing request processor tools
	///
	/// Revision 1.12  2005/01/07 16:58:02  kelsaka
	/// Added TimeConsumingProcessor including its documentation and configuration.
	/// Integrated the new processor into the COR.
	///
	/// Revision 1.11  2004/12/15 00:32:33  sliver
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
	/// Revision 1.10  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.9  2004/11/21 17:10:04  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	/// Revision 1.8  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.7  2004/10/27 05:52:49  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.6  2004/10/25 06:35:51  kelsaka
	/// added XML-reading-abilities
	///
	/// Revision 1.5  2004/10/23 11:55:08  kelsaka
	/// added some parts of the building process
	///
	/// Revision 1.4  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.3  2004/10/22 14:18:17  kelsaka
	/// interface-update
	///
	/// Revision 1.2  2004/10/22 12:55:56  kelsaka
	/// Actualised the UML-componentview; defined the webserverfactory-interface, therefore added some new interfaces
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public interface IWebserverFactory
	{
		#region Dispatcher

		/// <summary>
		/// Creates the DefaultDispatcher.
		/// </summary>
		/// <param name="requestParser">A component that fullfills the required-interface.</param>
		/// <param name="webserverMonitor">The monitor to use.</param>
		/// <param name="webserverConfiguration">The webser configuration to use.</param>
		/// <param name="requestFactory">The factory to create new requests with.</param>
		/// <param name="portListenerFactory">The factory to create new port listeners with.</param>
		/// <returns>IDispatcher, using the services from the reqestParser.</returns>
		IDispatcher CreateDispatcher(IRequestParser requestParser, IWebserverMonitor webserverMonitor,
			IWebserverConfiguration webserverConfiguration, IRequestFactory requestFactory,
			IPortListenerFactory portListenerFactory);

		#endregion

		#region WebserverMonitor

		/// <summary>
		/// Creates a WebserverMonitor: a component for logging- and debuggin-features. 
		/// </summary>
		/// <param name="webserverConfiguration">The webserver configuration.</param>
		/// <returns>a new <see cref="IWebserverMonitor"/>.</returns>
		IWebserverMonitor CreateWebserverMonitor(IWebserverConfiguration webserverConfiguration);

		#endregion

		#region ConfigReader

		/// <summary>
		/// Creates a ConfigReader to get settings for the webserver.
		/// </summary>
		/// <returns>new instance of <see cref="IConfigReader"/></returns>
		IConfigReader CreateConfigReader();


		#endregion

		#region RequestParsers

		/// <summary>
		/// Creates a HTTPRequestParser. This component can handle requests in a Chain Of Responsibility (COR).
		/// </summary>
		/// <param name="requestProcessor">The component used as HTTPRequestProcessor.</param>
		/// <param name="CorSuccessor">The successor in the COR to handle requests by using the IRequestParser-Interface.</param>
		/// <returns>HTTPRequestParser</returns>
		IRequestParser CreateHTTPRequestParser(IHTTPRequestProcessor requestProcessor, IRequestParser CorSuccessor,
			IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IRequestFactory requestFactory);

		/// <summary>
		/// Creates a FTPRequestParser. This component can handle requests in a Chain Of Responsibility (COR).
		/// </summary>
		/// <param name="requestProcessor">The component used as FTPRequestProcessor.</param>
		/// <param name="CorSuccessor">The successor in the COR to handle requests by using the IRequestParser-Interface.</param>
		/// <returns>FTPRequestParser</returns>
		IRequestParser CreateFTPRequestParser(IFTPRequestProcessor requestProcessor, IRequestParser CorSuccessor, 
			IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration);

		/// <summary>
		/// This parser does not use other components as it catches errors on parsing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be parsed. It should be the last link in the COR.
		/// </summary>
		/// <returns>ErrorRequestParser</returns>
		IRequestParser CreateDefaultRequestParser(IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration);

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
		IHTTPRequestProcessor CreateTimeConsumingProcessor(IHTTPRequestProcessor corSuccessor,
			IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration,
			IHTTPRequestProcessorTools requestProcessorTools);

		/// <summary>
		/// Creates a BibTeXProvider. This component makes a bibtex-db accessible.
		/// </summary>
		/// <param name="bibTexDB">The bibtex db to use.</param>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <param name="requestProcessorTools">Tools to use for processing the request.</param>
		/// <returns>BibTeXProvider</returns>
		IHTTPRequestProcessor CreateBibTeXProvider(IBibTexDB bibTexDB, IHTTPRequestProcessor CorSuccessor,
			IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration,
			IHTTPRequestProcessorTools requestProcessorTools);

		/// <summary>
		/// Creates a SimpleTemplateFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <param name="requestProcessorTools">Tools to use for processing the request.</param>
		/// <returns>SimpleTemplateFileProvider</returns>
		IHTTPRequestProcessor CreateSimpleTemplateFileProvider(IHTTPRequestProcessor CorSuccessor,
			IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration,
			IHTTPRequestProcessorTools requestProcessorTools);

		/// <summary>
		/// Creates a SimpleTemplateFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <param name="requestProcessorTools">Tools to use for processing the request.</param>
		/// <returns>SimpleTemplateFileProvider</returns>
		IHTTPRequestProcessor CreateAudioFileProvider(IHTTPRequestProcessor CorSuccessor,
			IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration,
			IHTTPRequestProcessorTools requestProcessorTools);

		
		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <param name="requestProcessorTools">Tools to use for processing the request.</param>
		/// <returns>StaticFileProvider</returns>
		IHTTPRequestProcessor CreateStaticFileProvider(IHTTPRequestProcessor CorSuccessor,
			IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration,
			IHTTPRequestProcessorTools requestProcessorTools);

		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="requestProcessorTools">Tools to use for processing the request.</param>
		/// <returns>StaticFileProvider</returns>
		IHTTPRequestProcessor CreateDynamicFileProvider(IHTTPRequestProcessor CorSuccessor,
			IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration,
			IHTTPRequestProcessorTools requestProcessorTools);

		/// <summary>
		/// This processor does not use other components as it catches errors on processing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be processed. It should be the last link in the COR.
		/// </summary>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <param name="requestProcessorTools">Tools to use for processing the request.</param>
		/// <returns>DefaultRequestProcessor</returns>
		IHTTPRequestProcessor CreateDefaultRequestProcessor(IWebserverMonitor webserverMonitor,
			IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools);

		#endregion

		#region HTTPRequestProcessorTools

		/// <summary>
		/// Creates new <c>IHTTPRequestProcessorTools</c>.
		/// </summary>
		/// <param name="webserverMonitor">The monitor to use.</param>
		/// <param name="webserverConfiguration">The configuration to use.</param>
		/// <returns>Default implementation that returns data to the client.</returns>
		IHTTPRequestProcessorTools CreateRequestProcessorTools(IWebserverMonitor webserverMonitor,
			IWebserverConfiguration webserverConfiguration);

		/// <summary>
		/// Creates IHTTPRequestProcessorTools that compresses the content to be sent to the client
		/// before passing it to the successor.
		/// </summary>
		/// <param name="successor">The successor to pass zipped content to.</param>
		/// <param name="webserverMonitor">The monitor zu use.</param>
		/// <returns>Content compressing IHTTPRequestProcessorTools.</returns>
		IHTTPRequestProcessorTools CreateZipRequestProcessorTools(IHTTPRequestProcessorTools successor,
			IWebserverMonitor webserverMonitor);

		#endregion

		#region WebserverConfiguration

		/// <summary>
		/// Creates new <c>IWebserverConfiguration</c>.
		/// </summary>
		/// <param name="configReader">The component to use for reading xml config files.</param>
		/// <param name="pathToConfigFile">The path to the config file of the webserver.</param>
		/// <param name="xmlConfigFile">The filename of the config file of the webserver.</param>
		/// <returns>The configuration.</returns>
		IWebserverConfiguration CreateWebserverConfiguration(IConfigReader configReader,
			string pathToConfigFile, string xmlConfigFile);

		#endregion

		#region BibTexDB

		/// <summary>
		/// Creates a new <see cref="IBibTexDB"/>, which offers acces to bibtex data.
		/// </summary>
		/// <returns>A new IBibTexDB instance.</returns>
		IBibTexDB CreateBibTexDB();

		#endregion

	}
}
