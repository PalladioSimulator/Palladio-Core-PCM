using System;
using Request;

namespace RequestProssor.MonitorWebServer
{
	/// <summary>
	/// Zusammenfassung für RequestServedEventArgs.
	/// </summary>
	/// 
	public class RequestServedEventArgs : EventArgs
	{
		private HttpRequest req;
		private HttpResponse res;

		public RequestServedEventArgs(HttpRequest req, HttpResponse res)
		{
			this.req = req;
			this.res = res;
		}

		public HttpRequest ServedRequest
		{
			get { return this.req; }
		}

		public HttpResponse ServedResponse
		{
			get { return this.res; }
		}
	}
}