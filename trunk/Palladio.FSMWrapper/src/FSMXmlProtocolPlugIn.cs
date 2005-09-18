using System;
using System.Xml;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Serialization.Xml;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Serializer.DefaultImplementation;
using Palladio.Serialization;

namespace Palladio.FSMWrapper
{
	/// <summary>
	/// This is the implementation of the protocol and seff plugin serializer that can be used to store and load
	/// fsm protocols and seffs.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/09/18 15:37:02  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class FSMXmlPlugin : IXmlProtocolPlugIn, IXmlSeffPlugIn
	{
		#region data
        //holds the serializer for the fsm
		private	XMLSerializer fsmSerializer;

		#endregion
		#region methods

		/// <summary>
		/// called by the serializer, when the plugin has been registered.
		/// </summary>
		public void Registered()
		{
			fsmSerializer = new XMLSerializer();
			fsmSerializer.AddInputSerializerPlugin(new FSMWrapperInputSerializer());
		}

		/// <summary>
		/// called by the serializer, after the plugin has been unregistered.
		/// </summary>
		public void Unregistered()
		{
			//not needed
		}

		/// <summary>
		/// called by the serializer, when a protocol has to be loaded from given xml reader. The type of the protocol is
		/// one of the supported ones.
		/// </summary>
		/// <param name="protocolNode">the xml node with the protocol</param>
		/// <returns>the protocol</returns>
		public IProtocol LoadProtocol(IProtocolIdentifier protId, XmlNode protocolNode)
		{
			IFiniteStateMachine fsm = fsmSerializer.Load(protocolNode);
			return new FSMProtocol(fsm, protId);
		}

		/// <summary>
		/// called by the serializer, when a protocol has to be saved to the given xml writer. The type of the protocol is
		/// one of the supported ones.
		/// </summary>
		/// <param name="xmlWriter">the xml writer</param>
		/// <param name="protocol">the protocol</param>
		public void SaveProtocol(XmlWriter xmlWriter, IProtocol protocol)
		{
			if (!(protocol is FSMProtocol))
				throw new ModelSerializationException("Protocol not supported by FSMXmlPlugin.");
			fsmSerializer.Save(xmlWriter,((FSMProtocol)protocol).FiniteStateMachine);
		}

		/// <summary>
		/// called by the serializer, when a seff has to be loaded from given xml node. The type of the seff is
		/// one of the supported ones.
		/// </summary>
		/// <param name="seffNode">the xml node with the seff</param>
		/// <returns>the seff</returns>
		public IServiceEffectSpecification LoadSeff(ISeffIdentifier seffId, XmlNode seffNode)
		{
			IFiniteStateMachine fsm = fsmSerializer.Load(seffNode);
			return new FSMServiceEffectSpecification(fsm,seffId);
		}

		/// <summary>
		/// called by the serializer, when a seff has to be saved to the given xml writer. The type of the seff is
		/// one of the supported ones.
		/// </summary>
		/// <param name="xmlWriter">the xml writer</param>
		/// <param name="seff">the seff</param>
		public void SaveSeff(XmlWriter xmlWriter, IServiceEffectSpecification seff)
		{
			if (!(seff is FSMServiceEffectSpecification))
				throw new ModelSerializationException("Given seff not supported by FSMXmlPlugin.");
			fsmSerializer.Save(xmlWriter,((FSMServiceEffectSpecification)seff).FiniteStateMachine);
		}

		#endregion
		#region properties

		/// <summary>
		/// returns an array of supported seff types
		/// </summary>
		public ISeffTypeIdentifier[] SupportedSeffs
		{
			get
			{
				return new ISeffTypeIdentifier[]{FSMServiceEffectSpecification.SEFFTYPEID};
			}
		}

		/// <summary>
		/// returns an array of supported protocol types
		/// </summary>
		public IProtocolTypeIdentifier[] SupportedProtocols
		{
			get
			{
				return new IProtocolTypeIdentifier[]{FSMProtocol.PROTTYPEID};
			}
		}

		/// <summary>
		/// returns the namespace of the subtree that represents the content of the xml-file that has to
		/// be processed by the plugin.
		/// </summary>
		public string XmlNameSpace
		{
			get
			{
				return XMLSerializer.XMLNAMESPACE;
			}
		}

		/// <summary>
		/// returns the xml schema that can be used to validate the xml file before building the model
		/// </summary>
		public string XmlSchema
		{
			get
			{
				return XMLSerializer.XSDSchemeFileName;
			}
		}

		#endregion
	}
}
