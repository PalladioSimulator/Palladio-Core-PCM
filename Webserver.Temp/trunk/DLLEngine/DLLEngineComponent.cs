using System;
using System.Collections;
using System.IO;
using System.Text;
using DBAcesses;
using Delivery;
using Request;

namespace DLLEngine
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class DLLEngineComponent : IResponseHandler
	{
		private IDLL actualHandler;
		private IDLL firstInCain;
		private IResponseHandler sucessor;
		private DBAcessComponent db;

		private byte[] resultToSend;
		private string statusCode;


		public IResponseHandler GetResponsibleHandler(HttpRequest r, string path)
		{
			if (r.UserInput != null || r is HttpPostRequest || r.URI.IndexOf("userStatictics.htm") != -1)
			{
				this.actualHandler = this.firstInCain;
				if (r.UserInput == null)
					r.UserInput = new Hashtable();
				this.actualHandler = this.actualHandler.DeliverDll(r, r.UserInput, ref this.db);
				//dings = dings.DeliverDll
				this.ComputeResult();
				return this;
			}
			else return this.sucessor.GetResponsibleHandler(r, path);

		}


		public Stream GetResponseStream()
		{
			return new MemoryStream();
		}

		public DLLEngineComponent()
		{
			this.db = new DBAcessComponent();
			this.AddHandler(new ErrorDLL());
			this.AddHandler(new UserStasHandler());
			this.AddHandler(new AdDBHandler());
			this.AddHandler(new SearchHandler());
			this.firstInCain = new GreetingHandler();
			this.AddHandler(this.firstInCain);
			statusCode = " 200 OK ";

			;
		}

		public byte[] GetResponse
		{
			get { return this.resultToSend; }
		}

		public int GetFileSize
		{
			get { return this.resultToSend.Length; }
		}

		public DateTime LastModified()
		{
			return DateTime.Now;
		}

		public IResponseHandler Sucessor
		{
			get { return this.sucessor; }
			set { this.sucessor = value; }
		}

		public string StatusCode
		{
			get { return statusCode; }
		}

		public void AddHandler(IDLL newHandler)
		{
			newHandler.Sucessor = this.actualHandler;
			this.actualHandler = newHandler;
		}

		public void ComputeResult()
		{
			string input = new StreamReader(@"..\..\..\for dll Engin\base.txt").ReadToEnd();
			input = input.Replace("<!-- </replace> -->", this.actualHandler.Result());
			this.resultToSend = ASCIIEncoding.ASCII.GetBytes(input);
		}

	}
}