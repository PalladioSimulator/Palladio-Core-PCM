using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// IRequestFactory. Creates the different types of Request: IRequest: general request and IHTTPRequest http-request.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/04/30 12:38:24  kelsaka
	/// - extended cvs ignore lists
	/// - added first version of zip compressing request processor tools
	///
	/// Revision 1.2  2005/01/29 21:47:44  kelsaka
	/// Added continuous use of NetworkStream (instead of Socket)
	///
	/// Revision 1.1  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	///
	///
	/// </pre>
	/// </remarks>
	public interface IRequestFactory
	{
		/// <summary>
		/// Creates new request.
		/// </summary>
		/// <param name="webserverMonitor">The monitor to use.</param>
		/// <returns>A new <see cref="IRequest"/>.</returns>
		IRequest CreateRequest(IWebserverMonitor webserverMonitor);


		/// <summary>
		/// Creates new HTTPRequest.
		/// </summary>
		/// <returns>The new instance.</returns>
		IHTTPRequest CreateHTTPRequest();
	}
}