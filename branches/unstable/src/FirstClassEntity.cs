using System;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für FirstClassEntity.
	/// </summary>
	public abstract class FirstClassEntity : IIdentifiable, ISerializable
	{
		protected GloballyUniqueIdentifier _guid;
		protected string _name;

		public FirstClassEntity()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public IIdentifier ID
		{
			get
			{
				return this._guid;
			}
		}

		public string Name
		{
			get
			{
				return this._name;
			}
			set
			{
				this._name = value;
			}
		}

		public abstract void Serialize(System.Xml.XmlTextWriter writer);
		public abstract void Deserialize(System.Xml.XmlNode node);
	}
}
