using System;
using System.Collections;
using DBAcesses;
using Request;
using UserStatistics;

namespace DLLEngine
{
	/// <summary>
	/// Zusammenfassung für UserStasHandler.
	/// </summary>
	public class UserStasHandler : IDLL
	{
		private DBAcessComponent db;
		private string result;
		private HttpRequest reg;
		protected IDLL sucessor;

		public UserStasHandler()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public void ComputeResult()
		{
			UserStas stas = new UserStas(ref this.db, this.reg);
			this.result = stas.Result();
		}

		protected bool Responseable(HttpRequest request)
		{
			if (request.URI.IndexOf("userStatictics.htm") != -1)
				return true;
			return false;
		}

		public IDLL DeliverDll(HttpRequest request, Hashtable userInput, ref DBAcessComponent db)
		{
			if (Responseable(request))
			{
				Console.WriteLine("USer Stas verantwortlich");
				this.db = db;
				this.reg = request;
				ComputeResult();
				return this;
			}
			else
			{
				return this.sucessor.DeliverDll(request, userInput, ref db);
			}
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