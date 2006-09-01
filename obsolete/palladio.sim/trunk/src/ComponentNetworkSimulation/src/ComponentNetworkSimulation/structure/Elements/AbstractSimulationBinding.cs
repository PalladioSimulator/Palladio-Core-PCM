using System;
using ComponentNetworkSimulation.Structure.Attributes;
using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Attributes;

namespace ComponentNetworkSimulation.Structure.Elements
{
	/// <summary>
	/// This class is the abstract class of a simulation binding. It uses the binding created with <code>ComponentFactory</code>
	/// to delegate the unchanged methods.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/06/26 16:32:12  joemal
	/// - now propagate the reset through the architecture
	///
	/// Revision 1.1  2004/06/26 15:39:44  joemal
	/// - initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public abstract class AbstractSimulationBinding : ISimulationBinding
	{
		#region data

		//the default binding used to fill unchanged methods
		private IBinding delegat;

		#endregion
		
		#region constructor

		/// <summary>
		/// called to construct a new AbstractSimulationBinding using the given parameters
		/// </summary>
		/// <param name="reqComp">the requiring component</param>
		/// <param name="reqRole">the id of the requires interface</param>
		/// <param name="provComp">the providing component</param>
		/// <param name="provRole">the id of the requires interface</param>
		/// <param name="parameters">the parameters of the binding</param>
		public AbstractSimulationBinding(IComponent reqComp,IIdentifier reqRole,IComponent provComp, 
			IIdentifier provRole, ISimulationBindingParams parameters)
		{
			delegat = ComponentFactory.CreateBinding(reqComp,reqRole,provComp,provRole);
			this.Attributes.Add(DefaultAttributeTypeSet.LoggingAttributeType,parameters.LoggingType);
		}

		#endregion

		#region properties

		/// <summary>
		/// delageted to the default binding
		/// </summary>
		public IAttachedRole RequiringRole
		{
			get
			{
				return delegat.RequiringRole;
			}
		}

		/// <summary>
		/// delageted to the default binding
		/// </summary>
		public IAttachedRole ProvidingRole
		{
			get
			{
				return delegat.ProvidingRole;
			}
		}

		/// <summary>
		/// delageted to the default binding
		/// </summary>
		public IAttributeHash Attributes
		{
			get
			{
				return delegat.Attributes;
			}
		}

		/// <summary>
		/// returns the logging type of the binding
		/// </summary>
		public ComponentNetworkSimulation.Structure.LoggingType_t LoggingType
		{
			get
			{
				return (LoggingType_t)this.Attributes[DefaultAttributeTypeSet.LoggingAttributeType];
			}
		}

		#endregion

		#region methods

		/// <summary>
		/// delageted to the default binding
		/// </summary>
		public void AcceptVisitor(ReflectionBasedVisitor.IVisitor visitor)
		{
			delegat.AcceptVisitor(visitor);
		}

		/// <summary>
		/// override to return a debug string. 
		/// </summary>
		/// <returns>a debug string</returns>
		public override string ToString()
		{
			return "Binding";
		}

		/// <summary>
		/// implement to return a copy of the binding
		/// </summary>
		/// <returns>the copy</returns>
		public abstract object Clone();

		/// <summary>
		/// called by a simulationthread, when it enters the binding. The binding has to return the time, the thread has to wait.
		/// </summary>
		/// <returns>the time, the thread has to wait</returns>
		public abstract long ThreadEntered();

		/// <summary>
		/// called by a thread, when it has exited the binding
		/// </summary>
		public abstract void ThreadExited();

		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. Dynamic timeconsumer should
		/// implement this method to reset its state.
		/// </summary>
		public abstract void Reset();

		/// <summary>
		/// return the hash code of the delegat
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode()
		{
			return delegat.GetHashCode ();
		}

		/// <summary>
		/// returns true, if the equals method of the delegat is true, and the loggintypes are matching
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public override bool Equals(object obj)
		{
			if (!(obj is AbstractSimulationBinding)) return false;
			if ((object)this == obj) return true;

			AbstractSimulationBinding myConnection = (AbstractSimulationBinding)obj;
			
			return (
				this.ProvidingRole.Equals(myConnection.ProvidingRole) &&
				this.RequiringRole.Equals(myConnection.RequiringRole) &&
				myConnection.LoggingType == this.LoggingType
				);
		}
		
		#endregion
	}
}
//EOF