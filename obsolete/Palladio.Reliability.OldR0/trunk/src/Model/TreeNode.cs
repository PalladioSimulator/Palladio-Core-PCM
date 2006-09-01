/*
 * $Id$
 * 
 * $Log$
 * Revision 1.6  2004/11/04 08:52:13  sliver
 * added regular expressions
 *
 * Revision 1.5  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.4  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.3  2004/09/09 04:07:52  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.2  2004/07/13 02:14:51  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */


using System.Collections;
using System.Diagnostics;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;
using Palladio.Reliability.Exceptions;
using Palladio.Reliability.TypedCollections;

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

		public TreeNodeHashmap Children
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

		public ReliabilityHashtable RequiresReliabilities
		{
			get { return reqRelHashtable; }
		}

		public ReliabilityHashtable ProvidesReliabilities
		{
			get { return provRelHashtable; }
		}

		public void AddChild(TreeNode n)
		{
			n.father = this;
			children.Add(n.ID, n);
		}

		public void RemoveChild(TreeNode n)
		{
			children.Remove(n.ID);
			n.father = null;
		}

		public TreeNode GetNode(params IIdentifier[] path)
		{
			return GetNodeRecursive(new ArrayList(path));
		}


		private TreeNode GetNodeRecursive(IList path)
		{
			Debug.Assert(path.Count > 0);

			TreeNode n = children[(IIdentifier) path[0]];
			if (n == null)
				throw new TreeNodeNotFoundException((IIdentifier) path[0]);

			if (path.Count == 1)
				return n;
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
			if (ProvidesReliabilities.Count > 0)
			{
				result += "".PadRight(level*2) + "Provides:\n";
				foreach (IMatchable extSig in ProvidesReliabilities.Keys)
				{
					result += "".PadRight((level + 1)*2) + extSig + " " + ProvidesReliabilities[extSig] + "\n";
				}
			}
			if (RequiresReliabilities.Count > 0)
			{
				result += "".PadRight(level*2) + "Requires:\n";
				foreach (IMatchable extSig in RequiresReliabilities.Keys)
				{
					result += "".PadRight((level + 1)*2) + extSig + " " + RequiresReliabilities[extSig] + "\n";
				}
			}
			foreach (TreeNode n in this.Children.Values)
			{
				result += n.ToString(level + 2);
			}
			return result;
		}


		public TreeNode(IIdentifier id)
		{
			this.id = id;
			this.children = new TreeNodeHashmap();
			this.father = null;
			this.provRelHashtable = new ReliabilityHashtable();
			this.reqRelHashtable = new ReliabilityHashtable();
		}

		public TreeNode(IIdentifier id, TreeNode father) : this(id)
		{
			this.father = father;
		}

		private IIdentifier id;
		private TreeNodeHashmap children;
		private TreeNode father;
		private ReliabilityHashtable provRelHashtable;
		private ReliabilityHashtable reqRelHashtable;

	}
}