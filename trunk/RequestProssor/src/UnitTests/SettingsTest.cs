using System;
using System.IO;
using NUnit.Framework;
using SimpleLogging;

namespace RequestProssor.UnitTests
{
	/// <summary>
	/// Zusammenfassung für SettingsTest.
	/// </summary>
	/// 
	[TestFixture]
	public class SettingsTest
	{
		ServerSettings testSetting;
		SimpleLogger logger;

		[SetUp] 
		public void Init()
		{
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput=true;
			this.logger.DebugOutput = true;

			this.testSetting = new ServerSettings();
		}

		[Test]public void TestGetPhysicalPath()
		{
			//Spec asserts!
			this.testSetting.GetPhysicalPath("/test/dok/img/");
			this.testSetting.GetPhysicalPath("/");
			this.testSetting.GetPhysicalPath("/test/dok/img/hallo.test");


		}
		public SettingsTest()
		{
			
		}
	}
}
