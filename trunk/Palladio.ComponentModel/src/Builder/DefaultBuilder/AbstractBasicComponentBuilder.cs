using System;
using System.Collections;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.BuilderConstraints;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the basic component builder - methods that are available at all levels.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.16  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.15  2005/04/23 11:00:44  kelsaka
	/// - removed Init-Methods from AbstractBuilder - created constructors
	///
	/// Revision 1.14  2005/04/20 18:27:45  kelsaka
	/// - made classes internal
	/// - removed unused init-methods
	/// - use of InternalEntityIdentifier for creating new Identifiers
	///
	/// Revision 1.13  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.12  2005/04/20 13:26:43  kelsaka
	/// - added new Init-method implementation
	///
	/// Revision 1.11  2005/04/20 13:08:30  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// Revision 1.10  2005/04/16 12:37:46  kelsaka
	/// - added first ideas using constraints with the builders
	///
	/// Revision 1.9  2005/04/15 08:29:45  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.8  2005/04/13 20:24:08  kelsaka
	/// - added enitity methods
	///
	/// Revision 1.7  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// Revision 1.6  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.5  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.4  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.3  2005/04/08 14:40:54  kelsaka
	/// - added implementation and unit-tests
	///
	/// Revision 1.2  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	internal abstract class AbstractBasicComponentBuilder : AbstractEntityBuilder, IBasicComponentBuilder
	{
		#region data

		protected IModelDataManager modelDataManager;
		protected IComponent component;
		protected IBuilderFactory builderFactory;

		#endregion

		#region constructors

		/// <summary>
		/// Initializes the Builder. 
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="component">The component to build.</param>
		/// <param name="builderFactory">The factory to use for creating other builders.</param>
		public AbstractBasicComponentBuilder(IModelDataManager modelDataManager, IComponent component, IBuilderFactory builderFactory)
			: base(component)
		{
			this.modelDataManager = modelDataManager;
			this.component = component;	
			this.builderFactory = builderFactory;
		}

		#endregion

		#region methods

		/// <summary>
		/// Called to add an existing interface as provided interface to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			modelDataManager.LowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, ifaceIdentifier, InterfaceRole.PROVIDES);
		}

		/// <summary>
		/// Called to add an existing interface as required interface to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			modelDataManager.LowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, ifaceIdentifier, InterfaceRole.REQUIRES);
		}

		/// <summary>
		/// Creates a new interface and adds it to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (string interfaceName)
		{
			return AddProvidesInterface(new InternalEntityIdentifier().AsInterfaceIdentifier(),
				interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(ifaceIdentifier, interfaceName);
			modelDataManager.LowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, iInterface.InterfaceID, InterfaceRole.PROVIDES);
			return builderFactory.GetInterfaceTypeLevelBuilder(iInterface);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (string interfaceName)
		{
			return AddRequiresInterface(new InternalEntityIdentifier().AsInterfaceIdentifier(),
				interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(ifaceIdentifier, interfaceName);
			modelDataManager.LowLevelBuilder.AddInterfaceToComponent(this.component.ComponentID, iInterface.InterfaceID, InterfaceRole.REQUIRES);
			return builderFactory.GetInterfaceTypeLevelBuilder(iInterface);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as provides interface (<see cref="InterfaceRole.PROVIDES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveProvidesInterface (IInterfaceIdentifier ifaceID)
		{
			modelDataManager.LowLevelBuilder.RemoveInterfaceFromComponent(this.component.ComponentID, ifaceID, InterfaceRole.PROVIDES);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as requires interface (<see cref="InterfaceRole.REQUIRES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveRequiresInterface (IInterfaceIdentifier ifaceID)
		{
			modelDataManager.LowLevelBuilder.RemoveInterfaceFromComponent(this.component.ComponentID, ifaceID, InterfaceRole.REQUIRES);
		}

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IComponent Component
		{
			get { return this.component; }
		}

		#endregion
	}
}
