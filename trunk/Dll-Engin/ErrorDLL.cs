using System;
using System.Collections;
using Request;
using DBAcesses;

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

		public IDLL DeliverDll(HttpRequest t, Hashtable h,ref DBAcessComponent db)
		{
			return this;
		}
		public string Result()
		{
			return "Yvette hat es kaputt gemacht oder besser gesagt entweder hat sie vergessen eine Komponete einzuhängen, oder sie haben was falsches eingegeben";
		}

		public IDLL Sucessor
		{
			get{return this.sucessor;}
			set{this.sucessor=value;}
		}
	}
}
