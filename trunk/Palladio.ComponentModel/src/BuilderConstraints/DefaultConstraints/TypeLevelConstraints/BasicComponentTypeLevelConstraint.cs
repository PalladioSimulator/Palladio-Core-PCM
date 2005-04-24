using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.BuilderConstraints.DefaultConstraints.TypeLevelConstraints
{

	/// <summary>
	/// Default constraints for basic components at the type level. This constraints are used always
	/// as they are the neccessary for a valid and consistent static structure of the component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
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
	public class BasicComponentTypeLevelConstraint : IBasicComponentTypeLevelBuilder
	{
		#region data
		
		private IBasicComponentTypeLevelBuilder basicComponentBuilderSuccessor;
		private IModelDataManager modelDataManager;
		private IComponent component;

		#endregion

		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="modelDataManager">The model data manager to use for executing e. g. queries.</param>
		public BasicComponentTypeLevelConstraint(IModelDataManager modelDataManager)
		{
			this.modelDataManager = modelDataManager;
		}

		/// <summary>
		/// Internal constructor.
		/// </summary>
		/// <param name="modelDataManager">The model data manager to use for executing e. g. queries.</param>
		/// <param name="component">The component this instance is constraint for.</param>
		private BasicComponentTypeLevelConstraint(IModelDataManager modelDataManager, IComponent component)
		{
			this.modelDataManager = modelDataManager;
			this.component = component;
		}

		#endregion

		/// <summary>
		/// Called to add an existing interface as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			this.basicComponentBuilderSuccessor.AddProvidesInterface(ifaceIdentifier);
		}

		/// <summary>
		/// Called to add an existing interface as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			this.basicComponentBuilderSuccessor.AddRequiresInterface(ifaceIdentifier);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="IInterfaceTypeLevelBuilder"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="InterfaceRole.PROVIDES"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (string interfaceName)
		{
			return this.basicComponentBuilderSuccessor.AddProvidesInterface(interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="IInterfaceTypeLevelBuilder"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="InterfaceRole.PROVIDES"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			return this.basicComponentBuilderSuccessor.AddProvidesInterface(ifaceIdentifier, interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (string interfaceName)
		{
			return this.basicComponentBuilderSuccessor.AddRequiresInterface(interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="IInterfaceTypeLevelBuilder"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="InterfaceRole.REQUIRES"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			return this.basicComponentBuilderSuccessor.AddRequiresInterface(ifaceIdentifier, interfaceName);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as provided interface (<see cref="InterfaceRole.PROVIDES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveProvidesInterface (IInterfaceIdentifier ifaceID)
		{
			this.basicComponentBuilderSuccessor.RemoveProvidesInterface(ifaceID);
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
			this.basicComponentBuilderSuccessor.RemoveRequiresInterface(ifaceID);
		}

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IComponent Component
		{
			get
			{
				return basicComponentBuilderSuccessor.Component;
			}
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public IBasicComponentImplementationLevelBuilder ImplementationLevelBuilder
		{
			get
			{
				return this.basicComponentBuilderSuccessor.ImplementationLevelBuilder;
			}
		}

		#region constraint-management

		/// <summary>
		/// The child builder to call for each method defined in the builder interface.
		/// </summary>
		public IBasicComponentTypeLevelBuilder ChildBuilder
		{
			set
			{
				this.basicComponentBuilderSuccessor = value;
			}
		}

		/// <summary>
		/// Clones the actual builder / constraints instance except the created / supervised
		/// component model entity.
		/// </summary>
		/// <param name="component">The component model entity that has to be builder /
		/// supervised.</param>
		/// <returns>A copy of the actual builder / constraint.</returns>
		public IBasicComponentTypeLevelBuilder Clone (IComponent component)
		{
			return new BasicComponentTypeLevelConstraint(modelDataManager, component);
		}

		#endregion
	}
}
