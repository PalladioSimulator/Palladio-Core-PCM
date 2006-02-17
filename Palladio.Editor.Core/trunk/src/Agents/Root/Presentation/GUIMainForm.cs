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
using System.Collections;
using System.Drawing;
using System.Windows.Forms;
using log4net;

using TD.SandDock;
using TD.SandBar;

using Palladio.ComponentModel;
using Palladio.Editor.Common;

namespace Palladio.Editor.Core.Agents.Root.Presentation
{
	/// <summary>
	/// Zusammenfassung für MainForm.
	/// </summary>
	internal class GUIMainForm : System.Windows.Forms.Form
	{
		#region Fields
		/// <summary>
		/// log4net logging service</summary>
		private static readonly ILog log = LogManager.GetLogger(typeof(GUIMainForm));

		private Facade _facade;

		private Hashtable activeViews;

		private Hashtable activeAnalyses;
		#endregion

		#region GUI components
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
		private Palladio.Editor.Core.Agents.Root.Presentation.LogOutputControl outputControl;
//		private Palladio.Editor.Core.Presentation.ToolBoxControl toolboxControl;
		private TD.SandBar.MenuButtonItem menubar_View_Output;
		private TD.SandBar.MenuButtonItem menubar_Edit_Plugins;
		private TD.SandBar.MenuButtonItem menubar_Help_Info;
		private System.Windows.Forms.OpenFileDialog openFileDialog;
		private TD.SandDock.DocumentContainer documentContainer;
		private System.Windows.Forms.SaveFileDialog saveFileDialog;
		private System.Windows.Forms.PropertyGrid propertyGrid;
		private TD.SandBar.MenuButtonItem menubar_View_Properties;
		private TD.SandDock.DockControl dctProperties;
		private TD.SandBar.MenuButtonItem menubar_View_Toolbox;
		private TD.SandBar.MenuButtonItem menubar_Edit_Undo;
		private TD.SandBar.MenuButtonItem menubar_Edit_Redo;
		private TD.SandBar.MenuBarItem menubar_Analyses;
		private TD.SandBar.MenuButtonItem menubar_Analyses_Analyses;
		private TD.SandDock.DockControl dctToolbox;
		#endregion

