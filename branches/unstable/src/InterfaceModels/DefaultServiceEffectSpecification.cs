using System;
using System.Collections;
using Palladio.Attributes;

namespace Palladio.ComponentModel.InterfaceModels
{
	#region DefaultServiceEffectSpecification
	/// <summary>
	/// An IInterfaceModel is the description of an interface (of a component).
	/// In our case an interface is a set of signatures
	/// which can be somehow related to each other.
	/// </summary>
	internal class DefaultServiceEffectSpecification : ICloneable, IAttributable, IServiceEffectSpecification
	{
		protected IServiceList requiredServicesList;
		protected AttributeHash attributes;
		protected ArrayList auxiliarySpecs = new ArrayList();
		
		public IServiceList RequiredServicesList
		{
			get
			{
				return requiredServicesList;
			}
		}
		
		public AttributeHash Attributes 
		{
			get 
			{
				return attributes;
			}
		}	
		
		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultServiceEffectSpecification(this.attributes, this.requiredServicesList);
		}
				
		public override bool Equals(object other)
		{
			if (!(other is IServiceEffectSpecification)) return false;
			if (other == this) return true;
			IServiceEffectSpecification model = (IServiceEffectSpecification)other;
			return model.RequiredServicesList.Equals(this.RequiredServicesList);
		}
		
		public override int GetHashCode()
		{
			return (
				requiredServicesList.GetHashCode()
				);		
		}

		/// <summary>
		/// Additional specification data like FSMs, Petri Nets, ....
		/// </summary>
		public IAuxiliaryServiceEffectSpecification[] AuxiliarySpecifications
		{
			get
			{
				IAuxiliaryServiceEffectSpecification[] result = new IAuxiliaryServiceEffectSpecification[auxiliarySpecs.Count];
				auxiliarySpecs.CopyTo(result);
				return result;
			}
		}

		/// <summary>
		/// Get the auxiliary information of a given type
		/// </summary>
		/// <param name="aType">Type of the additional information to retrieve</param>
		/// <returns>The requested information or an exception if the information is not
		/// available</returns>
		public IAuxiliaryServiceEffectSpecification GetAuxiliarySpecification(System.Type aType)
		{
			foreach (IAuxiliaryServiceEffectSpecification spec in auxiliarySpecs)
			{
				if (aType.IsAssignableFrom(spec.GetType()))
					return spec;
			}
			throw new Exception("Auxiliary information not found!");
		}
		
		/// <summary>
		/// Add a new specification aspect to this interface, like a protocol spec.
		/// </summary>
		/// <param name="info">Additional specification data</param>
		public void AddAuxiliarySpecification(IAuxiliaryServiceEffectSpecification info)
		{
			auxiliarySpecs.Add(info);
			RequiredServicesList.ServiceListChangeEvent += new ServiceListChangeEventHandler(info.ServiceListChangeEventHandler);
		}
			
		public DefaultServiceEffectSpecification(AttributeHash attrHash, IServiceList aRequiredServiceList)
		{
			this.requiredServicesList = (IServiceList)aRequiredServiceList.Clone();
			this.attributes = attrHash;
		}
		
		public DefaultServiceEffectSpecification(AttributeHash attrHash)
		{
			requiredServicesList = ComponentFactory.CreateServiceList(new IService[0]);
			this.attributes = attrHash;
		}
	}
	#endregion
}