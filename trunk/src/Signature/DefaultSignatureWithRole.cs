// 
// Palladio Class
// $Id$
//
using System;
using Palladio.Attributes;
using Palladio.Identifier;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.Signature
{
	/// <summary>
	/// Summary description for DefaultSignatureWithRole.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.3  2004/06/09 12:36:31  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.2  2004/06/03 14:37:29  sbecker
	/// Added the possibility to attach auxiliary specifications to a basic component
	///
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	///
	/// </pre></remarks>
	internal class DefaultSignatureWithRole : IExternalSignature
	{
		protected ISignature encapsulatedSignature;
		protected IIdentifier roleID;

		public IIdentifier RoleID
		{
			get
			{
				return roleID;
			}
		}

		public ISignature Signature
		{
			get
			{
				return encapsulatedSignature;
			}

		}

		public bool Match(IMatchable other)
		{
			return ((IExternalSignature)other).Signature.Match(encapsulatedSignature);
		}

		public object Clone()
		{
			return new DefaultSignatureWithRole((ISignature)encapsulatedSignature.Clone(),(IIdentifier)roleID.Clone());
		}

		public override string ToString()
		{
			return encapsulatedSignature.ToString() + " of role " + roleID.ToString();
		}

		public override bool Equals(object obj)
		{
			if (!(obj is IExternalSignature)) return false;
			if (obj == this) return true;
			IExternalSignature sigRole = (IExternalSignature)obj;
			return (sigRole.RoleID.Equals(this.RoleID) && sigRole.Signature.Equals(this.Signature));
		}

		public override int GetHashCode()
		{
			return 				(
				(encapsulatedSignature != null ? encapsulatedSignature.GetHashCode() : 0) ^ 
				(roleID != null ? roleID.GetHashCode() : 0));
		}


		/// <summary>
		/// Desciption of the constructor
		/// </summary>
		public DefaultSignatureWithRole(ISignature anEncapsulatedSignature, IIdentifier aRoleID)
		{
			this.encapsulatedSignature = (ISignature)anEncapsulatedSignature.Clone();
			this.roleID = aRoleID;
		}
	}
}
