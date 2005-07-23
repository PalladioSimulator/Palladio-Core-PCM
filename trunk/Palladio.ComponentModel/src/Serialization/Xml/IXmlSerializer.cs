using Palladio.Attributes;
using Palladio.ComponentModel.Identifier;
using Palladio.Serialization;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// this interface extends the serializer interface with some methods to add and remove several plugins to serialize
	/// protocols, service effect specifications and attributes.
	/// </summary>
 	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/07/23 18:59:57  joemal
	/// IType now is implemented in external object. Plugins for serializer are created.
	///
	/// Revision 1.1  2005/05/08 12:02:17  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	public interface IXmlSerializer : ISerializer 
	{
		/// <summary>
		/// called to register a plugin that can be used to load and store protocols.
		/// </summary>
		/// <param name="plugIn">the plugin</param>
		void RegisterProcotocolPlugin(IXmlProtocolPlugIn plugIn);

		/// <summary>
		/// called to unregister plugins that are used to load and store protocols from given types.
		/// </summary>
		/// <param name="protocolsTypes">the types of the protocols</param>
		void UnregisterProtocolPlugin(params IProtocolTypeIdentifier[] protocolsTypes);

		/// <summary>
		/// called to register a plugin that can be used to load and store types.
		/// </summary>
		/// <param name="plugIn">the plugin</param>
		void RegisterTypePlugin(IXmlTypePlugIn plugIn);

		/// <summary>
		/// called to unregister plugins that are used to load and store implementations from <code>IType</code>
		/// that match to given type ids.
		/// </summary>
		/// <param name="typeIds">the ids</param>
		void UnregisterTypePlugin(params ITypeIdentifier[] typeIds);

		/// <summary>
		/// called to register a plugin that can be used to load and store attributes.
		/// </summary>
		/// <param name="plugIn"></param>
		void RegisterAttributePlugin(IXmlAttributePlugIn plugIn);

		/// <summary>
		/// called to unregister plugins that are used to load and store attributes from given types.
		/// </summary>
		/// <param name="attributeTypes">the types of the attributes</param>
		void UnregisterAttributePlugin(params IAttributeType[] attributeTypes);
	}
}
