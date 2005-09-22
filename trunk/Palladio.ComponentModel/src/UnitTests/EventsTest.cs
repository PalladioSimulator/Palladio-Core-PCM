#if TEST
using System;
using NUnit.Framework;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
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
	/// Revision 1.1  2005/09/22 18:45:15  joemal
	/// xxx
	///
	[TestFixture]	
	public class EventsTest
	{
		private ComponentModelEnvironment componentModel;
		private string sequenze;

		[SetUp]
		public void Init()
		{
			sequenze="";
			componentModel = new ComponentModelEnvironment();
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
		}

		private void ConnectorRemoved(object sender, ConnectorRemovedEventArgs args)
		{
			this.sequenze += "-Con";
		}

		private void DelegationConnectorAdded(object sender, DelegationConnectorBuildEventArgs args)
		{
			this.sequenze += "+Del";
		}
	}
}

#endif