using Request;

namespace Delivery
{
	/// <summary>
	/// Zusammenfassung für IDeliveresponseHandler.
	/// </summary>
	public class ResponseHandlerQueue
	{
		private IResponseHandler handler;

		public ResponseHandlerQueue()
		{
			this.handler = new ResponseErrorHandler();
		}

		public void AddHandler(IResponseHandler r)
		{
			r.Sucessor = this.handler;
			this.handler = r;
		}

		//perhaps this ll  Work
		public IResponseHandler GetResponsibleHandler(HttpRequest r, string path)
		{
			return this.handler.GetResponsibleHandler(r, path);
		}
	}
}