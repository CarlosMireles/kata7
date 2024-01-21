package software.ulpgc.kata3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistogramFromCsv implements Histogram{
    private final File file;
    private final int bins;
    private final int metric;

    public HistogramFromCsv(File file, int bins, int metric) {
        this.file = file;
        this.bins = bins;
        this.metric = metric;
    }


    @Override
    public int bins() {
        return bins;
    }

    @Override
    public double[] values() {
        return toDoubleArray(load());
    }

    private double[] toDoubleArray(List<Double> list) {
        double[] array = new double[list.size()];
        for (int i=0 ; i < list.size() ; i++){
            array[i] = list.get(i);
            }
        return array;
    }

    public List<Double> load(){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            return load(reader);
        } catch (FileNotFoundException e) {
            return Collections.EMPTY_LIST;
        } catch (IOException e) {
            return Collections.EMPTY_LIST;
        }
    }

    private List<Double> load(BufferedReader reader) throws IOException {
        List<Double> result = new ArrayList<>();
        reader.readLine();
        while (true){
            String line = reader.readLine();
            if (line == null) return result;
            result.add(toDouble(line));
        }
    }

    private Double toDouble(String line) {
        return selectedMetrictoDouble(line.split(","));
    }

    private Double selectedMetrictoDouble(String[] fields) {
        Double selectedMetric = Double.parseDouble(fields[metric]);
        return selectedMetric;
    }
}
