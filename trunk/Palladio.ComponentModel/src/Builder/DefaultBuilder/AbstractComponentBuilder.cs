using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of a component builder - methods that are available at all levels.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/06/05 10:28:35  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	internal abstract class AbstractComponentBuilder : AbstractEntityBuilder, IComponentBuilder
	{
		#region constructors

		/// <summary>
		/// Initializes the Builder. 
		/// </summary>
		/// <param name="compID">the id of this builders component</param>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="builderManager">The factory to use for creating other builders.</param>
		public AbstractComponentBuilder(IComponentIdentifier compID,IModelDataManager modelDataManager, IBuilderManager builderManager)
			: base(compID, builderManager, modelDataManager)
		{
		}

		#endregion

		#region methods

		/// <summary>
		/// Called to add an existing interface as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddExistingInterfaceAsProvides(IInterfaceIdentifier ifaceIdentifier)
		{
			base.ModelDataManager.LowLevelBuilder.AddInterface(this.ComponentId, ifaceIdentifier, InterfaceRole.PROVIDES);			
		}

		/// <summary>
		/// Called to add an existing interface as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddExistingInterfaceAsRequires(IInterfaceIdentifier ifaceIdentifier)
		{
			base.ModelDataManager.LowLevelBuilder.AddInterface(this.ComponentId, ifaceIdentifier, InterfaceRole.REQUIRES);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddNewInterfaceAsProvides(string interfaceName)
		{
			return this.AddNewInterfaceAsProvides(new InternalEntityIdentifier().AsInterfaceIdentifier(),interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddNewInterfaceAsProvides(IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(ifaceIdentifier, interfaceName);
			base.ModelDataManager.LowLevelBuilder.CreateInterface(iInterface);
			base.ModelDataManager.LowLevelBuilder.AddInterface(this.ComponentId, iInterface.InterfaceID, InterfaceRole.PROVIDES);
			return base.BuilderManager.GetInterfaceTypeLevelBuilder(iInterface);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddNewInterfaceAsRequires(string interfaceName)
		{
			return this.AddNewInterfaceAsRequires(new InternalEntityIdentifier().AsInterfaceIdentifier(),interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="IInterfaceTypeLevelBuilder"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="InterfaceRole.REQUIRES"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddNewInterfaceAsRequires(IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			IInterface iInterface = EntityFactory.CreateInterface(ifaceIdentifier, interfaceName);
			base.ModelDataManager.LowLevelBuilder.CreateInterface(iInterface);
			base.ModelDataManager.LowLevelBuilder.AddInterface(this.ComponentId, iInterface.InterfaceID, InterfaceRole.REQUIRES);
			return base.BuilderManager.GetInterfaceTypeLevelBuilder(iInterface);
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
			base.ModelDataManager.LowLevelBuilder.RemoveInterfaceFromComponent(this.ComponentId, ifaceID, InterfaceRole.PROVIDES);
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
			base.ModelDataManager.LowLevelBuilder.RemoveInterfaceFromComponent(this.ComponentId, ifaceID, InterfaceRole.REQUIRES);
		}

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IComponent Component
		{
			get { return this.ModelDataManager.Query.QueryEntities.GetComponent(this.ComponentId); }
		}

		/// <summary>
		/// Accesses the identifier of the actual instance.
		/// </summary>
		public IComponentIdentifier ComponentId
		{
			get { return (IComponentIdentifier) this.Id; }
		}

		#endregion
	}
}
