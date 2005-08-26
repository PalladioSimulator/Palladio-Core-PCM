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
	/// Revision 1.12  2005/08/26 13:31:48  kelsaka
	/// - temporarily deactivated validation on load
	///
	/// Revision 1.11  2005/08/26 12:33:49  kelsaka
	/// - workaround for validation error
	///
	/// Revision 1.10  2005/08/26 08:04:21  kelsaka
	/// - fixed validation error
	///
	/// Revision 1.9  2005/08/25 18:43:47  kelsaka
	/// - support for default input serialization.
	///
	/// Revision 1.8  2005/08/24 10:24:07  kelsaka
	/// - added serialization support for default input
	///
	/// Revision 1.7  2005/08/24 08:38:22  kelsaka
	/// - added TypeID for IInputs
	///
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
			/*st.Init();
			st.XMLFilenameSaveTest();
			st.AttributeSerialize();*/
			st.LoadFromFileWithAttributes();
			/*st.LoadFromFileNoAttributesPluginsLoaded();
			st.XMLWriterSaveTest();*/
			//st.LoadFromXmlDocument();

			Console.WriteLine("Press ENTER to close program.");
			Console.ReadLine();
		}
	}
}
#endif