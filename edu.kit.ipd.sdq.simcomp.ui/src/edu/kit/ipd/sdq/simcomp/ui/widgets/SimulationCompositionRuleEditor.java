package edu.kit.ipd.sdq.simcomp.ui.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.meta.IContextFieldValueProvider;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentRequiredType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationContextField;
import edu.kit.ipd.sdq.simcomp.config.ISimulatorCompositonRule;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulatorCompositonRule;
import edu.kit.ipd.sdq.simcomp.ui.listener.IModificationListener;

/**
 * The simulation component rule editor is an SWT based editor to create a set
 * of simulator composition rules for a given simulation component type. The
 * rule editor is intended to be used to build the simulator configuration in
 * the launch configuration editor.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SimulationCompositionRuleEditor {

	private IPCMModel model;
	private ISimulationMiddleware middleware;
	private SimulationComponentRequiredType simCompRequiredType;
	private List<SimulationComponentImpl> availableComponents;
	private IModificationListener modificationListener;

	private Table tblCompositionRules;
	private Combo cmbDefaultComponent;
	private Button btnCreate;
	private Button btnDelete;
	private Button btnMoveUp;
	private Button btnMoveDown;

	public SimulationCompositionRuleEditor(Composite parent, SimulationComponentRequiredType simCompRequiredType, ISimulationMiddleware middleware, IModificationListener modificationListener) {

		this.simCompRequiredType = simCompRequiredType;
		this.middleware = middleware;
		this.modificationListener = modificationListener;

		// prepare component list
		availableComponents = new ArrayList<SimulationComponentImpl>();
		List<SimulationComponentImpl> metadata = middleware.getSimulationComponentMetadata();

		for (SimulationComponentImpl component : metadata) {
			List<SimulationComponentType> providedTypes = component.getProvidedTypes();

			for (SimulationComponentType providedType : providedTypes) {
				if (providedType.equals(simCompRequiredType.getType())) {
					availableComponents.add(component);
				}
			}
		}

		// build widget
		final Group simCompTypeGroup = new Group(parent, SWT.NONE);
		simCompTypeGroup.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		simCompTypeGroup.setText("Required Interface: " + simCompRequiredType.getType().getName());
		simCompTypeGroup.setLayout(new GridLayout(2, false));

		final Composite tableContainer = new Composite(simCompTypeGroup, SWT.NONE);
		tableContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tableContainer.setLayout(new GridLayout(1, false));

		this.createDefaultComponentSelection(tableContainer);

		this.createRuleTable(tableContainer);

		final Composite controls = new Composite(simCompTypeGroup, SWT.NONE);
		controls.setLayout(new GridLayout(1, false));

		this.createControls(controls);
	}

	/**
	 * Creates the controls for the default component selection.
	 * 
	 * @param parent
	 */
	private void createDefaultComponentSelection(Composite parent) {
		Composite defaulSelection = new Composite(parent, SWT.NONE);
		defaulSelection.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		defaulSelection.setLayout(new GridLayout(2, false));

		final Label label = new Label(defaulSelection, SWT.NONE);
		label.setText("Default component:");

		cmbDefaultComponent = new Combo(defaulSelection, SWT.READ_ONLY);
		cmbDefaultComponent.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		cmbDefaultComponent.setEnabled(false);
		cmbDefaultComponent.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				modificationListener.modified();
			}
		});
	}

	/**
	 * Creates the table for the rule editing
	 * 
	 * @param parent
	 */
	private void createRuleTable(Composite parent) {

		// create the basic table
		tblCompositionRules = new Table(parent, SWT.BORDER | SWT.MULTI);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.heightHint = 140;
		tblCompositionRules.setLayoutData(gridData);
		tblCompositionRules.setLinesVisible(true);
		tblCompositionRules.setHeaderVisible(true);

		// create the context field columns
		for (SimulationContextField contextField : this.simCompRequiredType.getContextFields()) {
			TableColumn column = new TableColumn(tblCompositionRules, SWT.NONE);
			column.setText(contextField.getName());
			column.setWidth(200);
		}
		// add selected component column
		TableColumn column = new TableColumn(tblCompositionRules, SWT.NONE);
		column.setText("Simulation Component");
		column.setWidth(200);

		final TableEditor editor = new TableEditor(tblCompositionRules);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;

		tblCompositionRules.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Rectangle clientArea = tblCompositionRules.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = tblCompositionRules.getTopIndex();
				while (index < tblCompositionRules.getItemCount()) {
					boolean visible = false;
					final TableItem item = tblCompositionRules.getItem(index);
					for (int i = 0; i < tblCompositionRules.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);

						if (rect.contains(pt)) {
							final int column = i;

							final Combo combo = new Combo(tblCompositionRules, SWT.READ_ONLY);
							combo.setItems(getPossibleValuesForColumn(column));
							combo.select(0);

							Listener comboListener = new Listener() {
								@Override
								public void handleEvent(final Event e) {
									switch (e.type) {
									case SWT.FocusOut:
										item.setText(column, combo.getText());
										combo.dispose();
										modificationListener.modified();
										break;
									case SWT.Traverse:
										switch (e.detail) {
										case SWT.TRAVERSE_RETURN:
											item.setText(column, combo.getText());
											// FALL THROUGH
										case SWT.TRAVERSE_ESCAPE:
											combo.dispose();
											e.doit = false;
										}
										break;
									}
								}
							};

							combo.addListener(SWT.FocusOut, comboListener);
							combo.addListener(SWT.Traverse, comboListener);
							editor.setEditor(combo, item, i);

							combo.setText(item.getText(i));
							combo.setFocus();

							return;
						}
						if (!visible && rect.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible)
						return;
					index++;
				}
			}
		});

		tblCompositionRules.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] selection = tblCompositionRules.getSelectionIndices();
				// prevent user from moving if more than one item is selected
				if (tblCompositionRules.getItemCount() < 1 || selection.length != 1) {
					btnMoveUp.setEnabled(false);
					btnMoveDown.setEnabled(false);
					btnDelete.setEnabled(false);
					return;
				}

				// update move buttons enabled/disabled state
				int selectedIndex = selection[0];
				updateButtonsForSelection(selectedIndex);
			}

		});
	}

	private String[] getPossibleValuesForColumn(int column) {
		String[] possibleValues = new String[0];

		if (column < simCompRequiredType.getContextFields().size()) {
			// context field column selected
			SimulationContextField field = simCompRequiredType.getContextFields().get(column);
			IContextFieldValueProvider valueProvider = middleware.getValueProviderForContextField(field);
			List<String> possibleValueList = valueProvider.getPossibleValues(model);
			possibleValues = possibleValueList.toArray(new String[possibleValueList.size() + 1]);
			System.arraycopy(possibleValues, 0, possibleValues, 1, possibleValueList.size());
			possibleValues[0] = ISimulatorCompositonRule.ANY_VALUE;

			return possibleValues;
		} else {
			// simulation component field selected
			possibleValues = new String[availableComponents.size()];
			for (int j = 0; j < availableComponents.size(); j++) {
				possibleValues[j] = availableComponents.get(j).toString();
			}

			return possibleValues;
		}
	}

	/**
	 * Creates the controls which create, delete or modify a rules position.
	 * 
	 * @param parent
	 */
	private void createControls(Composite parent) {
		btnCreate = new Button(parent, SWT.PUSH);
		btnCreate.setText("Create Rule");
		btnCreate.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				createNewRuleItem(tblCompositionRules);

				tblCompositionRules.deselectAll();
				tblCompositionRules.setSelection(tblCompositionRules.getItems().length - 1);
				tblCompositionRules.setFocus();
				modificationListener.modified();
			}
		});

		btnDelete = new Button(parent, SWT.PUSH);
		btnDelete.setText("Delete Rule");
		btnDelete.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		btnDelete.setEnabled(false);
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tblCompositionRules.remove(tblCompositionRules.getSelectionIndices());
				modificationListener.modified();
			}
		});

		btnMoveUp = new Button(parent, SWT.PUSH);
		btnMoveUp.setText("Move Up");
		btnMoveUp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		btnMoveUp.setEnabled(false);
		btnMoveUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblCompositionRules.getSelectionIndices()[0];
				moveTableItem(tblCompositionRules, selectedIndex, selectedIndex - 1);
				modificationListener.modified();
			}
		});

		btnMoveDown = new Button(parent, SWT.PUSH);
		btnMoveDown.setText("Move Down");
		btnMoveDown.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		btnMoveDown.setEnabled(false);
		btnMoveDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblCompositionRules.getSelectionIndices()[0];
				moveTableItem(tblCompositionRules, selectedIndex, selectedIndex + 1);
				modificationListener.modified();
			}
		});
	}

	/**
	 * Creates a new simulator composition rule entry with default values
	 * 
	 * @param table
	 */
	private void createNewRuleItem(Table table) {
		String[] values = new String[table.getColumnCount()];
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (i < (table.getColumnCount() - 1)) {
				// field column
				values[i] = ISimulatorCompositonRule.ANY_VALUE;
			} else {
				// component column
				values[i] = availableComponents.get(0).getName();
			}
		}

		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(values);
	}

	/**
	 * Moves an item in the given table from a given index to specified target
	 * index.
	 * 
	 * @param table
	 * @param fromIndex
	 * @param toIndex
	 */
	public void moveTableItem(Table table, int fromIndex, int toIndex) {

		TableItem toItem = table.getItem(toIndex);
		String[] toValues = new String[table.getColumnCount()];
		for (int i = 0; i < toValues.length; i++) {
			toValues[i] = toItem.getText(i);
		}
		table.remove(toIndex);

		TableItem newItem = new TableItem(table, SWT.NONE, fromIndex);
		newItem.setText(toValues);

		table.select(toIndex);

		updateButtonsForSelection(toIndex);
	}

	/**
	 * Updates the enabled/disabled state of the move buttons depending on the
	 * selected index to prevent the user from moving border items out of the
	 * table.
	 * 
	 * @param selectedIndex
	 */
	private void updateButtonsForSelection(int selectedIndex) {
		btnDelete.setEnabled(true);

		if (tblCompositionRules.getItemCount() == 1) {
			btnMoveUp.setEnabled(false);
			btnMoveDown.setEnabled(false);

			return;
		}

		if (selectedIndex == 0) {
			btnMoveUp.setEnabled(false);
			btnMoveDown.setEnabled(true);

			return;
		}
		if (selectedIndex == (tblCompositionRules.getItemCount() - 1)) {
			btnMoveUp.setEnabled(true);
			btnMoveDown.setEnabled(false);

			return;
		}

		btnMoveUp.setEnabled(true);
		btnMoveDown.setEnabled(true);
	}

	/**
	 * Updates the default component configuration
	 * 
	 * @param simulationComponentMetaData
	 */
	public void updateDefaultComponent(SimulationComponentImpl component) {
		if (component != null) {
			// TODO switch to something ID based
			String[] items = cmbDefaultComponent.getItems();
			for (int i = 0; i < items.length; i++) {
				if (items[i].equals(component.getName())) {
					cmbDefaultComponent.select(i);
					break;
				}
			}
		} else {
			cmbDefaultComponent.select(0);
		}
	}

	/**
	 * Returns the selected default component for the currently edited component
	 * type.
	 * 
	 * @return
	 */
	public SimulationComponentImpl getDefaultComponent() {
		if (this.model == null) {
			return null;
		}
		if (cmbDefaultComponent.getSelectionIndex() >= 0) {
			for (SimulationComponentImpl component : availableComponents) {
				if (component.getName().equals(cmbDefaultComponent.getItems()[cmbDefaultComponent.getSelectionIndex()])) {
					return component;
				}
			}
		}

		return null;
	}

	/**
	 * Updates the list of composition rules.
	 * 
	 * @param compositionRules
	 */
	public void updateCompositionRules(List<ISimulatorCompositonRule> compositionRules) {
		tblCompositionRules.clearAll();
		tblCompositionRules.setItemCount(0);

		if (compositionRules == null) {
			return;
		}

		for (ISimulatorCompositonRule rule : compositionRules) {
			TableItem ruleItem = new TableItem(tblCompositionRules, SWT.NONE);

			for (int i = 0; i < simCompRequiredType.getContextFields().size(); i++) {
				SimulationContextField contextField = simCompRequiredType.getContextFields().get(i);
				ruleItem.setText(i, rule.getFieldValues().get(contextField));
			}

			ruleItem.setText(simCompRequiredType.getContextFields().size(), rule.getComponent().getName());

		}
	}

	/**
	 * Returns the user configured simulator composition rules.
	 * 
	 * @return
	 */
	public List<ISimulatorCompositonRule> getCompositionRules() {
		List<ISimulatorCompositonRule> rules = new ArrayList<ISimulatorCompositonRule>();

		TableItem[] ruleTableItems = tblCompositionRules.getItems();
		// iterate over rule rows
		for (TableItem tableItem : ruleTableItems) {
			Map<SimulationContextField, String> fieldValues = new HashMap<SimulationContextField, String>();

			SimulationComponentImpl selectedComponent = null;

			// iterate context field columns
			for (int i = 0; i < tblCompositionRules.getColumnCount(); i++) {
				if (i < (tblCompositionRules.getColumnCount() - 1)) {
					// field column
					SimulationContextField field = simCompRequiredType.getContextFields().get(i);
					String fieldValue = tableItem.getText(i);
					fieldValues.put(field, fieldValue);
				} else {
					// component column
					String componentName = tableItem.getText(i);
					for (SimulationComponentImpl component : availableComponents) {
						if (component.getName().equals(componentName)) {
							selectedComponent = component;
							break;
						}
					}
					
					if (selectedComponent == null) {
						throw new IllegalStateException("Selected component \"" + componentName + "\" not found in avalable component list");
					}
				}
			}

			rules.add(new SimulatorCompositonRule(simCompRequiredType, fieldValues, selectedComponent));
		}

		return rules;
	}

	/**
	 * Updates the user specified PCM model.
	 * 
	 * @param pcmModel
	 *            A loaded PCM model or null if the user deselected it
	 */
	public void updatePCMModel(IPCMModel model) {
		this.model = model;

		if (model == null) {
			this.tblCompositionRules.setEnabled(false);
			this.btnCreate.setEnabled(false);
			this.btnDelete.setEnabled(false);
			this.btnMoveUp.setEnabled(false);
			this.btnMoveDown.setEnabled(false);
			this.cmbDefaultComponent.setEnabled(false);
		} else {
			this.tblCompositionRules.setEnabled(true);
			this.btnCreate.setEnabled(true);

			List<String> componentNames = new ArrayList<String>();
			for (SimulationComponentImpl component : availableComponents) {
				componentNames.add(component.getName());
			}
			this.cmbDefaultComponent.setItems(componentNames.toArray(new String[0]));
			this.cmbDefaultComponent.setEnabled(true);
		}
	}
}