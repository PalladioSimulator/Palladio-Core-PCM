/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.benchmarks.serial;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.BitSet;

import deprecated.spec.harness.Constants;
import deprecated.spec.harness.Context;
import deprecated.spec.harness.Launch;
import deprecated.spec.harness.StopBenchmarkException;
import deprecated.spec.harness.Util;


final class Client extends Thread {
    
    private Socket socket;
    private Object[] instances;
    
    public Client(int portNumber, Object[] instances) {
        try {
            socket = new Socket("localhost", portNumber);
            if (socket == null) {
                throw new StopBenchmarkException("Failed to create socket on port: 'localhost:" + portNumber + "'");
            }
            this.instances = instances;
        } catch (IOException e) {
            e.printStackTrace(Context.getOut());
        }
    }
    
    public void run() {
        try {
            doDeserialization();
        } catch (Exception e) {
            e.printStackTrace(Context.getOut());
        }
    }
    BitSet results;
    
    private void doDeserialization() throws Exception {
        if (socket == null) {
            throw new StopBenchmarkException("Socket is null");
        }
        
        InputStream is = socket.getInputStream();
        
        if (is == null) {
            throw new StopBenchmarkException("InputStream is null");
        }
        
        BufferedInputStream bis = new BufferedInputStream(is);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        results = Utils.createBitSet();
        
        for (int j = 0; j < Utils.pairLoop; j ++) {
            Object[] obj = (Object[])ois.readObject();
            for (int i = 0; i < Utils.classesNumber * Utils.SCALE; i ++) {
                results.set((i % Utils.classesNumber),
                        results.get(i % Utils.classesNumber) && instances[i].equals(obj[i]));
            }
        }
        bis.close();
        ois.close();
        socket.close();
    }
}

final class Server extends Thread {
    private ServerSocket serialServer;
    private Socket client;
    private Object[] instances;
    
    public Server(ServerSocket serverSocket, Object[] instances) throws Exception {
        serialServer = serverSocket;
        this.instances = instances;
    }
    
    public void run() {
        try {
            client = serialServer.accept();
            doSerialization();
        } catch (Exception e) {
            e.printStackTrace(Context.getOut());
            try {
                client.close();
            } catch (Exception e1) {
                e.printStackTrace(Context.getOut());
            }
        }
    }
    
    private void doSerialization() throws Exception {
        OutputStream os = client.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        for (int j = 0; j < Utils.pairLoop; j ++) {
            oos.writeObject(instances);            
        }
        oos.flush();
        os.close();
        bos.close();
        oos.close();
        client.close();
    }
}


public class Harness {
    static ServerSocket[] serverSockets;
    static boolean[] freeSockets;
    
    public Harness() throws Exception {
        inst_main();
    }
    
    static void initSockets() {
        serverSockets = initServerSockets();
        freeSockets = init();
    }
    
    static void releaseResources() {
        serverSockets = null;
        freeSockets = null;
    }
    
    static synchronized int getIndex() {
        for (int i = 0; i < freeSockets.length; i ++) {
            if (freeSockets[i]) {
                freeSockets[i] = false;
                return i;
            }
        }
        throw new StopBenchmarkException("Error: thread number more than #hw threads");
    }
    
    static synchronized void releaseSocket(int index) {
        freeSockets[index] = true;
    }
    
    static boolean[] init() {
        boolean[] result = new boolean[Launch.currentNumberBmThreads];
        for(int i = 0; i < result.length; i ++) {
            result[i] = true;
        }
        return result;
    }
    
    static ServerSocket[] initServerSockets() {
        Utils.startPortNumber = Util.getIntProperty(Constants.SERIAL_STARTUP_PORT_PROP, null);
        int socketsNumber = Launch.currentNumberBmThreads;
        ServerSocket[] result = new ServerSocket[socketsNumber];
        try {
            for (int i = 0; i < socketsNumber; i ++) {
                result[i] = new ServerSocket(Utils.startPortNumber + i);
            }
        } catch (IOException e) {
            e.printStackTrace(Context.getOut());
        }
        return result;
    }
    
    public void inst_main() throws Exception {
        Object[] instances = Utils.createInstances();
        int index = getIndex();
        Server server = new Server(serverSockets[index], instances);
        Client client = new Client(Utils.startPortNumber + index, instances);
        server.start();
        client.start();
        server.join();
        client.join();
        Utils.printResult(Context.getOut(), client.results);
        releaseSocket(index);
    }
}
