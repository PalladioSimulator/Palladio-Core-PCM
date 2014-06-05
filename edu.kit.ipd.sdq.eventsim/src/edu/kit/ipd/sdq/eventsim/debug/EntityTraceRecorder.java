package edu.kit.ipd.sdq.eventsim.debug;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ISeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.IUsageTraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.SeffInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.usage.UsageInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

public class EntityTraceRecorder {

	private Logger logger = Logger.getLogger(EntityTraceRecorder.class);
    private boolean interactive;
    private Map<EventSimEntity, List<TraceNode>> traces;
    private List<User> users;

    private static TraceNode ROOT_NODE = new TraceNode();

    private static String LINE_SEPARATOR = System.getProperty("line.separator");

    public EntityTraceRecorder(boolean interactive, SeffInterpreterConfiguration seffInterpreterConfig, UsageInterpreterConfiguration usageInterpreterConfig) {
        this.interactive = interactive;

        traces = new HashMap<EventSimEntity, List<TraceNode>>();
        users = new ArrayList<User>();
        usageInterpreterConfig.addTraversalListener(new UserTraversalListener());
        seffInterpreterConfig.addTraversalListener(new RequestTraversalListener());
    }

    public void print() {
        try {
            FileWriter writer = new FileWriter("W:/eventsim_trace.txt");
            for (User u : users) {
                List<TraceNode> trace = traces.get(u);
                writer.write("--------------------------------" + LINE_SEPARATOR);
                writer.write(u.toString() + LINE_SEPARATOR);
                writer.write(printTraceList(trace) + LINE_SEPARATOR);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(logger.isDebugEnabled()) {
	        for (Entry<EventSimEntity, List<TraceNode>> entry : traces.entrySet()) {
	            logger.debug("------------------------------");
	            logger.debug(entry.getKey());
	            logger.debug(printTraceList(entry.getValue()));
	        }
        }
    }

    public static EntityTraceRecorder install(SeffInterpreterConfiguration seffInterpreterConfig,
            UsageInterpreterConfiguration usageInterpreterConfig) {
        EntityTraceRecorder traceRecorder = new EntityTraceRecorder(true, seffInterpreterConfig, usageInterpreterConfig);
        return traceRecorder;
    }

    private static String printTraceList(List<TraceNode> trace) {
        StringBuilder builder = new StringBuilder();
        Stack<TraceNode> parentNodes = new Stack<TraceNode>();
        parentNodes.add(ROOT_NODE);
        TraceNode lastNode = null;
        for (int i = 0; i < trace.size(); i++) {
            TraceNode node = trace.get(i);
            if (node.parentAction == parentNodes.peek().action) {
                builder.append(printTrace(node, parentNodes, lastNode));
            } else if (lastNode != null && node.parentAction == lastNode.action) {
                parentNodes.add(lastNode);
                builder.append(printTrace(node, parentNodes, lastNode));
            } else {
                if (parentNodes.peek() != ROOT_NODE) {
                    parentNodes.pop();
                }
                builder.append(printTrace(node, parentNodes, lastNode));
            }
            lastNode = node;
        }
        return builder.toString();
    }

    private static String printTrace(TraceNode trace, Stack<TraceNode> parentNodes, TraceNode lastNode) {

        String prefix = "";
        if (parentNodes.peek() == ROOT_NODE) {
            if (lastNode == null) {
                prefix = "+-- ";
            } else {
                prefix = "|-- ";
            }
        } else {
            int size = parentNodes.size();
            for (int i = 0; i < size - 1; i++) {
                prefix += "|   ";
            }
            if (lastNode == null || lastNode.parentAction != parentNodes.peek().parentAction) {
                prefix += "|-- ";
            } else {
                prefix += "+-- ";
            }
        }

        String time = String.format("%10.4f", trace.simulationTime);
        time += " [" + trace.wallClockTime + "]";

        String postfix = LINE_SEPARATOR;

        return time + prefix + PCMEntityHelper.toString(trace.action) + postfix;
    }

    public static class TraceNode {

        double simulationTime;

        long wallClockTime;

        Entity action;

        Entity parentAction;

        @Override
        public String toString() {
            return simulationTime + " [" + wallClockTime + "]: " + PCMEntityHelper.toString(action);
        }

    }

    private class UserTraversalListener implements IUsageTraversalListener {

        private Map<EventSimEntity, Stack<AbstractUserAction>> scopes = new HashMap<EventSimEntity, Stack<AbstractUserAction>>();

        @Override
        public void after(AbstractUserAction action, User user, UserState state) {
            final Map<EventSimEntity, List<TraceNode>> traces = EntityTraceRecorder.this.traces;
            List<TraceNode> l = traces.get(user);
            scopes.get(user).remove(action);
        }

        @Override
        public void before(AbstractUserAction action, User user, UserState state) {
            final Map<EventSimEntity, List<TraceNode>> traces = EntityTraceRecorder.this.traces;
            List<TraceNode> l = traces.get(user);
            if (l == null) {
                l = new ArrayList<TraceNode>();
                scopes.put(user, new Stack<AbstractUserAction>());
                traces.put(user, l);
                users.add(user);
            }

            // create node
            TraceNode node = new TraceNode();
            node.action = action;
            if (scopes.get(user).size() > 0) {
                node.parentAction = scopes.get(user).peek();
            } else {
                node.parentAction = null;
            }
            node.simulationTime = user.getModel().getSimulationControl().getCurrentSimulationTime();
            node.wallClockTime = System.currentTimeMillis();

            // add node to trace list
            l.add(node);

            // sleep
            // try {
            // Thread.currentThread().sleep(2000);
            // } catch (InterruptedException e) {
            // // TODO Auto-generated catch block
            // e.printStackTrace();
            // }

            scopes.get(user).add(action);
        }

    }

    private class RequestTraversalListener implements ISeffTraversalListener {

        private Map<EventSimEntity, Stack<Entity>> scopes = new HashMap<EventSimEntity, Stack<Entity>>();

        @Override
        public void after(AbstractAction action, Request request, RequestState state) {
            User u = ((Request) request).getUser();
            final Map<EventSimEntity, List<TraceNode>> traces = EntityTraceRecorder.this.traces;
            List<TraceNode> l = traces.get(u);
            scopes.get(request).remove(action);
        }

        @Override
        public void before(AbstractAction action, Request request, RequestState state) {
            User u = request.getUser();

            final Map<EventSimEntity, List<TraceNode>> traces = EntityTraceRecorder.this.traces;
            List<TraceNode> l = traces.get(u);
            if (l == null) {
                l = new ArrayList<TraceNode>();
                traces.put(u, l);
            }
            if (!scopes.containsKey(request)) {
                Stack<Entity> stack = new Stack<Entity>();
                stack.push(traces.get(u).get(traces.get(u).size() - 1).action);
                scopes.put(request, stack);
            }

            // create node
            TraceNode node = new TraceNode();
            node.action = action;
            if (scopes.get(request).size() > 0) {
                node.parentAction = scopes.get(request).peek();
            } else {
                node.parentAction = null;
            }
            node.simulationTime = u.getModel().getSimulationControl().getCurrentSimulationTime();
            node.wallClockTime = System.currentTimeMillis();

            // add node to trace list
            l.add(node);

            // sleep
            // try {
            // Thread.currentThread().sleep(2000);
            // } catch (InterruptedException e) {
            // // TODO Auto-generated catch block
            // e.printStackTrace();
            // }

            scopes.get(request).add(action);

        }

    }

}
