package de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.swt.graphics.Image;

/**
 * A PCM wrap Label.
 */
public class PcmWrapLabel extends WrapLabel {

    /**
	 * 
	 */
    public PcmWrapLabel() {
        super();
        this.setAlignment(PositionConstants.CENTER);
    }

    /**
     * @param i an Image
     */
    public PcmWrapLabel(Image i) {
        super(i);
        this.setAlignment(PositionConstants.CENTER);
    }

    /**
     * @param s a String
     * @param i an Image
     */
    public PcmWrapLabel(String s, Image i) {
        super(s, i);
        this.setAlignment(PositionConstants.CENTER);
    }

    /**
     * @param s a String
     */
    public PcmWrapLabel(String s) {
        super(s);
        this.setAlignment(PositionConstants.CENTER);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.draw2d.Figure#getMaximumSize()
     */
    @Override
    public Dimension getMaximumSize() {
        Dimension d = super.getMaximumSize();
        Dimension newDim = new Dimension(d.width, getPreferredSize().height);

        return newDim;
    }

}
