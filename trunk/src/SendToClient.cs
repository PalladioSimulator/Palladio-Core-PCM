using System;
using System.Net.Sockets;
using System.IO;
using System.Text;

namespace MySmallWebServer
{
	/// <summary>
	/// This class sends the response to the client
	/// </summary>
	public class SendToClient
	{
		/// <summary>
		/// The message which should be sended to the client as <code>string</code>
		/// </summary>
		protected string message;

		/// <summary>
		/// The generated response in a <code>AbstractResponse</code>
		/// </summary>
		protected ClientResponse cr;

		/// <summary>
		/// The constructor its initaited which a <code>AbstractResponse</code>
		/// </summary>
		/// <param name="r">The <code>AbstractResponse</code></param>
		public SendToClient(ClientResponse r)
		{
			this.cr = r;
			Console.WriteLine("Der Response :"+this.cr.ToString());
		}


		/// <summary>
		/// An empty constructor
		/// </summary>
		public SendToClient()
		{
		}
		
		/// <summary>
		/// This sends a error message to the client
		/// </summary>
		/// <param name="kindOfError">A <code>string</code> which contains 
		/// the error message.</param>
		/// <param name="httpCode">The HTTP protocol as <code>string</code></param>
		/// <param name="r">An <code>AbstractResponse</code> which should be answered
		/// with an errror</param>
		public void sendError(string kindOfError, string httpCode,ClientResponse r)
		{
			Console.WriteLine("send Error");
			Console.WriteLine(r.ClientRequest.Protocol);
			SendErrorHeader(r.ClientRequest.Protocol.ToString(),  "text/html", kindOfError.Length, httpCode , r.ClientRequest.ClientSocket);
			SendToBrowser (kindOfError, r.ClientRequest.ClientSocket);
			Console.WriteLine("Closing Connection");
			r.ClientRequest.ClientSocket.Close();
			return;
		}


		/// <summary>
		/// The default way to answer a request.
		/// </summary>
		public void SendResponse()
		{
			
			if(this.cr.ClientRequest.RequestedMethod is GetMethod)
			{
				SendHeader();
				SendMessage();
			}
			if(this.cr.ClientRequest.RequestedMethod is HeadMethod)
			{
				SendHeader();
			}
			if(this.cr.ClientRequest.RequestedMethod is PostMethod)
	       {		
				SendHeader();
				SendMessage();
			}
			else
				;
			}


		/// <summary>
		/// Sends a error Header to the client
		/// </summary>
		/// <param name="sHttpVersion">The http protocol as <code>string</code></param>
		/// <param name="sMIMEHeader">The mine type as <code>string</code></param>
		/// <param name="iTotBytes">An <code>int</code> which contains the size of the message</param>
		/// <param name="sStatusCode">The status code as <code>string</code></param>
		/// <param name="mySocket">The <code>Socket</code> on which the client is connected</param>
		public void SendErrorHeader(string sHttpVersion, string sMIMEHeader, int iTotBytes, string sStatusCode,Socket mySocket)
		{
			String sBuffer = "";	
			// if Mime type is not provided set default to text/html
			//			if (sMIMEHeader.Length == 0 )
			if (sMIMEHeader == "" )
			{
				sMIMEHeader = "text/html";  // Default Mime Type is text/html
			}
			sBuffer = sBuffer + sHttpVersion + sStatusCode + "\r\n";
			sBuffer = sBuffer + "Server: Mogli-Server c\r\n";
			sBuffer = sBuffer + "Content-Type: " + sMIMEHeader + "\r\n";
			sBuffer = sBuffer + "Accept-Ranges: bytes\r\n";
			sBuffer = sBuffer + "Content-Length: " + iTotBytes + "\r\n\r\n";
			Console.WriteLine("Das wird gesendet: "+sBuffer);
			Byte[] bSendData = Encoding.ASCII.GetBytes(sBuffer); 
			SendToBrowser(bSendData, mySocket);
			Console.WriteLine("Total Bytes : " + iTotBytes.ToString());
		}

