#if TEST
using System;
using NUnit.Framework;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.UnitTests
{
	/// <summary>
	/// Testcases for the builders events.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.8  2005/10/23 16:26:42  kelsaka
	/// - extracted event interfaces to make the events adaptable
	/// - made event classes internal
	///
	/// Revision 1.7  2005/10/19 16:35:11  joemal
	/// xxx
	///
	/// Revision 1.6  2005/10/19 14:21:43  kelsaka
	/// - test-fix
	///
	/// Revision 1.5  2005/10/17 11:47:27  kelsaka
	/// - extended test case
	///
	/// Revision 1.4  2005/10/16 10:41:26  kelsaka
	/// - added test to show problems with CM-use in Palladio Editor.
	///
	/// Revision 1.3  2005/09/28 08:38:25  joemal
	/// add role to rem. interface event
	///
	/// Revision 1.2  2005/09/26 17:55:29  joemal
	/// now the remove event of a connection contains some more parameters
	///
	/// Revision 1.1  2005/09/22 18:45:15  joemal
	/// xxx
	///
	[TestFixture]	
	public class EventsTest
	{
		private ComponentModelEnvironment componentModel;
		private string sequenze;
		private bool errorFlag=false;
		private bool flag01 = false;
		private bool flag02 = false;

		[SetUp]
		public void Init()
		{
			sequenze="";
			componentModel = new ComponentModelEnvironment();
			errorFlag = false;
		}

		[Test]
		public void AddRemoveFromStaticView()
		{
			IStaticViewEvents ev = componentModel.EventInterface.GetStaticViewEvents();
			ev.ComponentAddedEvent +=new ComponentUseEventHandler(ComponentAdded);
			ev.ComponentRemovedEvent +=new ComponentUseEventHandler(ComponentRemoved);
			ev.AssemblyConnectorAddedEvent += new AssemblyConnectorBuildEventHandler(AssemblyConnectorAdded);
			ev.AssembyConnectorRemovedEvent +=new ConnectorRemovedEventHandler(AssemblyConnectorRemoved);

			StaticComponentModel.Create(this.componentModel);
			Assert.AreEqual(sequenze,"+Comp+Comp+Asm");
			this.componentModel.BuilderManager.RootTypeLevelBuilder.RemoveComponent(StaticComponentModel.CCWRITEID);
			Assert.AreEqual(sequenze,"+Comp+Comp+Asm-Asm-Comp");
			this.componentModel.BuilderManager.RootTypeLevelBuilder.RemoveComponent(StaticComponentModel.BCWRITEBEID);
			Assert.AreEqual(sequenze,"+Comp+Comp+Asm-Asm-Comp-Comp");

			if (errorFlag == true)
				throw new AssertionException("In one of the event methods failed an assertion."+
					"The silly dataset catched my exceptions so i've to go this way. Watch the console logs for details.");
		}

		[Test]
		public void AddRemoveFromCC()
		{
			StaticComponentModel.Create(this.componentModel);
			ICompositeComponentEvents ev = componentModel.EventInterface.
				GetCompositeComponentEvents(StaticComponentModel.CCWRITEID);
			ev.ComponentAddedEvent +=new ComponentUseEventHandler(ComponentAdded);
			ev.ComponentRemovedEvent +=new ComponentUseEventHandler(ComponentRemoved);
			ev.AssemblyConnectorAddedEvent += new AssemblyConnectorBuildEventHandler(AssemblyConnectorAdded);
			ev.DelegationConnectorAddedEvent +=new DelegationConnectorBuildEventHandler(DelegationConnectorAdded);
			ev.ConnectorRemovedEvent +=new ConnectorRemovedEventHandler(ConnectorRemoved);

			Assert.AreEqual(sequenze,"");
			this.componentModel.BuilderManager.RootTypeLevelBuilder.DestroyComponent(StaticComponentModel.CCWRITEID);
			Assert.AreEqual(sequenze,"-Con-Con-Comp");
			if (errorFlag == true)
				throw new AssertionException("In one of the event methods failed an assertion."+
					"The silly dataset catched my exceptions so i've to go this way. Watch the console logs for details.");
		}

		[Test]
		public void AddRemoveInterface()
		{
			StaticComponentModel.Create(this.componentModel);
			IComponentEvents ev = componentModel.EventInterface.GetComponentEvents(StaticComponentModel.BCWRITEID);
			ev.InterfaceRemovedEvent +=new InterfaceUseEventHandler(ev_InterfaceRemovedEvent);
			IBasicComponentTypeLevelBuilder bc =
				this.componentModel.BuilderManager.GetBasicComponentTypeLevelBuilder(StaticComponentModel.BCWRITEID);

			bc.RemoveProvidesInterface(StaticComponentModel.IWRITERID);
			Assert.AreEqual("-provif",sequenze);
			bc.RemoveRequiresInterface(StaticComponentModel.IWRITERBEID);
			Assert.AreEqual("-provif-reqif",sequenze);
		}

		[Test]
		public void QueryInterfaceAfterCreationEvent()
		{
			componentModel.EventInterface.GetRepositoryEvents().InterfaceAddedEvent += new InterfaceBuildEventHandler(EventsTest_InterfaceAddedEvent);
			IInterfaceIdentifier interfaceID = componentModel.BuilderManager.RootTypeLevelBuilder.CreateInterface("if1").InterfaceId;

			Assert.IsTrue(flag02, "No Creation Event.");

			componentModel.EventInterface.GetInterfaceEvents(interfaceID);			
			componentModel.Query.QueryRepository.GetInterface(interfaceID).Name = "..";
			Assert.IsTrue(flag01, "NameChangedEvent not raised.");
		}

		private void EventsTest_NameChangedEvent(object sender)
		{
			flag01 = true;
		}

		private void EventsTest_InterfaceAddedEvent(object sender, InterfaceBuildEventArgs args)
		{
			Assert.IsNotNull(args.Interface, "event-arg 'interface' was null.");
			Assert.IsNotNull(componentModel.Query.QueryRepository.GetInterface(args.Interface.InterfaceID), "query result: interface not found though event was raised.");

			IInterfaceIdentifier newID = new Identifier.InternalEntityIdentifier(args.Interface.InterfaceID.Key);
			Assert.IsNotNull(componentModel.Query.QueryRepository.GetInterface(newID), "query result: interface not found though event was raised.");

			componentModel.EventInterface.GetInterfaceEvents(args.Interface.InterfaceID).NameChangedEvent
				+= new StaticAttributeChangedEventHandler(EventsTest_NameChangedEvent);
			flag02 = true;
		}

		private void ComponentAdded(object sender, ComponentUseEventArgs args)
		{
			this.sequenze += "+Comp";
		}

		private void ComponentRemoved(object sender, ComponentUseEventArgs args)
		{
			this.sequenze += "-Comp";
		}

		private void AssemblyConnectorAdded(object sender, AssemblyConnectorBuildEventArgs args)
		{
			this.sequenze += "+Asm";
		}

		private void AssemblyConnectorRemoved(object sender, ConnectorRemovedEventArgs args)
		{
			this.sequenze += "-Asm";
			RemoveConTest(args);
		}

		private void ConnectorRemoved(object sender, ConnectorRemovedEventArgs args)
		{
			this.sequenze += "-Con";
			RemoveConTest(args);
		}

		private void DelegationConnectorAdded(object sender, DelegationConnectorBuildEventArgs args)
		{
			this.sequenze += "+Del";
		}

		private void RemoveConTest(ConnectorRemovedEventArgs args)
		{
			IConnectionIdentifier conId = args.Connection.ConnectionID;
			try
			{

				if (conId.Equals(StaticComponentModel.PROV_CC_BC))
				{
					Assert.AreEqual(StaticComponentModel.IWRITERID,args.ProvidingIfaceId);
					Assert.AreEqual(StaticComponentModel.IWRITERID,args.RequiringIfaceId);
					Assert.AreEqual(StaticComponentModel.CCWRITEID,args.ProvidingComponentId);
					Assert.AreEqual(StaticComponentModel.BCWRITEID,args.RequiringComponentId);
				}
				else if (conId.Equals(StaticComponentModel.REQ_CC_BC))
				{	
					Assert.AreEqual(StaticComponentModel.IWRITERBEID,args.ProvidingIfaceId);
					Assert.AreEqual(StaticComponentModel.IWRITERBEID,args.RequiringIfaceId);
					Assert.AreEqual(StaticComponentModel.BCWRITEID,args.ProvidingComponentId);
					Assert.AreEqual(StaticComponentModel.CCWRITEID,args.RequiringComponentId);
				}
				else if (conId.Equals(StaticComponentModel.ASM_CC_BC))
				{	
					Assert.AreEqual(StaticComponentModel.IWRITERBEID,args.ProvidingIfaceId);
					Assert.AreEqual(StaticComponentModel.IWRITERBEID,args.RequiringIfaceId);
					Assert.AreEqual(StaticComponentModel.BCWRITEBEID,args.ProvidingComponentId);
					Assert.AreEqual(StaticComponentModel.CCWRITEID,args.RequiringComponentId);
				}
				else
				{
					Console.WriteLine("Silly Dataset catchs my exceptions.");
					throw new ArgumentException("Unknown connection id given in remove connection event.");
				}
			}
			catch(Exception e)
			{
				Console.WriteLine("Silly Dataset catchs my exceptions.");
				Console.WriteLine(e);
				this.errorFlag=true;
			}
		}

		private void ev_InterfaceRemovedEvent(object sender, InterfaceUseEventArgs args)
		{
			if (args.Role == InterfaceRole.PROVIDES)
				this.sequenze += "-provif";
			else
				this.sequenze += "-reqif";
		}


	}
}

#endif