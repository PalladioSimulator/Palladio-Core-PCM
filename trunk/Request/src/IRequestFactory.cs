using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// IRequestFactory.
	/// </summary>
	/// 
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