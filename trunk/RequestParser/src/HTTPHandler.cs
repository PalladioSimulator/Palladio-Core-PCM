using System;
using System.Net.Sockets;

namespace RequestParser
{
	/// <summary>
	/// Zusammenfassung für HTTPHandler.
	/// </summary>
	public class HTTPHandler : IHandler
	{
		IHandler successor;
		public HTTPHandler()
		{
		}


		public IHandler Successor
		{
			get{return this.successor;}
			set{this.successor = value;}
		}

		public void HandleRequest(DateTime arrival,ref RequestProssor.RequestProzessorComponent pro,TcpClient da)
		{
			HTTPParser pars = null;
			//if(CheckResponsebility(request,client,arrival))
				pars = new HTTPParser(arrival,da, ref pro);

//			else
//				this.successor.HandleRequest(request,client,arrival,ref pro,da);
		}

		/// <summary>
		/// Cecks if this handler is responsible for this kind of request.
		/// The distinctive mark for handling is: request contains "HTTP/1.1"
		/// </summary>
		/// <param name="aRequest"></param>
		/// <returns></returns>
		private bool CheckResponsebility(string aRequest,NetworkStream cl,DateTime arr)
		{
			if(aRequest.IndexOf("HTTP")!=0)
			{
				
				return true;
			}
				
			return false;
		}
			

	}
}
