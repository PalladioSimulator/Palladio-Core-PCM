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
	/// Zusammenfassung für ViewPluginSkeleton.
	/// </summary>
	public abstract class ViewPluginSkeleton : PluginSkeleton, IViewPlugin
	{
		#region Fields
		/// <summary>
		/// The view plugins host.</summary>
		protected IViewPluginHost _host;

		/// <summary>
		/// </summary>
		private ComponentModelChangedHandler _componentModelChangedHandler;

		/// <summary>
		/// </summary>
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
		/// <param name="name"></param>
		/// <param name="descr"></param>
		/// <param name="author"></param>
		/// <param name="version"></param>
		public ViewPluginSkeleton(string name, string descr, string author, string version) :
			base(name,descr,author,version)
		{
			this._componentModelChangedHandler = new ComponentModelChangedHandler(host_ComponentModelChanged);
			this._entityChangedHandler = new EntityChangedHandler(host_EntityChanged);
		}
		#endregion

		#region IViewPlugin Member
		/// <summary>
		/// 
		/// </summary>
		/// <param name="host">The view plugins host</param>
		/// <returns>Returns true if initalization process was successful.</returns>
		/// <remarks>Derived classes that override this method MUST call <code>base.Initialize(host)</code>.</remarks>
		public virtual bool Initialize(IViewPluginHost host)
		{
			this._host = host;
			this._host.ComponentModelChanged += this._componentModelChangedHandler;
			this._host.EntityChanged += this._entityChangedHandler;
			return true;
		}

		/// <summary>
		/// Returns a value indicating where to place the usercontrol of this plugin.
		/// </summary>
		/// <remarks>If this method is not overriden, the default value 
		/// <see cref="Palladio.Editor.Common.UserControlPosition.FLOAT"/> will be returned.</remarks>
		public virtual UserControlPosition UserControlPosition 
		{ 
			get { return UserControlPosition.FLOAT; }
		}

		/// <summary>
		/// 
		/// </summary>
		public abstract System.Windows.Forms.Control ViewControl { get; }

		/// <summary>
		/// 
		/// </summary>
		public abstract Object[] ToolboxItems { get; }

		/// <summary>
		/// 
		/// </summary>
		/// <param name="entity"></param>
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
		/// <param name="evtArgs"></param>
		protected abstract void host_EntityChanged(object source, EntityProxies.EntityProxy entity, EntityProxies.EventArgs evtArgs);
	}
}
