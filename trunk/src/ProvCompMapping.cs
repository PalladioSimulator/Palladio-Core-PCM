using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für ProvCompMapping.
	/// </summary>
	public class ProvCompMapping : IMapping
	{
		private IComponent innerComp;
		private IComponent outerComp;
		private ProvIFaceMapping[] ifaceMappings;

		public IComponent InnerComp
		{
			get { return innerComp; }
		}

		public IComponent OuterComp
		{
			get { return OuterComp; }
		}

		public ProvIFaceMapping[] Mappings
		{
			get { return ifaceMappings; }
		}

		public ProvCompMapping(IComponent anInnerComp, IComponent anOuterComp)
		{
			innerComp = anInnerComp;
			outerComp = anOuterComp;
			ifaceMappings = GenerateMappings();
		}

		public ProvCompMapping(IComponent anInnerComp, IComponent anOuterComp, IList aMappingList)
		{
			innerComp = anInnerComp;
			outerComp = anOuterComp;
			ifaceMappings = new ProvIFaceMapping[aMappingList.Count];
			aMappingList.CopyTo(ifaceMappings,0);
		}


		private ProvIFaceMapping[] GenerateMappings()
		{
			IList mappingList = new ArrayList();
			foreach ( ProvidesInterface provOuter in outerComp.GetProvidesIFaceList() )
			{
				bool found = false;
				foreach( ProvidesInterface provInner in innerComp.GetProvidesIFaceList() )
				{
					if (provOuter.Name.Equals(provInner.Name))
					{
						found = true;
						mappingList.Add( new ProvIFaceMapping(provInner,provOuter) );
						break;
					}
				}
				if (!found)
					throw new NoMappingFoundException(provOuter);
			}
			ProvIFaceMapping[] result = new ProvIFaceMapping[mappingList.Count];
			mappingList.CopyTo(result,0);
			return result;
		}

		#region IMapping Member

		public bool IsSubType(out System.Collections.IList anErrorList)
		{
			// TODO:  Implementierung von ProvCompMapping.IsSubType hinzufügen
			anErrorList = null;
			return false;
		}

		bool Palladio.ComponentModel.IMapping.IsSubType()
		{
			// TODO:  Implementierung von ProvCompMapping.Palladio.ComponentModel.IMapping.IsSubType hinzufügen
			return false;
		}

		#endregion

		#region IConnection Member

		public IInterfaceModel GetIntersection()
		{
			// TODO:  Implementierung von ProvCompMapping.GetIntersection hinzufügen
			return null;
		}

		#endregion

		#region ICloneable Member

		public object Clone()
		{
			// TODO:  Implementierung von ProvCompMapping.Clone hinzufügen
			return null;
		}

		#endregion
	}
}
