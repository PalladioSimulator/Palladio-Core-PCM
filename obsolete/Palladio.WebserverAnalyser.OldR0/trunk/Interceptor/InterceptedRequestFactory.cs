using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.WebserverAnalyser.Interceptor
{
	/// <summary>
	/// Decorator for <c>IRequestFactory</c>. Wrapps each object with an interceptor.
	/// </summary>
	public class InterceptedRequestFactory : IRequestFactory
	{

		IRequestFactory factory;

		public InterceptedRequestFactory(IRequestFactory factory)
		{
			this.factory = factory;
		}
		
		public IRequest CreateRequest(IWebserverMonitor webserverMonitor)
		{
			IRequest request = factory.CreateRequest(webserverMonitor);
			return new RequestInterceptor(request);
		}

		public IHTTPRequest CreateHTTPRequest()
		{
			IHTTPRequest request = factory.CreateHTTPRequest();
			return new HTTPRequestInterceptor(request);
		}

	}
}
