using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// Zusammenfassung für StringIdentifier.
	/// </summary>
	public class StringIdentifier : IIdentifier
	{
		protected string s;

		public StringIdentifier(string aID)
		{
			this.s = aID;
		}

		public static implicit operator StringIdentifier (string s)
		{
			return new StringIdentifier(s);
		}

		public override bool Equals(object aID)
		{
			if (!(aID is StringIdentifier)) return false;
			if (aID == this) return true;
			if (aID.ToString().Equals(s)) return true;
			return false;
		}

		public override int GetHashCode()
		{
			return s.GetHashCode();
		}

		public override string ToString()
		{
			return s.ToString();
		}

		public object Clone()
		{
			return new StringIdentifier(s);
		}
	}
}
