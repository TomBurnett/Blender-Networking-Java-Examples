/*
To Do:

Specify Port


*/

import java.io.*;
import java.net.*;

public class UDPServerV2
{
    // Class Variables

    // LISTEN
    private DatagramSocket serverSocket;

    private byte[] receiveData;

    private DatagramPacket receivePacket;
    private SocketAddress address;


    // SEND
    private DatagramSocket clientSocket = new DatagramSocket();
    private byte[] sendData;

    // Constructor
    public UDPServerV2() throws Exception {

      // Catch EXCEPTION
      try {


        serverSocket = new DatagramSocket(10000);
        receiveData = new byte[1024];
        //byte[] sendData = new byte[1024];

        receivePacket = new DatagramPacket(receiveData, receiveData.length);

        address = new InetSocketAddress(10000);

        serverSocket.setSoTimeout(10);
        //serverSocket.bind(address);

      }

      catch (SocketException e) {

        System.out.println(e);

      }

    }

    // Methods

    public String listen() throws Exception {

      try {

        serverSocket.receive(receivePacket);
        String sentence = new String( receivePacket.getData());
        //System.out.println("RECEIVED: " + sentence);

        return sentence;

      }

      // Set Blocking Timeout
      catch (SocketTimeoutException e) {

        //System.out.println("Error 2");

      }

      finally {

        // Exception Happened
        //System.out.println("Error 3");

      }

      return "NONE";

    }

    public void send(String message) throws Exception {

      try {

        InetAddress IPAddress = InetAddress.getByName("localhost");
        sendData = new byte[1024];

        //String data = "Hello Blender";

        sendData = message.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 10001);

        clientSocket.send(sendPacket);

      }

      catch (SocketException e) {

        System.out.println(e);

      }

      catch (UnknownHostException e) {

        System.out.println(e);

      }

      catch (IOException e) {

        System.out.println(e);

      }


    }
    
    
    public void send(String[] commands) throws Exception {
	
	  try {

		InetAddress IPAddress = InetAddress.getByName("localhost");
		sendData = new byte[1024];
		
		for (int x = 0; x < commands.length; x++) {
	
			sendData = commands[x].getBytes();
			
			//System.out.println(sendData);

			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 10001);

			clientSocket.send(sendPacket);
		
		}

	  }

	  catch (SocketException e) {

		System.out.println(e);

	  }

	  catch (UnknownHostException e) {

		System.out.println(e);

	  }

	  catch (IOException e) {

		System.out.println(e);

	  }


	}
}
