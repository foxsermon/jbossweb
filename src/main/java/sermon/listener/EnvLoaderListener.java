package sermon.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EnvLoaderListener
 *
 */
@WebListener
public class EnvLoaderListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EnvLoaderListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent context) {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent context) {
    	String ambiente = System.getenv("AMBIENTE");
    	if (ambiente == null || ambiente.equalsIgnoreCase("null")) {
    		ambiente = "69.61.93.57";
    	}
        context.getServletContext().setAttribute("ambiente", ambiente);
        System.out.println("************* AMBIENTE : " + ambiente);
    }
	
}
