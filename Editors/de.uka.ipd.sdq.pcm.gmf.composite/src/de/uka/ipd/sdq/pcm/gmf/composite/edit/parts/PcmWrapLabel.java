package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.swt.graphics.Image;

/**
 * The Class PcmWrapLabel.
 */
public class PcmWrapLabel extends WrapLabel {

    /**
     * Instantiates a new pcm wrap label.
     */
    public PcmWrapLabel() {
        super();
        this.setAlignment(PositionConstants.CENTER);
    }

    /**
     * Instantiates a new pcm wrap label.
     * 
     * @param i
     *            the i
     */
    public PcmWrapLabel(Image i) {
        super(i);
        this.setAlignment(PositionConstants.CENTER);
    }

    /**
     * Instantiates a new pcm wrap label.
     * 
     * @param s
     *            the s
     * @param i
     *            the i
     */
    public PcmWrapLabel(String s, Image i) {
        super(s, i);
        this.setAlignment(PositionConstants.CENTER);
    }

    /**
     * Instantiates a new pcm wrap label.
     * 
     * @param s
     *            the s
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
