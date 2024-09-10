import java.lang.reflect.Array;
import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        In inputStream = new In();
        String title = inputStream.readLine();
        String xAxisLabel = inputStream.readLine();
        String dataSource = inputStream.readLine();
        inputStream.readLine(); //skip blank line
        //labels done

        /*idea for each loop: read the amount of bars, 
        create array of bars, 
        fill array with bars,
        sort, 
        reset chart, 
        add bars in order to chart, 
        draw,
        */
        while (!inputStream.isEmpty()) {
            int numberOfBars = inputStream.readInt();
            Bar[] arrayOfBars = new Bar[numberOfBars];
            String chartCaption = "";

            for (int i = 0; i < numberOfBars; i++) {
                String barInput = inputStream.readLine();
                String barName = "";
                String barValueString = "";
                String barCategory = "";

                int numberOfCommasEncountered = 0;
                for (int pointer = 0; pointer < barInput.length(); pointer++) {
                    if (numberOfCommasEncountered == 0 && barInput.charAt(pointer) != ',' && i == 0) {chartCaption += barInput.charAt(pointer);}
                    else if (numberOfCommasEncountered == 1 && barInput.charAt(pointer) != ',') {barName += barInput.charAt(pointer);}
                    else if (numberOfCommasEncountered == 3 && barInput.charAt(pointer) != ',') {barValueString += barInput.charAt(pointer);}
                    else if (numberOfCommasEncountered == 4 && barInput.charAt(pointer) != ',') {barCategory += barInput.charAt(pointer);}
                    else if (barInput.charAt(pointer) == ',') {numberOfCommasEncountered++;}
                }//indexing the bar input for required values
                
            } 
            //filling array with bars
            
            Arrays.sort(arrayOfBars);
            //sort


        }
    }
}
