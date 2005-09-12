using System;
using System.Collections;
using System.IO;
using System.Text;
using System.Xml;
using Palladio.Attributes;
using Palladio.FiniteStateMachines.Serializer;
using Palladio.FiniteStateMachines.Serializer.Interfaces;

namespace Palladio.FiniteStateMachines.Serializer.DefaultImplementation
{
	/// <summary>
	/// Serializer for the Palladio Finite State Machines (FSMs). All elements and attributes use the
	/// namespace definition and prefix defined in <see cref="XMLSerializer"/>.
	/// </summary>
	/// <remarks>
	/// Typical output of the serializer looks like this:
	/// <code>
	///		<?xml version="1.0" encoding="utf-8"?>
	///		<!--Finite State Machine - Palladio Research Group, Software Engineering, University of Oldenburg, Germany-->
	///		<Palladio.FiniteStateMachine>
	///		<!--List of states of the FSM:-->
	///		<states>
	///		<state id="2" isErrorState="False">
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</state>
	///		<state id="3" isErrorState="False">
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</state>
	///		<state id="1" isErrorState="False">
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</state>
	///		</states>
	///		<!--The start state of the FSM:-->
	///		<startState idref="1" />
	///		<!--List of final states:-->
	///		<finalStates>
	///		<finalState idref="1" />
	///		<finalState idref="3" />
	///		</finalStates>
	///		<!--List of transitions:-->
	///		<transitions>
	///		<transition sourceStateIdRef="2" destinationStateIdRef="3">
	///		<inputSymbol inputSymbolIdRef="c" />
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</transition>
	///		<transition sourceStateIdRef="3" destinationStateIdRef="1">
	///		<inputSymbol inputSymbolIdRef="eps" />
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</transition>
	///		<transition sourceStateIdRef="1" destinationStateIdRef="1">
	///		<inputSymbol inputSymbolIdRef="a" />
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</transition>
	///		<transition sourceStateIdRef="1" destinationStateIdRef="2">
	///		<inputSymbol inputSymbolIdRef="b" />
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</transition>
	///		</transitions>
	///		<inputSymbolAlphabet>
	///		<inputSymbol inputSymbolId="a" />
	///		<inputSymbol inputSymbolId="eps" />
	///		<inputSymbol inputSymbolId="b" />
	///		<inputSymbol inputSymbolId="c" />
	///		</inputSymbolAlphabet>
	///		</Palladio.FiniteStateMachine>
	///	-----------------
	/// Version history:
	///
	/// $Log$
	/// Revision 1.13  2005/09/12 19:02:42  joemal
	/// some changes in xml schema
	///
	/// Revision 1.12  2005/09/08 07:24:23  joemal
	/// to be continued ...
	///
	/// Revision 1.11  2005/09/01 09:02:52  kelsaka
	/// - fixed bug: validating reader was not closed
	/// - added nunit project
	///
	/// Revision 1.10  2005/08/26 12:33:50  kelsaka
	/// - workaround for validation error
	///
	/// Revision 1.9  2005/08/24 10:24:07  kelsaka
	/// - added serialization support for default input
	///
	/// Revision 1.8  2005/08/24 09:25:40  kelsaka
	/// - created serializer for the default input
	/// - added methods for the IInputSerializerPlugin
	///
	/// Revision 1.7  2005/08/22 16:39:02  kelsaka
	/// - load: validation against xsd added
	///
	/// Revision 1.6  2005/08/22 08:46:33  kelsaka
	/// - added use of prefixes and namespaces to loader and writer
	///
	/// Revision 1.5  2005/08/22 06:45:57  kelsaka
	/// - added XSD-Scheme for validation purposes
	///
	/// Revision 1.4  2005/08/21 15:34:54  kelsaka
	/// - completed handling of attributes (deserialisation)
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
	internal class FSMWriter
	{
		/// <summary>
		/// Use the attribute type GUID as key.
		/// </summary>
		private Hashtable attributeSerializerPlugins;

		/// <summary>
		/// Use the input type GUID as key.
		/// </summary>
		private Hashtable inputSerializerPlugins;

		/// <summary>
		/// Default constructor.
		/// </summary>
		public FSMWriter()
		{

		}

		#region public methods

