using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Decorators;
using NUnit.Framework;
using System;

namespace UnitTests.FiniteStateMachines.Decorators 
{

	/// <summary>
	/// 
	/// </summary>
	[TestFixture]
	public class FiniteCrossProductTest 
	{

		IFiniteStateMachine FSMOne;
		IFiniteStateMachine FSMTwo;
		IFiniteStateMachine FSMResult;

		/// <summary>
		/// 
		/// </summary>
		[SetUp] public void Init() 
		{
			this.FSMOne= AbstractFSM.Loader("../../data/CrossProductSource1.xml");
			this.FSMTwo = AbstractFSM.Loader("../../data/CrossProductSource2.xml");
			this.FSMResult = AbstractFSM.Loader("../../data/CrossProductResult.xml");
		}


		/// <summary>
		/// 
		/// </summary>
		[Test] public void CrossProduct() 
		{
			IFiniteStateMachine result = new FiniteCrossProductMaschine(this.FSMOne,this.FSMTwo).CP;
//			Console.WriteLine("The generated Crossproduct");
//			Console.WriteLine(result.ToString());
//			Assert.IsTrue( AbstractFSM.AreEqual( result, FSMResult ));
		}

		/// <summary>
		/// 
		/// </summary>
		public static void Main() 
		{
			FiniteCrossProductTest test = new FiniteCrossProductTest();
			test.Init();
			test.CrossProduct();
		}
	}
}
