using System;
using Palladio.Attributes;

namespace Palladio.Reliability.WebserverComponentModel
{
	/// <summary>
	/// Zusammenfassung für IDAttribute.
	/// </summary>
	public class DatabaseIDAttribute : IAttribute
	{
		#region Properties

		public long ID
		{
			get { return id; }
			set { id = value; }
		}


		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return id.ToString();
		}

		public static DatabaseIDAttribute GetAttribute(IAttributable obj)
		{
			return obj.Attributes[AttributeType] as DatabaseIDAttribute;
		}

		public static void SetAttribute(IAttributable obj, long id)
		{
			DatabaseIDAttribute attr = GetAttribute(obj);
			if (attr == null)
			{
				obj.Attributes.Add(AttributeType, new DatabaseIDAttribute(id));
			}
			else
			{
				attr.ID = id;
			}
		}

		#endregion

		#region Constructors

		public DatabaseIDAttribute(long id)
		{
			this.id = id;
		}

		#endregion

		#region Data

		private long id;
		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("F2E8343B-7046-4f1d-A20B-21177228BF31"), "LongIDAttribute", typeof (DatabaseIDAttribute));

		#endregion

		public object Clone()
		{
			return new DatabaseIDAttribute(id);
		}

		public override bool Equals(object obj)
		{
			if (obj is DatabaseIDAttribute)
			{
				DatabaseIDAttribute lID = (DatabaseIDAttribute) obj;
				return lID.id == this.id;
			}
			return false;
		}

		public override int GetHashCode()
		{
			return id.GetHashCode();
		}
		#region IAttribute Member

		public void Serialize(System.Xml.XmlTextWriter writer)
		{
			// TODO:  Implementierung von DatabaseIDAttribute.Serialize hinzufügen
		}

		public void Deserialize(System.Xml.XmlNode element)
		{
			// TODO:  Implementierung von DatabaseIDAttribute.Deserialize hinzufügen
		}

		#endregion
	}
}