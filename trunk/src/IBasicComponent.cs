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
		/// <param name="aServiceEffectMapping">IServiceEffectMapping associating a signature with a service effect specification.</param>
		void ChangeServiceEffectSpecification(IServiceEffectMapping aServiceEffectMapping);

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature"></param>
		/// <param name="aServEffSpec"></param>
		void ChangeServiceEffectSpecification(ISignature aSignature, ISignatureList aServEffSpec);

		/// <summary>
		/// Adds a provides interface to the component. For each service of the interface a 
		/// a service effect specification is required. It is given by a service effect mapping.
		/// </summary>
		/// <param name="aProvInterface">Provides interface to be added</param>
		/// <param name="aServEffSpecArray">Service effect specifications of all signatures of the provides interface.</param>
		void AddProvidesInterface(ISignatureList aProvInterface, params IServiceEffectMapping[] aServEffSpecArray);

		/// <summary>
		/// Remove all provides interfaces given by aProvArray from the component.
		/// </summary>
		/// <param name="aProvArray">Provides interfaces to be removed.</param>
		void DeleteProvidesInterfaces(params ISignatureList[] aProvArray);

		/// <summary>
		/// Remove all provides interfaces with the roles given by aProvRoleArray 
		/// from the component.
		/// </summary>
		/// <param name="aProvRoleArray">Roles of the interfaces to be removed.</param>
		void DeleteProvidesInterfaces(params string[] aProvRoleArray);
			
		/// <summary>
		/// Add all requires interfaces given by aReqArray to the component.
		/// </summary>
		/// <param name="aReqArray">Requires interfaces to be added.</param>
		void AddRequiresInterfaces(params ISignatureList[] aReqArray);

		/// <summary>
		/// Remove all requires interfaces given by aReqArray form the component.
		/// </summary>
		/// <param name="aReqArray">Requires interfaces to be deleted.</param>
		void DeleteRequiresInterfaces(params ISignatureList[] aReqArray);

		/// <summary>
		/// Remove all requires interfaces with the roles given by aReqRoleArray.
		/// </summary>
		/// <param name="aReqRoleArray">Roles of the requires interfaces to be deleted.</param>
		void DeleteRequiresInterfaces(params string[] aReqRoleArray);
	}
}
