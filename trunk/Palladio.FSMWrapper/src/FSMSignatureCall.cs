using System;
using Palladio.ComponentModel.Identifier;
using Palladio.FiniteStateMachines;

namespace Palladio.FSMWrapper
{
	/// <summary>
	/// The default implementaion of interface IFSMSignatureCall.
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
	internal class FSMSignatureCall : IFSMSignatureCall,IMatchable
	{
		//holds the interface id 
		private IInterfaceIdentifier iFaceId;

		//holds the signature id
		private ISignatureIdentifier signatureId;

		/// <summary>
		/// called to create a new FSMSignatureCall
		/// </summary>
		/// <param name="iFaceId">the id of the interface</param>
		/// <param name="signatureId">the id of the signature</param>
		public FSMSignatureCall(IInterfaceIdentifier iFaceId, ISignatureIdentifier signatureId)
		{
			this.iFaceId = iFaceId;
			this.signatureId = signatureId;
		}

		/// <summary>
		/// returns the id of the interface
		/// </summary>
		public IInterfaceIdentifier IFaceId
		{
			get 
			{
				return this.iFaceId;
			}
		}

		/// <summary>
		/// returns the id of the signature
		/// </summary>
		public ISignatureIdentifier SignatureId
		{
			get
			{
				return this.signatureId;
			}
		}

		/// <summary>
		/// A match is a more specialised comparison of two objects.
		/// </summary>
		/// <param name="other">Another object which should be matched.</param>
		/// <returns>True, if this object an the other object match, false otherwise.</returns>
		public bool Match(IMatchable other)
		{
			if (!(other is IFSMSignatureCall)) return false;
			IFSMSignatureCall fsmSigCall = (IFSMSignatureCall) other;
			return fsmSigCall.IFaceId.Equals(this.IFaceId) && fsmSigCall.SignatureId.Equals(this.SignatureId);
		}

		/// <summary>
		/// The ID of the input symbol used for a certain transition
		/// </summary>
		public IMatchable ID
		{
			get
			{
				return this;
			}
		}
	}
}
