import java.awt.Color;
public class KernelFilter {
    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        Picture sharpen = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                int increment = 0;
                int[] redValues = new int[9];
                int[] greenValues = new int[9];
                int[] blueValues = new int[9];
                for(int col2 = -1; col2 <= 1; col2++) { 
                    for(int row2 = -1; row2 <= 1; row2++) {
                        int rowTemp = row + row2;
                        int columnTemp = col + col2;
                        if (col + col2 < 0) {columnTemp+= picture.width();}
                        else if (col + col2 >= picture.width()) {columnTemp -= picture.width();}
                        if (row + row2 < 0) {rowTemp+= picture.height();}
                        else if (row + row2 >= picture.height()) {rowTemp-= picture.height();}

                        if (columnTemp< 0) {columnTemp+= picture.width();}
                        else if (columnTemp >= picture.width()) {columnTemp-= picture.width();}
                        if (rowTemp < 0) {rowTemp+= picture.height();}
                        else if (rowTemp>= picture.height()) {rowTemp-= picture.height();}
                        //conditions for when kernel wraps around
                        Color colorTemp = picture.get(columnTemp, rowTemp);
                        redValues[increment] = colorTemp.getRed();
                        greenValues[increment] = colorTemp.getGreen();
                        blueValues[increment] = colorTemp.getBlue();
                        increment++;
                    }
                }
                float newRed = 0;
                float newGreen = 0;
                float newBlue = 0;
                newRed = newRed + redValues[0] + 2*redValues[1]  + redValues[2]  + 2*redValues[3]  + 4*redValues[4]  + 2*redValues[5]  + 1*redValues[6]  + 2*redValues[7]  + 1*redValues[8] ;
                newRed/=16;
                newRed = Math.round(newRed);
                newGreen = newGreen + greenValues[0] + 2*greenValues[1]  + greenValues[2]  + 2*greenValues[3]  + 4*greenValues[4]  + 2*greenValues[5]  + 1*greenValues[6]  + 2*greenValues[7]  + 1*greenValues[8] ;
                newGreen/=16;
                newGreen = Math.round(newGreen);
                newBlue = newBlue + blueValues[0]  + 2*blueValues[1]  + blueValues[2]  + 2*blueValues[3]  + 4*blueValues[4]  + 2*blueValues[5]  + 1*blueValues[6]  + 2*blueValues[7]  + 1*blueValues[8] ;
                newBlue/=16;
                newBlue = Math.round(newBlue);
                
