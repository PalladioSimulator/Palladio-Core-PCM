using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// A factory for creating IDs
	/// </summary>
	public class IdentifiableFactory
	{
		/// <summary>
		/// Create an ID from a given string
		/// </summary>
		/// <param name="s">The string to be used as ID</param>
		/// <returns>An IIdentifier which represents the string as ID</returns>
		public static IIdentifier CreateStringID(string s)
		{
			return (StringIdentifier)s;
		}
	}
}
