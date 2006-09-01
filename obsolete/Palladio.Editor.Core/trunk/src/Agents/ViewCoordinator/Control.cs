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
using System.Reflection;
using System.Collections;
using log4net;

using Palladio.ComponentModel;
using Palladio.Editor.Core.Interfaces;
using Palladio.Editor.Common;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Core.Agents.ViewCoordinator
{
	/// <summary>
	/// The Control Component of the ViewCoordinator PAC agent
	/// </summary>
	internal class Control : IViewCoordinator, IViewPluginHost
	{
		#region Fields
		/// <summary>
		/// log4net logging service</summary>
		private static readonly ILog log = LogManager.GetLogger(typeof(Control));

		/// <summary>
		/// The PluginCoordinator PAC agent</summary>
		private IPluginCoordinator _parent;

		/// <summary>
		/// child agents (ViewPlugins) </summary>
		private Hashtable _plugins;
		#endregion

		#region Public Events
		public event SelectionChangedHandler SelectionChanged;

		/// <summary>
		/// Fired when the active component model has changed entirely.</summary>
		public event ComponentModelChangedHandler ComponentModelChanged;

		/// <summary>
		/// Fired when changes occur within the active component model.</summary>
		public event EntityChangedHandler EntityChanged;
		#endregion

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="parent">parent agent</param>
		public Control(IPluginCoordinator parent)
		{
			this._parent = parent;

			this._plugins = new Hashtable();
		}
		#endregion

		#region IViewCoordinator Member
		public void Initialize()
		{
			log.Debug("Initializing.");

			// hook up to parent agent events
			this._parent.ComponentModelChanged += new ComponentModelChangedHandler(parent_ComponentModelChanged);
			this._parent.EntityChanged += new EntityChangedHandler(parent_EntityChanged);
		}

		public void AttachPlugin(PluginInfo pluginInfo)
		{
			if (!this._plugins.ContainsKey(pluginInfo.TypeName))
			{
				Assembly assembly = Assembly.LoadFile(pluginInfo.Assembly);

				System.Type pluginType = assembly.GetType(pluginInfo.TypeName);

				if (pluginType != null)
				{
					IViewPlugin plugin = Activator.CreateInstance(
						pluginType, 
						new object[]{
										pluginInfo.Name,
										pluginInfo.Description,
										pluginInfo.Author,
										pluginInfo.Version} ) 
						as IViewPlugin;

					if (plugin.Initialize(this)) 
					{
						this._plugins.Add(pluginInfo.TypeName, plugin);
						plugin.SelectionChanged += new SelectionChangedHandler(plugin_SelectionChanged);
						log.Info("ViewPlugin '"+plugin.Name+"' attached");
						this._parent.PluginAttached(plugin);
					} 
					else 
					{
						// plugin.Initialize == 0
						log.Warn("ViewPlugin failed to initialize itself ("+plugin.GetType().ToString()+")");
					}
				}
				else
				{
					// pluginType == null
					log.Warn("Could not instantiate Plugin. Type "+pluginInfo.TypeName+" not found.");
				}
			}
		}

		public void DetachPlugin(string type) 
		{
			if (this._plugins.ContainsKey(type))
			{
				IViewPlugin plugin = (IViewPlugin)this._plugins[type];
				plugin.Detach();
				this._plugins.Remove(type);
				this._parent.PluginDetached(type);
			}
		}
		#endregion

		#region IViewPluginHost Member

		public CompositeComponentProxy GetComponentModel()
		{
			return this._parent.GetComponentModel();
		}

		#endregion

		#region Parent Agent Event Handler
		private void parent_ComponentModelChanged(object source, CompositeComponentProxy newModel)
		{
			if (this.ComponentModelChanged != null)
				this.ComponentModelChanged(this, newModel);
		}

		private void parent_EntityChanged(object source, EntityProxy entity, Palladio.Editor.Common.EntityProxies.EventArgs e)
		{
			if (this.EntityChanged != null)
				this.EntityChanged(this, entity, e);
		}
		#endregion

		#region Child Agents Event Handler
		private void plugin_SelectionChanged(object source, EntityProxy entity)
		{
			if (this.SelectionChanged != null)
				this.SelectionChanged(this, entity);

			foreach(IViewPlugin plugin in this._plugins.Values)
			{
				if (plugin != source)
					plugin.Select(entity);
			}
		}
		#endregion

	}
}
