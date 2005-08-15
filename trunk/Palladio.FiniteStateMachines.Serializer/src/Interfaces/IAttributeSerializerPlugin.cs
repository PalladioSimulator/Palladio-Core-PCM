using System.Xml;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.Serializer
{
	/// <summary>
	/// The interface of plugins that serialize <see cref="IAttribute"/>s. Such a plugin can be registered
	/// for a attribute type and is called to serialize the attribute.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/08/15 07:59:24  kelsaka
	/// - added futher tests (including test classes)
	///
	/// Revision 1.2  2005/08/15 06:44:39  kelsaka
	/// - added handling for attribute serializer plugins
	///
	/// Revision 1.1  2005/08/14 13:43:22  kelsaka
	/// - initial creation of FSM serialization
	///
	/// </code>
	/// </remarks>
	public interface IAttributeSerializerPlugin
	{
		#region public methods

		/// <summary>
		/// Serializes the given attribute and writes the results to the given xmlwriter.
		/// </summary>
		/// <param name="attributeType">The attributes type to serialize. This information has be serialized
		/// as well.</param>
		/// <param name="attribute">The attribute to serialize.</param>
		/// <param name="xmlWriter">The writer to use for serializing attributes.</param>
		void SerializeAttribute(IAttributeType attributeType, IAttribute attribute, XmlWriter xmlWriter);

		#endregion
	}
}
