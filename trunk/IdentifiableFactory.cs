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

		/// <summary>
		/// Create a new Globally Unique ID
		/// </summary>
		/// <returns>An IIdentifier which represents the GUID</returns>
		public static IIdentifier CreateGUID()
		{
			return new GloballyUniqueIdentifier();
		}

		/// <summary>
		/// Create a Globally Unique ID
		/// </summary>
		/// <param name="guid">The Guid to be converted to the IIdentifier</param>
		/// <returns>An IIdentifier which represents the GUID</returns>
		public static IIdentifier CreateGUID(Guid guid)
		{
			return new GloballyUniqueIdentifier(guid);
		}

		/// <summary>
		/// Create a Globally Unique ID
		/// </summary>
		/// <param name="s">The string to be converted to the IIdentifier</param>
		/// <returns>An IIdentifier which represents the GUID</returns>
		public static IIdentifier CreateGUID(string s)
		{
			return new GloballyUniqueIdentifier(s);
		}
	}
}
