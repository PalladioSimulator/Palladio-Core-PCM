using System;
using System.Collections;
using System.IO;
using System.Text;
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
	/// Revision 1.4  2005/08/15 06:44:39  kelsaka
	/// - added handling for attribute serializer plugins
	///
	/// Revision 1.3  2005/08/14 18:18:50  kelsaka
	/// - changed method signature for saving into files
	///
	/// Revision 1.2  2005/08/14 16:22:46  kelsaka
	/// - added writing to xml without use of plugins.
	///
	/// Revision 1.1  2005/08/14 13:43:22  kelsaka
	/// - initial creation of FSM serialization
	///
	/// </code>
	/// </remarks>
	public class XMLSerializer : IXMLSerializer
	{
		private Hashtable attributeSerializers;

		/// <summary>
		/// Default constructor.
		/// </summary>
		public XMLSerializer()
		{
			attributeSerializers = new Hashtable();
		}

		#region public methods

		#region Load methods

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a <see cref="XmlNode"/>.
		/// </summary>
		/// <param name="xmlNode">A xmlNode that represents a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xmlNode.</returns>
		public IFiniteStateMachine Load (XmlNode xmlNode)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a file.
		/// </summary>
		/// <param name="xmlFilePath">Location of the xml file, that contains a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xml file.</returns>
		public IFiniteStateMachine Load (Path xmlFilePath)
		{
			throw new NotImplementedException ();
		}

		#endregion

		#region Save methods

		/// <summary>
		/// Saves the given <see cref="IFiniteStateMachine"/> using the given <see cref="xmlWriter"/>.
		/// </summary>
		/// <param name="xmlWriter">Used to save the FSM.</param>
		/// <param name="fsm">The FSM to serialize.</param>
		/// <remarks>Note: The xmlWriter is NOT closed after writing.</remarks>
		public void Save (XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("Finite State Machine - Palladio Research Group, Software Engineering, University of Oldenburg, Germany");
			xmlWriter.WriteStartElement("Palladio.FiniteStateMachine");

			this.writeStates(xmlWriter, fsm);
			this.writeStartState(xmlWriter, fsm);
			this.writeFinalStates(xmlWriter, fsm);
			this.writeTransitions(xmlWriter, fsm);
			this.writeInputAlphabet(xmlWriter, fsm);

			xmlWriter.WriteEndElement();
		}

		private void writeStates(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("List of states of the FSM:");
			xmlWriter.WriteStartElement("states");

			foreach(IState state in fsm.States)
			{
				xmlWriter.WriteStartElement("state");

				xmlWriter.WriteAttributeString("id", state.ID);
				xmlWriter.WriteAttributeString("isErrorState", state.IsErrorState.ToString());

				writeAttributes (xmlWriter, state.Attributes);

				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		private void writeAttributes (XmlWriter xmlWriter, IAttributeHash attributeHash)
		{
			xmlWriter.WriteComment("List of IAttributes:");
			xmlWriter.WriteStartElement("attributes");
	
			foreach(IAttribute attribute in attributeHash.AttributeTypes)
			{
				xmlWriter.WriteStartElement("attribute");
				xmlWriter.WriteAttributeString("type", attribute.ToString());
				
				if(attributeSerializers.ContainsKey(attribute))
				{
					((IAttributeSerializerPlugin)attributeSerializers[attribute]).SerializeAttribute(attribute, xmlWriter);
				}
				else
				{
					throw new AttributeNotSupportedException(
						"There is no serializer plugin registered for the attribute type " + attribute.ToString());
				}

				xmlWriter.WriteEndElement();
			}
	
			xmlWriter.WriteEndElement();
		}

		private void writeStartState(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("The start state of the FSM:");
			xmlWriter.WriteStartElement("startState");
			xmlWriter.WriteAttributeString("idref", fsm.StartState.ID);
			xmlWriter.WriteEndElement();
		}

		private void writeFinalStates(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("List of final states:");
			xmlWriter.WriteStartElement("finalStates");

			foreach(IState state in fsm.FinalStates)
			{
				xmlWriter.WriteStartElement("finalState");
				xmlWriter.WriteAttributeString("idref", state.ID);
				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		private void writeTransitions(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("List of transitions:");
			xmlWriter.WriteStartElement("transitions");

			foreach(ITransition transition in fsm.Transitions)
			{
				xmlWriter.WriteStartElement("transition");
				
				xmlWriter.WriteAttributeString("sourceStateIdRef", transition.SourceState.ID);
				xmlWriter.WriteAttributeString("destinationStateIdRef", transition.DestinationState.ID);
				writeInputSymbol(xmlWriter, transition);
				writeAttributes(xmlWriter, transition.Attributes);

				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		private void writeInputSymbol (XmlWriter xmlWriter, ITransition transition)
		{
			xmlWriter.WriteStartElement("inputSymbol");

			//TODO: check use of ToString()
			xmlWriter.WriteAttributeString("inputSymbolIdRef", transition.InputSymbol.ID.ToString());
			
			xmlWriter.WriteEndElement();
		}

		private void writeInputAlphabet (XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteStartElement("inputSymbolAlphabet");

			foreach (IInput input in fsm.InputAlphabet)
			{
				xmlWriter.WriteStartElement("inputSymbol");
				//TODO: check use of ToString()
				xmlWriter.WriteAttributeString("inputSymbolId", input.ID.ToString());
				//TODO: plugin use here.
				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Saves the given <see cref="IFiniteStateMachine"/> in a file. For the document
		/// UTF8 encoding is used. The text indent is 4.
		/// </summary>
		/// <param name="xmlFilePath">The xml file location to save the FSM in.</param>
		/// <param name="fsm">The FSM to serialize.</param>
		public void Save (FileInfo xmlFilePath, IFiniteStateMachine fsm)
		{
			XmlTextWriter xmlWriter = new XmlTextWriter(xmlFilePath.Name, Encoding.UTF8);
			xmlWriter.Formatting = Formatting.Indented;
			xmlWriter.Indentation= 4;
			xmlWriter.Namespaces = true;
			xmlWriter.WriteStartDocument();
			xmlWriter.WriteProcessingInstruction("xml-stylesheet", "type='text/xsl' href='PalladioFSM.xsl'");

			this.Save(xmlWriter, fsm);

			xmlWriter.Close();
		}

		#endregion

		#region Plugin handling

		/// <summary>
		/// Adds a serializer for an <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="plugin">The serializer for the attribute.</param>
		/// <param name="attribute">The attribute to register for. If there is already an plugin registered
		/// for the <see cref="IAttribute"/> the new one is used.</param>
		public void AddAttributeSerializerPlugin (IAttributeSerializerPlugin plugin, IAttribute attribute)
		{
			if(attributeSerializers.ContainsKey(attribute))
			{
				attributeSerializers.Remove(attribute);
			}
			attributeSerializers.Add(attribute, plugin);
		}

		/// <summary>
		/// Removes an existing attribute serialiser plugin for the given <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="attribute">The attribute registration to be removed.</param>
		public void RemoveAttributeSerializerPlugin (IAttribute attribute)
		{
			attributeSerializers.Remove(attribute);
		}

		/// <summary>
		/// Adds a serializer for an <see cref="IInput"/>.
		/// </summary>
		/// <param name="plugin">The serializer for the input.</param>
		/// <param name="input">The input to register for.</param>
		public void AddInputSerializerPlugin (IInputSerializerPlugin plugin, IInput input)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Removes an existing input serialiser plugin for the given <see cref="IInput"/>.
		/// </summary>
		/// <param name="input">The input registration to be removed.</param>
		public void RemoveAttributeInputPlugin (IInput input)
		{
			throw new NotImplementedException ();
		}

		#endregion

		#endregion
	}
}
