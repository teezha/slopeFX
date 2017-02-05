package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField x1;

    @FXML
    private TextField y1;

    @FXML
    private TextField x2;

    @FXML
    private TextField y2;

    @FXML
    private TextField z1;

    @FXML
    private TextField z2;

    @FXML
    private TextField dist;

    @FXML
    private Button btnCalc;

    @FXML
    private Button btnClose;

    @FXML
    void calc(ActionEvent event) {


        try {
            double xo, yo, zo, xt, yt, zt;
            xo = Double.parseDouble(x1.getText());
            yo = Double.parseDouble(y1.getText());
            zo = Double.parseDouble(z1.getText());
            xt = Double.parseDouble(x2.getText());
            yt = Double.parseDouble(y2.getText());
            zt = Double.parseDouble(z2.getText());

            //Squaring the difference for X and Y coordinates from the calculated variables.
            double dis;
            /** =========================================================================
             * Calculating the distance between two points by squaring the sum of
             * the difference squared then displaying the distance in the prompt.
             * ==========================================================================
             */

            dis = Math.sqrt(Math.pow((xt - xo), 2) + Math.pow((yt - yo), 2));

            /** ===========================================================================
             *  Uses the difference between Z coordinates divided by the X Y distance to
             *  calculate the slope between the points. The results are then displayed in
             *  degrees and % grade.
             *  ===========================================================================
             */

            double slop;
            slop = Math.abs(Math.toDegrees(Math.atan((zt - zo) / dis)));
            dist.setText((String.valueOf(slop)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("Error");
            msg.setContentText("Enter valid numbs only yo");
            msg.showAndWait();
        }
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);

    }

}
