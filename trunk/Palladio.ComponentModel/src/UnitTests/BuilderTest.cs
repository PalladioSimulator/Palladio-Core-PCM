#if TEST
using NUnit.Framework;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// Testcases for the builder (not the low level builder).
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/08 08:23:30  joemal
	/// rename class ComponentModel to ComponentModelEnvironment
	/// due to problems with the namespace
	///
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	[TestFixture]	
	public class BuilderTest
	{
		private ComponentModelEnvironment componentModel;
		private IRootTypeLevelBuilder rootBuilder;

		/// <summary>
		/// For debugging purposes.
		/// </summary>
		/// <param name="args">Arguments</param>
		public static void Main(string[] args)
		{
			BuilderTest bt = new BuilderTest();
			bt.AddBCToRoot();
		}

		public BuilderTest()
		{
			InitTest();
		}

		[Test]
		public void InitTest()
		{
			this.componentModel = new ComponentModelEnvironment();	
			this.rootBuilder = componentModel.RootBuilder;
		}

		[Test]
		public void AddInterfaceToRoot()
		{
			rootBuilder.AddInterface("Interface-Name1");
		}

		[Test]
		public void AddCCToRoot()
		{
			rootBuilder.AddCompositeComponent("CC-Name1");
		}

		[Test]
		public void AddBCToRoot()
		{
			rootBuilder.AddBasicComponent("BC-Name1");
		}

	}
}

#endif