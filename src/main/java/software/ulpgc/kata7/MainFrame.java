package software.ulpgc.kata3;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private HistogramDisplay histogramDisplay;

    public MainFrame() throws HeadlessException{
        this.setTitle("Histogram Viewer");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createHistogramDisplay());
    }

    private Component createHistogramDisplay() {
        JFreeChartHistogramDisplay display = new JFreeChartHistogramDisplay();
        this.histogramDisplay = display;
        return display;
    }

    public HistogramDisplay histogramDisplay() {
        return histogramDisplay;
    }
}
