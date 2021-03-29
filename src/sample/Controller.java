package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Controller {
    public Button button;
    public Canvas Canvas;
    public ComboBox choice;
    public Button clear;

@FXML
int[][] tablica_robocza;
public void initialize()
{
    Main.generate_mesh(Canvas.getGraphicsContext2D(), Canvas);
   tablica_robocza = Main.Initialize_maintab(Canvas);

}
    public void Buttonclicked(javafx.event.ActionEvent actionEvent)
    {
        Main.Game_of_Life(tablica_robocza, Canvas.getGraphicsContext2D());

    }

    public void Comboboxchanged(javafx.event.ActionEvent actionEvent)
    {
        int[][] tablica = new int[0][];
        String value = (String) choice.getValue();
        switch (value) {
            case "Glider" -> tablica = Main.initialize_glider(tablica_robocza, Canvas.getGraphicsContext2D());
            case "Oscylator" -> tablica = Main.initialize_oscylator(tablica_robocza, Canvas.getGraphicsContext2D());
            case "Losowy" -> tablica = Main.random_picking(tablica_robocza, Canvas.getGraphicsContext2D());
            case "Niezmienne" -> tablica = Main.initialize_constant(tablica_robocza, Canvas.getGraphicsContext2D());
            case "Ręczna definicja" -> tablica = Main.manual_picking(tablica_robocza, Canvas.getGraphicsContext2D(), Canvas);
        }
        tablica_robocza = tablica;
    }
    public void ClearButtonPressed(javafx.event.ActionEvent actionEvent)
    {
        Main.clear(tablica_robocza, Canvas.getGraphicsContext2D());
    }


}
