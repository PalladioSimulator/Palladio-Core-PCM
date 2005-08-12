/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2005/08/12 07:59:20  helgeh
 * Initial impot after refactoring.
 *
 * Math:
 * - Added DiscretePDFunction.
 * - Added Fast Fourier Transformation and FourierFunction.
 * - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
 * - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
 * - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
 *
 * FSMTransformer:
 * - Method SEFFValidity added.
 * - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
 *
 * WebserverSeffFactory:
 * - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
 *
 * WebserverAnalyser:
 * - Data class for configuration added.
 * - ConfigReader added.
 *
 * RegExASTVisitor:
 * - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
 *
 * RegularExpressions:
 * - No changes.
 *
 * XmlSeffParser:
 * - Data class for configuration added.
 * - ConfigReader added.
 *
 * PerformanceCalculator:
 * - Added interface IPerformanceCalculator. Added CalculatorFactory.
 *
 * Unit Tests added.
 * Updated documentation.
 *
 * Revision 1.1  2005/06/03 09:33:42  helgeh
 * *** empty log message ***
 *
 * Revision 1.1  2005/05/18 21:35:08  helgeh
 * *** empty log message ***
 *
 * Revision 1.1  2005/03/16 11:55:25  helgeh
 * initial checkin
 *
 * Revision 1.1  2004/12/15 00:05:14  sliver
 * initial checkin after some major refactorings
 *
 * Revision 1.2  2004/11/08 03:50:06  sliver
 * *** empty log message ***
 *
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */
using Palladio.Attributes;

namespace Palladio.RegularExpressions.DefaultRegEx
{
	/// <summary>
	/// </summary>
	internal class Alternative : AbstractRegEx, IAlternative
	{
		private IRegEx alternativeOne;
		private IRegEx alternativeTwo;

		public Alternative(IAttributeHash attributeHash, IRegEx alternativeOne, IRegEx alternativeTwo) : base(attributeHash)
		{
			this.alternativeOne = alternativeOne;
			this.alternativeTwo = alternativeTwo;
		}

		public IRegEx AlternativeOne
		{
			get { return alternativeOne; }
		}

		public IRegEx AlternativeTwo
		{
			get { return alternativeTwo; }
		}

		public override string ToString()
		{
			return alternativeOne.ToString() + "|" + alternativeTwo.ToString();
		}


		public override bool Equals(object obj)
		{
			if (obj is IAlternative)
			{
				IAlternative alt = (IAlternative) obj;
				return AlternativeOne.Equals(alt.AlternativeOne) && AlternativeTwo.Equals(alt.AlternativeTwo);
			}
			return false;
		}

		public override int GetHashCode()
		{
			return AlternativeOne.GetHashCode() ^ "|".GetHashCode() ^ AlternativeTwo.GetHashCode();
		}
	}
}