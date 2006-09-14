using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;
using Utils.Collections;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class ServiceTest
	{
		Service srvOne, srvTwo, srvThree;
		
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			srvOne = Helper.CreateService("d1", "../../data/d1.xml");
			srvTwo = Helper.CreateService("d2", "../../data/d2.xml");
			srvThree = Helper.CreateService("d1", "../../data/d1.xml");
		}

		/// <summary>
		/// </summary>
		[Test] public void Equals()
		{
			Assert.IsTrue(srvOne.Equals(srvThree));
			Assert.IsFalse(srvTwo.Equals(srvOne));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			Service srv = (Service)srvOne.Clone();
			srv.Equals(srvThree);
		}
	}
}
