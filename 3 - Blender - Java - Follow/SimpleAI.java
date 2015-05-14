import java.io.*;


class SimpleAI
{

    // Class Variables


    // Constructor

    public SimpleAI() {


    }


    // Methods

    public float[] manipulateData(float[] input) {

      float[] newCoords = new float[input.length];

      for(int x = 0; x < input.length; x++) {

        newCoords[x] = input[x] + 2;

        //System.out.println("N-Coord #" + x + " : " + newCoords[x]);

      }

      return newCoords;
    }

}
