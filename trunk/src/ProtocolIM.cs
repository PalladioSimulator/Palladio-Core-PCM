using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Decorators;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public class ProtocolIModel : SignatureListIModel  
	{
		#region Data

		private IFiniteStateMachine protocol;
		private static FSMFactory fsmFactory = new FSMFactory();
		#endregion


		#region Properties

		public IFiniteStateMachine Protocol 
		{
			get { return protocol; }
		}

		#endregion


		#region Constructors

		public ProtocolIModel() : base() 
		{
		}

		public ProtocolIModel( IFiniteStateMachine aProtocol, IList aSignatureList) : base(aSignatureList)
		{
			protocol = (IFiniteStateMachine) aProtocol.Clone();
		}

		public ProtocolIModel( ProtocolIModel aProIModel ) : this (aProIModel.Protocol, aProIModel.SignatureList)
		{
		}

		#endregion


		#region Methods

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

		public override IInterfaceModel Intersect(IInterfaceModel anIModel)
		{
			if (anIModel is ProtocolIModel) 
			{
				ProtocolIModel protIM = (ProtocolIModel) anIModel;
				ProtocolIModel resultIModel = (ProtocolIModel) base.Intersect( anIModel ); // intersect SignatureLists
				resultIModel.protocol = fsmFactory.Intersect( this.Protocol, protIM.Protocol );
				return resultIModel;
			}   
			else 
			{
				throw new IModelNotProtocolIModelException();
			}
		}

		public override object Clone()
		{
			return new ProtocolIModel(this);
		}


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


		public override int GetHashCode()
		{
			return this.Protocol.GetHashCode ();
		}



		#endregion
	}
}
