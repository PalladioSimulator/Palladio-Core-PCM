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
		IServiceEffectSpecification GetServiceEffectSpecification(IService aSig);

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aService"></param>
		/// <param name="aServEffSpec"></param>
		void AddServiceEffectSpecification(IService aService, IServiceEffectSpecification aServEffSpec);

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aService"></param>
		/// <param name="aServEffSpec"></param>
		void ChangeServiceEffectSpecification(IService aService, IServiceEffectSpecification aServEffSpec);

//		/// <summary>
//		/// Get the service effect specification associated with aSig.
//		/// </summary>
//		/// <param name="aSig">A signature provided in a role of this component.</param>
//		/// <param name="aRoleID">The role of the signature.</param>
//		/// <returns>The service effect specification of aSig.</returns>
//		IServiceEffectSpecification GetServiceEffectSpecification(IIdentifier aRoleID, ISignature aSig);

		/// <summary>
		/// Add a service effect specification to the specified service.
		/// </summary>
		/// <param name="aRoleID">The role of the service getting a service effect specification.</param>
		/// <param name="aServEffSpec">The service effect to be added</param>
		/// <param name="aSignature">Signature of the service getting a service effect specification.</param>
		void AddServiceEffectSpecification(IIdentifier anInterfaceID, IIdentifier aSignatureID, IServiceEffectSpecification aServEffSpec);

		/// <summary>
		/// Reset a certain service effect specification
		/// </summary>
		/// <param name="signatures">The services whose service effect specifications get deleted</param>
		void DeleteServiceEffectSpecification(params IService[] services);
	}
}
