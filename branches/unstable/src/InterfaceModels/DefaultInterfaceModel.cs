using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.Identifier;

namespace Palladio.ComponentModel.InterfaceModels
{
	#region DefaultInterfaceModel
	/// <summary>
	/// An IInterfaceModel is the description of an interface (of a component).
	/// In our case an interface is a set of signatures
	/// which can be somehow related to each other.
	/// </summary>
	internal class DefaultInterfaceModel : FirstClassEntity, ICloneable, IAttributable, IInterfaceModel
	{
		protected ISignatureList signatureList;
		protected IAttributeHash attributes;
		protected ArrayList auxiliarySpecs = new ArrayList();

		public ISignatureList SignatureList
		{
			get
			{
				return signatureList;
			}
		}
		
		public IAttributeHash Attributes 
		{
			get 
			{
				return attributes;
			}
		}	
		
		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultInterfaceModel(this.attributes, this.signatureList, this.Name, this.ID as GloballyUniqueIdentifier);
		}
				
		public override bool Equals(object other)
		{
			if (!(other is IInterfaceModel)) return false;
			if (other == this) return true;
			IInterfaceModel model = (IInterfaceModel)other;
			return model.SignatureList.Equals(this.SignatureList);
		}
		
		public override int GetHashCode()
		{
			return (
				signatureList.GetHashCode()
				);		
		}

		/// <summary>
		/// Additional specification data like FSMs, Petri Nets, ....
		/// </summary>
		public IAuxiliaryInterfaceSpecification[] AuxiliarySpecifications
		{
			get
			{
				IAuxiliaryInterfaceSpecification[] result = new IAuxiliaryInterfaceSpecification[auxiliarySpecs.Count];
				auxiliarySpecs.CopyTo(result);
				return result;
			}
		}

		/// <summary>
		/// Get the auxiliary information of a given type
		/// </summary>
		/// <param name="aType">Type of the additional information to retrieve</param>
		/// <returns>The requested information or an exception if the information is not
		/// available</returns>
		public IAuxiliaryInterfaceSpecification GetAuxiliarySpecification(System.Type aType)
		{
			foreach (IAuxiliaryInterfaceSpecification spec in auxiliarySpecs)
			{
				if (aType.IsAssignableFrom(spec.GetType()))
					return spec;
			}
			throw new Exception("Auxiliary information not found!");
		}
		
		/// <summary>
		/// Add a new specification aspect to this interface, like a protocol spec.
		/// </summary>
		/// <param name="info">Additional specification data</param>
		public void AddAuxiliarySpecification(IAuxiliaryInterfaceSpecification info)
		{
			auxiliarySpecs.Add(info);
			signatureList.SignatureListChangeEvent += new SignatureListChangeEventHandler(info.SignatureListChangeEventHandler);
		}
			
		public DefaultInterfaceModel(IAttributeHash attrHash, ISignatureList aSignatureList, string name, GloballyUniqueIdentifier id)
		{
			this.signatureList = (ISignatureList)aSignatureList.Clone();
			this.attributes = attrHash;
			this._name = name;
			this._guid = id;
		}
		
		public DefaultInterfaceModel(IAttributeHash attrHash, string name, GloballyUniqueIdentifier id)
		{
			signatureList = ComponentFactory.CreateSignatureList(new ISignature[0]);
			this.attributes = attrHash;
			this._name = name;
			this._guid = id;
		}

		public override void Serialize(System.Xml.XmlTextWriter writer) 
		{
			writer.WriteStartElement("SignatureList","http://palladio.informatik.uni-oldenburg.de/XSD");
			foreach (ISignature s in this.SignatureList) 
			{
				s.Serialize(writer);
			}
			writer.WriteEndElement();

			foreach (IAuxiliaryInterfaceSpecification a in this.AuxiliarySpecifications) 
			{
				writer.WriteStartElement("AuxiliarySpecification","http://palladio.informatik.uni-oldenburg.de/XSD");
				a.Serialize(writer);
				writer.WriteEndElement();
			}
		}

		public override void Deserialize(System.Xml.XmlNode element) 
		{
			System.Xml.XmlNode childNode = element.FirstChild;

			while (childNode != null)
			{
				switch (childNode.Name) 
				{
					case "SignatureList":

						System.Xml.XmlNode signatureNode = childNode.FirstChild;
						while (signatureNode != null)
						{
							
							ISignature signature = ComponentFactory.CreateSignature("a");
							signature.Deserialize(signatureNode);
							this.signatureList.AddSignatures(signature);
							signatureNode = signatureNode.NextSibling;
						}						
						break;
					case "AuxiliarySpecification":
						break;
				}
				childNode = childNode.NextSibling;
			}
		}

	}
	#endregion
}