		public GUIMainForm(Facade facade)
		{
			this._facade = facade;

			this.activeViews = new Hashtable();
			this.activeAnalyses = new Hashtable();

			InitializeComponent();

			this.outputControl = new LogOutputControl();
			this.dctOutput.Controls.Add(outputControl);
			this.outputControl.Dock = System.Windows.Forms.DockStyle.Fill;
		}

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(GUIMainForm));
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
			this.menubar_Edit_Undo = new TD.SandBar.MenuButtonItem();
			this.menubar_Edit_Redo = new TD.SandBar.MenuButtonItem();
			this.menubar_Edit_Plugins = new TD.SandBar.MenuButtonItem();
			this.menubar_View = new TD.SandBar.MenuBarItem();
			this.menubar_View_Output = new TD.SandBar.MenuButtonItem();
			this.menubar_View_Properties = new TD.SandBar.MenuButtonItem();
			this.menubar_View_Toolbox = new TD.SandBar.MenuButtonItem();
			this.menubar_Analyses = new TD.SandBar.MenuBarItem();
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
			this.rightSandDock = new TD.SandDock.DockContainer();
			this.dctProperties = new TD.SandDock.DockControl();
			this.propertyGrid = new System.Windows.Forms.PropertyGrid();
			this.dctOutput = new TD.SandDock.DockControl();
			this.bottomSandDock = new TD.SandDock.DockContainer();
			this.topSandDock = new TD.SandDock.DockContainer();
			this.documentContainer = new TD.SandDock.DocumentContainer();
			this.saveFileDialog = new System.Windows.Forms.SaveFileDialog();
			this.menubar_Analyses_Analyses = new TD.SandBar.MenuButtonItem();
			this.topSandBarDock.SuspendLayout();
			this.leftSandDock.SuspendLayout();
			this.rightSandDock.SuspendLayout();
			this.dctProperties.SuspendLayout();
			this.bottomSandDock.SuspendLayout();
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
			this.openFileDialog.Filter = "Palladio-Models (*.palladio.xml)|*.palladio.xml|All Files (*.*)|*.*";
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
																			   this.menubar_Analyses,
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
			this.menubar_File_Open.BeginGroup = true;
			this.menubar_File_Open.ImageIndex = 1;
			this.menubar_File_Open.Text = "&Open...";
			this.menubar_File_Open.Activate += new System.EventHandler(this.menubar_File_Open_Activate);
			// 
			// menubar_File_Save
			// 
			this.menubar_File_Save.ImageIndex = 2;
			this.menubar_File_Save.Shortcut = System.Windows.Forms.Shortcut.CtrlS;
			this.menubar_File_Save.Text = "&Save";
			this.menubar_File_Save.Activate += new System.EventHandler(this.menubar_File_Save_Activate);
			// 
			// menubar_File_SaveAs
			// 
			this.menubar_File_SaveAs.ImageIndex = 3;
			this.menubar_File_SaveAs.Text = "Save &As...";
			this.menubar_File_SaveAs.Activate += new System.EventHandler(this.menubar_File_SaveAs_Activate);
			// 
			// menubar_File_Import
			// 
			this.menubar_File_Import.BeginGroup = true;
			this.menubar_File_Import.ImageIndex = 4;
			this.menubar_File_Import.Text = "&Import...";
			// 
			// menubar_File_Export
			// 
			this.menubar_File_Export.ImageIndex = 5;
			this.menubar_File_Export.Text = "&Export...";
			// 
			// menubar_File_Print
			// 
			this.menubar_File_Print.BeginGroup = true;
			this.menubar_File_Print.ImageIndex = 7;
			this.menubar_File_Print.Shortcut = System.Windows.Forms.Shortcut.CtrlP;
			this.menubar_File_Print.Text = "&Print...";
			// 
			// menubar_File_Exit
			// 
			this.menubar_File_Exit.BeginGroup = true;
			this.menubar_File_Exit.Text = "E&xit";
			this.menubar_File_Exit.Activate += new System.EventHandler(this.menubar_File_Exit_Activate);
			// 
			// menubar_Edit
			// 
			this.menubar_Edit.MenuItems.AddRange(new TD.SandBar.MenuButtonItem[] {
																					 this.menubar_Edit_Undo,
																					 this.menubar_Edit_Redo,
																					 this.menubar_Edit_Plugins});
			this.menubar_Edit.Text = "&Edit";
			// 
			// menubar_Edit_Undo
			// 
			this.menubar_Edit_Undo.ImageIndex = 8;
			this.menubar_Edit_Undo.Shortcut = System.Windows.Forms.Shortcut.CtrlZ;
			this.menubar_Edit_Undo.Text = "&Undo";
			this.menubar_Edit_Undo.Activate += new System.EventHandler(this.menubar_Edit_Undo_Activate);
			// 
			// menubar_Edit_Redo
			// 
			this.menubar_Edit_Redo.ImageIndex = 9;
			this.menubar_Edit_Redo.Shortcut = System.Windows.Forms.Shortcut.CtrlY;
			this.menubar_Edit_Redo.Text = "&Redo";
			this.menubar_Edit_Redo.Activate += new System.EventHandler(this.menubar_Edit_Redo_Activate);
			// 
			// menubar_Edit_Plugins
			// 
			this.menubar_Edit_Plugins.BeginGroup = true;
			this.menubar_Edit_Plugins.Shortcut = System.Windows.Forms.Shortcut.F9;
			this.menubar_Edit_Plugins.Text = "Plugins...";
			this.menubar_Edit_Plugins.Activate += new System.EventHandler(this.menubar_Edit_Plugins_Activate);
			// 
			// menubar_View
			// 
			this.menubar_View.MenuItems.AddRange(new TD.SandBar.MenuButtonItem[] {
																					 this.menubar_View_Output,
																					 this.menubar_View_Properties,
																					 this.menubar_View_Toolbox});
			this.menubar_View.Text = "&View";
			// 
			// menubar_View_Output
			// 
			this.menubar_View_Output.Shortcut = System.Windows.Forms.Shortcut.CtrlShiftO;
			this.menubar_View_Output.Text = "&Output";
			this.menubar_View_Output.Activate += new System.EventHandler(this.menubar_View_Output_Activate);
			// 
			// menubar_View_Properties
			// 
			this.menubar_View_Properties.ImageIndex = 10;
			this.menubar_View_Properties.Shortcut = System.Windows.Forms.Shortcut.CtrlShiftP;
			this.menubar_View_Properties.Text = "&Properties";
			this.menubar_View_Properties.Activate += new System.EventHandler(this.menubar_View_Properties_Activate);
			// 
			// menubar_View_Toolbox
			// 
			this.menubar_View_Toolbox.ImageIndex = 6;
			this.menubar_View_Toolbox.Shortcut = System.Windows.Forms.Shortcut.CtrlShiftT;
			this.menubar_View_Toolbox.Text = "&Toolbox";
			this.menubar_View_Toolbox.Activate += new System.EventHandler(this.menubar_View_Toolbox_Activate);
			// 
			// menubar_Analyses
			// 
			this.menubar_Analyses.MenuItems.AddRange(new TD.SandBar.MenuButtonItem[] {
																						 this.menubar_Analyses_Analyses});
			this.menubar_Analyses.Text = "&Analyses";
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
			this.dctToolbox.Guid = new System.Guid("220ad275-af28-4f8b-a4eb-523a525e465f");
			this.dctToolbox.Location = new System.Drawing.Point(0, 16);
			this.dctToolbox.Name = "dctToolbox";
			this.dctToolbox.Size = new System.Drawing.Size(247, 208);
			this.dctToolbox.TabImage = ((System.Drawing.Image)(resources.GetObject("dctToolbox.TabImage")));
			this.dctToolbox.TabIndex = 0;
			this.dctToolbox.Text = "Toolbox";
			// 
			// rightSandDock
			// 
			this.rightSandDock.Controls.Add(this.dctProperties);
			this.rightSandDock.Dock = System.Windows.Forms.DockStyle.Right;
			this.rightSandDock.Guid = new System.Guid("325f2b4a-713c-406c-8c55-04e91659b33a");
			this.rightSandDock.LayoutSystem = new TD.SandDock.SplitLayoutSystem(250, 400, System.Windows.Forms.Orientation.Horizontal, new TD.SandDock.LayoutSystemBase[] {
																																											  new TD.SandDock.ControlLayoutSystem(250, 247, new TD.SandDock.DockControl[] {
																																																															  this.dctProperties}, this.dctProperties)});
			this.rightSandDock.Location = new System.Drawing.Point(554, 64);
			this.rightSandDock.Manager = this.sandDockManager;
			this.rightSandDock.Name = "rightSandDock";
			this.rightSandDock.Size = new System.Drawing.Size(254, 247);
			this.rightSandDock.TabIndex = 13;
			// 
			// dctProperties
			// 
			this.dctProperties.Controls.Add(this.propertyGrid);
			this.dctProperties.Guid = new System.Guid("2f63a177-632b-4a54-9bd7-8e202e5e7f66");
			this.dctProperties.Location = new System.Drawing.Point(4, 16);
			this.dctProperties.Name = "dctProperties";
			this.dctProperties.Size = new System.Drawing.Size(250, 208);
			this.dctProperties.TabImage = ((System.Drawing.Image)(resources.GetObject("dctProperties.TabImage")));
			this.dctProperties.TabIndex = 0;
			this.dctProperties.Text = "Properties";
			// 
			// propertyGrid
			// 
			this.propertyGrid.CommandsBackColor = System.Drawing.Color.DarkGray;
			this.propertyGrid.CommandsVisibleIfAvailable = true;
			this.propertyGrid.Dock = System.Windows.Forms.DockStyle.Fill;
			this.propertyGrid.LargeButtons = false;
			this.propertyGrid.LineColor = System.Drawing.SystemColors.ScrollBar;
			this.propertyGrid.Location = new System.Drawing.Point(0, 0);
			this.propertyGrid.Name = "propertyGrid";
			this.propertyGrid.PropertySort = System.Windows.Forms.PropertySort.Categorized;
			this.propertyGrid.Size = new System.Drawing.Size(250, 208);
			this.propertyGrid.TabIndex = 0;
			this.propertyGrid.Text = "Properties";
			this.propertyGrid.ViewBackColor = System.Drawing.SystemColors.Window;
			this.propertyGrid.ViewForeColor = System.Drawing.SystemColors.WindowText;
			// 
			// dctOutput
			// 
			this.dctOutput.AutoScroll = true;
			this.dctOutput.FloatingSize = new System.Drawing.Size(600, 240);
			this.dctOutput.Guid = new System.Guid("16de0e8b-88e1-4871-80bb-f71df8ac642a");
			this.dctOutput.Location = new System.Drawing.Point(0, 20);
			this.dctOutput.Name = "dctOutput";
			this.dctOutput.Size = new System.Drawing.Size(808, 165);
			this.dctOutput.TabIndex = 0;
			this.dctOutput.Text = "Output";
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
			// documentContainer
			// 
			this.documentContainer.Guid = new System.Guid("8ef56633-ef80-40e5-a519-84be067f8d51");
			this.documentContainer.LayoutSystem = new TD.SandDock.SplitLayoutSystem(250, 400);
			this.documentContainer.Location = new System.Drawing.Point(251, 64);
			this.documentContainer.Manager = null;
			this.documentContainer.Name = "documentContainer";
			this.documentContainer.Size = new System.Drawing.Size(303, 247);
			this.documentContainer.TabIndex = 16;
			// 
			// saveFileDialog
			// 
			this.saveFileDialog.DefaultExt = "palladio.xml";
			this.saveFileDialog.Filter = "Palladio-Model (*.palladio.xml)|*.palladio.xml";
			// 
			// menubar_Analyses_Analyses
			// 
			this.menubar_Analyses_Analyses.Shortcut = System.Windows.Forms.Shortcut.F11;
			this.menubar_Analyses_Analyses.Text = "Analyses...";
			this.menubar_Analyses_Analyses.Activate += new System.EventHandler(this.menubar_Analyses_Analyses_Activate);
			// 
			// GUIMainForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.Color.DarkGray;
			this.ClientSize = new System.Drawing.Size(808, 541);
			this.Controls.Add(this.documentContainer);
			this.Controls.Add(this.leftSandDock);
			this.Controls.Add(this.rightSandDock);
			this.Controls.Add(this.bottomSandDock);
			this.Controls.Add(this.topSandDock);
			this.Controls.Add(this.leftSandBarDock);
			this.Controls.Add(this.rightSandBarDock);
			this.Controls.Add(this.bottomSandBarDock);
			this.Controls.Add(this.topSandBarDock);
			this.Controls.Add(this.statusBar);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.MinimumSize = new System.Drawing.Size(250, 250);
			this.Name = "GUIMainForm";
			this.Text = "Palladio Editor Prototype";
			this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
			this.Closing += new System.ComponentModel.CancelEventHandler(this.GUIMainForm_Closing);
			this.topSandBarDock.ResumeLayout(false);
			this.leftSandDock.ResumeLayout(false);
			this.rightSandDock.ResumeLayout(false);
			this.dctProperties.ResumeLayout(false);
			this.bottomSandDock.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion


