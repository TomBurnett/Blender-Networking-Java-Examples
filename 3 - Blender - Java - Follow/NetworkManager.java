import java.io.*;


class NetworkManager
{

    public static void main(String args[]) throws Exception
       {
         UDPServer comms = new UDPServer();
         StringParser parser = new StringParser();
         SimpleAI ai = new SimpleAI();

         while (true) {

           String receive = comms.listen();

           if(receive != "NONE") {

             //System.out.println("Received: " + receive);
             float[] coords = parser.getContents(receive);

             float[] newCoords = ai.manipulateData(coords);

             String stringVector = parser.prepareVector(newCoords);

             comms.send(stringVector);

          }

         }

       }
}
