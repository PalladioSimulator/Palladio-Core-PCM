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
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/21 15:37:43  joemal
	/// replace keyword as with real typcast
	///
	/// Revision 1.1  2005/02/21 13:48:31  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultInterfaceModel : FirstClassEntity, ICloneable, IAttributable, IInterfaceModel
	{
		protected ISignatureList signatureList;
		protected AttributeHash attributes;
		protected ArrayList protocolInfs = new ArrayList();

		public ISignatureList SignatureList
		{
			get
			{
				return signatureList;
			}
		}
		
		public AttributeHash Attributes 
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
			return new DefaultInterfaceModel(this.attributes, this.signatureList, this.Name, (GloballyUniqueIdentifier)this.ID);
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
		public IProtocolInformation[] ProtocolInformations
		{
			get
			{
				IProtocolInformation[] result = new IProtocolInformation[protocolInfs.Count];
				protocolInfs.CopyTo(result);
				return result;
			}
		}

		/// <summary>
		/// Get the additional information from given type
		/// </summary>
		/// <param name="aType">Type of the additional information to retrieve</param>
		/// <returns>The requested information or an exception if the information is not
		/// available</returns>
		public IProtocolInformation GetProtocolInformation(System.Type aType)
		{
			foreach (IProtocolInformation inf in protocolInfs)
			{
				if (aType.IsAssignableFrom(inf.GetType()))
					return inf;
			}
			throw new Exception("Additional information from given type not found!");
		}
		
		/// <summary>
		/// Add a new specification aspect to this interface, like a protocol spec.
		/// </summary>
		/// <param name="info">Additional specification data</param>
		public void AddProtocolInformation(IProtocolInformation info)
		{
			protocolInfs.Add(info);
			signatureList.SignatureListChangeEvent += new SignatureListChangeEventHandler(info.SignatureListChangeEventHandler);
		}
			
		public DefaultInterfaceModel(AttributeHash attrHash, ISignatureList aSignatureList, string name, GloballyUniqueIdentifier id)
		{
			this.signatureList = (ISignatureList)aSignatureList.Clone();
			this.attributes = attrHash;
			this._name = name;
			this._guid = id;
		}
		
		public DefaultInterfaceModel(AttributeHash attrHash, string name, GloballyUniqueIdentifier id)
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

			foreach (IProtocolInformation a in this.ProtocolInformations) 
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