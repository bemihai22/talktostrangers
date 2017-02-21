package backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class Client {
	Socket CSSocket;
	String serverName;
	PrintStream toServer = null;
    BufferedReader fromServer = null;
    public ClientReceiver receiver;
    
    public Client(String serverName){
		try{
			CSSocket = new Socket(serverName, Port.number);
			toServer = new PrintStream(CSSocket.getOutputStream());
			fromServer = new BufferedReader(new InputStreamReader(CSSocket.getInputStream()));
		}
		catch (IOException e){
		}
		
	}
    public void run(){
		try{
			if(CSSocket.isConnected()){
				receiver = new ClientReceiver(fromServer); // BBBBBB (Matches BBBBB in Server)
				
				receiver.start();
			
				int i = 1;
				while(i==1){
					
				}
			
				try{
				    toServer.close();
				    receiver.join();
				    fromServer.close();
				    CSSocket.close();
				} catch (IOException e){} catch(InterruptedException d){}     
			}
		}
		catch(NullPointerException e){
		}
	}
    
    public void send(String s){
    	toServer.println(s);
    }
    
    
    
    
   
	
	
	
	
}