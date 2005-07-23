using System.Xml;
using Palladio.Attributes;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// this interface defines a plugin for the xml serializer that can be used to load or store types declared 
	/// by the interface <code>IType</code>.
	/// </summary>
 	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/07/23 18:58:18  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	public interface IXmlTypePlugIn:IXmlPlugIn
	{
		/// <summary>
		/// called by the serializer, when a type has to be loaded from given xml node. The type is
		/// one of the supported ones.
		/// </summary>
		/// <param name="typeNode">the xml node that contains the type</param>
		/// <returns>the type</returns>
		IType LoadType(XmlNode typeNode);

		/// <summary>
		/// called by the serializer, when an type has to be saved to the given xmlwriter. The type is
		/// one of the supported ones.
		/// </summary>
		/// <param name="xmlWriter">the xml writer</param>
		/// <param name="type">the type</param>
		void SaveType(XmlWriter xmlWriter, IType type);

		/// <summary>
		/// returns an array of supported types
		/// </summary>
		ITypeIdentifier[] SupportedTypes
		{
			get;
		}
	}
}
