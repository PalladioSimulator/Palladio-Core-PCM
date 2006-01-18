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

namespace Palladio.QoSAdaptor.Pattern
{
	/// <summary>
	/// A MismatchSubAttribute describes the suitability of a design 
	/// pattern for solving problems with certain subattributes. For the 
	/// quality-based interface model this can be throughput or response time.
	/// The class has the attributes name and suitability, where
	/// suitability describes the suitability of the pattern to
	/// solve a problem with the subattribute referred to by 
	/// name. 
	/// </summary>
	internal class MismatchSubAttribute : IMismatchSubAttribute
	{
		#region attributes
		/// <summary>
		/// The name of the mismatch subattribute.
		/// </summary>
		private string name;

		/// <summary>
		/// Describes the influence of the pattern this mismatch subattribute 
		/// is defined for on this subattribute.
		/// </summary>
		private SuitabilityValue suitability;
		#endregion 

		#region constructor
		/// <summary>
		/// Constructs a new MismatchSubAttribute with the given name.
		/// </summary>
		/// <param name="name">The name of the QoSAttribute</param>
		internal MismatchSubAttribute(string name)
		{
			this.name = name;
		}
		#endregion

		#region properties
		/// <summary>
		/// The name of this mismatch subattribute.
		/// </summary>
		public string Name
		{
			get
			{
				return name;
			}
		}

		/// <summary>
		/// The suitability of this mismatch subattribute.
		/// </summary>
		public SuitabilityValue Suitability
		{
			get
			{
				return suitability;
			}
			set
			{
				suitability = value;
			}
		}
		#endregion
	}
}
