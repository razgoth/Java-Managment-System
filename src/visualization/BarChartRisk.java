package visualization;

import TeamOneMiniProject.Risk;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import static TeamOneMiniProject.Calculations.RiskMatrices;
import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class BarChartRisk extends ApplicationFrame {
    Risk[] risks = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\project-group-1\\src\\JsonFiles\\Risks.json", Risk[].class);
    public BarChartRisk(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Risk Description",
                "Risk",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {

        final String barName = "Risks";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        for (int i = 0; i < risks.length; i++) {
            dataset.addValue(risks[i].getRisk(), risks[i].getDescription(), barName);
        }
        return dataset;
    }

//    public static void main(String[] args) {
//
//        BarChartRisk chart = new BarChartRisk("Risk Matrix",
//                "Project Sun Shine");
//        chart.pack();
//        RefineryUtilities.centerFrameOnScreen(chart);
//        chart.setVisible(true);
//    }
}
