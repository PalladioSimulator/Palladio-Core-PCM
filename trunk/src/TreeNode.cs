using System;
using System.Diagnostics;
using System.Collections;

using Palladio.Identifier;
using Palladio.Attributes;
using Palladio.Reliability.Exceptions;

namespace Palladio.Reliability
{
	/// <summary>
	/// Description of Tree.	
	/// </summary>
	public class TreeNode : IIdentifiable, IAttributable
	{
		
		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get { return id; }
		}
		
		public TreeNodeHash Children
		{
			get { return children; }
		}
		
		public TreeNode Father
		{
			get { return father; }
		}
		
		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public IAttributeHash Attributes 
		{ 
			get { return attributes; }
		}
		
		public bool HasChildren 
		{
			get { return children.Count != 0; }
		}
		
		public bool IsRoot
		{
			get { return father == null; }
		}
		
		public void AddChild(TreeNode n)
		{
			n.father = this;
			children.Add(n.ID,n);
		}
		
		public void RemoveChild(TreeNode n)
		{
			children.Remove(n.ID);
			n.father = null;
		}
		
		public TreeNode GetNode( params IIdentifier[] path)
		{
			return GetNodeRecursive( new ArrayList(path) );
		}
		
		
		private TreeNode GetNodeRecursive( IList path )
		{
			Debug.Assert(path.Count > 0);
			
			TreeNode n = children[(IIdentifier)path[0]];
			if (n == null)
				throw new TreeNodeNotFoundException((IIdentifier)path[0]);
			
			if (path.Count == 1) return n;
			path.RemoveAt(0);
			return GetNodeRecursive(path);
		}
		
		public override string ToString()
		{
			return ToString(0);	
		}
		
		public string ToString(int level)
		{
			string result = "".PadRight(level*2) + this.ID + "\n";
			foreach (TreeNode n in this.Children.Values)
			{
				result += n.ToString(level + 1);
			}
			return result;
		}
		
		
		public TreeNode(IAttributeHash attributes, IIdentifier id)
		{
			this.id = id;
			this.attributes = attributes;
			this.children = new TreeNodeHash();
			this.father = null;
		}
		
		public TreeNode(IAttributeHash attributes, IIdentifier id, TreeNode father) : this(attributes, id)
		{
			this.father = father;
		}
		
		private IIdentifier id;
		private IAttributeHash attributes;
		private TreeNodeHash children;
		private TreeNode father;
	}
}
