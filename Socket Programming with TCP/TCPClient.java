import java.io.*;
import java.net.*;

class TCPClient{
	public static void main(String valdata[]) throws Exception{
		String myString;
		String serverString;
		int serverPort=Integer.parseInt(valdata[1]);
		String host=valdata[0];
		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket=new Socket(host,serverPort);
		System.out.println("Connection has been Established Successfully:"+host);
		DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		myString=inFromUser.readLine();
		outToServer.writeBytes(myString +'\n');
		serverString=inFromServer.readLine();
		System.out.println("Received from Server:"+serverString);
		clientSocket.close();

	}


}