package week7.jpa.test;

import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;

import java.io.IOException;

public class TestLogging {

    public static void main(String[] args) throws IOException {

        //create
        Logger parrentLog = Logger.getLogger("week7.jpa");
        parrentLog.setLevel(Level.INFO);
        parrentLog.addAppender(new ConsoleAppender());

        Logger childLog = Logger.getLogger("week7.jpa.test");
        childLog.setLevel(Level.INFO);
        childLog.addAppender(new ConsoleAppender());

        Logger childLog2 = Logger.getLogger(TestLogging.class);
        childLog2.setLevel(Level.INFO);

        //config
        childLog2.addAppender(new FileAppender(new XMLLayout(), "log.xml"));
        childLog2.addAppender(new ConsoleAppender(new PatternLayout("%d [%-6p] %c{1} - %m%n")));

        childLog2.debug("child2 debug");
        childLog2.trace("child2 trace");
        childLog.trace("child trace");
        childLog.info("child trace");


    }
}
