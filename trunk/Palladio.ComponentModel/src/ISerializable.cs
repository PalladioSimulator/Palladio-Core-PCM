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
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
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
