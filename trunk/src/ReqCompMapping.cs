using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für ReqCompMapping.
	/// </summary>
	public class ReqCompMapping : IMapping
	{

		private IComponent innerComp;
		private IComponent outerComp;
		private ReqIFaceMapping[] ifaceMappings;

		public IComponent InnerComp
		{
			get { return innerComp; }
		}

		public IComponent OuterComp
		{
			get { return OuterComp; }
		}

		public ReqIFaceMapping[] Mappings
		{
			get { return ifaceMappings; }
		}

		public ReqCompMapping(IComponent anInnerComp, IComponent anOuterComp)
		{
			innerComp = anInnerComp;
			outerComp = anOuterComp;
			ifaceMappings = GenerateMappings();
		}

		public ReqCompMapping(IComponent anInnerComp, IComponent anOuterComp, IList aMappingList)
		{
			innerComp = anInnerComp;
			outerComp = anOuterComp;
			ifaceMappings = new ReqIFaceMapping[aMappingList.Count];
			aMappingList.CopyTo(ifaceMappings,0);
		}

		private ReqIFaceMapping[] GenerateMappings()
		{
			IList mappingList = new ArrayList();
			foreach( RequiresInterface reqInner in innerComp.GetRequiresIFaceList() )
			{
				bool found = false;
				foreach ( RequiresInterface reqOuter in outerComp.GetRequiresIFaceList() )
				{
					if (reqOuter.Name.Equals(reqInner.Name))
					{
						found = true;
						mappingList.Add( new ReqIFaceMapping(reqInner,reqOuter) );
						break;
					}
				}
				if (!found)
					throw new NoMappingFoundException(reqInner);
			}
			ReqIFaceMapping[] result = new ReqIFaceMapping[mappingList.Count];
			mappingList.CopyTo(result,0);
			return result;
		}

		#region IMapping Member

		public bool IsSubType(out System.Collections.IList anErrorList)
		{
			// TODO:  Implementierung von ReqCompMapping.IsSubType hinzufügen
			anErrorList = null;
			return false;
		}

		bool Palladio.ComponentModel.IMapping.IsSubType()
		{
			// TODO:  Implementierung von ReqCompMapping.Palladio.ComponentModel.IMapping.IsSubType hinzufügen
			return false;
		}

		#endregion

		#region IConnection Member

		public IInterfaceModel GetIntersection()
		{
			// TODO:  Implementierung von ReqCompMapping.GetIntersection hinzufügen
			return null;
		}

		#endregion

		#region ICloneable Member

		public object Clone()
		{
			// TODO:  Implementierung von ReqCompMapping.Clone hinzufügen
			return null;
		}

		#endregion
	}
}
