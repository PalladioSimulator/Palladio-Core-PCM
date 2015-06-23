/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

/**
 * @generated
 */
public class PalladioComponentModelTextSelectionEditPolicy extends org.eclipse.gef.editpolicies.SelectionEditPolicy implements org.eclipse.gmf.tooling.runtime.edit.policies.labels.IRefreshableFeedbackEditPolicy {

	

		/**
 * @generated
 */
	private org.eclipse.draw2d.IFigure selectionFeedbackFigure;

	/**
 * @generated
 */
	private org.eclipse.draw2d.IFigure focusFeedbackFigure;

	/**
 * @generated
 */
	private org.eclipse.draw2d.FigureListener hostPositionListener;
	
		/**
 * @generated
 */
	protected void showPrimarySelection() {
		if (getHostFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getHostFigure()).setSelected(true);
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getHostFigure()).setFocus(true);
		} else {
			showSelection();
			showFocus();
		}
	}
	
		/**
 * @generated
 */
	protected void showSelection() {
		if (getHostFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getHostFigure()).setSelected(true);
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getHostFigure()).setFocus(false);
		} else {
			hideSelection();
			addFeedback(selectionFeedbackFigure = createSelectionFeedbackFigure());
			getHostFigure().addFigureListener(getHostPositionListener());
			refreshSelectionFeedback();
			hideFocus();
		}
	}
	
		/**
 * @generated
 */
	protected void hideSelection() {
		if (getHostFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getHostFigure()).setSelected(false);
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getHostFigure()).setFocus(false);
		} else {
			if (selectionFeedbackFigure != null) {
				removeFeedback(selectionFeedbackFigure);
				getHostFigure().removeFigureListener(getHostPositionListener());
				selectionFeedbackFigure = null;
			}
			hideFocus();
		}
	}
	
		/**
 * @generated
 */
	protected void showFocus() {
		if (getHostFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getHostFigure()).setFocus(true);
		} else {
			hideFocus();
			addFeedback(focusFeedbackFigure = createFocusFeedbackFigure());
			refreshFocusFeedback();
		}
	}
	
		/**
 * @generated
 */
	protected void hideFocus() {
		if (getHostFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
			((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getHostFigure()).setFocus(false);
		} else {
			if (focusFeedbackFigure != null) {
				removeFeedback(focusFeedbackFigure);
				focusFeedbackFigure = null;
		}
		}
	}
	
		/**
 * @generated
 */
	protected org.eclipse.draw2d.geometry.Rectangle getFeedbackBounds() {
		org.eclipse.draw2d.geometry.Rectangle bounds;
		if (getHostFigure() instanceof org.eclipse.draw2d.Label) {
			bounds = ((org.eclipse.draw2d.Label) getHostFigure()).getTextBounds();
			bounds.intersect(getHostFigure().getBounds());
		} else {
			bounds = getHostFigure().getBounds().getCopy();
		}
		getHostFigure().getParent().translateToAbsolute(bounds);
		getFeedbackLayer().translateToRelative(bounds);
		return bounds;
	}
	
		/**
 * @generated
 */
	protected org.eclipse.draw2d.IFigure createSelectionFeedbackFigure() {
		if (getHostFigure() instanceof org.eclipse.draw2d.Label) {
			org.eclipse.draw2d.Label feedbackFigure = new org.eclipse.draw2d.Label();
			feedbackFigure.setOpaque(true);
			feedbackFigure.setBackgroundColor(org.eclipse.draw2d.ColorConstants.menuBackgroundSelected);
			feedbackFigure.setForegroundColor(org.eclipse.draw2d.ColorConstants.menuForegroundSelected);
			return feedbackFigure;
		} else {
			org.eclipse.draw2d.RectangleFigure feedbackFigure = new org.eclipse.draw2d.RectangleFigure();
			feedbackFigure.setFill(false);
			return feedbackFigure;
		}
	}

		/**
 * @generated
 */
	protected org.eclipse.draw2d.IFigure createFocusFeedbackFigure() {
		return new org.eclipse.draw2d.Figure() {

			protected void paintFigure(org.eclipse.draw2d.Graphics graphics) {
				graphics.drawFocus(getBounds().getResized(-1, -1));
			}
		};
	}

		/**
 * @generated
 */
	protected void updateLabel(org.eclipse.draw2d.Label target) {
		org.eclipse.draw2d.Label source = (org.eclipse.draw2d.Label) getHostFigure();
		target.setText(source.getText());
		target.setTextAlignment(source.getTextAlignment());
		target.setFont(source.getFont());
	}

		/**
 * @generated
 */
	protected void refreshSelectionFeedback() {
		if (selectionFeedbackFigure != null) {
			if (selectionFeedbackFigure instanceof org.eclipse.draw2d.Label) {
				updateLabel((org.eclipse.draw2d.Label) selectionFeedbackFigure);
				selectionFeedbackFigure.setBounds(getFeedbackBounds());
			} else {
				selectionFeedbackFigure.setBounds(getFeedbackBounds().expand(5, 5));
			}
		}
	}
	
		/**
 * @generated
 */
	protected void refreshFocusFeedback() {
		if (focusFeedbackFigure != null) {
			focusFeedbackFigure.setBounds(getFeedbackBounds());
		}
	}
	
		/**
 * @generated
 */
	@Override
	public void refreshFeedback() {
		refreshSelectionFeedback();
		refreshFocusFeedback();
	}
	
		/**
 * @generated
 */
	private org.eclipse.draw2d.FigureListener getHostPositionListener() {
		if (hostPositionListener == null) {
			hostPositionListener = new org.eclipse.draw2d.FigureListener() {
				public void figureMoved(org.eclipse.draw2d.IFigure source) {
					refreshFeedback();
				}
			};
		}
		return hostPositionListener;
	}

	
	}
