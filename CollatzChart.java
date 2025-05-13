import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CollatzChart {


     //Visualizes the Collatz sequence for user's input and output
    public static void visualizeUserOutput(List<Integer> sequence, int input) {
        // Create a dataset for the sequence
        XYSeries series = new XYSeries("Collatz Sequence");
        for (int i = 0; i < sequence.size(); i++) {
            series.add(i, sequence.get(i));  // X-axis: steps going through, Y-axis: Values input
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Create the chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Collatz Sequence and User Output Visualization",
                "Step",  // X-axis label
                "Value", // Y-axis label
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // customization of chart
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false); // Remove connected lines
        renderer.setSeriesShapesVisible(0, true); // have dots for each input
        renderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-3, -3, 6, 6)); // dot shapes
        renderer.setSeriesPaint(0, Color.GREEN); // Set dot color
        plot.setRenderer(renderer);

        // Start input is highlighted
        XYTextAnnotation inputAnnotation = new XYTextAnnotation(
                "Start: " + input, 0, input
        );
        inputAnnotation.setFont(new Font("SansSerif", Font.BOLD, 12)); //bold the start input
        inputAnnotation.setPaint(Color.RED);
        plot.addAnnotation(inputAnnotation);

        // End of input is also highlighted
        int finalStep = sequence.size() - 1;
        int finalValue = sequence.get(finalStep);
        XYTextAnnotation outputAnnotation = new XYTextAnnotation(
                "End: " + finalValue, finalStep, finalValue
        );
        outputAnnotation.setFont(new Font("SansSerif", Font.BOLD, 12)); //bold end
        outputAnnotation.setPaint(Color.GREEN);
        plot.addAnnotation(outputAnnotation);

        // Customize background
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.LIGHT_RED);
        plot.setRangeGridlinePaint(Color.LIGHT_RED);

        // Displaying the chart in a JFrame
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Collatz Sequence Chart with User Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
