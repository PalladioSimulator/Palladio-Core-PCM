using System;

namespace MySmallWebServer
{
	/// <summary>
	/// Initates a PostMethod. This method is able to answer Post methods
	/// </summary>
	public class PostMethod : AbstractMethod
	{
		
		string fileContent;
		int fileSize;

		/// <summary>
		/// Initates an empty PostMethod
		/// </summary>
		public PostMethod()
		{
		}


		/// <summary>
		/// Retruns the size of the size of a generated message
		/// </summary>
		public override int MessageSize
		{
			get{return this.fileSize;}
			set{this.fileSize = value;}
		}


		/// <summary>
		/// Builds a Response for this method
		/// </summary>
		/// <param name="r"></param>
		public override void  BuildResponse(ClientResponse r)
		{
		}

		/// <summary>
		/// The Message which as <code> string</code> which will be sended to the client
		/// </summary>
		public override string MessageToSend
		{
			get{return this.fileContent;}
			set{this.fileContent = value;}
		}
	}
}
