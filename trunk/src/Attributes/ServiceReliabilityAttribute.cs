/*
 * $Id$
 * 
 * $Log$
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
using Palladio.Reliability.Math;
using Palladio.Reliability.TypedCollections;
using Palladio.FiniteStateMachines;
 
namespace Palladio.Reliability.Attributes
{
	
	
	/// <summary>
	/// Attribute containing the service reliability.
	/// </summary>
	/// <remarks>
	/// 	created by - sliver
	/// 	created on - 13.07.2004 15:33:17
	/// </remarks>
	public class ServiceReliabilityAttribute
	{
		#region Properties
		
		/// <summary>
		/// The value of the ServiceReliabilityAttribute.
		/// </summary>
		public IVariableExpression ServiceReliability {
			get {
				return reliability;
			}
			set {
				reliability = value;
			}
		}
		
				
		/// <summary>
		/// Type of the ServiceReliabilityAttribute.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get 
			{
				return attributeType;
			}
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
		#endregion
		
		#region Constructors
		
		/// <summary>
		/// Creates a new ServiceReliabilityAttribute and assigns aValue to it. 
		/// </summary>
		/// <param name="aValue">Reliability value. It can only be between 0 and 1.</param>
		public ServiceReliabilityAttribute(double aValue)
		{
			Trace.Assert( aValue >= 0 );
			Trace.Assert( aValue <= 1 );
			reliability = new ServiceReliability(aValue);
		}
		
		/// <summary>
		/// Creates a new ServiceReliabilityAttribute with a variable representing
		/// its reliability value.
		/// </summary>
		/// <param name="aVarName">Name of the Variable.</param>
		public ServiceReliabilityAttribute( string aVarName )
		{
			reliability = new ServiceReliability(aVarName);
		}

		/// <summary>
		/// Calculates the ServiceReliability out of a Markov Model describing the
		/// usage profile of the service and the reliability of external services.
		/// </summary>
		/// <param name="aMarkovModel">FSM with annotated transition. Each transition 
		/// must contain a MarkovProbabilityAttribute.</param>
		/// <param name="anExtReliabilityHash">Hashtable containing information about the reliability of 
		/// the external services used by aMarkovModel.</param>
		public ServiceReliabilityAttribute( IFiniteStateMachine aMarkovModel, ReliabilityHash anExtReliabilityHash )
		{
			reliability = new ServiceReliability(aMarkovModel, anExtReliabilityHash );
		}		
		
		#endregion
		
		#region Data
		
		private IVariableExpression reliability;
		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("d3b88ea3-be07-4ee1-959f-a90cf75ca5c8") ,"ServiceReliabilityAttribute", typeof(ServiceReliabilityAttribute));
		#endregion		
	}
}
