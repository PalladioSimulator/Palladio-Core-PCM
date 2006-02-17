using System;

namespace CodeBehind
{
	/// <summary>
	/// Zusammenfassung für TestClass.
	/// </summary>
	public class TestClass
	{
		public static void Main()
		{
			FSMHelper helper = new FSMHelper();
			FSMHelper.FSMInfo info = helper.ParseFSMDefString("IDispatcher; 3; 1; 3; 1 - Start - 2; 2 - Stop - 3;");
			Console.WriteLine(info.InterfaceName);
		}
	}
}
