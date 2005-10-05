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
	/// A QoSAttribute describes the suitability of a design 
	/// pattern for solving problems with certain QoS attributes.
	/// The class has the attributes name and suitability, where
	/// "suitability" describes the suitability of the pattern to
	/// solve a problem with the QoS attribute referred to by 
	/// "name". 
	/// Suitability is a string which at the moment should have
	/// one of the following values: ++, +, 0, -, --
	/// </summary>
	public class MismatchAttribute
	{
		#region data
		private string name;
		private string suitability;
		#endregion 

		#region constructor
		/// <summary>
		/// Constructs a new QoSAttribute with the given name.
		/// </summary>
		/// <param name="name">The name of the QoSAttribute</param>
		public MismatchAttribute(string name)
		{
			this.name = name;
		}
		#endregion

		#region properties
		public string Name
		{
			get
			{
				return name;
			}
		}

		public string Suitability
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
