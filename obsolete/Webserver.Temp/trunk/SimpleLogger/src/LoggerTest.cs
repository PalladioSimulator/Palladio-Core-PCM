using System;
using NUnit.Framework;
using System.Diagnostics;
namespace SimpleLogging
{
	[TestFixture]
	public class LoggerTest
	{	
		SimpleLogger prozessor;
		[SetUp]public void init()
		{
			this.prozessor = new SimpleLogger(this);
			this.prozessor.ConsoleOutput = true;
			this.prozessor.DebugOutput=true;
		}


		[Test] public void HandleError()
		{
			this.prozessor.Debug("Das ist ein Test");
		 
		}

		public static void Main()
		{
			LoggerTest test = new LoggerTest();
			test.init();
			test.HandleError();
		}
	}
}
