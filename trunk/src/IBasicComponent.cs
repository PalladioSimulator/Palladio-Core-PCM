using System;
using System.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;
using Palladio.Identifier;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A Component is a set of Provides- and RequiresInterface.
	/// </summary>
	public interface IBasicComponent : IComponent, IVisitable
	{
		/// <summary>
		/// Get the service effect specification associated with aSig.
		/// </summary>
		/// <param name="aSig">A signature provided in a role of this component.</param>
		/// <returns>The service effect specification of aSig.</returns>
		IServiceEffectSpecification GetServiceEffectSpecification(ISignatureWithRole aSig);

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature"></param>
		/// <param name="aServEffSpec"></param>
		void AddServiceEffectSpecification(ISignatureWithRole aSignature, IServiceEffectSpecification aServEffSpec);

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature"></param>
		/// <param name="aServEffSpec"></param>
		void ChangeServiceEffectSpecification(ISignatureWithRole aSignature, IServiceEffectSpecification aServEffSpec);

		/// <summary>
		/// Get the service effect specification associated with aSig.
		/// </summary>
		/// <param name="aSig">A signature provided in a role of this component.</param>
		/// <returns>The service effect specification of aSig.</returns>
		IServiceEffectSpecification GetServiceEffectSpecification(IIdentifier aRoleID, ISignature aSig);

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature"></param>
		/// <param name="aServEffSpec"></param>
		void AddServiceEffectSpecification(IIdentifier aRoleID, ISignature aSignature, IServiceEffectSpecification aServEffSpec);

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature"></param>
		/// <param name="aServEffSpec"></param>
		void ChangeServiceEffectSpecification(IIdentifier aRoleID, ISignature aSignature, IServiceEffectSpecification aServEffSpec);

		void DeleteServiceEffectSpecification(params ISignatureWithRole[] signatures);
	}
}
