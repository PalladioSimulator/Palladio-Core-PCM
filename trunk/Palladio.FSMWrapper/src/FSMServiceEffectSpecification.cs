using System;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;

namespace Palladio.FSMWrapper
{
	/// <summary>
	/// This is the wrapper class that supports FSMs to be used as componentmodels service effect specification.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/09/18 15:37:59  joemal
	/// now connected to the cm
	///
	/// Revision 1.2  2005/08/30 13:42:34  kelsaka
	/// - FSMWrappers are returning new public interface
	/// - added query for all existing SEFFs in CM
	///
	/// Revision 1.1  2005/07/29 15:59:16  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class FSMServiceEffectSpecification : IFSMServiceEffectSpecification
	{
		#region data
		
		//the type id of the wrapper
		public static ISeffTypeIdentifier SEFFTYPEID=
			ComponentModelIdentifier.CreateSeffTypeID("93295E86-E9C0-4f6c-9710-91AACDCC17C1");

		//holds the fsm
		private IFiniteStateMachine fsm;

		//the id of the seff
		private ISeffIdentifier seffId;

		#endregion

		#region constructor 

		/// <summary>
		/// called to create the seff wrapper.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		public FSMServiceEffectSpecification(IFiniteStateMachine fsm)
		{
			this.fsm = fsm;
			this.seffId = ComponentModelIdentifier.CreateSeffID(Guid.NewGuid().ToString());
		}

		/// <summary>
		/// called to create the seff wrapper using the given id.
		/// </summary>
		/// <param name="fsm">the fsm</param>
		/// <param name="seffId">the seffId</param>
		public FSMServiceEffectSpecification(IFiniteStateMachine fsm, ISeffIdentifier seffId)
		{
			this.fsm = fsm;
			this.seffId = seffId;
		}

		#endregion

		#region properties

		/// <summary>
		/// called to return the fsm that is used to specify the interface protocol.
		/// </summary>
		public IFiniteStateMachine FiniteStateMachine
		{
			get { return fsm; }
		}

		#endregion

		#region properties

		/// <summary>
		/// returns the typed id of the seff
		/// </summary>
		public ISeffIdentifier SeffID
		{
			get { return this.seffId; }
		}

		/// <summary>
		/// returns the type id of the seff. 
		/// </summary>
		public ISeffTypeIdentifier SeffTypeID
		{
			get { return FSMServiceEffectSpecification.SEFFTYPEID; }
		}

		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get { return this.seffId; }
		}

		#endregion
	}
}
