// 
// Palladio Class
// $Id$
//
using System;
using Palladio.Attributes;
using Palladio.Identifier;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.Signature
{
	/// <summary>
	/// Summary description for DefaultService.
	/// </summary>
	/// <remarks><pre>
	/// $Log$
	/// Revision 1.1  2005/02/21 13:49:17  joemal
	/// initial import
	///
	///
	/// </pre></remarks>
	internal class DefaultService : IService
	{
		protected ISignature signature;
		protected IInterfaceModel interfaceModel;

		public IInterfaceModel Interface
		{
			get
			{
				return interfaceModel;
			}
		}

		public ISignature Signature
		{
			get
			{
				return signature;
			}

		}

		public IIdentifier ID
		{
			get
			{
				return IdentifiableFactory.CreateStringID(this.interfaceModel.ID.ToString()+":"+signature.ID.ToString());
			}
		}

		public bool Match(IMatchable other)
		{
			return ((IService)other).Signature.Match(signature);
		}

		public object Clone()
		{
			return new DefaultService((IIdentifier)signature.ID.Clone(),interfaceModel);
		}

		public override string ToString()
		{
			return this.interfaceModel.ID.ToString()+":"+signature.ID.ToString();
		}

		public override bool Equals(object obj)
		{
			if (!(obj is IService)) return false;
			if (obj == this) return true;
			IService sigRole = (IService)obj;
			return (sigRole.Interface.ID.Equals(this.Interface.ID) && sigRole.Signature.ID.Equals(this.Signature.ID));
		}

		public override int GetHashCode()
		{
			return 				(
				(signature != null ? signature.GetHashCode() : 0) ^ 
				(interfaceModel != null ? interfaceModel.GetHashCode() : 0));
		}


		/// <summary>
		/// Desciption of the constructor
		/// </summary>
		public DefaultService(IIdentifier signatureID, IInterfaceModel iface)
		{
			this.interfaceModel = iface;
			if (interfaceModel.SignatureList.ContainsSignatureID(signatureID))
				this.signature = interfaceModel.SignatureList.GetSignaturesByID(signatureID);
		}

		public void Serialize(System.Xml.XmlTextWriter writer) 
		{
			writer.WriteStartElement("Service","http://palladio.informatik.uni-oldenburg.de/XSD");
			writer.WriteAttributeString("guid",this.Interface.ID.ToString());
			writer.WriteAttributeString("id",this.Signature.ID.ToString());
			writer.WriteEndElement();
		}

		public void Deserialize(System.Xml.XmlNode element) 
		{
//			foreach (System.Xml.XmlNode childNode in element.ChildNodes) 
//			{
//				switch (childNode.Name) 
//				{
//					case "Signature":
//						this.encapsulatedSignature.Deserialize(childNode);
//						break;
//					case "Role":
//						this.roleID = IdentifiableFactory.CreateStringID(childNode.InnerText);
//						break;
//				}
//			}
		}
	}
}
