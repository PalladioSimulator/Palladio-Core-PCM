#if TEST
using System;
using NUnit.Framework;
using Palladio.FiniteStateMachines;

namespace Palladio.Performance.Attributes.Test
{
	/// <summary>
	/// Zusammenfassung für AttributeTransformerTest.
	/// </summary>
	[TestFixture]
	public class AttributeTransformerTest
	{

		[Test]
		[NUnit.Framework.ExpectedException(typeof(ApplicationException))]
		public void TestProbabilityAttribute1()
		{
			ProbabilityAttribute probabilityAttribute = new ProbabilityAttribute(-1.1);
		}

		[Test]
		public void TestProbabilityAttribute2()
		{
			ProbabilityAttribute probabilityAttribute = new ProbabilityAttribute(1.1);
			Assert.AreEqual(1.1,probabilityAttribute.Probability);
		}

		[Test]
		public void QML2RVTest()
		{
			QMLAttribute qml =
				new QMLAttribute(new double[] {40, 60, 100}, new long[] {20, 40, 60});
			RandomVariable rv = AttributeTransformer.Qml2RandomVariable(qml);
			Assert.AreEqual(20, rv.ProbabilityDensityFunction.SamplingRate);
			Assert.AreEqual(20, rv.ProbabilityDensityFunction.XMin);
			Assert.AreEqual(new double[] {0.4, 0.2, 0.4}, rv.ProbabilityDensityFunction.Data);
		}

		[Test]
		public void QML2RVTest2()
		{
			QMLAttribute qml =
				new QMLAttribute(new double[] {40, 60, 100}, new long[] {20, 30, 60});
			RandomVariable rv = AttributeTransformer.Qml2RandomVariable(qml);
			Assert.AreEqual(10, rv.ProbabilityDensityFunction.SamplingRate);
			Assert.AreEqual(10, rv.ProbabilityDensityFunction.XMin);
			Assert.AreEqual(new double[] {0.2, 0.2, 0.2, 0.133333333333333, 0.133333333333333, 0.133333333333333}, rv.ProbabilityDensityFunction.Data);
		}

		[Test]
		public void QML2RVTest3()
		{
			QMLAttribute qml =
				new QMLAttribute(new double[] {10, 60, 100}, new long[] {0, 30, 60});
			RandomVariable rv = AttributeTransformer.Qml2RandomVariable(qml);
			Assert.AreEqual(30, rv.ProbabilityDensityFunction.SamplingRate);
			Assert.AreEqual(0, rv.ProbabilityDensityFunction.XMin);
			Assert.AreEqual(new double[] {0.1, 0.5, 0.4}, rv.ProbabilityDensityFunction.Data);
		}

		[Test]
		public void QML2RVTest4()
		{
			QMLAttribute qml =
				new QMLAttribute(new double[] {10, 100, 100}, new long[] {0, 30, 60});
			RandomVariable rv = AttributeTransformer.Qml2RandomVariable(qml);
			Assert.AreEqual(30, rv.ProbabilityDensityFunction.SamplingRate);
			Assert.AreEqual(0, rv.ProbabilityDensityFunction.XMin);
			Assert.AreEqual(new double[] {0.1, 0.9}, rv.ProbabilityDensityFunction.Data);
		}

		[Test]
		public void QML2RVTest5()
		{
			QMLAttribute qml =
				new QMLAttribute(new double[] {10, 10, 100}, new long[] {0, 30, 60});
			RandomVariable rv = AttributeTransformer.Qml2RandomVariable(qml);
			Assert.AreEqual(30, rv.ProbabilityDensityFunction.SamplingRate);
			Assert.AreEqual(0, rv.ProbabilityDensityFunction.XMin);
			Assert.AreEqual(new double[] {0.1, 0, 0.9}, rv.ProbabilityDensityFunction.Data);
		}

		[Test]
		[ExpectedException(typeof (ApplicationException))]
		public void QML2RVTestException()
		{
			new QMLAttribute(new double[] {10, 60, 120}, new long[] {0, 30, 60});
		}

