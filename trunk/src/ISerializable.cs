using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für ISerializable.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/09/02 12:50:06  uffi
	/// Added XML Serialization and Deserialization functionality
	///
	///
	/// </pre>
	/// </remarks>
	public interface ISerializable
	{
		void Serialize(System.Xml.XmlTextWriter writer);
		void Deserialize(System.Xml.XmlNode element);
	}
}
