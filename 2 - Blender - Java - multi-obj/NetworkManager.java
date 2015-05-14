import java.io.*;


class NetworkManager
{

    public static void main(String args[]) throws Exception
       {
		 UDPServerV2 comms = new UDPServerV2();
	 
		 StringParserV2 parser = new StringParserV2();
	 
		 multiObjectAI ai = new multiObjectAI();
	 
		 Boid[] objects = ai.initialiseObjects(10, "Cylinder");
	 
		 String[] commands = parser.createNewObjectCommand(objects);
	 
		 comms.send(commands);

		 //BoidController controller = new BoidController(20);
		 //Boid boid = new Boid();
		
		long timeDiff = 0;
	
		while (true) {
			
			long startTime = System.currentTimeMillis();
			if(timeDiff > 100) {
			
			objects = ai.updateBoids();
			commands = parser.updatePositionCommand(objects);
			comms.send(commands);
			System.out.println("Elapsed time was " + timeDiff + " miliseconds.");
			timeDiff = 0;
			}
			
			// Run some code;
			long stopTime = System.currentTimeMillis();
			timeDiff += (stopTime - startTime);

			
		
             //controller.updateBoids();
             //boid.update();

             //String receive = comms.listen();

             //if(receive != "NONE") {

                 //System.out.println("Received: " + receive);
                 //float[] coords = parser.getContents(receive);

                 //float[] newCoords = ai.manipulateData(coords);
                 //String stringVector = "<Vector(" + boid.getX() + " , " + boid.getY() + " , 0 )>";

                 //String stringVector = parser.prepareVector(newCoords);
                 //System.out.println(stringVector);
                 //comms.send(stringVector);

            // }

         }
         
         

       }
}
