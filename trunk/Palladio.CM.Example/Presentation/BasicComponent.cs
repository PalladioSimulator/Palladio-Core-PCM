using System;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the class for all visual representations of the componentmodels basiccomponents in the example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/07/29 16:29:30  joemal
	/// add protocols to example
	///
	/// Revision 1.3  2005/07/13 11:09:47  joemal
	/// add clone methods
	///
	/// Revision 1.2  2005/06/05 10:41:04  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.1  2005/04/08 10:54:33  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class BasicComponent : Component
	{
		/// <summary>
		/// called to create a visual representation of a basic component
		/// </summary>
		/// <param name="comp">the component</param>
		/// <param name="repository">the repository</param>
		public BasicComponent(IComponent comp, Repository repository) : base(comp, repository)
		{
			Init();
		}

		/// <summary>
		/// called to create a new component as a copy of the given one
		/// </summary>
		/// <param name="component">the component to be copied</param>
		private BasicComponent(BasicComponent component) : base(component)
		{		
			Init();
		}

		private void Init()
		{
			BasicComponentEvents events = modelEnvironment.EventInterface.GetBasicComponentEvents(Model.ComponentID);
			events.SeffAddedEvent +=new SeffBuildEventHandler(events_SeffAddedEvent);
			events.SeffRemovedEvent += new SeffBuildEventHandler(events_SeffRemovedEvent);
		}

		/// <summary>
		/// called to create a copy of this entity
		/// </summary>
		/// <returns></returns>
		public override object Clone()
		{
			return new BasicComponent(this);
		}

		//called when a seff has been added to the component
		private void events_SeffAddedEvent(object sender, SeffBuildEventArgs args)
		{
			Console.WriteLine("Service effect specification added to the basic component "+this.Model.Name+".");
		}

		//called when a seff has been removed from the component
		private void events_SeffRemovedEvent(object sender, SeffBuildEventArgs args)
		{
			Console.WriteLine("Service effect specification removed from the basic component "+this.Model.Name+".");
		}
	}
}
