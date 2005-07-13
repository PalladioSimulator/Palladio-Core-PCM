using System;
using Palladio.ComponentModel;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the base class for all visual representations of the componentmodels entities in the example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/07/13 11:09:47  joemal
	/// add clone methods
	///
	/// Revision 1.1  2005/04/08 10:54:33  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractEntity : ICloneable
	{
		#region data

		/// <summary>
		/// holds the model of the entity
		/// </summary>
		protected IComponentModelEntity entity;

		/// <summary>
		/// hold the environment of the componentmodel
		/// </summary>
		protected ComponentModelEnvironment modelEnvironment;

		#endregion

		#region constructor

		/// <summary>
		/// called to create the visual representation of an entity of the componentmodel
		/// </summary>
		/// <param name="entity">the entity</param>
		/// <param name="modelEnvironment">the model</param>
		public AbstractEntity(IComponentModelEntity entity, ComponentModelEnvironment modelEnvironment)
		{
			this.entity = entity;
			this.modelEnvironment = modelEnvironment;
			Init();
		}

		/// <summary>
		/// called to create a copy of the given entity
		/// </summary>
		/// <param name="entity">the entity to be copied</param>
		protected AbstractEntity(AbstractEntity entity)
		{
			this.entity = entity.entity;
			this.modelEnvironment = entity.modelEnvironment;
		}

		#endregion

		#region private methods

		//does some initial work
		private void Init()
		{
			EntityEvents events = modelEnvironment.EventInterface.GetEntityEvents(entity.ID);
			events.AttributeChangedEvent += new AttributeChangedEventHandler(events_AttributeChangedEvent);
			events.NameChangedEvent += new StaticAttributeChangedEventHandler(events_NameChangedEvent);
		}

		//called when an attribute of the entity has been changed
		private void events_AttributeChangedEvent(object sender, Palladio.Attributes.AttributeChangedEventArgs args)
		{
			Console.WriteLine("Attribute from Type "+args.AttributeType+" changed to "+args.Attribute+".");
		}

		//called when the name of the entity has been changed
		private void events_NameChangedEvent(object sender)
		{
			Console.WriteLine("The name of the entity has changed to "+entity.Name+".");
		}

		#endregion

		#region public methods

		/// <summary>
		/// called to paint the visual representation of an entity and its childs
		/// </summary>
		public abstract void Paint();

		#endregion

		/// <summary>
		/// called to create a copy of this entity
		/// </summary>
		/// <returns></returns>
		public abstract object Clone();
	}
}
