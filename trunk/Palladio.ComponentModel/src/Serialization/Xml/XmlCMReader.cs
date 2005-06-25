using System;
using System.Collections;
using System.Xml;
using System.Xml.Schema;
using Palladio.Attributes;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEntities.Impl;
using Palladio.Identifier;
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
	/// Revision 1.4  2005/06/25 16:53:29  joemal
	/// merge the implementation with the changed xsd
	///
	/// Revision 1.3  2005/05/25 18:15:27  kelsaka
	/// - added new methods to BuilderManager
	/// - use of new methods in example
	///
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
			XmlNode typeLevelNode = rootElement.SelectSingleNode("//cm:TypeLevel",mgr);
            ExtractInterfaces(typeLevelNode, mgr);
		}

		#endregion

		#region entity methods

		private void ExtractInterfaces(XmlNode typelevelNode, XmlNamespaceManager mgr)
		{
			IRootTypeLevelBuilder typeLevelBuilder = builderManager.RootTypeLevelBuilder;
			
			XmlNodeList ifaceNodes = typelevelNode.SelectNodes("cm:Interface",mgr);
			foreach(XmlNode ifaceNode in ifaceNodes)
			{
				IInterfaceIdentifier ifaceID = (IInterfaceIdentifier)ExtractEntityIdentifier(ifaceNode);
				string name = ExtractEntityName(ifaceNode,mgr);

				IInterfaceBuilder ifaceBuilder = typeLevelBuilder.CreateInterface(ifaceID,name);
				ExtractSignatures(ifaceBuilder,typelevelNode,ifaceNode, mgr);
				ExtractProtocols(ifaceBuilder,typelevelNode,ifaceNode, mgr);
			}
		}

		private void ExtractSignatures(IInterfaceBuilder ifaceBuilder, XmlNode typelevelNode,XmlNode ifaceNode,
			XmlNamespaceManager mgr)
		{
			XmlNodeList sigRefNodes = ifaceNode.SelectNodes("cm:Structure/cm:Signature",mgr);
			foreach(XmlNode sigRefNode in sigRefNodes)
			{
				string guid = sigRefNode.Attributes["guid"].Value;
				XmlNode sigNode = typelevelNode.SelectSingleNode("cm:Signature[@guid=\""+guid+"\"]",mgr);
				string name = ExtractEntityName(sigNode,mgr);
				ISignatureBuilder sigBuilder = ifaceBuilder.AddSignature(new InternalEntityIdentifier(guid),name);
				ExtractSignature(sigBuilder,sigNode,mgr);
			}
		}

		private void ExtractSignature(ISignatureBuilder builder, XmlNode sigNode, XmlNamespaceManager mgr)
		{
			XmlNode retType = sigNode.SelectSingleNode("cm:ReturnType",mgr);
			if (retType != null)
				builder.SetReturnType(retType.InnerText);

            XmlNodeList parameters = sigNode.SelectNodes("cm:Parameter",mgr);
			foreach(XmlNode parameter in parameters)
			{
				Type type = new ReflectedType(parameter.SelectSingleNode("cm:Type",mgr).InnerText).GetType();
				string name = parameter.SelectSingleNode("cm:Name",mgr).InnerText;
				ParameterModifierEnum modifier = (ParameterModifierEnum) 
					byte.Parse(parameter.SelectSingleNode("cm:Modifier",mgr).InnerText);
				builder.AppendParameter(type,name,modifier);
			}

			XmlNodeList exceptions = sigNode.SelectNodes("cm:Exception",mgr);
			foreach(XmlNode exception in exceptions)
				builder.AddException(exception.InnerText);
		}

		private void ExtractProtocols(IInterfaceBuilder builder,XmlNode typelevelNode ,XmlNode ifaceNode, XmlNamespaceManager mgr)
		{
		/*	XmlNodeList protRefNodes = ifaceNode.SelectNodes("cm:Structure/cm:Protocol",mgr);
			foreach(XmlNode protRefNode in protRefNodes)
			{

				IProtocolIdentifier protID = new InternalEntityIdentifier(protRefNode.Attributes["guid"].Value);				
				XmlNode sigNode = typelevelNode.SelectSingleNode("cm:Signature[@guid=\""+guid+"\"]",mgr);
				IProtocolTypeIdentifier protTypeID = new InternalEntityIdentifier(protRefNode.Attributes["type"].Value);

				IXmlProtocolPlugIn protocolPlugIn = (IXmlProtocolPlugIn) plugins[protTypeID];
				if (protocolPlugIn == null)
					throw new ModelSerializationException("No plugin found for protocoltype \""+protTypeID.Key+"\".");
				protocolPlugIn.LoadProtocol()
				writer.WriteEndElement();
			}	*/
		}

		private IIdentifier ExtractEntityIdentifier(XmlNode node)
		{
			return new InternalEntityIdentifier(node.Attributes["guid"].Value);
		}

		private string ExtractEntityName(XmlNode entityNode, XmlNamespaceManager mgr)
		{
			return entityNode.SelectSingleNode("cm:Name",mgr).InnerText;
		}

		#endregion
	}
}
