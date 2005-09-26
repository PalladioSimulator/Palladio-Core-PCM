using Palladio.Attributes;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelEventManagement
{
	#region event delegates 
	
	/// <summary>
	/// defines the eventhandler, that is called, when an interface has been created or destroyed.
	/// </summary>
	public delegate void InterfaceBuildEventHandler(object sender, InterfaceBuildEventArgs args);

	/// <summary>
	/// defines the eventhandler, that is called, when an interface has been added or removed.
	/// </summary>
	public delegate void InterfaceUseEventHandler(object sender, InterfaceUseEventArgs args);
	
	/// <summary>
	/// defines the eventhandler, that is called, when an component has been created or destroyed.
	/// </summary>
	public delegate void ComponentBuildEventHandler(object sender, ComponentBuildEventArgs args);

	/// <summary>
	/// defines the eventhandler, that is called, when an component has been added or removed.
	/// </summary>
	public delegate void ComponentUseEventHandler(object sender, ComponentUseEventArgs args);

	/// <summary>
	/// defines the eventhandler, that is called, when an assembly connector has been added or removed.
	/// </summary>
	public delegate void AssemblyConnectorBuildEventHandler(object sender, AssemblyConnectorBuildEventArgs args);

	/// <summary>
	/// defines the eventhandler, that is called, when a onnector has been removed.
	/// </summary>
	public delegate void ConnectorRemovedEventHandler(object sender, ConnectorRemovedEventArgs args);
	
	/// <summary>
	/// defines the eventhandler, that is called, when an attribute in the attribute hashtable has been changed
	/// </summary>
	public delegate void AttributeChangedEventHandler(object sender, AttributeChangedEventArgs args);

	/// <summary>
	/// defines the eventhandler, that is called, when the name of the entity has been changed
	/// </summary>
	public delegate void StaticAttributeChangedEventHandler(object sender);
	
	/// <summary>
	/// defines the eventhandler, that is called, when a delegates connector has been added to or removed from a 
	/// composite component
	/// </summary>
	public delegate void DelegationConnectorBuildEventHandler(object sender, DelegationConnectorBuildEventArgs args);
	
	/// <summary>
	/// defines the eventhandler, that is called, when a signature has been added to or removed from an interface 
	/// </summary>
	public delegate void SignatureBuildEventHandler(object sender, SignatureBuildEventArgs args);

	/// <summary>
	/// defines the eventhandler, that is called, when a protocol has been added to or removed from an interface 
	/// </summary>
	public delegate void ProtocolBuildEventHandler(object sender, ProtocolBuildEventArgs args);

	/// <summary>
	/// defines the eventhandler, that is called, when a seff has been added to or removed from a component
	/// </summary>
	public delegate void SeffBuildEventHandler(object sender, SeffBuildEventArgs args);

	#endregion

	#region eventargs

	/// <summary>
	/// This is the event argument structure of the InterfaceBuildEventHandler.
	/// </summary>
	public class InterfaceBuildEventArgs
	{
		//the the interface
		private IInterface iface;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="iface">the interface</param>
		internal InterfaceBuildEventArgs(IInterface iface)
		{
			this.iface = iface;
		}

		/// <summary>
		/// returns the interface that has been added or removed
		/// </summary>
		public IInterface Interface
		{
			get
			{
				return this.iface;
			}
		}
	}

	/// <summary>
	/// This is the event argument structure of the InterfaceAddedEventHandler.
	/// </summary>
	public class InterfaceUseEventArgs
	{
		//the the interface
		private IInterfaceIdentifier ifaceID;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="ifaceID">the interface</param>
		internal InterfaceUseEventArgs(IInterfaceIdentifier ifaceID)
		{
			this.ifaceID = ifaceID;
		}

		/// <summary>
		/// returns the id of the interface that has been added or removed
		/// </summary>
		public IInterfaceIdentifier InterfaceID
		{
			get
			{
				return this.ifaceID;
			}
		}
	}

	/// <summary>
	/// This is the event argument structure of the ComponentBuildEventHandler.
	/// </summary>
	public class ComponentBuildEventArgs
	{
		//the component 
		private IComponent component;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="comp">the component</param>
		internal ComponentBuildEventArgs(IComponent comp)
		{
			this.component = comp;
		}

		/// <summary>
		/// returns the component that has been added or removed
		/// </summary>
		public IComponent Component
		{
			get
			{
				return this.component;
			}
		}
	}

	/// <summary>
	/// This is the event argument structure of the ComponentBuildEventHandler.
	/// </summary>
	public class ComponentUseEventArgs
	{
		//the component 
		private IComponentIdentifier componentID;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="compID">the id of the component</param>
		internal ComponentUseEventArgs(IComponentIdentifier compID)
		{
			this.componentID = compID;
		}

		/// <summary>
		/// returns the component that has been added or removed
		/// </summary>
		public IComponentIdentifier ComponentID
		{
			get
			{
				return this.componentID;
			}
		}
	}

	/// <summary>
	/// This is the event argument structure of the ConnectorRemovedEventHandler
	/// </summary>
	public class ConnectorRemovedEventArgs
	{
		//the connection
		private IConnection connection;

		//the requiring iface
		private IInterfaceIdentifier providingIfaceId;

		//the providing iface
		private IInterfaceIdentifier requiringIfaceId;

		//the providing component
		private IComponentIdentifier providingComponentId;

		//the requiring component
		private IComponentIdentifier requiringComponentId;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="con">the connection</param>
		/// <param name="provCompId">the id of the providing component</param>
		/// <param name="provIfaceId">the id of the providing interface</param>
		/// <param name="reqCompId">the id of the requiring component</param>
		/// <param name="reqIfaceId">the id of the requiring interface</param>
		internal ConnectorRemovedEventArgs(IConnection con, IComponentIdentifier provCompId,IInterfaceIdentifier provIfaceId,
			IComponentIdentifier reqCompId,IInterfaceIdentifier reqIfaceId)
		{
			this.connection = con;
			this.providingIfaceId = provIfaceId;
			this.requiringIfaceId = reqIfaceId;
			this.providingComponentId = provCompId;
			this.requiringComponentId = reqCompId;
		}

		/// <summary>
		/// returns the connection that has been removed
		/// </summary>
		public IConnection Connection
		{
			get
			{
				return this.connection;
			}
		}

		/// <summary>
		/// returns the id of the providing interface
		/// </summary>
		public IInterfaceIdentifier ProvidingIfaceId
		{
			get { return providingIfaceId; }
		}

		/// <summary>
		/// returns the id of the requiring interface
		/// </summary>
		public IInterfaceIdentifier RequiringIfaceId
		{
			get { return requiringIfaceId; }
		}

		/// <summary>
		/// returns the id of the providing component
		/// </summary>
		public IComponentIdentifier ProvidingComponentId
		{
			get { return providingComponentId; }
		}

		/// <summary>
		/// returns the id of the requiring component
		/// </summary>
		public IComponentIdentifier RequiringComponentId
		{
			get { return requiringComponentId; }
		}
	}

	/// <summary>
	/// This is the event argument structure of the AssemblyConnectorBuildEventHandler.
	/// </summary>
	public class AssemblyConnectorBuildEventArgs
	{
		//the connection
		private IConnection connection;

		//the id of the requiring component
		private IComponentIdentifier reqCompID;

		//the id of the requiring components interface
		private IInterfaceIdentifier reqIFaceID;

		//the id of the providing component
		private IComponentIdentifier provCompID;

		//the id of the providing components interface
		private IInterfaceIdentifier provIFaceID;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="con">the connection</param>
		/// <param name="provCompID">the id of the providing component</param>
		/// <param name="provIFaceID">the id of the providing components interface</param>
		/// <param name="reqCompID">the id of the requiring component</param>
		/// <param name="reqIFaceID">the id of the requiring components interface</param>
		internal AssemblyConnectorBuildEventArgs(IConnection con,IComponentIdentifier provCompID,IInterfaceIdentifier provIFaceID,
			IComponentIdentifier reqCompID,IInterfaceIdentifier reqIFaceID)
		{
			this.connection = con;
			this.provCompID = provCompID;
			this.reqCompID = reqCompID;
			this.provIFaceID = provIFaceID;
			this.reqIFaceID = reqIFaceID;
		}

		/// <summary>
		/// returns the assemby connector that has been added or removed
		/// </summary>
		public IConnection AssemblyConnector
		{
			get
			{
				return this.connection;
			}
		}

		/// <summary>
		/// returns the id of the requiring component
		/// </summary>
		public IComponentIdentifier ReqCompId
		{
			get { return reqCompID; }
		}

		/// <summary>
		/// returns the id of the requiring components interface
		/// </summary>
		public IInterfaceIdentifier ReqIFaceId
		{
			get { return reqIFaceID; }
		}

		/// <summary>
		/// returns the id of the providing component
		/// </summary>
		public IComponentIdentifier ProvCompId
		{
			get { return provCompID; }
		}

		/// <summary>
		/// returns the id of the providing components interface
		/// </summary>
		public IInterfaceIdentifier ProvIFaceId
		{
			get { return provIFaceID; }
		}
	}

	/// <summary>
	/// This is the event argument structure of the DelegationConnectorBuildEventHandler.
	/// </summary>
	public class DelegationConnectorBuildEventArgs
	{
		//the connection
		private IConnection connection;

		//the id of the inner component
		private IComponentIdentifier innerCompID;

		//the id of the inner components interface
		private IInterfaceIdentifier innerIFaceID;

		//the id of the outer component
		private IComponentIdentifier outerCompID;

		//the id of the outer components interface
		private IInterfaceIdentifier outerIFaceID;

		//the role of the interface
		private InterfaceRole role;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="con">the connection</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the outer components interface</param>
		/// <param name="role">the role of the connector</param>
		internal DelegationConnectorBuildEventArgs(IConnection con,IComponentIdentifier innerCompID,IInterfaceIdentifier innerIFaceID,
			IComponentIdentifier outerCompID,IInterfaceIdentifier outerIFaceID, InterfaceRole role)
		{
			this.connection = con;
			this.innerCompID = innerCompID;
			this.outerCompID = outerCompID;
			this.innerIFaceID = innerIFaceID;
			this.outerIFaceID = outerIFaceID;
			this.role = role;
		}

		/// <summary>
		/// returns the delegation connector
		/// </summary>
		public IConnection Connection
		{
			get { return connection; }
		}

		/// <summary>
		/// returns the id of the inner component
		/// </summary>
		public IComponentIdentifier InnerCompId
		{
			get { return innerCompID; }
		}

		/// <summary>
		/// returns the id of the inner components interface
		/// </summary>
		public IInterfaceIdentifier InnerIFaceId
		{
			get { return innerIFaceID; }
		}

		/// <summary>
		/// returns the id of the outer component
		/// </summary>
		public IComponentIdentifier OuterCompId
		{
			get { return outerCompID; }
		}

		/// <summary>
		/// returns the id of the outer components interface
		/// </summary>
		public IInterfaceIdentifier OuterIFaceId
		{
			get { return outerIFaceID; }
		}

		/// <summary>
		/// returns the role of the connector
		/// </summary>
		public InterfaceRole Role
		{
			get { return role; }
		}
	}

	/// <summary>
	/// This is the event argument structure of the SignatureBuildEventHandler.
	/// </summary>
	public class SignatureBuildEventArgs
	{
		//the signature
		private ISignature signature;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="sig">the signature</param>
		internal SignatureBuildEventArgs(ISignature sig)
		{
			this.signature = sig;
		}

		/// <summary>
		/// returns the signature that has been added or removed
		/// </summary>
		public ISignature Signature
		{
			get
			{
				return this.signature;
			}
		}
	}

	/// <summary>
	/// This is the event argument structure of the ProtocolBuildEventHandler.
	/// </summary>
	public class ProtocolBuildEventArgs
	{
		//the protocol
		private IProtocol protocol;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="pro">the protocol</param>
		internal ProtocolBuildEventArgs(IProtocol pro)
		{
			this.protocol = pro;
		}

		/// <summary>
		/// returns the protocol that has been added or removed
		/// </summary>
		public IProtocol Protocol
		{
			get
			{
				return this.protocol;
			}
		}
	}

	/// <summary>
	/// This is the event argument structure of the SeffBuildEventHandler.
	/// </summary>
	public class SeffBuildEventArgs
	{
		//the protocol
		private IServiceEffectSpecification seff;

		//the component and interface
		private IInterfaceIdentifier ifaceID;

		//the signature
		private ISignatureIdentifier sigId;

		/// <summary>
		/// called to create new args
		/// </summary>
		/// <param name="seff">the seff</param>
		/// <param name="ifaceID">the id of the interface</param>
		/// <param name="sigId">the signature</param>
		internal SeffBuildEventArgs(IServiceEffectSpecification seff, IInterfaceIdentifier ifaceID, ISignatureIdentifier sigId)
		{
			this.seff = seff;
			this.ifaceID = ifaceID;
			this.sigId = sigId;
		}

		/// <summary>
		/// returns the service effectspecification
		/// </summary>
		public IServiceEffectSpecification Seff
		{
			get { return seff; }
		}

		/// <summary>
		/// returns the id of the interface
		/// </summary>
		public IInterfaceIdentifier IfaceId
		{
			get { return ifaceID; }
		}

		/// <summary>
		/// the id of the signature
		/// </summary>
		public ISignatureIdentifier SigId
		{
			get { return sigId; }
		}
	}
	#endregion
}
