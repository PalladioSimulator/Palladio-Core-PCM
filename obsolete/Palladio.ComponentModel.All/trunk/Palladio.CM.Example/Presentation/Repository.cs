using System;
using System.Collections;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the class for the visual representations of the repository in the example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/10/26 08:52:32  kelsaka
	/// - adapted to new usage of event-interface
	///
	/// Revision 1.1  2005/07/13 11:05:42  joemal
	/// initial creation
	///
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class Repository
	{
		//holds the model environment
		private ComponentModelEnvironment modelEnvironment;

		//holds the entities in the repository
		private	Hashtable childs = new Hashtable();

		/// <summary>
		/// constructs a new graphic representation of the repository
		/// </summary>
		/// <param name="modelEnvironment">the model environment</param>
		public Repository(ComponentModelEnvironment modelEnvironment)
		{
			this.modelEnvironment = modelEnvironment;
			Init();
		}

		#region private methods

		//private does some initial work
        private void Init()
		{
        	IRepositoryEvents ev = this.modelEnvironment.EventInterface.GetRepositoryEvents();

			ev.ComponentAddedEvent +=new ComponentBuildEventHandler(ev_ComponentAddedEvent);
			ev.ComponentRemovedEvent +=new ComponentBuildEventHandler(ev_ComponentRemovedEvent);
			ev.InterfaceAddedEvent +=new InterfaceBuildEventHandler(ev_InterfaceAddedEvent);
			ev.InterfaceRemovedEvent +=new InterfaceBuildEventHandler(ev_InterfaceRemovedEvent);
		}

		//called when a component has been added to the repository
		private void ev_ComponentAddedEvent(object sender, ComponentBuildEventArgs args)
		{
			if (args.Component.Type == ComponentType.BASIC)
				this.childs.Add(args.Component.ID,new BasicComponent(args.Component,this));
			else
				this.childs.Add(args.Component.ID,new CompositeComponent(args.Component,this));

			Console.WriteLine("Component "+args.Component.Name+" has been created.");
		}

		//called when a component has been removed from the repository
		private void ev_ComponentRemovedEvent(object sender, ComponentBuildEventArgs args)
		{
			childs.Remove(args.Component.ComponentID);
			Console.WriteLine("Component "+args.Component.Name+" has been destroyed.");
		}

		//called when an interface has been added to the repository
		private void ev_InterfaceAddedEvent(object sender, InterfaceBuildEventArgs args)
		{
			this.childs.Add(args.Interface.ID,new IFace(args.Interface,this.modelEnvironment));
			Console.WriteLine("Interface "+args.Interface.Name+" has been created.");
		}

		//called when an interface has been removed from the repository
		private void ev_InterfaceRemovedEvent(object sender, InterfaceBuildEventArgs args)
		{
			childs.Remove(args.Interface.InterfaceID);
			Console.WriteLine("Interface "+args.Interface.Name+" has been destroyed.");
		}

		#endregion 

		#region public members

		/// <summary>
		/// creates a new visual representation of a component that can be added to the static view or to another
		/// component. In our example this is a memberwise copy of the one in the repository but it might been any other object. 
		/// </summary>
		/// <param name="compID">the id of the requested component</param>
		/// <returns>the visual representation of a component</returns>
		public Component CreateComponentUsage(IComponentIdentifier compID)
		{
			if (!childs.ContainsKey(compID)) return null;
			return (Component) ((Component)this.childs[compID]).Clone();
		}

		/// <summary>
		/// creates a new visual representation of an interface that can be added to components. 
		/// In our example this is a memberwise copy of the one in the repository but it might been any other object. 
		/// </summary>
		/// <param name="ifaceID">the id of the requested interface</param>
		/// <returns>the visual representation of an interface</returns>
		public IFace CreateIfaceUsage(IInterfaceIdentifier ifaceID)
		{
			if (!childs.ContainsKey(ifaceID)) return null;
			return (IFace) ((IFace)this.childs[ifaceID]).Clone();
		}

		/// <summary>
		/// returns the modelenvironment
		/// </summary>
		public ComponentModelEnvironment ModelEnvironment
		{
			get { return modelEnvironment; }
		}

		#endregion
	}
}
