#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;

using Palladio.Identifier;
using Palladio.Editor.Common.EntityProxies;
using Palladio.Editor.Common.Commands;

namespace Palladio.Editor.Common
{

	public delegate void FileEventHandler(object source, System.IO.FileInfo fileInfo);
	public delegate void LogMessageAppendedHandler(object source, string level);
	
	public delegate void ComponentModelChangedHandler(object source, CompositeComponentProxy newModel);
	public delegate void EntityChangedHandler(object source, EntityProxy entity, EntityProxies.EventArgs e);
	public delegate void SelectionChangedHandler(object source, EntityProxy entity);
	public delegate void CommandHandler(object source, ICommand command);

}
