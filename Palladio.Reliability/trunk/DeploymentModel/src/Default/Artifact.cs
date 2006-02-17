using System;
using System.Xml;
using Palladio.Attributes;
using Palladio.ComponentModel;
using Palladio.Identifier;
using ReflectionBasedVisitor;

namespace Palladio.DeploymentModel.Default
{
	/// <summary>
	/// </summary>
	internal class Artifact : IArtifact
	{
		private string name;
		private ArtifactStereotype stereotype;
		private IDeploymentSpecification deploymentSpecification;
		private IComponent realisedComponent;
		private IIdentifier id;
		private IAttributeHash attributes;
		private IArtifactContainer nestedArtifacts;

		public Artifact(string name, IAttributeHash attributes)
		{
			this.id = IdentifiableFactory.CreateGUID();
			this.attributes = attributes;
			stereotype = ArtifactStereotype.EXECUTABLE;
			deploymentSpecification = null;
			this.name = name;
			realisedComponent = null;
			nestedArtifacts = new ArtifactContainer();
		}

		public Artifact(string name)
		{
			this.id = IdentifiableFactory.CreateGUID();
			this.attributes = AttributesFactory.Default.CreateAttributeHash();
			stereotype = ArtifactStereotype.EXECUTABLE;
			deploymentSpecification = null;
			this.name = name;
			realisedComponent = null;
			nestedArtifacts = new ArtifactContainer();
		}

		protected Artifact(Artifact artifact)
		{
			this.id = IdentifiableFactory.CreateGUID();
			attributes = artifact.attributes.Clone() as IAttributeHash;
			stereotype = artifact.stereotype;
			deploymentSpecification = artifact.deploymentSpecification.Clone() as IDeploymentSpecification;
			name = artifact.name;
			realisedComponent = artifact.realisedComponent.Clone() as IComponent;
			nestedArtifacts = artifact.nestedArtifacts.Clone() as IArtifactContainer;
		}

		public string Name
		{
			get { return name; }
			set { name = value; }
		}

		public ArtifactStereotype Stereotype
		{
			get { return stereotype; }
			set { stereotype = value; }
		}

		public IDeploymentSpecification DeploymentSpecification
		{
			get { return deploymentSpecification; }
			set { deploymentSpecification = value; }
		}

		/// <summary>
		/// Components realised by this artifacts excluding components 
		/// realised by nested artifacts.
		/// </summary>
		public IComponent RealisedComponent
		{
			get { return realisedComponent; }
			set { realisedComponent = value; }
		}

		public IArtifactContainer NestedArtifacts
		{
			get { return nestedArtifacts; }
		}


		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get { return id; }
		}

		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public IAttributeHash Attributes
		{
			get { return attributes; }
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

		public object Clone()
		{
			return new Artifact(this);
		}

		public void Serialize(XmlTextWriter writer)
		{
			throw new NotImplementedException();
		}

		public void Deserialize(XmlNode element)
		{
			throw new NotImplementedException();
		}
	}
}
