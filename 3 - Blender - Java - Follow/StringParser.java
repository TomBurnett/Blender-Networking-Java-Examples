import java.io.*;


class StringParser
{

    // Class Variables


    // Constructor

    public StringParser() {


    }


    // Methods

    public float[] getContents(String contents) {

      // Input Expected: <Vector (int , int , int)>

      // Get contents within brackets only
      String splitString1 = contents.substring(contents.indexOf("(") + 1, contents.indexOf(")"));

      // Remove all white space
      splitString1 = splitString1.replaceAll("\\s","");

      // Split string into x y z axis data
      String splitString[] = splitString1.split(",");

      // Array to hold converted string numbers
      float[] coords = new float[splitString.length];

      // create float array from string array
      for(int x = 0; x< splitString.length; x++) {

        coords[x] = Float.parseFloat(splitString[x]);

        //System.out.println("String #" + x + " : " + coords[x]);

      }

      return coords;

    }


    public String prepareVector(float[] coords) {

      String stringVector = "<Vector (";

      for(int x = 0; x< coords.length; x++) {

        if(x != 0) {
          stringVector += ", ";
        }

        stringVector += String.valueOf(coords[x]);

      }

      stringVector += ")>";

      //System.out.println(start);
      return stringVector;

    }


}
