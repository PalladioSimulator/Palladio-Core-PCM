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
using System.Windows.Forms;
using log4net;

using Palladio.Editor.Core;
using Palladio.Editor.Common;
using Palladio.Editor.Common.Commands;
using Palladio.Editor.Common.EntityProxies;
using Palladio.Editor.Core.Interfaces;
using Palladio.ComponentModel;

namespace Palladio.Editor.Core.Agents.Root
{
	/// <summary>
	/// The Control Component of the root PAC agent
	/// </summary>
	internal class Control : IRootAgent, IAbstractionAdapter, IPresentationAdapter
	{
		#region Fields
		private static readonly ILog log = LogManager.GetLogger(typeof(Control));

		/// <summary>
		/// A Facade for the Presentation Component of the Core PAC agent</summary>
		private Presentation.Facade _presentation;

		/// <summary>
		/// A Facade for the Abstraction Component of the Core PAC agent</summary>
		private Abstraction.Facade _abstraction;

		/// <summary>
		/// A child PAC agent responsible of Plugin coordination</summary>
		private Interfaces.IPluginCoordinator _pluginCoordinator;

		/// <summary>
		/// Handler for <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> 
		/// events fired by a <see cref="Palladio.Editor.Common.EntityProxies.ComponentProxy"/></summary>
		private CommandHandler _componentCmdHandler;

		/// <summary>
		/// Handler for <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> 
		/// events fired by a <see cref="Palladio.Editor.Common.EntityProxies.RoleProxy"/></summary>
		private CommandHandler _roleCmdHandler;

		/// <summary>
		/// Handler for <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> 
		/// events fired by a <see cref="Palladio.Editor.Common.EntityProxies.InterfaceProxy"/></summary>
		private CommandHandler _interfaceCmdHandler;

		private CommandHandler _signatureCmdHandler;

		/// <summary>
		/// Holds an instance of the proxy for the active component model</summary>
		private CompositeComponentProxy _modelProxy;

		/// <summary>
		/// Command stack holding undoable ICommands</summary>
		private CommandStack _undoCmdStack;

		/// <summary>
		/// Command stack holding redoable ICommands</summary>
		private CommandStack _redoCmdStack;
		#endregion

		#region Public Events
		/// <summary>
		/// Fired when the active component model has changed entirely.</summary>
		public event ComponentModelChangedHandler ComponentModelChanged;

		/// <summary>
		/// Fired when changes occur within the active component model.</summary>
		public event EntityChangedHandler EntityChanged;
		#endregion

		#region Constructors
		public Control()
		{
			// create presentation and abstraction components
			this._presentation = new Presentation.Facade(this);
			this._abstraction = new Abstraction.Facade(this);

			// create child agent
			this._pluginCoordinator = AgentFactory.CreatePluginCoordinator(this);

			// create EventHandler
			this._componentCmdHandler = new CommandHandler(componentCommandIssued);
			this._roleCmdHandler = new CommandHandler(roleCommandIssued);
			this._interfaceCmdHandler = new CommandHandler(interfaceCommandIssued);
			this._signatureCmdHandler = new CommandHandler(signatureCommandIssued);

			this._undoCmdStack = new CommandStack();
			this._redoCmdStack = new CommandStack();
		}
		#endregion

		#region ICoreAgent Member
		/// <summary>
		/// Initializes the Core agent and all its child agents before starting up the GUI.
		/// </summary>
		public void Initialize()
		{
			log.Debug("Initializing Core.");

			// hook up to presentation and abstraction events
			this._presentation.NewComponentModelRequested    += new EventHandler(presentation_NewComponentModelRequested);
			this._presentation.OpenComponentModelRequested   += new FileEventHandler(presentation_OpenComponentModelRequested);
			this._presentation.SaveComponentModelAsRequested += new FileEventHandler(presentation_SaveComponentModelAsRequested);
			this._presentation.SaveComponentModelRequested   += new EventHandler(presentation_SaveComponentModelRequested);
			this._presentation.PluginControlDialogRequested  += new EventHandler(presentation_PluginControlDialogRequested);
			this._presentation.ExitApplicationRequested      += new EventHandler(presentation_ExitApplicationRequested);
			this._presentation.UndoRequested				 += new EventHandler(presentation_UndoRequested);
			this._presentation.RedoRequested				 += new EventHandler(presentation_RedoRequested);
			this._abstraction.ComponentModelChanged          += new EventHandler(abstraction_ComponentModelChanged);

			// create a new model
			this._abstraction.NewComponentModel();

			// initialize child agent
			this._pluginCoordinator.Initialize();

			// hook up to child agent events
			this._pluginCoordinator.SelectionChanged += new SelectionChangedHandler(pluginCoordinator_SelectionChanged);

			// show GUI
			this._presentation.Show();
		}

