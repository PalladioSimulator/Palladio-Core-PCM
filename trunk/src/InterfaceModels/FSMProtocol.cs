using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.Utils.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A ProtocolIModel is an extension of a SignatureListModel. In
	/// addition to the list of services it describes the set of all possible
	/// call sequences of these services using a finite state machine 
	/// called protocol. The language accepted by the protocol
	/// represents the possible call sequences.
	/// </summary>
	public class FSMProtocol : IFSMProtocol  
	{

		#region Properties
		
		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		public IFiniteStateMachine FSM
		{
			get { return fsm; }
		}

		/// <summary>
		/// Signatures of the interface.
		/// </summary>
		public ISignature[] Signatures 
		{
			get
			{
				Set result = new Set();
				foreach (IInput i in fsm.InputAlphabet)
				{
					result.Add(i.ID);
				}
				return (ISignature[]) result.ToArray(typeof(ISignature));
			}
		}

		/// <summary>
		/// Indexer to access the sigantures easily.
		/// </summary>
		public ISignature this[int index]
		{
			get { return (ISignature) fsm.InputAlphabet[index]; }
		}

		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public IAttributeHash Attributes 
		{ 
			get { return attributes; }
		}

		/// <summary>
		/// Local unique identifier of the interface model.
		/// </summary>
		public string RoleID 
		{ 
			get{ return roleID; }
			set{ roleID = value; }
		}

		#endregion
		
		#region Methods
		
		/// <summary>
		/// Adds an array of signatures to the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to add.</param>
		public void AddSignatures( params ISignature[] aSigArray )
		{
		}

		/// <summary>
		/// Deletes a set of signatures from the interface.
		/// </summary>
		/// <param name="aSigArray">Signatures to delete.</param>
		public void DeleteSignatures( params ISignature[] aSigArray )
		{
		}
		
		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor)
		{
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return null;
		}
		
		#endregion

		#region Constructors

		#endregion
		
		#region Data
		
		private IAttributeHash attributes;
		private IFiniteStateMachine fsm;
		private string roleID;
		
		#endregion

	}
}
