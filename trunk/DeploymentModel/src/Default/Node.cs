using System;
using System.Xml;
using Palladio.Attributes;
using Palladio.Identifier;
using ReflectionBasedVisitor;

namespace Palladio.DeploymentModel.Default
{
	/// <summary>
	/// </summary>
	internal class Node : INode
	{

		private string name;
		private NodeStereotype stereotype;
		private INodeContainer nestedNodes;
		private IArtifactContainer deployedArtifacts;
		private IAttributeHash attributeHash;
		private IIdentifier id;

		public Node(string name)
		{
			this.id = IdentifiableFactory.CreateGUID();
			this.stereotype = NodeStereotype.DEVICE;
			this.nestedNodes = new NodeContainer();
			this.deployedArtifacts = new ArtifactContainer();
			this.attributeHash = AttributesFactory.Default.CreateAttributeHash();
			this.name = name;
		}

		public Node(string name, IAttributeHash attributeHash)
		{
			this.id = IdentifiableFactory.CreateGUID();
			this.stereotype = NodeStereotype.DEVICE;
			this.nestedNodes = new NodeContainer();
			this.deployedArtifacts = new ArtifactContainer();
			this.attributeHash = attributeHash;
			this.name = name;
		}

		public Node(Node node)
		{
			this.name = node.name;
			this.stereotype = node.stereotype;
			this.nestedNodes = node.nestedNodes.Clone() as INodeContainer;
			this.deployedArtifacts = node.deployedArtifacts.Clone() as IArtifactContainer;
			this.attributeHash = attributeHash.Clone() as IAttributeHash;
			this.id = IdentifiableFactory.CreateGUID();
		}

		public string Name
		{
			get { return name; }
			set { name = value; }
		}

		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get { return id; }
		}

		public NodeStereotype Stereotype
		{
			get { return stereotype; }
			set { stereotype = value; }
		}

		public INodeContainer NestedNodes
		{
			get { return nestedNodes; }
		}

		public IArtifactContainer DeployedArtifacts
		{
			get { return deployedArtifacts; }
		}

		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public IAttributeHash Attributes
		{
			get { return attributeHash; }
		}

		public object Clone()
		{
			return new Node(this);
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

		public void Deserialize(XmlNode element)
		{
			throw new NotImplementedException();
		}

		public void Serialize(XmlTextWriter writer)
		{
			throw new NotImplementedException();
		}

		public override string ToString()
		{
			return name;
		}

		public override bool Equals(object obj)
		{
			return base.Equals(obj);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode();
		}
	}
}