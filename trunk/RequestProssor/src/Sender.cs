using System;
using Request;
using System.Net.Sockets;
using System.IO;
using System.Text;

using ICSharpCode.SharpZipLib.Checksums;
using ICSharpCode.SharpZipLib.Zip.Compression;
using ICSharpCode.SharpZipLib.Zip.Compression.Streams;

namespace RequestProssor
{
	/// <summary>
	/// Zusammenfassung für Sender.
	/// </summary>
	public class Sender
	{
		private HttpRequest request;
		private HttPResponse response;
		private string path;
		protected bool zipRequested;

		public Sender(HttpRequest req,HttPResponse res,bool zipRequested)
		{
			this.request = req;
			this.response = res;
			this.zipRequested = zipRequested;

			if(zipRequested)
			{
				//this.response.MineType ="gzip";
				StartZipSending();
			}
			else
				StartSending();
		}

		private void StartZipSending()
		{
			Console.WriteLine("Zipped sending requested");
			
			MemoryStream outputMemStream = new MemoryStream(); 
			ICSharpCode.SharpZipLib.GZip.GZipOutputStream zipStream = new ICSharpCode.SharpZipLib.GZip.GZipOutputStream(outputMemStream);
			zipStream.Write(this.response.MessageByte,0,this.response.MessageByte.Length);
			zipStream.Flush();

			zipStream.Close();
			byte [] zipAsByte = outputMemStream.ToArray();
			SendHeader(zipAsByte.Length,this.response.StatusCode);
			this.request.ClientSocket.Write(zipAsByte,0,zipAsByte.Length);
			this.request.ClientSocket.Close();
			this.request.TcpClientOn.Close();
		}
		private void StartSending()
		{
			SendHeader(this.response.FileSize,this.response.StatusCode);
			SendToBrowser(this.response.MessageByte);

			this.request.ClientSocket.Close();
			this.request.TcpClientOn.Close();
		}	

		public void SendHeader(int iTotBytes, string sStatusCode)
		{

			string dateTime = generateActualDate();
			String sBuffer = "";
			sBuffer = sBuffer + this.request.Protocol + this.response.StatusCode + "\r\n";
			sBuffer = sBuffer + "Date: "+ DateTime.Now.ToString("r")+"\r\n";
			sBuffer = sBuffer + "Server: Yvettes Mini Server \r\n";
			sBuffer = sBuffer + "Accept-Ranges: bytes \r\n";
			sBuffer = sBuffer + "Content-Type: " + this.response.MineType + "\r\n";
			if(this.zipRequested)
			{
				sBuffer = sBuffer + "Content-Encoding: gzip  \r\n"; 
			}
			sBuffer = sBuffer + "Accept-Ranges: bytes\r\n";
			sBuffer = sBuffer + "Content-Length: " + iTotBytes + "\r\n\r\n";
			
			Byte[] bSendData = Encoding.ASCII.GetBytes(sBuffer); 

			SendToBrowser( bSendData);

			Console.WriteLine("Total Bytes : " + iTotBytes.ToString());

		}

		public void SendToBrowser(String sData)
		{
			SendToBrowser (Encoding.ASCII.GetBytes(sData));
			
		}

		public void SendToBrowser(Byte[] bSendData)
		{
			try
			{
				this.request.ClientSocket.Write(bSendData,0,bSendData.Length);
			}
			catch (Exception  e)
			{
				Console.WriteLine("Error Occurred : {0} ", e );
							
			}
		}

		internal string generateActualDate()
		{
			string result ="";
			DateTime dt = DateTime.Now;
			return result;
		}

//		public static void Main()  
//		{
//
//			// Displays the values of the pattern properties.
//			Console.WriteLine( " CULTURE    PROPERTY VALUE" );
//			PrintPattern( "en-US" );
//			PrintPattern( "ja-JP" );
//			PrintPattern( "fr-FR" );
//
//		}
//
//		public static void PrintPattern( String myCulture )  
//		{
//
//			DateTimeFormatInfo myDTFI = new CultureInfo( myCulture, false ).DateTimeFormat;
//			Console.WriteLine( "  {0}     {1}", myCulture, myDTFI.RFC1123Pattern );
//
//		}


	}
}
