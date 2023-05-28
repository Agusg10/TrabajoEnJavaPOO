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


public class PublicationsStatistics {

    public static void BarChart(int audio, int video, int text, int image, String statistic, String ejeY,String title){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(video, statistic, "Videos");
        dataset.addValue(image, statistic, "Imágenes");
        dataset.addValue(text, statistic, "Textos");
        dataset.addValue(audio, statistic, "Audios");

        // Crear el gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                title, // Título del gráfico
                "Tipo de publicación", // Etiqueta del eje X
                ejeY, // Etiqueta del eje Y
                dataset
        );

        // Mostrar el gráfico en una ventana
        ChartFrame frame = new ChartFrame("Estadísticas de publicaciones", chart);
        frame.pack();
        frame.setVisible(true);
    }

    public static void PieChart(int audio, int video, int text, int image){
        // Crear el conjunto de datos para el gráfico de torta
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Videos", video);
        dataset.setValue("Imágenes", image);
        dataset.setValue("Textos", text);
        dataset.setValue("Audios", audio);

        // Crear el gráfico de torta
        JFreeChart chart = ChartFactory.createPieChart(
                "Estadísticas de publicaciones", // Título del gráfico
                dataset,
                true, // Mostrar leyenda
                true, // Mostrar tooltips
                false // No mostrar URLs
        );

        // Obtener el objeto PiePlot y configurar el generador de etiquetas
        PiePlot plot = (PiePlot) chart.getPlot();
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} ({1})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(labelGenerator);

        // Mostrar el gráfico en una ventana
        ChartFrame frame = new ChartFrame("Estadísticas de publicaciones", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
