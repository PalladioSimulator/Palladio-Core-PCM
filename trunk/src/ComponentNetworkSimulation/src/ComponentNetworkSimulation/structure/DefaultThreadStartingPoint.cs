using System;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure
{
	/// <summary>
	/// This class is the default implementation of the datastructure describing a starting point for simulationthreads.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/06/19 13:48:07  joemal
	/// - now the startingpoint contains the ids of a component, an interface and a signature
	///
	/// Revision 1.1  2004/05/26 16:36:29  joemal
	/// initial creation
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
		/// <param name="component">the id of the component</param>
		/// <param name="iface">the id of the interface</param>
		/// <param name="signature">the id of the signature</param>
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