using System;
using System.Net.Sockets;

namespace MySmallWebServer
{
	/// <summary>
	/// This class represents a Client Request and stores all needable information 
	/// about it.
	/// </summary>
	public class ClientRequest
	{
		
		private ServerSettings settings;
		private AbstractMethod requestedMethod;
		private FileID fileID;
		private AbstractHttpProtocol protocol; 
		private Socket clientSocket;
		private string userInput;
		
		/// <summary>
		/// The input of the user as <code>string</code>
		/// </summary>
		public string UserInput
		{
			get{return this.userInput;}
			set{this.userInput = value;}
		}


		/// <summary>
		/// Sets and Gets the Protocol of the request
		/// </summary>
		public AbstractHttpProtocol Protocol
		{
			get{ return this.protocol;}
			set{ this.protocol = value;}
		}
		

		/// <summary>
		/// Returns the <code>FileID</code> of the request
		/// </summary>
		public FileID RequestedFile
		{
			get{ return this.fileID;}
			set{ this.fileID = value;}
		}
		
	
		/// <summary>
		/// The settings of the server (get, set)
		/// </summary>
		public ServerSettings Settings
		{
			get{ return this.settings;}
			set{ this.settings =value;}
		}


		/// <summary>
		/// The <code>Socket</code> on which the client is conntected
		/// </summary>
		public Socket ClientSocket
		{
			get{return this.clientSocket;}
			set{this.clientSocket = value;}
		}

		/// <summary>
		/// The empty constructor 
		/// </summary>
		public ClientRequest()
		{	}

		/// <summary>
		/// Sets and gets the Requested Method
		/// </summary>
		public AbstractMethod RequestedMethod{
			get{return this.requestedMethod;}
			set { this.requestedMethod = value; }}

		/// <summary>
		/// Retruns the Request in a <code>string</code>
		/// </summary>
		/// <returns></returns>
		public override string ToString()
		{
			string r = "The Client Request: "+"\n";
			r = r+ "Method: "+this.requestedMethod.ToString() +"\n";
			r = r + "Protocol: "+  this.protocol.ToString()+"\n";
			r = r + "the requested File: "+this.fileID.ToString()+"\n";
			r = r + "--------------------------------------";
			return r;
		} 

	}
}
