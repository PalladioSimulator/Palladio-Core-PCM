using System;
using System.Net.Sockets;
using System.Collections;

namespace Request
{
	/// <summary>
	/// The HTTPRequest class represents a client request based on the HttpProtocol
	/// For this functionality it is not expedient to use the HttpWebRequest from the
	/// .net Framework. Because this has been implemented only for clients.
	/// </summary>
	public class HttpRequest : BaseRequest
	{
		private string requestedMethod;
		private string  uri;
		private string protocol; 
		private NetworkStream clientSocket;
		private Hashtable userInput;
		private HTTPValidator valid;
		private string fileExtension;
		private DateTime arrival;
		private TcpClient tcpClient;

		/// <summary>
		/// Initates an empty empty HttpRequest.
		/// </summary>
		public HttpRequest()
		{
			valid = new HTTPValidator();
		}

		public TcpClient TcpClientOn
		{
			get{return this.tcpClient;}
			set{this.tcpClient =value;}
		}
		public HttpRequest(HttpRequest aReauest)
		{
			this.valid = aReauest.valid;
			this.arrival=aReauest.arrival;
			this.RequestedMethod=aReauest.RequestedMethod;
			this.protocol=aReauest.protocol;
			this.URI=aReauest.URI;
			this.UserInput=aReauest.userInput;
			this.ClientSocket=aReauest.ClientSocket;
			this.fileExtension = aReauest.fileExtension;
			this.TcpClientOn = aReauest.TcpClientOn;
		}
		public string FileExtension
		{
			get{ return this.fileExtension;}
			set
			{
				this.valid.ValidateFileExtenstion(value);
				this.fileExtension = value;
			}
		}


		public DateTime ArrivalTime
		{
			get{ return this.arrival;}
			set{this.arrival = value;}
		}

		public string RequestedMethod
		{
			get{return this.requestedMethod;}
			set
			{
			  this.valid.validateMethod(value);
			  this.requestedMethod = value;
			}
		}

		public string URI
		{
			get{return this.uri;}
			set
			{
			  this.valid.validateURI(value);
			  this.uri=value;
			}
		}

		public string Protocol
		{
			get{return this.protocol;}
			set
			{
				this.valid.validateProtocol(value);
				this.protocol=value;  
			}
		}

		public NetworkStream ClientSocket
		{
		  get{return this.clientSocket;}
			set
			{
			  this.valid.validateSocket(value);
			  this.clientSocket= value;
			}
		}

		public Hashtable UserInput
		{
		  get{return this.userInput;}
		  set
		  {
//		    this.valid.validateUserInput(value);
		    this.userInput = value;
		  }
		}
	}
}
