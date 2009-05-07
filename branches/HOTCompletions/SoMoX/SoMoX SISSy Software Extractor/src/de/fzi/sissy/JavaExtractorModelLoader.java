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

import javax.swing.JFileChooser;

import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.util.Debug;

/**
 * @author povalahe
 *
 */
public class JavaExtractorModelLoader implements ModelLoader {
    
    private String path = "";
    
    public ModelElementRepository loadRepository() {
        if ((path != null) && (path != "")) {
            try {
                new de.fzi.sissy.extractors.java.Extractor(new String[] {path, "-clone"}).extract();
                return ModelElementRepository.getWorkingRepository();
            } catch (Exception e) {
                Debug.error("Java extractor did not run correctly");
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public void configure() {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setDialogTitle("Select the directory to parse");
        if (f.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            path = f.getSelectedFile().getAbsolutePath();
        f = null;
    }
    
    public void setParameters(String args[]) {
        if ((args.length > 0) && (args[0] != null))
            path = args[0];
    }
}
