using System;
using System.Xml;
using Palladio.Attributes;

namespace Palladio.Performance.Attributes
{
	/// <summary>
	/// This attribute contains the maximum execution time for the probability
	/// density function of a regular expression. This attribute is needed for the calculation
	/// in frequency domain.
	/// </summary>
	public class MaximumExecutionTimeAttribute : IAttribute
	{

		#region Data

		private long maxExecutionTime;
		private static IAttributeType attributeType = 
			AttributesFactory.Default.CreateAttributeType(new Guid(), "MaximumExecutionTimeAttribute", 
			typeof (MaximumExecutionTimeAttribute));

		#endregion

		#region Properties

		/// <summary>
		/// The value of the MaximumExecutionTimeAttribute.
		/// </summary>
		public long MaxExecutionTime
		{
			get { return maxExecutionTime; }
			set { ValidateExecutionTime(value); maxExecutionTime = value; }
		}
		/// <summary>
		/// Type of the MaximumExecutionTimeAttribute.
		/// </summary>
		/// 
		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		#endregion

		#region Methods

		private void ValidateExecutionTime(long executionTime)
		{
			if(executionTime < 0)
				throw new ApplicationException("The executionTime mus be a positive value.");
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return maxExecutionTime.ToString();
		}

		/// <summary>
		/// Returns the MaximumExecutionTimeAttribute of the object. If it
		/// has no MaximumExecutionTimeAttribute null is returned.
		/// </summary>
		/// <param name="obj"><c>IAttributable</c> for which a <c>MaximumExecutionTimeAttribute</c> is requested.</param>
		/// <returns><c>MaximumExecutionTimeAttribute</c> of the <c>IAttributable</c> or null if it has none.</returns>
		public static MaximumExecutionTimeAttribute GetAttribute(IAttributable obj)
		{
			if(obj.Attributes.Contains(MaximumExecutionTimeAttribute.AttributeType)) 
			{
				return (MaximumExecutionTimeAttribute) obj.Attributes[MaximumExecutionTimeAttribute.AttributeType];
			} 
			else 
			{
				return null;
			}
		}

		/// <summary>
		/// Attaches a MaximumExecutionTimeAttribute to an object.
		/// </summary>
		/// <param name="obj">Object where the Attribute shall be attached.</param>
		/// <param name="aValue">MaximumExecutionTime.</param>
		public static void SetAttribute(IAttributable obj, long aValue)
		{
			MaximumExecutionTimeAttribute attr = GetAttribute(obj);
			if (attr == null)
			{
				obj.Attributes.Add(MaximumExecutionTimeAttribute.AttributeType, new MaximumExecutionTimeAttribute(aValue));
			}
			else
			{
				attr.MaxExecutionTime = aValue;
			}
		}

		/// <summary>
		/// Compares both objects of equality.
		/// </summary>
		/// <param name="obj">Object which is compared with this.</param>
		/// <returns>True if both objects are equal. False else.</returns>
		public override bool Equals(object obj)
		{
			if (obj == null || GetType() != obj.GetType()) return false;
			MaximumExecutionTimeAttribute other = (MaximumExecutionTimeAttribute) obj;
			return this.MaxExecutionTime.Equals(other.MaxExecutionTime);
		}

		/// <summary>
		/// Hash function.
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode() 
		{
			return base.GetHashCode();
		}


		#endregion

		#region Constructors

		/// <summary>
		/// Create a new MaximumExecutionTimeAttribute and assigns aValue to it. 
		/// </summary>
		/// <param name="aValue">Maximum execution time..</param>
		public MaximumExecutionTimeAttribute(long aValue)
		{
			ValidateExecutionTime(aValue);
			maxExecutionTime = aValue;
		}

		/// <summary>
		/// Default Constructor with a maximum execution time of 1.
		/// </summary>
		public MaximumExecutionTimeAttribute()
		{
			maxExecutionTime = 0;
		}
		

		#endregion

		#region IAttribute Member

		/// <summary>
		/// 
		/// </summary>
		/// <param name="writer"></param>
		public void Serialize(XmlTextWriter writer)
		{
			// TODO:  Implementierung von MaximumExecutionTimeAttribute.Serialize hinzufügen
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="element"></param>
		public void Deserialize(XmlNode element)
		{
			// TODO:  Implementierung von MaximumExecutionTimeAttribute.Deserialize hinzufügen
		}

		/// <summary>
		/// Returns a copy of the MaximumExecutionTimeAttribute.
		/// </summary>
		/// <returns></returns>
		public object Clone()
		{
			return new MaximumExecutionTimeAttribute(this.maxExecutionTime);
		}

		#endregion

	}
}
