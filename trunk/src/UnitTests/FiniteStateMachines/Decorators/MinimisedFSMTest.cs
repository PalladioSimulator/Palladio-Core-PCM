using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Decorators;
using NUnit.Framework;

namespace UnitTests.FiniteStateMachines.Decorators {

	/// <summary>
	/// 
	/// </summary>
	[TestFixture]
	public class MinimisedFSMTest {

		IFiniteStateMachine originalFSM;
		IFiniteStateMachine minimisedFSM;

		/// <summary>
		/// 
		/// </summary>
		[SetUp] public void Init() {
			originalFSM = AbstractFSM.Loader("../../data/minimisableFSM.xml");
			minimisedFSM = AbstractFSM.Loader("../../data/minimisedFSM.xml");
		}

		/// <summary>
		/// 
		/// </summary>
		[Test] public void Minimise() {
			IFiniteStateMachine result = new MinimisedFSM( originalFSM );
			Assert.IsTrue( AbstractFSM.AreEqual( result, minimisedFSM ));
		}

		/// <summary>
		/// 
		/// </summary>
		public static void Main() {
			MinimisedFSMTest test = new MinimisedFSMTest();
			test.Init();
			test.Minimise();
		}
	}
}
