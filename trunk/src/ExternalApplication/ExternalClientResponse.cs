using System;
using System.Collections;
using MySmallWebServer;

namespace MySmallWebServer.ExternalApplication
{
	/// <summary>
	/// This is an implemtation for an ExternalClientResponse. It implemts the
	/// <code>AbstractResponse</code>. And  generates responses for external Applications. So an external 
	/// Application must only provide a generateText Method to deliver the answer to this request.
	/// On this way only formular Application can be answered.
	/// </summary>
	public class ExternalClientResponse : AbstractResponse
	{
	
		/// <summary>
		/// The File which has been used 
		/// </summary>
		protected UsedFile file;

		/// <summary>
		/// The <code>ClientRequest</code> which should be answered
		/// </summary>
		protected ClientRequest cr;

		/// <summary>
		/// An hashtable which containst he user input:
		/// key: Name of the formular
		/// value: The input of the user on this field
		/// </summary>
		protected Hashtable filteredInput;

		/// <summary>
		/// The message as <code>string</code>
		/// </summary>
		protected string text;

		/// <summary>
		/// The <code>AbstractResponse</code> object.
		/// </summary>
		protected ClientResponse r;

		/// <summary>
		/// The statuscode of the Request in a <code>string</code> representation
		/// </summary>
		protected string statusCode;


		/// <summary>
		/// The Base of the <code>Abstractresponse</code>the <code>ClientRequest</code>
		/// (get and set)
		/// </summary>
		public override  ClientRequest ClientRequest
		{
			get{return this.cr;}
			set{this.cr = value;}
		}


		/// <summary>
		/// Sets and Gets the mineType of the Response in a string representation.
		/// </summary>
		public override string MineType
		{
			get
			{
				return this.MineType;
			}
			set
			{
				this.MineType = value;}
		}


		/// <summary>
		/// Initates an <code>ExternalClientResponse</code>
		/// </summary>
		/// <param name="r">The <code>ClientRequest</code> which should be answered</param>
		public ExternalClientResponse(ClientRequest r)
		{
			this.file = (UsedFile) r.RequestedFile;
			this.cr = r;
			Console.WriteLine("Externe Antwort: "+r.UserInput);
			ParseInput();
			generateText();
		}

		/// <summary>
		/// Seter and geter for the status code stored in a <code>string</code>
		/// </summary>
		public override string StatusCode
		{
			get{return this.statusCode;}
			set{this.statusCode = value;}
		}

		/// <summary>
		/// Returns the generated response
		/// </summary>
		public override ClientResponse GeneratedResponse
		{
			get{return this.r;}
		}

		/// <summary>
		/// Generates the message for the response
		/// </summary>
		protected void generateText()
		{
			this.r = new ClientResponse(this.cr);
			this.r.ClientRequest = cr;
			this.r.MineType = " text/html ";

			try
			{
				if(this.ClientRequest.RequestedFile.RequestedFileName=="form.htm")
				{
					Console.WriteLine(".");
					Form1Applikation t = new Form1Applikation(this.filteredInput);
					this.text= t.GenerateText();
					Console.WriteLine("Mein neuer Text: "+this.text);
				}
				else if(this.ClientRequest.RequestedFile.RequestedFileName=="form2.htm")
				{
					Form2Application t = new Form2Application(this.filteredInput);
					this.text= t.GenerateText();
					Console.WriteLine("Mein neuer Text: "+this.text);
				}
					//Throw Excetpiotn
				else
					throw new MyServerException.MyExternalException( r);
				//building Response
			}
			catch(Exception)
			{
				throw new MyServerException.MyExternalException( r);
			}
		
			this.r.StatusCode=" 200 ok ";
			this.r.MessageToSend = this.text;
			this.r.ClientRequest = this.cr;
			Console.WriteLine(r.ToString());
			//			this.r.MessageSize = this.MessageSize;
		}


		/// <summary>
		/// The empty constructor
		/// </summary>
		public ExternalClientResponse(){}


		/// <summary>
		/// Retruns the input sorted in a <code>Hashtable</code>
		/// </summary>
		public Hashtable FilteredInput
		{
			get{return this.filteredInput;}
		}


		/// <summary>
		/// parses the user input <code>string</code> an generates the soreted 
		/// <code>Hashtable</code>
		/// </summary>
		protected void ParseInput()
		{
			string input = this.cr.UserInput;
			string[] singleFormular = input.Split('&');

			this.filteredInput = new Hashtable();
			foreach(string s in singleFormular)
			{
				String[] erg = s.Split('=');
				this.filteredInput.Add(erg[0],erg[1]);
			}

		}


		/// <summary>
		/// Geter and seter for the message which shoulg be sendend
		/// </summary>
		public override string MessageToSend
		{
			get{return this.text;}
			set{this.text = value;}
		}


		/// <summary>
		/// the Size of the message which should be sended
		/// </summary>
		public int MessageSize
		{
			get{return this.text.Length;}
		}


	}
}
