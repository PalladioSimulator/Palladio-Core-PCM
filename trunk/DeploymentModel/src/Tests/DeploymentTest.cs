#if TEST
using System;
using NUnit.Framework;
using Palladio.Identifier;

namespace Palladio.DeploymentModel.Tests
{
	[TestFixture]
	public class DeploymentTest
	{
		/// <summary>
		/// </summary>
		[SetUp] public void Init() 
		{
			s = DeploymentFactory.CreateSystem("system");
			a1 = DeploymentFactory.CreateArtifact("a1");
			a2 = DeploymentFactory.CreateArtifact("a2");
			a3 = DeploymentFactory.CreateArtifact("a3");
			n1 = DeploymentFactory.CreateNode("n1");
			n2 = DeploymentFactory.CreateNode("n2");
			n3 = DeploymentFactory.CreateNode("n3");
		}


		/// <summary>
		/// </summary>
		[Test] public void AddElements()
		{
			s.Nodes.Add(n1,n2);
			n1.NestedNodes.Add(n3);
			Assert.IsTrue(s.Nodes.Contains(n3));
			s.Nodes.Remove(n3);
			Assert.IsTrue(n1.NestedNodes.Contains(n3));
			s.Nodes.Remove(n1,n2);
			n1.NestedNodes.Remove(n3);
			Assert.IsTrue(s.Nodes.Elements.Length == 0);
		}

		/// <summary>
		/// </summary>
		[Test] public void AddElementsHierarchical()
		{
			n1.NestedNodes.Add(n3,n2);
			s.Nodes.Add(n1);
			Assert.IsTrue(s.Nodes.Contains(n3));
			n1.NestedNodes.Remove(n3,n2);
			Assert.IsFalse(s.Nodes.Contains(n3));
			s.Nodes.Remove(n1);
		}

		/// <summary>
		/// </summary>
		[Test] public void Connections()
		{
			n1.NestedNodes.Add(n2);
			s.Nodes.Add(n1,n3,n2);
			INodeConnection c = DeploymentFactory.CreateNodeConnection(n2,n3);
			s.Nodes.AddConnections(c);
		}

		IArtifact a1, a2, a3;
		INode n1,n2,n3;
		ISystem s;
	}
}
#endif