using System.Xml;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// this interface defines a plugin for the xml serializer that can be used to load or store protocols of
	/// the componentmodel.
	/// </summary>
 	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/09/18 15:36:23  joemal
	/// add fsm seffs and protocols
	///
	/// Revision 1.2  2005/07/13 11:10:44  joemal
	/// replace xmlreader with xmlnode in load method
	///
	/// Revision 1.1  2005/05/08 12:02:17  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	public interface IXmlProtocolPlugIn : IXmlPlugIn
	{
		/// <summary>
		/// called by the serializer, when a protocol has to be loaded from given xml reader. The type of the protocol is
		/// one of the supported ones.
		/// </summary>
		/// <param name="protId">the id of the new protocol</param>
		/// <param name="protocolNode">the xml node with the protocol</param>
		/// <returns>the protocol</returns>
		IProtocol LoadProtocol(IProtocolIdentifier protId, XmlNode protocolNode);

		/// <summary>
		/// called by the serializer, when a protocol has to be saved to the given xml writer. The type of the protocol is
		/// one of the supported ones.
		/// </summary>
		/// <param name="xmlWriter">the xml writer</param>
		/// <param name="protocol">the protocol</param>
		void SaveProtocol(XmlWriter xmlWriter, IProtocol protocol);

		/// <summary>
		/// returns an array of supported protocol types
		/// </summary>
		IProtocolTypeIdentifier[] SupportedProtocols
		{
			get;
		}
	}
}
