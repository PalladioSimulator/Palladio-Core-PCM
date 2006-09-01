using System;
using System.Xml;
using Palladio.Attributes;
using Palladio.Identifier;
using ReflectionBasedVisitor;

namespace Palladio.DeploymentModel.Default
{
	/// <summary>
	/// </summary>
	internal class DeploymentSpecification : IDeploymentSpecification
	{
		private string filename;
		private IAttributeHash attributes;
		private IIdentifier id;

		public DeploymentSpecification(string filename)
		{
			this.id = IdentifiableFactory.CreateGUID();
			this.attributes = AttributesFactory.Default.CreateAttributeHash();
			this.filename = filename;
		}

		public DeploymentSpecification(string filename, IAttributeHash attributes)
		{
			this.attributes = attributes;
			this.id = IdentifiableFactory.CreateGUID();
			this.filename = filename;
		}

		protected DeploymentSpecification(DeploymentSpecification specification)
		{
			this.id = IdentifiableFactory.CreateGUID();
			this.attributes = specification.attributes.Clone() as IAttributeHash;
			this.filename = specification.filename;
		}

		public string Filename
		{
			get { return filename; }
			set { filename = value; }
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


		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get { return id; }
		}


		public object Clone()
		{
			return new DeploymentSpecification(this);
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
