using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// The default implementation of the Interface IIdentifier.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 12:15:57  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	internal class DefaultIdentifiable : IIdentifiable
	{
		protected StringIdentifier stringID;

		public IIdentifier ID
		{
			get
			{
				return stringID;
			}
		}

		public DefaultIdentifiable(string s)
		{
			stringID = s;
		}
	}
}
