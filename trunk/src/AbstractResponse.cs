using System;

namespace MySmallWebServer
{
	/// <summary>
	/// An AbstractResponse from this all response this mus be the father
	/// (Vererbung halt)
	/// </summary>
	public abstract class AbstractResponse
	{
		/// <summary>
		/// The request to which a response should be gerated
		/// </summary>
		public abstract ClientRequest ClientRequest{get;set;}

		/// <summary>
		/// The Message which is the response for the client  in a
		/// <code>String</code> represnetation
		/// </summary>
		public abstract string MessageToSend{get;set;}

		/// <summary>
		/// The status code of the response stored in a <code>string</code>
		/// </summary>
		public abstract string StatusCode{get;set;}

		/// <summary>
		/// The generated Response in the representation of an 
		/// <code>AbstractResponse</code>
		/// </summary>
		public abstract ClientResponse GeneratedResponse{get;}
		
		//		string PhysicalPfad{get;}

		public abstract string MineType{get;set;}
	}

}
