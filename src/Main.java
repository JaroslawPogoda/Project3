import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


/*
 * @Author Jaroslaw Pogoda
 * @Run to save to file exit choose size frame that causes program to open notepad text file output
 * 
 */
import java.io.IOException;
public class Main extends Application{
	static int[][] qh=new int[4][5];
	//Creates 2D Line Graph of all four Sorting functions
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sort work vs size Jaroslaw Pogoda");
        
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Size of Array");
        
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Work vs Size Sorting Algorithms");
        
        //defining a series
		XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        XYChart.Series series4 = new XYChart.Series();
        //creating name plates for each series
        series.setName("Selection Sort");
        series2.setName("Insertion Sort");
        series3.setName("Heap Sort");
        series4.setName("Quick Sort");
        
        //populating the series with data
        series.getData().add(new XYChart.Data(50, qh[0][0]));
        series.getData().add(new XYChart.Data(250, qh[0][1]));
        series.getData().add(new XYChart.Data(1000, qh[0][2]));
        series.getData().add(new XYChart.Data(2500, qh[0][3] ));
        series.getData().add(new XYChart.Data(5000, qh[0][4]));
        
        series2.getData().add(new XYChart.Data(50, qh[1][0]));
        series2.getData().add(new XYChart.Data(250, qh[1][1]));
        series2.getData().add(new XYChart.Data(1000, qh[1][2]));
        series2.getData().add(new XYChart.Data(2500, qh[1][3]));
        series2.getData().add(new XYChart.Data(5000, qh[1][4]));
        
        series3.getData().add(new XYChart.Data(50, qh[3][0]));
        series3.getData().add(new XYChart.Data(250, qh[3][1]));
        series3.getData().add(new XYChart.Data(1000, qh[3][2]));
        series3.getData().add(new XYChart.Data(2500, qh[3][3] ));
        series3.getData().add(new XYChart.Data(5000, qh[3][4]));
        
        series4.getData().add(new XYChart.Data(50, qh[2][0]));
        series4.getData().add(new XYChart.Data(250, qh[2][1]));
        series4.getData().add(new XYChart.Data(1000, qh[2][2]));
        series4.getData().add(new XYChart.Data(2500, qh[2][3] ));
        series4.getData().add(new XYChart.Data(5000, qh[2][4]));
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series,series2,series3,series4);
       
        stage.setScene(scene);
        stage.show();
    }
	
	@SuppressWarnings("unused")
	
	public static void main(String[] args) throws IOException {
		sizeFrame frames= new sizeFrame(args,qh);
		
		
	}
}
