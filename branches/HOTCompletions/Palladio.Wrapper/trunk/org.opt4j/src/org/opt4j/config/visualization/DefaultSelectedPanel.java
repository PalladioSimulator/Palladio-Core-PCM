/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.config.visualization;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.opt4j.config.PropertyModule;
import org.opt4j.config.annotations.Panel;

import com.google.inject.Inject;

/**
 * The {@code DefaultSelectedPanel}. The selected modules are organized as tabs.
 * 
 * @author lukasiewycz
 * 
 */
@SuppressWarnings("serial")
public class DefaultSelectedPanel extends SelectedPanel implements SetListener {

	protected class MyScrollPane extends JScrollPane {

		PropertyPanel panel;

		public MyScrollPane(PropertyPanel panel) {
			super(panel);
			this.panel = panel;
		}

		public PropertyPanel getPanel() {
			return panel;
		}

	}

	/**
	 * The custom {@code JTabbedPane}.
	 */
	protected class TabbedPane extends JTabbedPane {
		@Override
		public void remove(int index) {
			Component component = tabs.getComponentAt(index);
			super.remove(index);

			if (component instanceof MyScrollPane) {
				MyScrollPane scroll = (MyScrollPane) component;
				map.remove(scroll.getPanel().getModule());
			}
		}

		protected int getIndex(PropertyModule module) {
			if (map.keySet().contains(module)) {
				for (int i = 0; i < tabs.getTabCount(); i++) {
					Component component = tabs.getComponentAt(i);
					if (component instanceof MyScrollPane) {
						MyScrollPane scroll = (MyScrollPane) component;
						if (scroll.getPanel().getModule().equals(module)) {
							return i;
						}
					}
				}
			}
			return -1;
		}
	}

	/**
	 * The custom tab of the {@code JTabbedPane}.
	 */
	protected class TabComponent extends JPanel {

		private final PropertyModule module;

		public TabComponent(PropertyModule module) {
			super(new FlowLayout(FlowLayout.LEFT, 0, 0));
			this.module = module;
			setOpaque(false);

			String name = format.getName(module);
			ImageIcon icon = format.getIcon(module);

			if (name.length() > 22) {
				name = name.substring(0, 18) + "...";
			}

			JLabel label = new JLabel(name, icon, SwingConstants.LEFT);
			add(label);
			label.setBorder(BorderFactory.createEmptyBorder(0, icon == null ? 5
					: 0, 0, 5));

			JButton button = new TabButton();
			add(button);
			setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
		}

		private class TabButton extends JButton implements ActionListener {

			protected final static int SIZE = 16;

			public TabButton() {

				setPreferredSize(new Dimension(SIZE, SIZE));

				setContentAreaFilled(false);
				setFocusable(false);

				setBorder(BorderFactory.createEtchedBorder());
				setBorderPainted(false);

				addMouseListener(buttonMouseListener);
				setRolloverEnabled(true);

				addActionListener(this);
			}

			public void actionPerformed(ActionEvent e) {
				int i = tabs.indexOfTabComponent(TabComponent.this);
				if (i != -1) {
					selectedModules.remove(module);
				}
			}

			// paint the cross
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				// shift the image for pressed buttons
				if (getModel().isPressed()) {
					g2.translate(1, 1);
				}
				g2.setStroke(new BasicStroke(2));
				g2.setColor(Color.RED);

				int delta = 5;
				g2.drawLine(delta, delta, getWidth() - delta - 2, getHeight()
						- delta - 2);
				g2.drawLine(getWidth() - delta - 2, delta, delta, getHeight()
						- delta - 2);
				g2.dispose();
			}
		}

