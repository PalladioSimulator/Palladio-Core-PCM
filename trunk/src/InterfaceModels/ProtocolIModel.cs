using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Decorators;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A ProtocolIModel is an extension of a SignatureListModel. In
	/// addition to the list of services it describes the set of all possible
	/// call sequences of these services using a finite state machine 
	/// called protocol. The language accepted by the protocol
	/// represents the possible call sequences.
	/// </summary>
	public class ProtocolIModel : SignatureListIModel  
	{
		#region Properties

		/// <summary>
		/// A Protocol is a finite state machine, wich describes
		/// the possible call sequences of the services.
		/// </summary>
		public IFiniteStateMachine Protocol 
		{
			get { return protocol; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Checks if this interface is a subset of anIModel. In
		/// other words all services of this IInterfaceModel must be
		/// provided by anIModel and all relations between these 
		/// services expected by this IInterfaceModel must be fulfilled
		/// by anIModel, but anIModel can provide more than what is required
		/// by this IInterfaceModel.
		/// </summary>
		/// <param name="anIModel">An other IInterfaceModel.</param>
		/// <param name="anErrorList">List of error which occured during the subtypecheck.</param>
		/// <returns>True, if this IInterfaceModel is a subset of anIModel, false otherwise.</returns>
		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			if (anIModel is ProtocolIModel) 
			{
				if (base.IsSubSetOf( anIModel, out anErrorList ))
				{
					ProtocolIModel protIM = (ProtocolIModel) anIModel;
					IFiniteStateMachine crossProd = fsmFactory.Intersect( this.Protocol, protIM.Protocol );
					return this.Protocol.Equals(crossProd);
				}
				return false;
			}   
			else 
			{
				throw new IModelNotProtocolIModelException();
			}
		}

		/// <summary>
		/// Merges this IInterfaceModel with anIModel.
		/// </summary>
		/// <param name="anIModel">An IInterfaceModel which is merged with this one.</param>
		/// <returns>A new IInterfaceModel created by merging this IInterfacemodel an anIModel.</returns>
		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			if (anIModel is ProtocolIModel) 
			{
				ProtocolIModel protIM = (ProtocolIModel) anIModel;
				ProtocolIModel resultIModel = (ProtocolIModel) base.Merge( anIModel ); // merge SignatureLists
				resultIModel.protocol = fsmFactory.Merge( this.Protocol, protIM.Protocol );
				return resultIModel;
			}   
			else 
			{
				throw new IModelNotProtocolIModelException();
			}
		}

		/// <summary>
		/// Intersects this IInterfaceModel and anIModel. 
		/// The result contains alls services and relationships wich exist in both
		/// IInterfaceModels.
		/// </summary>
		/// <param name="anIModel">IInterfaceModel to intersect with.</param>
		/// <returns>A new IInterfaceModel representing the intersection 
		/// of both IInterfaceModels</returns>
		public override IInterfaceModel GetIntersection(IInterfaceModel anIModel)
		{
			if (anIModel is ProtocolIModel) 
			{
				ProtocolIModel protIM = (ProtocolIModel) anIModel;
				ProtocolIModel resultIModel = (ProtocolIModel) base.GetIntersection( anIModel ); // intersect SignatureLists
				resultIModel.protocol = fsmFactory.Intersect( this.Protocol, protIM.Protocol );
				return resultIModel;
			}   
			else 
			{
				throw new IModelNotProtocolIModelException();
			}
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new ProtocolIModel(this);
		}

		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
		public override bool Equals(object obj)
		{
			if (base.Equals (obj)) 
			{
				if (obj is ProtocolIModel) 
				{
					ProtocolIModel other = (ProtocolIModel)obj;
					return other.Protocol.Equals(this.Protocol);
				}
			}
			return false;
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return this.Protocol.GetHashCode ();
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			string result = base.ToString();
			result+= "\nProtocol:\n";
			result+= Protocol;
			return result;
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty ProtocolIModel.
		/// </summary>
		public ProtocolIModel() : base() 
		{
			protocol = fsmFactory.CreateFSM();
		}

		/// <summary>
		/// Creates an ProtocolIModel using aProtocol as protocol and the 
		/// ISignatures contained in aSignatureList.
		/// </summary>
		/// <param name="aProtocol">Describing the allowed call sequences.</param>
		/// <param name="aSignatureList">Containing the services of the IInterfaceModel.</param>
		public ProtocolIModel( IFiniteStateMachine aProtocol, IList aSignatureList) : base(aSignatureList)
		{
			protocol = (IFiniteStateMachine) aProtocol.Clone();
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aProIModel">ProtocolIModel to copy.</param>
		public ProtocolIModel( ProtocolIModel aProIModel ) : this (aProIModel.Protocol, aProIModel.SignatureList)
		{
		}

		#endregion

		#region Data

		private IFiniteStateMachine protocol;
		private static FSMFactory fsmFactory = new FSMFactory();
		#endregion
	}
}
