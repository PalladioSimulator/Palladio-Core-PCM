using System;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Todo: add comments ...
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
