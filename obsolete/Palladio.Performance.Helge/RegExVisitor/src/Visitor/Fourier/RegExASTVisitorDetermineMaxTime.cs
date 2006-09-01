using System;
using Palladio.Performance.Attributes;
using Palladio.Performance.RegExVisitor.Visitor;
using Palladio.RegularExpressions;

namespace Palladio.Performance.RegExVisitor.Visitor
{
	/// <summary>
	/// Zusammenfassung für RegExASTVisitorDetermineMaxTime.
	/// </summary>
	public class RegExASTVisitorDetermineMaxTime : AbstractRegExASTVisitor
	{
		public RegExASTVisitorDetermineMaxTime(double epsilon) : base(epsilon)
		{
		}

		/// <summary>
		/// Visits each alternative.
		/// </summary>
		/// <param name="alternative"></param>
		public override void VisitIAlternative(IAlternative alternative)
		{
			Visit(alternative.AlternativeOne);
			Visit(alternative.AlternativeTwo);
			long maxExecutionTime = System.Math.Max(MaximumExecutionTimeAttribute.GetAttribute(alternative.AlternativeOne).MaxExecutionTime,
				MaximumExecutionTimeAttribute.GetAttribute(alternative.AlternativeTwo).MaxExecutionTime);

			MaximumExecutionTimeAttribute.SetAttribute(alternative,maxExecutionTime);
		}

		/// <summary>
		/// Visits predecessor and successor.
		/// </summary>
		/// <param name="sequence"></param>
		public override void VisitISequence(ISequence sequence)
		{
			Visit(sequence.Predecessor);
			Visit(sequence.Successor);

			long maxExecutionTime = MaximumExecutionTimeAttribute.GetAttribute(sequence.Predecessor).MaxExecutionTime + 
				MaximumExecutionTimeAttribute.GetAttribute(sequence.Successor).MaxExecutionTime;

			MaximumExecutionTimeAttribute.SetAttribute(sequence,maxExecutionTime);
		}

		/// <summary>
		///  Visits inner loop. 
		/// </summary>
		/// <param name="loop"></param>
		public override void VisitILoop(ILoop loop)
		{
			Visit(loop.InnerExpression);

			ProbabilityAttribute prob = 
				ProbabilityAttribute.GetAttribute(loop.InnerExpression);
			int predictedLoopIterations = 
				DetermineNumberOfIterationsForLoop(prob.Probability);

			long maxExecutionTime = MaximumExecutionTimeAttribute.GetAttribute(loop.InnerExpression).MaxExecutionTime;
			maxExecutionTime = maxExecutionTime * predictedLoopIterations;

			MaximumExecutionTimeAttribute.SetAttribute(loop,maxExecutionTime);
		}

		/// <summary>
		/// Visits ISymbol
		/// </summary>
		/// <param name="symbol"></param>
		public override void VisitISymbol(ISymbol symbol)
		{
			long maxExecutionTime =  
				RandomVariable.GetAttribute(symbol).ProbabilityDensityFunction.XMax;
			MaximumExecutionTimeAttribute.SetAttribute(symbol,maxExecutionTime);
		}

		public override void VisitObject(object o)
		{
			throw new NotImplementedException();
		}
	}
}
