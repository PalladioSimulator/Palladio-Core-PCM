using System.IO;
using System.Xml;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.Serializer.Interfaces
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
	/// Revision 1.6  2005/08/22 16:39:02  kelsaka
	/// - load: validation against xsd added
	///
	/// Revision 1.5  2005/08/21 15:34:54  kelsaka
	/// - completed handling of attributes (deserialisation)
	///
	/// Revision 1.4  2005/08/15 09:51:50  kelsaka
	/// - added further test cases
	/// - use of GUID to identify attribute types
	///
	/// Revision 1.3  2005/08/15 07:59:24  kelsaka
	/// - added futher tests (including test classes)
	///
	/// Revision 1.2  2005/08/14 18:18:50  kelsaka
	/// - changed method signature for saving into files
	///
	/// Revision 1.1  2005/08/14 13:43:22  kelsaka
	/// - initial creation of FSM serialization
	///
	/// </code>
	/// </remarks>
	public interface IXMLSerializer
	{


		#region public methods

		#region Load methods

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a <see cref="XmlNode"/>.
		/// </summary>
		/// <param name="xmlDocument">A xml document that represents a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xmlNode.</returns>
		IFiniteStateMachine Load(XmlDocument xmlDocument);
		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a <see cref="XmlNode"/>.
		/// </summary>
		/// 
		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a file.
		/// </summary>
		/// <param name="xmlFilePath">Location of the xml file, that contains a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xml file.</returns>
		IFiniteStateMachine Load(FileInfo xmlFilePath);

		#endregion

		#region Save methods

		/// <summary>
		/// Saves the given <see cref="IFiniteStateMachine"/> using the given <see cref="xmlWriter"/>.
		/// </summary>
		/// <param name="xmlWriter">Used to save the FSM.</param>
		/// <param name="fsm">The FSM to serialize.</param>
		void Save(XmlWriter xmlWriter, IFiniteStateMachine fsm);

		/// <summary>
		/// Saves the given <see cref="IFiniteStateMachine"/> in a file.
		/// </summary>
		/// <param name="xmlFilePath">The xml file location to save the FSM in.</param>
		/// <param name="fsm">The FSM to serialize.</param>
		void Save(FileInfo xmlFilePath, IFiniteStateMachine fsm);

		#endregion

		#region Plugin handling

		/// <summary>
		/// Adds a serializer for an <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="plugin">The serializer for the attribute.</param>
		/// <param name="attributeType">The attribute type to register for.</param>
		void AddAttributeSerializerPlugin(IAttributeSerializerPlugin plugin, IAttributeType attributeType);

		/// <summary>
		/// Removes an existing attribute serialiser plugin for the given <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="attributeType">The attribute registration to be removed.</param>
		void RemoveAttributeSerializerPlugin(IAttributeType attributeType);

		/// <summary>
		/// Adds a serializer for an <see cref="IInput"/>.
		/// </summary>
		/// <param name="plugin">The serializer for the input.</param>
		/// <param name="input">The input to register for.</param>
		void AddInputSerializerPlugin(IInputSerializerPlugin plugin, IInput input);

		/// <summary>
		/// Removes an existing input serialiser plugin for the given <see cref="IInput"/>.
		/// </summary>
		/// <param name="input">The input registration to be removed.</param>
		void RemoveAttributeInputPlugin(IInput input);

		#endregion

		#endregion
	}
}
