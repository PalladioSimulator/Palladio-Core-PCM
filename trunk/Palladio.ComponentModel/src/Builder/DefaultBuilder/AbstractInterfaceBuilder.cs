using System;
using Palladio.ComponentModel.Builder.DeploymentLevelBuilder;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the Interface builder - methods that are available at all levels.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractInterfaceBuilder : IInterfaceBuilder
	{
		private ILowLevelBuilder lowLevelBuilder;
		private IInterface iInterface;


		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="iInterface">The interface to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, IInterface iInterface)
		{
			this.lowLevelBuilder = lowLevelBuilder;
			this.iInterface = iInterface;
		}


		/// <summary>
		/// called to add the given signature to the interfaces, specified by the given interface id.
		/// </summary>
		/// <param name="signature">the signature to be added</param>
		/// <returns>SignatureBuilder</returns>
		public ISignatureBuilder AddSignature (ISignature signature)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Adds a new signature to the interface.
		/// </summary>
		/// <returns>SignatureBuilder</returns>
		public ISignatureBuilder AddSignature ()
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// called to remove the signature with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		public void RemoveSignature (ISignatureIdentifier signatureID)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// called to add a protocol to the interfaces that is specified by the given interface id.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		public void AddProtocol (IProtocol protocol)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Adds a new protocol to the interface.
		/// </summary>
		public void AddProtocol ()
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// called to remove the protocol with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		public void RemoveProtocol (IProtocolIdentifier protocolID)
		{
			throw new NotImplementedException ();
		}
	}
}
