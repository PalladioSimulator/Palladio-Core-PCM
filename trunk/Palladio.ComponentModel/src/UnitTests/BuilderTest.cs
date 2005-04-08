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
	/// Revision 1.3  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
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

		#region for static use
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
		#endregion

		#region general tests
		[Test]
		public void InitTest()
		{
			this.componentModel = new ComponentModelEnvironment();	
			this.rootBuilder = componentModel.RootBuilder;
		}
		#endregion

		#region root-Tests
		[Test]
		public void AddBCToRoot()
		{
			rootBuilder.AddBasicComponent("BC1");
		}

		[Test]
		public void AddCCToRoot()
		{
			rootBuilder.AddCompositeComponent("CC1");
		}

		[Test]
		public void RemoveCCandBCFromRoot()
		{
			Identifier.IComponentIdentifier c1 = rootBuilder.AddCompositeComponent("CC2").ComponentID;
			Identifier.IComponentIdentifier c2 = rootBuilder.AddCompositeComponent("BC2").ComponentID;
			rootBuilder.RemoveComponent(c1);
			rootBuilder.RemoveComponent(c2);
		}

		[Test]
		public void AddInterfaceToRoot()
		{
			rootBuilder.AddInterface("Interface-Name1");
		}

		[Test]
		public void AddCC_BCToRoot()
		{
			rootBuilder.AddCompositeComponent("CC3").AddBasicComponent("CC3_BC3");
		}

		[Test]
		public void RemoveInternalCC_BCFromRoot()
		{
			Identifier.IComponentIdentifier c4 = rootBuilder.AddCompositeComponent("CC4").AddBasicComponent("CC4_BC4").ComponentID;
			rootBuilder.RemoveComponent(c4);
		}
		#endregion
	}
}

#endif