package org.palladiosimulator.protocom.framework.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.junit.Before;
import org.junit.Test;
import org.palladiosimulator.protocom.framework.java.se.strategies.PassiveResource;
import org.palladiosimulator.protocom.framework.java.se.strategies.PassiveResourceRegistry;

public class PassiveResourcesTest {
    private static final int CAPACITY = 1;
    private static final String PR1 = "pr1";
    private static final String PR2 = "pr2";

    @Before
    public void initialise() {
        final PassiveResource pr1 = new PassiveResource(CAPACITY, PR1);
        final PassiveResource pr2 = new PassiveResource(CAPACITY + 1, PR2);
        PassiveResourceRegistry.singleton().addPassiveResource(pr1);
        PassiveResourceRegistry.singleton().addPassiveResource(pr2);

        Logger.getLogger(PassiveResource.class.getName()).addAppender(new ConsoleAppender(new SimpleLayout()));
    }

    @Test
    public void testPassiveResources() throws IOException, InterruptedException {
        final ThreadGroup tg = new ThreadGroup("Acquiring Threads");

        PassiveResourceRegistry.singleton().getResource(PR1).acquire();

        final AcquiringThread at = new AcquiringThread();
        new Thread(tg, at).start();

        Thread.sleep(1000);
        assertTrue(tg.activeCount() == 1);

        PassiveResourceRegistry.singleton().getResource(PR1).release();

        Thread.sleep(100);
        assertTrue(tg.activeCount() == 0);

        PassiveResourceRegistry.singleton().getResource(PR2).acquire();
        PassiveResourceRegistry.singleton().getResource(PR2).acquire();
        PassiveResourceRegistry.singleton().getResource(PR2).release();
        PassiveResourceRegistry.singleton().getResource(PR2).release();

        final TryingThread tt = new TryingThread();
        new Thread(tg, tt).start();

        Thread.sleep(100);

    }

    class TryingThread implements Runnable {
        @Override
        public void run() {
            PassiveResourceRegistry.singleton().getResource(PR2).acquire();
            PassiveResourceRegistry.singleton().getResource(PR2).acquire();
            PassiveResourceRegistry.singleton().getResource(PR2).acquire();

            assertTrue(false);
        }
    }

    class AcquiringThread implements Runnable {
        @Override
        public void run() {
            PassiveResourceRegistry.singleton().getResource(PR1).acquire();
            Logger.getLogger(PassiveResource.class.getName()).debug("ACQUIRED! ");
        }
    }
}
