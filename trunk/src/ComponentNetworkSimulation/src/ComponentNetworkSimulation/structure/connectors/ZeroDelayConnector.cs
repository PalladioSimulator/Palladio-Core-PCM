namespace ComponentNetworkSimulation.Structure.Connectors
{
	internal class ZeroDelayConnector : ConstantTimeConnector {

		public ZeroDelayConnector(int id) : base(id,0)
		{
		}

		public override System.String getName()
		{
			return "Connector "+this.id+" [Zero delay]";
		}

		public override long ThreadEntered()
		{
			return 0;
		}

	}
}
