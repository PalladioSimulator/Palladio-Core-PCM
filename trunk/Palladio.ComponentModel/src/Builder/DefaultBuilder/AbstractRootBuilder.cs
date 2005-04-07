using System;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// <summary>
	/// The RootBuilder for the component model. Allows to build sub-builders. By default
	/// type-level builders are returned from all levels of builders. This means, that for
	/// each entity the default level is the type-level.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// Revision 1.4  2005/04/06 19:06:58  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.3  2005/03/18 07:36:27  kelsaka
	/// - corrected errors
	///
	/// Revision 1.2  2005/03/17 19:54:12  kelsaka
	/// - added builder-interfaces
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractRootBuilder : IRootBuilder
	{

		private ILowLevelBuilder lowLevelBuilder;


		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder)
		{
			this.lowLevelBuilder = lowLevelBuilder;
		}

		/// <summary>
		/// Creates a new <see cref="IBasicComponentBuilder"/>, which allows to create new components.
		/// </summary>
		/// <returns>The new ComponentBuilder.</returns		
		public IComponentBuilder AddComponent (IComponent component, IComponentIdentifier parentComponentID)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a new <see cref="IBasicComponentBuilder"/>, which allows to create new components.
		/// </summary>
		/// <returns>The new ComponentBuilder.</returns>
		public IBasicComponentTypeLevelBuilder AddBasicComponent (string name)
		{
			IComponent component = EntityFactory.CreateComponent(ModelEntities.ComponentType.BASIC, name);
			lowLevelBuilder.AddComponent(component, null);

			return new DefaultBasicComponentTypeLevelBuilder(lowLevelBuilder, component);
		}

		/// <summary>
		/// Adds a <see cref="IComponent"/> (Type <see cref="ComponentType.COMPOSITE"/>) to the component model.
		/// </summary>
		/// <param name="name">The components name</param>
		/// <returns>A <see cref="ICompositeComponentBuilder"/> to build the further component.</returns>
		public ICompositeComponentBuilder AddCompositeComponent (string name)
		{
			IComponent component = EntityFactory.CreateComponent(ModelEntities.ComponentType.COMPOSITE, name);

			lowLevelBuilder.AddComponent(component, null);
			return null;
			
			//throw new NotImplementedException ();
		}

		/// <summary>
		/// Called to remove the component which belongs to the given id. All contained components
		/// (Type <see cref="ComponentType.COMPOSITE"/>) and
		/// all connections to and from this components are also removed.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		public void RemoveComponent (IComponentIdentifier componentId)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="reqCompID">the id of the incoming component</param>
		/// <param name="reqIFaceID">the incoming components interface</param>
		/// <param name="provCompID">the id of the outgoing component</param>
		/// <param name="provIFaceID">the outgoing components interface</param>
		public void AddAssemblyConnector (IConnection connection, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection (IConnectionIdentifier connectionID)
		{
			throw new NotImplementedException ();
		}




		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <param name="name">The interfaces name.</param>
		/// <returns>A new InterfaceBuilder.</returns>
		public IInterfaceTypeLevelBuilder AddInterface (string name)
		{
			IInterface iInterface = EntityFactory.CreateInterface(name);
			lowLevelBuilder.AddInterface(iInterface);

			return new DefaultInterfaceTypeLevelBuilder(lowLevelBuilder, iInterface);
		}

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">the role bound of the interface in the component</param>
		public void RemoveInterface (IInterfaceIdentifier ifaceIdentifier, InterfaceRole role)
		{
			throw new NotImplementedException ();
		}


	}
}