                if (newRed > 255) {newRed = 255;} 
                if (newRed < 0) { newRed = 0;}
                if (newGreen > 255) {newGreen = 255;}
                if (newGreen < 0) { newGreen = 0;}
                if (newBlue > 255) {newBlue = 255;}
                if (newBlue < 0) { newBlue = 0;}
                //kernel operations
                Color sharpenFilter = new Color(newRed, newGreen, newBlue);
                sharpen.set(col, row, sharpenFilter);
            }
        }
        return sharpen;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        Picture sharpen = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                int increment = 0;
                int[] redValues = new int[9];
                int[] greenValues = new int[9];
                int[] blueValues = new int[9];
                for(int col2 = -1; col2 <= 1; col2++) { 
                    for(int row2 = -1; row2 <= 1; row2++) {
                        int rowTemp = row + row2;
                        int columnTemp = col + col2;
                        if (col + col2 < 0) {columnTemp+= picture.width();}
                        else if (col + col2 >= picture.width()) {columnTemp -= picture.width();}
                        if (row + row2 < 0) {rowTemp+= picture.height();}
                        else if (row + row2 >= picture.height()) {rowTemp-= picture.height();}

                        if (columnTemp< 0) {columnTemp+= picture.width();}
                        else if (columnTemp >= picture.width()) {columnTemp-= picture.width();}
                        if (rowTemp < 0) {rowTemp+= picture.height();}
                        else if (rowTemp>= picture.height()) {rowTemp-= picture.height();}
                        //conditions for when kernel wraps around
                        Color colorTemp = picture.get(columnTemp, rowTemp);
                        redValues[increment] = colorTemp.getRed();
                        greenValues[increment] = colorTemp.getGreen();
                        blueValues[increment] = colorTemp.getBlue();
                        increment++;
                    }
                }
                int newRed = 0;
                int newGreen = 0;
                int newBlue = 0;
                newRed = newRed - redValues[1] - redValues[3] + 5*redValues[4] - redValues[5] - redValues[7];
                newGreen = newGreen - greenValues[1] - greenValues[3] + 5*greenValues[4] - greenValues[5] - greenValues[7];
                newBlue = newBlue - blueValues[1] - blueValues[3] + 5*blueValues[4] - blueValues[5] - blueValues[7];
                if (newRed > 255) {newRed = 255;}
                if (newRed < 0) { newRed = 0;}
                if (newGreen > 255) {newGreen = 255;}
                if (newGreen < 0) { newGreen = 0;}
                if (newBlue > 255) {newBlue = 255;}
                if (newBlue < 0) { newBlue = 0;}
                //kernel operations
                Color sharpenFilter = new Color(newRed, newGreen, newBlue);
                sharpen.set(col, row, sharpenFilter);
            }
        }
        return sharpen;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        Picture laplacian = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                int increment = 0;
                int[] redValues = new int[9];
                int[] greenValues = new int[9];
                int[] blueValues = new int[9];
                for(int col2 = -1; col2 <= 1; col2++) { 
                    for(int row2 = -1; row2 <= 1; row2++) {
                        int rowTemp = row + row2;
                        int columnTemp = col + col2;
                        if (col + col2 < 0) {columnTemp+= picture.width();}
                        else if (col + col2 >= picture.width()) {columnTemp -= picture.width();}
                        if (row + row2 < 0) {rowTemp+= picture.height();}
                        else if (row + row2 >= picture.height()) {rowTemp-= picture.height();}

                        if (columnTemp< 0) {columnTemp+= picture.width();}
                        else if (columnTemp >= picture.width()) {columnTemp-= picture.width();}
                        if (rowTemp < 0) {rowTemp+= picture.height();}
                        else if (rowTemp>= picture.height()) {rowTemp-= picture.height();}
                        //conditions for when kernel wraps around
                        Color colorTemp = picture.get(columnTemp, rowTemp);
                        redValues[increment] = colorTemp.getRed();
                        greenValues[increment] = colorTemp.getGreen();
                        blueValues[increment] = colorTemp.getBlue();
                        increment++;
                    }
                }
                int newRed = 0;
                int newGreen = 0;
                int newBlue = 0;
                newRed = newRed - redValues[0] - redValues[1] - redValues[2] - redValues[3] + 8*redValues[4] - redValues[5] - redValues[6] - redValues[7] - redValues[8];
                newGreen = newGreen - greenValues[0] - greenValues[1] - greenValues[2] - greenValues[3] + 8*greenValues[4] - greenValues[5] - greenValues[6] - greenValues[7] - greenValues[8];
                newBlue = newBlue - blueValues[0] - blueValues[1] - blueValues[2] - blueValues[3] + 8*blueValues[4] - blueValues[5] - blueValues[6] - blueValues[7] - blueValues[8];

                if (newRed > 255) {newRed = 255;}
                if (newRed < 0) { newRed = 0;}
                if (newGreen > 255) {newGreen = 255;}
                if (newGreen < 0) { newGreen = 0;}
                if (newBlue > 255) {newBlue = 255;}
                if (newBlue < 0) { newBlue = 0;}
                //kernel operations
                Color laplacianFilter = new Color(newRed, newGreen, newBlue);
                laplacian.set(col, row, laplacianFilter);
            }
        }
        return laplacian;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        Picture emboss = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                int increment = 0;
                int[] redValues = new int[9];
                int[] greenValues = new int[9];
                int[] blueValues = new int[9];
                for(int col2 = -1; col2 <= 1; col2++) { 
                    for(int row2 = -1; row2 <= 1; row2++) {
                        int rowTemp = row + row2;
                        int columnTemp = col + col2;
                        if (col + col2 < 0) {columnTemp+= picture.width();}
                        else if (col + col2 >= picture.width()) {columnTemp -= picture.width();}
                        if (row + row2 < 0) {rowTemp+= picture.height();}
                        else if (row + row2 >= picture.height()) {rowTemp-= picture.height();}

                        if (columnTemp< 0) {columnTemp+= picture.width();}
                        else if (columnTemp >= picture.width()) {columnTemp-= picture.width();}
                        if (rowTemp < 0) {rowTemp+= picture.height();}
                        else if (rowTemp>= picture.height()) {rowTemp-= picture.height();}
                        //conditions for when kernel wraps around
                        Color colorTemp = picture.get(columnTemp, rowTemp);
                        redValues[increment] = colorTemp.getRed();
                        greenValues[increment] = colorTemp.getGreen();
                        blueValues[increment] = colorTemp.getBlue();
                        increment++;
                    }
                }
                int newRed = 0;
                int newGreen = 0;
                int newBlue = 0;
                newRed += -2*redValues[0] - redValues[1] - redValues[3] + redValues[4] + redValues[5] + redValues[7] + 2*redValues[8];
                newGreen += -2*greenValues[0] - greenValues[1] - greenValues[3] + greenValues[4] + greenValues[5] + greenValues[7] + 2*greenValues[8];
                newBlue += -2*blueValues[0] - blueValues[1] - blueValues[3] + blueValues[4] + blueValues[5] + blueValues[7] + 2*blueValues[8];
                if (newRed > 255) {newRed = 255;}
                if (newRed < 0) { newRed = 0;}
                if (newGreen > 255) {newGreen = 255;}
                if (newGreen < 0) { newGreen = 0;}
                if (newBlue > 255) {newBlue = 255;}
                if (newBlue < 0) { newBlue = 0;}
                //kernel operations
                Color embossFilter = new Color(newRed, newGreen, newBlue);
                emboss.set(col, row, embossFilter);
            }
        }
        return emboss;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        Picture motionBlur = new Picture(picture.width(), picture.height());
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                float red = 0;
                float green = 0;
                float blue = 0;
                for (int i = -4; i <= 4; i++) {
                    int col2 = col + i;
                    int row2 = row + i;

                    if (col + i < 0) {col2+= picture.width();}
                    else if (col + i >= picture.width()) {col2-= picture.width();}
                    if (row + i < 0) {row2+= picture.height();}
                    else if (row + i >= picture.height()) {row2-= picture.height();}

                    if (col2< 0) {col2+= picture.width();}
                    else if (col2 >= picture.width()) {col2-= picture.width();}
                    if (row2 < 0) {row2+= picture.height();}
                    else if (row2>= picture.height()) {row2-= picture.height();}
                    //algorithm to wrap when index is out of bound in picture

                    Color colorTemp = picture.get(col2, row2);
                    red += colorTemp.getRed();
                    green += colorTemp.getGreen();
                    blue += colorTemp.getBlue();
                }
                Color colorBlur = new Color(Math.round(red/9), Math.round(green/9), Math.round(blue/9));
                motionBlur.set(col, row, colorBlur);
            }
        }
        return motionBlur;
    }
    
    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture  = new Picture("https://introcs.cs.princeton.edu/java/stdlib/mandrill.jpg");
        Picture identity = identity(picture);
        Picture gaussian = gaussian(picture);
        Picture sharpen = sharpen(picture);
        Picture laplacian = laplacian(picture);
        Picture emboss = emboss(picture);
        Picture motionBlur = motionBlur(picture);
        identity.show();
        gaussian.show();
        sharpen.show();
        laplacian.show();
        emboss.show();
        motionBlur.show();
    }
}
