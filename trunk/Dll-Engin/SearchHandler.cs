using System;
using searchBibTexDatabase;
using System.Collections;
using Request;

namespace DLL_Engin
{
	/// <summary>
	/// Zusammenfassung für SearchHandler.
	/// </summary>
	public class SearchHandler : IDLL
	{
		IDLL sucessor;
		Hashtable userInput;
		string result;

		public IDLL DeliverDll(HttpRequest request, Hashtable userInput)
		{
			if(Responseable(request))
			{
				this.userInput = userInput;
				this.userInput.Remove("Submit");
				ComputeResult();
				return this;
			}
			else return this.sucessor.DeliverDll(request,userInput);
		}

		public void  ComputeResult()
		{
			seachrchDB dbs = new seachrchDB(this.userInput);
			this.result = dbs.Result();
		}
			
		internal bool Responseable(HttpRequest r)
		{
			if(r.URI.IndexOf("suche.htm")!=-1 && r.RequestedMethod =="GET")
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
			return this.result;
		}


	}
}
