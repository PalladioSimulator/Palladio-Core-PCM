using System;
using System.Collections;
using System.Drawing;
using System.Windows.Forms;
using Palladio.ComponentModel;
using Palladio.Editor.Common;
using Palladio.Editor.PluginHost;
using log4net;
using TD.SandDock;

namespace Palladio.Editor.Forms
{

	/// <summary>
	/// Zusammenfassung für MainForm.
	/// </summary>
	public class MainForm : System.Windows.Forms.Form
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(MainForm));

		private System.Windows.Forms.StatusBar statusBar;
		private System.ComponentModel.IContainer components;
		private TD.SandBar.ToolBarContainer leftSandBarDock;
		private TD.SandBar.ToolBarContainer rightSandBarDock;
		private TD.SandBar.ToolBarContainer bottomSandBarDock;
		private TD.SandBar.ToolBarContainer topSandBarDock;
		private TD.SandBar.MenuBarItem menubar_File;
		private TD.SandBar.MenuBarItem menubar_Edit;
		private TD.SandBar.MenuBarItem menubar_View;
		private TD.SandBar.MenuBarItem menubar_Help;
		private TD.SandBar.MenuButtonItem menubar_File_New;
		private TD.SandBar.MenuButtonItem menubar_File_Open;
		private TD.SandBar.MenuButtonItem menubar_File_Save;
		private TD.SandBar.MenuButtonItem menubar_File_SaveAs;
		private TD.SandBar.MenuButtonItem menubar_File_Import;
		private TD.SandBar.MenuButtonItem menubar_File_Export;
		private TD.SandBar.MenuButtonItem menubar_File_Print;
		private TD.SandBar.MenuButtonItem menubar_File_Exit;
		private System.Windows.Forms.ImageList imageList;
		private TD.SandBar.ToolBar toolBar;
		private TD.SandBar.ButtonItem button_New;
		private TD.SandBar.ButtonItem button_Open;
		private TD.SandBar.ButtonItem button_Save;
		private TD.SandBar.ButtonItem button_SaveAs;
		private TD.SandDock.DockContainer leftSandDock;
		private TD.SandDock.DockContainer rightSandDock;
		private TD.SandDock.DockContainer bottomSandDock;
		private TD.SandDock.DockContainer topSandDock;
		private TD.SandDock.SandDockManager sandDockManager;
		private TD.SandBar.SandBarManager sandBarManager;
		private TD.SandBar.MenuBar menuBar;
		private TD.SandDock.DockControl dctOutput;
		private Palladio.Editor.Forms.LogOutputControl outputControl;
		private Palladio.Editor.Forms.PluginControlForm pluginControl;
		private Palladio.Editor.Forms.ToolBoxControl toolboxControl;
		private TD.SandBar.MenuButtonItem menubar_View_Output;
		private TD.SandBar.MenuBarItem menubar_Analysis;
		private TD.SandBar.MenuButtonItem menubar_Edit_Plugins;
		private TD.SandBar.MenuButtonItem menubar_Help_Info;
		private System.Windows.Forms.OpenFileDialog openFileDialog;
		private TD.SandDock.DocumentContainer documentContainer1;
		private TD.SandDock.DockControl dockControl1;
		private TD.SandDock.DockControl dockControl2;
		private TD.SandDock.DockControl dockControl3;
		private TD.SandDock.DockControl dctToolbox;

		private Hashtable activePlugins = new Hashtable();

		public MainForm()
		{
			// doublebuffering an um flickern beim docken zu vermeiden
//			SetStyle(ControlStyles.DoubleBuffer, true);
//			SetStyle(ControlStyles.AllPaintingInWmPaint, true);

		}

		internal void init()
		{
			this.pluginControl = new PluginControlForm();

			InitializeComponent();

			AppMain.Instance.PluginManager.PluginLoaded += new PluginLoadedHandler(OnPluginManager_PluginLoaded);
		}


		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(MainForm));
			this.statusBar = new System.Windows.Forms.StatusBar();
			this.openFileDialog = new System.Windows.Forms.OpenFileDialog();
			this.sandBarManager = new TD.SandBar.SandBarManager();
			this.bottomSandBarDock = new TD.SandBar.ToolBarContainer();
			this.leftSandBarDock = new TD.SandBar.ToolBarContainer();
			this.rightSandBarDock = new TD.SandBar.ToolBarContainer();
			this.topSandBarDock = new TD.SandBar.ToolBarContainer();
			this.menuBar = new TD.SandBar.MenuBar();
			this.menubar_File = new TD.SandBar.MenuBarItem();
			this.menubar_File_New = new TD.SandBar.MenuButtonItem();
			this.menubar_File_Open = new TD.SandBar.MenuButtonItem();
			this.menubar_File_Save = new TD.SandBar.MenuButtonItem();
			this.menubar_File_SaveAs = new TD.SandBar.MenuButtonItem();
			this.menubar_File_Import = new TD.SandBar.MenuButtonItem();
			this.menubar_File_Export = new TD.SandBar.MenuButtonItem();
			this.menubar_File_Print = new TD.SandBar.MenuButtonItem();
			this.menubar_File_Exit = new TD.SandBar.MenuButtonItem();
			this.menubar_Edit = new TD.SandBar.MenuBarItem();
			this.menubar_Edit_Plugins = new TD.SandBar.MenuButtonItem();
			this.menubar_View = new TD.SandBar.MenuBarItem();
			this.menubar_View_Output = new TD.SandBar.MenuButtonItem();
			this.menubar_Analysis = new TD.SandBar.MenuBarItem();
			this.menubar_Help = new TD.SandBar.MenuBarItem();
			this.menubar_Help_Info = new TD.SandBar.MenuButtonItem();
			this.imageList = new System.Windows.Forms.ImageList(this.components);
			this.toolBar = new TD.SandBar.ToolBar();
			this.button_New = new TD.SandBar.ButtonItem();
			this.button_Open = new TD.SandBar.ButtonItem();
			this.button_Save = new TD.SandBar.ButtonItem();
			this.button_SaveAs = new TD.SandBar.ButtonItem();
			this.sandDockManager = new TD.SandDock.SandDockManager();
			this.leftSandDock = new TD.SandDock.DockContainer();
			this.dctToolbox = new TD.SandDock.DockControl();
			this.toolboxControl = new Palladio.Editor.Forms.ToolBoxControl();
			this.rightSandDock = new TD.SandDock.DockContainer();
			this.dctOutput = new TD.SandDock.DockControl();
			this.outputControl = new Palladio.Editor.Forms.LogOutputControl();
			this.bottomSandDock = new TD.SandDock.DockContainer();
			this.topSandDock = new TD.SandDock.DockContainer();
			this.documentContainer1 = new TD.SandDock.DocumentContainer();
			this.dockControl1 = new TD.SandDock.DockControl();
			this.dockControl2 = new TD.SandDock.DockControl();
			this.dockControl3 = new TD.SandDock.DockControl();
			this.topSandBarDock.SuspendLayout();
			this.leftSandDock.SuspendLayout();
			this.dctToolbox.SuspendLayout();
			this.dctOutput.SuspendLayout();
			this.bottomSandDock.SuspendLayout();
			this.documentContainer1.SuspendLayout();
			this.SuspendLayout();
			// 
			// statusBar
			// 
			this.statusBar.Location = new System.Drawing.Point(0, 519);
			this.statusBar.Name = "statusBar";
			this.statusBar.ShowPanels = true;
			this.statusBar.Size = new System.Drawing.Size(808, 22);
			this.statusBar.TabIndex = 7;
			// 
			// openFileDialog
			// 
			this.openFileDialog.Filter = "Palladio-Models (*.paladio.xml)|*.palladio.xml|All Files (*.*)|*.*";
			// 
			// sandBarManager
			// 
			this.sandBarManager.BottomContainer = this.bottomSandBarDock;
			this.sandBarManager.LeftContainer = this.leftSandBarDock;
			this.sandBarManager.OwnerForm = this;
			this.sandBarManager.Renderer = new TD.SandBar.WhidbeyRenderer();
			this.sandBarManager.RightContainer = this.rightSandBarDock;
			this.sandBarManager.TopContainer = this.topSandBarDock;
			// 
			// bottomSandBarDock
			// 
			this.bottomSandBarDock.Dock = System.Windows.Forms.DockStyle.Bottom;
			this.bottomSandBarDock.Location = new System.Drawing.Point(0, 519);
			this.bottomSandBarDock.Manager = this.sandBarManager;
			this.bottomSandBarDock.Name = "bottomSandBarDock";
			this.bottomSandBarDock.Size = new System.Drawing.Size(808, 0);
			this.bottomSandBarDock.TabIndex = 10;
			// 
			// leftSandBarDock
			// 
			this.leftSandBarDock.Dock = System.Windows.Forms.DockStyle.Left;
			this.leftSandBarDock.Location = new System.Drawing.Point(0, 64);
			this.leftSandBarDock.Manager = this.sandBarManager;
			this.leftSandBarDock.Name = "leftSandBarDock";
			this.leftSandBarDock.Size = new System.Drawing.Size(0, 455);
			this.leftSandBarDock.TabIndex = 8;
			// 
			// rightSandBarDock
			// 
			this.rightSandBarDock.Dock = System.Windows.Forms.DockStyle.Right;
			this.rightSandBarDock.Location = new System.Drawing.Point(808, 64);
			this.rightSandBarDock.Manager = this.sandBarManager;
			this.rightSandBarDock.Name = "rightSandBarDock";
			this.rightSandBarDock.Size = new System.Drawing.Size(0, 455);
			this.rightSandBarDock.TabIndex = 9;
			// 
			// topSandBarDock
			// 
			this.topSandBarDock.Controls.Add(this.menuBar);
			this.topSandBarDock.Controls.Add(this.toolBar);
			this.topSandBarDock.Dock = System.Windows.Forms.DockStyle.Top;
			this.topSandBarDock.Location = new System.Drawing.Point(0, 0);
			this.topSandBarDock.Manager = this.sandBarManager;
			this.topSandBarDock.Name = "topSandBarDock";
			this.topSandBarDock.Size = new System.Drawing.Size(808, 64);
			this.topSandBarDock.TabIndex = 11;
			// 
			// menuBar
			// 
			this.menuBar.Buttons.AddRange(new TD.SandBar.ToolbarItemBase[] {
																			   this.menubar_File,
																			   this.menubar_Edit,
																			   this.menubar_View,
																			   this.menubar_Analysis,
																			   this.menubar_Help});
			this.menuBar.Guid = new System.Guid("039a1dce-8a93-4612-bdd3-324fc2483654");
			this.menuBar.ImageList = this.imageList;
			this.menuBar.Location = new System.Drawing.Point(2, 0);
			this.menuBar.Name = "menuBar";
			this.menuBar.Size = new System.Drawing.Size(806, 24);
			this.menuBar.TabIndex = 0;
			// 
			// menubar_File
			// 
			this.menubar_File.MenuItems.AddRange(new TD.SandBar.MenuButtonItem[] {
																					 this.menubar_File_New,
																					 this.menubar_File_Open,
																					 this.menubar_File_Save,
																					 this.menubar_File_SaveAs,
																					 this.menubar_File_Import,
																					 this.menubar_File_Export,
																					 this.menubar_File_Print,
																					 this.menubar_File_Exit});
			this.menubar_File.Text = "&File";
			// 
			// menubar_File_New
			// 
			this.menubar_File_New.ImageIndex = 0;
			this.menubar_File_New.Shortcut = System.Windows.Forms.Shortcut.CtrlN;
			this.menubar_File_New.Text = "&New";
			this.menubar_File_New.Activate += new System.EventHandler(this.menubar_File_New_Activate);
			// 
			// menubar_File_Open
			// 
			this.menubar_File_Open.ImageIndex = 1;
			this.menubar_File_Open.Text = "&Open...";
			this.menubar_File_Open.Activate += new System.EventHandler(this.OnOpenFile);
			// 
			// menubar_File_Save
			// 
			this.menubar_File_Save.ImageIndex = 2;
			this.menubar_File_Save.Shortcut = System.Windows.Forms.Shortcut.CtrlS;
			this.menubar_File_Save.Text = "&Save";
			// 
			// menubar_File_SaveAs
			// 
			this.menubar_File_SaveAs.ImageIndex = 3;
			this.menubar_File_SaveAs.Text = "Save &As...";
			// 
			// menubar_File_Import
			// 
			this.menubar_File_Import.BeginGroup = true;
			this.menubar_File_Import.Text = "&Import...";
			// 
			// menubar_File_Export
			// 
			this.menubar_File_Export.Text = "&Export...";
			// 
			// menubar_File_Print
			// 
			this.menubar_File_Print.BeginGroup = true;
			this.menubar_File_Print.Shortcut = System.Windows.Forms.Shortcut.CtrlP;
			this.menubar_File_Print.Text = "&Print...";
			// 
			// menubar_File_Exit
			// 
			this.menubar_File_Exit.BeginGroup = true;
			this.menubar_File_Exit.Text = "E&xit";
			this.menubar_File_Exit.Activate += new System.EventHandler(this.OnExit);
			// 
			// menubar_Edit
			// 
			this.menubar_Edit.MenuItems.AddRange(new TD.SandBar.MenuButtonItem[] {
																					 this.menubar_Edit_Plugins});
			this.menubar_Edit.Text = "&Edit";
			// 
			// menubar_Edit_Plugins
			// 
			this.menubar_Edit_Plugins.Shortcut = System.Windows.Forms.Shortcut.F9;
			this.menubar_Edit_Plugins.Text = "Plugins...";
			this.menubar_Edit_Plugins.Activate += new System.EventHandler(this.menubar_Edit_Plugins_Activate);
			// 
			// menubar_View
			// 
			this.menubar_View.MenuItems.AddRange(new TD.SandBar.MenuButtonItem[] {
																					 this.menubar_View_Output});
			this.menubar_View.Text = "&View";
			// 
			// menubar_View_Output
			// 
			this.menubar_View_Output.Text = "&Output";
			this.menubar_View_Output.Activate += new System.EventHandler(this.OnViewOutput);
			// 
			// menubar_Analysis
			// 
			this.menubar_Analysis.Text = "&Analysis";
			// 
			// menubar_Help
			// 
			this.menubar_Help.MenuItems.AddRange(new TD.SandBar.MenuButtonItem[] {
																					 this.menubar_Help_Info});
			this.menubar_Help.Text = "&Help";
			// 
			// menubar_Help_Info
			// 
			this.menubar_Help_Info.Text = "Info...";
			// 
			// imageList
			// 
			this.imageList.ImageSize = new System.Drawing.Size(16, 16);
			this.imageList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList.ImageStream")));
			this.imageList.TransparentColor = System.Drawing.Color.Transparent;
			// 
			// toolBar
			// 
			this.toolBar.AddRemoveButtonsVisible = false;
			this.toolBar.Buttons.AddRange(new TD.SandBar.ToolbarItemBase[] {
																			   this.button_New,
																			   this.button_Open,
																			   this.button_Save,
																			   this.button_SaveAs});
			this.toolBar.DockLine = 1;
			this.toolBar.DrawActionsButton = false;
			this.toolBar.Guid = new System.Guid("35768cf2-c2f6-4c47-8176-f7f9929098a2");
			this.toolBar.ImageList = this.imageList;
			this.toolBar.Location = new System.Drawing.Point(2, 24);
			this.toolBar.Name = "toolBar";
			this.toolBar.Size = new System.Drawing.Size(224, 40);
			this.toolBar.TabIndex = 1;
			this.toolBar.Text = "toolBar";
			this.toolBar.TextAlign = TD.SandBar.ToolBarTextAlign.Underneath;
			// 
			// button_New
			// 
			this.button_New.BuddyMenu = this.menubar_File_New;
			this.button_New.ImageIndex = 0;
			this.button_New.Text = "New";
			this.button_New.ToolTipText = "New";
			// 
			// button_Open
			// 
			this.button_Open.BuddyMenu = this.menubar_File_Open;
			this.button_Open.ImageIndex = 1;
			this.button_Open.Text = "Open";
			this.button_Open.ToolTipText = "Open...";
			// 
			// button_Save
			// 
			this.button_Save.BuddyMenu = this.menubar_File_Save;
			this.button_Save.ImageIndex = 2;
			this.button_Save.Text = "Save";
			this.button_Save.ToolTipText = "Save";
			// 
			// button_SaveAs
			// 
			this.button_SaveAs.BuddyMenu = this.menubar_File_SaveAs;
			this.button_SaveAs.ImageIndex = 3;
			this.button_SaveAs.Text = "Save As";
			this.button_SaveAs.ToolTipText = "Save As...";
			// 
			// sandDockManager
			// 
			this.sandDockManager.OwnerForm = this;
			// 
			// leftSandDock
			// 
			this.leftSandDock.Controls.Add(this.dctToolbox);
			this.leftSandDock.Dock = System.Windows.Forms.DockStyle.Left;
			this.leftSandDock.Guid = new System.Guid("9f66d4d4-1368-484a-ad77-71e6357b2d03");
			this.leftSandDock.LayoutSystem = new TD.SandDock.SplitLayoutSystem(250, 400, System.Windows.Forms.Orientation.Horizontal, new TD.SandDock.LayoutSystemBase[] {
																																											 new TD.SandDock.ControlLayoutSystem(247, 247, new TD.SandDock.DockControl[] {
																																																															 this.dctToolbox}, this.dctToolbox)});
			this.leftSandDock.Location = new System.Drawing.Point(0, 64);
			this.leftSandDock.Manager = this.sandDockManager;
			this.leftSandDock.Name = "leftSandDock";
			this.leftSandDock.Size = new System.Drawing.Size(251, 247);
			this.leftSandDock.TabIndex = 12;
			// 
			// dctToolbox
			// 
			this.dctToolbox.Controls.Add(this.toolboxControl);
			this.dctToolbox.Guid = new System.Guid("220ad275-af28-4f8b-a4eb-523a525e465f");
			this.dctToolbox.Location = new System.Drawing.Point(0, 16);
			this.dctToolbox.Name = "dctToolbox";
			this.dctToolbox.Size = new System.Drawing.Size(247, 208);
			this.dctToolbox.TabImage = ((System.Drawing.Image)(resources.GetObject("dctToolbox.TabImage")));
			this.dctToolbox.TabIndex = 0;
			this.dctToolbox.Text = "Toolbox";
			// 
			// toolboxControl
			// 
			this.toolboxControl.Dock = System.Windows.Forms.DockStyle.Fill;
			this.toolboxControl.Location = new System.Drawing.Point(0, 0);
			this.toolboxControl.Name = "toolboxControl";
			this.toolboxControl.Size = new System.Drawing.Size(247, 208);
			this.toolboxControl.TabIndex = 0;
			// 
			// rightSandDock
			// 
			this.rightSandDock.Dock = System.Windows.Forms.DockStyle.Right;
			this.rightSandDock.Guid = new System.Guid("325f2b4a-713c-406c-8c55-04e91659b33a");
			this.rightSandDock.LayoutSystem = new TD.SandDock.SplitLayoutSystem(250, 400);
			this.rightSandDock.Location = new System.Drawing.Point(808, 64);
			this.rightSandDock.Manager = this.sandDockManager;
			this.rightSandDock.Name = "rightSandDock";
			this.rightSandDock.Size = new System.Drawing.Size(0, 247);
			this.rightSandDock.TabIndex = 13;
			// 
			// dctOutput
			// 
			this.dctOutput.AutoScroll = true;
			this.dctOutput.Controls.Add(this.outputControl);
			this.dctOutput.FloatingSize = new System.Drawing.Size(600, 240);
			this.dctOutput.Guid = new System.Guid("16de0e8b-88e1-4871-80bb-f71df8ac642a");
			this.dctOutput.Location = new System.Drawing.Point(0, 20);
			this.dctOutput.Name = "dctOutput";
			this.dctOutput.Size = new System.Drawing.Size(808, 165);
			this.dctOutput.TabIndex = 0;
			this.dctOutput.Text = "Output";
			// 
			// outputControl
			// 
			this.outputControl.AutoScroll = true;
			this.outputControl.Dock = System.Windows.Forms.DockStyle.Fill;
			this.outputControl.Location = new System.Drawing.Point(0, 0);
			this.outputControl.Name = "outputControl";
			this.outputControl.Size = new System.Drawing.Size(808, 165);
			this.outputControl.TabIndex = 0;
			// 
			// bottomSandDock
			// 
			this.bottomSandDock.Controls.Add(this.dctOutput);
			this.bottomSandDock.Dock = System.Windows.Forms.DockStyle.Bottom;
			this.bottomSandDock.Guid = new System.Guid("763578bb-ebf1-40f7-8dd6-5816295b9882");
			this.bottomSandDock.LayoutSystem = new TD.SandDock.SplitLayoutSystem(250, 400, System.Windows.Forms.Orientation.Horizontal, new TD.SandDock.LayoutSystemBase[] {
																																											   new TD.SandDock.ControlLayoutSystem(808, 204, new TD.SandDock.DockControl[] {
																																																															   this.dctOutput}, this.dctOutput)});
			this.bottomSandDock.Location = new System.Drawing.Point(0, 311);
			this.bottomSandDock.Manager = this.sandDockManager;
			this.bottomSandDock.Name = "bottomSandDock";
			this.bottomSandDock.Size = new System.Drawing.Size(808, 208);
			this.bottomSandDock.TabIndex = 14;
			// 
			// topSandDock
			// 
			this.topSandDock.Dock = System.Windows.Forms.DockStyle.Top;
			this.topSandDock.Guid = new System.Guid("6d6c552f-f913-46a9-88b3-0b314451099d");
			this.topSandDock.LayoutSystem = new TD.SandDock.SplitLayoutSystem(250, 400);
			this.topSandDock.Location = new System.Drawing.Point(0, 64);
			this.topSandDock.Manager = this.sandDockManager;
			this.topSandDock.Name = "topSandDock";
			this.topSandDock.Size = new System.Drawing.Size(808, 0);
			this.topSandDock.TabIndex = 15;
			// 
			// documentContainer1
			// 
			this.documentContainer1.Controls.Add(this.dockControl1);
			this.documentContainer1.Controls.Add(this.dockControl2);
			this.documentContainer1.Controls.Add(this.dockControl3);
			this.documentContainer1.Guid = new System.Guid("8ef56633-ef80-40e5-a519-84be067f8d51");
			this.documentContainer1.LayoutSystem = new TD.SandDock.SplitLayoutSystem(250, 400, System.Windows.Forms.Orientation.Horizontal, new TD.SandDock.LayoutSystemBase[] {
																																												   new TD.SandDock.DocumentLayoutSystem(555, 245, new TD.SandDock.DockControl[] {
																																																																	this.dockControl1,
																																																																	this.dockControl2,
																																																																	this.dockControl3}, this.dockControl3)});
			this.documentContainer1.Location = new System.Drawing.Point(251, 64);
			this.documentContainer1.Manager = null;
			this.documentContainer1.Name = "documentContainer1";
			this.documentContainer1.Size = new System.Drawing.Size(557, 247);
			this.documentContainer1.TabIndex = 16;
			// 
			// dockControl1
			// 
			this.dockControl1.Guid = new System.Guid("8dbab6f3-6e03-4c58-ab9f-98be3130a750");
			this.dockControl1.Location = new System.Drawing.Point(3, 23);
			this.dockControl1.Name = "dockControl1";
			this.dockControl1.Size = new System.Drawing.Size(802, 221);
			this.dockControl1.TabIndex = 0;
			this.dockControl1.Text = "Static View";
			// 
			// dockControl2
			// 
			this.dockControl2.Guid = new System.Guid("585c9bcf-e94f-4107-8324-a4dfe8e9c32b");
			this.dockControl2.Location = new System.Drawing.Point(3, 23);
			this.dockControl2.Name = "dockControl2";
			this.dockControl2.Size = new System.Drawing.Size(802, 221);
			this.dockControl2.TabIndex = 1;
			this.dockControl2.Text = "Dynamic View";
			// 
			// dockControl3
			// 
			this.dockControl3.Guid = new System.Guid("267968f4-ae55-4057-9bb2-f69364e4d949");
			this.dockControl3.Location = new System.Drawing.Point(3, 23);
			this.dockControl3.Name = "dockControl3";
			this.dockControl3.Size = new System.Drawing.Size(551, 221);
			this.dockControl3.TabIndex = 2;
			this.dockControl3.Text = "Allocation View";
			// 
			// MainForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.Color.DarkGray;
			this.ClientSize = new System.Drawing.Size(808, 541);
			this.Controls.Add(this.documentContainer1);
			this.Controls.Add(this.leftSandDock);
			this.Controls.Add(this.rightSandDock);
			this.Controls.Add(this.bottomSandDock);
			this.Controls.Add(this.topSandDock);
			this.Controls.Add(this.leftSandBarDock);
			this.Controls.Add(this.rightSandBarDock);
			this.Controls.Add(this.bottomSandBarDock);
			this.Controls.Add(this.topSandBarDock);
			this.Controls.Add(this.statusBar);
			this.MinimumSize = new System.Drawing.Size(250, 250);
			this.Name = "MainForm";
			this.Text = "Palladio Editor Prototype";
			this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
			this.topSandBarDock.ResumeLayout(false);
			this.leftSandDock.ResumeLayout(false);
			this.dctToolbox.ResumeLayout(false);
			this.dctOutput.ResumeLayout(false);
			this.bottomSandDock.ResumeLayout(false);
			this.documentContainer1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion


		private void OnOpenFile(object sender, System.EventArgs e)
		{
			if (openFileDialog.ShowDialog() == DialogResult.OK)
			{
				log.Debug("loading "+openFileDialog.FileName);
				try 
				{
					AppMain.Instance.ComponentModel = ComponentFactory.LoadCompositeComponent(openFileDialog.FileName);
				}
				catch (Exception exc) 
				{
					log.Error("Could not load ComponentModel! "+exc.Message);
				}
			}

		}

		private void OnExit(object sender, System.EventArgs e)
		{
			Close();
			Application.Exit();
		}



		private void OnPluginManager_PluginLoaded(object source, IPlugin plugin)
		{
			plugin.StatusChanged += new PluginStatusChangedHandler(OnPluginWrapper_StatusChanged);
		}

		private void OnPluginWrapper_StatusChanged(IPlugin plugin, PluginStatusEnum newstatus)
		{
			System.Type pluginType = AppMain.Instance.PluginManager.GetPluginType(plugin);

			if (plugin.GetType().GetInterface("IViewPlugin") != null) 
			{
				if (newstatus == PluginStatusEnum.ACTIVE) 
				{
					ActiveViewPluginRecord record = new ActiveViewPluginRecord();
					TD.SandBar.MenuButtonItem viewMenuItem = new TD.SandBar.MenuButtonItem(plugin.Name);
					this.menubar_View.MenuItems.Add(viewMenuItem);
					record.ViewMenuItem = viewMenuItem;
					UserControl newCtrl = ((IViewPlugin)plugin).Control;
					if (newCtrl != null) 
					{
						DockControl dct = new TD.SandDock.DockControl();
						dct.AutoScroll = true;
						dct.Controls.Add(newCtrl);
						dct.FloatingSize = new System.Drawing.Size(400, 300);
						dct.Location = new System.Drawing.Point(0, 20);
						dct.Name = "dct"+plugin.Name;
						dct.Size = new System.Drawing.Size(808, 165);
						dct.Text = plugin.Name;

						record.ViewControl = dct;

						ControlLayoutSystem layout = new ControlLayoutSystem(180, 100, new DockControl [] {dct}, dct);
						this.leftSandDock.LayoutSystem.LayoutSystems.Add(layout);
					}
					this.activePlugins.Add(pluginType,record);
				}
				else if (newstatus == PluginStatusEnum.INACTIVE) 
				{
					ActiveViewPluginRecord record = (ActiveViewPluginRecord)this.activePlugins[pluginType];
					this.menubar_View.MenuItems.Remove(record.ViewMenuItem);
					ControlLayoutSystem layoutSystem = record.ViewControl.LayoutSystem;
					if (layoutSystem != null) 
					{
						layoutSystem.Controls.Remove(record.ViewControl);
						if (layoutSystem.Controls.Count == 0) 
						{
							((SplitLayoutSystem)layoutSystem.Parent).LayoutSystems.Remove(layoutSystem);
						}
					}
					this.activePlugins.Remove(pluginType);
				}
				//return;
			}
		}

		private void OnViewOutput(object sender, System.EventArgs e)
		{
			this.dctOutput.Open();
			this.dctOutput.Activate();
		}

		private void menubar_Edit_Plugins_Activate(object sender, System.EventArgs e)
		{
			this.pluginControl.ShowDialog();
		}

		private void dockControl4_Closing(object sender, System.ComponentModel.CancelEventArgs e)
		{
		
		}

		private void menubar_File_New_Activate(object sender, System.EventArgs e)
		{
			AppMain.Instance.ComponentModel = ComponentFactory.CreateCompositeComponent("New Model");
		}
	}

	internal class ActiveViewPluginRecord 
	{
		private TD.SandBar.MenuButtonItem _viewMenuItem;
		public TD.SandBar.MenuButtonItem ViewMenuItem
		{
			get { return this._viewMenuItem; }
			set { this._viewMenuItem = value; }
		}

		private TD.SandDock.DockControl _viewControl;
		public TD.SandDock.DockControl ViewControl
		{
			get { return this._viewControl; }
			set { this._viewControl = value; }
		}
	}
}
