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

		public Sender(HttpRequest req,HttPResponse res,bool zipRequested)
		{
			this.request = req;
			this.response = res;

			if(zipRequested)
				StartZipSending();
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
			byte[] zipAsByte = new byte[outputMemStream.Length];
			outputMemStream.Read(zipAsByte,0,zipAsByte.Length);
			Console.WriteLine(Encoding.ASCII.GetChars(zipAsByte));
			SendHeader(zipAsByte.Length,this.response.StatusCode);
			this.request.ClientSocket.Write(zipAsByte,0,zipAsByte.Length);
			zipStream.Close();
			
	
			////		Stream s = new GZipOutputStream(File.Create(args[0] + ".gz"));
			/// 		FileStream fs = File.OpenRead(args[0]);
			/// 		byte[] writeData = new byte[fs.Length];
			/// 		fs.Read(writeData, 0, (int)fs.Length);
			/// 		s.Write(writeData, 0, writeData.Length);
			/// 		s.Close();
		
		
			this.request.ClientSocket.Close();
			this.request.TcpClientOn.Close();

			//			FileStream fs = File.OpenRead(args[0]);
			//			byte[] writeData = new byte[fs.Length];
			//			fs.Read(writeData, 0, (int)fs.Length);
			//			s.Write(writeData, 0, writeData.Length);
			//			s.Close();
		}
		private void StartSending()
		{
			SendHeader(this.response.FileSize,this.response.StatusCode);
			SendToBrowser(this.response.MessageByte);

			this.request.ClientSocket.Close();
			this.request.TcpClientOn.Close();
			//			int iTotBytes=0;
			//			string sResponse ="";
			//
			//			FileStream fs = new FileStream(this.path, FileMode.Open, 	FileAccess.Read, FileShare.Read);
			//			// Create a reader that can read bytes from the FileStream.
			//
			//						
			//			BinaryReader reader = new BinaryReader(fs);
			//			byte[] bytes = new byte[fs.Length];
			//			int read;
			//			while((read = reader.Read(bytes, 0, bytes.Length)) != 0) 
			//			{
			//				// Read from the file and write the data to the network
			//				sResponse = sResponse + Encoding.ASCII.GetString(bytes,0,read);
			//				iTotBytes = iTotBytes + read;
			//			}
			//			reader.Close(); 
			//			fs.Close();
			//		
			//			SendHeader( iTotBytes, this.response.StatusCode);
			//
			//			SendToBrowser(bytes);
			//						
			//			//mySocket.Send(bytes, bytes.Length,0);
			//			this.request.ClientSocket.Close();
			//			this.request.ClientSocket.
		}	

		public void SendHeader(int iTotBytes, string sStatusCode)
		{

			String sBuffer = "";
			
			// if Mime type is not provided set default to text/html
			

			sBuffer = sBuffer + this.request.Protocol + this.response.StatusCode + "\r\n";
			sBuffer = sBuffer + "Server: Yvettes Mini Server :-)\r\n";
			sBuffer = sBuffer + "Content-Type: " + this.response.MineType + "\r\n";
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
			//			int numBytes = 0;
			
			try
			{
				this.request.ClientSocket.Write(bSendData,0,bSendData.Length);
				
			
				//				if (this.request.ClientSocket.Connected)
				//				{
				//					if (( numBytes = this.request.ClientSocket.Send(bSendData, bSendData.Length,0)) == -1)
				//						Console.WriteLine("Socket Error cannot Send Packet");
				//					else
				//					{
				//						Console.WriteLine("No. of bytes send {0}" , numBytes);
				//					}
				//				}
				//				else
				//					Console.WriteLine("Connection Dropped....");
			}
			catch (Exception  e)
			{
				Console.WriteLine("Error Occurred : {0} ", e );
							
			}
		}

	}
}
//		}
//
//		public void SendResponse()
//		{
//			
////			concreteFilestream.Close();
//			
//			
//			StreamReader test = new StreamReader(this.response.MessageToSend);
//			
//			Byte[] res = System.Text.ASCIIEncoding.ASCII.GetBytes(test.ReadToEnd());
//			
//
////			if(this.cr.ClientRequest.RequestedMethod is GetMethod)
////			{
//				SendHeader(response.MessageToSend.Length.ToString());
////				//TO DO Change string message to Byte[] so this can be dropped.
////				if(this.cr.MineType == "image/bmp" || this.cr.MineType =="image/gif")
////				{
////					Console.WriteLine("bild soll gesendet werden");
////					Byte[] image = this.cr.ClientRequest.RequestedMethod.FetchImage();
////					SendToBrowser(image,this.cr.ClientRequest.ClientSocket);
////					Console.WriteLine("Bild sollte da sein");
////				}
//				SendToBrowser(res, this.request.ClientSocket);
//			test.Close();
////			}
////			if(this.cr.ClientRequest.RequestedMethod is HeadMethod)
////			{
////				SendHeader();
////			}
////			if(this.cr.ClientRequest.RequestedMethod is PostMethod)
////			{		
////				SendHeader();
////				SendMessage();
////			}
////			else
////			{}
//		}
//
//		public void SendHeader( string sa)
//		{
//			
//			string generatedMessage = this.request.Protocol + this.response.StatusCode +"\r\n";
//			generatedMessage = generatedMessage + "Server: Mogli-Server c\r\n";
////			generatedMessage = generatedMessage + "Content-Type: "+this.response.MineType +"\r\n";
//			generatedMessage = generatedMessage + "Content-Type: "+this.response.MineType +"\r\n";
////			generatedMessage = generatedMessage + "Content-Length: " +this.response.MessageToSend.Length+ "\r\n\r\n";
//			generatedMessage = generatedMessage + "Content-Length: " +sa.Length+ "\r\n\r\n";
//			Console.WriteLine("Generated Message: "+generatedMessage);
//			Byte[] bSendData = Encoding.ASCII.GetBytes(generatedMessage);
//			SendToBrowser( bSendData,this.request.ClientSocket);
//			Console.WriteLine("header sendet");
//		}
//
//		/// <summary>
//		/// Sends a message to the browser (Default way)
//		/// </summary>
//		public void SendMessage()
//		{
//			this.SendToBrowser(this.response.MessageToSend.ToString(),this.request.ClientSocket);
//		}
//
//		/// <summary>
//		///Sends data to the browser format.
//		/// </summary>
//		/// <param name="sData">A <code>string</code> which contains the message</param>
//		/// <param name="mySocket">The <code>Socket</code> on which the client listens</param>
//		public void SendToBrowser(string sData, Socket mySocket)
//		{
//			SendToBrowser(sData,  mySocket);
//		}
//
//
//		public  Byte[] FetchImage(Stream concreteFilestream)
//		{
//			int fileSize=0;
//			string response ="";
////			Stream concreteFilestream = Stream(this.generatedResponse.PhysicalPfad, FileMode.Open, 	FileAccess.Read, FileShare.Read);
//			// Create a reader that can read bytes from the FileStream.	
//			BinaryReader reader = new BinaryReader(concreteFilestream);
//			byte[] bytes = new byte[concreteFilestream.Length];
//			int read;
//			while((read = reader.Read(bytes, 0, bytes.Length)) != 0) 
//			{
//				response = response + Encoding.ASCII.GetString(bytes,0,read);
//				fileSize = fileSize + read;
//			}
//			reader.Close(); 
//			concreteFilestream.Close();
//			return bytes;
//		}
//		/// <summary>
//		/// Sends data to the client in the right format.
//		/// </summary>
//		/// <param name="bSendData">A <code>Byte[]</code>< which contains the data/param>
//		/// <param name="mySocket">The <code>Socket</code> on which the client listens</param>
//		public void SendToBrowser(Byte[] bSendData, Socket mySocket)
//		{
////			foreach(Byte b in bSendData)
////				Console.WriteLine(b.ToString());
//
//			Console.WriteLine("Länge des Streams: "+bSendData.Length);
//			
//			int numBytes = 0;
//			
//			try
//			{
//				if (mySocket.Connected)
//				{
//					if (( numBytes = mySocket.Send(bSendData, bSendData.Length,0)) == -1)
//						Console.WriteLine("Socket Error cannot Send Packet");
//					else
//					{
//						Console.WriteLine("No. of bytes send {0}" , numBytes);
//					}
//				}
//				else
//					Console.WriteLine("Connection Dropped....");
//			}
//			catch (Exception  e)
//			{
//				Console.WriteLine("Error Occurred : {0} ", e );
//							
//			}
//
//		
//			
//		}
//
//		
//
//		
//	}
//}
