using System;
using System.Collections;
using System.Reflection;
using NUnit.Framework;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// </summary>
	[TestFixture]
	public class SignatureTest
	{

		[SetUp] public void Init() 
		{
		}
		
		[Test] public void Constructor() 
		{
			DummyOne dOne = new DummyOne();
			DummyTwo dTwo = new DummyTwo();
			IList methodList = dOne.GetType().GetMethods();
			foreach( MethodInfo info in methodList) 
			{
				Console.WriteLine(info.Name);
			}

		}


		// Dummy Methods for testing the reflection
		private class Dummy1
		{
			public void m() 
			{
			}
		}

		private class Dummy2
		{
			public void m() 
			{
			}
		}

		private class Dummy3
		{
			public void m(int b)
			{
			}
		}
		
		private class Dummy4
		{
			public bool m(long b)
			{
				return false;
			}
		}

		private class Dummy5
		{
			public void m(int a)
			{
			}
		}

		private class Dummy6
		{
			public void m(long b)
			{
			}
		}

		private class Dummy7
		{
			public void n(long b)
			{
			}
		}
	}
}
