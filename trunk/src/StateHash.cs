using System;
using System.Collections;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	/// Zusammenfassung für InputSymbolHash.
	/// </summary>
	public class StateHash
	{
		protected Hashtable stateHash = new Hashtable();

		public IState this[object key]
		{
			get
			{
				return (IState)stateHash[key];
			}
		}

		public void Add(object key, object val)
		{
			stateHash.Add(key,val);
		}

		public IState[] StoredStates
		{
			get
			{
				IState[] result = new IState[stateHash.Values.Count];
				stateHash.Values.CopyTo(result,0);
				return result;
			}
		}

		public StateHash()
		{
		}

		public StateHash(IState[] states)
		{
			foreach (IState s in states)
			{
				this.Add(s.ID,s);
			}
		}

		public override string ToString()
		{
			string result = "";

			foreach (IState s in stateHash.Values)
			{
				result += s.ID + " | ";
			}
			if (result.Length > 0)
				return result.Substring(0,result.Length - 3);
			else
				return "";
		}
	}
}
