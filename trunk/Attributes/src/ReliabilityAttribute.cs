/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/12/15 00:05:12  sliver
 * initial checkin after some major refactorings
 *
 * Revision 1.4  2004/11/18 06:53:17  sliver
 * *** empty log message ***
 *
 * Revision 1.3  2004/11/04 08:52:13  sliver
 * added regular expressions
 *
 * Revision 1.2  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.1  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.3  2004/09/09 04:07:52  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.2  2004/07/30 01:25:51  sliver
 * Some changes...
 *
 * Revision 1.1  2004/07/19 04:37:48  sliver
 * extracted attributes
 *
 * 
 */

using System;
using System.Diagnostics;
using Palladio.Attributes;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// Attribute containing the service reliability.
	/// </summary>
	/// <remarks>
	/// 	created by - sliver
	/// 	created on - 13.07.2004 15:33:17
	/// </remarks>
	public class ReliabilityAttribute
	{
		#region Properties

		/// <summary>
		/// The value of the ServiceReliabilityAttribute.
		/// </summary>
		public double Reliability
		{
			get { return reliability; }
			set { reliability = value; }
		}


		/// <summary>
		/// Type of the ServiceReliabilityAttribute.
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
			return reliability.ToString();
		}

		/// <summary>
		/// Returns the ReliabilityAttribute of the object. If it
		/// has no ReliabilityAttribute null is returned.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public static ReliabilityAttribute Get(IAttributable obj)
		{
			return obj.Attributes[AttributeType] as ReliabilityAttribute;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new ServiceReliabilityAttribute and assigns aValue to it. 
		/// </summary>
		/// <param name="aValue">Reliability value. It can only be between 0 and 1.</param>
		public ReliabilityAttribute(double aValue)
		{
			Trace.Assert(aValue >= 0);
			Trace.Assert(aValue <= 1);
			reliability = aValue;
		}

		/// <summary>
		/// Calculates the ServiceReliability out of a Markov Model describing the
		/// usage profile of the service and the reliability of external services.
		/// </summary>
		/// <param name="aMarkovModel">FSM with annotated transition. Each transition 
		/// must contain a MarkovProbabilityAttribute.</param>
		/// <param name="anExtReliabilityHashtable">Hashtable containing information about the reliability of 
		/// the external services used by aMarkovModel.</param>
//		public ReliabilityAttribute(IMarkovModel aMarkovModel, ReliabilityHashtable anExtReliabilityHashtable)
//		{
//			reliability = new ServiceReliability(aMarkovModel, anExtReliabilityHashtable);
//		}

		#endregion

		#region Data
		private double reliability;

		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("497F9B65-C4B4-4de6-9B43-D4452B73244C"), "ServiceReliabilityAttribute", typeof (ReliabilityAttribute));

		#endregion		
	}
}