using System;
using System.Collections;
using FiniteStateMachines;
using FiniteStateMachines.Decorators;
using NUnit.Framework;

namespace UnitTests.FiniteStateMachines.Decorators {

	[TestFixture]
	public class MinimisedFSMTest {

		IFiniteStateMachine originalFSM;
		IFiniteStateMachine minimisedFSM;

		[SetUp] public void Init() {
			originalFSM = AbstractFSM.Loader("../../data/minimisableFSM.xml");
			minimisedFSM = AbstractFSM.Loader("../../data/minimisedFSM.xml");
		}

		[Test] public void Minimise() {
			IFiniteStateMachine result = new MinimisedFSM( originalFSM );
			Assert.IsTrue( AbstractFSM.AreEqual( result, minimisedFSM ));
		}

		public static void Main() {
			MinimisedFSMTest test = new MinimisedFSMTest();
			test.Init();
			test.Minimise();
		}
	}
}
