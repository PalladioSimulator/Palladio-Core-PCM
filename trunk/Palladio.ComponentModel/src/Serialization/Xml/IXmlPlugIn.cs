using System.Xml.Schema;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// this interface defines a plugin for the xml serializer.
	/// </summary>
 	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/07/23 18:59:57  joemal
	/// IType now is implemented in external object. Plugins for serializer are created.
	///
	/// Revision 1.1  2005/05/08 12:02:17  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	public interface IXmlPlugIn
	{
		/// <summary>
		/// called by the serializer, when the plugin has been registered.
		/// </summary>
		void Registered();

		/// <summary>
		/// called by the serializer, after the plugin has been unregistered.
		/// </summary>
		void Unregistered();

		/// <summary>
		/// returns the xml schema that can be used to validate the xml file before building the model
		/// </summary>
		string XmlSchema
		{
			get;
		}

		/// <summary>
		/// returns the namespace of the subtree that represents the content of the xml-file that has to
		/// be processed by the plugin.
		/// </summary>
		string XmlNameSpace
		{
			get;
		}
	}
}
