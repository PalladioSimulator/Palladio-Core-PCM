using System;
using System.Collections;
using System.IO;
using System.Xml;
using System.Xml.Schema;
using Palladio.Attributes;
using Palladio.FiniteStateMachines.Serializer.Interfaces;

namespace Palladio.FiniteStateMachines.Serializer.DefaultImplementation
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
	/// Revision 1.8  2005/08/22 06:45:57  kelsaka
	/// - added XSD-Scheme for validation purposes
	///
	/// Revision 1.7  2005/08/21 18:08:11  kelsaka
	/// - added comments
	///
	/// Revision 1.6  2005/08/21 15:34:54  kelsaka
	/// - completed handling of attributes (deserialisation)
	///
	/// Revision 1.5  2005/08/21 13:58:17  kelsaka
	/// - added use of plugins for deserialisation
	///
	/// Revision 1.4  2005/08/20 12:27:55  kelsaka
	/// - added further attribute handling
	///
	/// Revision 1.3  2005/08/19 16:11:38  kelsaka
	/// - added further deserialisation
	///
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
		/// <param name="xmlDocument">A xmlDocument that represents a FSM.</param>
		/// <param name="attributeSerializerPlugins">A List of registered serializer plugins for <see cref="IAttribute"/>s.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xmlNode.</returns>
		public IFiniteStateMachine Load (XmlDocument xmlDocument, Hashtable attributeSerializerPlugins)
		{
			this.attributeSerializerPlugins = attributeSerializerPlugins;

			XmlNamespaceManager mgr = new XmlNamespaceManager(xmlDocument.NameTable);
			mgr.AddNamespace(XMLSerializer.XMLPREFIX, XMLSerializer.XMLNAMESPACE);
			XmlNode rootNode = xmlDocument.DocumentElement.SelectSingleNode(
				"//Palladio.FiniteStateMachine", mgr);
			
			ExtractStates(rootNode, mgr);
			ExtractStartState(rootNode, mgr);
			ExtractFinalStates(rootNode, mgr);
			ExtractInputAlphabet(rootNode, mgr);
			ExtractTransitions(rootNode, mgr);

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

			return Load(xmlDocument, attributeSerializerPlugins);
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
				XmlSchemaCollection schemaCollection = new XmlSchemaCollection();
				schemaCollection.Add(XMLSerializer.XMLNAMESPACE,
					System.AppDomain.CurrentDomain.BaseDirectory + "\\" + XMLSerializer.XSDSchemeFileName);

				/*foreach(IAttributeSerializerPlugin plugin in attributeSerializerPlugins.Values)
					schemaCollection.Add(plugin.XmlNamespace, plugin.XmlSchemaURI);*/

				//validatingReader.Schemas.Add(schemaCollection);
			}
			catch(Exception exc)
			{
				throw new ModelSerializationException("Unable to load the xml schema " + XMLSerializer.XSDSchemeFileName +
					" or one of the plugins'.", exc);
			}

			return LoadXMLDocument (validatingReader);
		}

		/// <summary>
		/// Extract all states, including assignment of error states.
		/// </summary>
		/// <param name="rootNode">base node</param>
		/// <param name="mgr">namespace management to be applied</param>
		private void ExtractStates (XmlNode rootNode, XmlNamespaceManager mgr)
		{
			// get states:
			XmlNodeList stateList = rootNode.SelectSingleNode("//states", mgr).ChildNodes;

			IState state;
			foreach(XmlNode node in stateList)
			{
				state = FSMFactory.CreateDefaultState(node.Attributes.GetNamedItem("id").Value);

				// set error states:
				if(node.Attributes.GetNamedItem("isErrorState").Value.Equals("True"))
				{
					state.IsErrorState = true;
				}
				else
				{
					state.IsErrorState = false;	
				}
				
				// handle attributes:
				AttributeInfo[] attributes = ExtractAttribute(node.SelectSingleNode("attributes"), mgr);
				foreach(AttributeInfo attributeInfo in attributes)
				{
					state.Attributes.Add(attributeInfo.AttributeType, attributeInfo.Attribute);
				}

				efsm.AddStates(state);
			}
		}

		/// <summary>
		/// Set the start state
		/// </summary>
		/// <param name="rootNode">base node</param>
		/// <param name="mgr">namespace management to be applied</param>
		private void ExtractStartState(XmlNode rootNode, XmlNamespaceManager mgr)
		{
			efsm.StartState = efsm.
				GetState(rootNode.SelectSingleNode("//startState", mgr).
				Attributes.GetNamedItem("idref").Value);	
		}

		/// <summary>
		/// Set the final states.
		/// </summary>
		/// <param name="rootNode">base node</param>
		/// <param name="mgr">namespace management to be applied</param>
		private void ExtractFinalStates(XmlNode rootNode, XmlNamespaceManager mgr)
		{
			ArrayList finalStates = new ArrayList();
			XmlNodeList nodes = rootNode.SelectSingleNode("//finalStates", mgr).ChildNodes;
			foreach(XmlNode node in nodes)
			{
				finalStates.Add(efsm.GetState(node.Attributes.GetNamedItem("idref").Value));
			}
			
			efsm.FinalStates = (IState[])finalStates.ToArray(typeof(IState));
		}

		/// <summary>
		/// Read all transitions including attributes.
		/// </summary>
		/// <param name="rootNode">base node</param>
		/// <param name="mgr">namespace management to be applied</param>
		private void ExtractTransitions(XmlNode rootNode, XmlNamespaceManager mgr)
		{
			XmlNodeList nodes = rootNode.SelectSingleNode("//transitions", mgr).ChildNodes;
			foreach(XmlNode node in nodes)
			{
				ITransition transition = FSMFactory.CreateDefaultTransition(
					efsm.GetState(node.Attributes.GetNamedItem("sourceStateIdRef").Value),
					FSMFactory.CreateDefaultInput(
						node.SelectSingleNode("//inputSymbol", mgr).Attributes.GetNamedItem("inputSymbolIdRef").Value
					),
					efsm.GetState(node.Attributes.GetNamedItem("destinationStateIdRef").Value)
				);
				
				// handle attributes:
				AttributeInfo[] attributes = ExtractAttribute(node.SelectSingleNode("attributes"), mgr);
				foreach(AttributeInfo attributeInfo in attributes)
				{
					transition.Attributes.Add(attributeInfo.AttributeType, attributeInfo.Attribute);
				}
				
				efsm.AddTransitions(transition);
			}
		}

		/// <summary>
		/// Get the IAttributes from the given XML node.
		/// </summary>
		/// <param name="node">The "attributes"-node who's child-nodes are "attribute"-nodes.</param>
		/// <param name="mgr">Actual namespace manager to use.</param>
		/// <returns>Array of IAttributes that were found in the given node.</returns>
		private AttributeInfo[] ExtractAttribute(XmlNode node, XmlNamespaceManager mgr)
		{
			ArrayList attributes = new ArrayList();

			XmlNodeList attributeNodes = node.SelectNodes("attribute", mgr);
			foreach(XmlNode attributeNode in attributeNodes)
			{
				string attributeTypeGUID = attributeNode.Attributes.GetNamedItem("attributeType").Value;

				try 
				{
					if(attributeTypeGUID != null)
					{
						Guid guid = new Guid(attributeTypeGUID);
						// load by plugins:
						attributes.Add(((IAttributeSerializerPlugin)attributeSerializerPlugins[guid])
							.DeserializeAttribute(attributeNode));
					}
				}
				catch (Exception e)
				{
					throw new AttributeNotSupportedException(
						"Could not find attributeTypeGUID for attribute OR no plugin loaded for attributeTypeGUID: " +
						attributeTypeGUID + "\nInner Exception Message: " + e.Message + "; " + e.StackTrace);
				}
			}

			return (AttributeInfo[])attributes.ToArray(typeof(AttributeInfo));
		}

		/// <summary>
		/// Set up the input alphabet.
		/// </summary>
		/// <param name="rootNode">base node</param>
		/// <param name="mgr">namespace management to be applied</param>
		private void ExtractInputAlphabet(XmlNode rootNode, XmlNamespaceManager mgr)
		{
			XmlNodeList nodes = rootNode.SelectSingleNode("//inputSymbolAlphabet", mgr).ChildNodes;
			foreach(XmlNode node in nodes)
			{
				efsm.AddInputSymbols(
					FSMFactory.CreateDefaultInput(node.Attributes.GetNamedItem("inputSymbolId").Value));
			}
		}

		/// <summary>
		/// Creates a XML document from the given reader.
		/// </summary>
		/// <param name="validatingReader">The reader to use for reading the XML document.</param>
		/// <returns>The XmlDocument representing the xml file given in the validatingReader.</returns>
		/// <exception cref="ModelSerializationException">Thrown if the document cannot be opened.</exception>
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
				throw new ModelSerializationException("Unable to load the xml document.", exc);
			}
			return xmlDoc;
		}

		#endregion
	}
}
