using System;
using Request;
using System.Collections;
using Greeting;
using DBAcesses;


namespace DLL_Engin
{
	/// <summary>
	/// Zusammenfassung für GreetingHandler.
	/// </summary>
	public class GreetingHandler : IDLL
	{
		IDLL sucessor;
		Hashtable userInput;
		string result;
		public GreetingHandler()
		{}

		public IDLL DeliverDll(HttpRequest request, Hashtable userInput, ref DBAcessComponent db)
		{
			if(Responseable(request))
			{
				this.userInput = userInput;
				ComputeResult();
				return this;
			}
			else return this.sucessor.DeliverDll(request,userInput,ref db);
		}

		public void  ComputeResult()
		{
			Greet greet = new Greet(this.userInput);
			this.result = greet.Result();
		}
			
		internal bool Responseable(HttpRequest r)
		{
			if(r.URI.IndexOf("dynamic.htm")!=-1 && r.RequestedMethod =="GET")
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
