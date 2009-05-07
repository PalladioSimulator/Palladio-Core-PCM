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
package de.fzi.sissy;

import javax.swing.*;
import java.io.File;

import de.fzi.sissy.metamod.*;


/**
 * @author povalahe
 *
 */
public class CacheModelLoader implements ModelLoader {
    private String fileName = "";
    
    public ModelElementRepository loadRepository() {
        if ((fileName != null) && (fileName != "")) {
            ModelElementRepository m  = ModelElementRepository.deserializeFromFile(new File(fileName));
            return m;
        }
        return null;
    }
    
    public void configure() {
        JFileChooser f = new JFileChooser();
        f.setDialogTitle("Please select the cache file");
        if (f.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            fileName = f.getSelectedFile().getAbsolutePath();
        f = null;
    }
    
    public void setParameters(String args[]) {
        if ((args.length > 0) && (args[0] != null))
            fileName = args[0];
    }
}
