using System;

namespace Palladio.Attributes
{
	/// <summary>
	/// Zusammenfassung für IAttribute.
	/// </summary>
	public interface IAttribute
	{
		void Serialize(System.Xml.XmlTextWriter writer);
		void Deserialize(System.Xml.XmlNode element);
	}
}
