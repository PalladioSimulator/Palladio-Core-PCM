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
		#endregion


		#region Properties

		public IFiniteStateMachine Protocol 
		{
			get { return protocol; }
		}

		#endregion


		#region Constructors

		public ProtocolIModel() 
		{
		}

		public ProtocolIModel( IFiniteStateMachine aProtocol) 
		{
			protocol = (IFiniteStateMachine) aProtocol.Clone();
		}

		public ProtocolIModel( ProtocolIModel aProIModel ) : this (aProIModel.Protocol) {}

		#endregion


		#region Methods

		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			if (anIModel is ProtocolIModel) 
			{
				if (base.IsSubSetOf( anIModel, out anErrorList ))
				{
					ProtocolIModel protIM = (ProtocolIModel) anIModel;
					IFiniteStateMachine crossProd = new FiniteCrossProductMaschineLazy( this.Protocol, protIM.Protocol );
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
				//resultIModel.protocol = new FiniteShuffleProductMaschineLazy( this.Protocol, protIM.Protocol );
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
				resultIModel.protocol = new FiniteCrossProductMaschineLazy( this.Protocol, protIM.Protocol );
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

		#endregion
	}
}
