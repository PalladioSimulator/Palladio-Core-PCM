// 
// Palladio Class
// $Id$
//
using Palladio.Identifier;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.Signature
{
	/// <summary>
	/// Summary description for DefaultService.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:05  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:49:17  joemal
	/// initial import
	///
	///
	/// </pre></remarks>
	internal class DefaultService : IService
	{
		protected ISignature signature;
		protected IInterfaceModel interfaceModel;

		public IInterfaceModel Interface
		{
			get
			{
				return interfaceModel;
			}
		}

		public ISignature Signature
		{
			get
			{
				return signature;
			}

		}

		public IIdentifier ID
		{
			get
			{
				return IdentifiableFactory.CreateStringID(this.interfaceModel.ID.ToString()+":"+signature.ID.ToString());
			}
		}

		public bool Match(IMatchable other)
		{
			return ((IService)other).Signature.Match(signature);
		}

		public object Clone()
		{
			return new DefaultService((IIdentifier)signature.ID.Clone(),interfaceModel);
		}

		public override string ToString()
		{
			return this.interfaceModel.ID.ToString()+":"+signature.ID.ToString();
		}

		/// <summary>
		/// Desciption of the constructor
		/// </summary>
		public DefaultService(IIdentifier signatureID, IInterfaceModel iface)
		{
			this.interfaceModel = iface;
			if (interfaceModel.SignatureList.ContainsSignatureID(signatureID))
				this.signature = interfaceModel.SignatureList.GetSignaturesByID(signatureID);
		}
	}
}
