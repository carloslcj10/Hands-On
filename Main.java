package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

import org.apache.http.client.ClientProtocolException;

public class Main {

	public static void main(String[] args) throws ClientProtocolException, IOException {

	    BufferedReader br = null;
		Collection<Entry> entry = new Vector<Entry>();

	    try {

	        String sCurrentLine;
	        br = new BufferedReader(new FileReader("data.txt"));

	        while ((sCurrentLine = br.readLine()) != null) {
	            String[] arr = sCurrentLine.split(" ");
	    		Entry ent = new Entry(arr[0],Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
	    		entry.add(ent);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (br != null)br.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
		
		App app = new App(0, entry);
		app.init();

	}

}
