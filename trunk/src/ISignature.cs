using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.ComponentModel
{
	public interface ISignature : ICloneable 
	{
		string Name 
		{
			get;
		}

		bool Match(ISignature aSig);

		bool HasMatches(IList aSigList, out IList aMatchList);

		bool HasMatches(IList aSigList);

		bool HasOneMatch(IList aSigList);

		bool HasOneMatch(IList aSigList, out ISignature aMatch);
	}


	/// <summary>
	/// </summary>
	public abstract class AbstractSignature	: ISignature
	{

		#region Abstract Properties

		public abstract string Name 
		{
			get;
		}
		#endregion

		// TODO add parameters

		#region Abstract Methods

		public abstract object Clone();
		#endregion

		#region Implemented Methods

		public bool Match(ISignature aSig)
		{
			return (aSig.Name == this.Name);
		}

		public bool HasMatches(IList aSigList, out IList aMatchList)
		{
			aMatchList = new Vector();
			foreach (ISignature sig in aSigList) 
			{
				if (this.Match(sig)) 
				{
					aMatchList.Add(sig);
				}
			}
			return (aMatchList.Count != 0);
		}

		public bool HasMatches(IList aSigList)
		{
			IList matchList;
			return HasMatches(aSigList, out matchList);
		}

		public bool HasOneMatch(IList aSigList)
		{
			ISignature match;
			return HasOneMatch(aSigList, out match);
		}

		public bool HasOneMatch(IList aSigList, out ISignature aMatch)
		{
			aMatch = null;
			IList matchList;
			if (HasMatches(aSigList, out matchList) && (matchList.Count == 1))
			{
				aMatch = (ISignature) matchList[0];
				return true;
			}
			return false;
		}

		public override string ToString()
		{
			return Name;
		}

		public override bool Equals(object obj)
		{
			if (obj is ISignature) 
			{
				return ( ((ISignature)obj).Name == this.Name );
			}
			return false;
		}

		public override int GetHashCode()
		{
			return this.Name.GetHashCode();
		}



		#endregion
	}
}
