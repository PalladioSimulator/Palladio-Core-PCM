using System;

namespace Palladio.Attributes
{
	/// <summary>
	/// Zusammenfassung für IAttributesFactory.
	/// </summary>
	public interface IAttributesFactory
	{
		/// <summary>
		/// Create a new <see cref="IAttributeType"/>
		/// </summary>
		/// <param name="aGuid">The ID of the type</param>
		/// <param name="description">A description of the attribute</param>
		/// <param name="aType">The type of the attributes values</param>
		/// <returns>A new IAttributeType</returns>
		IAttributeType CreateAttributeType(Guid aGuid, string description, Type aType);		

		/// <summary>
		/// Create a new <see cref="IAttributeHash"/>
		/// </summary>
		/// <returns>An IAttributeHash</returns>
		IAttributeHash CreateAttributeHash();
	}
}
