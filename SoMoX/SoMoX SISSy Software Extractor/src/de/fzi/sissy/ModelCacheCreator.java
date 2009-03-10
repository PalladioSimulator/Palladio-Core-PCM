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

import de.fzi.sissy.metamod.*;
import de.fzi.sissy.util.Debug;

/**
 * @author povalahe
 *
 */
public class ModelCacheCreator {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            
        }
        Debug.setDebugLevel(6);
        do {
            ModelLoader ml = new JavaExtractorModelLoader();
            ml.configure();
            ModelElementRepository mer = ml.loadRepository();
            if (mer == null) {
                JOptionPane.showMessageDialog(null, "Error", "Model parsing was not successful", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            String fileName = "";
            JFileChooser f = new JFileChooser();
            f.setDialogTitle("Please select the cache file");
            if (f.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                fileName = f.getSelectedFile().getAbsolutePath();
                mer.serializeToFile(new java.io.File(fileName));
            }
            
        } while (JOptionPane.showConfirmDialog(null, "Do you want to extract another model and save it?", "Once more?", 
                 JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
        System.exit(0);
    }
}
