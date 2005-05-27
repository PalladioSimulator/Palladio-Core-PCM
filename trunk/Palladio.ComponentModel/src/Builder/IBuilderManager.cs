using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Manages the wrappers/decorators for the builders which are used for the constraints.
	/// Use this factory/manager to get new builders that include all currently assigned constraints.
	/// Offers access to builders (including constraints) for:
	/// <li>Type level (for initializing by id and enitity instance)</li>
	/// <li>Implementation level (initializing by id)</li>
	/// <li>Deployment level (initializing by id)</li>
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.10  2005/05/27 11:20:20  kelsaka
	/// - added methods for accessing builders of implementation and deployment level to BuilderManager.
	///
	/// Revision 1.9  2005/05/25 18:15:27  kelsaka
	/// - added new methods to BuilderManager
	/// - use of new methods in example
	///
	/// Revision 1.8  2005/05/25 16:27:10  kelsaka
	/// - renamed former BuilderFactory / therefore removed former BuilderManager
	///
	/// Revision 1.3  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.2  2005/04/23 17:42:08  kelsaka
	/// - added further methods for constraint-support
	///
	/// Revision 1.1  2005/04/23 14:56:44  kelsaka
	/// - enhanced constraints management
	///
	/// </pre>
	/// </remarks>
	public interface IBuilderManager
	{

		#region methods with entities

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="component">The component to build</param>
		/// <returns>Basic component builder for the type level.</returns>
		IBasicComponentTypeLevelBuilder GetBasicComponentTypeLevelBuilder(IComponent component);

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="component">The component to build</param>
		/// <returns>Composite component builder for the type level.</returns>
		ICompositeComponentTypeLevelBuilder GetCompositeComponentTypeLevelBuilder(IComponent component);

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="iInterface">The interface to build</param>
		/// <returns>interface builder for the type level.</returns>
		IInterfaceTypeLevelBuilder GetInterfaceTypeLevelBuilder(IInterface iInterface);

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="signature">The signature to build</param>
		/// <returns>signature builder for the type level.</returns>
		ISignatureTypeLevelBuilder GetSignatureTypeLevelBuilder(ISignature signature);

		#endregion		

		#region methods with IDs

		#region type level

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Basic component builder for the type level.</returns>
		IBasicComponentTypeLevelBuilder GetBasicComponentTypeLevelBuilder(IComponentIdentifier componentID);

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Composite component builder for the type level.</returns>
		ICompositeComponentTypeLevelBuilder GetCompositeComponentTypeLevelBuilder(IComponentIdentifier componentID);

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="iInterfaceID">The interface to build</param>
		/// <returns>interface builder for the type level.</returns>
		IInterfaceTypeLevelBuilder GetInterfaceTypeLevelBuilder(IInterfaceIdentifier iInterfaceID);

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="signatureID">The signature to build</param>
		/// <returns>signature builder for the type level.</returns>
		ISignatureTypeLevelBuilder GetSignatureTypeLevelBuilder(ISignatureIdentifier signatureID);

		#endregion

		#region implementation level

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Basic component builder for the type level.</returns>
		IBasicComponentImplementationLevelBuilder GetBasicComponentImplementationLevelBuilder(IComponentIdentifier componentID);

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Composite component builder for the type level.</returns>
		ICompositeComponentImplementationLevelBuilder GetCompositeComponentImplementationLevelBuilder(IComponentIdentifier componentID);

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="iInterfaceID">The interface to build</param>
		/// <returns>interface builder for the type level.</returns>
		IInterfaceImplementationLevelBuilder GetInterfaceImplementationLevelBuilder(IInterfaceIdentifier iInterfaceID);

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="signatureID">The signature to build</param>
		/// <returns>signature builder for the type level.</returns>
		ISignatureImplementationLevelBuilder GetSignatureImplementationLevelBuilder(ISignatureIdentifier signatureID);

		#endregion

		#endregion		

		/// <summary>
		/// The root builder of the actual component model. Root builder for the type level.
		/// Use this builder to set up the static structure of the component model.
		/// The root builder that is returned applies all actually defined constraints.
		/// </summary>
		/// <remarks>Formerly this property was called "RootBuilder".</remarks>
		IRootTypeLevelBuilder RootTypeLevelBuilder
		{
			get;
		}

	}
}
