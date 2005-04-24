#if TEST
using System;
using System.Collections;
using NUnit.Framework;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

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
	/// Revision 1.19  2005/04/24 14:50:15  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.18  2005/04/23 11:49:54  kelsaka
	/// - refactored enity-builder interface: currently no methods.
	///
	/// Revision 1.17  2005/04/23 11:00:44  kelsaka
	/// - removed Init-Methods from AbstractBuilder - created constructors
	///
	/// Revision 1.16  2005/04/20 19:53:20  kelsaka
	/// - Example and CM-Environment are now using the IBuilderManger
	///
	/// Revision 1.15  2005/04/14 13:43:03  kelsaka
	/// - fixed error in boolean expression for dertermining exception-types
	///
	/// Revision 1.14  2005/04/14 08:19:28  kelsaka
	/// - added new Equals semantic for IType
	/// - added new GetType-method for IType
	///
	/// Revision 1.13  2005/04/14 06:16:34  kelsaka
	/// - fixed bug on listening to name changed events.
	///
	/// Revision 1.12  2005/04/13 21:22:40  kelsaka
	/// - added testcases
	///
	/// Revision 1.11  2005/04/13 20:24:08  kelsaka
	/// - added enitity methods
	///
	/// Revision 1.10  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// Revision 1.9  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.8  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.7  2005/04/11 17:07:18  joemal
	/// use [SetUp] Attribute instead of using the constructor
	///
	/// Revision 1.6  2005/04/09 12:26:28  kelsaka
	/// - added documentation
	///
	/// Revision 1.5  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// Revision 1.4  2005/04/08 14:40:55  kelsaka
	/// - added implementation and unit-tests
	///
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
		private bool executed;

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

		}
		#endregion

		#region general tests

		[SetUp]		
		public void InitTest()
		{
			this.componentModel = new ComponentModelEnvironment();	
			this.rootBuilder = componentModel.BuilderManager.RootBuilder;
			this.executed = false;
		}
		#endregion

		#region root-Tests
		[Test]
		public void RootInit()
		{
			Assert.IsNotNull(this.rootBuilder, "Root is not initialized");
		}

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
			Identifier.IComponentIdentifier c1 = rootBuilder.AddCompositeComponent("CC2").Component.ComponentID;
			Identifier.IComponentIdentifier c2 = rootBuilder.AddCompositeComponent("BC2").Component.ComponentID;
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
			Identifier.IComponentIdentifier c4 = rootBuilder.AddCompositeComponent("CC4").AddBasicComponent("CC4_BC4").Component.ComponentID;
			rootBuilder.RemoveComponent(c4);
		}
		[Test]
		public void JustClearAll()
		{
			rootBuilder.ClearAll();
		}
		[Test]
		public void AddComponentThenClearAll()
		{
			rootBuilder.AddCompositeComponent("Comp");
			rootBuilder.ClearAll();
		}
		#endregion

		#region CC-Builder
		[Test]
		public void CC_AddBCToCCAndRemove()
		{
			Identifier.IComponentIdentifier c5 = rootBuilder.AddCompositeComponent("CC5").AddBasicComponent("CC4_BC4").Component.ComponentID;
			rootBuilder.RemoveComponent(c5);
		}

		[Test]
		public void CC_AddProvidesInterfaceAndRemove()
		{
			Identifier.IInterfaceIdentifier i6 = rootBuilder.AddCompositeComponent("CC6").AddProvidesInterface("IF6").Interface.InterfaceID;
			rootBuilder.RemoveInterface(i6);
		}

		[Test]
		public void CC_AddRequiresInterfaceAndRemove()
		{
			Identifier.IInterfaceIdentifier i7 = rootBuilder.AddCompositeComponent("CC7").AddRequiresInterface("IF7").Interface.InterfaceID;
			rootBuilder.RemoveInterface(i7);
		}

		[Test]
		public void CC_AddInterfacesAndConnections()
		{
			ICompositeComponentTypeLevelBuilder sccb = rootBuilder.AddCompositeComponent("SuperCC8");
			Identifier.IInterfaceIdentifier i8 = rootBuilder.AddInterface("IF8").Interface.InterfaceID;
			
			ICompositeComponentTypeLevelBuilder ccb1 = sccb.AddCompositeComponent("CC8-1");
			ICompositeComponentTypeLevelBuilder ccb2 = sccb.AddCompositeComponent("CC8-2");

			ccb1.AddProvidesInterface(i8);
			ccb2.AddRequiresInterface(i8);

			sccb.AddAssemblyConnector("Connection8", ccb2.Component.ComponentID, i8, ccb1.Component.ComponentID, i8);			
		}

		[Test]
		public void CC_RemoveComponentTwice()
		{
			Identifier.IComponentIdentifier bc9 = rootBuilder.AddBasicComponent("BC9").Component.ComponentID;
			rootBuilder.RemoveComponent(bc9);
			rootBuilder.RemoveComponent(bc9);
		}

		[Test]
		public void CC_AddComponentWithOneNameTwice()
		{
			rootBuilder.AddBasicComponent("BC9");
			rootBuilder.AddBasicComponent("BC9");
		}
		#endregion

		#region BC-Builder
		[Test]
		public void BC_AddInterfacesAndConnections()
		{
			ICompositeComponentTypeLevelBuilder sccb = rootBuilder.AddCompositeComponent("SuperCC10");
			Identifier.IInterfaceIdentifier i10 = rootBuilder.AddInterface("IF10").Interface.InterfaceID;
			
			IBasicComponentTypeLevelBuilder bcb1 = sccb.AddBasicComponent("BC10-1");
			IBasicComponentTypeLevelBuilder bcb2 = sccb.AddBasicComponent("BC10-2");

			bcb1.AddProvidesInterface(i10);
			bcb2.AddRequiresInterface(i10);

			sccb.AddAssemblyConnector("Connection8", bcb2.Component.ComponentID, i10, bcb1.Component.ComponentID, i10);			
		}

		[Test]
		public void BC_RemoveInterface()
		{
			Identifier.IInterfaceIdentifier i11 =  rootBuilder.AddInterface("IF11").Interface.InterfaceID;
			IBasicComponentTypeLevelBuilder bc11 = rootBuilder.AddBasicComponent("BC11");
			bc11.AddProvidesInterface(i11);
			bc11.AddRequiresInterface(i11);

			bc11.RemoveProvidesInterface(i11);
			bc11.RemoveProvidesInterface(i11);
		}

		[Test]
		public void BC_Event_NameChanged()
		{
			IBasicComponentTypeLevelBuilder bc = rootBuilder.AddBasicComponent("BC");
			bc.Component.NameChangedEvent += new StaticAttributeChangedEventHandler(NameChangedListener);

			// provoke event
			bc.Component.Name = "bc2";
			
			Assert.IsTrue(executed, "event-delegate was not called.");
		}

		// This will be called whenever the name changes.
		private void NameChangedListener(object sender) 
		{
			executed = true;
		}

		#endregion

		#region Interface-Builder
		[Test]
		public void IF_AddSignatureAndRemove()
		{
			IInterfaceTypeLevelBuilder iFace = rootBuilder.AddInterface("newInterface");
			Identifier.ISignatureIdentifier si = iFace.AddSignature("newSignature").Signature.SignatureID;
			iFace.RemoveSignature(si);
			
		}

		#endregion

		#region Signature-Builder
		
		[Test]
		public void SIGNATURE_AddAndRemoveParameter()
		{
			IInterfaceTypeLevelBuilder iFace = rootBuilder.AddInterface("newInterface");
			ISignatureTypeLevelBuilder si = iFace.AddSignature("newSignature");
			si.AppendParameter("System.String");
			si.AppendParameter(typeof(IEnumerator), "enumer1");
			si.AppendParameter(typeof(IEnumerator), "enumer2", ParameterModifierEnum.OUT);
			si.AppendParameter(typeof(IEnumerator), "enumer3", ParameterModifierEnum.NONE);
			si.ClearParameterList();
		}

		[Test]
		public void SIGNATURE_ReturnType()
		{
			IInterfaceTypeLevelBuilder iFace = rootBuilder.AddInterface("newInterface");
			ISignatureTypeLevelBuilder si = iFace.AddSignature("newSignature");
			si.SetReturnType("System.String");
			si.SetReturnType(typeof(IEnumerator));
			si.SetReturnTypeVoid();
		}

		[Test]
		[ExpectedException(typeof(TypeNotFoundException))]
		public void SIGNATURE_AddNonExistingTypeAsParameter()
		{
			IInterfaceTypeLevelBuilder iFace = rootBuilder.AddInterface("newInterface");
			ISignatureTypeLevelBuilder si = iFace.AddSignature("newSignature");
			si.SetReturnType("does.not.exist");
		}

		[Test]
		public void SIGNATURE_AddAndRemoveException()
		{
			IInterfaceTypeLevelBuilder iFace = rootBuilder.AddInterface("newInterface");
			ISignatureTypeLevelBuilder si = iFace.AddSignature("newSignature");
			si.AddException(typeof(Palladio.ComponentModel.Exceptions.ComponentHierarchyException));
			si.AddException(typeof(Exception));			
			si.RemoveException(typeof(Palladio.ComponentModel.Exceptions.ComponentHierarchyException));
			si.RemoveException(typeof(Exception));
		}

		[Test]
		public void SIGNATURE_AddAndRemoveExceptionsTwice()
		{
			IInterfaceTypeLevelBuilder iFace = rootBuilder.AddInterface("newInterface");
			ISignatureTypeLevelBuilder si = iFace.AddSignature("newSignature");
			si.AddException(typeof(Exception));
			si.AddException(typeof(Exception));
			si.AddException(typeof(Palladio.ComponentModel.Exceptions.ComponentHierarchyException));
			si.RemoveException(typeof(Exception));
			si.RemoveException(typeof(Exception));
		}

		[Test]
		public void SIGNATURE_RemoveNonExistingException()
		{
			IInterfaceTypeLevelBuilder iFace = rootBuilder.AddInterface("newInterface");
			ISignatureTypeLevelBuilder si = iFace.AddSignature("newSignature");
			si.RemoveException(typeof(Exception));
		}

		[Test]
		public void SIGNATURE_ClearWithoutExistingParameters()
		{
			IInterfaceTypeLevelBuilder iFace = rootBuilder.AddInterface("newInterface");
			ISignatureTypeLevelBuilder si = iFace.AddSignature("newSignature");
			si.ClearParameterList();
		}

		[Test]
		public void SIGNATURE_Event_ExceptionsChanged()
		{
			IInterfaceTypeLevelBuilder iFace = rootBuilder.AddInterface("newInterface");
			ISignatureTypeLevelBuilder si = iFace.AddSignature("newSignature");
			si.Signature.ExceptionsChanged += new StaticAttributeChangedEventHandler(ExceptionsChangedListener);

			// provoke event
			si.AddException(typeof(Exception));

			Assert.IsTrue(executed, "event-delegate was not called.");
		}

		private void ExceptionsChangedListener(object sender)
		{
			executed = true;
		}

		#endregion

		#region Other tests

		[Test]
		public void ITypeEquals()
		{
			IType type1 = EntityFactory.CreateType(typeof(Exception));
			IType type2 = EntityFactory.CreateType(typeof(Exception));
			Assert.IsTrue(type1.Equals(type2));
		}

		#endregion

	}
}

#endif