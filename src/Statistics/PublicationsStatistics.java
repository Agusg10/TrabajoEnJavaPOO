package Statistics;

import java.util.Arrays;

public class PublicationsStatistics {

    public static void likesStatistics(int audio, int likevideo, int text,int image) {

        // Generate an array containing the variable values
        int[] information = { audio, image, text, likevideo };

        // Find the maximum value among the variables
        int maxInformation = Arrays.stream(information).max().orElse(0);

        // Define the character to represent each bar
        char barCharacter = '#';

        // Calculate the scaling factor for the bars
        double scalingFactor = (maxInformation > 0) ? 40.0 / maxInformation : 0;

        // Generate the statistics diagram
        for (int i = 0; i < information.length; i++) {
            String bar = new String(new char[(int) (information[i] * scalingFactor)]).replace('\0', barCharacter);
            //System.out.printf("%-10s %s%n", getVariableName(i), bar);
            System.out.printf("%-13s %s (%d)%n", getVariableName(i), bar, information[i]);
        }
    }


    private static String getVariableName(int index) {
        return switch (index) {
            case 0 -> "Audio";
            case 1 -> "Imagen";
            case 2 -> "Texto";
            case 3 -> "Video";
            default -> "Desconocido";
        };
    }
}
