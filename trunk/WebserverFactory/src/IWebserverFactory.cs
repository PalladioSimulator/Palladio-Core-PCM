using System;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.FTPRequestProcessor;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;

namespace Palladio.Webserver.WebserverFactory
{
	/// <summary>
	/// IWebserverFactory.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
		/// <returns>IDispatcher, using the services from the reqestParser.</returns>
		IDispatcher CreateDispatcher(IRequestParser requestParser, IWebserverMonitor webserverMonitor, IConfigReader configReader);

		#endregion

		#region WebserverMonitor

		/// <summary>
		/// Creates a WebserverMonitor: a component for logging- and debuggin-features. 
		/// </summary>
		/// <returns></returns>
		IWebserverMonitor CreateWebserverMonitor(IWebserverConfiguration webserverConfiguration);

		#endregion

		#region ConfigReader

		/// <summary>
		/// Creates a ConfigReader to get settings for the webserver.
		/// </summary>
		/// <returns></returns>
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
			IWebserverMonitor webserverMonitor, IConfigReader configReader);


		/// <summary>
		/// Creates a FTPRequestParser. This component can handle requests in a Chain Of Responsibility (COR).
		/// </summary>
		/// <param name="requestProcessor">The component used as FTPRequestProcessor.</param>
		/// <param name="CorSuccessor">The successor in the COR to handle requests by using the IRequestParser-Interface.</param>
		/// <returns>FTPRequestParser</returns>
		IRequestParser CreateFTPRequestParser(IFTPRequestProcessor requestProcessor, IRequestParser CorSuccessor, 
			IWebserverMonitor webserverMonitor, IConfigReader configReader);


		/// <summary>
		/// This parser does not use other components as it catches errors on parsing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be parsed. It should be the last link in the COR.
		/// </summary>
		/// <returns>ErrorRequestParser</returns>
		IRequestParser CreateDefaultRequestParser(IWebserverMonitor webserverMonitor, IConfigReader configReader);

		#endregion

		#region RequestProcessors

		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <returns>StaticFileProvider</returns>
		IHTTPRequestProcessor CreateStaticFileProvider(IHTTPRequestProcessor CorSuccessor, IWebserverMonitor webserverMonitor, IConfigReader configReader);


		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <returns>StaticFileProvider</returns>
		IHTTPRequestProcessor CreateDynamicFileProvider(IHTTPRequestProcessor CorSuccessor, IWebserverMonitor webserverMonitor, IConfigReader configReader);


		/// <summary>
		/// This processor does not use other components as it catches errors on processing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be processed. It should be the last link in the COR.
		/// </summary>
		/// <returns>DefaultRequestProcessor</returns>
		IHTTPRequestProcessor CreateDefaultRequestProcessor(IWebserverMonitor webserverMonitor, IConfigReader configReader);

		#endregion

	}
}
