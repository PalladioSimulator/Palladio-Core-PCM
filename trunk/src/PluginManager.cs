using System;
using System.IO;
using System.Reflection;
using System.Collections;
using Palladio.Editor.Common;
using Palladio.ComponentModel;
using log4net;
using log4net.Config;

namespace Palladio.Editor.PluginHost
{
	public delegate void PluginLoadedHandler(object source, IPlugin host);

	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class PluginManager
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(PluginManager));

		private event ComponentModelChangedHandler ComponentModelChanged;

		private ICompositeComponent _model;
		
		public PluginManager()
		{
			this._plugins = new Hashtable();
		}

		public event PluginLoadedHandler PluginLoaded;

		public int loadAssembly(string filename) 
		{
			int pluginCount = 0;

			try 
			{
				Assembly assembly = Assembly.LoadFrom(filename);
				log.Debug("Loading from Assembly "+filename);
				System.Type[] types = assembly.GetTypes();
				foreach(System.Type type in types)
				{
					if(type.GetInterface("IViewPlugin")!=null)
					{
						log.Debug("Found ViewPlugin "+type.Name);
						if (!this._plugins.ContainsKey(type.ToString()))
						{
							log.Debug("Creating and initializing "+type.Name);
							IViewPlugin instance = (IViewPlugin)Activator.CreateInstance(type);
							ViewPluginWrapper pluginwrapper = new ViewPluginWrapper(instance,assembly,this);
							if (instance.Initialize(pluginwrapper)) 
							{
								this._plugins.Add(type.ToString(), pluginwrapper);
								this.ComponentModelChanged += new ComponentModelChangedHandler(pluginwrapper.OnComponentModelChanged);
								pluginCount++;
								log.Info("ViewPlugin '"+instance.Name+"' connected ("+type.ToString()+")");
								if (this.PluginLoaded != null)
									this.PluginLoaded(this, pluginwrapper);
							} 
							else 
							{
								log.Warn("ViewPlugin failed to initialize itself ("+type.ToString()+")");
							}
						}
					} 
				}
			} 
			catch (Exception e) 
			{
				log.Error("loadAssembly: "+e.Message);
			}

			return pluginCount;
		}


		public void loadConfig() 
		{

		}

		public void saveConfig() 
		{

		}

		private Hashtable _plugins;
		public IPlugin[] Plugins
		{
			get 
			{
				IPlugin[] arr = new IPlugin[this._plugins.Count];
				int i = 0;
				foreach (object wrapper in this._plugins.Values) 
				{
					arr[i++] = (IPlugin)wrapper;				
				}
				return arr;
			}
		}

		public System.Type GetPluginType(IPlugin wrapper)
		{
			return ((PluginWrapperSkeleton)wrapper).GetWrappedPluginType();

		}

		public void OnComponentModelChanged(ICompositeComponent model) 
		{
			this._model = model;
			if (this.ComponentModelChanged != null)
				this.ComponentModelChanged(model);
		}

		internal ICompositeComponent GetComponentModel()
		{
			return this._model;
		}
	}
}
