using System;
using System.Collections;


namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public abstract class AbstractComponentInterface : Palladio.ComponentModel.AbstractIModel 
	{
		#region Data

		private IInterfaceModel iModel;
		private string name;

		#endregion

		#region Constructors

		protected AbstractComponentInterface( IInterfaceModel anIModel, string aName )
		{
			iModel = (IInterfaceModel)anIModel.Clone();
			name = (string)aName.Clone();
		}
		#endregion

		#region Implemented Properties

		public IInterfaceModel IModel 
		{
			get { return iModel; }
		}

		public string Name
		{
			get { return name; }
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

		public override bool Equals(object obj)
		{
			if (obj is AbstractComponentInterface)
			{
				AbstractComponentInterface aComIFace = (AbstractComponentInterface)obj;
				return (this.IModel.Equals( aComIFace.IModel ) &&
					this.Name.Equals( aComIFace.Name ));
			}
			return false;
		}


		#endregion
	}
}