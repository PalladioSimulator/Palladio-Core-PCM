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
using System.Collections;
using System.Data;
using System.ComponentModel;
using System.Globalization;
using System.Text.RegularExpressions;
using System.Xml;
using System.IO;
using System.Reflection;

namespace CodeSmith.CustomProperties
{
	public class StringCollectionTypeConverter : TypeConverter 
	{
		public override bool CanConvertFrom(ITypeDescriptorContext context, Type sourceType) 
		{
			if (sourceType == typeof(XmlNode)) 
			{
				return true;
			}
			if (sourceType == typeof(string)) 
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
				StringCollection stringCollection = new StringCollection();
				
				XmlNodeList nodeList = node.SelectNodes("stringList/string");
				if (nodeList != null && nodeList.Count > 0)
				{
					for (int i = 0; i < nodeList.Count; i++)
					{
						stringCollection.Add(nodeList[i].InnerText);
					}
				}
				
				return stringCollection;
			}
			
			if (value is string) 
			{
				string csvrecord = (string)value;
				StringCollection stringCollection = new StringCollection();
				
				Regex csvRegex = new Regex(@",(?=([^\""]*""[^""]*"")*(?![^""]*""))");
				int start = 0;
				string csvvalue = String.Empty;
				foreach (Match match in csvRegex.Matches(csvrecord))
				{
					csvvalue = csvrecord.Substring(start, match.Index - start).Trim();
					if (csvvalue.StartsWith("\"") && csvvalue.EndsWith("\""))
					{
						csvvalue = csvvalue.Substring(1, csvvalue.Length - 2);
					}
					stringCollection.Add(csvvalue);
					start = match.Index + 1;
				}
				csvvalue = csvrecord.Substring(start).Trim();
				if (csvvalue.StartsWith("\"") && csvvalue.EndsWith("\""))
				{
					csvvalue = csvvalue.Substring(1, csvvalue.Length - 2);
				}
				stringCollection.Add(csvvalue);
				
				return stringCollection;
			}
			
			return base.ConvertFrom(context, culture, value);
		}
		
		public override object ConvertTo(ITypeDescriptorContext context, CultureInfo culture, object value, Type destinationType) 
		{
			if (destinationType == typeof(XmlNode)) 
			{
				StringWriter writer = new StringWriter();
				XmlTextWriter xmlwriter = new XmlTextWriter(writer);
				StringCollection stringCollection = value as StringCollection;
				
				xmlwriter.WriteStartElement("root");
				
				if (stringCollection != null && stringCollection.Count > 0)
				{				
					xmlwriter.WriteStartElement("stringList");
					for (int i = 0; i < stringCollection.Count; i++)
					{
						xmlwriter.WriteStartElement("string");
						xmlwriter.WriteString(stringCollection[i]);
						xmlwriter.WriteEndElement();
					}
					xmlwriter.WriteEndElement();
				}
				
				xmlwriter.WriteEndElement();
				
				string xml = writer.ToString();
				writer.Close();
				xmlwriter.Close();
				
				XmlDocument doc = new XmlDocument();
				doc.LoadXml(xml);
				
				return doc.SelectSingleNode("/root");
			}
			
			return base.ConvertTo(context, culture, value, destinationType);
		}
	}
}
