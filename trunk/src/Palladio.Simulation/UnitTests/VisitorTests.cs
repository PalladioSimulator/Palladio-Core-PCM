#if TEST

using System;
using NUnit.Framework;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;
using Palladio.Simulation.Model.Visitor;

namespace Palladio.Simulation.UnitTests
{
	/// <summary>
	/// Zusammenfassung für VisitorTests.
	/// </summary>
	[TestFixture]
	public class VisitorTests
	{
		private int pathIdentifier = 0;

		public VisitorTests()
		{
		}

		[SetUp]
		public void Init() 
		{
			pathIdentifier = 0;
		}

		public void TestBasicComponentVisitor()
		{
			IBasicComponent bc = (IBasicComponent)ReferenceArchitecture.CreateC1();
			IComponentVisitor visitor = new DefaultBasicComponentVisitor(bc,
				ComponentFactory.CreateExternalSignature(ID("P1"),ComponentFactory.CreateSignature("d1")));

			visitor.OnVisitorEvent +=new VisitorEventHandler(visitor_OnVisitorEvent);

			Assert.AreEqual(visitor.CurrentElement.ToString(),"d1->1");
			Assert.AreEqual(this.pathIdentifier,0);
			
			visitor.NextElement();

			Assert.IsTrue(visitor.CurrentElement is ITransition);
			Assert.AreEqual(this.pathIdentifier,0);

			visitor.NextElement();

			while(visitor.CurrentElement.ToString().Equals("d1->2"))
			{
				Assert.AreEqual(this.pathIdentifier,1);
				pathIdentifier = 0;

				visitor.NextElement();

				Assert.IsTrue(visitor.CurrentElement is ITransition);
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();
				
				Assert.AreEqual(visitor.CurrentElement.ToString(),"d1->1");
				Assert.AreEqual(this.pathIdentifier,1);
				pathIdentifier = 0;

				visitor.NextElement();

				Assert.IsTrue(visitor.CurrentElement is ITransition);
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();
			}

			Assert.AreEqual(visitor.CurrentElement.ToString(),"d1->3");
			Assert.AreEqual(this.pathIdentifier,1);
			pathIdentifier = 0;

			visitor.NextElement();

			Assert.AreEqual(this.pathIdentifier,2);
			Assert.IsFalse(visitor.HasAnyElement);
		}

		public void TestCompositeComponentVisitor()
		{
			ICompositeComponent cc = (ICompositeComponent)ReferenceArchitecture.CreateCompositeComponent();
			IComponentVisitor visitor = new DefaultCompositeComponentVisitor(cc,ID("P1"),ID("d1"),new DefaultVisitorFactory());

			visitor.OnVisitorEvent +=new VisitorEventHandler(visitor_OnVisitorEvent);

			Assert.AreEqual(visitor.CurrentElement.ToString(),"d1->1");
			Assert.AreEqual(this.pathIdentifier,0);

			visitor.NextElement();

			Assert.IsTrue(visitor.CurrentElement is ITransition);
			Assert.AreEqual(this.pathIdentifier,0);

			visitor.NextElement();
				
			Assert.IsTrue(visitor.CurrentElement is IBinding);
			Assert.AreEqual(this.pathIdentifier,0);

			visitor.NextElement();

			while(visitor.CurrentElement.ToString().Equals("C2->e1->1")) 
			{
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();

				Assert.AreEqual(visitor.CurrentElement.ToString(),"d1->2");
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();

				Assert.IsTrue(visitor.CurrentElement is ITransition);
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();

				Assert.IsTrue(visitor.CurrentElement is IBinding);
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();

				Assert.AreEqual(visitor.CurrentElement.ToString(),"C2->e2->1");
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();

				Assert.AreEqual(visitor.CurrentElement.ToString(),"d1->1");
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();

				Assert.IsTrue(visitor.CurrentElement is ITransition);
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();

				Assert.IsTrue(visitor.CurrentElement is IBinding);
				Assert.AreEqual(this.pathIdentifier,0);

				visitor.NextElement();
			}

			Assert.AreEqual(visitor.CurrentElement.ToString(),"C2->e4->1");
			Assert.AreEqual(this.pathIdentifier,0);

			visitor.NextElement();

			Assert.AreEqual(visitor.CurrentElement.ToString(),"d1->3");
			Assert.AreEqual(this.pathIdentifier,0);

			visitor.NextElement();

			Assert.AreEqual(this.pathIdentifier,2);
			Assert.IsFalse(visitor.HasAnyElement);
		}

		public static IIdentifier ID(string id)
		{
			return IdentifiableFactory.CreateStringID(id);
		}

		private void visitor_OnVisitorEvent(object sender, VisitorEventArgs args)
		{
			switch(args.Type)
			{
				case VisitorEventArgs.EventType.TYPE_EXTERNALCALL:
					pathIdentifier = 1;
					break;
				case VisitorEventArgs.EventType.TYPE_RETURN:
					pathIdentifier = 2;
					break;
				case VisitorEventArgs.EventType.TYPE_UNBOUNDREQUIRES:
					pathIdentifier = 3;
					break;
				case VisitorEventArgs.EventType.TYPE_UNKNOWN_ELEMENT:
					pathIdentifier = 4;
					break;
			}
		}
	}
}
#endif