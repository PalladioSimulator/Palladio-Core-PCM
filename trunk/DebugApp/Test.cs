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
	/// Revision 1.6  2005/08/21 13:58:17  kelsaka
	/// - added use of plugins for deserialisation
	///
	/// Revision 1.5  2005/08/20 12:27:55  kelsaka
	/// - added further attribute handling
	///
	/// Revision 1.4  2005/08/19 16:11:38  kelsaka
	/// - added further deserialisation
	///
	/// Revision 1.3  2005/08/19 09:50:31  kelsaka
	/// - added XPath statements
	///
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
			//st.Init();
			//st.XMLFilenameSaveTest();
			st.AttributeSerialize();
			st.LoadFromFileWithAttributes();

			Console.WriteLine("Press ENTER to close program.");
			Console.ReadLine();
		}
	}
}
#endif