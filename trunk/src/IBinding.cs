using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connection between a requires interface of component A and
	/// a provides interface of component B. Both components stand on
	/// the same level. (none is including the other)
	/// </summary>
	public interface IBinding : IConnection
	{
		bool CheckInteroperability ();

		bool CheckInteroperability ( out IList anErrorList );
	}
}
