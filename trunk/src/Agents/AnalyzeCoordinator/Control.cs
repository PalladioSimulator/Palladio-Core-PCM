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
using System.Windows.Forms;
using log4net;

using Palladio.Attributes;
using Palladio.Editor.Common;
using Palladio.Editor.Core.Interfaces;

namespace Palladio.Editor.Core.Agents.AnalyzeCoordinator
{
	/// <summary>
	/// The Control Component of the AnalyzeCoordinator PAC agent
	/// </summary>
	internal class Control : IAnalyzeCoordinator, IAnalyzePluginHost, IAbstractionAdapter
	{

		#region Fields
		/// <summary>
		/// log4net logging service</summary>
		private static readonly ILog log = LogManager.GetLogger(typeof(Control));

		/// <summary>
		/// The PluginCoordinator PAC agent</summary>
		private IPluginCoordinator _parent;

		/// <summary>
		/// The Presentation Component of the AnalyzeCoordinator PAC agent</summary>
		private Presentation.Facade _presentation;

		// child agents (ViewPlugins)
		private Hashtable _plugins;
		#endregion

		#region Constructors
		/// <summary>
		/// 
		/// </summary>
		/// <param name="parent">parent agent</param>
		public Control(IPluginCoordinator parent)
		{
			this._parent = parent;

			this._presentation = new Presentation.Facade(this);

			this._plugins = new Hashtable();
		}
		#endregion
	
		#region IAnalyzeCoordinator Member
		public void Initialize()
		{
			log.Debug("Initializing.");

			// hook up to presentation events
			this._presentation.AnalysisStartRequested += new StringEventHandler(presentation_AnalysisStartRequested);
		}

		public void AttachPlugin(PluginInfo pluginInfo)
		{
			if (!this._plugins.ContainsKey(pluginInfo.TypeName))
			{
				Assembly assembly = Assembly.LoadFile(pluginInfo.Assembly);

				System.Type pluginType = assembly.GetType(pluginInfo.TypeName);

				if (pluginType != null && pluginType.GetInterface("Palladio.Editor.Common.IAnalyzePlugin") != null)
				{
					IAnalyzePlugin plugin = Activator.CreateInstance(
						pluginType, 
						new object[]{
							pluginInfo.Name,
							pluginInfo.Description,
							pluginInfo.Author,
							pluginInfo.Version} ) 
						as IAnalyzePlugin;

					if (plugin.Initialize(this)) 
					{
						plugin.CanStartChanged += new EventHandler(plugin_CanStartChanged);
						this._plugins.Add(pluginInfo.TypeName, plugin);
						log.Info("AnalyzePlugin '"+plugin.Name+"' attached");
						this._parent.PluginAttached(plugin);

						foreach(System.Type requiredAttrType in plugin.RequiredAttributeTypes)
						{
							try
							{
								if (requiredAttrType.IsSubclassOf(typeof(AbstractAttributeType)))
								{
									AbstractAttributeType attrType = Activator.CreateInstance(requiredAttrType) as AbstractAttributeType;
									this._parent.RegisterAttributeType(attrType);
								}
							}
							catch (Exception e)
							{
								log.Error("Could not register required attribute "+requiredAttrType+". "+e.ToString());
							}
						}
					}
					else 
					{
						// plugin.Initialize == 0
						log.Warn("AnalyzePlugin failed to initialize itself ("+plugin.GetType().ToString()+")");
					}
				}
				else
				{
					// pluginType == null
					log.Warn("Could not instantiate Plugin. Type "+pluginInfo.TypeName+" not found or is not an AnalyzePlugin.");
				}
			}
		}

		public void DetachPlugin(string type)
		{
			if (this._plugins.ContainsKey(type))
			{
				IAnalyzePlugin plugin = (IAnalyzePlugin)this._plugins[type];
				plugin.Detach();
				this._plugins.Remove(type);
				this._parent.PluginDetached(type);
			}
		}

		/// <summary>
		/// Shows the control dialog to configure and start active analyses.
		/// </summary>
		/// <param name="pluginType">Name of the type of the plugin that should be selected.</param>
		public void ShowAnalysesControlDialog(string pluginType)
		{
			this._presentation.ShowAnalysesControlDialog(pluginType);
		}
		#endregion
	
		#region IAnalyzePluginHost Member
		/// <summary>
		/// Returns the open component model.
		/// </summary>
		/// <returns>A proxy object for the current component model.</returns>
		public Palladio.Editor.Common.EntityProxies.CompositeComponentProxy GetComponentModel()
		{
			return this._parent.GetComponentModel();
		}
		#endregion

		#region IAbstractionAdapter Member
		/// <summary>
		/// 
		/// </summary>
		public string[] AttachedPlugins
		{
			get
			{
				string[] types = new string[this._plugins.Count];
				this._plugins.Keys.CopyTo(types,0);
				return types;
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="type"></param>
		/// <returns></returns>
		public string GetPluginName(string type)
		{
			IAnalyzePlugin plugin = this._plugins[type] as IAnalyzePlugin;
			if (plugin != null)
				return plugin.Name;
			return null;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="type"></param>
		/// <returns></returns>
		public UserControl GetConfigControl(string type)
		{
			IAnalyzePlugin plugin = this._plugins[type] as IAnalyzePlugin;
			if (plugin != null)
			{
				plugin.UpdateConfigControl();
				this._presentation.CanStart = plugin.CanStart;
				return plugin.ConfigControl;
			}
			return null;
		}
		#endregion

		#region Presentation Event Handler
		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="pluginType"></param>
		private void presentation_AnalysisStartRequested(object sender, string pluginType)
		{
			IAnalyzePlugin plugin = this._plugins[pluginType] as IAnalyzePlugin;
			if (plugin != null)
			{
				plugin.Start();
				UserControl result = plugin.ResultControl;
				if (result != null)
					this._parent.NewAnalysisResult(result);
			}
		}
		#endregion

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void plugin_CanStartChanged(object sender, EventArgs e)
		{
			this._presentation.CanStartChanged(sender.GetType().ToString(), ((IAnalyzePlugin)sender).CanStart);
		}
	}
}
