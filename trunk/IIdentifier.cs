using System;
using System.Collections;

namespace Palladio.Identifier
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public interface IIdentifier : ICloneable
	{
		bool Equals(object aID);
		string ToString();
		int GetHashCode();
	}
}
