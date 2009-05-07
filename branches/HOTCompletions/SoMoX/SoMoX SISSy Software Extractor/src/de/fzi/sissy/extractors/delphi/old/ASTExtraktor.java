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

import antlr.collections.AST;

/**
 * @author stammel
 *
 */
public class ASTExtraktor {

    public void extractAll(AST ast) {
        
	    ASTWalkerDF walkersb = new ASTWalkerDF(ast);
	    
	    do {
	        AST astb = walkersb.getCurrentAST();

	        // 139: STMNT_LIST
	        if (astb.getType()==139) {
	            AST stmnt_list = astb;
	            // get parent declaration:
	            AST parent_decl = walkersb.getParentOfAST(astb);
	            System.out.println(parent_decl.toString() + ": ");
	            extractSTMNT_LIST(stmnt_list);
	        }
	        
	    } while(walkersb.next());
        
    }
    
    public void printAST(AST ast) {
	    ASTWalkerDF walker = new ASTWalkerDF(ast);
	    
	    do {
	        
	        for (int i=0; i<=walker.getLevel(); i++) {
	            System.out.print("   ");
	        }
	        AST astb = walker.getCurrentAST();
	        System.out.println(astb.toString() + " " + astb.getType() +"  Line: "+ astb.getLine() + " Column: "+ astb.getColumn());
	        
	    } while(walker.next());
        
    }
    
    public void extractSTMNT_LIST(AST ast) { 
        
        ASTSiblingWalker sb_walker = new ASTSiblingWalker(ast);
        
        do {
            AST stmnt = sb_walker.getCurrentAST();
            
            extractStatement(stmnt);
            
        } while(sb_walker.next());
        
    }
    
    private void extractStatement(AST stmnt) {

        int type = stmnt.getType();
        switch (type) {
        // assign
        case 193:
            System.out.println("SimpleStatement (ASSIGN, 193, Line: "+stmnt.getLine()+")");
            break;
        // expr
        case 168:
            System.out.println("SimpleStatement (EXPR, 168, Line: "+stmnt.getLine()+")");
            break;
        // if
        case 51:
            System.out.println("BranchStatement (IF, 51, Line: "+stmnt.getLine()+")");
            break;
        // stmnt-list ==> block-statement
        case 139:
            System.out.println("BlockStatement (STMNT_LIST, 139, Line: "+stmnt.getLine()+")");
            break;
        default:
            System.out.println(stmnt.toString());
        }

    }
    
    private void extractIF(AST if_ast) {
        
        
    }
    
    
}
