package de.uka.ipd.sdq.pcm.dialogs.exception;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

import de.uka.ipd.sdq.pcm.repository.ExceptionType;

/** author roman */
public class ExceptionsCellModifier implements ICellModifier {

    private List<String> columnNames;
    private ExceptionType exceptionType;
    private TableViewer viewer;

    /**
     * The transactional editing domain which is used to get the commands and alter the model
     */
    protected TransactionalEditingDomain editingDomain = null;

    public ExceptionsCellModifier(TableViewer viewer, TransactionalEditingDomain editingDomain) {
        this.columnNames = Arrays.asList(ExceptionsDialog.getColumnNames());
        this.editingDomain = editingDomain;
        this.viewer = viewer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
     */
    public boolean canModify(Object element, String property) {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
     */
    public Object getValue(Object element, String property) {
        return (new ExceptionsItemProvider(null)).getColumnText(element, columnNames.indexOf(property));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String,
     * java.lang.Object)
     */
    public void modify(Object element, String property, Object value) {

        // Find the index of the column
        int columnIndex = columnNames.indexOf(property);

        Assert.isNotNull(element);
        TableItem item = (TableItem) element;
        exceptionType = (ExceptionType) item.getData();

        switch (columnIndex) {
        case ExceptionsDialog.ICON_COLUMN_INDEX: // COMPLETED_COLUMN
            break;
        case ExceptionsDialog.CONTEXT_COLUMN_INDEX: // RETURNTYPE_COLUMN
            break;
        case ExceptionsDialog.NAME_COLUMN_INDEX: // SERVICENAME_COLUMN
            String valueString = ((String) value).trim();
            setExceptionName(valueString);
            break;
        default:
        }
    }

    /**
     * Set ExceptionName of the selected Signature
     */
    private void setExceptionName(final String value) {

        RecordingCommand recCommand = new RecordingCommand(editingDomain) {
            @Override
            protected void doExecute() {
                exceptionType.setExceptionName(value);
            }
        };

        if (!value.equals(exceptionType.getExceptionName())) {
            recCommand.setLabel("Set ParameterName");
            editingDomain.getCommandStack().execute(recCommand);

            /** Refresh TableViewer */
            viewer.refresh();
        }
    }
}
