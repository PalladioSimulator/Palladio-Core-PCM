using System;
using System.Collections;
using addBibTexDatabase;
using DBAcesses;
using Request;

namespace DLLEngine
{
	/// <summary>
	/// Zusammenfassung für AdDBHandler.
	/// </summary>
	public class AdDBHandler : IDLL
	{
		private HttpPostRequest request;
		private IDLL sucessor;
		private DBAcessComponent db;

		public AdDBHandler()
		{
		}


		public IDLL DeliverDll(HttpRequest t, Hashtable userInput, ref DBAcessComponent db)
		{
			if (Responseable(t))
			{
				Console.WriteLine("Error Handler verantwortlich");
				this.request = (HttpPostRequest) t;
				this.db = db;
				return this;
			}
			else
			{
				return this.sucessor.DeliverDll(t, userInput, ref db);
			}
		}

		internal bool Responseable(HttpRequest r)
		{
			if (r.URI.IndexOf("entry.htm") != -1 && r.RequestedMethod == "POST")
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
			AddFile add = new AddFile(ref this.db);
			return add.ComputeResponse(request);

		}
	}
}