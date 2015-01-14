package org.palladiosimulator.protocom.framework.java.se.utils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.palladiosimulator.protocom.framework.java.se.AbstractAllocationStorage;

public class UserMenu {
    protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

    /**
     * Shows the user menu and receives user selections
     * 
     * @return List of selections the user made
     */
    public static List<Integer> showUserMenu(String[][] systems) {
        System.out.println("Select starting option:");
        showMenuItems(systems);
        System.out.print("Option: ");
        Scanner sc = new Scanner(System.in);
        String st = null;
        if (sc.hasNextLine()) {
            st = sc.nextLine();
        }
        sc.close();

        List<Integer> ids = new LinkedList<Integer>();
        if (st != null) {
            sc = new Scanner(st);

            while (sc.hasNextInt()) {
                ids.add(sc.nextInt());
            }
        }
        sc.close();

        return ids;
    }

    /**
     * Shows the list of menu items
     */
    private static void showMenuItems(String[][] systems) {
        System.out
                .println("1: Start everything in local mode (hardware container #1 is used, only for testing purpose!)");
        System.out.println("2: RmiRegistry");
        System.out.println("3: Usage Scenarios");

        int i = 4;

        // systems
        for (String[] system : systems) {
            System.out.println(i + ": System " + system[1]);
            i++;
        }

        // container
        Collection<String> containers = AbstractAllocationStorage.getContainerNames();
        for (String container : containers) {
            System.out.println(i + ": Container " + container);
            i++;
        }
    }
}