		#region Public Properties
		public bool CanUndo
		{
			get
			{
				return this.menubar_Edit_Undo.Enabled;
			}
			set
			{
				this.menubar_Edit_Undo.Enabled = value;
			}
		}

		public bool CanRedo
		{
			get
			{
				return this.menubar_Edit_Redo.Enabled;
			}
			set
			{
				this.menubar_Edit_Redo.Enabled = value;
			}
		}
		#endregion

		/// <summary>
		/// Adds visual components for a view plugin to the GUI
		/// </summary>
		/// <param name="plugin">The plugin for which user controls should be added</param>
		public void AddView(IViewPlugin plugin)
		{
			if (this.activeViews[plugin.GetType().ToString()] != null)
			{
				log.Error("Plugin has already been added to the GUI");
				return;
			}

			// create a new record to hold viewplugin informations
			ActiveViewPluginRecord record = new ActiveViewPluginRecord();

			// create menu item
			TD.SandBar.MenuButtonItem viewMenuItem = new TD.SandBar.MenuButtonItem(plugin.Name);
			viewMenuItem.Activate += new System.EventHandler(this.menubar_View_Plugin_Activate);
			if (this.menubar_View.MenuItems.Count == 3)
				viewMenuItem.BeginGroup = true;

			record.ViewMenuItem = viewMenuItem;
			this.menubar_View.MenuItems.Add(viewMenuItem);

			System.Windows.Forms.Control newCtrl = plugin.ViewControl;
			if (newCtrl != null) 
			{
				newCtrl.Dock = System.Windows.Forms.DockStyle.Fill;
				DockControl dct = new TD.SandDock.DockControl();
				dct.AutoScroll = true;
				dct.Controls.Add(newCtrl);
				dct.Name = "dct"+plugin.Name;
				dct.Text = plugin.Name;

				if (plugin.ViewControlPosition == ViewControlPosition.FLOAT)
				{
					record.ControlPosition = ViewControlPosition.FLOAT;
					dct.FloatingSize = new System.Drawing.Size(400, 300);
					dct.Location = new System.Drawing.Point(0, 20);
					dct.Size = new System.Drawing.Size(808, 165);

					ControlLayoutSystem layout = new ControlLayoutSystem(180, 100, new DockControl [] {dct}, dct);
					this.leftSandDock.LayoutSystem.LayoutSystems.Add(layout);
				}
				else if (plugin.ViewControlPosition == ViewControlPosition.MDI_CONTAINER)
				{
					record.ControlPosition = ViewControlPosition.MDI_CONTAINER;
					this.documentContainer.AddDocument(dct);
					this.dctToolbox.Controls.Add((System.Windows.Forms.Control)plugin.ToolboxItems[0]);
				}

				record.ViewControl = dct;
			}
			this.activeViews.Add(plugin.GetType().ToString(), record);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="type"></param>
		public void RemoveView(string type) 
		{
			ActiveViewPluginRecord record = (ActiveViewPluginRecord)this.activeViews[type];
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
			this.activeViews.Remove(type.ToString());
		}

		/// <summary>
		/// Adds visual components for a analyze plugin to the GUI
		/// </summary>
		/// <param name="plugin">The plugin for which user controls should be added</param>
		public void AddAnalysis(IAnalyzePlugin plugin)
		{
			if (this.activeAnalyses[plugin.GetType().ToString()] != null)
			{
				log.Error("Plugin has already been added to the GUI");
				return;
			}

			// create a new record to hold viewplugin informations
			ActiveAnalysisPluginRecord record = new ActiveAnalysisPluginRecord();
			record.Type = plugin.GetType().ToString();

			// create menu item
			TD.SandBar.MenuButtonItem analyzeMenuItem = new TD.SandBar.MenuButtonItem(plugin.Name);
			analyzeMenuItem.Activate += new System.EventHandler(this.menubar_Analyses_Plugin_Activate);
			if (this.menubar_Analyses.MenuItems.Count == 1)
				analyzeMenuItem.BeginGroup = true;

			record.AnalysesMenuItem = analyzeMenuItem;
			this.menubar_Analyses.MenuItems.Add(analyzeMenuItem);

			this.activeAnalyses.Add(plugin.GetType().ToString(), record);
		}

		public void AddAnalysisResult(UserControl result)
		{
			if (result != null) 
			{
				result.Dock = System.Windows.Forms.DockStyle.Fill;
				DockControl dct = new TD.SandDock.DockControl();
				dct.AutoScroll = true;
				dct.Controls.Add(result);
				dct.Text = "Result";

				dct.FloatingSize = new System.Drawing.Size(400, 300);
				dct.Location = new System.Drawing.Point(0, 20);
				dct.Size = new System.Drawing.Size(808, 165);

				ControlLayoutSystem layout = new ControlLayoutSystem(180, 100, new DockControl [] {dct}, dct);
				this.bottomSandDock.LayoutSystem.LayoutSystems.Add(layout);
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="selected"></param>
		public void SetSelectedObject(object selected)
		{
			this.propertyGrid.SelectedObject = selected;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public object GetSelectedObject()
		{
			return this.propertyGrid.SelectedObject;
		}

		#region Menu Handler

		// FILE //////////
		private void menubar_File_New_Activate(object sender, System.EventArgs e)
		{
			this._facade.FireNewComponentModelRequested();
		}

		private void menubar_File_Open_Activate(object sender, System.EventArgs e)
		{
			if (openFileDialog.ShowDialog() == DialogResult.OK)
			{
				this._facade.FireOpenComponentModelRequested(this.openFileDialog.FileName);
			}
		}

		private void menubar_File_Save_Activate(object sender, System.EventArgs e)
		{
			if (this._facade.Abstraction.ModelFileName != null)
			{
				this._facade.FireSaveComponentModelRequested();
			}
			else
			{
				this.menubar_File_SaveAs_Activate(sender, e);
			}
		}

		private void menubar_File_SaveAs_Activate(object sender, System.EventArgs e)
		{
			if (saveFileDialog.ShowDialog() == DialogResult.OK)
			{
				this._facade.FireSaveComponentModelAsRequested(this.saveFileDialog.FileName);
			}			
		}

		private void menubar_File_Exit_Activate(object sender, System.EventArgs e)
		{
			Close();
		}

		// EDIT //////////
		private void menubar_Edit_Undo_Activate(object sender, System.EventArgs e)
		{
			this._facade.FireUndoRequested();
		}

		private void menubar_Edit_Redo_Activate(object sender, System.EventArgs e)
		{
			this._facade.FireRedoRequested();
		}

		private void menubar_Edit_Plugins_Activate(object sender, System.EventArgs e)
		{
			this._facade.FirePluginControlDialogRequested();
		}

		// VIEW //////////
		private void menubar_View_Output_Activate(object sender, System.EventArgs e)
		{
			this.dctOutput.Open();
			this.dctOutput.Activate();
		}

		private void menubar_View_Properties_Activate(object sender, System.EventArgs e)
		{
			this.dctProperties.Open();
			this.dctProperties.Activate();
		}

		private void menubar_View_Toolbox_Activate(object sender, System.EventArgs e)
		{
			this.dctToolbox.Open();
			this.dctToolbox.Activate();
		}

		private void menubar_View_Plugin_Activate(object sender, System.EventArgs e)
		{
			foreach (ActiveViewPluginRecord viewRcrd in this.activeViews.Values)
			{
				if (sender == viewRcrd.ViewMenuItem)
				{
					if (viewRcrd.ControlPosition == ViewControlPosition.FLOAT)
					{
						viewRcrd.ViewControl.Open();
						viewRcrd.ViewControl.Activate();
					}
					else if (viewRcrd.ControlPosition == ViewControlPosition.MDI_CONTAINER)
					{
						if (!this.documentContainer.Contains(viewRcrd.ViewControl))
							this.documentContainer.AddDocument(viewRcrd.ViewControl);
						this.documentContainer.ActiveDocument = viewRcrd.ViewControl;
					}
				}
			}
		}

		// ANALYSES //////////
		private void menubar_Analyses_Analyses_Activate(object sender, System.EventArgs e)
		{
			this._facade.FireAnalysesControlDialogRequested(null);
		}

		private void menubar_Analyses_Plugin_Activate(object sender, System.EventArgs e)
		{
			foreach (ActiveAnalysisPluginRecord anaRcrd in this.activeAnalyses.Values)
			{
				if (sender == anaRcrd.AnalysesMenuItem)
				{
					this._facade.FireAnalysesControlDialogRequested(anaRcrd.Type);
				}
			}
		}
		#endregion

		private void GUIMainForm_Closing(object sender, System.ComponentModel.CancelEventArgs e)
		{
			this._facade.FireExitApplicationRequested();
		}





		private struct ActiveViewPluginRecord
		{
			public TD.SandBar.MenuButtonItem ViewMenuItem;
			public DockControl ViewControl;
			public ViewControlPosition ControlPosition;
		}

		private struct ActiveAnalysisPluginRecord
		{
			public TD.SandBar.MenuButtonItem AnalysesMenuItem;
			public string Type;
		}
	}
}
