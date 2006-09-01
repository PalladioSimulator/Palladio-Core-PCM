using System.Collections;

namespace Greeting
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class Greet
	{
		private Hashtable userData;

		public Greet(Hashtable ud)
		{
			this.userData = ud;
		}

		public string Result()
		{
			return "<H1> Hallo " + this.userData["nameFeld"].ToString() + " !";
		}
	}
}