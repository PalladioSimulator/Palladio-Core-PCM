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
 * Revision 1.1  2005/03/16 11:55:26  helgeh
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
using Palladio.FiniteStateMachines;
using Palladio.RegularExpressions.DefaultRegEx;
using Palladio.RegularExpressions.GNFA;

namespace Palladio.RegularExpressions
{
	/// <summary>
	/// Factory for creating regular expressions with attributes.
	/// </summary>
	public class RegexFactory
	{
		/// <summary>
		/// Returns a regular expression that accepts the same language as
		/// the FSM.
		/// </summary>
		/// <param name="fsm"></param>
		/// <returns></returns>
		public static IRegEx FSMToRegex(IFiniteStateMachine fsm)
		{
			return FSMToRegexConverter.Convert(fsm);
		}


		/// <summary>
		/// Creates a new alternative / union.
		/// </summary>
		/// <param name="regExOne"></param>
		/// <param name="regExTwo"></param>
		/// <returns></returns>
		public static IAlternative Alternative(IRegEx regExOne, IRegEx regExTwo)
		{
			return new Alternative(CreateAttributeHash(), regExOne, regExTwo);
		}

		/// <summary>
		/// Creates a new alternative / union.
		/// </summary>
		/// <param name="attributeHash"></param>
		/// <param name="regExOne"></param>
		/// <param name="regExTwo"></param>
		/// <returns></returns>
		public static IAlternative Alternative(IAttributeHash attributeHash, IRegEx regExOne, IRegEx regExTwo)
		{
			return new Alternative(attributeHash, regExOne, regExTwo);
		}

		/// <summary>
		/// Creates a sequence  / concatenation.
		/// </summary>
		/// <param name="regExOne"></param>
		/// <param name="regExTwo"></param>
		/// <returns></returns>
		public static ISequence Sequence(IRegEx regExOne, IRegEx regExTwo)
		{
			return new Sequence(CreateAttributeHash(), regExOne, regExTwo);
		}

		/// <summary>
		/// Creates a sequence  / concatenation.
		/// </summary>
		/// <param name="attributeHash"></param>
		/// <param name="regExOne"></param>
		/// <param name="regExTwo"></param>
		/// <returns></returns>
		public static ISequence Sequence(IAttributeHash attributeHash, IRegEx regExOne, IRegEx regExTwo)
		{
			return new Sequence(attributeHash, regExOne, regExTwo);
		}

		/// <summary>
		/// Creates a loop / Kleene star.
		/// </summary>
		/// <param name="regEx"></param>
		/// <returns></returns>
		public static ILoop Loop(IRegEx regEx)
		{
			return new Loop(CreateAttributeHash(), regEx);
		}

		/// <summary>
		/// Creates a loop / Kleene star.
		/// </summary>
		/// <param name="attributeHash"></param>
		/// <param name="regEx"></param>
		/// <returns></returns>
		public static ILoop Loop(IAttributeHash attributeHash, IRegEx regEx)
		{
			return new Loop(attributeHash, regEx);
		}

		/// <summary>
		/// Creates a new symbol from an input symbol.
		/// </summary>
		/// <param name="inputSymbol"></param>
		/// <returns></returns>
		public static ISymbol Symbol(IInput inputSymbol)
		{
			return new Symbol(CreateAttributeHash(), inputSymbol);
		}

		/// <summary>
		/// Creates a new symbol from an input symbol and associated attributeHash to it.
		/// </summary>
		/// <param name="attributeHash"></param>
		/// <param name="inputSymbol"></param>
		/// <returns></returns>
		public static ISymbol Symbol(IAttributeHash attributeHash, IInput inputSymbol)
		{
			return new Symbol(attributeHash, inputSymbol);
		}

		/// <summary>
		/// Creates an empty attribute hash.
		/// </summary>
		/// <returns></returns>
		private static IAttributeHash CreateAttributeHash()
		{
			return AttributesFactory.Default.CreateAttributeHash();
		}
	}
}