using System;

namespace Palladio.FiniteStateMachines.DefaultFSM
{
	/// <summary>
	/// String implementing the IMatchable interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	internal class MatchableString : IMatchable 
	{
		public bool Match(IMatchable other)
		{
			return Equals(other);
		}

		public override bool Equals(object obj)
		{
			if (obj is MatchableString )
			{
				MatchableString mStr = (MatchableString) obj;
				return mStr.str.Equals(str);
			}
			return false;
		}

		public override string ToString()
		{
			return str;
		}

		public override int GetHashCode()
		{
			return str.GetHashCode ();
		}

		public MatchableString(string aStr)
		{
			str = aStr;
		}

		public static implicit operator MatchableString(string aStr)
		{
			return new MatchableString(aStr);
		}

		private string str;
	}
}
