using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// Zusammenfassung für FactoryTest.
	/// </summary>
	[TestFixture]
	public class FactoryTest
	{

		[SetUp] public void Init() 
		{
		}
		
		[Test] public void Component() 
		{
			ISignature one = new SimpleSignature("one");
			ISignature one1 = new SimpleSignature("one");
			ISignature two = new SimpleSignature("two");
			ISignature three = new SimpleSignature("three");
			ISignature four = new SimpleSignature("four");

		}
	}
}
