using System;
using System.Text.RegularExpressions;
using System.Net.Sockets;

namespace Request
{
	/// <summary>
	/// Zusammenfassung für HTTPValidator.
	/// </summary>
	public class HTTPValidator
	{
		public HTTPValidator()
		{

		}


		internal void ValidateFileExtenstion(string s)
		{
			if(s=="")
				return;
			string pattern = @"[.][a-zA-Z]{2,4}";
			Match m = Regex.Match(s,pattern);
//			if(!m.Success)
//				throw new RequestNotValidException(s+" no regular FileExtension");
		}

		internal void validateURI(string uri)
		{
			if(uri=="/")
				return;
			string pattern = @"([a-zA-Z0-9_\-]+)[/]([a-zA-Z0-9_\-]+)([.][a-z]{2,4})?";
			Match m = Regex.Match(uri, pattern);
//			if(!m.Success)
//					throw new RequestNotValidException(uri+" is not a valid uri");
		}

		internal void validateMethod(string aMethod)
		{
			if(aMethod != "GET" && aMethod !="PUT" && aMethod!="HEAD" && aMethod!="POST")
				 throw new RequestNotValidException(aMethod+" is not a valid HttpMethod");
		}

		internal void validateProtocol(string aProtocol)
		{
		  if(aProtocol != "HTTP/1.0" && aProtocol != "HTTP/1.1")
			  throw new RequestNotValidException(aProtocol+" is not a valid HTTP Protocol");
		}

		internal void validateUserInput(string aInput)
		{
		  
		}

		internal void validateSocket(NetworkStream aSocket)
		{
		
		}



	}

	public class RequestNotValidException : Exception
	{
	  public RequestNotValidException(string message) : base(message)
	  {
	    
	  }
	}


}
