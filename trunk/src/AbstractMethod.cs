using System;

namespace MySmallWebServer
{
	/// <summary>
	/// Represents a comman Method.
	/// </summary>
	public abstract class AbstractMethod
	{
		/// <summary>
		/// Initaites an empty Method
		/// </summary>
		public AbstractMethod()
		{
		}


		/// <summary>
		/// The message which should be sendend
		/// </summary>
		public abstract string MessageToSend{get ;set;}

		/// <summary>
		/// Builds a Response to the delivers Request
		/// </summary>
		/// <param name="r"></param>
		public abstract void BuildResponse(ClientResponse r);

		/// <summary>
		/// The size of the message which should be sendend as get and set
		/// </summary>
		public abstract int MessageSize{get;set;}
	}
}
