using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public interface IMapping : IConnection
	{
		IComponent InnerComp 
		{ 
			get;
		}
		IComponent OuterComp 
		{ 
			get;
		}

		bool CheckSubType(out IList anErrorList);

		bool CheckSubType();
	}
}
