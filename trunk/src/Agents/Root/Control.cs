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
using Palladio.Editor.Common.EntityProxies.UITypeEditors.Dialogs;
using Palladio.Editor.Core.Interfaces;
using Palladio.ComponentModel;

namespace Palladio.Editor.Core.Agents.Root
{
	/// <summary>
	/// The Control Component of the root PAC agent.
	/// </summary>
	/// <remarks>This Control Component handles all incoming 
	/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> events. 
	/// It executes commands and updates proxy objects accordingly. When it's done it raises the 
	/// <see cref="EntityChanged"/> event to inform registered agents (the PluginCoordinator) about the
	/// updated and changed proxies.</remarks>
	internal class Control : IRootAgent, IAbstractionAdapter, IPresentationAdapter
	{
		#region Fields
		/// <summary>
		/// log4net logging service</summary>
		private static readonly ILog log = LogManager.GetLogger(typeof(Control));

		/// <summary>
		/// A Facade for the Presentation Component of the Core PAC agent</summary>
		private Presentation.Facade _presentation;

		/// <summary>
		/// A Facade for the Abstraction Component of the Core PAC agent</summary>
		private Abstraction.Facade _abstraction;

		/// <summary>
		/// A child PAC agent responsible for plugin coordination</summary>
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

		/// <summary>
		/// Handler for <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> 
		/// events fired by a <see cref="Palladio.Editor.Common.EntityProxies.SignatureProxy"/></summary>
		private CommandHandler _signatureCmdHandler;

		/// <summary>
		/// Handler for <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> 
		/// events fired by connections</summary>
		private CommandHandler _connectionCmdHandler;

		/// <summary>
		/// A proxy-instance of the active component model</summary>
		private CompositeComponentProxy _modelProxy;
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
		/// <summary>
		/// Creates Presentation and Abstraction components and 
		/// instantiates the PluginCoordinator child agent.
		/// </summary>
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
			this._connectionCmdHandler = new CommandHandler(connectionCommandIssued);
		}
		#endregion

