using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Utils.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Some useful helper tools.
	/// </summary>
	public class Helper
	{
		/// <summary>
		/// Creates a list of ISignature objects from anInputAlphabet of
		/// a finite state machine.
		/// </summary>
		/// <param name="anInputAlphabet">InputAlphabet of a FSM.</param>
		/// <returns></returns>
		public static IList SigListFromInputAlphabet(IList anInputAlphabet)
		{
			IList resultList = new Vector();
			foreach( Input i in anInputAlphabet)
			{
				ISignature sig = new SimpleSignature((string)i.InputSymbol);
				resultList.Add(sig);
			}
			return resultList;
		}
	}
}
