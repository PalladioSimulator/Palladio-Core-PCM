using System.Reflection;
using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;
using Palladio.Performance.Math;
using Palladio.RegularExpressions;

#if TEST
namespace Palladio.Performance.RegExVisitor.Visitor.Test
{

	[TestFixture]
	public class VisitorTest
	{
		double epsilon=0.01;

		double[] data1 = {0.2,0.4,0.25,0.15};
		double[] data2 = {0.5,0.3,0.2};

		ISequence sequence;
		IAlternative alternative;
		ILoop loop;

		#region time domain

		[Test]
		public void TestSequenceTimeDomain()
		{
			sequence.Predecessor.Attributes.Add(ProbabilityAttribute.AttributeType,
				new ProbabilityAttribute());
			sequence.Successor.Attributes.Add(ProbabilityAttribute.AttributeType,
				new ProbabilityAttribute());

			IRegExASTVisitor visitor = new RegExASTVisitorTimeDomain(sequence,epsilon);
			IDiscretePDFunction f1 = 
				RandomVariable.GetAttribute(sequence.Predecessor).ProbabilityDensityFunction;
			IDiscretePDFunction f2 = 
				RandomVariable.GetAttribute(sequence.Successor).ProbabilityDensityFunction;
			RandomVariable other = new RandomVariable(f1.Convolution(f2));
			Assert.AreEqual(other,visitor.Random);
		}

		[Test]
		public void TestAlternativeTimeDomain()
		{
			double p=0;
			while(p<1)
			{
				alternative.AlternativeOne.Attributes.Add(ProbabilityAttribute.AttributeType,
					new ProbabilityAttribute(p));
				alternative.AlternativeTwo.Attributes.Add(ProbabilityAttribute.AttributeType,
					new ProbabilityAttribute(1-p));
				IRegExASTVisitor visitor = new RegExASTVisitorTimeDomain(alternative,epsilon);
				IDiscretePDFunction f1 = 
					RandomVariable.GetAttribute(alternative.AlternativeOne).ProbabilityDensityFunction;
				IDiscretePDFunction f2 = 
					RandomVariable.GetAttribute(alternative.AlternativeTwo).ProbabilityDensityFunction;
				RandomVariable other = new RandomVariable(f1.GetScaled(p).Add(f2.GetScaled(1-p)));
				Assert.AreEqual(other,visitor.Random);
				p += 0.1;
			}
		}

		[Test]
		public void TestLoopTimeDomain()
		{
			double p = 0.1;
			while(p<0.9)
			{
				loop.InnerExpression.Attributes.Add(ProbabilityAttribute.AttributeType,
					new ProbabilityAttribute(p));
				IRegExASTVisitor visitor = new RegExASTVisitorTimeDomain(loop,epsilon);

				double totalProb = visitor.Random.ProbabilityDensityFunction.TotalProb;
				Assert.IsTrue(totalProb<=1 && totalProb >= 1-(epsilon));
				p += 0.1;
			}
		}

		[Test]
		[ExpectedException(typeof(TargetInvocationException))]
		public void TestLoopTimeDomain2()
		{
			double p=1;
			loop.InnerExpression.Attributes.Add(ProbabilityAttribute.AttributeType,
				new ProbabilityAttribute(p));
			IRegExASTVisitor visitor = new RegExASTVisitorTimeDomain(loop,epsilon);
		}

		#endregion time domain

		#region frequency domain

		[Test]
		public void TestSequenceFrequencyDomain()
		{
			sequence.Predecessor.Attributes.Add(ProbabilityAttribute.AttributeType,
				new ProbabilityAttribute());
			sequence.Successor.Attributes.Add(ProbabilityAttribute.AttributeType,
				new ProbabilityAttribute());

			IRegExASTVisitor visitor = new RegExASTVisitorFrequencyDomain(sequence,epsilon);

			IDiscretePDFunction f1 = 
				RandomVariable.GetAttribute(sequence.Predecessor).ProbabilityDensityFunction;
			IDiscretePDFunction f2 = 
				RandomVariable.GetAttribute(sequence.Successor).ProbabilityDensityFunction;
			RandomVariable other = new RandomVariable(f1.Convolution(f2));
			Assert.AreEqual(other,visitor.Random);
		}

