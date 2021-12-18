package in.dugg.pwnme;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import static spark.Spark.*;
public class LogMyAgent {
    static final Logger logger = LogManager.getLogger(LogMyAgent.class.getName());
    public static void main(String[] args) {
        int port = 1820;
        if ( args.length > 0 ) { port = Integer.parseInt(args[ 0 ]); } 
	System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
	System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true"); 
	System.setProperty("com.sun.jndi.cosnaming.object.trustURLCodebase","true");
	System.setProperty("log4j2.formatMsgNoLookups","false");
        port(port);
        get("/*", (req, res) -> {
            String agent = req.headers("User-Agent");
            System.out.println("User-Agent: " + agent);
            logger.error("User-Agent: " + agent);
            return "User-Agent was " + agent + ".";
        });
    }
}
