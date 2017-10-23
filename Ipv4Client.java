x// ============================================================================
// file: Ipv4Client.java
// ============================================================================
// Programmers: David Shin & Ethan Smith
// Date: 10/22/2017
// Class: CS 380 ("Computer Networks")
// Time: T/TH 3:00 - 4:50pm
// Instructor: Mr. Davarpanah
// Project: 3
//
// Description:
//      
//
// ============================================================================
import java.io.IOException;
import java.net.Socket;
import java.lang.Math;
public class Ipv4Client
{
    public static void main(String[] args)
    {
	//public static int LEN = 2;
	Socket socket;
	byte[] version;
	byte[] HLen;
	byte[] length;
	byte[] data; 
	    

	
	try{
	    socket = new Socket("18.221.102.182", 38003);
	    System.out.println("Connected to server");


	    for(int i = 1; i <= 12; i++)
		{
		    //creates a new byte array for data of length 2,4,8,16,32,64,128,256,512,1024,2048
		    data = new byte[(int)Math.pow(2.0, i)];
		    System.out.println("data length :" + data.length);
		}

	}
	catch(IOException e)
	    {
		e.printStackTrace();
	    }
	
	    
	    
    }

}
