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

		/// <summary>
		/// 
		/// </summary>
		[SetUp] public void Init() 
		{
			this.FSMOne= AbstractFSM.Loader("../../data/CrossProductSource1.xml");
			this.FSMTwo = AbstractFSM.Loader("../../data/CrossProductSource2.xml");
			this.FSMResult =  new FiniteCrossProductMaschine(this.FSMOne,this.FSMTwo).CP;
			this.lazy = new FiniteCrossProductMaschineLazy(this.FSMOne,this.FSMTwo);
			
			
		}

		/// <summary>
		/// 
		/// </summary>
//		[Test] public void OutgoingTransitions()
//		{
//			IList result = this.FSMResult.GetOutgoingTransitions(this.FSMResult.StartState);
//			IList lazyRes = this.lazy.GetOutgoingTransitions(this.lazy.StartState);
//			Assert.AreEqual(result,lazyRes);
//			
//		}
		
//		[Test] public void NextStates()
//		{
//			Set input = this.lazy.InputAlphabet;
//			foreach(Input i in input)
//			Assert.AreEqual(this.FSMResult.GetNextState(this.FSMResult.StartState,i),this.lazy.GetNextState(this.lazy.StartState,i));
//
//		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void Input()
		{
			Assert.AreEqual(this.FSMResult.InputAlphabet,this.lazy.InputAlphabet);
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void StartState()
		{
			Assert.AreEqual(new DualState(this.FSMOne.StartState,this.FSMTwo.StartState),this.lazy.StartState);
		}

		/// <summary>
		/// 
		/// </summary>
		public static void Main() 
		{
			FiniteCrossProductLazyTest test = new FiniteCrossProductLazyTest();
			test.Init();

			//test.StartState();
		}
	}
}