		[Test]
		[ExpectedException(typeof (ApplicationException))]
		public void QML2RVTestException2()
		{
			new QMLAttribute(new double[] {10, 100, 60}, new long[] {0, 30, 60});
		}

		[Test]
		[ExpectedException(typeof (ApplicationException))]
		public void QML2RVTestException3()
		{
			new QMLAttribute(new double[] {10, 100, 100, 100}, new long[] {0, 30, 60});
		}

		[Test]
		public void RV2QML2RVTest1()
		{
			RandomVariable rv1 = new RandomVariable(2, 2, new double[] {0.2, 0, 0.7, 0.1});
			QMLAttribute qml = AttributeTransformer.RandomVariable2QML(rv1);
			RandomVariable rv2 = AttributeTransformer.Qml2RandomVariable(qml);
			Assert.AreEqual(rv1, rv2);
		}

		[Test]
		public void RV2QML2RVTest2()
		{
			RandomVariable rv1 = new RandomVariable(4, 2, new double[] {0.2, 0, 0.7, 0.1});
			QMLAttribute qml = AttributeTransformer.RandomVariable2QML(rv1);
			RandomVariable rv2 = AttributeTransformer.Qml2RandomVariable(qml);
			Assert.AreEqual(rv1, rv2);
		}

		[Test]
		public void RV2QMLTest1()
		{
			RandomVariable rv1 = new RandomVariable(2, 2, new double[] {0.2, 0, 0.7, 0.1});
			QMLAttribute qml = AttributeTransformer.RandomVariable2QML(rv1);
			QMLAttribute other = new QMLAttribute(new double[] {20, 20, 90, 100}, new long[] {2, 4, 6, 8});
			Assert.AreEqual(other, qml);
		}

		[Test]
		public void RV2QMLTest2()
		{
			RandomVariable rv1 = new RandomVariable(4, 2, new double[] {0.2, 0, 0.7, 0.1});
			QMLAttribute qml = AttributeTransformer.RandomVariable2QML(rv1);
			QMLAttribute other = new QMLAttribute(new double[] {0, 20, 20, 90, 100}, new long[] {2, 4, 6, 8, 10});
			Assert.AreEqual(other, qml);
		}

		[Test]
		public void MeasureAttribute2RV()
		{
			MeasureAttribute measure = new MeasureAttribute();
			for (int i = 0; i < 3; i++)
			{
				measure.AddMesaure(4);
			}
			for (int i = 0; i < 4; i++)
			{
				measure.AddMesaure(8);
			}
			for (int i = 0; i < 2; i++)
			{
				measure.AddMesaure(12);
			}
			for (int i = 0; i < 1; i++)
			{
				measure.AddMesaure(16);
			}

			RandomVariable rv = AttributeTransformer.MeasureAttribute2RandomVariable(measure, 4);
			RandomVariable other = new RandomVariable(4, 4, new double[] {0.3, 0.4, 0.2, 0.1});
			Assert.AreEqual(other, rv);
		}

		[Test]
		public void MeasureAttribute2RV2()
		{
			MeasureAttribute measure = new MeasureAttribute();
			for (int i = 0; i < 3; i++)
			{
				measure.AddMesaure(4);
			}
			for (int i = 0; i < 4; i++)
			{
				measure.AddMesaure(8);
			}
			measure.AddMesaure(10);
			measure.AddMesaure(12);
			for (int i = 0; i < 1; i++)
			{
				measure.AddMesaure(16);
			}

			RandomVariable rv = AttributeTransformer.MeasureAttribute2RandomVariable(measure, 4);
			RandomVariable other = new RandomVariable(4, 4, new double[] {0.3, 0.4, 0.2, 0.1});
			Assert.AreEqual(other, rv);
		}

