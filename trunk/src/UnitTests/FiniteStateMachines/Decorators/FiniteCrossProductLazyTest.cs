using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Decorators;
using Utils.Collections;
using System;
using NUnit.Framework;
using System.Collections;

namespace UnitTests.FiniteStateMachines.Decorators 
{

	/// <summary>
	/// 
	/// </summary>
	[TestFixture]
	public class FiniteCrossProductLazyTest 
	{

		IFiniteStateMachine FSMOne;
		IFiniteStateMachine FSMTwo;
		IFiniteStateMachine FSMResult;
		FiniteCrossProductMaschineLazy lazy;
		IState final ;

		/// <summary>
		/// 
		/// </summary>
		[SetUp] public void Init() 
		{
			this.FSMOne= AbstractFSM.Loader("../../data/CrossProductSource1.xml");
			this.FSMTwo = AbstractFSM.Loader("../../data/CrossProductSource2.xml");
			this.FSMResult =  AbstractFSM.Loader("../../data/CrossProductResult.xml");
			this.lazy = new FiniteCrossProductMaschineLazy(this.FSMOne,this.FSMTwo);
			
			
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void OutgoingTransitions()
		{
			IList result = this.FSMResult.GetOutgoingTransitions(new DualState(this.FSMOne.StartState,this.FSMTwo.StartState));
			IList lazyRes = this.lazy.GetOutgoingTransitions(this.lazy.StartState);
			Assert.IsTrue(Array.Equals(result,lazyRes));
			//Assert.AreEqual(result,lazyRes);
			
		}
		
		[Test] public void FinalStates()
		{
			Set mustBe = new Set();
			this.final = new DualState((IState) this.FSMOne.FinalStates[0],(IState)this.FSMTwo.FinalStates[0]);
			mustBe.Add(this.final);
			Assert.AreEqual(mustBe,this.lazy.FinalStates);
		}
		/// <summary>
		/// 
		/// </summary>
		[Test] public void NextStates()
		{
		
			Input a = new Input("a");
			Assert.AreEqual(this.final,this.lazy.GetNextState(this.lazy.StartState,a));

		}

		
		/// <summary>
		/// 
		/// </summary>
		[Test] public void Input()
		{
			Set mustBe = new Set();
			mustBe.Add(new Input("a"));
			mustBe.Add(new Input("b"));
			Assert.AreEqual(mustBe,lazy.InputAlphabet);
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void StartState()
		{
			Assert.AreEqual(this.FSMResult.StartState,this.lazy.StartState);
		}

		/// <summary>
		/// 
		/// </summary>
		public static void Main() 
		{
			FiniteCrossProductLazyTest test = new FiniteCrossProductLazyTest();
			test.Init();
			test.StartState();
			test.FinalStates();

			//test.StartState();
		}
	}
}
