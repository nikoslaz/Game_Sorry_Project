import Controller.Controller;
import View.GraphicUI;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the instances
            GraphicUI graphicUI = new GraphicUI();
            Controller controller = new Controller();

            // Set dependencies
            graphicUI.setController(controller);
            controller.setGraphicUI(graphicUI);

            // Make the GraphicUI visible
            graphicUI.setVisible(true);
        });
    }
}
