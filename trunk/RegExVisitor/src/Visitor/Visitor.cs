using System;
using System.Diagnostics;
using MathNet.Numerics;
using Palladio.Performance.Attributes;
using Palladio.Performance.Math;
using Palladio.RegularExpressions;

namespace Palladio.Performance.RegExVisitor.Visitor
{
	/// <summary>
	/// Visits each node of the abstract syntax tree of a regular expression 
	/// and determins its total time consumption. The Computation of the time consumption uses
	/// vector-multiplication for the sequence and the  Fourier-Transformation for the computation
	/// of the limit of the loop.
	/// 
	/// Therefore, serveral requirements must be fullfilled:
	///  - each input symbol must contain a RansomVariable attribute.
	///  - each input symbol must contain a ProbabilityAttribute
	/// </summary>
	public class RegExASTVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor, IRegExASTVisitor
	{
		private IDiscreteFunctionFactory functionFactory;
		private RandomVariable rand;

		/// <summary>
		/// The <c>RandomVariable</c> contains the result of the calculation.
		/// </summary>
		public RandomVariable Random
		{
			get { return rand; }
		}


		/// <summary>
		/// Constructor that also starts the visitor. The Visitor walks through the AST in depth-first order.
		/// </summary>
		/// <param name="node">The root node of the abstract syntax tree.</param>
		public RegExASTVisitor(IRegEx node) : base(false)
		{
			functionFactory = (IDiscreteFunctionFactory) MathTools.DiscreteFunctions.Clone();

			Visit(node);

			this.rand = RandomVariable.GetAttribute(node);
		}

		/// <summary>
		/// Computes the weighted sum of the two alternatives.
		/// If the two functions do not have the same sampling rate, the samplingrate must be adjusted. 
		/// </summary>
		/// <param name="alternative"></param>
		public void VisitIAlternative(IAlternative alternative)
		{
			Visit(alternative.AlternativeOne);
			Visit(alternative.AlternativeTwo);

			ProbabilityAttribute p1 = ProbabilityAttribute.GetAttribute(alternative.AlternativeOne);
			ProbabilityAttribute p2 = ProbabilityAttribute.GetAttribute(alternative.AlternativeTwo);

			RandomVariable r1 = (RandomVariable) RandomVariable.GetAttribute(alternative.AlternativeOne).Clone();
			RandomVariable r2 = (RandomVariable) RandomVariable.GetAttribute(alternative.AlternativeTwo).Clone();

			double palt = p1.Probability + p2.Probability; // probability of the alternative
			if (palt != 0)
			{
				r1.ProbabilityDensityFunction.Scale(p1.Probability/palt);
				r2.ProbabilityDensityFunction.Scale(p2.Probability/palt);
			}
			else
			{
				r1.ProbabilityDensityFunction.Scale(0);
				r2.ProbabilityDensityFunction.Scale(0);
			}

			AdjustSamplingRate(ref r1, ref r2);

			r1.ProbabilityDensityFunction.Add(r2.ProbabilityDensityFunction);

			ProbabilityAttribute.SetAttribute(alternative, palt);
			RandomVariable.SetAttribute(alternative, r1);

			IDiscretePDFunction df = r1.ProbabilityDensityFunction;
			if (df.TotalProb < 0.99) Debugger.Break();


		}

		/// <summary>
		/// Computes the convolution of the predecessor und the successor of the sequence.
		/// If the two functions do not have the same sampling rate, the samplingrate must be adjusted.
		/// </summary>
		/// <param name="sequence"></param>
		public void VisitISequence(ISequence sequence)
		{
			Visit(sequence.Predecessor);
			Visit(sequence.Successor);

			RandomVariable r1 = RandomVariable.GetAttribute(sequence.Predecessor);
			RandomVariable r2 = RandomVariable.GetAttribute(sequence.Successor);
			ProbabilityAttribute p1 = ProbabilityAttribute.GetAttribute(sequence.Predecessor);
			ProbabilityAttribute p2 = ProbabilityAttribute.GetAttribute(sequence.Successor);

			ProbabilityAttribute.SetAttribute(sequence, p1.Probability*p2.Probability);

			AdjustSamplingRate(ref r1,ref r2);
			RandomVariable fseq = new RandomVariable(
					MathTools.DiscreteFunctions.DiscreteValuePDFunction(
						r1.ProbabilityDensityFunction.Convolution(r2.ProbabilityDensityFunction)));

			RandomVariable.SetAttribute(sequence, fseq);

			IDiscretePDFunction df = fseq.ProbabilityDensityFunction;
			if (df.TotalProb < 0.99) Debugger.Break();
		}


