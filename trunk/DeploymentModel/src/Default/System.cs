using System;
using System.Collections;
using System.Xml;
using Palladio.Attributes;
using Palladio.Identifier;
using ReflectionBasedVisitor;

namespace Palladio.DeploymentModel.Default
{
	/// <summary>
	/// Zusammenfassung für System.
	/// </summary>
	internal class System	: ISystem
	{
		private string name;
		private IAttributeHash attributeHash;
		private NodeContainer nodes;
		private IIdentifier id;
		private ArtifactContainer artifacts;

		public string Name
		{
			get { return name; }
			set { name = value; }
		}

		public IAttributeHash Attributes
		{
			get { return attributeHash; }
		}

		public INodeContainerWithConnections Nodes
		{
			get { return nodes; }
		}

		public IArtifactContainerWithConnections Artifacts
		{
			get { return artifacts; }
		}

		public System(string name)
		{
			this.id = IdentifiableFactory.CreateGUID();
			attributeHash = AttributesFactory.Default.CreateAttributeHash();
			this.name = name;
			nodes = new NodeContainer();
			artifacts = new ArtifactContainer();
			nodes.ElementAdded += new INodeAddedEventHandler(NodeAdded);
			nodes.ElementRemoved += new INodeRemovedEventHandler(NodeRemoved);
			artifacts.ElementAdded += new IArtifactAddedEventHandler(ArtifactAdded);
			artifacts.ElementRemoved += new IArtifactRemovedEventHandler(ArtifactRemoved);
		}

		public System(string name, IAttributeHash attributeHash)
		{
			this.attributeHash = attributeHash;
			this.id = IdentifiableFactory.CreateGUID();
			this.name = name;
			nodes = new NodeContainer();
			artifacts = new ArtifactContainer();
			nodes.ElementAdded += new INodeAddedEventHandler(NodeAdded);
			nodes.ElementRemoved += new INodeRemovedEventHandler(NodeRemoved);
			artifacts.ElementAdded += new IArtifactAddedEventHandler(ArtifactAdded);
			artifacts.ElementRemoved += new IArtifactRemovedEventHandler(ArtifactRemoved);
		}

		protected System(System system)
		{
			name = system.name;
			attributeHash = system.attributeHash.Clone() as IAttributeHash;
			nodes = system.nodes.Clone() as NodeContainer;
			artifacts = system.artifacts.Clone() as ArtifactContainer;
			this.id = IdentifiableFactory.CreateGUID();
		}

		public object Clone()
		{
			return new System(this);
		}

		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor(IVisitor visitor)
		{
		}

		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get { return id; }
		}

		protected virtual void NodeAdded(object sender, INodeAddedEventArgs args)
		{
			if (sender == nodes)
			{
				args.Element.NestedNodes.ElementAdded += new INodeAddedEventHandler(NodeAdded);
				args.Element.NestedNodes.ElementRemoved += new INodeRemovedEventHandler(NodeRemoved);
			}
			else
			{
				if (!nodes.Contains(args.Element))
					nodes.Add(args.Element);				
			}

			Stack nodeStack = new Stack(args.Element.NestedNodes.Elements);

			while (nodeStack.Count > 0)
			{
				INode current = (INode) nodeStack.Pop();
				if (!nodes.Contains(current))
				{
					nodes.Add(current);
					foreach (INode element in current.NestedNodes.Elements)
					{
						nodeStack.Push(element);
					}
				}
			}
		}

		protected virtual void NodeRemoved(object sender, INodeRemovedEventArgs args)
		{
			if (sender != nodes)
			{
				nodes.RemoveElements(args.filterExpression);
			}
		}

		protected virtual void ArtifactAdded(object sender, IArtifactAddedEventArgs args)
		{
			if (sender != artifacts)
			{
				artifacts.Add(args.Element);
			} 
			else
			{
				args.Element.NestedArtifacts.ElementAdded += new IArtifactAddedEventHandler(ArtifactAdded);
				args.Element.NestedArtifacts.ElementRemoved += new IArtifactRemovedEventHandler(ArtifactRemoved);
			}
		}

		protected virtual void ArtifactRemoved(object sender, IArtifactRemovedEventArgs args)
		{
			if (sender != artifacts)
			{
				artifacts.RemoveElements(args.filterExpression);
			}
		}

		public void Deserialize(XmlNode element)
		{
			throw new NotImplementedException();
		}

		public void Serialize(XmlTextWriter writer)
		{
			throw new NotImplementedException();
		}
	}
}