		/// <summary>
		/// Test for CreateProbabilityAttributeForTransition().
		/// </summary>
		[Test]
		public void CreateProbabilityAttributeForTransition()
		{
			StateHash stateHash1 = FSMFactory.CreateStatesFromList("1", "2", "3", "4");
			InputSymbolHash inputHash1 = FSMFactory.CreateInputFromList("a", "b");

			IEditableFiniteStateMachine fsm1 = FSMFactory.CreateEmptyFSM();
			fsm1.AddInputSymbols(inputHash1.StoredInputs);
			fsm1.AddStates(stateHash1.StoredStates);
			fsm1.StartState = stateHash1["1"];
			fsm1.FinalStates = new IState[] {stateHash1["4"]};

			ITransition t1 = FSMFactory.CreateDefaultTransition(stateHash1["1"], inputHash1["a"], stateHash1["2"]);
			ITransition t2 = FSMFactory.CreateDefaultTransition(stateHash1["3"], inputHash1["b"], stateHash1["4"]);
			ITransition t3 = FSMFactory.CreateDefaultTransition(stateHash1["1"], inputHash1["b"], stateHash1["4"]);
			ITransition t4 = FSMFactory.CreateDefaultTransition(stateHash1["2"], inputHash1["b"], stateHash1["4"]);
			ITransition t5 = FSMFactory.CreateDefaultTransition(stateHash1["2"], inputHash1["a"], stateHash1["3"]);

			stateHash1["1"].Attributes.Add(MeasureAttribute.AttributeType,sm1);
			stateHash1["2"].Attributes.Add(MeasureAttribute.AttributeType,sm2);
			stateHash1["3"].Attributes.Add(MeasureAttribute.AttributeType,sm3);

			t1.Attributes.Add(MeasureAttribute.AttributeType,tm1);
			t2.Attributes.Add(MeasureAttribute.AttributeType,tm2);
			t3.Attributes.Add(MeasureAttribute.AttributeType,tm3);
			t4.Attributes.Add(MeasureAttribute.AttributeType,tm4);
			t5.Attributes.Add(MeasureAttribute.AttributeType,tm5);
			fsm1.AddTransitions(t1, t2, t3, t4, t5);

			foreach (ITransition transition in fsm1.Transitions)
			{
				transition.Attributes.Add(ProbabilityAttribute.AttributeType,
					AttributeTransformer.CreateProbabilityAttributeForTransition(transition));
			}

			Assert.AreEqual(2.0/3,ProbabilityAttribute.GetAttribute(t1).Probability);
			Assert.AreEqual(1,ProbabilityAttribute.GetAttribute(t2).Probability);
			Assert.AreEqual(1.0/3,ProbabilityAttribute.GetAttribute(t3).Probability);
			Assert.AreEqual(0.75,ProbabilityAttribute.GetAttribute(t4).Probability);
			Assert.AreEqual(0.25,ProbabilityAttribute.GetAttribute(t5).Probability);
		}


		[TestFixtureSetUp]
		public void Init()
		{
			sm1 = new MeasureAttribute();
			sm2 = new MeasureAttribute();
			sm3 = new MeasureAttribute();
			tm1 = new MeasureAttribute();
			tm2 = new MeasureAttribute();
			tm3 = new MeasureAttribute();
			tm4 = new MeasureAttribute();
			tm5 = new MeasureAttribute();
			AddMeasure(sm1,30,10);
			AddMeasure(sm2,20,10);
			AddMeasure(sm3,5,10);
			AddMeasure(tm1,20,10);
			AddMeasure(tm2,5,10);
			AddMeasure(tm3,10,10);
			AddMeasure(tm4,15,10);
			AddMeasure(tm5,5,10);
		}

		private void AddMeasure(MeasureAttribute m, int numberOfMeasures, long time)
		{
			for(int i=0;i<numberOfMeasures;i++)
			{
				m.AddMesaure(time);
			}
		}
		MeasureAttribute tm1,tm2,tm3,tm4,tm5,sm1,sm2,sm3;
	}
}
#endif