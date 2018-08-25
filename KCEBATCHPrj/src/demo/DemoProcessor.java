package demo;

import java.util.logging.Logger;

import javax.batch.api.chunk.ItemProcessor;

public class DemoProcessor implements ItemProcessor {
	private final static Logger logger = Logger.getLogger(DemoProcessor.class.getName());
    protected static void log(String method, Object msg) {
        System.out.println("DemoProcessor: " + method + ": " + String.valueOf(msg));
        //logger.info("SleepyBatchlet: " + method + ": " + String.valueOf(msg));
    }
    public Object processItem(Object item) {
        if (item != null) {
        	if (item instanceof String) {
        		String line = (String) item +" i have processed this line...";
        		log("processItem", "line : " +line);
        		if (line.matches("^\\d*[02468].*"));
        			return "Item: " + item;
        	}
        }
        return null;
    }
}