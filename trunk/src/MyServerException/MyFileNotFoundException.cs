using System;

namespace MySmallWebServer.MyServerException
{
	/// <summary>
	/// This is thrown when the the requested file has not been found.
	/// </summary>
	public class MyFileNotFoundException : MyFatalServerException
	{
		/// <summary>
		/// This is thrown when the the requested file has not been found.
		/// </summary>
		/// <param name="r">The <code>ClientResponse</code> which requested has not been found</param>
		public MyFileNotFoundException(ClientResponse r)
		{
			string Message="<h2> The requested File was not found :-)</h2>";
			SendToClient sender = new SendToClient();
			Console.WriteLine(r.ToString());
			sender.sendError(Message," 404 File Not Found ",r);
		}
	}
}