		/// <summary>
		/// Returns a proxy object for the active component model.
		/// </summary>
		/// <returns>A proxy object for the active component model.</returns>
		public CompositeComponentProxy GetComponentModel()
		{
			return this._modelProxy;
		}

		/// <summary>
		/// Notifies the core agent of a newly attached plugin
		/// </summary>
		/// <param name="plugin">The plugin being attached</param>
		public void PluginAttached(IPlugin plugin)
		{
			if (plugin is IViewPlugin)
			{
				this._presentation.AddView((IViewPlugin)plugin);
			}
		}

		public void PluginDetached(PluginType pluginType, string systemType)
		{
			if (pluginType == PluginType.VIEW)
			{
				this._presentation.RemoveView(systemType);
			}
		}
		#endregion

		#region IDataProvider Member
		public string ModelFileName
		{
			get
			{
				return this._abstraction.ModelFileName;
			}
			set
			{
				this._abstraction.ModelFileName = value;
			}
		}
		#endregion

		#region Presentation Event Handler
		private void presentation_NewComponentModelRequested(object sender, System.EventArgs e)
		{
			this._abstraction.NewComponentModel();
		}

		private void presentation_OpenComponentModelRequested(object sender, System.IO.FileInfo fileInfo)
		{
			this._abstraction.LoadComponentModel(fileInfo.FullName);
		}

		private void presentation_SaveComponentModelRequested(object sender, System.EventArgs e)
		{
			this._abstraction.SaveComponentModel();
		}

		private void presentation_SaveComponentModelAsRequested(object sender, System.IO.FileInfo fileInfo)
		{
			this._abstraction.SaveComponentModelAs(fileInfo.FullName);
		}

		private void presentation_ExitApplicationRequested(object sender, System.EventArgs e)
		{
			Application.ExitThread();
		}

		private void presentation_PluginControlDialogRequested(object sender, System.EventArgs e)
		{
			this._pluginCoordinator.ShowPluginControlDialog();
		}

		private void presentation_UndoRequested(object sender, System.EventArgs e)
		{
			if (this._undoCmdStack.Count > 0)
			{
				ICommand cmd = this._undoCmdStack.Pop();
				cmd.Undo();
				this._redoCmdStack.Push(cmd);

				if (this._undoCmdStack.Count == 0)
					this._presentation.CanUndo = false;

				this._presentation.CanRedo = true;

				EntityProxy proxy = null;
				if (cmd.Receiver is ICompositeComponent)
					proxy = Abstraction.ProxyFactory.CreateCompositeComponentProxy(
						cmd.Receiver as ICompositeComponent,
						this._componentCmdHandler,
						this._roleCmdHandler,
						this._interfaceCmdHandler,
						this._signatureCmdHandler );
				else if (cmd.Receiver is IBasicComponent)
					proxy = Abstraction.ProxyFactory.CreateBasicComponentProxy(
						cmd.Receiver as IBasicComponent,
						this._componentCmdHandler,
						this._roleCmdHandler,
						this._interfaceCmdHandler,
						this._signatureCmdHandler );
				else if (cmd.Receiver is IInterfaceModel)
					proxy = Abstraction.ProxyFactory.CreateInterfaceProxy(
						cmd.Receiver as IInterfaceModel,
						this._interfaceCmdHandler,
						this._signatureCmdHandler );
				else if (cmd.Receiver is ISignature)
				{
					proxy = ((ChangeSignatureCmd)cmd).Interface;
					this._presentation.SelectedObject = proxy;
				}


				if ((this._presentation.SelectedObject != null) && ((EntityProxy)this._presentation.SelectedObject).ID.Equals(proxy.ID))
					this._presentation.SelectedObject = proxy;

				if (this.EntityChanged != null)
					this.EntityChanged(this, proxy, cmd.EventArgs);
			}
		}