		/// <summary>
		/// Saves the given <see cref="IFiniteStateMachine"/> using the given <see cref="xmlWriter"/>.
		/// </summary>
		/// <param name="xmlWriter">Used to save the FSM.</param>
		/// <param name="fsm">The FSM to serialize.</param>
		/// <param name="attributeSerializerPlugins">A List of registered serializer plugins for <see cref="IAttribute"/>s.</param>
		/// <param name="inputSerializerPlugins">A list of registered serializer plugins for <see cref="IInput"/>s.</param>
		/// <remarks>Note: The xmlWriter is NOT closed after writing.</remarks>
		public void Save (XmlWriter xmlWriter, IFiniteStateMachine fsm, Hashtable attributeSerializerPlugins, Hashtable inputSerializerPlugins)
		{
			this.attributeSerializerPlugins = attributeSerializerPlugins;
			this.inputSerializerPlugins = inputSerializerPlugins;

			xmlWriter.WriteComment("Finite State Machine - Palladio Research Group, Software Engineering, University of Oldenburg, Germany");
			// declare namespaces, schemas and prefixes:
			xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "Palladio.FiniteStateMachine", XMLSerializer.XMLNAMESPACE);
			xmlWriter.WriteAttributeString("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");			
			//xmlWriter.WriteAttributeString("xsi:schemaLocation", XMLSerializer.XMLNAMESPACE + " " + XMLSerializer.XSDSchemeFileName);
			//xmlWriter.WriteAttributeString("xsi:schemaLocation",  XMLSerializer.XMLNAMESPACE + " " + XMLSerializer.XSDSchemeFileName + " http://Test1-Namespace.com/attribute" + " " + "Test1-attribute.xsd");

			this.writeStates(xmlWriter, fsm);
			this.writeInputAlphabet(xmlWriter, fsm);
			this.WriteStructure(xmlWriter,fsm);

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Saves the given <see cref="IFiniteStateMachine"/> in a file. For the document
		/// UTF8 encoding is used. The text indent is 4.
		/// </summary>
		/// <param name="xmlFilePath">The xml file location to save the FSM in.</param>
		/// <param name="fsm">The FSM to serialize.</param>
		/// <param name="attributeSerializerPlugins">A list of registered serializer plugins for <see cref="IAttribute"/>s.</param>
		/// <param name="inputSerializerPlugins">A list of registered serializer plugins for <see cref="IInput"/>s.</param>
		public void Save (FileInfo xmlFilePath, IFiniteStateMachine fsm, Hashtable attributeSerializerPlugins, Hashtable inputSerializerPlugins)
		{
			this.attributeSerializerPlugins = attributeSerializerPlugins;
			this.inputSerializerPlugins = inputSerializerPlugins;

			XmlTextWriter xmlWriter = null;
			try 
			{
				xmlWriter = new XmlTextWriter(xmlFilePath.Name, Encoding.UTF8);
				xmlWriter.Formatting = Formatting.Indented;
				xmlWriter.Indentation= 4;
				xmlWriter.Namespaces = true;
				xmlWriter.WriteStartDocument();

				this.Save(xmlWriter, fsm, attributeSerializerPlugins, inputSerializerPlugins);
			}
			catch (Exception e)
			{
				if(xmlWriter != null) //Write message if possible:
				{
					xmlWriter.WriteComment("***+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++***");
					xmlWriter.WriteComment("*** !!!There occured errors on writing this XML-file!!! This file might be invalid. ***");
					xmlWriter.WriteComment("***+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++***");
				}
				throw e;
			}
			finally
			{
				xmlWriter.Close();
			}
		}

		#endregion

		#region private methods

		/// <summary>
		/// Writes a list of states. For serialization of attribute the according method is used.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeStates(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("List of states of the FSM:");
			xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "States", XMLSerializer.XMLNAMESPACE);

			foreach(IState state in fsm.States)
			{
				xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "State", XMLSerializer.XMLNAMESPACE);

				xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX, "id", XMLSerializer.XMLNAMESPACE, state.ID);
				xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX, "isErrorState", 
					XMLSerializer.XMLNAMESPACE, state.IsErrorState.ToString().ToLower());

				writeAttributes (xmlWriter, state.Attributes);

				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes a list of attributes.
		/// </summary>
		/// <param name="xmlWriter">The writer to use.</param>
		/// <param name="attributeHash">The Hash of attributes to serialize.</param>
		private void writeAttributes (XmlWriter xmlWriter, IAttributeHash attributeHash)
		{
			xmlWriter.WriteComment("List of IAttributes:");
			xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "attributes", XMLSerializer.XMLNAMESPACE);
			xmlWriter.WriteComment("Written by plugin:");
	
			foreach(IAttributeType attrType in attributeHash.AttributeTypes)
			{
				IAttributeSerializerPlugin attrPlugIn = (IAttributeSerializerPlugin) attributeSerializerPlugins[attrType.GUID];
				if (attrPlugIn == null)
				{
					throw new AttributeNotSupportedException(
						"There is no serializer plugin registered for the attribute type " +
						attrType.GUID.ToString() + "; " + attrType.DisplayName);
				}

				IAttribute attr = attributeHash[attrType];
				xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX,"attribute",XMLSerializer.XMLNAMESPACE);
				xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX,"type",XMLSerializer.XMLNAMESPACE,attrType.GUID.ToString());
				xmlWriter.WriteElementString(XMLSerializer.XMLPREFIX+":Description",attrType.Description);
				xmlWriter.WriteElementString(XMLSerializer.XMLPREFIX+":Name",attrType.DisplayName);
				xmlWriter.WriteElementString(XMLSerializer.XMLPREFIX+":ValueType",attrType.ValueType.ToString());
				attrPlugIn.SerializeAttribute(attrType,attr,xmlWriter);
				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// called to write the structure part of the fsm
		/// </summary>
		/// <param name="xmlWriter">the xml writer</param>
		/// <param name="fsm">the finite state machine</param>
		private void WriteStructure(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "Structure", XMLSerializer.XMLNAMESPACE);
			this.writeStartState(xmlWriter, fsm);
			this.writeFinalStates(xmlWriter, fsm);
			this.writeTransitions(xmlWriter, fsm);
			xmlWriter.WriteEndElement();			
		}

		/// <summary>
		/// Write a XML node describing the start state.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeStartState(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("The start state of the FSM:");
			xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "StartState", XMLSerializer.XMLNAMESPACE);
			xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX, "idref", XMLSerializer.XMLNAMESPACE, fsm.StartState.ID);
			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes a list of final states.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeFinalStates(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("List of final states:");
			xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "FinalStates", XMLSerializer.XMLNAMESPACE);

			foreach(IState state in fsm.FinalStates)
			{
				xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "FinalState", XMLSerializer.XMLNAMESPACE);
				xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX, "idref", XMLSerializer.XMLNAMESPACE, state.ID);
				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes a list of transitions.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeTransitions(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("List of transitions:");
			xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "Transitions", XMLSerializer.XMLNAMESPACE);

			foreach(ITransition transition in fsm.Transitions)
			{
				xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "Transition", XMLSerializer.XMLNAMESPACE);
				
				xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "SourceStateRef", XMLSerializer.XMLNAMESPACE);
				xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX, "idref", XMLSerializer.XMLNAMESPACE, transition.SourceState.ID);
				xmlWriter.WriteEndElement();
				xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "DestinationStateRef", XMLSerializer.XMLNAMESPACE);
				xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX, "idref", XMLSerializer.XMLNAMESPACE, transition.DestinationState.ID);
				xmlWriter.WriteEndElement();
				xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "InputSymbolRef", XMLSerializer.XMLNAMESPACE);
				xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX, "idref", XMLSerializer.XMLNAMESPACE, transition.InputSymbol.ID.ToString());
				xmlWriter.WriteEndElement();
				writeAttributes(xmlWriter, transition.Attributes);

				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes a list of input symbol for the given FSM.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeInputAlphabet (XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "InputSymbolAlphabet", XMLSerializer.XMLNAMESPACE);

			foreach (IInput input in fsm.InputAlphabet)
			{
				xmlWriter.WriteStartElement(XMLSerializer.XMLPREFIX, "InputSymbol", XMLSerializer.XMLNAMESPACE);
				xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX, "id", XMLSerializer.XMLNAMESPACE, input.ID.ToString());
				xmlWriter.WriteAttributeString(XMLSerializer.XMLPREFIX, "typeId", XMLSerializer.XMLNAMESPACE, input.TypeID.ToString());

				//the default implementation of IInput doesn't contain any additional attributes. No serializerplugin needed.
				if (!input.TypeID.Equals(FSMFactory.GetInputTypeId()))
				{
					// use Plugin for serialization:
					if(inputSerializerPlugins.ContainsKey(input.TypeID))
						((IInputSerializerPlugin)inputSerializerPlugins[input.TypeID]).SerializeInput(input, xmlWriter);
					else
						throw new InputNotSupportedException(
							"There is no serializer plugin registered for the input type " + input.TypeID.ToString());
				}

				xmlWriter.WriteEndElement(); //end inputSymbol
			}

			xmlWriter.WriteEndElement(); //end alphabet
		}

		#endregion
	}
}
