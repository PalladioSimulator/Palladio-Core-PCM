#if TEST
using System;
using NUnit.Framework;
using Palladio.ComponentModel.Identifier;
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
			StaticViewEvents ev = componentModel.EventInterface.GetStaticViewEvents();
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
			CompositeComponentEvents ev = componentModel.EventInterface.
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
	}
}

#endif