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
		private IFiniteStateMachine protocol;

		public IFiniteStateMachine Protocol 
		{
			get { return protocol; }
		}

		public ProtocolIModel() 
		{
		}

		public ProtocolIModel( IFiniteStateMachine aProtocol) 
		{
			protocol = aProtocol;
		}

		public ProtocolIModel( ProtocolIModel aProtIModel ) 
		{
			protocol = aProtIModel.Protocol; //.Clone();
		}

		public ProtocolIModel( ProtocolIModel aProtIModelOne, ProtocolIModel aProtIModelTwo ) 
		{
//			FiniteShuffleProductMaschine shuffle = new FiniteShuffleProductMaschine(aProtIModelOne.Protocol, aProtIModelTwo.Protocol);
//			protocol = shuffle.GenerateFSP();
		}

		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			anErrorList = null;
			return false;
		}

		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			if (anIModel is ProtocolIModel) 
			{
				ProtocolIModel protIM = (ProtocolIModel) anIModel;
				return new ProtocolIModel( this, protIM);
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
	}
}
