using System;
using System.Collections;
using System.IO;
using System.Xml;
using Palladio.Attributes;
using Palladio.FiniteStateMachines.Serializer.Interfaces;

namespace Palladio.FiniteStateMachines.Serializer.DefaultImplementation
{
	/// <summary>
	/// Serializer for the Palladio Finite State Machines (FSMs). Handles laoding and saving of
	/// FSMs including <see cref="IAttribute"/>s and <see cref="IInput"/>s.
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
	/// Revision 1.11  2005/08/22 08:46:33  kelsaka
	/// - added use of prefixes and namespaces to loader and writer
	///
	/// Revision 1.10  2005/08/22 06:45:57  kelsaka
	/// - added XSD-Scheme for validation purposes
	///
	/// Revision 1.9  2005/08/21 15:34:54  kelsaka
	/// - completed handling of attributes (deserialisation)
	///
	/// Revision 1.8  2005/08/19 09:50:31  kelsaka
	/// - added XPath statements
	///
	/// Revision 1.7  2005/08/18 09:30:47  kelsaka
	/// - extraced load and save into separate classes
	/// - started implementation of loading from xml
	///
	/// Revision 1.6  2005/08/15 09:51:50  kelsaka
	/// - added further test cases
	/// - use of GUID to identify attribute types
	///
	/// Revision 1.5  2005/08/15 07:59:24  kelsaka
	/// - added futher tests (including test classes)
	///
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
		/// <summary>
		/// The namespace for the Palladio.FSM (URI).
		/// </summary>
		public static string XMLNAMESPACE
		{
			get
			{
				return "http://palladio.informatik.uni-oldenburg.de/Palladio.FiniteStateMachine";
			}
		}

		/// <summary>
		/// The prefix of XML-elements.
		/// </summary>
		public static string XMLPREFIX
		{
			get
			{
				return "fsm";
			}
		}

		/// <summary>
		/// The file name (without location) of the XSD-Scheme of the FSM serialization.
		/// </summary>
		public static string XSDSchemeFileName
		{
			get
			{
				return "Palladio.FiniteStateMachines.xsd";
			}
		}

		/// <summary>
		/// Use the attribute type GUID as key.
		/// </summary>
		private Hashtable attributeSerializerPlugins;

		/// <summary>
		/// Default constructor.
		/// </summary>
		public XMLSerializer()
		{
			attributeSerializerPlugins = new Hashtable();
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
			FSMLoader loader = new FSMLoader();
			//return loader.Load(, attributeSerializerPlugins);
			//TODO: change xmlNode to xmlDocument?
			throw new NotImplementedException();
		}

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a file.
		/// </summary>
		/// <param name="xmlFilePath">Location of the xml file, that contains a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xml file.</returns>
		public IFiniteStateMachine Load (FileInfo xmlFilePath)
		{
			FSMLoader loader = new FSMLoader();
			return loader.Load(xmlFilePath, attributeSerializerPlugins);
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
			FSMWriter writer = new FSMWriter();
			writer.Save(xmlWriter, fsm, attributeSerializerPlugins);
		}

		/// <summary>
		/// Saves the given <see cref="IFiniteStateMachine"/> in a file. For the document
		/// UTF8 encoding is used. The text indent is 4.
		/// </summary>
		/// <param name="xmlFilePath">The xml file location to save the FSM in.</param>
		/// <param name="fsm">The FSM to serialize.</param>
		public void Save (FileInfo xmlFilePath, IFiniteStateMachine fsm)
		{
			FSMWriter writer = new FSMWriter();
			writer.Save(xmlFilePath, fsm, attributeSerializerPlugins);
		}

		#endregion

		#region Plugin handling

		/// <summary>
		/// Adds a serializer for an <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="plugin">The serializer for the attribute.</param>
		/// <param name="attributeType">The attribute type to register for. If there is already an plugin registered
		/// for the <see cref="IAttributeType"/> the new one is used. The GUID is used to identify the attribute
		/// type.</param>
		public void AddAttributeSerializerPlugin (IAttributeSerializerPlugin plugin, IAttributeType attributeType)
		{
			if(attributeSerializerPlugins.ContainsKey(attributeType.GUID))
			{
				attributeSerializerPlugins.Remove(attributeType.GUID);
			}
			attributeSerializerPlugins.Add(attributeType.GUID, plugin);
		}

		/// <summary>
		/// Removes an existing attribute serialiser plugin for the given <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="attributeType">The attribute registration to be removed. The GUID is
		/// used to identify the attribute type.</param>
		public void RemoveAttributeSerializerPlugin (IAttributeType attributeType)
		{
			attributeSerializerPlugins.Remove(attributeType.GUID);
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
