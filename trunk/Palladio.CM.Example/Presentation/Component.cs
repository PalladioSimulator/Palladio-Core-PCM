using System;
using Palladio.ComponentModel;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the base class for all visual representations of the componentmodels components in the example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/08 10:54:33  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public abstract class Component : AbstractEntity
	{
		#region constructor

		/// <summary>
		/// called to create a new representation for the given component
		/// </summary>
		/// <param name="comp">the component</param>
		/// <param name="modelEnvironment">the model</param>
		public Component(IComponent comp, ComponentModelEnvironment modelEnvironment):base(comp,modelEnvironment)
		{
			Init();
		}

		#endregion

		#region private methods

		//does some initial work
		private void Init()
		{
			ComponentEvents events = modelEnvironment.EventInterface.GetComponentEvents(Model.ComponentID);
			events.ProvidesInterfaceAddedEvent += new InterfaceBuildEventHandler(events_ProvidesInterfaceAddedEvent);
			events.RequiresInterfaceAddedEvent += new InterfaceBuildEventHandler(events_RequiresInterfaceAddedEvent);
			events.InterfaceRemovedEvent += new InterfaceBuildEventHandler(events_InterfaceRemovedEvent);
		}

		//called when an interface was added to the component as provides interface
		private void events_ProvidesInterfaceAddedEvent(object sender, InterfaceBuildEventArgs args)
		{
			Console.WriteLine("Interface "+ args.Interface.Name +" added to component "+Model.Name+
				" as provides interface.");
		}

		//called when an interface was added to the component as requires interface
		private void events_RequiresInterfaceAddedEvent(object sender, InterfaceBuildEventArgs args)
		{
			Console.WriteLine("Interface "+ args.Interface.Name +" added to component "+Model.Name+
				" as requires interface.");
		}

		//called when an interface was removed from the component
		private void events_InterfaceRemovedEvent(object sender, InterfaceBuildEventArgs args)
		{
			Console.WriteLine(("Interface "+args.Interface.Name+" removed from Component "+Model.Name+"."));
		}

		#endregion

		#region properties

		/// <summary>
		/// called to return the model of the component
		/// </summary>
		public IComponent Model
		{
			get
			{
				return (IComponent) this.entity;
			}
		}

		#endregion
	}
}
