using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Builder for creating Basic Components.
	/// </summary>
	/// <remarks>
	/// <p>This builder interface contains all non model-level specifical methods of a basic
	/// component.</p>
	/// Probably currently no methods exist.
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.9  2005/07/29 16:01:32  joemal
	/// now service effect specifications can be added ...
	///
	/// Revision 1.8  2005/05/27 15:22:51  kelsaka
	/// - added return of entity ids
	///
	/// Revision 1.7  2005/05/25 19:44:54  kelsaka
	/// - optimized usings
	/// - builders are now returning identifiers again
	///
	/// Revision 1.6  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.5  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.4  2005/04/07 17:49:31  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// Revision 1.3  2005/04/06 19:06:58  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.2  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface IBasicComponentBuilder : IComponentBuilder
	{
		#region methods

		/// <summary>
		/// call to add a service effect specification to the builders basic component.
		/// </summary>
		/// <param name="seff">the service effect specification</param>
		/// <param name="ifaceID">the id of the interface that holds the signature of the seff.</param>
		/// <param name="sigID">the id of the signature</param>
		/// <exception cref="EntityAlreadyExistsException">a seff with given id already exists in cm</exception>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="SignatureNotFoundException">the signature could not be found in cm</exception>
		/// <exception cref="InterfaceNotFromComponentException">the interface is not bound to the component</exception>		
		void AddServiceEffectSpecification(IServiceEffectSpecification seff,IInterfaceIdentifier ifaceID, 
			ISignatureIdentifier sigID);

		/// <summary>
		/// called to remove the service effect specification that matchs to given id.
		/// </summary>
		/// <param name="seffId">the id of the seff to be removed</param>
		void RemoveServiceEffectSpecification(ISeffIdentifier seffId);

		#endregion
	}
}
