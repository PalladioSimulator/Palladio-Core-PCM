#if DEBUG

using System;

namespace Palladio.FiniteStateMachines.UnitTests
{
	/// <summary>
	/// Debug.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/08/19 07:20:05  kelsaka
	/// - added "console out" to give a hint on the running program
	///
	/// Revision 1.1  2005/08/15 09:51:50  kelsaka
	/// - added further test cases
	/// - use of GUID to identify attribute types
	///
	/// </code>
	/// </remarks>
	public class Test
	{
		/// <summary>
		/// For testing purposes only.
		/// </summary>
		/// <param name="args">unused</param>
		public static void Main(string[] args)
		{
			SerializationTest st = new SerializationTest();
			st.Init();
			st.AttributeSerialize();

			Console.WriteLine("Press ENTER to close program.");
			Console.ReadLine();
		}
	}
}
#endif