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
package de.fzi.sissy.extractors.delphi.old;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import antlr.collections.AST;

import de.fzi.delphi.CommonASTWithLineNumber;
import de.fzi.delphi.symbols.Scope;

/**
 * @author stammel
 *
 */
public class ASTWalkerDF {

    private Stack parents;
    
    private AST current_ast;
    
    private HashMap child_parent_map;
    
    ASTWalkerDF(AST start_ast) {
        current_ast = start_ast;
        parents = new Stack();
        child_parent_map = new HashMap();
    }
    
    private void setCurrentAst(AST current_ast) {
        this.current_ast = current_ast;
        if (getParent()!=null)
        if (!child_parent_map.containsKey(current_ast)) {
            child_parent_map.put(current_ast, getParent());
        }
    }
    
    public boolean next() {
        
        AST child_ast = this.current_ast.getFirstChild();
        
        // if we have children ==> take first child !
        if (child_ast != null) {
            parents.push(current_ast);
            setCurrentAst(child_ast);
            return true;
            
        } else {
            
            setCurrentAst(getNextSibling(this.current_ast));
            
            if (current_ast==null)
                return false;

            return true;
        }
        
    }

    
    private AST getNextSibling(AST ast) {

        AST sibling_ast = ast.getNextSibling();
        
        if (sibling_ast!=null) {
            return sibling_ast;
        } else {
            if (!parents.isEmpty()) {
                AST parent = (AST) parents.pop();
                return getNextSibling(parent);
            } else {
                // no parent available
                return null;
            }
            
        }
    }

    public AST getCurrentAST() {
        return this.current_ast;
    }
    
    public int getLevel() {
        return parents.size();
    }
    
    public AST getParent() {
        if (!this.parents.isEmpty()) 
            return (AST)this.parents.peek();
        else 
            return null;
    }
    
    
    /**
     * @return Returns the child_parent_map.
     */
    public HashMap getChildParentMap() {
        return child_parent_map;
    }
    
    public AST getParentOfAST(AST ast) {
        if (child_parent_map.containsKey(ast)) {
            return (AST)child_parent_map.get(ast);
        } else {
            return null;
        }
    }
}