		private void presentation_RedoRequested(object sender, System.EventArgs e)
		{
			if (this._redoCmdStack.Count > 0)
			{
				ICommand cmd = this._redoCmdStack.Pop();
				cmd.Execute();
				this._undoCmdStack.Push(cmd);

				if (this._redoCmdStack.Count == 0)
					this._presentation.CanRedo = false;

				this._presentation.CanUndo = true;

				EntityProxy proxy = null;
				if (cmd.Receiver is ICompositeComponent)
					proxy = Abstraction.ProxyFactory.CreateCompositeComponentProxy(
						cmd.Receiver as ICompositeComponent,
						this._componentCmdHandler,
						this._roleCmdHandler,
						this._interfaceCmdHandler,
						this._signatureCmdHandler );
				else if (cmd.Receiver is IBasicComponent)
					proxy = Abstraction.ProxyFactory.CreateBasicComponentProxy(
						cmd.Receiver as IBasicComponent,
						this._componentCmdHandler,
						this._roleCmdHandler,
						this._interfaceCmdHandler,
						this._signatureCmdHandler );
				else if (cmd.Receiver is IInterfaceModel)
					proxy = Abstraction.ProxyFactory.CreateInterfaceProxy(
						cmd.Receiver as IInterfaceModel,
						this._interfaceCmdHandler,
						this._signatureCmdHandler );
				else if (cmd.Receiver is ISignature)
				{
					proxy = ((ChangeSignatureCmd)cmd).Interface;
					this._presentation.SelectedObject = proxy;
				}

				if ((this._presentation.SelectedObject != null) && ((EntityProxy)this._presentation.SelectedObject).ID.Equals(proxy.ID))
					this._presentation.SelectedObject = proxy;

				if (this.EntityChanged != null)
					this.EntityChanged(this, proxy, cmd.EventArgs);
			}
		}
		#endregion

		#region Abstraction Event Handler
		private void abstraction_ComponentModelChanged(object sender, System.EventArgs e)
		{
			log.Debug("ComponentModelChanged");	
			ICompositeComponent newModel = this._abstraction.ComponentModel;

			CompositeComponentProxy modelProxy = Abstraction.ProxyFactory.CreateCompositeComponentProxy(
				newModel,
				this._componentCmdHandler, 
				this._roleCmdHandler, 
				this._interfaceCmdHandler,
				this._signatureCmdHandler );

			this._presentation.SelectedObject = null;
			this._presentation.CanUndo = false;
			this._presentation.CanRedo = false;

			//modelProxy.EntityChanged += new EntityChangedHandler(this._componentChangedHandler);

			this._modelProxy = modelProxy;

			if (this.ComponentModelChanged != null)
				this.ComponentModelChanged(this, modelProxy);
		}
		#endregion

		#region Child Agents Event Handler
		private void pluginCoordinator_SelectionChanged(object sender, EntityProxy entity)
		{
			// show properties of selected entity in the property control
			this._presentation.SelectedObject = entity;
		}
		#endregion

