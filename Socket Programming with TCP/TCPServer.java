import java.io.*;
import java.net.*;

class TCPServer{
	public static void main(String valdata[]) throws Exception{
		String clientString;
		String modifiedString;
		int serverPort=Integer.parseInt(valdata[0]);
		ServerSocket welcomeSocket=new ServerSocket(serverPort);
		
		System.out.println("Server Running on Port Number:"+serverPort);
		while(true){
			Socket connectionSocket=welcomeSocket.accept();
			System.out.println("Connected to:"+connectionSocket.getRemoteSocketAddress().toString());
			BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
			clientString=inFromClient.readLine();
			modifiedString=clientString.toUpperCase() + "\n";
			outToClient.writeBytes(modifiedString);
		}

	}


}