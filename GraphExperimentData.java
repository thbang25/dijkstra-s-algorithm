/* @author thabang sambo
smbtha002
create files of data*/

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


public class GraphExperimentData{//create method

   public void Data () throws IOException{
/*write our file */
    FileWriter myWriter = new FileWriter("../data/input.txt");
    Set<String> data = new HashSet<>(); //use hash
    Random rand = new Random();//random
    int[] array = IntStream.range(1, 25).toArray(); //weights
    String[] paths = {"A", "B", "C", "D", "E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};//vertices
    int count = 0;
    //while the size
    while(count < 30) { // Number of datasets that we need
        String path1 = paths[rand.nextInt(paths.length)]; //path1
        String path2 = "";//path2
        do {
            path2 = paths[rand.nextInt(paths.length)];//get data
        } while(path1.equals(path2));
        String weight = String.valueOf(array[(rand.nextInt(array.length))]); /*weights*/
        String combination = path1 + " " + path2 + " " + weight;
        if(!data.contains(combination) && !data.contains(path1+" "+path2)) {
            data.add(combination);
            myWriter.write(combination);
            myWriter.write("\n");
            count++;
        }
    }
    myWriter.close();

    PrintWriter writeData = new PrintWriter("../data/dataset30.txt");
          
    // BufferedReader object for input.txt
    BufferedReader buffRead1 = new BufferedReader(new FileReader("../data/input.txt"));
      
    String input1 = buffRead1.readLine();
      
    // loop for each line of input.txt
    while(input1 != null)
    {
        boolean signal = false;
          
        // BufferedReader object for delete.txt
        BufferedReader buffRead = new BufferedReader(new FileReader("../data/delete.txt"));
          
        String input2 = buffRead.readLine();
          
        // loop for each line of delete.txt
        while(input2 != null)
        {
            if(input1.equals(input2))
            {
                signal = true;
                break;
            }
              
            input2 = buffRead.readLine();
        }
          
        // if signal = false
        // write line of input.txt to output.txt
        if(!signal)
            writeData.println(input1);
          
        input1 = buffRead1.readLine();
          
    }
      
    writeData.flush();
      
    // closing resources
    buffRead1.close();
    writeData.close();
      
}
}



  
