package server;


import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.thread.QueuedThreadPool;

public class LymallWebServiceRunner {

    private static Server server = new Server();

    public static void main(String[] args) throws Exception {
        System.setProperty("log.basedir", "c:/logs");
        System.setProperty("log.appender", "STDOUT");
        QueuedThreadPool boundedThreadPool = new QueuedThreadPool();
        boundedThreadPool.setMaxThreads(5);
        server.setThreadPool(boundedThreadPool);

        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);

        WebAppContext context = new WebAppContext("src/main/webapp", "/app");
        context.setDefaultsDescriptor("src/test/resources/webdefault.xml");
        server.setHandler(context);

        server.setStopAtShutdown(true);
        server.setSendServerVersion(true);

        server.start();
        server.join();
    }
}
