using System;
using NUnit.Framework;
namespace Dispatcher
{
	/// <summary>
	/// Zusammenfassung für DispatcherTest.
	/// </summary>
	/// 
	[TestFixture]
	public class DispatcherTest
	{
		public DispatcherTest()
		{
		}

		[SetUp] public void init()
		{
			HTTPAcceptor acc = new HTTPAcceptor(90);
			Console.WriteLine("starting dispatcher");
		}

		[Test] public void TestSomething()
		{
			Console.WriteLine("testing something");
		}
		public static void Main()
		{
			DispatcherTest test = new DispatcherTest();
			test.init();
		
		}
	}
}
