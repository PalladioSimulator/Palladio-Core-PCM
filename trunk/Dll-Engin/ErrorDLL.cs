using System;
using System.Collections;
using Request;

namespace DLL_Engin
{
	/// <summary>
	/// Zusammenfassung für ErrorDLL.
	/// </summary>
	public class ErrorDLL : IDLL
	{
		IDLL sucessor;
		public ErrorDLL(Hashtable d)
		{
		}

		public IDLL DeliverDll(HttpRequest t, Hashtable h)
		{
			return this;
		}
		public string Result()
		{
			return "Yvette hat es kaputt gemacht";
		}

		public IDLL Sucessor
		{
			get{return this.sucessor;}
			set{this.sucessor=value;}
		}
	}
}
