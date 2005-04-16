using System;
using Palladio.Attributes;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.BuilderConstraints.DefaultConstraints
{

	/// <summary>
	/// .
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/16 12:37:46  kelsaka
	/// - added first ideas using constraints with the builders
	///
	/// </pre>
	/// </remarks>
	public class BasicComponentConstraint : IBasicComponentBuilderConstraint
	{
	

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="entity">The enitity instance.</param>
		public void Init (IComponentModelEntity entity)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Adds a <see cref="IAttribute"/> to the AttributeHash.
		/// </summary>
		/// <param name="attributeType">The attributes type to add.</param>
		/// <param name="attribute">The attribute to add.</param>
		public void AddAttribute (IAttributeType attributeType, IAttribute attribute)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Removes a <see cref="IAttribute"/> from the AttributeHash.
		/// </summary>
		/// <param name="attributeType">The attribute to remove.</param>
		public void RemoveAttribute (IAttributeType attributeType)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Adds the given EventHandler to listen for NameChangedEvents. These events are
		/// fired if the entities <see cref="IEntityBuilder.Name"/> changes.
		/// </summary>
		/// <param name="nameChangedListener">The
		/// <see cref="StaticAttributeChangedEventHandler"/> to add.</param>
		public void AddNameChangedEventHandler (StaticAttributeChangedEventHandler nameChangedListener)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Removes the given EventHandler from listening for NameChangedEvents.
		/// </summary>
		/// <param name="nameChangedListener">The
		/// <see cref="StaticAttributeChangedEventHandler"/> to remove.</param>
		public void RemoveNameChangedEventHandler (StaticAttributeChangedEventHandler nameChangedListener)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Gets a copy (!) of the value of the attribute with the specified type.
		/// To change the value, get a copy, change it and then add it again to the table.
		/// </summary>
		public IAttribute this [IAttributeType type]
		{
			get { throw new NotImplementedException (); }
		}

		/// <summary>
		/// Called to add an existing interface as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddProvidesInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Called to add an existing interface as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the existing interface</param>
		public void AddRequiresInterface (IInterfaceIdentifier ifaceIdentifier)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a new interface and adds it as provided interface (<see cref="InterfaceRole.PROVIDES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddProvidesInterface (string interfaceName)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a new interface and adds it as required interface (<see cref="InterfaceRole.REQUIRES"/>) to the actual component.
		/// </summary>
		/// <param name="interfaceName">The name of the newly created interface.</param>
		/// <returns>A <see cref="IInterfaceTypeLevelBuilder"/> to build the new interface.</returns>
		public IInterfaceTypeLevelBuilder AddRequiresInterface (string interfaceName)
		{
			throw new NotImplementedException ();
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
			throw new NotImplementedException ();
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
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IComponent Component
		{
			get { throw new NotImplementedException (); }
		}

		/// <summary>
		/// The name of the entity
		/// </summary>
		public string Name
		{
			get { throw new NotImplementedException (); }
			set { throw new NotImplementedException (); }
		}
	}
}
