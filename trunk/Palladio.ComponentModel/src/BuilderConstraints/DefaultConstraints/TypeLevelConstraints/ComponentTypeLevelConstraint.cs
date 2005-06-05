using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;

namespace Palladio.ComponentModel.BuilderConstraints.DefaultConstraints.TypeLevelConstraints
{

	/// <summary>
	/// Default constraints for components at the type level. This constraints are used always
	/// as they are the neccessary for a valid and consistent static structure of the component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.1  2005/06/05 10:28:35  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentTypeLevelConstraint : AbstractEntityConstraint,IComponentBuilder
	{
		#region data
		
		/// <summary>
		/// the successor of this constraint
		/// </summary>
		protected IComponentBuilder componentBuilderSuccessor;

		#endregion

		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="query">the query interface of the model.</param>
		public ComponentTypeLevelConstraint(IQuery query):
			base(query)
		{
		}

		/// <summary>
		/// Internal constructor.
		/// </summary>
		/// <param name="query">the query interface of the model.</param>
		/// <param name="componentId">The id of the component this instance is constraint for.</param>
		protected ComponentTypeLevelConstraint(IComponentIdentifier componentId, IQuery query):
			base(componentId,query)

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
			this.componentBuilderSuccessor.AddExistingInterfaceAsProvides(ifaceIdentifier);
		}

		/// <summary>
		/// Called to add an existing interface as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddExistingInterfaceAsRequires(IInterfaceIdentifier ifaceIdentifier)
		{
			this.componentBuilderSuccessor.AddExistingInterfaceAsRequires(ifaceIdentifier);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="IInterfaceTypeLevelBuilder"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="InterfaceRole.PROVIDES"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddNewInterfaceAsProvides(string interfaceName)
		{
			return this.componentBuilderSuccessor.AddNewInterfaceAsProvides(interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="IInterfaceTypeLevelBuilder"/>) to the actual component.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="ifaceIdentifier">The new interfaces identifier.</param>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="InterfaceRole.PROVIDES"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddNewInterfaceAsProvides(IInterfaceIdentifier ifaceIdentifier, string interfaceName)
		{
			return this.componentBuilderSuccessor.AddNewInterfaceAsProvides(ifaceIdentifier, interfaceName);
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddNewInterfaceAsRequires(string interfaceName)
		{
			return this.componentBuilderSuccessor.AddNewInterfaceAsRequires(interfaceName);
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
			return this.componentBuilderSuccessor.AddNewInterfaceAsRequires(ifaceIdentifier, interfaceName);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as provided interface (<see cref="InterfaceRole.PROVIDES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		/// <remarks>Only if the given interface is provided by the actual component the
		/// interface will be deleted. Other a exception will be thrown.</remarks>
		/// <exception cref="InterfaceNotFromComponentException">Will be thrown if
		/// the actual component does not provide the given interface.</exception>
		public void RemoveProvidesInterface(IInterfaceIdentifier ifaceID)
		{
			if(!this.Query.QueryTypeLevel
				.QueryBasicComponent(this.ComponentId).IsProvidesInterface(ifaceID))
			{			
				throw new InterfaceNotFromComponentException(this.ComponentId, ifaceID,
					"The interface to delete is not provided by the component.");
			}
			this.componentBuilderSuccessor.RemoveProvidesInterface(ifaceID);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// This method deletes the interface used as requires interface (<see cref="InterfaceRole.REQUIRES"/>).
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		/// <remarks>Only if the given interface is required by the actual component the
		/// interface will be deleted. Other a exception will be thrown.</remarks>
		/// <exception cref="InterfaceNotFromComponentException">Will be thrown if
		/// the actual component does not require the given interface.</exception>
		public void RemoveRequiresInterface(IInterfaceIdentifier ifaceID)
		{
			if(!this.Query.QueryTypeLevel
				.QueryBasicComponent(this.ComponentId).IsRequiresInterface(ifaceID))
			{			
				throw new InterfaceNotFromComponentException(this.ComponentId, ifaceID,
					"The interface to delete is not required by the component.");
			}
			this.componentBuilderSuccessor.RemoveRequiresInterface(ifaceID);
		}

		#endregion

		#region properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IComponent Component
		{
			get
			{
				return this.componentBuilderSuccessor.Component;
			}
		}

		/// <summary>
		/// Accesses the identifier of the actual instance.
		/// </summary>
		public IComponentIdentifier ComponentId
		{
			get
			{
				return this.componentBuilderSuccessor.ComponentId;
			}
		}

		#endregion
	}
}