		/// <summary>
		///  Calculates the loop limit. The function values are fourier transformed to calculate the limit.
		///  For the´calculation the data array must be resized to a power of 2. The minimal value is 0,
		///  because for a loop probability less than 1 there is the possability of never entering the loop.
		/// </summary>
		/// <param name="loop"></param>
		public void VisitILoop(ILoop loop)
		{
			Visit(loop.InnerExpression);

			ProbabilityAttribute pin = ProbabilityAttribute.GetAttribute(loop.InnerExpression);
			// actually this is not a probability, since we neglected the
			// probability of leaving the loop. However, the later multiplications
			// fix this problem, because a loop is ever a part of a sequence.
			double ploop = 1/(1 - pin.Probability);
			double p = pin.Probability; // probability of reiterating the loop.
			ProbabilityAttribute.SetAttribute(loop, ploop);

			RandomVariable rin = RandomVariable.GetAttribute(loop.InnerExpression);
			IDiscreteFunction pdf = rin.ProbabilityDensityFunction;


			// transform ProbabilityDensityFunction by the fouriertransformation
			// adjust array size
			// The size of the array could depent on p and variance.

//			pdf.ExpandDomainPo2(0, pdf.XMax*System.Math.Max((int) (8*p), 4));
			pdf.ExpandDomainPo2(0, pdf.XMax);

			// resulting function in time domain
			IDiscreteFunction xLoop = 
				MathTools.DiscreteFunctions.DiscreteValuePDFunction(functionFactory.ConstantFunction(0));
			// fouriertransformation forward
			Complex[] fv = MathTools.FourierTransform.ForwardFromReal(pdf.Data);
			// compute values
			Complex[] resultFrequencyDomain = ComputeLoopLimit(fv, p);
			// fouriertransformation backward
			double[] resultTimeDomain = new double[resultFrequencyDomain.Length];
			resultTimeDomain = MathTools.FourierTransform.BackwardToReal(resultFrequencyDomain);

			xLoop = functionFactory.DiscreteValuePDFunction(0, pdf.SamplingRate, resultTimeDomain);
			xLoop =  xLoop.GetScaled(1 - p);
			xLoop.Crop();

			RandomVariable resultRV = new RandomVariable(xLoop);
			new RandomVariable(xLoop);
			RandomVariable.SetAttribute(loop, resultRV);

			IDiscretePDFunction df = resultRV.ProbabilityDensityFunction;
			if (df.TotalProb < 0.99) Debugger.Break();
		}

		/// <summary>
		/// Computes the limit of the loop.
		/// </summary>
		/// <param name="fv">Fourier transformed values.</param>
		/// <param name="p">Probability of reiterating the loop.</param>
		/// <returns></returns>
		private static Complex[] ComputeLoopLimit(Complex[] fv, double p)
		{
			double alpha = 1;
			double alphaInv = 1/alpha;
			Complex[] resultFrequencyDomain = new Complex[fv.Length];
			for (int i = 0; i < resultFrequencyDomain.Length; i++)
			{
				resultFrequencyDomain[i] = alphaInv + ((p*fv[i])/(1 - p*alpha*fv[i]));
				if (resultFrequencyDomain[i].IsNaN) Debugger.Break();
			}
			return resultFrequencyDomain;
		}


		/// <summary>
		/// Nothing has to be done when a Symbol is visited. A Symbol must have a RandomVariable.
		/// </summary>
		/// <param name="symbol"></param>
		public void VisitISymbol(ISymbol symbol)
		{
			IDiscretePDFunction df = RandomVariable.GetAttribute(symbol).ProbabilityDensityFunction;
			if (df.TotalProb < 0.99) Debugger.Break();
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
	}
}