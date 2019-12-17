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

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;


public class BarCharRisk1  extends ApplicationFrame {
    Risk[] risks = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\project-group-1\\src\\JsonFiles\\Risks.json", Risk[].class);

        public BarCharRisk1( String applicationTitle , String chartTitle ) {
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

        private CategoryDataset createDataset( ) {
            final String impact = "Impact";
            final String probability = "probability";
            final String risk = "risk";
            final DefaultCategoryDataset dataset =
                    new DefaultCategoryDataset( );

            for (int i = 0; i < risks.length; i++) {
                dataset.addValue(risks[i].getImpact(),risks[i].getDescription(),impact);
                dataset.addValue(risks[i].getProbability(),risks[i].getDescription(),probability);
                dataset.addValue(risks[i].getRisk(),risks[i].getDescription(),risk);
            }
            return dataset;
        }

//        public static void main( String[ ] args ) {
//            BarCharRisk1 chart = new BarCharRisk1("Risk Matrix",
//                "Project Sun Shine");
//            chart.pack( );
//            RefineryUtilities.centerFrameOnScreen( chart );
//            chart.setVisible( true );
//        }
    }
