/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 */

using System;
using System.Diagnostics;
using Palladio.Attributes;
using Palladio.Reliability.Math;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// Attribute containig the Markov Probability of a transition.	
	/// </summary>
	public class TimeAttribute
	{
		#region Properties

		/// <summary>
		/// The value of the TimeAttribute.
		/// </summary>
		public IVariableExpression Time
		{
			get { return time; }
			set { time = value; }
		}


		/// <summary>
		/// Type of the TimeAttribute.
		/// </summary>
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
			return time.ToString();
		}

		/// <summary>
		/// Returns the TimeAttribute of the object. If it
		/// has no TimeAttribute null is returned.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public static TimeAttribute GetAttribute(IAttributable obj)
		{
			return obj.Attributes[AttributeType] as TimeAttribute;
		}

		public static void SetAttribute(IAttributable obj, double aValue)
		{
			TimeAttribute attr = GetAttribute(obj);
			if (attr == null)
			{
				obj.Attributes.Add(AttributeType, new TimeAttribute(aValue));
			}
			else
			{
				attr.Time = new VariableExpression(aValue);
			}
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Create a new TimeAttribute and assigns aValue to it. 
		/// </summary>
		/// <param name="aValue">Probability value. It can only be inbetween 0 and 1.</param>
		public TimeAttribute(double aValue)
		{
			Trace.Assert(aValue >= 0);
			time = new VariableExpression(aValue);
		}

		#endregion

		#region Data

		private IVariableExpression time;
		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("E3D56D31-11E6-481e-8B1C-1BB350B1014B"), "TimeAttribute", typeof (TimeAttribute));

		#endregion
	}
}