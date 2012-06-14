package Client;

public class ResponseHandler {

	private String[] responseParts;
	//private String command;
	
	public ResponseHandler(String response) {
		responseParts = response.split(":");
	}

	public String getCommand() {
		return responseParts[0];
	}

}
