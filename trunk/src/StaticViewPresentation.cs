using System;
using System.Reflection;
using System.Drawing;
using System.IO;
using System.Windows.Forms;
using Syncfusion.Windows.Forms.Diagram;
using Syncfusion.Windows.Forms.Diagram.Controls;
using Palladio.Editor.Common;
using Palladio.Editor.Common.EntityProxies;
using Palladio.Identifier;
using log4net;

namespace Palladio.Editor.Plugins.StaticView
{
	/// <summary>
	/// Zusammenfassung für StaticViewPresentation.
	/// </summary>
	public class StaticViewPresentation : System.Windows.Forms.Form
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(StaticViewPresentation));
		private Syncfusion.Windows.Forms.Diagram.Controls.Diagram diagram;

		private Syncfusion.Windows.Forms.Diagram.NodeCollection.EventHandler diagram_SelectionChangedHandler;
		private System.Windows.Forms.Panel panel1;

		private Syncfusion.Windows.Forms.Diagram.NodeCollection.EventHandler diagram_ChildrenChangingHandler;
		private Syncfusion.Windows.Forms.Diagram.ConnectionCollection.EventHandler diagram_ConnectionsChangeCompleteHandler;
		private System.Windows.Forms.Panel panel2;
		private System.Windows.Forms.Panel panel3;
		private System.Windows.Forms.ToolBar toolBar;
		private System.Windows.Forms.ImageList imageList;
		private System.Windows.Forms.ToolBarButton toolBarZoom;
		private System.Windows.Forms.ToolBarButton toolBarShowGrid;
		private System.Windows.Forms.ToolBarButton toolBarSnapToGrid;
		private System.Windows.Forms.ToolBarButton toolBarSelect;
		private System.ComponentModel.IContainer components;
		private Syncfusion.Windows.Forms.Diagram.Controls.PaletteGroupView publicPaletteView;
		private Syncfusion.Windows.Forms.Diagram.Controls.PaletteGroupView privatePaletteView;
		private System.Windows.Forms.ToolBarButton toolBarLink;

		private Port sourcePort = null;
		private Port targetPort = null;
		private Connection intermediateConnection = null;
		private Symbols.Link _userGeneratedLink = null;
		private Symbols.Component _userDraggedComponent = null;

		public event SelectionChangedHandler SelectionChanged;

		private IAbstractionAdapter _abstraction;

		public StaticViewPresentation(IAbstractionAdapter abstraction)
		{
			this._abstraction = abstraction;

			InitializeComponent();
			FileInfo assemblyInfo = new FileInfo(Assembly.GetAssembly(typeof(Palladio.Editor.Plugins.StaticView.Control)).Location);
			this.publicPaletteView.LoadPalette(assemblyInfo.DirectoryName+"\\palettetest1.edp");
			this.privatePaletteView.LoadPalette(assemblyInfo.DirectoryName+"\\privatePalette.edp");

			this.diagram_SelectionChangedHandler = new Syncfusion.Windows.Forms.Diagram.NodeCollection.EventHandler(diagram_SelectionChanged);
			this.diagram_ChildrenChangingHandler = new Syncfusion.Windows.Forms.Diagram.NodeCollection.EventHandler(diagram_ChildrenChanging);
			this.diagram_ConnectionsChangeCompleteHandler = new Syncfusion.Windows.Forms.Diagram.ConnectionCollection.EventHandler(diagram_ConnectionsChangeComplete);

			this.diagram.SelectionChanged += this.diagram_SelectionChangedHandler;
			this.diagram.NodeMoved += new MoveEventHandler(diagram_NodeMoved);
			this.diagram.MouseUp +=new MouseEventHandler(diagram_MouseUp);

			this.diagram.ConnectionsChangeComplete += this.diagram_ConnectionsChangeCompleteHandler;

			LinkTool tool = this.diagram.Controller.GetTool("LinkTool") as LinkTool;
			tool.LinkFactory = new LinkFactory(this.CreateLink);
		}

		public void Initialize(CompositeComponentProxy model)
		{
			this.diagram.ChildrenChanging -= this.diagram_ChildrenChangingHandler;
			this.diagram.Model.Clear();
			Symbols.Component modelSymbol = this.AddComponent(model);
			this._abstraction.ModelID = new Guid(modelSymbol.Name);
			modelSymbol.Translate(240,120);
			modelSymbol.Scale(3f,3f);
			this._abstraction.RegisterSymbol(this._abstraction.ModelID, model, modelSymbol.X, modelSymbol.Y);
			modelSymbol.UpdateRoles();
			this.diagram.Controller.SelectionList.Clear();
			this.diagram.Model.UpdateViews();
			this.diagram.ChildrenChanging += this.diagram_ChildrenChangingHandler;
		}


		public void SelectSymbol(EntityProxy proxy)
		{
			// avoid event loop
			this.diagram.SelectionChanged -= this.diagram_SelectionChangedHandler;

			this.diagram.Controller.SelectionList.Clear();

			if (proxy == null) 
			{
				this.diagram.Model.UpdateViews();
				return;
			}

			foreach(System.Guid guid in this._abstraction.GetSymbolIDsByEntityID(proxy.ID))
			{
				INode node = this.diagram.Model.GetChildByName(guid.ToString());
				if (node != null)
					this.diagram.Controller.SelectionList.Add(node);
			}

			this.diagram.Model.UpdateViews();
			this.diagram.SelectionChanged += this.diagram_SelectionChangedHandler;
		}

		/// <summary>
		/// Die verwendeten Ressourcen bereinigen.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Vom Windows Form-Designer generierter Code
		/// <summary>
		/// Erforderliche Methode für die Designerunterstützung. 
		/// Der Inhalt der Methode darf nicht mit dem Code-Editor geändert werden.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(StaticViewPresentation));
			this.diagram = new Syncfusion.Windows.Forms.Diagram.Controls.Diagram();
			this.publicPaletteView = new Syncfusion.Windows.Forms.Diagram.Controls.PaletteGroupView();
			this.privatePaletteView = new Syncfusion.Windows.Forms.Diagram.Controls.PaletteGroupView();
			this.panel1 = new System.Windows.Forms.Panel();
			this.panel3 = new System.Windows.Forms.Panel();
			this.panel2 = new System.Windows.Forms.Panel();
			this.toolBar = new System.Windows.Forms.ToolBar();
			this.toolBarSelect = new System.Windows.Forms.ToolBarButton();
			this.toolBarShowGrid = new System.Windows.Forms.ToolBarButton();
			this.toolBarSnapToGrid = new System.Windows.Forms.ToolBarButton();
			this.toolBarZoom = new System.Windows.Forms.ToolBarButton();
			this.toolBarLink = new System.Windows.Forms.ToolBarButton();
			this.imageList = new System.Windows.Forms.ImageList(this.components);
			this.panel1.SuspendLayout();
			this.panel3.SuspendLayout();
			this.panel2.SuspendLayout();
			this.SuspendLayout();
			// 
			// diagram
			// 
			this.diagram.AllowDrop = true;
			this.diagram.BackColor = System.Drawing.Color.White;
			// 
			// diagram.Controller
			// 
			this.diagram.Controller.MaxHistory = 128;
			this.diagram.Dock = System.Windows.Forms.DockStyle.Fill;
			this.diagram.HScroll = true;
			this.diagram.LayoutManager = null;
			this.diagram.Location = new System.Drawing.Point(0, 0);
			// 
			// diagram.Model
			// 
			this.diagram.Model.BackgroundStyle.Color = System.Drawing.Color.White;
			this.diagram.Model.BackgroundStyle.GradientAngle = 90F;
			this.diagram.Model.BackgroundStyle.GradientBounds = ((System.Drawing.RectangleF)(resources.GetObject("diagram.Model.BackgroundStyle.GradientBounds")));
			this.diagram.Model.BackgroundStyle.GradientStartColor = System.Drawing.Color.White;
			this.diagram.Model.BackgroundStyle.Properties = this.diagram.Model;
			this.diagram.Model.BackgroundStyle.Texture = null;
			this.diagram.Model.BackgroundStyle.TextureWrapMode = System.Drawing.Drawing2D.WrapMode.Tile;
			this.diagram.Model.BackgroundStyle.Type = Syncfusion.Windows.Forms.Diagram.BackgroundStyle.BackgroundType.Solid;
			this.diagram.Model.BoundaryConstraintsEnabled = true;
			this.diagram.Model.FillStyle.AlphaFactor = 255;
			this.diagram.Model.FillStyle.Color = System.Drawing.Color.White;
			this.diagram.Model.FillStyle.GradientAngle = 90F;
			this.diagram.Model.FillStyle.GradientBounds = ((System.Drawing.RectangleF)(resources.GetObject("diagram.Model.FillStyle.GradientBounds")));
			this.diagram.Model.FillStyle.GradientStartColor = System.Drawing.Color.White;
			this.diagram.Model.FillStyle.Properties = this.diagram.Model;
			this.diagram.Model.FillStyle.Texture = null;
			this.diagram.Model.FillStyle.TextureWrapMode = System.Drawing.Drawing2D.WrapMode.Tile;
			this.diagram.Model.FillStyle.Type = Syncfusion.Windows.Forms.Diagram.FillStyle.FillType.Solid;
			this.diagram.Model.Height = 1056F;
			this.diagram.Model.LineStyle.DashCap = System.Drawing.Drawing2D.DashCap.Flat;
			this.diagram.Model.LineStyle.DashOffset = 0F;
			this.diagram.Model.LineStyle.DashStyle = System.Drawing.Drawing2D.DashStyle.Solid;
			this.diagram.Model.LineStyle.EndCap = System.Drawing.Drawing2D.LineCap.Flat;
			this.diagram.Model.LineStyle.LineColor = System.Drawing.Color.Black;
			this.diagram.Model.LineStyle.LineJoin = System.Drawing.Drawing2D.LineJoin.Bevel;
			this.diagram.Model.LineStyle.LineWidth = 2F;
			this.diagram.Model.LineStyle.MiterLimit = 10F;
			this.diagram.Model.LineStyle.Properties = this.diagram.Model;
			this.diagram.Model.MeasurementScale = 1F;
			this.diagram.Model.MeasurementUnits = System.Drawing.GraphicsUnit.Pixel;
			this.diagram.Model.Name = "Model";
			this.diagram.Model.RenderingStyle.Properties = this.diagram.Model;
			this.diagram.Model.RenderingStyle.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.Default;
			this.diagram.Model.ShadowStyle.AlphaFactor = 128;
			this.diagram.Model.ShadowStyle.Color = System.Drawing.Color.LightGray;
			this.diagram.Model.ShadowStyle.OffsetX = 6F;
			this.diagram.Model.ShadowStyle.OffsetY = 6F;
			this.diagram.Model.ShadowStyle.Properties = this.diagram.Model;
			this.diagram.Model.ShadowStyle.Visible = false;
			this.diagram.Model.Width = 1024F;
			this.diagram.Name = "diagram";
			this.diagram.NudgeIncrement = 1F;
			this.diagram.ScrollGranularity = 0.5F;
			this.diagram.Size = new System.Drawing.Size(872, 425);
			this.diagram.SmartSizeBox = false;
			this.diagram.TabIndex = 2;
			// 
			// diagram.View
			// 
			this.diagram.View.BackgroundColor = System.Drawing.Color.DarkGray;
			this.diagram.View.Grid.Color = System.Drawing.Color.DarkGray;
			this.diagram.View.Grid.DashOffset = 4F;
			this.diagram.View.Grid.DashStyle = System.Drawing.Drawing2D.DashStyle.Dash;
			this.diagram.View.Grid.GridStyle = Syncfusion.Windows.Forms.Diagram.GridStyle.Point;
			this.diagram.View.Grid.HorizontalSpacing = 6F;
			this.diagram.View.Grid.SnapToGrid = true;
			this.diagram.View.Grid.VerticalSpacing = 6F;
			this.diagram.View.Grid.Visible = true;
			this.diagram.View.HandleAnchorColor = System.Drawing.Color.Lavender;
			this.diagram.View.HandleColor = System.Drawing.Color.Beige;
			this.diagram.View.HandleDisabledColor = System.Drawing.Color.Black;
			this.diagram.View.HandleSize = 5;
			this.diagram.View.HorizontalRuler.Visible = true;
			this.diagram.View.MouseTrackingEnabled = true;
			this.diagram.View.PasteOffsetX = 10;
			this.diagram.View.PasteOffsetY = 10;
			this.diagram.View.RulerFillColor = System.Drawing.Color.LightGray;
			this.diagram.View.RulerLineColor = System.Drawing.Color.Black;
			this.diagram.View.RulerSize = 12;
			this.diagram.View.RulerUnits = Syncfusion.Windows.Forms.Diagram.MeasurementsUnit.Inches;
			this.diagram.View.ShowPageBounds = true;
			this.diagram.View.VerticalRuler.Visible = true;
			this.diagram.VScroll = true;
			// 
			// publicPaletteView
			// 
			this.publicPaletteView.BorderStyle = System.Windows.Forms.BorderStyle.None;
			this.publicPaletteView.EditMode = false;
			this.publicPaletteView.Location = new System.Drawing.Point(0, 0);
			this.publicPaletteView.Name = "publicPaletteView";
			this.publicPaletteView.Palette = null;
			this.publicPaletteView.Size = new System.Drawing.Size(168, 264);
			this.publicPaletteView.TabIndex = 1;
			this.publicPaletteView.Text = "publicPaletteView";
			// 
			// privatePaletteView
			// 
			this.privatePaletteView.BorderStyle = System.Windows.Forms.BorderStyle.None;
			this.privatePaletteView.EditMode = false;
			this.privatePaletteView.Location = new System.Drawing.Point(0, 0);
			this.privatePaletteView.Name = "privatePaletteView";
			this.privatePaletteView.Palette = null;
			this.privatePaletteView.Size = new System.Drawing.Size(168, 264);
			this.privatePaletteView.TabIndex = 1;
			this.privatePaletteView.Text = "privatePaletteView";
			// 
			// panel1
			// 
			this.panel1.Controls.Add(this.panel3);
			this.panel1.Controls.Add(this.panel2);
			this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
			this.panel1.Location = new System.Drawing.Point(0, 0);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(872, 453);
			this.panel1.TabIndex = 3;
			// 
			// panel3
			// 
			this.panel3.Controls.Add(this.diagram);
			this.panel3.Dock = System.Windows.Forms.DockStyle.Fill;
			this.panel3.Location = new System.Drawing.Point(0, 28);
			this.panel3.Name = "panel3";
			this.panel3.Size = new System.Drawing.Size(872, 425);
			this.panel3.TabIndex = 4;
			// 
			// panel2
			// 
			this.panel2.Controls.Add(this.toolBar);
			this.panel2.Dock = System.Windows.Forms.DockStyle.Top;
			this.panel2.Location = new System.Drawing.Point(0, 0);
			this.panel2.Name = "panel2";
			this.panel2.Size = new System.Drawing.Size(872, 28);
			this.panel2.TabIndex = 3;
			// 
			// toolBar
			// 
			this.toolBar.Buttons.AddRange(new System.Windows.Forms.ToolBarButton[] {
																					   this.toolBarSelect,
																					   this.toolBarShowGrid,
																					   this.toolBarSnapToGrid,
																					   this.toolBarZoom,
																					   this.toolBarLink});
			this.toolBar.DropDownArrows = true;
			this.toolBar.ImageList = this.imageList;
			this.toolBar.Location = new System.Drawing.Point(0, 0);
			this.toolBar.Name = "toolBar";
			this.toolBar.ShowToolTips = true;
			this.toolBar.Size = new System.Drawing.Size(872, 28);
			this.toolBar.TabIndex = 0;
			this.toolBar.ButtonClick += new System.Windows.Forms.ToolBarButtonClickEventHandler(this.toolBar_ButtonClick);
			// 
			// toolBarSelect
			// 
			this.toolBarSelect.ImageIndex = 0;
			this.toolBarSelect.ToolTipText = "Edit";
			// 
			// toolBarShowGrid
			// 
			this.toolBarShowGrid.ImageIndex = 1;
			this.toolBarShowGrid.ToolTipText = "Show Grid";
			// 
			// toolBarSnapToGrid
			// 
			this.toolBarSnapToGrid.ImageIndex = 2;
			this.toolBarSnapToGrid.ToolTipText = "Snap to Grid";
			// 
			// toolBarZoom
			// 
			this.toolBarZoom.ImageIndex = 3;
			this.toolBarZoom.ToolTipText = "Zoom";
			// 
			// toolBarLink
			// 
			this.toolBarLink.ImageIndex = 4;
			this.toolBarLink.ToolTipText = "Connect";
			// 
			// imageList
			// 
			this.imageList.ImageSize = new System.Drawing.Size(16, 16);
			this.imageList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList.ImageStream")));
			this.imageList.TransparentColor = System.Drawing.Color.Magenta;
			// 
			// StaticViewPresentation
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(872, 453);
			this.Controls.Add(this.publicPaletteView);
			this.Controls.Add(this.panel1);
			this.Name = "StaticViewPresentation";
			this.Text = "StaticViewPresentation";
			this.panel1.ResumeLayout(false);
			this.panel3.ResumeLayout(false);
			this.panel2.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		public System.Windows.Forms.Control ViewControl
		{
			get { return this.panel1; }
		}

		public System.Windows.Forms.Control Palette
		{
			get { return this.publicPaletteView; }
		}

		public void UpdateEntity(EntityProxy entity)
		{
			this.diagram.ChildrenChanging -= this.diagram_ChildrenChangingHandler;
			foreach (System.Guid guid in this._abstraction.GetSymbolIDsByEntityID(entity.ID))
			{
				INode node = this.diagram.Model.GetChildByName(guid.ToString());
				if (node is Symbols.PalladioSymbol)
				{
					if (node is Symbols.Component)
						if (entity is ComponentProxy)
							((Symbols.Component)node).Labels["Name"].Text = ((ComponentProxy)entity).Name;

					((Symbols.PalladioSymbol)node).Tag = entity;
				}
			}

			this.diagram.Model.UpdateViews();
			this.diagram.ChildrenChanging += this.diagram_ChildrenChangingHandler;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="comp"></param>
		/// <returns></returns>
		private Symbols.Component AddComponent(ComponentProxy comp)
		{
			Symbols.Component symbol = null;
			if (this._userDraggedComponent == null)
			{
				SymbolModel symModel = null;
				if (comp is CompositeComponentProxy)
					symModel = this.publicPaletteView.Palette.GetChildByName("Composite Component") as SymbolModel;
				else 
					symModel = this.publicPaletteView.Palette.GetChildByName("Basic Component") as SymbolModel;

				symbol = symModel.CreateSymbol() as Symbols.Component;
			}
			else
				symbol = this._userDraggedComponent;

			System.Guid newGuid = System.Guid.NewGuid();
			symbol.Name = newGuid.ToString();
			symbol.Tag = comp;
			symbol.Labels["Name"].Text = comp.Name;

			this._abstraction.RegisterSymbol(newGuid, comp, symbol.X, symbol.Y);

			this.diagram.Model.AppendChild(symbol);

			if (comp is CompositeComponentProxy)
			{
				foreach(ComponentProxy subcomp in ((CompositeComponentProxy)comp).Components)
				{
					Symbols.Component compSymbol = this.AddComponent(subcomp);
					compSymbol.ParentSymbol = symbol;
					((Symbols.CompositeComponent)symbol).RegisterComponent(subcomp.ID, compSymbol);
					compSymbol.X = symbol.X + 10;
					compSymbol.Y = symbol.Y + 10;
				}
			}

			foreach(RoleProxy role in comp.ProvidedRoles)
			{
				Symbols.ProvidesRole rolesymbol = this.CreateProvidesRoleSymbol();

				System.Guid roleGuid = System.Guid.NewGuid();
				rolesymbol.Name = newGuid.ToString();
				rolesymbol.Tag = role;

				rolesymbol.ParentSymbol = symbol;
				symbol.RegisterProvidesRole(role.ID, rolesymbol);
				this._abstraction.RegisterSymbol(roleGuid, role, 0, 0);

				this.diagram.Model.AppendChild(rolesymbol);

				// add interface symbol
				SymbolModel ifaceSymModel = this.privatePaletteView.Palette.GetChildByName("Provides Interface") as SymbolModel;
				Symbols.ProvidesInterface ifaceSymbol = ifaceSymModel.CreateSymbol() as Symbols.ProvidesInterface;

				InterfaceProxy ifaceProxy = role.Interface;

				System.Guid ifaceGuid = System.Guid.NewGuid();
				//ifaceSymbol.Name = role.ID.ToString()+":"+ifaceProxy.ID.ToString();
				ifaceSymbol.Name = ifaceGuid.ToString();
				ifaceSymbol.Tag = ifaceProxy;
				ifaceSymbol.EditStyle.AllowMove = false;
				ifaceSymbol.EditStyle.AllowResize = false;
				ifaceSymbol.FillStyle.Color = System.Drawing.Color.LightGray;

				ifaceSymbol.ParentSymbol = symbol as Symbols.Component;
				this._abstraction.RegisterSymbol(ifaceGuid, ifaceProxy, 0, 0);

				rolesymbol.InterfaceSymbol = ifaceSymbol;

				this.diagram.Model.AppendChild(ifaceSymbol);
			}

			foreach(RoleProxy role in comp.RequiredRoles)
			{
				Symbols.RequiresRole rolesymbol = this.CreateRequiresRoleSymbol();

				System.Guid roleGuid = System.Guid.NewGuid();
				rolesymbol.Name = newGuid.ToString();
				rolesymbol.Tag = role;

				rolesymbol.ParentSymbol = symbol;
				symbol.RegisterRequiresRole(role.ID, rolesymbol);
				this._abstraction.RegisterSymbol(roleGuid, role, 0, 0);

				this.diagram.Model.AppendChild(rolesymbol);

				// add interface symbol
				SymbolModel ifaceSymModel = this.privatePaletteView.Palette.GetChildByName("Requires Interface") as SymbolModel;
				Symbols.RequiresInterface ifaceSymbol = ifaceSymModel.CreateSymbol() as Symbols.RequiresInterface;

				InterfaceProxy ifaceProxy = role.Interface;

				System.Guid ifaceGuid = System.Guid.NewGuid();
				//ifaceSymbol.Name = role.ID.ToString()+":"+ifaceProxy.ID.ToString();
				ifaceSymbol.Name = ifaceGuid.ToString();
				ifaceSymbol.Tag = ifaceProxy;
				ifaceSymbol.EditStyle.AllowMove = false;
				ifaceSymbol.EditStyle.AllowResize = false;
				ifaceSymbol.FillStyle.Color = System.Drawing.Color.LightGray;

				ifaceSymbol.ParentSymbol = symbol as Symbols.Component;
				this._abstraction.RegisterSymbol(ifaceGuid, ifaceProxy, 0, 0);

				rolesymbol.InterfaceSymbol = ifaceSymbol;

				this.diagram.Model.AppendChild(ifaceSymbol);
			}
			this.diagram.Controller.SelectionList.Clear();
			this.diagram.Controller.SelectionList.Add(symbol);
			return symbol;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="target"></param>
		/// <param name="compID"></param>
		public void AddComponent(CompositeComponentProxy target, IIdentifier compID)
		{
			this.diagram.ChildrenChanging -= this.diagram_ChildrenChangingHandler;

			foreach (System.Guid guid in this._abstraction.GetSymbolIDsByEntityID(target.ID))
			{
				INode node = this.diagram.Model.GetChildByName(guid.ToString());
				if (node is Symbols.CompositeComponent)
				{
					Symbols.CompositeComponent parentSymbol = node as Symbols.CompositeComponent;
					foreach (ComponentProxy subcomp in target.Components)
					{
						if (subcomp.ID.Equals(compID))
						{
							Symbols.Component symbol = this.AddComponent(subcomp);
							if (this._userDraggedComponent == null)
							{
								symbol.ParentSymbol = parentSymbol;
								symbol.Translate(parentSymbol.X+10,parentSymbol.Y+10);
							}
							parentSymbol.RegisterComponent(subcomp.ID, symbol);
							symbol.UpdateRoles();
							parentSymbol.UpdateComponents();
							break;
						}
					}
				}
			}
			this._userDraggedComponent = null;

			this.diagram.Model.UpdateViews();
			this.diagram.ChildrenChanging += this.diagram_ChildrenChangingHandler;
		}
		
		/// <summary>
		/// 
		/// </summary>
		/// <param name="proxy"></param>
		/// <param name="removeID"></param>
		public void RemoveComponent(CompositeComponentProxy proxy, IIdentifier removeID)
		{
			this.diagram.ChildrenChanging -= this.diagram_ChildrenChangingHandler;

			foreach(System.Guid guid in this._abstraction.GetSymbolIDsByEntityID(proxy.ID))
			{
				INode node = this.diagram.Model.GetChildByName(guid.ToString());
				if (node is Symbols.CompositeComponent)
				{
					Symbols.CompositeComponent parentNode = node as Symbols.CompositeComponent;
					Symbols.PalladioSymbol deleteNode = parentNode.GetComponent(removeID);
					if (deleteNode != null)
					{
						if (deleteNode is Symbols.CompositeComponent)
							RemoveCompositeComponentSymbol(deleteNode as Symbols.CompositeComponent);
						else if (deleteNode is Symbols.BasicComponent)
							RemoveBasicComponentSymbol(deleteNode as Symbols.BasicComponent);
						parentNode.UnregisterComponent(((ComponentProxy)deleteNode.Tag).ID);
						parentNode.Tag = proxy;
					}
				}
			}
			
			this.diagram.Model.UpdateViews();
			this.diagram.ChildrenChanging += this.diagram_ChildrenChangingHandler;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="proxy"></param>
		/// <param name="ifaceID"></param>
		public void AddProvidesInterface(ComponentProxy proxy, IIdentifier ifaceID)
		{
			this.diagram.ChildrenChanging -= this.diagram_ChildrenChangingHandler;

			foreach (System.Guid guid in this._abstraction.GetSymbolIDsByEntityID(proxy.ID))
			{
				INode node = this.diagram.Model.GetChildByName(guid.ToString());
			
				if (node is Symbols.Component)
				{
					// add role symbol
					Symbols.ProvidesRole symbol = this.CreateProvidesRoleSymbol();

					RoleProxy newRole = proxy.GetProvidesRoleByInterfaceID(ifaceID);

					System.Guid newGuid = System.Guid.NewGuid();
					symbol.Name = newGuid.ToString();
					symbol.Tag = newRole;

					symbol.ParentSymbol = node as Symbols.Component;
					((Symbols.Component)node).RegisterProvidesRole(newRole.ID, symbol);
					this._abstraction.RegisterSymbol(newGuid, newRole, 0, 0);

					this.diagram.Model.AppendChild(symbol);

					// add interface symbol
					SymbolModel ifaceSymModel = this.privatePaletteView.Palette.GetChildByName("Provides Interface") as SymbolModel;
					Symbols.ProvidesInterface ifaceSymbol = ifaceSymModel.CreateSymbol() as Symbols.ProvidesInterface;

					InterfaceProxy ifaceProxy = newRole.Interface;

					System.Guid ifaceGuid = System.Guid.NewGuid();
					//ifaceSymbol.Name = newRole.ID.ToString()+":"+ifaceProxy.ID.ToString();
					ifaceSymbol.Name = ifaceGuid.ToString();
					ifaceSymbol.Tag = ifaceProxy;
					ifaceSymbol.EditStyle.AllowMove = false;
					ifaceSymbol.EditStyle.AllowResize = false;
					ifaceSymbol.FillStyle.Color = System.Drawing.Color.LightGray;

					ifaceSymbol.ParentSymbol = node as Symbols.Component;
					this._abstraction.RegisterSymbol(ifaceGuid, ifaceProxy, 0, 0);

					symbol.InterfaceSymbol = ifaceSymbol;

					this.diagram.Model.AppendChild(ifaceSymbol);

					((Symbols.Component)node).Tag = proxy;
					((Symbols.Component)node).UpdateRoles();
				}
			}
			this.diagram.Model.UpdateViews();
			this.diagram.ChildrenChanging += this.diagram_ChildrenChangingHandler;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="proxy"></param>
		/// <param name="ifaceID"></param>
		public void AddRequiresInterface(ComponentProxy proxy, IIdentifier ifaceID)
		{
			this.diagram.ChildrenChanging -= this.diagram_ChildrenChangingHandler;

			foreach(System.Guid guid in this._abstraction.GetSymbolIDsByEntityID(proxy.ID))
			{
				INode node = this.diagram.Model.GetChildByName(guid.ToString());
			
				if (node is Symbols.Component)
				{
					// add role symbol
					Symbols.RequiresRole symbol = this.CreateRequiresRoleSymbol();

					RoleProxy newRole = proxy.GetRequiresRoleByInterfaceID(ifaceID);

					System.Guid newGuid = System.Guid.NewGuid();
					symbol.Name = newGuid.ToString();
					symbol.Tag = newRole;

					symbol.ParentSymbol = node as Symbols.Component;
					((Symbols.Component)node).RegisterRequiresRole(newRole.ID, symbol);
					this._abstraction.RegisterSymbol(newGuid, newRole, 0, 0);

					this.diagram.Model.AppendChild(symbol);

					// add interface symbol
					SymbolModel ifaceSymModel = this.privatePaletteView.Palette.GetChildByName("Requires Interface") as SymbolModel;
					Symbols.RequiresInterface ifaceSymbol = ifaceSymModel.CreateSymbol() as Symbols.RequiresInterface;

					InterfaceProxy ifaceProxy = newRole.Interface;

					System.Guid ifaceGuid = System.Guid.NewGuid();
					//ifaceSymbol.Name = newRole.ID.ToString()+":"+ifaceProxy.ID.ToString();
					ifaceSymbol.Name = ifaceGuid.ToString();
					ifaceSymbol.Tag = ifaceProxy;
					ifaceSymbol.EditStyle.AllowMove = false;
					ifaceSymbol.EditStyle.AllowResize = false;
					ifaceSymbol.FillStyle.Color = System.Drawing.Color.LightGray;

					ifaceSymbol.ParentSymbol = node as Symbols.Component;
					this._abstraction.RegisterSymbol(ifaceGuid, ifaceProxy, 0, 0);

					symbol.InterfaceSymbol = ifaceSymbol;

					this.diagram.Model.AppendChild(ifaceSymbol);

					((Symbols.Component)node).Tag = proxy;
					((Symbols.Component)node).UpdateRoles();
				}
			}
			this.diagram.Model.UpdateViews();
			this.diagram.ChildrenChanging += this.diagram_ChildrenChangingHandler;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="proxy"></param>
		/// <param name="connID"></param>
		/// <param name="tag"></param>
		public void AddConnection(CompositeComponentProxy proxy, IIdentifier connID, object tag)
		{
			this.diagram.ChildrenChanging -= this.diagram_ChildrenChangingHandler;
			this.diagram.ConnectionsChangeComplete -= this.diagram_ConnectionsChangeCompleteHandler;

			if (this._userGeneratedLink != null)
			{
				this._userGeneratedLink.TailPort.EditStyle.AllowMove = false;
				this._userGeneratedLink.HeadPort.EditStyle.AllowMove = false;
				this._userGeneratedLink.Tag = tag;
				this.diagram.Model.AppendChild(this._userGeneratedLink);
				this.sourcePort.Container.Connect(this.sourcePort, this._userGeneratedLink.TailPort);
				this.targetPort.Container.Connect(this._userGeneratedLink.HeadPort, this.targetPort);
			}

			this._userGeneratedLink = null;
			this.diagram.Model.UpdateViews();
			this.diagram.ConnectionsChangeComplete += this.diagram_ConnectionsChangeCompleteHandler;
			this.diagram.ChildrenChanging += this.diagram_ChildrenChangingHandler;
		}

		private void diagram_ChildrenChanging(object sender, Syncfusion.Windows.Forms.Diagram.NodeCollection.EventArgs evtArgs)
		{
			if (evtArgs.ChangeType.ToString().Equals("Insert"))
			{
				if (evtArgs.Node is Symbols.Component)
				{
					Symbols.Component componentSymbol = evtArgs.Node as Symbols.Component;
					INode parentNode = null;
					NodeCollection nodeCollection = new NodeCollection();
					int intersecting = this.diagram.Model.GetChildrenIntersecting(
						nodeCollection, 
						new RectangleF(componentSymbol.X,componentSymbol.Y,componentSymbol.Width,componentSymbol.Height),
						this.diagram.CreateGraphics() );
					if (intersecting == 0)
					{
						log.Debug("invalid drop");
						evtArgs.Cancel = true;
						return;
					}
					if (intersecting > 1) 
					{
						log.Warn("ambiguous drop. trying to insert in top level container.");
						int highestZOrder = 0;
						foreach (INode node in nodeCollection)
						{
							if (node is Symbols.CompositeComponent)
							{
								int zOrder = this.diagram.Model.GetZOrder(node);
								if (zOrder > highestZOrder)
								{
									highestZOrder = zOrder;
									parentNode = node;
								}
							}
						}
						if (parentNode == null)
						{
							log.Error("no container");
							evtArgs.Cancel = true;
							return;
						}
					}
					if (intersecting == 1)
					{
						parentNode = nodeCollection[0];
					}

					if (!(parentNode is Symbols.CompositeComponent))
					{
						log.Debug("invalid drop");
						evtArgs.Cancel = true;
						return;
					}
					Symbols.CompositeComponent parentSymbol = parentNode as Symbols.CompositeComponent;

					CompositeComponentProxy parentEntity = parentSymbol.Tag as CompositeComponentProxy;

					this._userDraggedComponent = componentSymbol;
					this._userDraggedComponent.ParentSymbol = parentSymbol;

					evtArgs.Cancel = true;

					IIdentifier compID = null;
					if (this._userDraggedComponent is Symbols.BasicComponent)
						compID = parentEntity.AddBasicComponent("Basic");
					else if (this._userDraggedComponent is Symbols.CompositeComponent)
						compID = parentEntity.AddCompositeComponent("Composite");

					
				}
			}
		}

		private void diagram_SelectionChanged(object sender, Syncfusion.Windows.Forms.Diagram.NodeCollection.EventArgs evtArgs)
		{
			if (evtArgs.ChangeType.ToString().Equals("Insert"))
			{
				if (evtArgs.Node is Symbols.PalladioSymbol)
				{
					Symbols.PalladioSymbol selectedNode = evtArgs.Node as Symbols.PalladioSymbol;
					if (this.SelectionChanged != null)
						this.SelectionChanged(this, selectedNode.Tag as EntityProxy);
				}
				else if (evtArgs.Node is  Symbols.Link)
				{
					Symbols.Link selectedNode = evtArgs.Node as Symbols.Link;
					if (this.SelectionChanged != null)
						this.SelectionChanged(this, selectedNode.Tag as EntityProxy);

				}
			}
			else if (evtArgs.ChangeType.ToString().Equals("Clear"))
			{
				if (this.SelectionChanged != null)
					this.SelectionChanged(this, null);
			}
		}

		private void diagram_NodeMoved(object sender, MoveEventArgs evtArgs)
		{
			foreach (INode node in evtArgs.Nodes)
			{
				if (node is Symbols.CompositeComponent)
				{
					Symbols.CompositeComponent compNode = node as Symbols.CompositeComponent;
					foreach(Symbols.Component child in compNode.Components)
					{
						if (!this.diagram.SelectionList.Contains(child))
							child.Translate(evtArgs.OffsetX, evtArgs.OffsetY);
					}
				}
			}
		}

		private void toolBar_ButtonClick(object sender, System.Windows.Forms.ToolBarButtonClickEventArgs e)
		{
			if (e.Button == this.toolBarZoom)
				this.diagram.Controller.ActivateTool("ZoomTool");
			else if (e.Button == this.toolBarSelect)
				this.diagram.Controller.ActivateTool("SelectTool");
			else if (e.Button == this.toolBarShowGrid)
				this.diagram.View.Grid.Visible = !this.diagram.View.Grid.Visible;
			else if (e.Button == this.toolBarSnapToGrid)
				this.diagram.View.Grid.SnapToGrid = !this.diagram.View.Grid.SnapToGrid;
			else if (e.Button == this.toolBarLink)
				this.diagram.Controller.ActivateTool("LinkTool");
		}

		// kein rausbewegen aus dem übergeordneten container
		private void diagram_MouseUp(object sender, MouseEventArgs e)
		{
			if (e.Button == MouseButtons.Left)
			{
				foreach(INode node in this.diagram.SelectionList)
				{
					// dont care about model node
					if (node.Name == this._abstraction.ModelID.ToString())
						continue;

					if (!(node is Symbols.Component))
						continue;

					Symbols.Component component = node as Symbols.Component;

					NodeCollection nodeCollection = new NodeCollection();
					this.diagram.Model.GetChildrenIntersecting(
						nodeCollection,
						new RectangleF(component.X,component.Y,component.Width,component.Height),
						this.diagram.CreateGraphics());
					if (!nodeCollection.Contains(component.ParentSymbol))
						this.diagram.Controller.UndoCommand();
				}
			}
		}

		private void RemoveCompositeComponentSymbol(Symbols.CompositeComponent symbol)
		{
			foreach (Symbols.ProvidesRole providedRole in symbol.ProvidesRoles)
			{
				this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(providedRole));
				this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(providedRole.InterfaceSymbol));
				symbol.UnregisterProvidesRole(((RoleProxy)providedRole.Tag).ID);
			}
			foreach (Symbols.RequiresRole requiredRole in symbol.RequiresRoles)
			{
				this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(requiredRole));
				this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(requiredRole.InterfaceSymbol));
				symbol.UnregisterProvidesRole(((RoleProxy)requiredRole.Tag).ID);
			}
			foreach (Symbols.PalladioSymbol containedSymbol in  symbol.Components)
			{
				if (containedSymbol is Symbols.CompositeComponent)
					RemoveCompositeComponentSymbol(containedSymbol as Symbols.CompositeComponent);
				else if (containedSymbol is Symbols.BasicComponent)
					RemoveBasicComponentSymbol(containedSymbol as Symbols.BasicComponent);
				symbol.UnregisterComponent(((ComponentProxy)containedSymbol.Tag).ID);
			}
			this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(symbol));
		}

		private void RemoveBasicComponentSymbol(Symbols.BasicComponent symbol)
		{
			foreach (Symbols.ProvidesRole providedRole in symbol.ProvidesRoles)
			{
				this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(providedRole));
				this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(providedRole.InterfaceSymbol));
				symbol.UnregisterProvidesRole(((RoleProxy)providedRole.Tag).ID);
			}
			foreach (Symbols.RequiresRole requiredRole in symbol.RequiresRoles)
			{
				this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(requiredRole));
				this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(requiredRole.InterfaceSymbol));
				symbol.UnregisterProvidesRole(((RoleProxy)requiredRole.Tag).ID);
			}
			this.diagram.Model.RemoveChild(this.diagram.Model.GetChildIndex(symbol));
		}

		private Link CreateLink(PointF[] pts)
		{
			return new Symbols.Link(pts);
		}

		private void diagram_ConnectionsChanging(object sender, Syncfusion.Windows.Forms.Diagram.ConnectionCollection.EventArgs evtArgs)
		{

		}

		private void diagram_ConnectionsChangeComplete(object sender, Syncfusion.Windows.Forms.Diagram.ConnectionCollection.EventArgs evtArgs)
		{

			if (evtArgs.ChangeType.ToString().ToLower().Equals("insert"))
			{
				Connection conn = evtArgs.Connection;
				if (conn.SourcePort is CirclePort)
				{
					this.sourcePort = conn.SourcePort;
					if (this.intermediateConnection == null)
						this.intermediateConnection = conn;
				}
				if (conn.TargetPort is CirclePort)
				{
					this.targetPort = conn.TargetPort;
					if (this.intermediateConnection == null)
						this.intermediateConnection = conn;
				}

				if (this.sourcePort != null && this.targetPort != null)
				{
					ConnectionType connType = this.PrepareConnection();

					Symbols.PalladioSymbol sourceRole = this.sourcePort.Container as Symbols.PalladioSymbol;
					Symbols.PalladioSymbol targetRole = this.targetPort.Container as Symbols.PalladioSymbol;

					try
					{
						switch (connType)
						{
							case ConnectionType.BINDING:
								this._userGeneratedLink = this.RemoveLink(conn, this.intermediateConnection);
								((CompositeComponentProxy)sourceRole.ParentSymbol.ParentSymbol.Tag).AddBinding(sourceRole.Tag as RoleProxy, targetRole.Tag as RoleProxy);
								break;
							case ConnectionType.PROVIDES_MAPPING:
								this._userGeneratedLink = this.RemoveLink(conn, this.intermediateConnection);
								((CompositeComponentProxy)sourceRole.ParentSymbol.Tag).AddProvidesMapping(sourceRole.Tag as RoleProxy, targetRole.Tag as RoleProxy);
								break;
							case ConnectionType.REQUIRES_MAPPING:
								this._userGeneratedLink = this.RemoveLink(conn, this.intermediateConnection);
								((CompositeComponentProxy)targetRole.ParentSymbol.Tag).AddRequiresMapping(sourceRole.Tag as RoleProxy, targetRole.Tag as RoleProxy);
								break;
							case ConnectionType.INVALID:
								log.Error("Could not establish connection.");
								this.RemoveLink(conn, this.intermediateConnection);
								this._userGeneratedLink = null;
								evtArgs.Cancel = true;
								break;
						}
					}
					catch (Exception e)
					{
						log.Error("Could not establish connection.");
						this.RemoveLink(conn, this.intermediateConnection);
						this._userGeneratedLink = null;
						evtArgs.Cancel = true;
					}

					this.diagram.Model.UpdateViews();
					this.sourcePort = null;
					this.targetPort = null;
					this.intermediateConnection = null;
				}
			}
		}

		private Symbols.Link RemoveLink(Connection conn1, Connection conn2)
		{
			this.diagram.ChildrenChanging -= this.diagram_ChildrenChangingHandler;
			this.diagram.ConnectionsChangeComplete -= this.diagram_ConnectionsChangeCompleteHandler;

			Symbols.Link link = null;
			if (conn1.TargetPort.Container is Symbols.Link)
				link = conn1.TargetPort.Container as Symbols.Link;
			else if (conn1.SourcePort.Container is Symbols.Link)
				link = conn1.SourcePort.Container as Symbols.Link;
			else if (conn2.TargetPort.Container is Symbols.Link)
				link = conn2.TargetPort.Container as Symbols.Link;
			else if (conn2.SourcePort.Container is Symbols.Link)
				link = conn2.SourcePort.Container as Symbols.Link;

			if (link != null)
			{
				this.sourcePort.Container.Disconnect(sourcePort, link.HeadPort);
				this.sourcePort.Container.Disconnect(sourcePort, link.TailPort);
				this.targetPort.Container.Disconnect(targetPort, link.HeadPort);
				this.targetPort.Container.Disconnect(targetPort, link.TailPort);

				int idx = this.diagram.Model.GetChildIndex(link);
				if (idx >= 0)
					this.diagram.Model.RemoveChild(idx);
			}

			this.diagram.ConnectionsChangeComplete += this.diagram_ConnectionsChangeCompleteHandler;
			this.diagram.ChildrenChanging += this.diagram_ChildrenChangingHandler;

			return link;
		}

		/// <summary>
		/// Detects the ConnectionType and sorts <code>this.sourcePort</code> and <code>this.targetPort</code>
		/// so that the connection is always pointing from requires side to provides side.
		/// </summary>
		/// <returns></returns>
		private ConnectionType PrepareConnection()
		{
			if (this.sourcePort.Container == this.targetPort.Container)
				return ConnectionType.INVALID;

			Port temp;

			if (this.sourcePort.Name == "InnerProvidesPort" && this.targetPort.Name == "OuterProvidesPort")
			{
				return ConnectionType.PROVIDES_MAPPING;
			}
			if (this.sourcePort.Name == "OuterProvidesPort" && this.targetPort.Name == "InnerProvidesPort")
			{
				temp = this.sourcePort;
				this.sourcePort = this.targetPort;
				this.targetPort = temp;
				return ConnectionType.PROVIDES_MAPPING;
			}
			if (this.sourcePort.Name == "OuterRequiresPort" && this.targetPort.Name == "OuterProvidesPort")
			{
				return ConnectionType.BINDING;
			}
			if (this.sourcePort.Name == "OuterProvidesPort" && this.targetPort.Name == "OuterRequiresPort")
			{
				temp = this.sourcePort;
				this.sourcePort = this.targetPort;
				this.targetPort = temp;
				return ConnectionType.BINDING;
			}
			if (this.sourcePort.Name == "OuterRequiresPort" && this.targetPort.Name == "InnerRequiresPort")
			{
				return ConnectionType.REQUIRES_MAPPING;
			}
			if (this.sourcePort.Name == "InnerRequiresPort" && this.targetPort.Name == "OuterRequiresPort")
			{
				temp = this.sourcePort;
				this.sourcePort = this.targetPort;
				this.targetPort = temp;
				return ConnectionType.REQUIRES_MAPPING;
			}
			return ConnectionType.INVALID;
		}


		private Symbols.ProvidesRole CreateProvidesRoleSymbol()
		{
			SymbolModel symModel = this.privatePaletteView.Palette.GetChildByName("Provides Role") as SymbolModel;
			Symbols.ProvidesRole symbol = symModel.CreateSymbol() as Symbols.ProvidesRole;

			symbol.EditStyle.AllowMove = false;
			symbol.EditStyle.AllowResize = false;
			symbol.Ports[0].Visible = false;
			symbol.Ports[0].EditStyle.AllowSelect = false;
			symbol.Ports[0].EditStyle.AllowMove = false;
			symbol.Ports[1].Visible = false;
			symbol.Ports[1].EditStyle.AllowSelect = false;
			symbol.Ports[1].EditStyle.AllowMove = false;

			return symbol;
		}

		private Symbols.RequiresRole CreateRequiresRoleSymbol()
		{
			SymbolModel symModel = this.privatePaletteView.Palette.GetChildByName("Requires Role") as SymbolModel;
			Symbols.RequiresRole symbol = symModel.CreateSymbol() as Symbols.RequiresRole;

			symbol.EditStyle.AllowMove = false;
			symbol.EditStyle.AllowResize = false;
			symbol.Ports[0].Visible = false;
			symbol.Ports[0].EditStyle.AllowSelect = false;
			symbol.Ports[0].EditStyle.AllowMove = false;
			symbol.Ports[1].Visible = false;
			symbol.Ports[1].EditStyle.AllowSelect = false;
			symbol.Ports[1].EditStyle.AllowMove = false;

			return symbol;
		}
	}

	public enum ConnectionType
	{
		BINDING,
		PROVIDES_MAPPING,
		REQUIRES_MAPPING,
		INVALID
	}
}

