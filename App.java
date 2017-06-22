package app;

import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.lang.time.StopWatch;

public class App {

	Timer timer;
	private int requests;
	 Collection<Entry> entry;

	
	
	public App(int requests, Collection<Entry> entry) {
		super();
		this.requests = requests;
		this.entry = entry;
	}

	public int getRequests() {
		return requests;
	}

	public void setRequests(int requests) {
		this.requests = requests;
	}

	public Collection<Entry> getEntry() {
		return entry;
	}

	public void setEntry(Collection<Entry> entry) {
		this.entry = entry;
	}
	public void init() {
		
		long TEMPO = (1000 * 5);

		if (timer == null) {
			timer = new Timer();
			TimerTask tarefa = new TimerTask() {
				public void run() {
					try {
						req();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
		}
	
				
	}

	public void req() throws ClientProtocolException, IOException {
		increase_reqs();
		
		 if(!entry.isEmpty())
		 {
		  Iterator iter = entry.iterator();
		   while (iter.hasNext()) {
		   Entry item = (Entry)iter.next();
		   
			StopWatch watch = new StopWatch();
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet response = new HttpGet(item.getUrl());
			HttpResponse Httpresponse;

			watch.start();
			Httpresponse = client.execute(response);
			watch.stop();
			int code = Httpresponse.getStatusLine().getStatusCode();
			long time_response= watch.getTime();

			if (code>= 200 && code <=499) 
			{
				item.increase_success_resp();
			}
			
			if(time_response<=100)
			{
				item.increase_success_fast_resp();
			}			
			
			item.set_SLIs(this.requests);  
			item.set_status();
		    item.print();
		   }
		  }

	}

	
	private void increase_reqs() {
		this.requests=this.requests+1;

	}
	
	
}
