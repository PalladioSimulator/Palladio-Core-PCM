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
		/// <summary>
		/// The interface for which a mismatch occurred.
		/// </summary>
		private string interfaceName;

		/// <summary>
		/// The entity for which a mismatch occurred.
		/// </summary>
		private string entity;

		/// <summary>
		/// The mismatched QoS attribute.
		/// </summary>
		private string mismatchedQoSAttribute;

		/// <summary>
		/// The mismatched QoS subattribute.
		/// </summary>
		private string mismatchedQoSSubAttribute;

		/// <summary>
		/// Further details about the mismatch.
		/// </summary>
		private string mismatchDetails;
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
		/// <param name="mismatchedSubAttribute">The mismatches QoS subaspect
		/// </param>
		/// <param name="mismatchDetails">Further details about the mismatch.
		/// </param>
		public QMLMismatch(string interfaceName, string entity, 
			string mismatch, string mismatchedSubAttribute, 
			string mismatchDetails)
		{
			this.interfaceName = interfaceName;
			this.entity = entity;
			this.mismatchedQoSAttribute = mismatch;
			this.mismatchedQoSSubAttribute = mismatchedSubAttribute;
			this.mismatchDetails = mismatchDetails;
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
				return this.mismatchedQoSAttribute;
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
				return this.mismatchedQoSSubAttribute;
			}
		}

		/// <summary>
		/// Provides further details about the mismatch and its occurrence.
		/// </summary>
		public string MismatchDetails
		{
			get
			{
				return this.mismatchDetails;
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
			s += ": "+this.mismatchedQoSAttribute;
			if (this.mismatchedQoSSubAttribute != null)
				s+= "."+this.mismatchedQoSSubAttribute;
			if (this.mismatchDetails != string.Empty)
				s+= "\n"+mismatchDetails;
			return s;
		}
		#endregion
	}
}
