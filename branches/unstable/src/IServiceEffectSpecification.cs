using System;
using System.Collections;
using Palladio.Attributes;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// An IInterfaceModel is the description of an interface (of a component).
	/// In our case an interface is a set of signatures
	/// which can be somehow related to each other.
	/// </summary>
	public interface IServiceEffectSpecification : ICloneable, IAttributable
	{
		/// <summary>
		/// A list of signatures contained in this IServiceEffectSpecification
		/// </summary>
		IServiceList SignatureList
		{
			get;
		}
		
		/// <summary>
		/// Additional specification data like FSMs, Petri Nets, ....
		/// </summary>
		IAuxiliaryServiceEffectSpecification[] AuxiliarySpecifications
		{
			get;
		}
		
		/// <summary>
		/// Add a new specification aspect to this interface, like a protocol spec.
		/// </summary>
		/// <param name="info">Additional specification data</param>
		void AddAuxiliarySpecification(IAuxiliaryServiceEffectSpecification info);

		/// <summary>
		/// Get the auxiliary information of a given type
		/// </summary>
		/// <param name="type">Type of the additional information to retrieve</param>
		/// <returns>The requested information or an exception if the information is not
		/// available</returns>
		IAuxiliaryServiceEffectSpecification GetAuxiliarySpecification(System.Type type);
	}
}
