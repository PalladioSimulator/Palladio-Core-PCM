using System;
using System.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;

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
		ISignatureList GetServiceEffectSpecification(ISignature aSig);

		/// <summary>
		/// Changes the service effect specification of aService.Signature to aService.EffectSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aService">Service associating a signature with a service effect specification.</param>
		void ChangeServiceEffectSpecification(IServiceEffectMapping aService);

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature"></param>
		/// <param name="aServEffSpec"></param>
		void ChangeServiceEffectSpecification(ISignature aSignature, ISignatureList aServEffSpec);

		void AddProvidesInterface(ISignatureList aProvInterface, params IServiceEffectMapping[] aServEffSpecArray);

		void DeleteProvidesInterfaces(params ISignatureList[] aProvArray);

		void AddRequiresInterfaces(params ISignatureList[] aReqArray);

		void DeleteRequiresInterfaces(params ISignatureList[] aReqArray);

	}
}
