import java.io.*;


class StringParserV2
{

    // Class Variables


    // Constructor

    public StringParserV2() {


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

    public String createNewObjectCommand(float[] coords, String object, String uniqueObjectName) {

        // Begin String
        String command = "< CREATE ";

        command += "("+ object + ") ";

        command += "(" + uniqueObjectName + ") ";

        command += "(";

        for(int x = 0; x< coords.length; x++) {

          if(x != 0) {
            command += ", ";
          }

          command += String.valueOf(coords[x]);

        }

        command += ") ";

        // End String
        command += ">";
        
        return command;

    }
    
    public String[] createNewObjectCommand(Boid[] objects) {
		
		int numObjects = objects.length;
		
		String[] commands = new String[numObjects];
		
		for(int x = 0; x < numObjects; x++) {
		
			String object = objects[x].getObjectName();
			String uniqueObjectName = objects[x].getUniqueObjectName();
			
			float[] coords = objects[x].getCoords();
			
			commands[x] = createNewObjectCommand(coords, object, uniqueObjectName);
			
			//System.out.println(commands[x]);
		
		}
		
		return commands;
    }
    
    public String updatePositionCommand(float[] coords, String uniqueObjectName) {

      String command = "< NEWPOSITION ";

      command += "(" + uniqueObjectName + ") ";

      command += " (";
      
      for(int x = 0; x< coords.length; x++) {

        if(x != 0) {
          command += ", ";
        }

        command += String.valueOf(coords[x]);

      }

      command += ") ";

      command += ">";

      //System.out.println(start);
      return command;

    }

    
    public String[] updatePositionCommand(Boid[] objects) {

       int numObjects = objects.length;
		
		String[] commands = new String[numObjects];
		
		for(int x = 0; x < numObjects; x++) {
		
			String uniqueObjectName = objects[x].getUniqueObjectName();
			
			float[] coords = objects[x].getCoords();
			
			commands[x] = updatePositionCommand(coords, uniqueObjectName);
			
			//System.out.println(commands[x]);
		
		}
		
		return commands;

    }

}
