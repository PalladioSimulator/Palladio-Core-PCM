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
	}
}
