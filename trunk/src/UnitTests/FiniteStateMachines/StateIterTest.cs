using System;
using System.Collections;
using NUnit.Framework;
using Palladio.FiniteStateMachines;
using Utils.Collections;

            
namespace UnitTests.FiniteStateMachines
{
	/// <summary>
	/// I knoe that is not usefull to write a test for this, but I know no other way to 
	/// test the functionally of this class
	/// </summary>
	[TestFixture]
	public class StateIterTest
	{
		IFiniteStateMachine fsmOne;
	  StateIterator oneIter;
		Set states;
		IState two,six,seven;
		bool depptest=false;


		[SetUp] public void Init()
		{
			two = new State("two",false,false);
			six = new State("six",false,false);
			seven = new State("seven",false,true);

			this.states = new Set();
			FSMFactory fac = new FSMFactory();
			this.fsmOne = AbstractFSM.Loader("../../data/ForStateIteration1.xml");
			this.oneIter = new StateIterator(this.fsmOne); 
			while(oneIter.MoveNext())
		  {
//				Console.WriteLine("#####ä####Next Staete: "+oneIter.Current);
				this.states.Add(oneIter.Current);
				if(oneIter.Current.Equals(this.six)&& !this.depptest)
				{
				  DeepSearch();
				}
		    
		  }

		}



		[Test]public void DeepTest()
		{
		  Assert.IsTrue(this.depptest);
		}

		private void DeepSearch() 
		{

			this.oneIter.MoveNext();
//			Assert.AreEqual(this.oneIter.Current,six);
//			this.states.Add(this.oneIter.Current);
//			this.oneIter.MoveNext();
			Assert.AreEqual(this.oneIter.Current,seven);
			this.states.Add(this.oneIter.Current);
//			Console.WriteLine(this.oneIter.Current);

			this.depptest = true;
		}

		[Test]public void AllStatesVistedOnce()
		{
			StateIterator newOne = new StateIterator(this.fsmOne);
			ArrayList statesNew = new ArrayList();
			while(newOne.MoveNext())
			{
				if(statesNew.Contains(newOne.Current))
					Assert.AreEqual(true,false);
				statesNew.Add(newOne.Current);
				
			}
			
		}
		[Test]public void AllStatesVisited()
		{
		 
			Set statesFromFSM = new Set();
			statesFromFSM.Add(new State("one",true,false));
			statesFromFSM.Add(new State("two",false,false));
			statesFromFSM.Add(new State("three",false,false));
			statesFromFSM.Add(new State("four",false,false));
			statesFromFSM.Add(new State("five",false,false));
			statesFromFSM.Add(new State("six",false,false));
			statesFromFSM.Add(new State("seven",false,true));
		
			Assert.AreEqual(statesFromFSM,this.states);
		}


		public StateIterTest()
		{
		}


		public static void Main()
		{
			StateIterTest test = new StateIterTest();
			test.Init();
			test.AllStatesVisited();
		}
	}
}
