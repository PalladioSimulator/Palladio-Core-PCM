using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public interface IMapping : IConnection
	{
		bool IsSubType(out IList anErrorList);

		bool IsSubType();
	}
}
