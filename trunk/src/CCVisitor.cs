using System;
using System.Collections;
using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Attributes;

namespace Palladio.Reliability
{
	/// <summary>
	/// Description of CompositeComponentVisitor.	
	/// </summary>
	public class CCVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		public TreeNode ReliabilityTree
		{
			get { return tree; }
		}
		
		public CCVisitor(ICompositeComponent cc) : base(false)
		{
			this.cc = cc;
			this.visited = new ArrayList();
		}
		
		
		public override void VisitObject(object o)
		{
			Console.WriteLine("Unkown object type: "+o.GetType());	
		}
		
		public void VisitICompositeComponent(ICompositeComponent cc)
		{
			
			CCVisitor v = new CCVisitor(cc);
			v.Run();
		}
		
		public void VisitIMapping(IMapping m)
		{
			if (m.IsProvidesMapping)
			{
				Visit(m.InnerRole.Component);
			}
		}
		
		public void VisitIBinding(IBinding b)
		{
			Visit(b.ProvidingRole.Component);
		}
		
		public void VisitIBasicComponent(IBasicComponent bc)
		{
			if (!visited.Contains(bc.ID))
			{
				visited.Add(bc.ID);
				TreeNode n = new TreeNode(CreateAttributeHash(), bc.ID);
				tree.AddChild(n);
				foreach( IConnection c in cc.GetRequiresConnections(bc.ID) )
				{
					Visit(c);
				}
			}
		}
		
		public void Run()
		{
			visited.Clear();
			tree = new TreeNode(CreateAttributeHash(), cc.ID);
			foreach( IIdentifier i in cc.ProvidedRoles )
			{
				Visit(cc.GetProvidesMappingByOuter(i));
			}
		}
		
		
		private IAttributeHash CreateAttributeHash()
		{
			AttributesFactory factory = new AttributesFactory();
			return factory.Default.CreateAttributeHash();
		}

		private ICompositeComponent cc;
		private ArrayList visited;
		private TreeNode tree;
		
		
	}
}
