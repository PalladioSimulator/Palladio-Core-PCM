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
		/// <param name="webserverMonitor"></param>
		/// <returns></returns>
		IRequest CreateRequest(IWebserverMonitor webserverMonitor);


		/// <summary>
		/// Creates new HTTPRequest.
		/// </summary>
		/// <returns></returns>
		IHTTPRequest CreateHTTPRequest();
	}
}