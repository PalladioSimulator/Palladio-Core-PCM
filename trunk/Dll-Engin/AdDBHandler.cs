using System;
using Request;
using System.Collections;
using addBibTexDatabase;

namespace DLL_Engin
{
	/// <summary>
	/// Zusammenfassung für AdDBHandler.
	/// </summary>
	public class AdDBHandler : IDLL
	{
		HttpPostRequest request;
		IDLL sucessor;
		public AdDBHandler() 
		{
		}

		

		public IDLL DeliverDll(HttpRequest t, Hashtable h)
		{
			if(Responseable(t))
			{
				this.request = (HttpPostRequest) t;
				return this;
			}
			else
				return this.sucessor.DeliverDll(t,h);
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
			addFile add = new addFile();
			return add.ComputeResponse(request);
		
		}
	}
}
