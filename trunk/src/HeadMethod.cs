using System;
using System.IO;
using System.Text;

namespace MySmallWebServer
{
	/// <summary>
	/// Represents a Head Method form a client. It implements the Abstract Method
	/// </summary>
	public class HeadMethod : AbstractMethod
	{
		string fileContent;
		int fileSize;
		ClientResponse clientRequest;

		/// <summary>
		/// Inits a empty HeadMethod
		/// </summary>
		public HeadMethod()
		{

		}

		public override int MessageSize
		{
			get{return this.fileSize;}
			set{this.fileSize = value;}
		}
		public override void BuildResponse(ClientResponse r)
		{
			this.clientRequest = r;
			//ugly:
			this.MessageToSend="";
			CollectInformation();
		}
		public override string MessageToSend
		{
			get{return this.fileContent;}
			set{this.fileContent = value;}
		}

		private void CollectInformation()
		{

			this.fileSize = calculateFileSize();
		}

		private int calculateFileSize()
		{
			int iTotBytes=0;
			string response ="";
			FileStream fs = new FileStream(this.clientRequest.PhysicalPfad, FileMode.Open, 	FileAccess.Read, FileShare.Read);
			// Create a reader that can read bytes from the FileStream.	
			BinaryReader reader = new BinaryReader(fs);
			byte[] bytes = new byte[fs.Length];
			int read;
			while((read = reader.Read(bytes, 0, bytes.Length)) != 0) 
			{
				response = response + Encoding.ASCII.GetString(bytes,0,read);
				iTotBytes = iTotBytes + read;
			}
			reader.Close(); 
			fs.Close();
			this.fileContent = response;
			return iTotBytes;
		}
		public override Byte[] FetchImage()
		{
			return null;
		}

	}
}
