import java.io.*;
import java.util.Random;


class Boid
{
    // Class Variables

    int maxX = 60;
    int maxY = 60;

    int x = 0;
    int y = 0;

    int dx = 1;
    int dy = 1;
    
    String uniqueObjectName;
    
    String object;

    // Constructor

    public Boid() {

        Random randomGenerator = new Random();

        // Set random position within coordinates
        x = randomGenerator.nextInt(maxX-1) + 1;
        y = randomGenerator.nextInt(maxY-1) + 1;

        dx = randomGenerator.nextInt(3) - 2;
        dy = randomGenerator.nextInt(3) - 2;

        if (dx == 0) {
            dx = 1;
        }

        if (dy == 0) {
            dy = 1;
        }

    }

    // Methods

    public void update() {

        if (x <= 0 || x >= maxX) {

            dx = dx * (-1);
        }

        if (y <= 0 || y >= maxY) {

            dy = dy * (-1);
        }

        x = x + (dx);
        y = y + (dy);


        //System.out.println("Position x: " + x + " y: " + y);

    }

    public String getPosition() {

        return (x + " , " + y + " , 0");
    }


    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }
    
    public float[] getCoords() {
    
    	float[] coords = new float[2];
			
		coords[0] = x;
			
		coords[1] = y;
		
		return coords;
    
    }
    
    public String getUniqueObjectName() {
    
    	return uniqueObjectName;
    }
    
    public String getObjectName() {
    
    	return object;
    }
    
    public void setUniqueObjectName(String name) {
    
    	uniqueObjectName = name;
    }
    
    public void setObjectName(String name) {
    
    	object = name;
    }
    
    


}
