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
		protected IViewPluginHost _host;

		protected ComponentModelChangedHandler _componentModelChangedHandler;
		protected EntityChangedHandler _entityChangedHandler;

		public abstract event SelectionChangedHandler SelectionChanged;

		public ViewPluginSkeleton(string name, string descr, string author, string version) :
			base(name,descr,author,version)
		{
			this._componentModelChangedHandler = new ComponentModelChangedHandler(host_ComponentModelChanged);
			this._entityChangedHandler = new EntityChangedHandler(host_EntityChanged);
		}

		#region IViewPlugin Member

		/// <summary>
		/// 
		/// </summary>
		/// <param name="host"></param>
		/// <returns>Returns true if initalization process was successful.</returns>
		/// <remarks>Derived classes that override this method MUST call base.Initialize(host).</remarks>
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
		/// <see cref="UserControlPosition.FLOAT"/> will be returned.</remarks>
		public virtual UserControlPosition UserControlPosition 
		{ 
			get { return UserControlPosition.FLOAT; }
		}

		public abstract System.Windows.Forms.Control ViewControl { get; }

		public abstract Object[] ToolboxItems { get; }

		public abstract void Select(EntityProxies.EntityProxy adapter);
		#endregion

		protected abstract void host_ComponentModelChanged(object source, EntityProxies.CompositeComponentProxy newModel);
		protected abstract void host_EntityChanged(object source, EntityProxies.EntityProxy entity, EntityProxies.EventArgs e);
	}
}
