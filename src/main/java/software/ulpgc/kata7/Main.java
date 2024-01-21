package software.ulpgc.kata3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.histogramDisplay().show(histogram());
        mainFrame.setVisible(true);
    }

    private static Histogram histogram() {
        Histogram histogram = new HistogramFromCsv(new File("nfl_quarterbacks.csv"), 6, 10);
        return histogram;
    }
}
