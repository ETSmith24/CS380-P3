// ============================================================================
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.BufferedReader;

public class Ipv4Client
{
    public static void main(String[] args) {
	Socket socket;
	byte[] data; 
	    
	try{
	    socket = new Socket("18.221.102.182", 38003);
	    System.out.println("Connected to server");
<<<<<<< HEAD
	    
=======
>>>>>>> ba8bd02f0dbbb6e7ee68f46b120f2fde14b0b709
	    //setting up input stream
	    InputStream is = socket.getInputStream();
	    InputStreamReader isr = new InputStreamReader(is, "UTF-8");
	    BufferedReader br = new BufferedReader(isr);
<<<<<<< HEAD
	    
=======
>>>>>>> ba8bd02f0dbbb6e7ee68f46b120f2fde14b0b709
	    //setting up output stream
	    OutputStream os = socket.getOutputStream();
	    PrintStream ps = new PrintStream(os);
	    
<<<<<<< HEAD
=======

>>>>>>> ba8bd02f0dbbb6e7ee68f46b120f2fde14b0b709
	    for(int i = 1; i <= 12; i++)
		{
		    //creates a new byte array for data of length 2,4,8,16,32,64,128,256,512,1024,2048
		    data = new byte[(int)Math.pow(2.0, i) + 20];
		    //FrameFill returns a byte array in IPv4 format
		    data = FrameFill(data);
		    ps.write(data);
<<<<<<< HEAD
		    System.out.println("data length :" + data.length);
		    System.out.println(br.readLine() + '\n');
		}

	} catch(IOException e) {
		e.printStackTrace();
	}  
	}//end main

    public static byte[] FrameFill(byte[] data) {
=======
		    System.out.println(br.readLine() + '\n');
		    // System.out.println("data length :" + data.length);
		}

	}//end try-block
	catch(IOException e)
	    {
		e.printStackTrace();
	    }  
    }//end main

    public static byte[] FrameFill(byte[] data)
    {
>>>>>>> ba8bd02f0dbbb6e7ee68f46b120f2fde14b0b709
	short length = (short) data.length;
	data[0] = 0x45; //version 4, header length 5
	data[1] = 0x0;//type of service
	data[2] = (byte) ((length >> 8) & 0xFF);//Header + Data(0)?
	data[3] = (byte) (length & 0xFF); //20+2*


	data[4] = 0x0; //identifier

	data[5] = 0x0;
	data[6] = (0x1 << 6); //flag : fragment

	data[7] = 0x0; //offset
	data[8] = 0x32; // 50 TTL
	data[9] = 0x6; // TCP = 6
	data[10] = 0x0; //insert verified Checksum
	data[11] = 0x0;

	data[12] = (byte) 72; //random source address
	data[13] = (byte) 182;
	data[14] = (byte) 13;
	data[15] = (byte) 171;

	data[16] = (byte) 18;//destination inet address: 18.221.102.182
	data[17] = (byte) 221;
	data[18] = (byte) 102;
	data[19] = (byte) 182;

	//insert verified checksum
	short CheckedSum = checksum(data);
	data[10] = (byte) ((CheckedSum >> 8) & 0xFF);
	data[11] = (byte) (CheckedSum & 0xFF);


	// Data section is 0
	for (int i = 20; i < length; ++i)
	    data[i] = 0x0;
	return data;
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