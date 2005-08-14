using System;
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
		/// <param name="xmlNode">A xmlNode that represents a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xmlNode.</returns>
		IFiniteStateMachine Load(XmlNode xmlNode);

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a file.
		/// </summary>
		/// <param name="xmlFilePath">Location of the xml file, that contains a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xml file.</returns>
		IFiniteStateMachine Load(Path xmlFilePath);

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
		void Save(Path xmlFilePath, IFiniteStateMachine fsm);

		#endregion

		#region Plugin handling

		/// <summary>
		/// Adds a serializer for an <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="plugin">The serializer for the attribute.</param>
		/// <param name="attribute">The attribute to register for.</param>
		void AddAttributeSerializerPlugin(IAttributeSerializerPlugin plugin, IAttribute attribute);

		/// <summary>
		/// Removes an existing attribute serialiser plugin for the given <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="attribute">The attribute registration to be removed.</param>
		void RemoveAttributeSerializerPlugin(IAttribute attribute);

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
