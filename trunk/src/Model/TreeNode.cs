/*
 * $Id$
 * 
 * $Log$
 * Revision 1.2  2004/07/13 02:14:51  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */


using System;
using System.Diagnostics;
using System.Collections;

using Palladio.Identifier;
using Palladio.Attributes;
using Palladio.Reliability.Exceptions;
using Palladio.Reliability.TypedCollections;
using Palladio.Utils.Collections;
using Palladio.ComponentModel;


namespace Palladio.Reliability.Model
{
	/// <summary>
	/// Description of Tree.	
	/// </summary>
	public class TreeNode : IIdentifiable
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
				
		public bool HasChildren 
		{
			get { return children.Count != 0; }
		}
		
		public bool IsRoot
		{
			get { return father == null; }
		}
				
		public ReliabilityHash RequiresReliabilities
		{
			get { return reqRelHash; }
		}
		
		public ReliabilityHash ProvidesReliabilities
		{
			get { return provRelHash; }
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
		
		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <param name="level"></param>
		/// <returns>String representation of the object.</returns>
		public string ToString(int level)
		{
			string result = "".PadRight(level*2) + this.ID + "\n";
			if ( ProvidesReliabilities.Count > 0 )
			{
				result += "".PadRight(level*2) + "Provides:\n";
				foreach (IExternalSignature exSig in ProvidesReliabilities.Keys)
				{
					result += "".PadRight( (level+1)*2 ) + exSig + " " + ProvidesReliabilities[exSig] + "\n";
				}
			}
			if ( RequiresReliabilities.Count > 0 )
			{
				result += "".PadRight(level*2) + "Requires:\n";
				foreach (IExternalSignature exSig in RequiresReliabilities.Keys)
				{
					result += "".PadRight( (level+1)*2 ) + exSig + " " + RequiresReliabilities[exSig] + "\n";
				}
			}
			foreach (TreeNode n in this.Children.Values)
			{
				result += n.ToString(level+2);
			}
			return result;
		}
		
		
		public TreeNode(IIdentifier id)
		{
			this.id = id;
			this.children = new TreeNodeHash();
			this.father = null;
			this.provRelHash = new ReliabilityHash();
			this.reqRelHash = new ReliabilityHash();
		}
		
		public TreeNode(IIdentifier id, TreeNode father) : this(id)
		{
			this.father = father;
		}
		
		private IIdentifier id;
		private TreeNodeHash children;
		private TreeNode father;
		private ReliabilityHash provRelHash;
		private ReliabilityHash reqRelHash;
		
	}
}
