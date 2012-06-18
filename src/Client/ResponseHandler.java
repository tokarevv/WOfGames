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
	
	public String[] getParams() {
		String[] res;
		if (responseParts.length > 1){
			res = responseParts[1].split(",");
		}
		else {
			res = new String[0];
		}
		return res;
	}
	
	

}