		/// <summary>
		/// Send an error to the client
		/// </summary>
		/// <param name="error">A <code>string</code> which contains the error message</param>
		/// <param name="cr"></param>
		public void sendError(string error,ClientResponse cr)
		{
			Console.WriteLine("send Error");
			Console.WriteLine("Mesage: "+error);
			SendHeader(cr, error.Length);
			SendToBrowser(error, cr.ClientRequest.ClientSocket);
			Console.WriteLine("Closing Connection");
			cr.ClientRequest.ClientSocket.Close();
		}


		/// <summary>
		/// Sends the default header to the client.
		/// </summary>
		public void SendHeader()
		{
//			Console.WriteLine("Datei: "+cr.MessageToSend);
			string generatedMessage = this.cr.ClientRequest.Protocol+ cr.StatusCode +"\r\n";
			generatedMessage = generatedMessage + "Server: Mogli-Server c\r\n";
			generatedMessage = generatedMessage + "Content-Type: "+cr.MineType +"\r\n";
//			generatedMessage = generatedMessage + "Accept-Ranges: bytes\r\n";
			generatedMessage = generatedMessage + "Content-Length: " +cr.MessageToSend.Length+ "\r\n\r\n";
			Console.WriteLine("Generated Message: "+generatedMessage);
			Byte[] bSendData = Encoding.ASCII.GetBytes(generatedMessage);
			SendToBrowser( bSendData,cr.ClientRequest.ClientSocket);
		}

		/// <summary>
		/// Sends the file to the browser
		/// </summary>
		/// <param name="dd">The gernated <code>AbstractResponse</code> for the client request</param>
		/// <param name="iTotBytes">An <code>int</code> which contains the size of the message</param>
		public void SendHeader(ClientResponse dd, int iTotBytes)
		{					
			String sBuffer = "";
			// if Mime type is not provided set default to text/html
			//			if (sMIMEHeader.Length == 0 )
			string mine = dd.MineType;
			if (mine =="" )
			{
				mine = "text/html";  // Default Mime Type is text/html
			}
			Console.WriteLine("Mine "+dd.MineType);
			sBuffer = sBuffer + dd.ClientRequest.Protocol + dd.StatusCode + "\r\n";
			sBuffer = sBuffer + "Server: Mogli-Server c\r\n";
			sBuffer = sBuffer + "Content-Type: " + mine + "\r\n";
//			sBuffer = sBuffer + "Accept-Ranges: bytes\r\n";
			sBuffer = sBuffer + "Content-Length: " + iTotBytes + "\r\n\r\n";
			Console.WriteLine("Das soll gesendet werden. "+sBuffer);
			Byte[] bSendData = Encoding.ASCII.GetBytes(sBuffer); 
			SendToBrowser( bSendData, dd.ClientRequest.ClientSocket);
			Console.WriteLine("Total Bytes : " + iTotBytes.ToString());
		}


		/// <summary>
		/// Sends a message to the browser (Default way)
		/// </summary>
		public void SendMessage()
		{
			this.SendToBrowser(cr.MessageToSend,cr.ClientRequest.ClientSocket);
		}
		

		/// <summary>
		///Sends data to the browser format.
		/// </summary>
		/// <param name="sData">A <code>string</code> which contains the message</param>
		/// <param name="mySocket">The <code>Socket</code> on which the client listens</param>
		public void SendToBrowser(String sData, Socket mySocket)
		{
			SendToBrowser (Encoding.ASCII.GetBytes(sData),  mySocket);
		}


		/// <summary>
		/// Sends data to the client in the right format.
		/// </summary>
		/// <param name="bSendData">A <code>Byte[]</code>< which contains the data/param>
		/// <param name="mySocket">The <code>Socket</code> on which the client listens</param>
		public void SendToBrowser(Byte[] bSendData, Socket mySocket)
		{
			
			int numBytes = 0;
			
			try
			{
				if (mySocket.Connected)
				{
					if (( numBytes = mySocket.Send(bSendData, bSendData.Length,0)) == -1)
						Console.WriteLine("Socket Error cannot Send Packet");
					else
					{
						Console.WriteLine("No. of bytes send {0}" , numBytes);
					}
				}
				else
					Console.WriteLine("Connection Dropped....");
			}
			catch (Exception  e)
			{
				Console.WriteLine("Error Occurred : {0} ", e );
							
			}
		}


	}
}
