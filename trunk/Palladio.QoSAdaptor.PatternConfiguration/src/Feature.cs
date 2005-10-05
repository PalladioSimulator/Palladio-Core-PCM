#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using System.Collections;

namespace Palladio.QoSAdaptor.PatternConfiguration
{
	/// <summary>
	/// Represents a feature.
	/// </summary>
	public class Feature
	{
		#region data
		/// <summary>
		/// Indicates that this feature is the root node of the feature tree.
		/// </summary>
		private bool root;

		/// <summary>
		/// The name of this feature
		/// </summary>
		private string name;

		/// <summary>
		/// Detailed description of this feature.
		/// </summary>
		private string description;

		/// <summary>
		/// The guid of this feature in the feature diagram. 
		/// </summary>
		private string guid;

		/// <summary>
		/// The type of this feature if is represents a variable. If it does 
		/// not, the type is null;
		/// </summary>
		private string type;

		// TODO: Find another word for "instances"
		/// <summary>
		/// The minimum number of instances of this feature
		/// </summary>
		private int minCardinality;

		/// <summary>
		/// The maximum number of instances of this feature
		/// </summary>
		private int maxCardinality;

		/// <summary>
		/// The parent feature of this feature in the feature tree. Null, if 
		/// this is the root feature.
		/// </summary>
		private Feature parent;

		/// <summary>
		/// A list of child features of this feature in the feature tree. 
		/// Empty, if this is a leaf feature.
		/// </summary>
		private ArrayList children;
		#endregion

		#region properties
		/// <summary>
		/// Returns the name of this feature
		/// </summary>
		public string Name
		{
			get
			{
				return this.name;
			}
		}

		/// <summary>
		/// Returns the description of this feature
		/// </summary>
		public string Description
		{
			get
			{
				return this.description;
			}
		}

		/// <summary>
		/// Returns the guid of this feature
		/// </summary>
		public string Guid
		{
			get
			{
				return this.guid;
			}
		}

		/// <summary>
		/// Indicates if this feature is the root node of the feature tree
		/// </summary>
		public bool IsRoot
		{
			get
			{
				return this.root;
			}
			set
			{
				this.root = value;
			}
		}

		/// <summary>
		/// Indicates if this feature is a leaf in the feature tree.
		/// </summary>
		public bool isLeaf
		{
			get
			{
				if (this.children.Count == 0)
					return true;
				else 
					return false;
			}
		}

		/// <summary>
		/// The type of the feature if it represents a variable. If it does not
		/// the type is null.
		/// </summary>
		public string Type
		{
			get
			{
				return this.type;
			}
			set
			{
				this.type = value;
			}
		}

		/// <summary>
		/// The minimum number of instances of the feature in the feature tree.
		/// </summary>
		public int MinCardinality
		{
			get
			{
				return this.minCardinality;
			}
			set
			{
				this.minCardinality = value;
			}
		}

		/// <summary>
		/// The maximum number of instances of the feature in the feature tree.
		/// </summary>
		public int MaxCardinality
		{
			get
			{
				return this.maxCardinality;
			}
			set
			{
				this.maxCardinality = value;
			}
		}

		/// <summary>
		/// The parent feature of this feature in the feature tree.
		/// Null, if this is the root feature.
		/// </summary>
		public Feature Parent
		{
			get
			{
				return this.parent;
			}
			set
			{
				this.parent = value;
			}
		}

		/// <summary>
		/// Returns a list of children of this feature in the feature node.
		/// Changes to this list will not change the inner state of this 
		/// feature.
		/// </summary>
		public IList Children
		{
			get
			{
				return (IList)this.children.Clone();
			}
		}
		#endregion

		#region constructor
		public Feature(string name, string description, string guid)
		{
			this.name = name;
			this.description = description;
			this.guid = guid;
			this.type = null;
			this.root = false;
			// TODO: Change default values to 0 or -1?
			this.minCardinality = 1;
			this.maxCardinality = 1;
			this.parent = null;
			this.children = new ArrayList();
		}
		#endregion

		#region public methods
		/// <summary>
		/// Adds a child to the list of children of this feature.
		/// </summary>
		/// <param name="child">A feature in the same feature tree which is a 
		/// child of this feature.</param>
		public void AddChild(Feature child)
		{
			this.children.Add(child);
		}

		/// <summary>
		/// Returns a string representation of this feature.
		/// </summary>
		/// <returns></returns>
		public override string ToString()
		{
			string s =  "FEATURE "+this.name+". ";
			if (this.root) s+= "Is root. ";
			if (this.type != null) s+= "Type = "+this.type+". ";
			s+= "guid = "+this.guid+". Description: "+this.description;
			return s;
		}

		#endregion
	}
}
