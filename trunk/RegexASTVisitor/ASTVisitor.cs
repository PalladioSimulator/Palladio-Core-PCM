using System;
using System.Diagnostics;
using MathNet.Numerics;
using Palladio.RegularExpressions;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.FSMTransformer;
using Palladio.Reliability.Math;
using ReflectionBasedVisitor;

namespace Palladio.Reliability.RegexASTVisitor
{
	/// <summary>
	/// Visits each node of the abstract syntax tree of a regular expression 
	/// and determins its total time consumption.
	/// 
	/// Therefore, serveral requirements must be fullfilled:
	///  - each input symbol must contain a measured time attribute.
	/// </summary>
	public class ASTVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		private FourierTimeAttribute fourier;
		private IFourierTransform fourierTransform;
		private IDiscreteFunctionFactory functionFactory;
		private IDiscreteFunction timePDF;

		public FourierTimeAttribute Fourier
		{
			get { return fourier; }
		}

		public IDiscreteFunction TimePdf
		{
			get { return timePDF; }
		}

		public ASTVisitor(IRegEx node) : base(false)
		{
			functionFactory = (IDiscreteFunctionFactory)MathTools.DiscreteFunctions.Clone();
			functionFactory.SamplingRate = MeasuredTimeAttribute.SAMPLING_RATE;
			functionFactory.XMin = 0;
			functionFactory.XMax = MeasuredTimeAttribute.SAMPLING_RATE * FourierTimeAttribute.DATA_SIZE;

			fourierTransform = MathTools.SimpleFourierTransform;
			Visit(node);
			
			fourier = FourierTimeAttribute.GetAttribute(node);

			double[] data = fourierTransform.BackwardToReal(fourier.Data);
			timePDF = (IDiscreteFunction)functionFactory.DiscreteValueFunction(0,data);

		}

		public void VisitIAlternative(IAlternative alternative)
		{
			Visit(alternative.AlternativeOne);
			Visit(alternative.AlternativeTwo);

			ProbabilityAttribute p1 = ProbabilityAttribute.GetAttribute(alternative.AlternativeOne);
			ProbabilityAttribute p2 = ProbabilityAttribute.GetAttribute(alternative.AlternativeTwo);

			FourierTimeAttribute f1 = FourierTimeAttribute.GetAttribute(alternative.AlternativeOne);
			FourierTimeAttribute f2 = FourierTimeAttribute.GetAttribute(alternative.AlternativeTwo);

			double palt = p1.Probability + p2.Probability;
			ProbabilityAttribute.SetAttribute(alternative, palt);
			if (palt != 0)
			{
				f1.Scale(p1.Probability / palt);
				f2.Scale(p2.Probability / palt);
			}
			else
			{
				f1.Scale(0);
				f2.Scale(0);
			}

			FourierTimeAttribute falt = f1.Add(f2);
			FourierTimeAttribute.SetAttribute(alternative, falt);
		}

		public void VisitISequence(ISequence sequence)
		{
			Visit(sequence.Predecessor);
			Visit(sequence.Successor);

			ProbabilityAttribute p1 = ProbabilityAttribute.GetAttribute(sequence.Predecessor);
			ProbabilityAttribute p2 = ProbabilityAttribute.GetAttribute(sequence.Successor);

			FourierTimeAttribute f1 = FourierTimeAttribute.GetAttribute(sequence.Predecessor);
			FourierTimeAttribute f2 = FourierTimeAttribute.GetAttribute(sequence.Successor);

			ProbabilityAttribute.SetAttribute(sequence, p1.Probability * p2.Probability ); 
			FourierTimeAttribute fseq = f1.Multiply(f2);
			fseq.Scale(MeasuredTimeAttribute.SAMPLING_RATE);
			FourierTimeAttribute.SetAttribute(sequence, fseq);
		}

		public void VisitILoop(ILoop loop)
		{
			Visit(loop.InnerExpression);

			ProbabilityAttribute pin = ProbabilityAttribute.GetAttribute(loop.InnerExpression);
			FourierTimeAttribute fin = FourierTimeAttribute.GetAttribute(loop.InnerExpression);
			
			// actually this is not a probability, since we neclected the
			// probability of leaving the loop. However, the later multiplications
			// fix this problem...
			double ploop = 1 / (1 - pin.Probability);
			FourierTimeAttribute floop = fin.ComputeLoopLimit(pin.Probability);

			ProbabilityAttribute.SetAttribute(loop, ploop);
			FourierTimeAttribute.SetAttribute(loop, floop);

		}

		/// <summary>
		/// Determine the probability and execution time of a 
		/// basic symbol. Note that the symbol is the result
		/// of the construction process performed before and therefore
		/// must have a certain structure. That is:
		///		ISymbol
		///			UniqueInput
		///				StateInput
		///					State
		///						AttributeHash
		/// </summary>
		/// <param name="symbol"></param>
		public void VisitISymbol(ISymbol symbol)
		{
			UniqueInput uInput = (UniqueInput) symbol.InputSymbol;
			StateInput sInput = (StateInput) uInput.Input;
			MeasuredTimeAttribute time = MeasuredTimeAttribute.GetAttribute(sInput.State);
			ProbabilityAttribute prob = ProbabilityAttribute.GetAttribute(sInput.State);

			ProbabilityAttribute.SetAttribute(symbol, prob.Probability);
			FourierTimeAttribute symbolFourier = GetFourier(time);
			FourierTimeAttribute.SetAttribute(symbol, symbolFourier);

		}

		private FourierTimeAttribute GetFourier(MeasuredTimeAttribute time)
		{
			IDiscreteFunction pdf = GetExpanded((IDiscreteFunction) time.ProbabilityDensityFunction);
			Complex[] data = fourierTransform.ForwardFromReal(pdf.Data);
			return new FourierTimeAttribute(data);
		}

		private IDiscreteFunction GetExpanded(IDiscreteFunction discreteFunction)
		{
			double[] data = new double[FourierTimeAttribute.DATA_SIZE];
			discreteFunction.Data.CopyTo(data,0);
			for (long i = discreteFunction.Data.Length; i < data.Length; i++)
			{
				data[i] = 0;
			}
			return (IDiscreteFunction)functionFactory.DiscreteValueFunction(0,data);
		}

		/// <summary>
		/// The default function which is called if no "VisitTYPE" method is found
		/// by the reflection API
		/// </summary>
		/// <param name="o">The object calling the unknown visitor function</param>
		public override void VisitObject(object o)
		{
			Debug.WriteLine("Unkown object type: "+ o.GetType().ToString());
		}
	}
}
