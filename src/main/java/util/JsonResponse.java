package util;

public class JsonResponse {
	
	public class Message {
		String status;
		String message;
		String reference;
		
		public String getStatus() { return status; }
		public String getMessage() { return message; }
		public String getReference() { return reference; }
		
		public void setStatus(String s) { status = s; }
		public void setMessage(String m) { message = m; }
		public void setReference(String r) { reference = r; }
		
	}
    public Message message = new Message();
}
