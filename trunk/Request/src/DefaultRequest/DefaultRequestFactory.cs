using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// DefaultRequestFactory. Offers methods to create a HTTPRequest.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/01/07 16:58:02  kelsaka
	/// Added TimeConsumingProcessor including its documentation and configuration.
	/// Integrated the new processor into the COR.
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
	public class DefaultRequestFactory : IRequestFactory
	{
		public DefaultRequestFactory()
		{
		}

		public IRequest CreateRequest(IWebserverMonitor webserverMonitor)
		{
			return new DefaultRequest(webserverMonitor);
		}

		public IHTTPRequest CreateHTTPRequest()
		{
			return new DefaultHTTPRequest();
		}
	}
}