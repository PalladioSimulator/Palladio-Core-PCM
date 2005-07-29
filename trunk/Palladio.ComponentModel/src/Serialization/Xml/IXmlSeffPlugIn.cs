using System.Xml;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// this interface defines a plugin for the xml serializer that can be used to load or store service effect
	/// specifications of the componentmodel.
	/// </summary>
 	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/07/29 16:00:56  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	public interface IXmlSeffPlugIn : IXmlPlugIn
	{
		/// <summary>
		/// called by the serializer, when a seff has to be loaded from given xml node. The type of the seff is
		/// one of the supported ones.
		/// </summary>
		/// <param name="seffNode">the xml node with the seff</param>
		/// <returns>the seff</returns>
		IServiceEffectSpecification LoadSeff(XmlNode seffNode);

		/// <summary>
		/// called by the serializer, when a seff has to be saved to the given xml writer. The type of the seff is
		/// one of the supported ones.
		/// </summary>
		/// <param name="xmlWriter">the xml writer</param>
		/// <param name="seff">the seff</param>
		void SaveProtocol(XmlWriter xmlWriter, IServiceEffectSpecification seff);

		/// <summary>
		/// returns an array of supported seff types
		/// </summary>
		ISeffTypeIdentifier[] SupportedTypes
		{
			get;
		}
	}
}
