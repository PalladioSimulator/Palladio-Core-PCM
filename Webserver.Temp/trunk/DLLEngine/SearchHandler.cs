using System;
using System.Collections;
using DBAcesses;
using Request;
using searchBibTexDatabase;

namespace DLLEngine
{
	/// <summary>
	/// Zusammenfassung für SearchHandler.
	/// </summary>
	public class SearchHandler : IDLL
	{
		private IDLL sucessor;
		private Hashtable userInput;
		private string result;
		private DBAcessComponent db;

		public IDLL DeliverDll(HttpRequest request, Hashtable userInput, ref DBAcessComponent db)
		{
			if (Responseable(request))
			{
				Console.WriteLine("Search Handler verantwortlich");
				this.userInput = userInput;
				this.userInput.Remove("Submit");
				this.db = db;
				ComputeResult();
				return this;
			}
			else
			{
				return this.sucessor.DeliverDll(request, userInput, ref db);
			}
		}

		public void ComputeResult()
		{
			seachrchDB dbs = new seachrchDB(this.userInput, ref this.db);
			this.result = dbs.Result();
		}

		internal bool Responseable(HttpRequest r)
		{
			if (r.URI.IndexOf("suche.htm") != -1 && r.RequestedMethod == "GET")
			{
				return true;
			}
			return false;
		}

		public IDLL Sucessor
		{
			get { return this.sucessor; }
			set { this.sucessor = value; }
		}

		public string Result()
		{
			return this.result;
		}


	}
}