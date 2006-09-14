using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class ProtocolIModelTest :  AbstractInterfaceModelTest
	{
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			modelOne = Helper.LoadProtIModel("../../data/d1.xml");
			modelOne1 = Helper.LoadProtIModel("../../data/d1.xml");
			modelTwo = Helper.LoadProtIModel("../../data/d2.xml");
			modelIsec = Helper.LoadProtIModel("../../data/intersection.xml");
			modelMerged = Helper.LoadProtIModel("../../data/merged.xml");
		}

		protected override void Modify(ref IInterfaceModel aModel)
		{
			((ProtocolIModel)aModel).Protocol.AddTransition( Helper.CreateTransition("Start","input","Final") );
		}

	}
}
