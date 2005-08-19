using System;
using System.Collections;
using System.IO;
using System.Xml;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.Serializer
{
	/// <summary>
	/// Serializer for the Palladio Finite State Machines (FSMs). Handles laoding and saving of
	/// FSMs including <see cref="IAttribute"/>s and <see cref="IInput"/>s.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/08/19 09:50:31  kelsaka
	/// - added XPath statements
	///
	/// Revision 1.1  2005/08/18 09:30:47  kelsaka
	/// - extraced load and save into separate classes
	/// - started implementation of loading from xml
	///
	/// </code>
	/// </remarks>
	internal class FSMLoader
	{
		/// <summary>
		/// Use the attribute type GUID as key.
		/// </summary>
		private Hashtable attributeSerializerPlugins;
		
		/// <summary>
		/// The FSM to build on loading.
		/// </summary>
		private IEditableFiniteStateMachine efsm;

		/// <summary>
		/// Default constructor.
		/// </summary>
		public FSMLoader()
		{
			efsm = FSMFactory.GetEditableFSM(FSMFactory.CreateEmptyFSM());
		}

		#region public methods

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a <see cref="XmlNode"/>.
		/// </summary>
		/// <param name="xmlNode">A xmlNode that represents a FSM.</param>
		/// <param name="attributeSerializerPlugins">A List of registered serializer plugins for <see cref="IAttribute"/>s.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xmlNode.</returns>
		public IFiniteStateMachine Load (XmlNode xmlNode, Hashtable attributeSerializerPlugins)
		{
			this.attributeSerializerPlugins = attributeSerializerPlugins;
			

			return efsm;
		}

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a file.
		/// </summary>
		/// <param name="xmlFilePath">Location of the xml file, that contains a FSM.</param>
		/// <param name="attributeSerializerPlugins">A List of registered serializer plugins for <see cref="IAttribute"/>s.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xml file.</returns>
		public IFiniteStateMachine Load (FileInfo xmlFilePath, Hashtable attributeSerializerPlugins)
		{
			this.attributeSerializerPlugins = attributeSerializerPlugins;

			// get a validated xmlDocument:
			XmlDocument xmlDocument = LoadFromFileAndValidate (xmlFilePath);

			XmlNamespaceManager mgr = new XmlNamespaceManager(xmlDocument.NameTable);
			mgr.AddNamespace(XMLSerializer.XMLPREFIX, XMLSerializer.XMLNAMESPACE);
			
			ExtractDataFromXML (xmlDocument.DocumentElement, mgr);

			return efsm;
		}


		private static XmlDocument LoadFromFileAndValidate (FileInfo xmlFilePath)
		{
			XmlTextReader xmlTextReader = new XmlTextReader(xmlFilePath.Name);
			XmlValidatingReader validatingReader = null;
	
			try 
			{
				validatingReader = new XmlValidatingReader(xmlTextReader);
				validatingReader.ValidationType = ValidationType.Schema;			
	

				// TODO: add validation schemas
				/* XmlSchemaCollection schemaCollection = new XmlSchemaCollection();
				schemaCollection.Add(XMLSerializer.XMLNAMESPACE,
					System.AppDomain.CurrentDomain.BaseDirectory + "\\Palladio.FiniteStateMachines.xsd");

				foreach(IAttributeSerializerPlugin plugin in attributeSerializerPlugins.Values)
					schemaCollection.Add(plugin.XmlNamespace, plugin.XmlSchemaURI);

				validatingReader.Schemas.Add(schemaCollection);*/
			}
			catch(Exception exc)
			{
				throw new ModelSerializationException("Unable to load the xml schema Palladio.FiniteStateMachine.xsd "+
					"or one of the plugins once.",exc);
			}

			return LoadXMLDocument (validatingReader);
		}

		private void ExtractDataFromXML (XmlElement rootElement, XmlNamespaceManager mgr)
		{

			// get states:
			XmlNode rootNode = rootElement.SelectSingleNode(
				"//" + "Palladio.FiniteStateMachine", mgr);
			XmlNodeList stateList = rootNode.SelectSingleNode("//states").ChildNodes;

			foreach(XmlNode node in stateList)
			{
				Console.Out.WriteLine (".." + node.Attributes.Count);
				//efsm.
			}
			
		}

		private static XmlDocument LoadXMLDocument (XmlValidatingReader validatingReader)
		{
			XmlDocument xmlDoc = null;
			try
			{
				xmlDoc = new XmlDocument();	
				xmlDoc.Load(validatingReader);
				validatingReader.Close();
			}
			catch(Exception exc)
			{
				throw new ModelSerializationException("Unable to load the xml document.",exc);
			}
			return xmlDoc;
		}

		#endregion
	}
}
