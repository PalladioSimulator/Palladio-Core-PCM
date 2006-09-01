using System;
using System.ComponentModel;
using Palladio.Editor.Common;

namespace Palladio.Editor.Plugins.AnalyzeTest.Attributes
{
	/// <summary>
	/// Zusammenfassung für WeightAttributeType.
	/// </summary>
	public class WeightAttributeType : AbstractAttributeType
	{

		private TypeConverter _typeConverter;

		public WeightAttributeType()
		{
			this._typeConverter = new Int32Converter();
		}

		public override TypeConverter TypeConverter
		{
			get { return this._typeConverter; }
		}

		public override AbstractAttributeTypeDescriptor CreateTypeDescriptor(AbstractAttribute attr)
		{
			if (attr is WeightAttribute)
				return new WeightAttributeTypeDescriptor(this, attr as WeightAttribute);
			else return null;
		}

		#region IAttributeType Member
		public override string DisplayName
		{
			get { return "Weight"; }
		}

		public override string Description
		{
			get { return "Positive integer value indicating the weight of the entity"; }
		}

		public override Guid GUID
		{
			get { return new Guid ("AD6B2DF5-75FB-4b8b-8D7B-51E0B6394615"); }
		}

		public override Type ValueType
		{
			get { return typeof(WeightAttribute); }
		}

		#endregion
	}


	public class WeightAttributeTypeDescriptor : AbstractAttributeTypeDescriptor
	{
		private WeightAttributeType attrType;
		private WeightAttribute attr;

		public WeightAttributeTypeDescriptor(WeightAttributeType attrType, WeightAttribute attr) : 
			base( attrType.DisplayName )
		{
			this.attrType = attrType;
			this.attr = attr;
		} 

		public override TypeConverter TypeConverter
		{
			get { return this.attrType.TypeConverter; }
		}

		/// <summary>
		/// 
		/// </summary>
		public override Type ComponentType
		{
			get { return this.attrType.GetType(); }
		}

		/// <summary>
		/// 
		/// </summary>
		public override string DisplayName
		{
			get { return this.attrType.DisplayName; }
		}

		/// <summary>
		/// 
		/// </summary>
		public override string Description
		{
			get { return this.attrType.Description; }
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <returns></returns>
		public override object GetValue(object component)
		{
			return this.attr.Value;
		}


		/// <summary>
		/// 
		/// </summary>
		public override string Name
		{
			get { return this.attrType.DisplayName; }
		}

		/// <summary>
		/// 
		/// </summary>
		public override Type PropertyType
		{
			get { return this.attr.GetType(); }
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="component"></param>
		/// <param name="value"></param>
		public override void SetValue(object component, object value)
		{
			this.attr.Value = Int32.Parse(value.ToString());
		}
	}
}
