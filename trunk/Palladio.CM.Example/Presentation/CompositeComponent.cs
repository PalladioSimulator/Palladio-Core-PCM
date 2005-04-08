using System;
using System.Collections;
using Palladio.ComponentModel;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the class for all visual representations of the componentmodels compositecomponents in the example.
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
	public class CompositeComponent : Component
	{
		#region data

		//holds the hashtable for the childs
		private Hashtable childs = new Hashtable();

		#endregion

		#region constructor 

		/// <summary>
		/// called to create a visual representation of a basic component
		/// </summary>
		/// <param name="comp"></param>
		/// <param name="modelEnvironment"></param>
		public CompositeComponent(IComponent comp, ComponentModelEnvironment modelEnvironment) : base(comp, modelEnvironment)
		{
			Init();
		}

		#endregion

		#region private methods 

		//does some initial work
		private void Init()
		{
			CompositeComponentEvents events = modelEnvironment.EventInterface.GetCompositeComponentEvents(Model.ComponentID);
			events.ComponentAddedEvent += new ComponentBuildEventHandler(events_ComponentAddedEvent);
			events.ComponentRemovedEvent += new ComponentBuildEventHandler(events_ComponentRemovedEvent);
			events.ConnectorRemovedEvent += new ConnectorRemovedEventHandler(events_ConnectorRemovedEvent);
			events.AssemblyConnectorAddedEvent += new AssemblyConnectorBuildEventHandler(events_AssemblyConnectorAddedEvent);
			events.DelegationConnectorAddedEvent += new DelegationConnectorBuildEventHandler(events_DelegationConnectorAddedEvent);
		}
		
		//called when a component has been added to this one
		private void events_ComponentAddedEvent(object sender, ComponentBuildEventArgs args)
		{
			Component comp;
			if (args.Component.Type == ComponentType.BASIC)
				comp = new BasicComponent(args.Component,modelEnvironment);
			else
				comp = new CompositeComponent(args.Component,modelEnvironment);

			childs.Add(args.Component.ID,comp);
			Console.WriteLine("Component "+args.Component.Name+" added to component "+this.Model.Name+".");

			comp.Paint();			
		}

		//called when a component has been removed from this one
		private void events_ComponentRemovedEvent(object sender, ComponentBuildEventArgs args)
		{
			if (!childs.ContainsKey(args.Component.ID)) return;
			childs.Remove(args.Component.ID);
			Console.WriteLine("Remove Component "+args.Component.Name+" from Component "+Model.Name+".");
			Console.WriteLine("Repaint component "+Model.Name+".");
			this.Paint();
		}

		//called when an assembly connector has been added to the model
		private void events_AssemblyConnectorAddedEvent(object sender, AssemblyConnectorBuildEventArgs args)
		{
			Connection con = new Connection(args.AssemblyConnector,this.modelEnvironment);
			childs.Add(args.AssemblyConnector.ID,con);
			Console.WriteLine("AssemblyConnector "+args.AssemblyConnector.Name+" added to component "+Model.Name+".");

			IComponent reqComp = ((Component)childs[args.ReqCompId]).Model;
			IComponent provComp = ((Component)childs[args.ProvCompId]).Model;

			Console.WriteLine("Connected from component "+reqComp.Name+" to component "+provComp.Name+".");

			con.Paint();
		}

		//called when a delegation connector has been added to the model
		private void events_DelegationConnectorAddedEvent(object sender, DelegationConnectorBuildEventArgs args)
		{
			Connection con = new Connection(args.Connection,this.modelEnvironment);
			childs.Add(args.Connection.ID,con);
			Console.WriteLine("DelegationConnector "+args.Connection.Name+" added to component "+Model.Name+".");

			IComponent innerComp = ((Component)childs[args.InnerCompId]).Model;

			Console.WriteLine("Connected from component "+Model.Name+" to component "+innerComp.Name+".");

			con.Paint();
		}

		//called when a connector has been removed from the model
		private void events_ConnectorRemovedEvent(object sender, ConnectorRemovedEventArgs args)
		{
			if (!childs.ContainsKey(args.Connection.ID)) return;
			childs.Remove(args.Connection.ID);
			Console.WriteLine("Remove Connection "+args.Connection.Name+" from Component "+Model.Name+".");
			Console.WriteLine("Repaint component "+Model.Name+".");
			this.Paint();
		}

		#endregion

		#region public methods 

		/// <summary>
		/// called to paint the component
		/// </summary>
		public override void Paint()
		{			
			Console.WriteLine("CompsiteComponent "+this.Model.Name+" painted.");
			Console.WriteLine("Paint the childs ... ");

			foreach(DictionaryEntry entry in childs)
				((AbstractEntity)entry.Value).Paint();

			Console.WriteLine("Childs painted.");
		}

		#endregion
	}
}
