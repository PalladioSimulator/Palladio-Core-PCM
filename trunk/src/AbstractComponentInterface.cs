using System;
using System.Collections;


namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public abstract class AbstractComponentInterface : Palladio.ComponentModel.AbstractIModel 
	{
		#region Data

		protected IInterfaceModel iModel;

		#endregion


		#region Implemented Properties

		public IInterfaceModel IModel 
		{
			get { return iModel; }
		}
		#endregion


		#region Implemented Methods

		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			if (anIModel is AbstractComponentInterface) 
			{
				AbstractComponentInterface compIFace = (AbstractComponentInterface) anIModel;
				return IModel.IsSubSetOf( compIFace.IModel, out anErrorList );
			}
			else
			{
				throw new IModelNotComponentInterfaceException();
			}
		}

		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			if (anIModel is AbstractComponentInterface) 
			{
				AbstractComponentInterface compIFace = (AbstractComponentInterface) anIModel;
				AbstractComponentInterface resultIFace = (AbstractComponentInterface) this.Clone();
				resultIFace.iModel = IModel.Merge( compIFace.IModel );
				return resultIFace;
			}
			else
			{
				throw new IModelNotComponentInterfaceException();
			}
		}

		public override IInterfaceModel Intersect(IInterfaceModel anIModel)
		{
			if (anIModel is AbstractComponentInterface) 
			{
				AbstractComponentInterface compIFace = (AbstractComponentInterface) anIModel;
				AbstractComponentInterface resultIFace = (AbstractComponentInterface) this.Clone();
				resultIFace.iModel = IModel.Intersect( compIFace.IModel );
				return resultIFace;
			}
			else
			{
				throw new IModelNotComponentInterfaceException();
			}
		}

		#endregion
	}
}