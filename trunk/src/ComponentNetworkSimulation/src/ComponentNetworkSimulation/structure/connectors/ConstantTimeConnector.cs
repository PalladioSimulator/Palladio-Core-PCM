using ComponentNetworkSimulation.structure;
namespace ComponentNetworkSimulation.structure.connectors
{
	internal class ConstantTimeConnector: AbstractConnector
	{
		protected long delayTime = 0;

		public ConstantTimeConnector(int id, long delayTime) : base(id)
		{
			this.delayTime = delayTime;
		}

		public override long getDelayTime()
		{
			return this.delayTime;
		}

		public override System.String getName()
		{
			return base.getName()+"[constant delaytime = "+this.delayTime+"]";
		}

		public override void reset()
		{
			//nothing to do in this implementation
		}

	}
}
