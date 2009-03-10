/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.extractors.delphi;

import java.util.List;

import de.fzi.delphi.symbols.Scope;

/**
 * @author stammel
 *
 */
public class ScopeWalker {

    private Scope current_scope;
    
    ScopeWalker(Scope start_scope) {
        current_scope = start_scope;
    }
    
    public boolean next() {
        
        List child_scopes = this.current_scope.getChildScopes();
        
        // if we have children ==> take first child !
        if (!child_scopes.isEmpty()) {
            this.current_scope = (Scope)child_scopes.get(0);
            return true;
        } else {
            this.current_scope = getNextSibling(this.current_scope);
            
            if (this.current_scope != null) {
                return true;
            } else {
                // no Scopes left to process!
                return false;
            }
            
        }
    }

    
    private Scope getNextSibling(Scope scope) {

        // get parent!
        Scope parent_scope = scope.getParent();
        
        if (parent_scope == null)
            return null;
        
        // get all children of parent
        List parent_child_scopes = parent_scope.getChildScopes();
        
        // are we the last child of our parent?
        int our_index = parent_child_scopes.indexOf(scope);
        
        // if we are not last child ==> get next brother/sister
        if (our_index < parent_child_scopes.size()-1) {
            return (Scope)parent_child_scopes.get(our_index+1);
        } else {
            // we are the last child ==> get next sibling of parent
            // if possible! (returns null if not possible)
            return getNextSibling(parent_scope);
        }
        
    }

    public Scope getCurrentScope() {
        return this.current_scope;
    }
    
    
    
}
