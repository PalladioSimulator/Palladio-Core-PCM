using System;
using Palladio.ComponentModel;
using Palladio.Identifier;
using ComponentNetworkSimulation.Structure.Attributes;

namespace ComponentNetworkSimulation.Structure.Elements
{
	/// <summary>
	/// This class is the default class of a simulation binding with a static time.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/06/26 15:39:44  joemal
	/// - initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultStaticTimeBinding : AbstractSimulationBinding
	{
		/// <summary>
		/// called to constructs a new DefaultStaticTimeBinding using the given parameters
		/// </summary>
		/// <param name="reqComp">the requiring component</param>
		/// <param name="reqRole">the id of the requires interface</param>
		/// <param name="provComp">the providing component</param>
		/// <param name="provRole">the id of the requires interface</param>
		/// <param name="parms">the parameters of the binding</param>
		public DefaultStaticTimeBinding(IComponent reqComp,IIdentifier reqRole,IComponent provComp, IIdentifier provRole,
			StaticTimeBindingParams parms):base(reqComp,reqRole,provComp,provRole,parms)
		{
			this.Attributes.Add(DefaultAttributeTypeSet.StaticTimeType,parms.StaticTime);
		}

		/// <summary>
		/// called when a thread entered the binding to retrieve the time to wait.
		/// Returns the static time of the binding.
		/// </summary>
		/// <returns>the static time of the binding</returns>
		public override long ThreadEntered()
		{
			return (long)this.Attributes[DefaultAttributeTypeSet.StaticTimeType];
		}

		/// <summary>
		/// called when a thread exited this binding. Not used in this implementation.
		/// </summary>
		public override void ThreadExited()
		{
		}

		/// <summary>
		/// returns a copy of this binding
		/// </summary>
		/// <returns>a copy of this binding</returns>
		public override object Clone()
		{
			long staticTime = (long)this.Attributes[DefaultAttributeTypeSet.StaticTimeType];
			StaticTimeBindingParams parms = new StaticTimeBindingParams(this.LoggingType,staticTime);

			return new DefaultStaticTimeBinding(this.RequiringRole.Component,this.RequiringRole.RoleID,
					this.ProvidingRole.Component,this.ProvidingRole.RoleID,parms);
		}

		/// <summary>
		/// return the hash code of the base class
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode()
		{
			return base.GetHashCode ();
		}


		/// <summary>
		/// returns true, if the base methods returns true and the static times are the same.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public override bool Equals(object obj)
		{
			if (!base.Equals(obj)) return false;
			ISimulationBinding simBinding = (ISimulationBinding)obj;

			long myTime = (long)this.Attributes[DefaultAttributeTypeSet.StaticTimeType];
			long itsTime = (long)simBinding.Attributes[DefaultAttributeTypeSet.StaticTimeType];

			return myTime == itsTime;
		}
	}
}
//EOF