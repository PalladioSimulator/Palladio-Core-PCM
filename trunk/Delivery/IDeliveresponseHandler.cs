using System;
using Request;

namespace Delivery
{
	/// <summary>
	/// Zusammenfassung für IDeliveresponseHandler.
	/// </summary>
	public class DeliveresponseHandler
	{
		IDeliverResponse handler;
		public DeliveresponseHandler()
		{
			this.handler = new ErrorHandler();
		}

		public void AddAditionalHandler(IDeliverResponse r)
		{
			r.Sucessor = this.handler;
			this.handler = r;
		}

		//perhaps this ll not Work
		public IDeliverResponse FixDeliverer(HttpRequest r,string path)
		{			
			return this.handler.DeliverResonse(r,path);		
		}
	}
}
