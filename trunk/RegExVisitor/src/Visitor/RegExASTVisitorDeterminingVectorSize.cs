using System;
using Palladio.Performance.Attributes;
using Palladio.Performance.Math;
using Palladio.RegularExpressions;

namespace Palladio.Performance.RegExVisitor.Visitor
{
	public class RegExASTVisitorDeterminingVectorSize : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		long size;

		/// <summary>
		/// Constructor that also starts the visitor. The Visitor walks through the AST in depth-first order.
		/// </summary>
		/// <param name="node">The root node of the abstract syntax tree.</param>
		/// <param name="epsilon">A threashhold for the computation of the loop.</param>
		public RegExASTVisitorDeterminingVectorSize(IRegEx node, double epsilon) : base(false)
		{
			Visit(node);
		}

		/// <summary>
		/// Computes the weighted sum of the two alternatives.
		/// If the two functions do not have the same sampling rate, the samplingrate must be adjusted. 
		/// </summary>
		/// <param name="alternative"></param>
		public void VisitIAlternative(IAlternative alternative)
		{
		}

		/// <summary>
		/// Computes the convolution of the predecessor und the successor of the sequence.
		/// If the two functions do not have the same sampling rate, the samplingrate must be adjusted.
		/// </summary>
		/// <param name="sequence"></param>
		public void VisitISequence(ISequence sequence)
		{
		}



		/// <summary>
		///  Calculates the loop limit. The calculation will abort if the the maximum value of the i-th 
		///  iteration is smaller than <c>epsilon</c>.
		/// </summary>
		/// <param name="loop"></param>
		public void VisitILoop(ILoop loop)
		{
		}



		/// <summary>
		/// Nothing has to be done when a Symbol is visited. A Symbol must have a RandomVariable.
		/// </summary>
		/// <param name="symbol"></param>
		public void VisitISymbol(ISymbol symbol)
		{
		}

		/// <summary>
		/// The default function which is called if no "VisitTYPE" method is found
		/// by the reflection API
		/// </summary>
		/// <param name="o">The object calling the unknown visitor function</param>
		public override void VisitObject(object o)
		{
			Console.WriteLine("Unkown object type: " + o.GetType().ToString());
		}


		/// <summary>
		/// Adjusts the samplingrate of both <c>RandomVariable</c> to the same value.
		/// </summary>
		/// <param name="r1"></param>
		/// <param name="r2"></param>
		private void AdjustSamplingRate(ref RandomVariable  r1, ref RandomVariable  r2)
		{
			if (r1.ProbabilityDensityFunction.SamplingRate != r2.ProbabilityDensityFunction.SamplingRate)
			{
				// Check for Epsilon Transition
				if (r1.ProbabilityDensityFunction.SamplingRate == 0)
				{
					r1.ProbabilityDensityFunction.SamplingRate=r2.ProbabilityDensityFunction.SamplingRate;
				}
				else if (r2.ProbabilityDensityFunction.SamplingRate == 0)
				{
					r2.ProbabilityDensityFunction.SamplingRate=r1.ProbabilityDensityFunction.SamplingRate;
				}
				else
				{
					long gcd = MathTools.GCD(r1.ProbabilityDensityFunction.SamplingRate,
						r2.ProbabilityDensityFunction.SamplingRate);
					r1.ProbabilityDensityFunction.SamplingRate = gcd;
					r2.ProbabilityDensityFunction.SamplingRate = gcd;
				}
			}
		}

		private int DetermineSamplingRate(IRegEx node)
		{
			switch(typeof(node))
			{
				case typeof(Symbol):

			}



		}
	}
}