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
	/// Revision 1.6  2005/10/26 08:52:32  kelsaka
	/// - adapted to new usage of event-interface
	///
	/// Revision 1.5  2005/07/13 11:09:47  joemal
	/// add clone methods
	///
	/// Revision 1.4  2005/06/25 16:52:20  joemal
	/// changes in the example
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
	public class StaticView
	{
		#region data

		//holds the model environment
		private ComponentModelEnvironment modelEnvironment;

		//holds the childs of the static view
		private	Hashtable childs = new Hashtable();

		private Repository repository;

		#endregion

		#region constructor 

		/// <summary>
		/// called to create a new visual representation of the static view of the componentmodel 
		/// </summary>
		/// <param name="modelEnvironment">the model</param>
		public StaticView(ComponentModelEnvironment modelEnvironment)
		{
			this.modelEnvironment = modelEnvironment;
			this.repository = new Repository(modelEnvironment);
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
			IStaticViewEvents events = modelEnvironment.EventInterface.GetStaticViewEvents();
			events.AssemblyConnectorAddedEvent += new AssemblyConnectorBuildEventHandler(events_AssemblyConnectorAddedEvent);
			events.AssembyConnectorRemovedEvent += new ConnectorRemovedEventHandler(events_AssembyConnectorRemovedEvent);
			events.ComponentAddedEvent +=new ComponentUseEventHandler(events_ComponentAddedEvent);
			events.ComponentRemovedEvent +=new ComponentUseEventHandler(events_ComponentRemovedEvent);
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
		}

		//called when an assembly connector has been removed from the static view
		private void events_AssembyConnectorRemovedEvent(object sender, ConnectorRemovedEventArgs args)
		{
			if (!childs.ContainsKey(args.Connection.ID)) return;
			childs.Remove(args.Connection.ID);
			Console.WriteLine("Remove Connection "+args.Connection.Name+" from the static view.");
			Console.WriteLine("Repaint the static view.");
		}

		//called when a component as been added to the static view
		private void events_ComponentAddedEvent(object sender, ComponentUseEventArgs args)
		{
			IComponent comp = modelEnvironment.Query.QueryRepository.GetComponent(args.ComponentID);
			Component comp_gui=repository.CreateComponentUsage(args.ComponentID);

			childs.Add(args.ComponentID,comp_gui);
			Console.WriteLine("Component "+comp.Name+" added to the static view.");
		}

		//called when a component as been removed from the static view
		private void events_ComponentRemovedEvent(object sender, ComponentUseEventArgs args)
		{
			IComponent comp = modelEnvironment.Query.QueryRepository.GetComponent(args.ComponentID);
			if (!childs.ContainsKey(args.ComponentID)) return;
			childs.Remove(args.ComponentID);
			Console.WriteLine("Remove Component "+comp.Name+" from the static view.");
			Console.WriteLine("Repaint component the static view.");
		}
	
		#endregion
	}
}
