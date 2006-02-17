#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;

using Palladio.Identifier;

namespace Palladio.Editor.Common
{

	/// <summary>
	/// This is the base class for all view plugins. Derive from this class if 
	/// you want to implement a view.
	/// </summary>
	public abstract class ViewPluginSkeleton : PluginSkeleton, IViewPlugin
	{
		#region Fields
		/// <summary>
		/// The view plugins host.</summary>
		protected IViewPluginHost _host;

		/// <summary>
		/// A handler for the ComponentModelChanged event of the parent host.</summary>
		private ComponentModelChangedHandler _componentModelChangedHandler;

		/// <summary>
		/// A handler for the EntityChanged event of the parent host.</summary>
		private EntityChangedHandler _entityChangedHandler;
		#endregion

		#region Events
		/// <summary>
		/// An event each implementation should fire each time the user 
		/// selects a different entity.</summary>
		public abstract event SelectionChangedHandler SelectionChanged;
		#endregion

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="name">Name</param>
		/// <param name="descr">Description</param>
		/// <param name="author">Author</param>
		/// <param name="version">Version</param>
		public ViewPluginSkeleton(string name, string descr, string author, string version)
			: base(name,descr,author,version)
		{
			this._componentModelChangedHandler = new ComponentModelChangedHandler(host_ComponentModelChanged);
			this._entityChangedHandler = new EntityChangedHandler(host_EntityChanged);
		}
		#endregion

		#region IViewPlugin Member
		/// <summary>
		/// This method is called by the host when a plugin becomes active.
		/// </summary>
		/// <param name="host">The host of the view plugin</param>
		/// <returns>Returns true if initalization process was successful.</returns>
		/// <remarks>Derived classes that override this method should call <code>base.Initialize(host)</code>.</remarks>
		public virtual bool Initialize(IViewPluginHost host)
		{
			this._host = host;
			this._host.ComponentModelChanged += this._componentModelChangedHandler;
			this._host.EntityChanged += this._entityChangedHandler;
			return true;
		}

		/// <summary>
		/// Returns the view control component for presentation and user interaction
		/// </summary>
		public abstract System.Windows.Forms.Control ViewControl { get; }

		/// <summary>
		/// Returns a value that indicates where the ViewControl should be placed within the GUI.
		/// </summary>
		/// <remarks>If this method is not overriden, the default value 
		/// <see cref="Palladio.Editor.Common.UserControlPosition.FLOAT"/> will be returned.</remarks>
		public virtual ViewControlPosition ViewControlPosition 
		{ 
			get { return ViewControlPosition.FLOAT; }
		}

		/// <summary>
		/// Returns the toolbox control component for selecting modelling tools.
		/// </summary>
		public abstract Object[] ToolboxItems { get; }

		/// <summary>
		/// Instructs the plugin to select the specified entity
		/// </summary>
		/// <param name="entity">The entity that should become selected.</param>
		public abstract void Select(EntityProxies.EntityProxy entity);
		#endregion

		/// <summary>
		/// A handler routine for the <see cref="Palladio.Editor.Common.IViewPluginHost.ComponentModelChanged"/> 
		/// event which all plugins must implement.
		/// </summary>
		/// <param name="source">Event dispatcher (ViewPluginHost)</param>
		/// <param name="newModel">The new component model</param>
		protected abstract void host_ComponentModelChanged(object source, EntityProxies.CompositeComponentProxy newModel);

		/// <summary>
		/// A handler routine for the <see cref="Palladio.Editor.Common.IViewPluginHost.EntityChanged"/> 
		/// event which all plugins must implement.
		/// </summary>
		/// <param name="source">Event dispatcher (ViewPluginHost)</param>
		/// <param name="entity">A proxy representing the changed entity</param>
		/// <param name="evtArgs">Event parameter</param>
		protected abstract void host_EntityChanged(object source, EntityProxies.EntityProxy entity, EntityProxies.EventArgs evtArgs);
	}
}
