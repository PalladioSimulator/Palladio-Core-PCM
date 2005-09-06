//------------------------------------------------------------------------------
//
// Copyright (c) 2002-2004 Eric J. Smith.  All rights reserved.
// 
// The terms of use for this software are contained in the file
// named sourcelicense.txt, which can be found in the root of this distribution.
// By using this software in any fashion, you are agreeing to be bound by the
// terms of this license.
// 
// You must not remove this notice, or any other, from this software.
//
//------------------------------------------------------------------------------

using System;
using System.IO;
using System.ComponentModel;
using System.Globalization;
using System.Xml;
using System.Xml.Serialization;

namespace CodeSmith.CustomProperties
{
	public class XmlSerializedTypeConverter : TypeConverter 
	{
		public override bool CanConvertFrom(ITypeDescriptorContext context, Type sourceType) 
		{
			if (sourceType == typeof(XmlNode)) 
			{
				return true;
			}
			
			return base.CanConvertFrom(context, sourceType);
		}
		
		public override bool CanConvertTo(ITypeDescriptorContext context, Type destinationType)
		{
			if (destinationType == typeof(XmlNode)) 
			{
				return true;
			}
			
			return base.CanConvertTo(context, destinationType);
		}
		
		public override object ConvertFrom(ITypeDescriptorContext context, CultureInfo culture, object value) 
		{
			if (value is XmlNode) 
			{
				XmlNode node = (XmlNode)value;
				StringReader reader = new StringReader(node.InnerXml);
				XmlSerializer serializer = new XmlSerializer(context.PropertyDescriptor.PropertyType);
				object xml = serializer.Deserialize(reader);
				reader.Close();
				
				return xml;
			}
			
			return base.ConvertFrom(context, culture, value);
		}
		
		public override object ConvertTo(ITypeDescriptorContext context, CultureInfo culture, object value, Type destinationType) 
		{
			if (destinationType == typeof(XmlNode)) 
			{
				StringWriter writer = new StringWriter();
				XmlTextWriter xmlwriter = new XmlTextWriter(writer);
				
				try
				{
					xmlwriter.WriteStartElement("root");
				
					XmlSerializer serializer = new XmlSerializer(value.GetType());
					serializer.Serialize(xmlwriter, value);
				
					xmlwriter.WriteEndElement();
				
					string xml = writer.ToString();
					writer.Close();
					xmlwriter.Close();
				
					XmlDocument doc = new XmlDocument();
					doc.LoadXml(xml);
				
					return doc.SelectSingleNode("/root");
				}
				catch (Exception e)
				{
					throw e;
				}
				finally
				{
					writer.Close();
					xmlwriter.Close();
				}
			}
			
			return base.ConvertTo(context, culture, value, destinationType);
		}
	}
}
