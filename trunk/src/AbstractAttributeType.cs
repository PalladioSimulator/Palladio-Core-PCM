using System;
using System.ComponentModel;
using Palladio.Attributes;
using Palladio.Editor.Common.EntityProxies.Collections;

namespace Palladio.Editor.Common
{
	/// <summary>
	/// Zusammenfassung für AbstractAttributeType.
	/// </summary>
	public abstract class AbstractAttributeType : IAttributeType
	{
		public AbstractAttributeType()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public abstract TypeConverter TypeConverter { get; }

		public abstract AbstractAttributeTypeDescriptor CreateTypeDescriptor(AbstractAttribute attr);

		#region IAttributeType Member

		public virtual string DisplayName
		{
			get
			{
				return "Attribute";
			}
		}

		public virtual string Description
		{
			get
			{
				return "Description";
			}
		}

		public abstract Guid GUID
		{
			get;
		}

		public abstract Type ValueType
		{
			get;
		}

		#endregion

		#region IVisitable Member

		public void AcceptVisitor(ReflectionBasedVisitor.IVisitor visitor)
		{
		}

		#endregion
	}

	/// <summary>
	/// 
	/// </summary>
	public abstract class AbstractAttributeTypeDescriptor : PropertyDescriptor
	{
//		private AttributeHashtable collection = null;
//		private AbstractAttributeType attrType = null;


		/// <summary>
		/// 
		/// </summary>
		/// <param name="name"></param>
		public AbstractAttributeTypeDescriptor(string name) : 
			base( name, null )
		{
//			this.collection = collection;
//			this.attrType = attrType;
		} 

		public abstract TypeConverter TypeConverter { get; }
		

		/// <summary>
		/// 
		/// </summary>
		public override AttributeCollection Attributes
		{
			get 
			{ 
				return new AttributeCollection(null);
			}
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public override bool CanResetValue(object component)
		{
			return true;
		}

		/// <summary>
		/// 
		/// </summary>
		public abstract override Type ComponentType
		{
			get;
		}

		/// <summary>
		/// 
		/// </summary>
		public abstract override string DisplayName
		{
			get;
		}

		/// <summary>
		/// 
		/// </summary>
		public abstract override string Description
		{
			get;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public abstract override object GetValue(object component);

		/// <summary>
		/// 
		/// </summary>
		public override bool IsReadOnly
		{
			get { return false;  }
		}

		/// <summary>
		/// 
		/// </summary>
		public abstract override string Name
		{
			get;
		}

		/// <summary>
		/// 
		/// </summary>
		public abstract override Type PropertyType
		{
			get;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		public override void ResetValue(object component)
		{
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public override bool ShouldSerializeValue(object component)
		{
			return true;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <param name="value"></param>
		public override void SetValue(object component, object value)
		{
			// this.collection[index] = value;
		}
	}
}
