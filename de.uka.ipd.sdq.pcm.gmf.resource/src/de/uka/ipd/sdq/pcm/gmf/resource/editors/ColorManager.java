package de.uka.ipd.sdq.pcm.gmf.resource.editors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * A ColorManager.
 */
public class ColorManager {

    /**
     * The ColorTable.
     */
    protected Map fColorTable = new HashMap(10);

    /**
     * Disposes of the ColorTable.
     */
    public void dispose() {
        Iterator e = fColorTable.values().iterator();
        while (e.hasNext()) {
            ((Color) e.next()).dispose();
        }
    }

    /**
     * @param rgb
     *            the Color
     * @return color
     */
    public Color getColor(RGB rgb) {
        Color color = (Color) fColorTable.get(rgb);
        if (color == null) {
            color = new Color(Display.getCurrent(), rgb);
            fColorTable.put(rgb, color);
        }
        return color;
    }
}
