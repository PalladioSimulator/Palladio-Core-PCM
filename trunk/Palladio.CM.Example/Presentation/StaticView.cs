using System;
using System.Collections;
using Palladio.ComponentModel;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the class for the visual representations of the componentmodels static view in the example.
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
	public class StaticView
	{
		#region data

		//holds the model environment
		private ComponentModelEnvironment modelEnvironment;

		//holds the childs of the static view
		private	Hashtable childs = new Hashtable();

		#endregion

		#region constructor 

		/// <summary>
		/// called to create a new visual representation of the static view of the componentmodel 
		/// </summary>
		/// <param name="modelEnvironment">the model</param>
		public StaticView(ComponentModelEnvironment modelEnvironment)
		{
			this.modelEnvironment = modelEnvironment;
			Init();
		}

		#endregion

		#region public methods

		/// <summary>
		/// called to paint the static view and its childs
		/// </summary>
		public void Paint()
		{
			Console.WriteLine("Paint the static view.");
			Console.WriteLine("Paint the childs ...");

			foreach(DictionaryEntry entry in childs)
				((AbstractEntity)entry.Value).Paint();

			Console.WriteLine("Childs painted.");
		}

		#endregion

		#region private methods

		//does some initial work
		private void Init()
		{
			StaticViewEvents events = modelEnvironment.EventInterface.GetStaticViewEvents();
			events.AssemblyConnectorAddedEvent += new AssemblyConnectorBuildEventHandler(events_AssemblyConnectorAddedEvent);
			events.AssembyConnectorRemovedEvent += new ConnectorRemovedEventHandler(events_AssembyConnectorRemovedEvent);
			events.ComponentAddedEvent += new ComponentBuildEventHandler(events_ComponentAddedEvent);
			events.ComponentRemovedEvent += new ComponentBuildEventHandler(events_ComponentRemovedEvent);
			events.InterfaceAddedEvent += new InterfaceBuildEventHandler(events_InterfaceAddedEvent);
			events.InterfaceRemovedEvent += new InterfaceBuildEventHandler(events_InterfaceRemovedEvent);
		}

		//called when an assembly connector has been added to the static view
		private void events_AssemblyConnectorAddedEvent(object sender, AssemblyConnectorBuildEventArgs args)
		{
			Connection con = new Connection(args.AssemblyConnector,this.modelEnvironment);
			childs.Add(args.AssemblyConnector.ID,con);
			Console.WriteLine("AssemblyConnector "+args.AssemblyConnector.Name+" added to static view.");

			IComponent reqComp = ((Component)childs[args.ReqCompId]).Model;
			IComponent provComp = ((Component)childs[args.ProvCompId]).Model;

			Console.WriteLine("Connected from component "+reqComp.Name+" to component "+provComp.Name+".");

			con.Paint();	
		}

		//called when an assembly connector has been removed from the static view
		private void events_AssembyConnectorRemovedEvent(object sender, ConnectorRemovedEventArgs args)
		{
			if (!childs.ContainsKey(args.Connection.ID)) return;
			childs.Remove(args.Connection.ID);
			Console.WriteLine("Remove Connection "+args.Connection.Name+" from the static view.");
			Console.WriteLine("Repaint the static view.");
			this.Paint();
		}

		//called when a component has been added to the static view
		private void events_ComponentAddedEvent(object sender, ComponentBuildEventArgs args)
		{
			Component comp;
			if (args.Component.Type == ComponentType.BASIC)
				comp = new BasicComponent(args.Component,modelEnvironment);
			else
				comp = new CompositeComponent(args.Component,modelEnvironment);

			childs.Add(args.Component.ID,comp);
			Console.WriteLine("Component "+args.Component.Name+" added to the static view.");

			comp.Paint();					
		}

		//called when a component has been removed from the static view
		private void events_ComponentRemovedEvent(object sender, ComponentBuildEventArgs args)
		{
			if (!childs.ContainsKey(args.Component.ID)) return;
			childs.Remove(args.Component.ID);
			Console.WriteLine("Remove Component "+args.Component.Name+" from the static view.");
			Console.WriteLine("Repaint component the static view.");
			this.Paint();				
		}

		//called when an interface has been added to the static view
		private void events_InterfaceAddedEvent(object sender, InterfaceBuildEventArgs args)
		{
            IFace iface = new IFace(args.Interface,this.modelEnvironment);
			childs.Add(args.Interface.ID, iface);
			Console.WriteLine("Interface "+args.Interface.Name+" added to the static view.");
			iface.Paint();
		}

		//called when an interface has been removed from the static view
		private void events_InterfaceRemovedEvent(object sender, InterfaceBuildEventArgs args)
		{
			if (!childs.ContainsKey(args.Interface.ID)) return;
			childs.Remove(args.Interface.ID);
			Console.WriteLine("Remove Interface "+args.Interface.Name+" from the static view.");
			Console.WriteLine("Repaint the static view.");
			this.Paint();				
		}

		#endregion
	}
}
