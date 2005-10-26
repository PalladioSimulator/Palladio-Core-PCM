using System;
using System.Collections;
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
	/// Revision 1.5  2005/10/26 08:52:32  kelsaka
	/// - adapted to new usage of event-interface
	///
	/// Revision 1.4  2005/07/13 11:09:47  joemal
	/// add clone methods
	///
	/// Revision 1.3  2005/06/12 17:07:31  joemal
	/// renamed from QueryEntity to QueryRepository
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
	public abstract class Component : AbstractEntity
	{
		#region data

		//holds the childs of the static view
		protected Hashtable childs = new Hashtable();

		//the repository
		protected Repository repository;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new representation for the given component
		/// </summary>
		/// <param name="comp">the component</param>
		/// <param name="repository">the repository</param>
		public Component(IComponent comp, Repository repository):base(comp,repository.ModelEnvironment)
		{
			this.repository = repository;
			Init();
		}

		/// <summary>
		/// called to create a new component as a copy of the given one
		/// </summary>
		/// <param name="component">the component to be copied</param>
		protected Component(Component component) : base (component)
		{
			foreach(DictionaryEntry entry in component.childs)
				this.childs.Add(entry.Key,entry.Value);
			this.repository = component.repository;
			Init();
		}

		#endregion

		#region private methods

		//does some initial work
		private void Init()
		{
			IComponentEvents events = modelEnvironment.EventInterface.GetComponentEvents(Model.ComponentID);
			events.ProvidesInterfaceAddedEvent += new InterfaceUseEventHandler(events_ProvidesInterfaceAddedEvent);
			events.RequiresInterfaceAddedEvent += new InterfaceUseEventHandler(events_RequiresInterfaceAddedEvent);
			events.InterfaceRemovedEvent += new InterfaceUseEventHandler(events_InterfaceRemovedEvent);
		}

		//called when an interface was added to the component as provides interface
		private void events_ProvidesInterfaceAddedEvent(object sender, InterfaceUseEventArgs args)
		{
			IInterface iface = this.modelEnvironment.Query.QueryRepository.GetInterface(args.InterfaceID);
			IFace iface_gui = this.repository.CreateIfaceUsage(args.InterfaceID);
			childs.Add(args.InterfaceID,iface_gui);
			Console.WriteLine("Interface "+iface.Name+" added as provides interface to the component "+Model.Name+".");
		}

		//called when an interface was added to the component as requires interface
		private void events_RequiresInterfaceAddedEvent(object sender, InterfaceUseEventArgs args)
		{
			IInterface iface = modelEnvironment.Query.QueryRepository.GetInterface(args.InterfaceID);
			IFace iface_gui = this.repository.CreateIfaceUsage(args.InterfaceID);
			childs.Add(args.InterfaceID,iface_gui);
			Console.WriteLine("Interface "+iface.Name+" added as requires interface to the component "+Model.Name+".");
		}

		//called when an interface was removed from the component
		private void events_InterfaceRemovedEvent(object sender, InterfaceUseEventArgs args)
		{
			if (!childs.ContainsKey(args.InterfaceID)) return;
			childs.Remove(args.InterfaceID);

			IInterface iface = modelEnvironment.Query.QueryRepository.GetInterface(args.InterfaceID);
			Console.WriteLine("Remove Interface "+iface.Name+" from the component.");
		}

		/// <summary>
		/// called to paint the component
		/// </summary>
		public override void Paint()
		{			
			Console.WriteLine("Component "+this.Model.Name+" painted.");
			Console.WriteLine("Paint the childs ... ");

			foreach(AbstractEntity child in childs.Values)
				child.Paint();

			Console.WriteLine("Childs painted.");
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