		#region EntityChanged EventHandler
		private void componentCommandIssued(object source, ICommand command)
		{
			if ( ExecuteCommand( command ) )
			{
				// provides interface added
				if (command.EventArgs.Reason == EntityChangeReason.PROVIDESINTERFACE_ADDED)
				{
					IRole role = ((IComponent)command.Receiver).GetProvidesRoleByInterfaceID(command.EventArgs.AssociatedID);
					if (role != null)
					{
						RoleProxy roleProxy = Abstraction.ProxyFactory.CreateRoleProxy(role, source as ComponentProxy, this._roleCmdHandler, this._interfaceCmdHandler, this._signatureCmdHandler);
						((ComponentProxy)source).ProvidedRoles.Add(roleProxy);
					}
				}
				// requires interface added
				else if (command.EventArgs.Reason == EntityChangeReason.REQUIRESINTERFACE_ADDED)
				{
					IRole role = ((IComponent)command.Receiver).GetRequiresRoleByInterfaceID(command.EventArgs.AssociatedID);
					if (role != null)
					{
						RoleProxy roleProxy = Abstraction.ProxyFactory.CreateRoleProxy(role, source as ComponentProxy, this._roleCmdHandler, this._interfaceCmdHandler, this._signatureCmdHandler);
						((ComponentProxy)source).RequiredRoles.Add(roleProxy);
					}
				}
				else if (command.EventArgs.Reason == EntityChangeReason.COMPONENT_ADDED)
				{
					ComponentProxy newComp = null;
					FirstClassEntity newEntity = ModelPersistencyService.Instance.GetEntity(command.EventArgs.AssociatedID);
					if (newEntity is IBasicComponent)
					{
						newComp = Abstraction.ProxyFactory.CreateBasicComponentProxy(newEntity as IBasicComponent, 
							this._componentCmdHandler,
							this._roleCmdHandler,
							this._interfaceCmdHandler,
							this._signatureCmdHandler );
						((CompositeComponentProxy)source).BasicComponents.Add(newComp as BasicComponentProxy);
					}
					else if (newEntity is ICompositeComponent)
					{
						newComp = Abstraction.ProxyFactory.CreateCompositeComponentProxy(newEntity as ICompositeComponent,
							this._componentCmdHandler,
							this._roleCmdHandler,
							this._interfaceCmdHandler,
							this._signatureCmdHandler );
						((CompositeComponentProxy)source).CompositeComponents.Add(newComp as CompositeComponentProxy);
					}
				}

				this.EntityChanged(this, source as ComponentProxy, command.EventArgs);
			}
		}

		/// <summary>
		/// Handler routine for <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> events
		/// fired by a <see cref="Palladio.Editor.Common.EntityProxies.RoleProxy"/>.
		/// </summary>
		/// <param name="source"></param>
		/// <param name="command"></param>
		private void roleCommandIssued(object source, ICommand command)
		{
//			Palladio.Editor.Common.EntityProxies.EventArgs evtArgs = new Palladio.Editor.Common.EntityProxies.EventArgs(
//				EntityChangeReason.ROLEPROPERTY_CHANGED, ((RoleProxy)proxy).ID);
//			this.EntityChanged(this, ((RoleProxy)proxy).Component, evtArgs);
		}

		/// <summary>
		/// Handler routine for <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> events
		/// by an <see cref="Palladio.Editor.Common.EntityProxies.InterfaceProxy"/>.
		/// </summary>
		private void interfaceCommandIssued(object source, ICommand command)
		{
			if ( ExecuteCommand( command) )
			{
				Console.WriteLine("ok4");
				if (command.EventArgs.Reason == EntityChangeReason.SIGNATURE_ADDED)
				{
					ISignature sig = ((IInterfaceModel)command.Receiver).SignatureList.GetSignaturesByID(command.EventArgs.AssociatedID)[0];
					SignatureProxy sigProxy =  Abstraction.ProxyFactory.CreateSignatureProxy(sig, (InterfaceProxy)source, this._signatureCmdHandler);

					((InterfaceProxy)source).Signatures.Add(sigProxy);
				}
				else if (command.EventArgs.Reason == EntityChangeReason.SIGNATURE_REMOVED)
				{
					((InterfaceProxy)source).Signatures.Remove(((InterfaceProxy)source).GetSignatureByID(command.EventArgs.AssociatedID));
				}
				this.EntityChanged(this, source as EntityProxy, command.EventArgs);
			}
		}

		private void signatureCommandIssued(object source, ICommand command)
		{
			if ( ExecuteCommand( command) )
			{
				Console.WriteLine("ok5");
				this._presentation.SelectedObject = ((SignatureProxy)source).Interface.GetSignatureByID(((ISignature)command.Receiver).ID);
				this.EntityChanged(
					this, 
					((SignatureProxy)source).Interface, 
					new Palladio.Editor.Common.EntityProxies.EventArgs(
						EntityChangeReason.UNSPECIFIED,
						((ISignature)command.Receiver).ID
					) );
			}
		}

		private bool ExecuteCommand(ICommand command)
		{
			if ( command.Execute() )
			{
				log.Debug(command.EventArgs.Reason.ToString());

				if (command.CanUndo)
					this._undoCmdStack.Push(command);
				else
					this._undoCmdStack.Clear();
				this._presentation.CanUndo = command.CanUndo;

				this._redoCmdStack.Clear();
				this._presentation.CanRedo = false;

				return true;
			}
			return false;
		}
		#endregion
	}
}
