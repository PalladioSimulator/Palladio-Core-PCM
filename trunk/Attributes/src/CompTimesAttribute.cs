using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// </summary>
	public class CompTimesAttribute : IAttribute
	{

		public static MeasuredTimeAttribute GetTime(IComponent component, string interfaceName, string methodName)
		{
			CompTimesAttribute attr = GetAttribute(component);
			return attr.GetTime(interfaceName, methodName);
		}

		public MeasuredTimeAttribute GetTime(string interfaceName, string methodName)
		{
			Hashtable signatureHash = (Hashtable)interfaceHash[interfaceName];
			if (signatureHash == null)
				return null;
			return (MeasuredTimeAttribute) signatureHash[methodName];
		}

		#region AttributeHandling

		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		public static CompTimesAttribute GetAttribute(IComponent component)
		{
			CompTimesAttribute attr = component.Attributes[CompTimesAttribute.AttributeType] as CompTimesAttribute;
			if (attr == null)
			{
				AddAttributeTo(component);
				attr = component.Attributes[CompTimesAttribute.AttributeType] as CompTimesAttribute;
			}
			return attr;
		}

		public static void AddAttributeTo(IComponent component)
		{
			CompTimesAttribute attr = new CompTimesAttribute();
			foreach (IIdentifier roleID in component.ProvidedRoles)
			{
				IInterfaceModel iModel = component.GetProvidesInterface(roleID);
				attr.AddInterface(iModel);
			}
			component.Attributes.Add(CompTimesAttribute.AttributeType, attr);
		}

		/// <summary>
		/// Hide Constructor.
		/// </summary>
		private CompTimesAttribute()
		{
			interfaceHash = new Hashtable();
		}


		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("C381D5F2-6DD7-43ac-A0B0-B8DC07D8DD45"), "ComponentMeasuredTimesAttribute", typeof (CompTimesAttribute));

		private void AddInterface(IInterfaceModel iModel)
		{
			Hashtable signatureHash = new Hashtable();
			foreach(ISignature signature in iModel.SignatureList.GetSignatures())
			{
				signatureHash.Add(signature.Name, new MeasuredTimeAttribute());
			}
			interfaceHash.Add(iModel.Name, signatureHash);
		}

		#endregion
		
		/// <summary>
		/// key: IInterfaceModel.Name
		/// value: Hashtable
		///		key: ISignature.Name
		///		value: MeasuredTimesAttribute
		/// </summary>
		private Hashtable interfaceHash;

		#region IAttribute Member

		public void Serialize(System.Xml.XmlTextWriter writer)
		{
			// TODO:  Implementierung von CompTimesAttribute.Serialize hinzufügen
		}

		public void Deserialize(System.Xml.XmlNode element)
		{
			// TODO:  Implementierung von CompTimesAttribute.Deserialize hinzufügen
		}

		#endregion
	}
}
