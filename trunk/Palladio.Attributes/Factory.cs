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
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	/// Revision 1.1  2005/02/21 12:46:18  joemal
	/// initial import
	///
	/// Revision 1.1  2005/02/18 20:47:57  joemal
	/// initial class creation
	///
	/// Revision 1.2  2004/07/13 07:48:47  sbecker
	/// Made AttributesFactory static
	///
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
		public static IAttributesFactory Default
		{
			get
			{
				return attributesFactory;
			}
		}
	}
}
