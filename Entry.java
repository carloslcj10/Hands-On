package app;

public class Entry {

private String url;
private double Successful_Response_SLO;
private double Fast_Response_SLO;
private int successful_fast_resp;
private int successful_resp;
private int Successful_Response_SLI;
private int Fast_Response_SLI;
private boolean status_fast_response;
private boolean status_successful_response;

public Entry(String url, double successful_Response_SLO, double fast_Response_SLO, int successful_fast_resp,
		int successful_req) {
	super();
	this.url = url;
	Successful_Response_SLO = successful_Response_SLO;
	Fast_Response_SLO = fast_Response_SLO;
	this.successful_fast_resp = successful_fast_resp;
	this.successful_resp = successful_req;
}

public Entry(String url, double successful_Response_SLO, double fast_Response_SLO) {
	super();
	this.url = url;
	Successful_Response_SLO = successful_Response_SLO;
	Fast_Response_SLO = fast_Response_SLO;
	this.successful_fast_resp = 0;
	this.successful_resp = 0;
}

public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public double getSuccessful_Response_SLO() {
	return Successful_Response_SLO;
}
public void setSuccessful_Response_SLO(double successful_Response_SLO) {
	Successful_Response_SLO = successful_Response_SLO;
}
public double getFast_Response_SLO() {
	return Fast_Response_SLO;
}
public void setFast_Response_SLO(double fast_Response_SLO) {
	Fast_Response_SLO = fast_Response_SLO;
}

public int getSuccessful_resp() {
	return successful_resp;
}

public void setSuccessful_resp(int successful_req) {
	this.successful_resp = successful_req;
}

public int getSuccessful_fast_resp() {
	return successful_fast_resp;
}

public void setSuccessful_fast_resp(int successful_fast_resp) {
	this.successful_fast_resp = successful_fast_resp;
}
public void increase_success_fast_resp() 
{
	this.successful_fast_resp=getSuccessful_fast_resp()+1;
}
public void increase_success_resp() {
	this.successful_resp=getSuccessful_resp()+1;
	
	
}
public void set_SLIs(int requests) {
	this.setFast_Response_SLI((getSuccessful_fast_resp()/requests)*100);
    this.setSuccessful_Response_SLI((getSuccessful_resp()/requests)*100);
		
}

public double getSuccessful_Response_SLI() {
	return Successful_Response_SLI;
}
public void setSuccessful_Response_SLI(int successful_Response_SLI) {
	Successful_Response_SLI = successful_Response_SLI;
}
public double getFast_Response_SLI() {
	return Fast_Response_SLI;
}
public void setFast_Response_SLI(int fast_Response_SLI) {
	Fast_Response_SLI = fast_Response_SLI;
}

public void set_status()
{
	if(this.getSuccessful_Response_SLI()>= this.getSuccessful_Response_SLO())
	{
		setStatus_successful_response(true);
	}
	else
	{
		setStatus_successful_response(false);	
	}
	
	if(this.getFast_Response_SLI()>=this.getFast_Response_SLO())
	{
		setStatus_fast_response(true);
	}
	else
	{
		setStatus_fast_response(false);	
	}
	
}

public boolean isStatus_successful_response() {
	return status_successful_response;
}
public void setStatus_successful_response(boolean status_successful_response) {
	this.status_successful_response = status_successful_response;
}
public boolean isStatus_fast_response() {
	return status_fast_response;
}
public void setStatus_fast_response(boolean status_fast_response) {
	this.status_fast_response = status_fast_response;
}
public void print() {
	System.out.println("-------------");
	System.out.println("URL: "+ this.getUrl());
	
	System.out.println("Successful Response: ");
	System.out.println("SLO: "+ this.getSuccessful_Response_SLO()+ " SLI: "+ this.getSuccessful_Response_SLI());
	System.out.println("Status: "+ (this.isStatus_successful_response() ? "attend": "not attend"));


	System.out.println("Fast Response: ");
	System.out.println("SLO: "+ this.getFast_Response_SLO()+ " SLI: "+ this.getFast_Response_SLI());
	System.out.println("Status: "+ (this.isStatus_fast_response() ? "attend": "not attend"));

}

}
