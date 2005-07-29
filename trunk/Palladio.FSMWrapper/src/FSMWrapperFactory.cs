using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Serialization.Xml;
using Palladio.FiniteStateMachines;

namespace Palladio.FSMWrapper
{
	/// <summary>
	/// This factory provides protocols, seffs and their serializers using FSMs. This protocols and seffs 
	/// can be added to the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/07/29 15:59:16  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class FSMWrapperFactory
	{
		/// <summary>
		/// called to create an interface protocol for the component model that is specified by the given fsm.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		/// <returns>the protocol</returns>
		public static IProtocol	CreateFSMProtocol(IFiniteStateMachine fsm)
		{
			return new FSMProtocol(fsm);
		}

		/// <summary>
		/// called to create an interface protocol for the component model that is specified by the given fsm.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		/// <param name="protId">the id of the protocol</param>
		/// <returns>the protocol</returns>
		public static IProtocol	CreateFSMProtocol(IProtocolIdentifier protId,IFiniteStateMachine fsm)
		{
			return new FSMProtocol(fsm,protId);
		}

		/// <summary>
		/// called to create a service effect specification for the component model that is specified by the given fsm.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		/// <returns>the seff</returns>
		public static IServiceEffectSpecification CreateFSMServiceEffectSpecification(IFiniteStateMachine fsm)
		{
			return new FSMServiceEffectSpecification(fsm);
		}

		/// <summary>
		/// called to create a service effect specification for the component model that is specified by the given fsm.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		/// <param name="seffId">the id of the seff</param>
		/// <returns>the seff</returns>
		public static IServiceEffectSpecification CreateFSMServiceEffectSpecification(ISeffIdentifier seffId,
			IFiniteStateMachine fsm)
		{
			return new FSMServiceEffectSpecification(fsm,seffId);
		}

		/// <summary>
		/// called to create a plugin that is used to store and load the fsm protocols with the componentmodels 
		/// serializer.
		/// </summary>
		/// <returns>the plugin</returns>
		public static IXmlProtocolPlugIn CreateFSMProtocolPlugin()
		{
			throw new NotImplementedException("to be implemented ...");
		}

		/// <summary>
		/// called to create a plugin that is used to store and load the fsm protocols with the componentmodels 
		/// serializer.
		/// </summary>
		/// <returns>the plugin</returns>
		public static IXmlSeffPlugIn CreateFSMSeffPlugin()
		{
			throw new NotImplementedException("to be implemented ...");
		}

		/// <summary>
		/// called to create an input symbol that can be annotated to a transition of the fsm. This symbol contains the id
		/// of a componentmodel interface and an id of a signature of this interface. 
		/// </summary>
		/// <param name="ifaceID">the id of the interface that contains the signature</param>
		/// <param name="sigID">the id of the signature to be called</param>
		/// <returns>the inputsymbol that can be annotaded to a transition</returns>
		public static IFSMSignatureCall CreateSignatureCall(IInterfaceIdentifier ifaceID, ISignatureIdentifier sigID)
		{
			return new FSMSignatureCall(ifaceID,sigID);
		}
	}
}
