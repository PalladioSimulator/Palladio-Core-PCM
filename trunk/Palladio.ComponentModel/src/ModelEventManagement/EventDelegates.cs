using Palladio.Attributes;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelEventManagement
{
	#region event delegates 
	
	/// <summary>
	/// defines the eventhandler, that is called, when an interface has been added or removed.
	/// </summary>
	public delegate void InterfaceBuildEventHandler(object sender, InterfaceBuildEventArgs args);
	
	/// <summary>
	/// defines the eventhandler, that is called, when an component has been added or removed.
	/// </summary>
	public delegate void ComponentBuildEventHandler(object sender, ComponentBuildEventArgs args);

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
	/// This is the event argument structure of the ConnectorRemovedEventHandler
	/// </summary>
	public class ConnectorRemovedEventArgs
	{
		//the connection
		private IConnection connection;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="con">the connection</param>
		internal ConnectorRemovedEventArgs(IConnection con)
		{
			this.connection = con;
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
	/// This is the event argument structure of the AttributeChangedEventHandler.
	/// </summary>
	public class AttributeChangedEventArgs
	{
		/// <summary>
		/// defines the three types of changes. 
		/// </summary>
		public enum ChangedType
		{
			/// <summary>
			/// the attribute has been added
			/// </summary>
			ADDED,
			/// <summary>
			/// the attribute has been removed
			/// </summary>
			REMOVED,

			/// <summary>
			/// the attribute has been changed
			/// </summary>
			CHANGED
		}

		//the attributetype
		private IAttributeType attributeType;

		//the attribute
		private IAttribute attribute;

		//hold the type of changes
		private ChangedType changesType;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="attribute">the attribute</param>
		/// <param name="attributeType">the type of the attribute</param>
		/// <param name="changesType">the type of changes</param>
		internal AttributeChangedEventArgs(IAttribute attribute, IAttributeType attributeType, ChangedType changesType)
		{
			this.attribute = attribute;
			this.attributeType = attributeType;
			this.changesType = changesType;
		}

		/// <summary>
		/// the type of the attribute
		/// </summary>
		public IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		/// <summary>
		/// the new attribute
		/// </summary>
		public IAttribute Attribute
		{
			get { return attribute; }
		}

		/// <summary>
		/// the type of changes
		/// </summary>
		public ChangedType ChangesType
		{
			get { return changesType; }
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
	#endregion
}
