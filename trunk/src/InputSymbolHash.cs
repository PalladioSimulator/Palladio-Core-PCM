using System;
using System.Collections;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	/// Zusammenfassung für InputSymbolHash.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/05/12 08:12:59  sbecker
	/// Fixed small typo
	///
	/// Revision 1.2  2004/05/12 08:07:25  sbecker
	/// Added constructor constructing from IInput[]
	/// Added CVS log
	///
	///
	/// </pre>
	/// </remarks>	
	public class InputSymbolHash
	{
		protected Hashtable inputHash = new Hashtable();

		public IInput this[object key]
		{
			get
			{
				return (IInput)inputHash[key];
			}
		}

		public void Add(object key, object val)
		{
			inputHash.Add(key,val);
		}

		public IInput[] StoredInputs
		{
			get
			{
				IInput[] result = new IInput[inputHash.Values.Count];
				inputHash.Values.CopyTo(result,0);
				return result;
			}
		}

		public InputSymbolHash()
		{
		}

		public InputSymbolHash(IInput[] inputs)
		{
			foreach (IInput i in inputs)
			{
				this.Add(i.ID,i);
			}
		}

		public override string ToString()
		{
			string result = "";

			foreach (IInput s in inputHash.Values)
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
