using System;
using System.Collections;
using System.Xml;
using System.Xml.Schema;
using Palladio.Attributes;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.Serialization;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// This is the reader used by XmlSerializer.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/05/25 16:27:10  kelsaka
	/// - renamed former BuilderFactory / therefore removed former BuilderManager
	///
	/// Revision 1.1  2005/05/24 16:47:24  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	public class XmlCMReader
	{
		#region data

		//the buildermanager
		private IBuilderManager builderManager;

		//the plugins
		private Hashtable plugins;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new XmlCMReader using the given builder and plugins
		/// </summary>
		/// <param name="builderManager">the buildermanager</param>
		/// <param name="plugins">the plugins</param>
		public XmlCMReader(IBuilderManager builderManager, Hashtable plugins)
		{
			this.builderManager = builderManager;
			this.plugins = plugins;
		}

		#endregion 

		#region public methods

		/// <summary>
		/// called to read a serialized model from a file.
		/// </summary>
		/// <param name="location">the location that contains the file</param>
		/// <exception cref="ModelSerializationException">thrown if any reading error occurs during the deserialization</exception>
		public void Read(XmlFileLocation location)
		{
			XmlReader reader = null;

			try 
			{
				reader = new XmlTextReader(location.XmlFile);
			}
			catch(Exception exception)
			{
				throw new ModelSerializationException("Unable to open the xml file "+location.XmlFile+".",exception);
			}
			
			Read(reader);

			reader.Close();
		}

		/// <summary>
		/// called to read the serialized model from a xml reader.
		/// </summary>
		/// <param name="location">the location that contains the node</param>
		/// <exception cref="ModelSerializationException">thrown if any reading error occurs during the deserialization</exception>
		public void Read(XmlNodeLocation location)
		{
			Read(location.XmlReader);
		}

		#endregion

		#region private methods

		//read the model from the reader
		private void Read(XmlReader reader)
		{
			throw new NotImplementedException();
			XmlValidatingReader validator=null;
			try 
			{
				validator = new XmlValidatingReader(reader);
				validator.ValidationType = ValidationType.Schema;			
	
				XmlSchemaCollection schemaCollection = new XmlSchemaCollection();
				schemaCollection.Add(XmlSerializer.XMLNAMESPACE,
					System.AppDomain.CurrentDomain.BaseDirectory+"\\Palladio.ComponentModel.xsd");
				validator.Schemas.Add(schemaCollection);
			}
			catch(Exception exc)
			{
				throw new ModelSerializationException("Unable to load the xml schema Palladio.ComponentModel.xsd.",exc);
			}

			XmlDocument xmlDoc = null;
			try
			{
				xmlDoc = new XmlDocument();	
				xmlDoc.Load(validator);
				reader.Close();
			}
			catch(Exception exc)
			{
				throw new ModelSerializationException("Unable to load the xml document.",exc);
			}

			XmlNamespaceManager mgr = new XmlNamespaceManager(xmlDoc.NameTable);
			mgr.AddNamespace("cm",XmlSerializer.XMLNAMESPACE);

			ReadTLModel(xmlDoc.DocumentElement,mgr);
		}

		#endregion

		#region type level read methods

		private void ReadTLModel(XmlElement rootElement,XmlNamespaceManager mgr)
		{
			ExtractStructuredEntityTL(rootElement.SelectSingleNode("//cm:StaticViewRootTL",mgr),mgr);
		}

		#endregion

		#region private methods

		private void ExtractStructuredEntityTL(XmlNode entityNode,XmlNamespaceManager mgr)
		{
			XmlNodeList entities = entityNode.SelectNodes("cm:Structure/*",mgr);
			string parentGuid = null;
			if (entityNode.Attributes["guid"]!=null)
				parentGuid = entityNode.Attributes["guid"].Value;

			foreach(XmlNode entityStructure in entities)
			{
				string guid = entityStructure.Attributes["guid"].Value;
				XmlNode entityContent = entityNode.SelectSingleNode("cm:Entities/*[@guid=\""+guid+"\"]",mgr);
				string name = entityContent.ChildNodes[0].InnerText;

				if (entityStructure.Name.Equals("Interface"))
					ExtractInterface(guid, name,entityContent,mgr);
				else if (entityStructure.Name.Equals("Signature"))
					ExtractSignature(parentGuid,guid, name,entityContent);
			}			
		}

		private void ExtractInterface(string guid, string name, XmlNode entityContent,XmlNamespaceManager mgr)
		{
			IInterfaceIdentifier ifaceID = ComponentModelIdentifier.CreateInterfaceID(guid);
			IInterfaceTypeLevelBuilder ifaceBuilder = builderManager.RootBuilder.CreateInterface(ifaceID,name);
			ExtractAttributes(ifaceBuilder.Interface.Attributes,entityContent.ChildNodes[1]);
			ExtractStructuredEntityTL(entityContent,mgr);
		}

		private void ExtractAttributes(IAttributeHash attributes, XmlNode attributesNode)
		{
			//todo: to be implemented
			//throw new NotImplementedException();
		}

		private void ExtractSignature(string parentGuid, string guid, string name, XmlNode content)
		{
			Console.WriteLine("Signature found: "+name);
		}

		#endregion
	}
}
