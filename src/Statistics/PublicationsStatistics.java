package Statistics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.text.DecimalFormat;

/**
 * The PublicationsStatistics class provides methods to generate statistical charts for publications.
 */
public class PublicationsStatistics {

    /**
     * Generates a bar chart with publication statistics.
     *
     * @param audio     The number of audio publications.
     * @param video     The number of video publications.
     * @param text      The number of text publications.
     * @param image     The number of image publications.
     * @param statistic The statistic used for the data.
     * @param ejeY      The label for the Y-axis of the chart.
     * @param title     The title of the chart.
     */
    public static void BarChart(int audio, int video, int text, int image, String statistic, String ejeY, String title) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(video, statistic, "Videos");
        dataset.addValue(image, statistic, "Imágenes");
        dataset.addValue(text, statistic, "Textos");
        dataset.addValue(audio, statistic, "Audios");

        // Create the bar chart
        JFreeChart chart = ChartFactory.createBarChart(
                title, // Chart title
                "Tipo de publicación", // X-axis label
                ejeY, // Y-axis label
                dataset
        );

        // Display the chart in a frame
        ChartFrame frame = new ChartFrame("Estadísticas de publicaciones", chart);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Generates a pie chart with publication statistics.
     *
     * @param audio The number of audio publications.
     * @param video The number of video publications.
     * @param text  The number of text publications.
     * @param image The number of image publications.
     */
    public static void PieChart(int audio, int video, int text, int image) {
        // Create the dataset for the pie chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Videos", video);
        dataset.setValue("Imágenes", image);
        dataset.setValue("Textos", text);
        dataset.setValue("Audios", audio);

        // Create the pie chart
        JFreeChart chart = ChartFactory.createPieChart(
                "Estadísticas de publicaciones", // Chart title
                dataset,
                true, // Show legend
                true, // Show tooltips
                false // Do not show URLs
        );

        // Get the PiePlot object and configure the label generator
        PiePlot plot = (PiePlot) chart.getPlot();
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} ({1})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(labelGenerator);

        // Display the chart in a frame
        ChartFrame frame = new ChartFrame("Estadísticas de publicaciones", chart);
        frame.pack();
        frame.setVisible(true);
    }
}