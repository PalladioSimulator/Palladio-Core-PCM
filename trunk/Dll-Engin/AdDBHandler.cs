using System;
using Request;
using System.Collections;
using addBibTexDatabase;
using DBAcesses;

namespace DLL_Engin
{
	/// <summary>
	/// Zusammenfassung für AdDBHandler.
	/// </summary>
	public class AdDBHandler : IDLL
	{
		HttpPostRequest request;
		IDLL sucessor;
		DBAcessComponent db;
		public AdDBHandler() 
		{
		}

		

		public IDLL DeliverDll(HttpRequest t, Hashtable h,ref DBAcessComponent db)
		{
			if(Responseable(t))
			{
				this.request = (HttpPostRequest) t;
				this.db = db;
				return this;
			}
			else
				return this.sucessor.DeliverDll(t,h,ref db);
		}
		internal bool Responseable(HttpRequest r)
		{
			if(r.URI.IndexOf("entry.htm")!=-1 && r.RequestedMethod =="POST")
			{
				return true;
			}
			return false;
		}

		public IDLL Sucessor
		{
			get{return this.sucessor;}
			set{this.sucessor = value;}
		}

		public string Result()
		{
			addFile add = new addFile(ref this.db);
			return add.ComputeResponse(request);
		
		}
	}
}
