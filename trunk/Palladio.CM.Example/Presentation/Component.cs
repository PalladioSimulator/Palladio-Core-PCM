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

		#endregion

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
			events.ProvidesInterfaceAddedEvent += new InterfaceUseEventHandler(events_ProvidesInterfaceAddedEvent);
			events.RequiresInterfaceAddedEvent += new InterfaceUseEventHandler(events_RequiresInterfaceAddedEvent);
			events.InterfaceRemovedEvent += new InterfaceUseEventHandler(events_InterfaceRemovedEvent);
		}

		//called when an interface was added to the component as provides interface
		private void events_ProvidesInterfaceAddedEvent(object sender, InterfaceUseEventArgs args)
		{
			IInterface iface = modelEnvironment.Query.QueryEntities.GetInterface(args.InterfaceID);
			IFace iface_gui = new IFace(iface,modelEnvironment);
			childs.Add(args.InterfaceID,iface_gui);
			Console.WriteLine("Interface "+iface.Name+" added as provides interface to the component "+Model.Name+".");

			iface_gui.Paint();									
		}

		//called when an interface was added to the component as requires interface
		private void events_RequiresInterfaceAddedEvent(object sender, InterfaceUseEventArgs args)
		{
			IInterface iface = modelEnvironment.Query.QueryEntities.GetInterface(args.InterfaceID);
			IFace iface_gui = new IFace(iface,modelEnvironment);
			childs.Add(args.InterfaceID,iface_gui);
			Console.WriteLine("Interface "+iface.Name+" added as requires interface to the component "+Model.Name+".");

			iface_gui.Paint();									
		}

		//called when an interface was removed from the component
		private void events_InterfaceRemovedEvent(object sender, InterfaceUseEventArgs args)
		{
			if (!childs.ContainsKey(args.InterfaceID)) return;
			childs.Remove(args.InterfaceID);

			IInterface iface = modelEnvironment.Query.QueryEntities.GetInterface(args.InterfaceID);
			Console.WriteLine("Remove Interface "+iface.Name+" from the component.");
			Console.WriteLine("Repaint the component.");
			this.Paint();
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
