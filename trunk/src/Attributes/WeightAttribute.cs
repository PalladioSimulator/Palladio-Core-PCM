using System;
using System.ComponentModel;
using Palladio.Editor.Common;
using Palladio.Editor.Plugins.AnalyzeTest;

namespace Palladio.Editor.Plugins.AnalyzeTest.Attributes
{
	/// <summary>
	/// Zusammenfassung für WeightAttribute.
	/// </summary>
	public class WeightAttribute : AbstractAttribute
	{
		private int _weight;

		public WeightAttribute()
		{

		}
	
		#region IAttribute Member

		public override void Serialize(System.Xml.XmlTextWriter writer)
		{
			writer.WriteStartElement("Weight");
			writer.WriteString(this._weight.ToString());
			writer.WriteEndElement();
		}

		public override void Deserialize(System.Xml.XmlNode element)
		{
			// TODO:  Implementierung von WeightAttribute.Deserialize hinzufügen
		}

		#endregion

		public int Value
		{
			get
			{
				return this._weight;
			}
			set
			{
				this._weight = value;
			}
		}

	}

}
