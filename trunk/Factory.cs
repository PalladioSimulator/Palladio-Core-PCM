using System;

namespace Palladio.Attributes
{
	/// <summary>
	/// Static factory class for getting an <see cref="IAttributesFactory"/>
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
	public class AttributesFactory
	{
		/// <summary>
		/// Create a factory for attributes
		/// </summary>
		protected static IAttributesFactory attributesFactory = new DefaultAttributesFactory();	

		/// <summary>
		/// Return a default factory
		/// </summary>
		public IAttributesFactory Default
		{
			get
			{
				return attributesFactory;
			}
		}
	}
}
