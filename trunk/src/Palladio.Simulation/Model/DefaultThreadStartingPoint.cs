using System;
using Palladio.Identifier;

namespace Palladio.Simulation.Model
{
	/// <summary>
	/// This class is the default implementation of the datastructure describing a starting point for simulationthreads.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultThreadStartingPoint : IThreadStartingPoint
	{
		#region data

		//the component
		private IIdentifier componentID;

		//the role
		private IIdentifier ifaceID;

		//the signature
		private IIdentifier signatureID;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new DefaultThreadStartingPoint described by the given parameters.
		/// </summary>
		/// <param name="componentID">the id of the component</param>
		/// <param name="ifaceID">the id of the interface</param>
		/// <param name="signatureID">the id of the signature</param>
		public DefaultThreadStartingPoint(IIdentifier componentID, IIdentifier ifaceID, IIdentifier signatureID)
		{
			this.componentID = componentID;
			this.ifaceID = ifaceID;
			this.signatureID = signatureID;
		}
		#endregion

		#region Properties
		
		/// <summary>
		/// The Component, in which the thread has to start.
		/// </summary>
		public IIdentifier ComponentID
		{
			get
			{
				return this.componentID;
			}
		}

		/// <summary>
		/// return the id of the interface, where the thread has to start.
		/// </summary>
		public IIdentifier InterfaceID
		{
			get
			{
				return this.ifaceID;
			}
		}

		/// <summary>
		/// the id of the signature, where the thread has to be started.
		/// </summary>
		public IIdentifier SignatureID
		{
			get
			{
				return this.signatureID;
			}
		}

		#endregion
	}
}
//EOF