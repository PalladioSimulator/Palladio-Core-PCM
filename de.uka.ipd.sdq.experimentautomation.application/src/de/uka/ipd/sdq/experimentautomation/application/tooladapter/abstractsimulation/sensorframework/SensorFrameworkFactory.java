package de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.sensorframework;

import org.eclipse.core.runtime.Path;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.FileDatasource;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFrameworkDatasource;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public class SensorFrameworkFactory {

    public static IDAOFactory createOrOpenDatasource(SensorFrameworkDatasource datasource) {
        IDAOFactory daoFactory = null;
        if (AbstractSimulationPackage.eINSTANCE.getMemoryDatasource().isInstance(datasource)) {
            // create MemoryDatasource
            daoFactory = SensorFrameworkFactory.createMemoryDatasource();
        } else if (AbstractSimulationPackage.eINSTANCE.getFileDatasource().isInstance(datasource)) {
            // create or open FileDatasource
            FileDatasource fileDatasource = (FileDatasource) datasource;
            Path directory = new Path(fileDatasource.getLocation());
            daoFactory = SensorFrameworkFactory.createOrOpenFileDatasource(directory);
        } else {
            throw new RuntimeException("Could not determine datasource type. This should not have happened.");
        }
        SensorFrameworkDataset.singleton().addDataSource(daoFactory);

        return daoFactory;
    }
    
    public static void closeDatasource(SensorFrameworkDatasource datasource) {
        IDAOFactory daoFactory = null;
        if (AbstractSimulationPackage.eINSTANCE.getMemoryDatasource().isInstance(datasource)) {
            // create MemoryDatasource
            daoFactory = SensorFrameworkFactory.createMemoryDatasource();
        } else if (AbstractSimulationPackage.eINSTANCE.getFileDatasource().isInstance(datasource)) {
            // create or open FileDatasource
            FileDatasource fileDatasource = (FileDatasource) datasource;
            Path directory = new Path(fileDatasource.getLocation());
            daoFactory = SensorFrameworkFactory.createOrOpenFileDatasource(directory);
        } else {
            throw new RuntimeException("Could not determine datasource type. This should not have happened.");
        }
        SensorFrameworkDataset.singleton().removeDataSource(daoFactory);
    }

    private static IDAOFactory createOrOpenFileDatasource(Path directory) {
        IDAOFactory fileFactory = new FileDAOFactory(directory.toOSString());

        return fileFactory;
    }

    private static IDAOFactory createMemoryDatasource() {
        return new MemoryDAOFactory("");
    }

}
