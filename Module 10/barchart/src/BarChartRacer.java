import java.lang.reflect.Array;
import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        String inputFile = args[0];
        int amountOfBarsToDisplay = Integer.parseInt(args[1]);
        //String inputFile = "https://coursera.cs.princeton.edu/introcs/assignments/barchart/files/cities.txt";
        //int amountOfBarsToDisplay = 10;

        In inputStream = new In(inputFile);
        String title = inputStream.readLine();
        String xAxisLabel = inputStream.readLine();
        String dataSource = inputStream.readLine();
        BarChart drawingBoard = new BarChart(title, xAxisLabel, dataSource);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        inputStream.readLine(); //skip blank line
        //setups done

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
            inputStream.readLine();// do this so the pointer would move to next line and the next .readLine() doesnt read from the rest of current line 
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
                arrayOfBars[i] = new Bar(barName, Integer.parseInt(barValueString), barCategory);
                
            } 
            //filling array with bars

            Arrays.sort(arrayOfBars); //sort

            drawingBoard.reset(); //reset chart

            drawingBoard.setCaption(chartCaption);
            for (int i = 0; i < amountOfBarsToDisplay; i++) {
                drawingBoard.add(arrayOfBars[i].getName(), arrayOfBars[i].getValue(), arrayOfBars[i].getCategory());
            }
            // add bars to chart
            StdDraw.clear();

            drawingBoard.draw();

            StdDraw.show();
            
            inputStream.readLine(); // to skip the blank line between each block of inputs
        }
    }
}
