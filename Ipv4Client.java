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
    public static void main(String[] args) {
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
	
	public static short checksum(byte[] b) {
		int length = b.length;
        int i = 0;
        long returnValue = 0;
        long sum = 0;

        while (length > 1) {
            sum += ((b[i] << 8 & 0xFF00) | ((b[i + 1]) & 0x00FF));
            i += 2;
            length -= 2;
            if ((sum & 0xFFFF0000) > 0) {
                sum &= 0xFFFF;
                sum++;
            }
        }
        //if statement triggers if we are given an odd number of bytes
        if (length > 0) {
            sum += b[i] << 8 & 0xFF00;
            if ((sum & 0xFFFF0000) > 0) {
                sum &= 0xFFFF;
                sum++;
            }
        }
        returnValue = (~((sum & 0xFFFF) + (sum >> 16))) & 0xFFFF;
        return (short) returnValue;
	}

}
