using System;
using System.Xml;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Identifier;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Serializer;
using Palladio.FiniteStateMachines.Serializer.Interfaces;

namespace Palladio.FSMWrapper.src
{
	/// <summary>
	/// The fsm serializer plugin for <code>FSMSignatureCall</code> (extension of <code>IInput</code>).
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/09/13 14:56:39  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class FSMWrapperInputSerializer : IInputSerializerPlugin
	{
		//the list of supported type guids
		private static Guid[] SUPPORTED_TYPES = new Guid[]{FSMSignatureCall.TYPE_GUID};

		/// <summary>
		/// Serializes the given input and writes the results to the given xmlwriter.
		/// </summary>
		/// <param name="input">The input to serialize.</param>
		/// <param name="xmlWriter">The writer to use for serializing the input.</param>
		/// <remarks>The output is automatically surrounded by the calling class by a
		/// <code>&lt;input inputType="abcde"&gt;&lt;/input&gt;</code> Tag.</remarks>
		public void SerializeInput(IInput input, XmlWriter xmlWriter)
		{
			if (!(input is IFSMSignatureCall))
				throw new ModelSerializationException("The instance of IInput is not supported by this plugin. "+
					"Must be an instance of IFSMSignatureCall");
			IFSMSignatureCall sigCall = (IFSMSignatureCall) input;

			xmlWriter.WriteStartElement(this.XmlPrefix,"AdditionalData",this.XmlNamespace);

			xmlWriter.WriteStartElement(this.XmlPrefix,"Signature",this.XmlNamespace);
			xmlWriter.WriteAttributeString(this.XmlPrefix,"idref",this.XmlNamespace,sigCall.SignatureId.Key);
			xmlWriter.WriteEndElement();
			xmlWriter.WriteStartElement(this.XmlPrefix,"Interface",this.XmlNamespace);
			xmlWriter.WriteAttributeString(this.XmlPrefix,"idref",this.XmlNamespace,sigCall.IFaceId.Key);
			xmlWriter.WriteEndElement();

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Deserializes the given xmlNode, that represents an <see cref="IInput"/>.
		/// </summary>
		/// <param name="xmlNode">The node to deserialize, that contains the input
		/// xml element.</param>
		/// <returns>The deserialized input information.</returns>
		public IInput DeserializeInput(XmlNode xmlNode)
		{
			XmlDocument doc = xmlNode.OwnerDocument;
			XmlNamespaceManager mgr = new XmlNamespaceManager(doc.NameTable);
			mgr.AddNamespace(this.XmlPrefix,this.XmlNamespace);

			XmlNode addDataNode = xmlNode.SelectSingleNode(this.XmlPrefix+":AdditionalData",mgr);
			XmlNode ifaceNode = addDataNode.SelectSingleNode(this.XmlPrefix+":Interface",mgr);
			XmlNode sigNode = addDataNode.SelectSingleNode(this.XmlPrefix+":Signature",mgr);

			string idStr = ifaceNode.Attributes[this.XmlPrefix+":idref"].Value;
			IInterfaceIdentifier ifaceId = ComponentModelIdentifier.CreateInterfaceID(idStr);
			idStr = sigNode.Attributes[this.XmlPrefix+":idref"].Value;
			ISignatureIdentifier sigId = ComponentModelIdentifier.CreateSignatureID(idStr);

			return new FSMSignatureCall(ifaceId,sigId);
		}

		/// <summary>
		/// The namespace of the IInput elements. (read)
		/// </summary>
		public string XmlNamespace
		{
			get
			{
				return "http://palladio.informatik.uni-oldenburg.de/fsmwrapper/";
			}
		}

		/// <summary>
		/// The URI of the XSD-File that describes the XML-Scheme of the Plugin output. This XSD is used
		/// for validation. (read)
		/// </summary>
		public string XmlSchemaURI
		{
			get
			{
				return "FSMSignatureCall.xsd";
			}
		}

		/// <summary>
		/// The prefix to identify XML elements written by the plugin.
		/// </summary>
		public string XmlPrefix
		{
			get
			{
				return "fsc";
			}
		}

		/// <summary>
		/// called to return a list of supported ids of input types
		/// </summary>
		public Guid[] SupportedInputTypes
		{
			get
			{
				return FSMWrapperInputSerializer.SUPPORTED_TYPES;
			}
		}
	}
}
