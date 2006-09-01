using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Serialization.Xml;

namespace Palladio.Types
{
	/// <summary>
	/// The factory that is used to create instances from <code>IType</code> and supporting plugins for the 
	/// componentmodels serializer.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/07/23 18:53:57  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	public class TypesFactory
	{
		/// <summary>
		/// called to create a simple type that only contains the name of the type
		/// </summary>
		/// <param name="typename">the name of the type</param>
		/// <returns>the instance of IType</returns>
		public static IType CreateStringType(string typename)
		{
			return new StringType(typename);
		}

		/// <summary>
		/// called to create a new plugin that can be used by the componentmodels serializer to
		/// load and store the string type.
		/// </summary>
		/// <returns></returns>
		public static IXmlTypePlugIn CreateStringTypeXMLSerializerPlugin()
		{
			return new StringTypeXMLSerializerPlugin();
		}
	}
}
