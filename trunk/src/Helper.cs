using System;
using System.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public class Helper
	{
		public static IList SigListFromInputAlphabet(IList anInputAlphabet)
		{
			IList resultList = new ArrayList();
			foreach( Input i in anInputAlphabet)
			{
				ISignature sig = new SimpleSignature((string)i.InputSymbol);
				resultList.Add(sig);
			}
			return resultList;
		}
	}
}
