using System.IO;
using System.Text;
using System.Collections;
using System;	
using System.IO;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace MySmallWebServer
{
	/// <summary>
	/// The GetMethod which can be requested by Client
	/// </summary>
	public class GetMethod : AbstractMethod
	{
		protected ClientResponse generatedResponse;
		protected string fileContent;
		protected int fileSize;
		

		public override int MessageSize
		{
			get{return this.fileSize;}
			set{this.fileSize = value;}
		}


		public override string MessageToSend
		{
			get{return this.fileContent;}
			set{this.fileContent = value;}
		}


		/// <summary>
		/// Initates an empty GetMethod
		/// </summary>
		public GetMethod()
		{
		}


		/// <summary>
		/// Build the response for this reques Method
		/// </summary>
		/// <param name="r">An <code>AbstractResponse</code> to fetch the file</param>
		public override void BuildResponse(ClientResponse aClientResponse)
		{
			this.generatedResponse = aClientResponse;
			FetchFile();
			
		}


		/// <summary>
		/// Fertch the selected file from the disk an stores them into a <code>string</code>
		/// </summary>
		public void FetchFile()
		{
			int fileSize=0;
			string response ="";
			FileStream concreteFilestream = new FileStream(this.generatedResponse.PhysicalPfad, FileMode.Open, 	FileAccess.Read, FileShare.Read);
			// Create a reader that can read bytes from the FileStream.	
			BinaryReader reader = new BinaryReader(concreteFilestream);
			byte[] bytes = new byte[concreteFilestream.Length];
			int read;
			while((read = reader.Read(bytes, 0, bytes.Length)) != 0) 
			{
				response = response + Encoding.ASCII.GetString(bytes,0,read);
				fileSize = fileSize + read;
			}
			reader.Close(); 
			concreteFilestream.Close();
			this.fileContent = response;
			this.fileSize = fileSize;
		}

		public override Byte[] FetchImage()
		{
			int fileSize=0;
			string response ="";
			FileStream concreteFilestream = new FileStream(this.generatedResponse.PhysicalPfad, FileMode.Open, 	FileAccess.Read, FileShare.Read);
			// Create a reader that can read bytes from the FileStream.	
			BinaryReader reader = new BinaryReader(concreteFilestream);
			byte[] bytes = new byte[concreteFilestream.Length];
			int read;
			while((read = reader.Read(bytes, 0, bytes.Length)) != 0) 
			{
				response = response + Encoding.ASCII.GetString(bytes,0,read);
				fileSize = fileSize + read;
			}
			reader.Close(); 
			concreteFilestream.Close();
			return bytes;
		}
	}
}
