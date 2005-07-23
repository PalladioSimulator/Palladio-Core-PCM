using System;
using System.Xml;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Serialization.Xml;

namespace Palladio.Types
{
	/// <summary>
	/// The xml serializer plugin that is used to serialize simple string types.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/07/23 18:53:57  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class StringTypeXMLSerializerPlugin : IXmlTypePlugIn
	{
		#region data

		//the namespace of the componentmodels xml tree
		const string XMLNAMESPACE = "http://palladio.informatik.uni-oldenburg.de/Types/StringType";

		//the name of the xml schema of this plugin
		const string XMLSCHEMA = "Palladio.Types.StringType.xsd";

		//the supported type ids
		private static ITypeIdentifier[] SUPPORTED_TYPES={StringType.TYPEID};

		#endregion
		
		#region methods

		/// <summary>
		/// called by the serializer, when the plugin has been registered.
		/// </summary>
		public void Registered()
		{
			//not used
		}

		/// <summary>
		/// called by the serializer, when a type has to be loaded from given xml node. The type is
		/// one of the supported ones.
		/// </summary>
		/// <param name="typeNode">the xml node that contains the type</param>
		/// <returns>the type</returns>
		public IType LoadType(XmlNode typeNode)
		{
			XmlDocument doc = typeNode.OwnerDocument;
			XmlNamespaceManager mgr = new XmlNamespaceManager(doc.NameTable);
			mgr.AddNamespace("st",StringTypeXMLSerializerPlugin.XMLNAMESPACE);

			return TypesFactory.CreateStringType(typeNode.SelectSingleNode("st:Name",mgr).InnerText);			
		}

		/// <summary>
		/// called by the serializer, when an type has to be saved to the given xmlwriter. The type is
		/// one of the supported ones.
		/// </summary>
		/// <param name="xmlWriter">the xml writer</param>
		/// <param name="type">the type</param>
		public void SaveType(XmlWriter xmlWriter, IType type)
		{
			xmlWriter.WriteElementString("Name",XMLNAMESPACE,type.Name);
		}

		/// <summary>
		/// called by the serializer, after the plugin has been unregistered.
		/// </summary>
		public void Unregistered()
		{
			//not used
		}

		/// <summary>
		/// returns the xml schema that can be used to validate the xml file before building the model
		/// </summary>
		public string XmlSchema
		{
			get
			{
				return StringTypeXMLSerializerPlugin.XMLSCHEMA;
			}
		}

		/// <summary>
		/// returns the namespace of the subtree that represents the content of the xml-file that has to
		/// be processed by the plugin.
		/// </summary>
		public string XmlNameSpace
		{
			get
			{
				return StringTypeXMLSerializerPlugin.XMLNAMESPACE;
			}
		}

		#endregion

		#region properties

		/// <summary>
		/// returns an array of supported types
		/// </summary>
		public ITypeIdentifier[] SupportedTypes
		{
			get
			{
				return StringTypeXMLSerializerPlugin.SUPPORTED_TYPES;
			}
		}

		#endregion
	}	
}
