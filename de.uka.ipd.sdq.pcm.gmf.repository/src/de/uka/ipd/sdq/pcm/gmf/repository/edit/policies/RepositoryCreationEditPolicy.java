package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;

/***
 * A creation policy which supports adding roles when dragging components or
 * interfaces on the diagram.
 */
public class RepositoryCreationEditPolicy extends CreationEditPolicy implements EditPolicy {

    // @Override
    // protected Command getCreateCommand(CreateViewRequest request) {
    // Command cmd = super.getCreateCommand(request);
    // final CompoundCommand cc = new CompoundCommand();
    // final List<IAdaptable> descriptors = (List<IAdaptable>)request.getNewObject();
    //
    // cc.add(cmd);
    // cc.add(new Command(){
    // private CompoundCommand doCommand = new CompoundCommand();
    //
    // @Override
    // public void execute() {
    // for (IAdaptable d : descriptors) {
    // View o = (View) d.getAdapter(View.class);
    // if (o.getElement() instanceof Interface) {
    // doCommand.add(getAddMissingInterfaceComponentRoleRelations(o));
    // } else if (o.getElement() instanceof ProvidesComponentType) {
    // doCommand.add(getAddMissingComponentInterfaceRoleRelations(o));;
    // }
    // }
    // doCommand.execute();
    // }
    //
    // @Override
    // public boolean canExecute() {
    // return true;
    // }
    //
    // @Override
    // public boolean canUndo() {
    // return true;
    // }
    //
    // @Override
    // public void redo() {
    // doCommand.redo();
    // }
    //
    // @Override
    // public void undo() {
    // doCommand.undo();
    // }
    //
    //
    // });
    // return cc;
    // }
    //
    // private Command getAddMissingComponentInterfaceRoleRelations(
    // View componentView) {
    // CompoundCommand cc = new CompoundCommand();
    // RepositoryComponent pc = (RepositoryComponent)componentView.getElement();
    // Repository r = pc.getRepository_RepositoryComponent();
    // for (EditPart editPart : (List<EditPart>) getHost().getChildren()) {
    // if (editPart instanceof IGraphicalEditPart) {
    // IGraphicalEditPart iEditPart = (IGraphicalEditPart) editPart;
    // if (((View) editPart.getModel()).getElement() instanceof Interface) {
    // Interface interf = (Interface) ((View) editPart.getModel()).getElement();
    // ArrayList<EObject> missingRoles = new ArrayList<EObject>();
    // if (getProvidedRole(pc, interf) != null) {
    // missingRoles.add(getProvidedRole(pc, interf));
    // }
    // if (getRequiredRole(pc, interf) != null) {
    // missingRoles.add(getRequiredRole(pc, interf));
    // }
    // addCreateRelationshipViewsCommands(cc, iEditPart, findEditPart(componentView), missingRoles);
    // }
    // }
    // }
    // return cc;
    // }
    //
    // private Command getAddMissingInterfaceComponentRoleRelations(
    // View interfaceView) {
    // CompoundCommand cc = new CompoundCommand();
    // Interface interf = (Interface)interfaceView.getElement();
    // Repository r = interf.getRepository_Interface();
    // for (EditPart editPart : (List<EditPart>) getHost().getChildren()) {
    // if (editPart instanceof IGraphicalEditPart) {
    // IGraphicalEditPart iEditPart = (IGraphicalEditPart) editPart;
    // if (((View) editPart.getModel()).getElement() instanceof ProvidesComponentType) {
    // ProvidesComponentType pc = (ProvidesComponentType) ((View) editPart.getModel()).getElement();
    // ArrayList<EObject> missingRoles = new ArrayList<EObject>();
    // if (getProvidedRole(pc, interf) != null) {
    // missingRoles.add(getProvidedRole(pc, interf));
    // }
    // if (getRequiredRole(pc, interf) != null) {
    // missingRoles.add(getRequiredRole(pc, interf));
    // }
    // addCreateRelationshipViewsCommands(cc, findEditPart(interfaceView), iEditPart, missingRoles);
    // }
    // }
    // }
    // return cc;
    // }
    //
    // private void addCreateRelationshipViewsCommands(CompoundCommand cc,
    // IGraphicalEditPart targetEditPart, IGraphicalEditPart sourceEditPart, ArrayList<EObject>
    // missingRoles) {
    //
    //
    // if (targetEditPart == null) return;
    //
    // for (EObject role : missingRoles) {
    // ConnectionViewDescriptor descriptor = new ConnectionViewDescriptor(
    // new EObjectAdapter(role),
    // null,
    // ((IGraphicalEditPart) getHost())
    // .getDiagramPreferencesHint());
    // CreateConnectionViewRequest request = new CreateConnectionViewRequest(
    // descriptor);
    // request.setSourceEditPart(sourceEditPart);
    // request.setTargetEditPart(targetEditPart);
    // request.setType(RequestConstants.REQ_CONNECTION_START);
    // sourceEditPart.getCommand(request);
    // request.setType(RequestConstants.REQ_CONNECTION_END);
    // Command addViewCommand = targetEditPart.getCommand(request);
    // cc.add(addViewCommand);
    // }
    // }
    //
    // private ProvidedRole getProvidedRole(ProvidesComponentType pc,
    // Interface interf) {
    // for (ProvidedRole pr : pc.getProvidedRoles_InterfaceProvidingEntity())
    // if (pr.getProvidedInterface__ProvidedRole() == interf)
    // return pr;
    // return null;
    // }
    //
    // private RequiredRole getRequiredRole(ProvidesComponentType pc,
    // Interface interf) {
    // for (RequiredRole rr : pc.getRequiredRoles_InterfaceRequiringEntity())
    // if (rr.getRequiredInterface__RequiredRole() == interf)
    // return rr;
    // return null;
    // }
    //
    // private IGraphicalEditPart findEditPart(View targetView){
    // List<EditPart>children = ((IGraphicalEditPart) getHost()).getChildren();
    // IGraphicalEditPart targetEditPart = null;
    // for (EditPart ep : children) {
    // if (ep instanceof IGraphicalEditPart){
    // IGraphicalEditPart iep = (IGraphicalEditPart)ep;
    // if (iep.getNotationView() == targetView)
    // targetEditPart = iep;
    // }
    // }
    // return targetEditPart;
    // }
}