		[Test]
		public void TestAlternativeFrequencyDomain1()
		{
			double pSum=1;
			double p=0;
			while(p<pSum)
			{
				alternative.AlternativeOne.Attributes.Add(ProbabilityAttribute.AttributeType,
					new ProbabilityAttribute(p));
				alternative.AlternativeTwo.Attributes.Add(ProbabilityAttribute.AttributeType,
					new ProbabilityAttribute(1-p));
				IRegExASTVisitor visitor = new RegExASTVisitorFrequencyDomain(alternative,epsilon);

				IDiscretePDFunction f1 = 
					RandomVariable.GetAttribute(alternative.AlternativeOne).ProbabilityDensityFunction;
				IDiscretePDFunction f2 = 
					RandomVariable.GetAttribute(alternative.AlternativeTwo).ProbabilityDensityFunction;
				RandomVariable other = new RandomVariable(f1.GetScaled(p/pSum).Add(f2.GetScaled((1-p)/pSum)));

				Assert.AreEqual(pSum,ProbabilityAttribute.GetAttribute(alternative).Probability);
				Assert.AreEqual(other,visitor.Random);
				p += 0.1;
			}
		}

		[Test]
		public void TestAlternativeFrequencyDomain2()
		{
			double pSum=0.7;
			double p=0;
			while(p<pSum)
			{
				alternative.AlternativeOne.Attributes.Add(ProbabilityAttribute.AttributeType,
					new ProbabilityAttribute(p));
				alternative.AlternativeTwo.Attributes.Add(ProbabilityAttribute.AttributeType,
					new ProbabilityAttribute(pSum-p));
				IRegExASTVisitor visitor = new RegExASTVisitorFrequencyDomain(alternative,epsilon);

				IDiscretePDFunction f1 = 
					RandomVariable.GetAttribute(alternative.AlternativeOne).ProbabilityDensityFunction;
				IDiscretePDFunction f2 = 
					RandomVariable.GetAttribute(alternative.AlternativeTwo).ProbabilityDensityFunction;
				RandomVariable other = new RandomVariable(f1.GetScaled(p/pSum).Add(f2.GetScaled((pSum-p)/pSum)));

				Assert.AreEqual(pSum,ProbabilityAttribute.GetAttribute(alternative).Probability);
				Assert.AreEqual(other,visitor.Random);
				p += 0.1;
			}
		}

		[Test]
		public void TestLoopFrequencyDomain()
		{
			double p=0.1;
			while (p<0.9)
			{
				loop.Attributes.Remove(ProbabilityAttribute.AttributeType);
				loop.InnerExpression.Attributes.Add(ProbabilityAttribute.AttributeType,
					new ProbabilityAttribute(p));
				IRegExASTVisitor visitor = new RegExASTVisitorFrequencyDomain(loop,epsilon);
				Assert.AreEqual(1/(1-p),ProbabilityAttribute.GetAttribute(loop).Probability);
				
				double totalProb = visitor.Random.ProbabilityDensityFunction.TotalProb;
				Assert.IsTrue(totalProb<=1+epsilon && totalProb >= 1-epsilon);

				p += 0.1;
			}
		}

		[Test]
		[ExpectedException(typeof(TargetInvocationException))]
		public void TestLoopFrequencyDomain2()
		{
			double p=1;
			loop.InnerExpression.Attributes.Add(ProbabilityAttribute.AttributeType,
				new ProbabilityAttribute(p));
			IRegExASTVisitor visitor = new RegExASTVisitorFrequencyDomain(loop,epsilon);
		}

		[Test]



		#endregion frequency domain
		
		[TestFixtureSetUp]
		public void Init()
		{
			RandomVariable r1 = new RandomVariable(2,2,data1);
			RandomVariable r2 = new RandomVariable(4,2,data2);

			ISymbol sym1 = RegexFactory.Symbol(FSMFactory.CreateDefaultInput("1"));
			ISymbol sym2 = RegexFactory.Symbol(FSMFactory.CreateDefaultInput("2"));

			sym1.Attributes.Add(RandomVariable.AttributeType,r1);
			sym2.Attributes.Add(RandomVariable.AttributeType,r2);

			sequence=RegexFactory.Sequence(sym1,sym2);
			alternative = RegexFactory.Alternative(sym1,sym2);
			loop= RegexFactory.Loop(sym2);
		}
	}
}
#endif