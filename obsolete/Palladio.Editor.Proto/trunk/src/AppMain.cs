using System;
using System.Data;
using System.Windows.Forms;
using Palladio.ComponentModel;
using Palladio.Editor.Common;
using Palladio.Editor.PluginHost;
using Palladio.Editor.Forms;
using log4net;
using log4net.Config;

namespace Palladio.Editor
{
	/// <summary>
	/// Zusammenfassung für AppMain.
	/// </summary>
	internal class AppMain
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(AppMain));

		#region Properties
		// Singleton instance
		private static AppMain _instance;
		public static AppMain Instance
		{
			get 
			{
				if (AppMain._instance == null)
					AppMain._instance = new AppMain();
				return _instance;
			}
		}


		private PluginManager _pluginManager;
		internal PluginManager PluginManager
		{
			get { return this._pluginManager; }
		}

		private MainForm _mainForm;
		internal MainForm MainForm
		{
			get { return this._mainForm; }
		}


		private ICompositeComponent _componentModel;
		public ICompositeComponent ComponentModel
		{
			get { return this._componentModel; }
			set 
			{ 
				if (this._componentModel != value) 
				{
					this._componentModel = value; 
					if (this.ComponentModelChanged != null)
						this.ComponentModelChanged(this._componentModel);
					log.Debug("ComponentModel changed.");
				}
			}
		}

		#endregion

		#region Events

		public event ComponentModelChangedHandler ComponentModelChanged;

		#endregion

		#region Methods


		#endregion

		private AppMain() 
		{
			// configure log4net
			DOMConfigurator.Configure(new System.IO.FileInfo("log4net.config.xml"));

			this._mainForm = new MainForm();

			this._pluginManager = new PluginManager();

			this.ComponentModelChanged += new ComponentModelChangedHandler(this.PluginManager.OnComponentModelChanged);

			this.ComponentModel = ComponentFactory.CreateCompositeComponent("New Model");
		}

		[STAThread]
		static void Main() 
		{

			AppMain.Instance.MainForm.init();
	
			//AppMain.Instance.PluginManager.loadAssembly("C:\\Dokumente und Einstellungen\\Matze\\Eigene Dateien\\Visual Studio-Projekte\\Palladio.Editor.Plugins.Test\\bin\\Debug\\Palladio.Editor.Plugins.Test.dll");
			//AppMain.Instance.PluginManager.loadAssembly("C:\\Dokumente und Einstellungen\\Matze\\Eigene Dateien\\Visual Studio-Projekte\\Palladio.Editor.Plugins.TreeView\\bin\\Debug\\Palladio.Editor.Plugins.TreeView.dll");

			Application.Run(AppMain.Instance.MainForm);
		}

	}
}
