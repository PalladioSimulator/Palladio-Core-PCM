using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// Zusammenfassung für IDFactory.
	/// </summary>
	public class IdentifiableFactory
	{
		public static IIdentifier CreateStringID(string s)
		{
			return (StringIdentifier)s;
		}
	}
}
