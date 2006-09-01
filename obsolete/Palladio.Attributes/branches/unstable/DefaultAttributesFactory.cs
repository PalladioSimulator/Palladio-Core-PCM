using System;

namespace Palladio.Attributes
{
	/// <summary>
	/// Factory for creating objects of the interfaces in this
	/// namespace
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/05/13 15:17:31  sbecker
	/// Initial import
	///
	///
	/// </pre>
	/// </remarks>
	internal class DefaultAttributesFactory : IAttributesFactory
	{
		/// <summary>
		/// Create a new <see cref="IAttributeType"/>
		/// </summary>
		/// <param name="aGuid">The ID of the type</param>
		/// <param name="description">A description of the attribute</param>
		/// <param name="aType">The type of the attributes values</param>
		/// <returns>A new IAttributeType</returns>
		public IAttributeType CreateAttributeType(Guid aGuid, string description, Type aType)
		{
			return new DefaultAttributeType(aGuid,description,aType);
		}
		
		/// <summary>
		/// Create a new <see cref="IAttributeHash"/>
		/// </summary>
		/// <returns>An IAttributeHash</returns>
		public IAttributeHash CreateAttributeHash()
		{
			return new AttributeHash();
		}
	}
}
