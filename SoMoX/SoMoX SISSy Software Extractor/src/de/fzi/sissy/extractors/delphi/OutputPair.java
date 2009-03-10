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

import de.fzi.delphi.symbols.Scope;
import de.fzi.delphi.symbols.Symbol;
import de.fzi.sissy.metamod.Statement;

/**
 * @author stammel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OutputPair {
	
	private Scope scope;
	private Object symbol;
	private Statement currentStatement;
    
	OutputPair(Scope scope, Symbol symbol) {
		this.scope = scope; 
		this.symbol = symbol;
	}

	OutputPair(Scope scope, String symbol) {
		this.scope = scope; 
		this.symbol = symbol;
	}

	/**
	 * @return Returns the scope.
	 */
	public Scope getScope() {
		return scope;
	}
	/**
	 * @param scope The scope to set.
	 */
	public void setScope(Scope scope) {
		this.scope = scope;
	}
	/**
	 * @return Returns the symbol.
	 */
	public Object getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol The symbol to set.
	 */
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

    public Statement getCurrentStatement() {
        return currentStatement;
    }

    public void setCurrentStatement(Statement currentStatement) {
        this.currentStatement = currentStatement;
    }
}
