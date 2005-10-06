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

using Palladio.QoSAdaptor.Interfaces;
using Palladio.QoSAdaptor.Pattern;
using System.Collections;

namespace Palladio.QoSAdaptor.QMLComparison
{
	/// <summary>
	/// Represents a mismatch that was found in the comparison of two 
	/// QMLSpecification's. A mismatch object holds the interface and the
	/// entity for which the mismatch occured and the QoS aspect that 
	/// mismatched (e.g Performance or Reliability).
	/// </summary>
	public class QMLMismatch : IMismatch
	{
		#region data
		private string interfaceName;
		private string entity;
		private string mismatchedQoSAspect;
		private string mismatchedQoSSubAspect;
		private ArrayList solutionPatterns;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor.
		/// </summary>
		/// <param name="interfaceName">The interface for which the mismatch 
		/// occurred.</param>
		/// <param name="entity">The entitiy for which the mismatch 
		/// occurred.</param>
		/// <param name="mismatch">The mismatched QoS aspect.</param>
		/// <param name="mismatchedSubAspect">The mismatches QoS subaspect
		/// </param>
		public QMLMismatch(string interfaceName, string entity, 
			string mismatch, string mismatchedSubAspect)
		{
			this.interfaceName = interfaceName;
			this.entity = entity;
			this.mismatchedQoSAspect = mismatch;
			this.mismatchedQoSSubAspect = mismatchedSubAspect;
			this.solutionPatterns = new ArrayList();
		}
		#endregion

		#region properties
		/// <summary>
		/// Returns the name of the interface belonging to this Mismatch
		/// </summary>
		public string InterfaceName
		{
			get
			{
				return this.interfaceName;
			}
		}

		/// <summary>
		/// Returns the name of the entity belonging to this Mismatch
		/// </summary>
		public string Entity
		{
			get
			{
				return this.entity;
			}
		}

		/// <summary>
		/// Returns the name of the mismatched QoS attribute belonging to this 
		/// Mismatch
		/// </summary>
		public string MismatchAttribute
		{
			get
			{
				return this.mismatchedQoSAspect;
			}
		}

		/// <summary>
		/// Returns the name of the mismatched QoS subattribute belonging to 
		/// this Mismatch
		/// </summary>
		public string MismatchSubAttribute
		{
			get
			{
				return this.mismatchedQoSSubAspect;
			}
		}

		/// <summary>
		/// Returns a list of PatternDescriptions of patterns that cover this
		/// mismatch.
		/// </summary>
		public IList Patterns
		{
			get
			{
				return this.solutionPatterns;
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Create string representation of this mismatch.
		/// </summary>
		/// <returns>String representation of this mismatch.</returns>
		public override string ToString()
		{
			string s = this.interfaceName;
			if (entity != null)
				s += "."+this.entity;
			s += ": "+this.mismatchedQoSAspect;
			if (this.mismatchedQoSSubAspect != null)
				s+= "."+this.mismatchedQoSSubAspect;
			return s;
		}

		/// <summary>
		/// Adds a new pattern that covers this mismatch.
		/// </summary>
		/// <param name="pattern">A PatternDescription.</param>
		public void AddPattern (PatternDescription pattern)
		{
			if (!this.solutionPatterns.Contains(pattern))
				this.solutionPatterns.Add(pattern);
		}
		#endregion
	}
}