		private final MouseListener buttonMouseListener = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Component component = e.getComponent();
				if (component instanceof AbstractButton) {
					AbstractButton button = (AbstractButton) component;
					button.setBorderPainted(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Component component = e.getComponent();
				if (component instanceof AbstractButton) {
					AbstractButton button = (AbstractButton) component;
					button.setBorderPainted(false);
				}
			}
		};
	}

	protected final TabbedPane tabs = new TabbedPane();

	protected final Format format;

	protected final SelectedModules selectedModules;

	protected final FileChooser fileChooser;

	protected final Map<PropertyModule, PropertyPanel> map = new HashMap<PropertyModule, PropertyPanel>();

	protected final DropTarget dropTarget;

	/**
	 * The drop listener for the drag-and-drop functionality.
	 */
	protected final DropTargetListener dropListener = new DropTargetAdapter() {
		public void drop(DropTargetDropEvent dtde) {
			Transferable transferable = dtde.getTransferable();
			DataFlavor flaver = ModuleTransferable.localModuleFlaver;
			try {

				if (transferable.isDataFlavorSupported(flaver)) {
					Object o = transferable.getTransferData(flaver);
					PropertyModule module = (PropertyModule) o;
					selectedModules.add(module);

					dtde.acceptDrop(DnDConstants.ACTION_MOVE);
					dtde.getDropTargetContext().dropComplete(true);
				} else {
					dtde.rejectDrop();
				}

			} catch (UnsupportedFlavorException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};

	/**
	 * Constructs a {@code DefaultSelectedPanel}.
	 * 
	 * @param format
	 *            the format
	 * @param selectedModules
	 *            the selected modules
	 * @param fileChooser
	 *            the file chooser
	 */
	@Inject
	public DefaultSelectedPanel(Format format, SelectedModules selectedModules,
			FileChooser fileChooser) {
		super();
		this.format = format;
		this.selectedModules = selectedModules;
		this.fileChooser = fileChooser;

		dropTarget = new DropTarget(this, dropListener);

	}

	/**
	 * Registers the listeners.
	 */
	@Inject
	public void init() {
		selectedModules.addListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.conf.gui.Startupable#startup()
	 */
	public void startup() {
		setLayout(new BorderLayout());
		add(tabs);
	}

	/**
	 * Adds a module to the panel.
	 * 
	 * @param module
	 *            the module to add
	 */
	protected void addModule(PropertyModule module) {
		if (!map.keySet().contains(module)) {

			PropertyPanel panel = null;
			Panel p = module.getModule().getClass().getAnnotation(Panel.class);
			if (p != null) {
				Class<? extends PropertyPanel> clazz = p.value();

				try {
					Constructor<? extends PropertyPanel> cstr = clazz
							.getConstructor(PropertyModule.class,
									FileChooser.class, Format.class);
					panel = cstr.newInstance(module, fileChooser, format);

				} catch (Exception e) {
					throw new RuntimeException(e);
				}

			} else {
				panel = new PropertyPanel(module, fileChooser, format);
			}

			MyScrollPane scroll = new MyScrollPane(panel);
			scroll
					.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroll.setPreferredSize(new Dimension(300, 300));

			String name = format.getName(module);
			String tooltip = format.getTooltip(module);

			int count = selectedModules.subSet(selectedModules.first(), module)
					.size();
			tabs.insertTab(name, null, scroll, tooltip, count);
			tabs.setSelectedIndex(count);
			tabs.setTabComponentAt(count, new TabComponent(module));

			map.put(module, panel);

		} else {
			int index = tabs.getIndex(module);
			if (index != -1) {
				tabs.setSelectedIndex(index);
			}
		}
	}

	/**
	 * Removes a module from the panel.
	 * 
	 * @param module
	 *            the module to remove
	 */
	protected void removeModule(PropertyModule module) {
		int index = tabs.getIndex(module);
		if (index != -1) {
			map.remove(module);
			tabs.remove(index);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.conf.gui.SetListener#moduleAdded(java.util.Collection,
	 * org.opt4j.conf.PropertyModule)
	 */
	public void moduleAdded(Collection<PropertyModule> collection,
			PropertyModule module) {
		addModule(module);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.conf.gui.SetListener#moduleRemoved(java.util.Collection,
	 * org.opt4j.conf.PropertyModule)
	 */
	public void moduleRemoved(Collection<PropertyModule> collection,
			PropertyModule module) {
		removeModule(module);
	}

}
