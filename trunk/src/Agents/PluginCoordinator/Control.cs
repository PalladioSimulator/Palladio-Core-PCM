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

using Palladio.Editor.Common;
using Palladio.Editor.Core.Interfaces;
using Palladio.Editor.Common.EntityProxies;
using Palladio.ComponentModel;

namespace Palladio.Editor.Core.Agents.PluginCoordinator
{
	/// <summary>
	/// The Control Component of the PluginCoordinator PAC agent
	/// </summary>
	internal class Control : IPluginCoordinator, IAbstractionAdapter
	{
		#region Fields
		private static readonly ILog log = LogManager.GetLogger(typeof(Control));

		/// <summary>
		/// The Core PAC agent</summary>
		private IRootAgent _parent;

		/// <summary>
		/// The Presentation Component of the PluginCoordinator PAC agent</summary>
		private Presentation.Facade _presentation;

		/// <summary>
		/// The Abstraction Component of the PluginCoordinator PAC agent</summary>
		private Abstraction _abstraction;

		/// <summary>
		/// A child PAC agent responsible for ViewPlugin coordination</summary>
		private IViewCoordinator _viewCoordinator;
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
		public Control(IRootAgent parent)
		{
			this._parent = parent;

			// create presentation and abstraction components
			this._presentation = new Presentation.Facade(this);
			this._abstraction = new Abstraction(this);

			// create child agents
			this._viewCoordinator = Agents.AgentFactory.CreateViewCoordinator(this);
		}
		#endregion

		#region IPluginCoordinator Member
		/// <summary>
		/// Initializes the PluginCoordinator agent and all its child agents.
		/// </summary>
		public void Initialize()
		{
			log.Debug("Initializing PluginCoordinator.");

			// initialize child agents
			this._viewCoordinator.Initialize();

			// hook up to parent agent events
			this._parent.ComponentModelChanged += new ComponentModelChangedHandler(parent_ComponentModelChanged);
			this._parent.EntityChanged += new EntityChangedHandler(parent_EntityChanged);

			// hook up to presentation and abstraction events
			this._abstraction.DataChanged += new EventHandler(this.abstraction_DataChanged);
			this._presentation.AddPluginRequested += new FileEventHandler(presentation_AddPluginRequested);
			this._presentation.ActivatePluginRequested += new EventHandler(presentation_ActivatePluginRequested);
			this._presentation.DeactivatePluginRequested += new EventHandler(presentation_DeactivatePluginRequested);

			// hook up to child agent events
			this._viewCoordinator.SelectionChanged += new SelectionChangedHandler(viewCoordinator_SelectionChanged);

			// load installed plugins and start the plugins marked active
			this._abstraction.Initialize();
		}
	
		public CompositeComponentProxy GetComponentModel()
		{
			return this._parent.GetComponentModel();
		}
		public void ShowPluginControlDialog()
		{
			this._presentation.ShowPluginControlDialog();
		}
		public void PluginAttached(IPlugin plugin)
		{
			this._parent.PluginAttached(plugin);

			PluginInfo info = this._abstraction.GetPluginInfo(plugin.GetType().ToString());
			info.Status = PluginStatus.ACTIVE;
			this._abstraction.SetPluginInfo(info);
		}
		public void PluginDetached(string type)
		{
			PluginInfo info = this._abstraction.GetPluginInfo(type);

			this._parent.PluginDetached(info.PluginType, type);

			info.Status = PluginStatus.INACTIVE;
			this._abstraction.SetPluginInfo(info);
		}
		#endregion

		#region IDataProvider Member

		public PluginInfo[] GetPluginInfos() 
		{ 
			return this._abstraction.GetPluginInfos(); 
		}

		public PluginInfo GetPluginInfo(int index) 
		{
			return this._abstraction.GetPluginInfo(index);
		}

		#endregion

		#region Presentation Event Handler
		private void presentation_ActivatePluginRequested(object sender, System.EventArgs e)
		{
			int selectedIndex = this._presentation.GetSelectedPluginListIndex();
			PluginInfo pluginInfo = this._abstraction.GetPluginInfo(selectedIndex);
			if (pluginInfo.PluginType == PluginType.VIEW)
			{
				try 
				{
					this._viewCoordinator.AttachPlugin(pluginInfo);
				}
				catch (Exception exc)
				{
					log.Error("Could not instantiate "+pluginInfo.TypeName+": "+exc.ToString());

				}
			}
		}

		private void presentation_DeactivatePluginRequested(object sender, System.EventArgs e)
		{
			int index = this._presentation.GetSelectedPluginListIndex();
			PluginInfo info = this._abstraction.GetPluginInfo(index);
			if (info.PluginType == PluginType.VIEW)
			{
				this._viewCoordinator.DetachPlugin(info.TypeName);
			}
			System.GC.Collect();
		}

		private void presentation_AddPluginRequested(object sender, System.IO.FileInfo assemblyInfo)
		{
			// create and define setup information for a new domain
			AppDomainSetup domainInfo = new AppDomainSetup();
			domainInfo.ApplicationBase = AppDomain.CurrentDomain.BaseDirectory;
			domainInfo.PrivateBinPath = "Assemblies";

			// create temporal domain and use it to extract type information from the assembly
			AppDomain pluginDomain = AppDomain.CreateDomain("PluginDomain", null, domainInfo);
			try 
			{
				// instantiate a RemoteLoader in the new application domain
				RemoteLoader remoteLoader = pluginDomain.CreateInstanceFromAndUnwrap(
					AppDomain.CurrentDomain.BaseDirectory+"\\Palladio.Editor.exe",
					typeof(RemoteLoader).ToString()) 
					as RemoteLoader;

				// load assembly into the domain and return plugin infos
				PluginInfo[] infos = remoteLoader.GetPluginInfosFromAssembly(assemblyInfo.FullName);

				foreach (PluginInfo info in infos)
					this._abstraction.SetPluginInfo( info );
			} 
			catch (Exception exc) 
			{
				log.Error("AddPlugin Handler: "+exc.ToString());
			}

			AppDomain.Unload(pluginDomain);
		}
		#endregion

		#region Abstraction Event Handler
		private void abstraction_DataChanged(object source, System.EventArgs e)
		{
			this._presentation.UpdatePluginList( this._abstraction.GetPluginInfos() );
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
		private void viewCoordinator_SelectionChanged(object source, EntityProxy entity)
		{
			if (this.SelectionChanged != null)
				this.SelectionChanged(this, entity);
		}
		#endregion

		#region Public Methods
		public void ActivatePlugin(PluginInfo info)
		{
			if (info.PluginType == PluginType.VIEW)
			{
				try 
				{
					this._viewCoordinator.AttachPlugin(info);
				}
				catch (Exception e)
				{
					log.Error("Could not instantiate "+info.TypeName+": "+e.ToString());
				}
			}			
		}
		#endregion
	}
}
