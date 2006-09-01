using System;
using System.IO;
using System.Text;
using Request;

namespace RequestProssor
{
	/// <summary>
	/// Sends a mesage to a client. This message is based on the HTTP-Prorocol. This class builds
	/// up the header of a message. The message itself is contained in the <c> HttPResponse </c>.
	/// This class is also able to send compressed content.
	/// </summary>
	public class Sender
	{
		protected HttpRequest currentRequest;
		protected HttpResponse currentResponse;
		protected string path;

		/// <summary>
		/// If is is true the message will ne compressed before sendig.
		/// </summary>
		protected bool zipRequested;


		/// <summary>
		/// Initiates a new Sender. And starts sending the response to the client.
		/// </summary>
		/// <param name="aRequest">The original request, which has to be answered.</param>
		/// <param name="aResponse">The response to the original request.</param>
		/// <param name="zipRequested">True if compressed sending is desired</param>
		public Sender(HttpRequest aRequest, HttpResponse aResponse, bool zipRequested)
		{
			this.currentRequest = aRequest;
			this.currentResponse = aResponse;
			this.zipRequested = zipRequested;

			if (zipRequested)
			{
				StartZipSending();
			}
			else
				StartSending();
		}


		/// <summary>
		/// Initates compressed sending.
		/// </summary>
		protected void StartZipSending()
		{
			//debug output
			Console.WriteLine("Zipped sending requested");

			MemoryStream outputMemStream = new MemoryStream();
			ICSharpCode.SharpZipLib.GZip.GZipOutputStream zipStream = new ICSharpCode.SharpZipLib.GZip.GZipOutputStream(outputMemStream);
			zipStream.Write(this.currentResponse.MessageByte, 0, this.currentResponse.MessageByte.Length);
			zipStream.Flush();

			zipStream.Close();
			byte[] zipAsByte = outputMemStream.ToArray();
			SendHeader(zipAsByte.Length, this.currentResponse.StatusCode);
			this.currentRequest.ClientSocket.Write(zipAsByte, 0, zipAsByte.Length);
			this.currentRequest.ClientSocket.Close();
			this.currentRequest.TcpClientOn.Close();
		}


		/// <summary>
		/// Starts non compressed sending.
		/// </summary>
		private void StartSending()
		{
			SendHeader(this.currentResponse.FileSize, this.currentResponse.StatusCode);
			SendToBrowser(this.currentResponse.MessageByte);
			this.currentRequest.ClientSocket.Close();
			this.currentRequest.TcpClientOn.Close();
		}


		/// <summary>
		/// Composes the header of the response message and sends it to the client. 
		/// </summary>
		/// <param name="iTotBytes">The size of the response message.</param>
		/// <param name="sStatusCode">The status of the response as string.</param>
		protected void SendHeader(int iTotBytes, string sStatusCode)
		{
			string dateTime = generateActualDate();
			String sBuffer = "";
			sBuffer = sBuffer + this.currentRequest.Protocol + this.currentResponse.StatusCode + "\r\n";
			sBuffer = sBuffer + "Date: " + DateTime.Now.ToString("r") + "\r\n";
			sBuffer = sBuffer + "Server: Yvettes Mini Server \r\n";
			sBuffer = sBuffer + "Accept-Ranges: bytes \r\n";
			sBuffer = sBuffer + "Content-Type: " + this.currentResponse.MineType + "\r\n";
			if (this.zipRequested)
			{
				sBuffer = sBuffer + "Content-Encoding: gzip  \r\n";
			}
			sBuffer = sBuffer + "Accept-Ranges: bytes\r\n";
			sBuffer = sBuffer + "Content-Length: " + iTotBytes + "\r\n\r\n";

			Byte[] bSendData = Encoding.ASCII.GetBytes(sBuffer);
			SendToBrowser(bSendData);
			Console.WriteLine("Total Bytes : " + iTotBytes.ToString());
		}


		/// <summary>
		/// Sends a message to a client.
		/// </summary>
		/// <param name="sData">The message which should be send 
		/// to the client in a string representation.</param>
		public void SendToBrowser(String sData)
		{
			SendToBrowser(Encoding.ASCII.GetBytes(sData));

		}


		/// <summary>
		/// Sends a message to a client.
		/// </summary>
		/// <param name="bSendData">The message which should be send 
		/// to the client in a byte[] representation.</param>
		public void SendToBrowser(Byte[] bSendData)
		{
			try
			{
				this.currentRequest.ClientSocket.Write(bSendData, 0, bSendData.Length);
			}
			catch (Exception  e)
			{
				Console.WriteLine("Error Occurred : {0} ", e);

			}
		}

		/// <summary>
		/// Generates the actual Server Date in the represtation of the RFC ???.
		/// </summary>
		/// <returns>A string which contains the actual server date.</returns>
		internal string generateActualDate()
		{
			string result = "";
			DateTime dt = DateTime.Now;
			return result;
		}
	}
}