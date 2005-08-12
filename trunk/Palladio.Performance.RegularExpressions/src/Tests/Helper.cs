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
 * Revision 1.2  2005/07/07 08:56:49  helgeh
 * *** empty log message ***
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
 * Revision 1.6  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.5  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.4  2004/09/09 04:07:53  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.3  2004/07/30 01:25:51  sliver
 * Some changes...
 *
 * Revision 1.2  2004/07/13 02:14:52  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */


using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.RegularExpressions.Tests
{
	/// <summary>
	/// Description of Helper.	
	/// </summary>
	public class Helper
	{
		/// <summary>
		/// Creates a new transition
		/// </summary>
		/// <param name="sourceState">Source state.</param>
		/// <param name="input">Input symbol.</param>
		/// <param name="destinationState">Destination state.</param>
		/// <returns></returns>
		public static ITransition CreateTransition(string sourceState, IMatchable input, string destinationState)
		{
			return FSMFactory.CreateDefaultTransition(
				FSMFactory.CreateDefaultState(sourceState),
				FSMFactory.CreateDefaultInput(input),
				FSMFactory.CreateDefaultState(destinationState));
		}

		/// <summary>
		/// Creates a new transition
		/// </summary>
		/// <param name="from">Source state.</param>
		/// <param name="input">Input symbol.</param>
		/// <param name="to">Destination state.</param>
		/// <returns></returns>
		public static ITransition CreateTransition(IState from, IInput input, IState to)
		{
			ITransition transition = FSMFactory.CreateDefaultTransition(
				from,
				input,
				to);
			return transition;
		}

		/// <summary>
		/// Creates a new transition
		/// </summary>
		/// <param name="from">Source state.</param>
		/// <param name="m">Input symbol.</param>
		/// <param name="to">Destination state.</param>
		/// <returns></returns>
		public static ITransition CreateTransition(IState from, IMatchable m, IState to)
		{
			ITransition transition = FSMFactory.CreateDefaultTransition(
				from,
				FSMFactory.CreateDefaultInput(m),
				to);
			return transition;
		}

		/// <summary>
		/// Creates a copy of the transition.
		/// </summary>
		/// <param name="transition"></param>
		/// <returns></returns>
		public static ITransition CopyTransition(ITransition transition)
		{
			return CreateTransition(transition.SourceState, transition.InputSymbol, transition.DestinationState);
		}

		/// <summary>
		/// Creates a StateHash out of an array of strings.
		/// </summary>
		/// <param name="anIDArray"></param>
		/// <returns></returns>
		public static StateHash CreateStates(params string[] anIDArray)
		{
			StateHash result = new StateHash();
			foreach (string id in anIDArray)
			{
				IState state = CreateState(id);
				result.Add(state);
			}
			return result;
		}

		/// <summary>
		/// Creates a state with the given ID.
		/// </summary>
		/// <param name="anID"></param>
		/// <returns></returns>
		public static IState CreateState(string anID)
		{
			IState s = FSMFactory.CreateDefaultState(anID);
			return s;
		}

		/// <summary>
		/// Creates an AttributeHash.
		/// </summary>
		/// <returns></returns>
		public static IAttributeHash CreateAttributeHash()
		{
			return AttributesFactory.Default.CreateAttributeHash();
		}

	}
}
