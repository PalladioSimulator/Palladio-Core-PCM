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
 * Revision 1.2  2005/05/09 14:27:10  helgeh
 * Berechnung lauffähig
 *
 * Revision 1.1  2005/03/16 11:55:25  helgeh
 * initial checkin
 *
 * Revision 1.1  2004/12/15 00:05:14  sliver
 * initial checkin after some major refactorings
 *
 * Revision 1.1  2004/11/04 08:52:14  sliver
 * added regular expressions
 *
 */
using System;
using System.Text.RegularExpressions;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.RegularExpressions.DefaultRegEx
{
	/// <summary>
	/// </summary>
	internal abstract class AbstractRegEx : IRegEx
	{
		public AbstractRegEx(IAttributeHash attributeHash)
		{
			this.attributeHash = attributeHash;
		}

		/// <summary>
		/// A match is a more specialised comparison of two objects.
		/// </summary>
		/// <param name="other">Another object which should be matched.</param>
		/// <returns>True, if this object an the other object match, false otherwise.</returns>
		public bool Match(IMatchable other)
		{
			return this.Equals(other);
		}

		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public IAttributeHash Attributes
		{
			get { return attributeHash as IAttributeHash; }
		}

		public IMatchable ID
		{
			get { return this; }
		}

		private IAttributeHash attributeHash;

		/// <summary>
		/// Added for further development. 
		/// </summary>
		public Regex Expression
		{
			get { throw new NotImplementedException(); }
		}

		/// <summary>
		/// Added for further development. 
		/// </summary>
		public void Simplify()
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// Added for further development. 
		/// </summary>
		public bool Accept(params IInput[] word)
		{
			throw new NotImplementedException();
		}
		#region IAttribute Member

		public void Serialize(System.Xml.XmlTextWriter writer)
		{
			// TODO:  Implementierung von RandomVariable.Serialize hinzufügen
		}

		public void Deserialize(System.Xml.XmlNode element)
		{
			// TODO:  Implementierung von RandomVariable.Deserialize hinzufügen
		}

		public object Clone(){return null;}

		#endregion
	}
}