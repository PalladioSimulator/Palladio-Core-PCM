using System;
using System.IO;
using System.Collections;
using System.Net.Sockets;

namespace MySmallWebServer
{
	/// <summary>
	/// A Response has to be answered this class rpresents the answer
	/// </summary>
	public class ClientResponse : AbstractResponse
	{
		/// <summary>
		/// The request which should be answered
		/// </summary>
		protected ClientRequest clientRequest;

		/// <summary>
		/// The status Code of the response as <code>string</code>
		/// </summary>
		protected string statusCode;

		/// <summary>
		/// The minetyoe of the request as <code>string</code>
		/// </summary>
		protected string mineType;

		/// <summary>
		/// The physical dir of the response as <code>string</code>
		/// </summary>
		protected string physicalDir;

		/// <summary>
		/// The physical path to the requested file as <code>string</code>
		/// </summary>
		protected string path;

		/// <summary>
		/// The message (html page) which shozld be sendend
		/// </summary>
		protected string sendedMessage;

		/// <summary>
		/// The size of the message as <code>string</code>
		/// </summary>
		protected int size;

		/// <summary>
		/// The kind of method to which should be answered
		/// </summary>
		protected AbstractMethod method;



		/// <summary>
		/// The originaly request
		/// </summary>
		public override ClientRequest ClientRequest
		{
			get{return this.clientRequest;}
			set{this.clientRequest = value;}
		}

		/// <summary>
		/// Gets and sets the messge which should be sended
		/// </summary>
		public override  string MessageToSend
		{
			get{return this.sendedMessage;}
			set{this.sendedMessage = value;}
		}


		/// <summary>
		/// Gets and Sets the Size of the message
		/// </summary>
		public int MessageSize
		{
			get{return this.size;}
		}


		/// <summary>
		/// Sets and gets the method of the request
		/// </summary>
		public AbstractMethod Method
		{
			get{return this.method;}
		}


		/// <summary>
		/// Build the response to a request
		/// </summary>
		public void BuildResponse()
		{
			this.clientRequest.RequestedMethod.BuildResponse(this);
			this.sendedMessage = this.clientRequest.RequestedMethod.MessageToSend;
			this.size = this.clientRequest.RequestedMethod.MessageSize;
		}


		/// <summary>
		/// The Request in a <code>string</code> reprenstation 
		/// </summary>
		/// <returns></returns>
		public override string ToString()
		{
			string s = "Thats the Response"+"\n";
			s=s+ this.clientRequest.ToString();
			s=s+"MineType "+ this.mineType;
			s=s+"statusCode "+this.statusCode;
			return s;
		}


		/// <summary>
		/// Gets ans sets the satuscode of a response
		/// </summary>
		public override string StatusCode
		{
			get{return this.statusCode;}
			set{this.statusCode= value;}
		}


		/// <summary>
		/// Sets and gets the MineType of a response
		/// </summary>
		public override string MineType
		{
			get{return this.mineType;}
			set{this.mineType = value;}
		}

		/// <summary>
		/// The physical pfad of a file as <code>string</code>
		/// </summary>
		public string PhysicalPfad{get{return this.path;}}


		/// <summary>
		/// Returns itself
		/// </summary>
		public override ClientResponse GeneratedResponse
		{get{return this;}}


		/// <summary>
		/// Returns the base of the response, the <code>ClientRequest</code>
		/// </summary>
		/// <param name="cr"></param>
		public ClientResponse(ClientRequest cr)
		{
			if(cr.RequestedMethod is GetMethod)
			{
				this.clientRequest = cr;
				Console.WriteLine("The generated Request---"+ cr.ToString());
				validateFile();
				BuildResponse();
				Console.WriteLine(this.ToString());
			}
		}



		/// <summary>
		///Checks if the requested file is valid and throws a exception if not.
		/// </summary>
		public void validateFile()
		{
			//check regualrMineType
			try
			{
				this.mineType = this.clientRequest.Settings.GetMineTypeMapping(this.clientRequest.RequestedFile.FileExtension);
				Console.WriteLine("The mineType: *********************************************************************"+this.mineType);
			}
			catch(Exception)
			{
				//here a notSupported fileEx has to be thrown
				Console.WriteLine("mapping faild");
			}
			this.physicalDir = this.clientRequest.Settings.GetDirMapping(this.clientRequest.RequestedFile.RequestedDirectory);
			Console.WriteLine("Physical Dir "+ this.physicalDir);

			//search for file
			this.path = this.physicalDir+this.clientRequest.RequestedFile.RequestedFileName;
			//Here a File not Found exception has to be thrown
			
			Console.WriteLine("das ist der pfad: "+this.path);
			if (File.Exists(path) == false)
			{
				Console.WriteLine("datei nicht gefunden");
				throw new MyServerException.MyFileNotFoundException(this);
			}
			else
			{
				this.statusCode = " 200 ok";
				Console.WriteLine(this.statusCode);
				Console.WriteLine("datei gefunden!");
			}

		}

		
	}
}
