using System;
using System.Collections;
using Delivery;
using Request;
using System.IO;
using System.Text;
using DBAcesses;


namespace DLL_Engin
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class DLL_EnginComponent :IDeliverResponse
	{
		IDLL actualHandler;
		IDLL firstInCain;
		IDeliverResponse sucessor;
		DBAcessComponent db;

		byte[] resultToSend;


		public IDeliverResponse DeliverResonse(HttpRequest r, string path)
		{
			if(r.UserInput!=null || r is HttpPostRequest || r.URI.IndexOf("userStatictics.htm")!=-1) 
			{
				this.actualHandler = this.firstInCain;
				if(r.UserInput == null)
					r.UserInput= new Hashtable();
				this.actualHandler = this.actualHandler.DeliverDll(r,r.UserInput,ref this.db);
				//dings = dings.DeliverDll
				this.ComputeResult();
				return this;
			}
			else return this.sucessor.DeliverResonse(r,path);

		}

		public Stream DeliverResponseStream()
		{
			return new MemoryStream();
		}
		public DLL_EnginComponent()
		{
			this.db = new DBAcessComponent();
//			this.actualHandler = new AdDBHandler();
//			this.actualHandler = new ErrorDLL();
			this.AddHandler(new ErrorDLL());
			this.AddHandler(new UserStasHandler());
			this.AddHandler(new AdDBHandler());
			this.AddHandler(new SearchHandler());
			this.firstInCain = new GreetingHandler();
			this.AddHandler(this.firstInCain);
			
			;
		}

		public byte[] GetResponse
		{
			get{return this.resultToSend;}
		}
		public int GetFileSize
		{
			get{return this.resultToSend.Length;}
		}
		public DateTime LastModified()
		{
			return DateTime.Now;
		}
		public IDeliverResponse Sucessor
		{
			get{
				return this.sucessor;}
			set{
				this.sucessor = value;}
		}
		public void AddHandler(IDLL newHandler)
		{
			newHandler.Sucessor = this.actualHandler;
			this.actualHandler = newHandler;
		}

		public void ComputeResult()
		{
			string input = new StreamReader(@"C:\Dokumente und Einstellungen\Yvette\Eigene Dateien\Visual Studio Projects\WebserverComponents\for dll Engin\base.txt").ReadToEnd();
			input = input.Replace("<!-- </replace> -->",this.actualHandler.Result());
			this.resultToSend = System.Text.ASCIIEncoding.ASCII.GetBytes(input);
		}
		
	}
}
