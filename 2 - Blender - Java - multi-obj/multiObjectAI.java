import java.io.*;


class multiObjectAI
{
    
    // Class Variables
    
    Boid[] objects;


    // Constructor

    public multiObjectAI() {
		
		

    }
	
	
	 // Methods
	
	public Boid[] initialiseObjects(int numObjects, String object) {
			
		objects = new Boid[numObjects];
		
		for (int x = 0; x < numObjects; x++) {
			
			objects[x] = new Boid();
			
			String uniqueObjectName = object + x;
			
			objects[x].setUniqueObjectName(uniqueObjectName);	
			
			objects[x].setObjectName(object);
		
		
		}
		
		return objects;
	
	}
	
	public Boid[] updateBoids() {

        for (int x = 0; x < objects.length; x++) {

            objects[x].update();

        }
        
        return objects;

    }


    public float[] manipulateData(float[] input) {

      float[] newCoords = new float[input.length];

      for(int x = 0; x < input.length; x++) {

        newCoords[x] = input[x] + 2;

        //System.out.println("N-Coord #" + x + " : " + newCoords[x]);

      }

      return newCoords;
    }

}
