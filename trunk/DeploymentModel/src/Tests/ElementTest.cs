#if TEST
using System;
using NUnit.Framework;
using Palladio.Identifier;

namespace Palladio.DeploymentModel.Tests
{
	[TestFixture]
	public class ElementTest
	{
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			e1 = new CharacterisedElement("Element 1");
			e2 = new CharacterisedElement("Element 2");
			e3 = new CharacterisedElement("Element 3");
			c1 = new ElementConnection(e1,e2);
			c2 = new ElementConnection(e2,e3);
			c3 = new ElementConnection(e3,e1);
		}


		/// <summary>
		/// </summary>
		[ExpectedException(typeof(ApplicationException))]
		[Test] public void AddElements()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.Add(e1,e2,e3);
			Assert.AreEqual(e1, container.Get(e1.ID));
			Assert.AreEqual(e2, container.Get(e2.Name)[0]);
			Assert.IsFalse(e1.Equals(container.Get(e2.Name)));
			container.Add(e1);
		}

		/// <summary>
		/// </summary>
		[ExpectedException(typeof(ApplicationException))]
		[Test] public void NoElement()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.Add(e1,e2);
			container.Get(e3.ID);
		}

		/// <summary>
		/// </summary>
		[Test] public void Contains()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.Add(e1,e2);
			Assert.IsTrue(container.Contains(e1));
			Assert.IsTrue(container.Contains(e2));
			Assert.IsFalse(container.Contains(e3));
		}

		/// <summary>
		/// </summary>
		[Test] public void RemoveElements()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.Add(e1,e2,e3);
			container.Remove(e1.ID);
			Assert.IsFalse(container.Contains(e1));
			container.Remove(e2.Name);
			Assert.IsFalse(container.Contains(e2));
			container.Remove(e3);
			Assert.IsFalse(container.Contains(e3));
			container.Remove(e3);
		}

		/// <summary>
		/// </summary>
		[Test] public void Events()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.ElementAdded += new CharacterisedElementAddedEventHandler(ElementAdded);
			container.ElementRemoved += new CharacterisedElementRemovedEventHandler(ElementRemoved);
			elemCnt = 0;
			container.Add(e1,e2,e3);
			Assert.AreEqual(3,elemCnt);
			container.Remove(e1.ID);
			Assert.AreEqual(2,elemCnt);
			container.Remove(e2.Name);
			Assert.AreEqual(1,elemCnt);
			container.Remove(e3);
			Assert.AreEqual(0,elemCnt);
			container.Remove(e3);
		}

		public void ElementAdded(object sender, CharacterisedElementAddedEventArgs args)
		{
			elemCnt++;
		}

		public void ElementRemoved(object sender, CharacterisedElementRemovedEventArgs args)
		{
			elemCnt--;
		}

		/// <summary>
		/// </summary>
		[Test] public void AddConnections()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.Add(e1,e2,e3);
			container.AddConnections(c1,c2,c3);
			Assert.AreEqual(c3, container.GetIncomingConnections(e1)[0]);
			Assert.AreEqual(c1, container.GetOutgoingConnections(e1)[0]);
		}

		/// <summary>
		/// </summary>
		[Test] public void ContainsConnections()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.Add(e1,e2,e3);
			container.AddConnections(c1,c2);
			Assert.IsTrue(container.ContainsConnection(c1));
			Assert.IsTrue(container.ContainsConnection(c2));
			Assert.IsFalse(container.ContainsConnection(c3));
		}

		/// <summary>
		/// </summary>
		[Test] public void NoConnection()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.Add(e1,e2,e3);
			container.AddConnections(c1,c2);
			Assert.AreEqual(0, container.GetIncomingConnections(e1).Length);
			Assert.AreEqual(c1, container.GetOutgoingConnections(e1)[0]);
		}

		/// <summary>
		/// </summary>
		[Test] public void RemoveConnections()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.Add(e1,e2,e3);
			container.AddConnections(c1,c2,c3);
			container.RemoveConnections(c1,c3);
			Assert.IsFalse(container.ContainsConnection(c1));
			Assert.IsTrue(container.ContainsConnection(c2));
			Assert.IsFalse(container.ContainsConnection(c3));
		}

		/// <summary>
		/// </summary>
		[Test] public void Clone()
		{
			IElementContainerWithConnections container = new ElementContainer();
			container.Add(e1,e2,e3);
			container.AddConnections(c1,c2,c3);
			IElementContainerWithConnections container2 = container.Clone() as IElementContainerWithConnections;
			container.RemoveConnections(c1,c2,c3);
			container.Remove(e2,e3);
			Assert.IsTrue(container2.ContainsConnection(c1));
			Assert.IsTrue(container2.ContainsConnection(c2));
			Assert.IsTrue(container2.ContainsConnection(c3));
			Assert.IsTrue(container2.Contains(e1));
			Assert.IsTrue(container2.Contains(e2.Name));
			Assert.IsTrue(container2.Contains(e3.ID));
		}

		ICharacterisedElement e1;
		ICharacterisedElement e2;
		ICharacterisedElement e3;
		IElementConnection c1;
		IElementConnection c2;
		IElementConnection c3;
		int elemCnt;
		int removeCnt;
	}
}
#endif