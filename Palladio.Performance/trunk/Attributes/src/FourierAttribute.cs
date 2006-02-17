using System;
using System.Xml;
using Palladio.Attributes;
using Palladio.Performance.Math;

namespace Palladio.Performance.Attributes
{
	/// <summary>
	/// Attribute containing the fourier transformed probability density function.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/12 07:59:19  helgeh
	/// Initial impot after refactoring.
	///
	/// Math:
	/// - Added DiscretePDFunction.
	/// - Added Fast Fourier Transformation and FourierFunction.
	/// - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
	/// - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
	/// - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
	///
	/// FSMTransformer:
	/// - Method SEFFValidity added.
	/// - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
	///
	/// WebserverSeffFactory:
	/// - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
	///
	/// WebserverAnalyser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// RegExASTVisitor:
	/// - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
	///
	/// RegularExpressions:
	/// - No changes.
	///
	/// XmlSeffParser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// PerformanceCalculator:
	/// - Added interface IPerformanceCalculator. Added CalculatorFactory.
	///
	/// Unit Tests added.
	/// Updated documentation.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class FourierAttribute : IAttribute
	{
		#region Data

		/// <summary>
		/// Fourier transformed probability density function.
		/// </summary>
		private IFourierFunction function;

		/// <summary>
		/// Attribute type.
		/// </summary>
		private static IAttributeType attributeType = 
			AttributesFactory.Default.CreateAttributeType(new Guid(), "FourierAttribute",
			typeof (FourierAttribute));

		#endregion Data

		#region Properties
		/// <summary>
		/// Fourier transformed probability density function.
		/// </summary>
		public IFourierFunction Function
		{
			get
			{
				return function;
			}
		}

		/// <summary>
		/// Type of the FourierTimeAttribute.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		#endregion Properties
		
		#region Constructor
		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="ff">Fourier transformed function.</param>
		public FourierAttribute(IFourierFunction ff)
		{
			this.function=ff;
		}

		#endregion Constructor

		#region static methods

		/// <summary>
		/// Returns the FourierAttribute of the <c>IAttributable</c>. If it
		/// has no FourierTimeAttribute null is returned.
		/// </summary>
		/// <param name="obj"><c>IAttributable</c> for which the FourierAttribute is requested.</param>
		/// <returns><c>FourierAttribute</c> of the <c>IAttributable</c> or null if it has no.</returns>
		public static FourierAttribute GetAttribute(IAttributable obj)
		{
			return (FourierAttribute) obj.Attributes[FourierAttribute.AttributeType];
		}


		/// <summary>
		/// Attaches a <c>FourierAttribute</c> to an object.
		/// </summary>
		/// <param name="obj"><c>IAttributable</c> to which the FourierAttribute shall be added.</param>
		/// <param name="fourier">The <c>FourierAttribute</c> which shall be added to the object.</param>
		public static void SetAttribute(IAttributable obj, FourierAttribute fourier)
		{
			obj.Attributes.Add(FourierAttribute.AttributeType, fourier);
		}


		#endregion static methods

		#region IAttribute Member

		/// <summary>
		/// 
		/// </summary>
		/// <param name="writer"></param>
		public void Serialize(XmlTextWriter writer)
		{
			// TODO:  Implementierung von FourierTimeAttribute.Serialize hinzufügen
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="element"></param>
		public void Deserialize(XmlNode element)
		{
			// TODO:  Implementierung von FourierTimeAttribute.Deserialize hinzufügen
		}

		/// <summary>
		/// Creates a Copy of the <c>FourierAttribute</c>.
		/// </summary>
		/// <returns></returns>
		public object Clone()
		{
			return new FourierAttribute((IFourierFunction) this.function.Clone());
		}
		#endregion

	}
}