using System;
using Request;

namespace RequestProssor.MonitorWebServer
{
	/// <summary>
	/// Zusammenfassung für RequestServedEventArgs.
	/// </summary>
	/// 
	public class RequestServedEventArgs:EventArgs
	{
		HttpRequest req;
		HttPResponse res;
		public RequestServedEventArgs(HttpRequest req, HttPResponse res)
		{
			this.req = req;
			this.res= res;
		}

		public HttpRequest ServedRequest
		{
			get{ return this.req;}
		}

		public HttPResponse ServedResponse
		{
			get{ return this.res;}
		}
	}
}
