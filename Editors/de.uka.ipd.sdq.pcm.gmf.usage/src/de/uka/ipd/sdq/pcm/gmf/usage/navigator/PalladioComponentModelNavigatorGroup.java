/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.navigator;

import java.util.Collection;
import java.util.LinkedList;

/**
 * The Class PalladioComponentModelNavigatorGroup.
 *
 * @generated
 */
public class PalladioComponentModelNavigatorGroup extends PalladioComponentModelAbstractNavigatorItem {

    /** The my group name. @generated */
    private String myGroupName;

    /** The my icon. @generated */
    private String myIcon;

    /** The my children. @generated */
    private Collection myChildren = new LinkedList();

    /**
     * Instantiates a new palladio component model navigator group.
     *
     * @param groupName the group name
     * @param icon the icon
     * @param parent the parent
     * @generated
     */
    PalladioComponentModelNavigatorGroup(String groupName, String icon, Object parent) {
        super(parent);
        myGroupName = groupName;
        myIcon = icon;
    }

    /**
     * Gets the group name.
     *
     * @return the group name
     * @generated
     */
    public String getGroupName() {
        return myGroupName;
    }

    /**
     * Gets the icon.
     *
     * @return the icon
     * @generated
     */
    public String getIcon() {
        return myIcon;
    }

    /**
     * Gets the children.
     *
     * @return the children
     * @generated
     */
    public Object[] getChildren() {
        return myChildren.toArray();
    }

    /**
     * Adds the children.
     *
     * @param children the children
     * @generated
     */
    public void addChildren(Collection children) {
        myChildren.addAll(children);
    }

    /**
     * Adds the child.
     *
     * @param child the child
     * @generated
     */
    public void addChild(Object child) {
        myChildren.add(child);
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     * @generated
     */
    public boolean isEmpty() {
        return myChildren.size() == 0;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     * @generated
     */
    public boolean equals(Object obj) {
        if (obj instanceof de.uka.ipd.sdq.pcm.gmf.usage.navigator.PalladioComponentModelNavigatorGroup) {
            de.uka.ipd.sdq.pcm.gmf.usage.navigator.PalladioComponentModelNavigatorGroup anotherGroup = (de.uka.ipd.sdq.pcm.gmf.usage.navigator.PalladioComponentModelNavigatorGroup) obj;
            if (getGroupName().equals(anotherGroup.getGroupName())) {
                return getParent().equals(anotherGroup.getParent());
            }
        }
        return super.equals(obj);
    }

    /**
     * Hash code.
     *
     * @return the int
     * @generated
     */
    public int hashCode() {
        return getGroupName().hashCode();
    }

}
