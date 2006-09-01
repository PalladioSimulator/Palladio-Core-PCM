using System;

namespace MySmallWebServer.MyServerException
{
	/// <summary>
	/// MyExternalException is thrown when a error in an external application happpens.
	/// </summary>
	public class MyExternalException : MyFatalServerException
	{

		/// <summary>
		/// Is thrown when an error in an external application happpens
		/// </summary>
		/// <param name="r">The response on which module the error happend</param>
		public MyExternalException(ClientResponse r)
		{
			string Message="<h2> We are sorry a external error</h2>";
			SendToClient sender = new SendToClient(r);
			Console.WriteLine(r.ToString());
			sender.sendError(Message," 505 Internal Server Error ",r);
		}
	}
}
