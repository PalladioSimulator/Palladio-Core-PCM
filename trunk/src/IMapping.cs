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

		bool IsSubType(out IList anErrorList);

		bool IsSubType();
	}
}
