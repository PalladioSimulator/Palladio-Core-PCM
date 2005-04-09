using System;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Builder which is base of all component types.
	/// </summary>
	/// <remarks>
	/// <p>This builder interface contains all non model-level specifical methods of a component
	/// (basic and composite).</p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.4  2005/04/08 14:40:55  kelsaka
	/// - added implementation and unit-tests
	///
	/// Revision 1.3  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.2  2005/04/06 19:06:58  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.1  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface IComponentBuilder
	{
		#region methods

		/// <summary>
		/// Called to add an existing interface as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		void AddProvidesInterface(IInterfaceIdentifier ifaceIdentifier);

		/// <summary>
		/// Called to add an existing interface as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		void AddRequiresInterface(IInterfaceIdentifier ifaceIdentifier);

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		IInterfaceTypeLevelBuilder AddProvidesInterface(string interfaceName);

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		IInterfaceTypeLevelBuilder AddRequiresInterface(string interfaceName);

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as provided interface (<see cref="InterfaceRole.PROVIDES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		void RemoveProvidesInterface(IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as requires interface (<see cref="InterfaceRole.REQUIRES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		void RemoveRequiresInterface(IInterfaceIdentifier ifaceID);

		#endregion

		#region Properties

		/// <summary>
		/// Returns the <see cref="IComponentIdentifier"/> of the actual component.
		/// </summary>
		IComponentIdentifier ComponentID
		{
			get;
		}

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		IComponent Component
		{
			get;
		}

		#endregion
	}
}
