using System;

namespace MySmallWebServer
{
	/// <summary>
	/// Represents a Head Method form a client. It implements the Abstract Method
	/// </summary>
	public class HeadMethod : AbstractMethod
	{
		string fileContent;
		int fileSize;

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
		}
		public override string MessageToSend
		{
			get{return this.fileContent;}
			set{this.fileContent = value;}
		}
	}
}
