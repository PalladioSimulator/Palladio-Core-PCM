using System.Collections;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Manages the wrappers/decorators for the builders which are used for the constraints.
	/// Use this factory to get new builders that include all currently assigned constraints.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
	internal interface IBuilderFactory : IBuilderManager
	{

		#region methods

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
	}
}
