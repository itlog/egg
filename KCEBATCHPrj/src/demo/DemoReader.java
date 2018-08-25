package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Inject;


public class DemoReader extends AbstractItemReader {
	@Inject @BatchProperty String inputFile;
	BufferedReader bf;
	private final static Logger logger = Logger.getLogger(DemoReader.class.getName());
    protected static void log(String method, Object msg) {
        System.out.println("DemoReader: " + method + ": " + String.valueOf(msg));
        //logger.info("SleepyBatchlet: " + method + ": " + String.valueOf(msg));
    }
	
    @Override
	public void open(Serializable checkpoint) throws Exception {
		super.open(checkpoint);
		bf = new BufferedReader(new FileReader(inputFile));
	}

    public Object readItem() throws IOException {
		if (bf != null && bf.ready()) {
			String line = bf.readLine();
			
			log("readItem", "line : " +line);
			
			if (line == null) {
				bf.close();
				bf = null;
			}
			return line;
		}
		return null;
    }

}