		#region IRootAgent Member
		/// <summary>
		/// Initializes the Core agent and all its child agents before starting up the GUI.
		/// </summary>
		public void Initialize()
		{
			log.Debug("Initializing Root.");

			// hook up to presentation and abstraction events
			this._presentation.NewComponentModelRequested      += new EventHandler(presentation_NewComponentModelRequested);
			this._presentation.OpenComponentModelRequested     += new FileEventHandler(presentation_OpenComponentModelRequested);
			this._presentation.SaveComponentModelAsRequested   += new FileEventHandler(presentation_SaveComponentModelAsRequested);
			this._presentation.SaveComponentModelRequested     += new EventHandler(presentation_SaveComponentModelRequested);
			this._presentation.PluginControlDialogRequested    += new EventHandler(presentation_PluginControlDialogRequested);
			this._presentation.AnalysesControlDialogRequested  += new StringEventHandler(presentation_AnalysesControlDialogRequested);
			this._presentation.ExitApplicationRequested        += new EventHandler(presentation_ExitApplicationRequested);
			this._presentation.UndoRequested				   += new EventHandler(presentation_UndoRequested);
			this._presentation.RedoRequested				   += new EventHandler(presentation_RedoRequested);
			this._abstraction.ComponentModelChanged            += new EventHandler(abstraction_ComponentModelChanged);

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
		/// Notifies the core agent of a newly attached plugin. 
		/// The results in the plugin being integrated in the GUI.
		/// </summary>
		/// <param name="plugin">The plugin being attached</param>
		public void PluginAttached(IPlugin plugin)
		{
			if (plugin is IViewPlugin)
			{
				this._presentation.AddView((IViewPlugin)plugin);
			}
			else if (plugin is IAnalyzePlugin)
			{
				this._presentation.AddAnalysis((IAnalyzePlugin)plugin);
			}

		}

		/// <summary>
		/// Notifies the core agent of a plugin that has been detached.
		/// This plugins controls will be removed from the GUI.
		/// </summary>
		/// <param name="pluginType">Plugin category</param>
		/// <param name="systemType">String representation of the System.Type of the plugin being removed.</param>
		public void PluginDetached(PluginType pluginType, string systemType)
		{
			if (pluginType == PluginType.VIEW)
			{
				this._presentation.RemoveView(systemType);
			}
		}

		/// <summary>
		/// Registers and stores an <see cref="Palladio.Editor.Common.AbstractAttributeType"/> in the
		/// Abstraction component to make it available to attributable elements.
		/// </summary>
		/// <param name="type">The attribute type to register.</param>
		public void RegisterAttributeType(AbstractAttributeType type)
		{
			this._abstraction.RegisterAttributeType(type);
		}

		public void NewAnalysisResult(UserControl result)
		{
			this._presentation.AddAnalysisResult(result);
		}
		#endregion

		#region IAbstractionAdapter Member
		/// <summary>
		/// The name of the file which is associated with the active component model and
		/// to which it is stored when calling the 'Save' routine.
		/// </summary>
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
		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void presentation_NewComponentModelRequested(object sender, System.EventArgs e)
		{
			this._abstraction.NewComponentModel();
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="fileInfo"></param>
		private void presentation_OpenComponentModelRequested(object sender, System.IO.FileInfo fileInfo)
		{
			this._abstraction.LoadComponentModel(fileInfo.FullName);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void presentation_SaveComponentModelRequested(object sender, System.EventArgs e)
		{
			this._abstraction.SaveComponentModel();
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="fileInfo"></param>
		private void presentation_SaveComponentModelAsRequested(object sender, System.IO.FileInfo fileInfo)
		{
			this._abstraction.SaveComponentModelAs(fileInfo.FullName);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void presentation_ExitApplicationRequested(object sender, System.EventArgs e)
		{
			Application.ExitThread();
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void presentation_PluginControlDialogRequested(object sender, System.EventArgs e)
		{
			this._pluginCoordinator.ShowPluginControlDialog();
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="type"></param>
		private void presentation_AnalysesControlDialogRequested(object sender, string type)
		{
			this._pluginCoordinator.ShowAnalysesControlDialog(type);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void presentation_UndoRequested(object sender, System.EventArgs e)
		{
			if (this._abstraction.UndoCount > 0)
			{
				ICommand cmd = this._abstraction.PopUndo();
				cmd.Undo();
				this._abstraction.PushRedo(cmd);

				if (this._abstraction.UndoCount == 0)
					this._presentation.CanUndo = false;

				this._presentation.CanRedo = true;

				EntityProxy proxy = null;
				if (cmd.Receiver is ICompositeComponent)
					proxy = Abstraction.ProxyFactory.CreateCompositeComponentProxy(
						cmd.Receiver as ICompositeComponent,
						this._componentCmdHandler,
						this._roleCmdHandler,
						this._interfaceCmdHandler,
						this._signatureCmdHandler,
						new AttributeProvider(this.GetRegisteredAttributeTypes));
				else if (cmd.Receiver is IBasicComponent)
					proxy = Abstraction.ProxyFactory.CreateBasicComponentProxy(
						cmd.Receiver as IBasicComponent,
						this._componentCmdHandler,
						this._roleCmdHandler,
						this._interfaceCmdHandler,
						this._signatureCmdHandler,
						new AttributeProvider(this.GetRegisteredAttributeTypes));
				else if (cmd.Receiver is IInterfaceModel)
					proxy = Abstraction.ProxyFactory.CreateInterfaceProxy(
						cmd.Receiver as IInterfaceModel,
						this._interfaceCmdHandler,
						this._signatureCmdHandler,
						new AttributeProvider(this.GetRegisteredAttributeTypes));
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

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void presentation_RedoRequested(object sender, System.EventArgs e)
		{
			if (this._abstraction.RedoCount > 0)
			{
				ICommand cmd = this._abstraction.PopRedo();
				cmd.Execute();
				this._abstraction.PushUndo(cmd);

				if (this._abstraction.RedoCount == 0)
					this._presentation.CanRedo = false;

				this._presentation.CanUndo = true;

				EntityProxy proxy = null;
				if (cmd.Receiver is ICompositeComponent)
					proxy = Abstraction.ProxyFactory.CreateCompositeComponentProxy(
						cmd.Receiver as ICompositeComponent,
						this._componentCmdHandler,
						this._roleCmdHandler,
						this._interfaceCmdHandler,
						this._signatureCmdHandler,
						new AttributeProvider(this.GetRegisteredAttributeTypes));
				else if (cmd.Receiver is IBasicComponent)
					proxy = Abstraction.ProxyFactory.CreateBasicComponentProxy(
						cmd.Receiver as IBasicComponent,
						this._componentCmdHandler,
						this._roleCmdHandler,
						this._interfaceCmdHandler,
						this._signatureCmdHandler,
						new AttributeProvider(this.GetRegisteredAttributeTypes));
				else if (cmd.Receiver is IInterfaceModel)
					proxy = Abstraction.ProxyFactory.CreateInterfaceProxy(
						cmd.Receiver as IInterfaceModel,
						this._interfaceCmdHandler,
						this._signatureCmdHandler,
						new AttributeProvider(this.GetRegisteredAttributeTypes));
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
		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void abstraction_ComponentModelChanged(object sender, System.EventArgs e)
		{
			log.Debug("ComponentModelChanged");	
			ICompositeComponent newModel = this._abstraction.ComponentModel;

			CompositeComponentProxy modelProxy = Abstraction.ProxyFactory.CreateCompositeComponentProxy(
				newModel,
				this._componentCmdHandler, 
				this._roleCmdHandler, 
				this._interfaceCmdHandler,
				this._signatureCmdHandler,
				new AttributeProvider(this.GetRegisteredAttributeTypes));

			this._presentation.SelectedObject = null;
			this._presentation.CanUndo = false;
			this._presentation.CanRedo = false;

			this._modelProxy = modelProxy;

			if (this.ComponentModelChanged != null)
				this.ComponentModelChanged(this, modelProxy);
		}
		#endregion

		#region Child Agents Event Handler
		/// <summary>
		/// 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="entity"></param>
		private void pluginCoordinator_SelectionChanged(object sender, EntityProxy entity)
		{
			// show properties of selected entity in the property control
			this._presentation.SelectedObject = entity;
		}
		#endregion

		#region CommandIssued EventHandler
		/// <summary>
		/// 
		/// </summary>
		/// <param name="source"></param>
		/// <param name="command"></param>
		private void componentCommandIssued(object source, ICommand command)
		{
			if ( ExecuteCommand( command ) )
			{
				switch(command.EventArgs.Reason)
				{
					case EntityChangeReason.PROVIDESINTERFACE_ADDED:
						IRole role = ((IComponent)command.Receiver).GetProvidesRoleByInterfaceID(command.EventArgs.AssociatedID);
						if (role != null)
						{
							RoleProxy roleProxy = Abstraction.ProxyFactory.CreateRoleProxy(role, source as ComponentProxy, this._roleCmdHandler, this._interfaceCmdHandler, this._signatureCmdHandler, new AttributeProvider(this.GetRegisteredAttributeTypes));
							((ComponentProxy)source).ProvidedRoles.Add(roleProxy);
						}
						break;

					case EntityChangeReason.REQUIRESINTERFACE_ADDED:
						role = ((IComponent)command.Receiver).GetRequiresRoleByInterfaceID(command.EventArgs.AssociatedID);
						if (role != null)
						{
							RoleProxy roleProxy = Abstraction.ProxyFactory.CreateRoleProxy(role, source as ComponentProxy, this._roleCmdHandler, this._interfaceCmdHandler, this._signatureCmdHandler, new AttributeProvider(this.GetRegisteredAttributeTypes));
							((ComponentProxy)source).RequiredRoles.Add(roleProxy);
						}
						break;

					case EntityChangeReason.COMPONENT_ADDED:
						FirstClassEntity newEntity = ModelPersistencyService.Instance.GetEntity(command.EventArgs.AssociatedID);
						if (newEntity is IBasicComponent)
						{
							BasicComponentProxy newComp = Abstraction.ProxyFactory.CreateBasicComponentProxy(
								newEntity as IBasicComponent, 
								this._componentCmdHandler,
								this._roleCmdHandler,
								this._interfaceCmdHandler,
								this._signatureCmdHandler,
								new AttributeProvider(this.GetRegisteredAttributeTypes));
							((CompositeComponentProxy)source).BasicComponents.Add(newComp);
						}
						else if (newEntity is ICompositeComponent)
						{
							CompositeComponentProxy newComp = Abstraction.ProxyFactory.CreateCompositeComponentProxy(
								newEntity as ICompositeComponent,
								this._componentCmdHandler,
								this._roleCmdHandler,
								this._interfaceCmdHandler,
								this._signatureCmdHandler,
								new AttributeProvider(this.GetRegisteredAttributeTypes));
							((CompositeComponentProxy)source).CompositeComponents.Add(newComp);
						}
						break;

					case EntityChangeReason.COMPONENT_REMOVED:
						ComponentProxy deleted = ((CompositeComponentProxy)source).GetComponentByID(command.EventArgs.AssociatedID);
						if (deleted is CompositeComponentProxy)
							((CompositeComponentProxy)source).CompositeComponents.Remove(deleted as CompositeComponentProxy);
						else if (deleted is BasicComponentProxy)
							((CompositeComponentProxy)source).BasicComponents.Remove(deleted as BasicComponentProxy);
						break;

					case EntityChangeReason.BINDING_ADDED:
						foreach (IBinding binding in ((ICompositeComponent)command.Receiver).Bindings)
						{
							if (binding.ID.Equals(command.EventArgs.AssociatedID))
							{
								RoleProxy prov = ((CompositeComponentProxy)source).GetProvidesRoleByInterfaceID(binding.ProvidingRole.Interface.ID);
								RoleProxy req = ((CompositeComponentProxy)source).GetComponentByID(binding.RequiringRole.Component.ID).GetRequiresRoleByInterfaceID(binding.RequiringRole.Interface.ID);

								BindingProxy newBinding = Abstraction.ProxyFactory.CreateBindingProxy(binding, prov, req, this._connectionCmdHandler, new AttributeProvider(this.GetRegisteredAttributeTypes));
								((CompositeComponentProxy)source).Bindings.Add(newBinding);

								prov.AttachedConnection = newBinding;
								req.AttachedConnection = newBinding;
								break;
							}
						}
						break;

					case EntityChangeReason.PROVIDESMAPPING_ADDED:
						foreach (IMapping mapping in ((ICompositeComponent)command.Receiver).ProvidesMappings)
						{
							if (mapping.ID.Equals(command.EventArgs.AssociatedID))
							{
								RoleProxy outer = ((CompositeComponentProxy)source).GetProvidesRoleByInterfaceID(mapping.OuterRole.Interface.ID);
								RoleProxy inner = ((CompositeComponentProxy)source).GetComponentByID(mapping.InnerRole.Component.ID).GetProvidesRoleByInterfaceID(mapping.InnerRole.Interface.ID);

								ProvidesMappingProxy newMapping = Abstraction.ProxyFactory.CreateProvidesMappingProxy(mapping, inner, outer, this._connectionCmdHandler, new AttributeProvider(this.GetRegisteredAttributeTypes));
								((CompositeComponentProxy)source).ProvidesMappings.Add(newMapping);

								inner.AttachedConnection = newMapping;
								outer.InnerMapping = newMapping;
								break;
							}
						}
						break;

					case EntityChangeReason.REQUIRESMAPPING_ADDED:
						foreach (IMapping mapping in ((ICompositeComponent)command.Receiver).RequiresMappings)
						{
							if (mapping.ID.Equals(command.EventArgs.AssociatedID))
							{
								RoleProxy outer = ((CompositeComponentProxy)source).GetRequiresRoleByInterfaceID(mapping.OuterRole.Interface.ID);
								RoleProxy inner = ((CompositeComponentProxy)source).GetComponentByID(mapping.InnerRole.Component.ID).GetRequiresRoleByInterfaceID(mapping.InnerRole.Interface.ID);

								RequiresMappingProxy newMapping = Abstraction.ProxyFactory.CreateRequiresMappingProxy(mapping, inner, outer, this._connectionCmdHandler, new AttributeProvider(this.GetRegisteredAttributeTypes));
								((CompositeComponentProxy)source).RequiresMappings.Add(newMapping);

								inner.AttachedConnection = newMapping;
								outer.InnerMapping = newMapping;
								break;
							}
						}
						break;

					case EntityChangeReason.SERVICEEFFECTSPECS_CHANGED:
						IBasicComponent comp = command.Receiver as IBasicComponent;
						((BasicComponentProxy)source).ServiceEffects.Clear();
						foreach (IService service in comp.GetServicesWithServiceEffectSpecification())
						{
							IServiceEffectSpecification spec = comp.GetServiceEffectSpecification(service);
							ServiceEffectSpecificationProxy specProxy = Abstraction.ProxyFactory.CreateServiceEffectSpecificationProxy(
								spec,
								source as BasicComponentProxy,
								service,
								this._componentCmdHandler,
								new AttributeProvider(this.GetRegisteredAttributeTypes));
							((BasicComponentProxy)source).ServiceEffects.Add(specProxy);
						}
						break;
					case EntityChangeReason.SERVICE_IN_SEFFSPEC_ADDED:
						//IServiceEffectSpecification sef = command.Receiver as IServiceEffectSpecification;
						((ServiceEffectSpecificationProxy)source).ServiceList.Add(((AddServiceToServiceEffectCmd)command).SignatureProxy);
						break;
				}

				this.EntityChanged(this, source as EntityProxy, command.EventArgs);

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
			if ( ExecuteCommand( command ) )
			{
				this.EntityChanged(this, source as RoleProxy, command.EventArgs);
			}
		}

		/// <summary>
		/// Handler routine for <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> events
		/// by an <see cref="Palladio.Editor.Common.EntityProxies.InterfaceProxy"/>.
		/// </summary>
		private void interfaceCommandIssued(object source, ICommand command)
		{
			if ( ExecuteCommand( command ) )
			{
				if (command.EventArgs.Reason == EntityChangeReason.SIGNATURE_ADDED)
				{
					ISignature sig = ((IInterfaceModel)command.Receiver).SignatureList.GetSignaturesByID(command.EventArgs.AssociatedID)[0];
					SignatureProxy sigProxy =  Abstraction.ProxyFactory.CreateSignatureProxy(sig, (InterfaceProxy)source, this._signatureCmdHandler, new AttributeProvider(this.GetRegisteredAttributeTypes));

					((InterfaceProxy)source).Signatures.Add(sigProxy);
				}
				else if (command.EventArgs.Reason == EntityChangeReason.SIGNATURE_REMOVED)
				{
					((InterfaceProxy)source).Signatures.Remove(((InterfaceProxy)source).GetSignatureByID(command.EventArgs.AssociatedID));
				}
				this.EntityChanged(this, source as EntityProxy, command.EventArgs);
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="source"></param>
		/// <param name="command"></param>
		private void signatureCommandIssued(object source, ICommand command)
		{
			if ( ExecuteCommand( command ) )
			{
				this._presentation.SelectedObject = ((SignatureProxy)source).Interface.GetSignatureByID(((ISignature)command.Receiver).ID);
				this.EntityChanged(
					this, 
					((SignatureProxy)source).Interface, 
					new Palladio.Editor.Common.EntityProxies.EventArgs(
					EntityChangeReason.UNSPECIFIED,
					((ISignature)command.Receiver).ID
					) );

				EntityProxyCollectionFormRegistrar.UpdateProxyInForm(((SignatureProxy)source).Interface, ((SignatureProxy)source).Interface);
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="source"></param>
		/// <param name="command"></param>
		private void connectionCommandIssued(object source, ICommand command)
		{

		}

		/// <summary>
		/// Executes a command and pushes it onto the undo stack.
		/// </summary>
		/// <param name="command">The command to execute.</param>
		/// <returns>True if command execution was succesful.</returns>
		private bool ExecuteCommand(ICommand command)
		{
			if ( command.Execute() )
			{
				log.Debug(command.EventArgs.Reason.ToString());

				if (command.CanUndo)
					this._abstraction.PushUndo(command);
				else
					this._abstraction.ClearUndo();
				this._presentation.CanUndo = command.CanUndo;

				this._abstraction.ClearRedo();
				this._presentation.CanRedo = false;

				return true;
			}
			return false;
		}
		#endregion

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		private AbstractAttributeType[] GetRegisteredAttributeTypes()
		{
			return this._abstraction.GetRegisteredAttributeTypes();
		}
	}
}
