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
		public ErrorDLL()
		{
		}

		public IDLL DeliverDll(HttpRequest t, Hashtable h,ref DBAcessComponent db)
		{
			Console.WriteLine("Error Handler wurde gefragt");
			if(Responseable())
			{
				Console.WriteLine("Error Handler verantwortlich");
				return this;
			}
			else
				return this;
		}
		public string Result()
		{
			return "Yvette hat es kaputt gemacht oder besser gesagt entweder hat sie vergessen eine Komponete einzuhängen, oder sie haben was falsches eingegeben";
		}

		public IDLL Sucessor
		{
			get{return this.sucessor;}
			set{
				this.sucessor=value;}
		}
		protected bool Responseable()
		{
			return true;
		}
	}
}
