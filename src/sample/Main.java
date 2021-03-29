package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    static void generate_mesh(GraphicsContext graphicsContext, Canvas canvas)
    {
        graphicsContext.setStroke(Color.BLACK);
        int i, j;
        for( i = 0; i< canvas.getHeight()/10; i++)
        {
            for( j = 0; j< canvas.getWidth()/10; j++)
            {
                graphicsContext.strokeRect(i*10, j*10, 10, 10);
            }
        }
    }
    static int[][] Initialize_maintab(Canvas canvas)
    {

        int y = (int) (canvas.getHeight()/10);
        int x = (int) (canvas.getWidth()/10);
        int [][] maintab = new int[x][y];
        int i, j;
        for(i =0; i<y; i++)
        {
            for(j=0; j<x;j++)
            {
                maintab[i][j] =0;
            }
        }
        return maintab;
    }
    static void Game_of_Life(int[][] tab, GraphicsContext graphicsContext)
    {

        int maxx = tab[0].length;
        int maxy = tab.length;
        int i, j;

        for( i = 0; i<maxy; i++)
        {
            for(j = 0; j<maxx; j++) {
                int living_neighbors = 0;

                    graphicsContext.setFill(Color.YELLOW);
                graphicsContext.setStroke(Color.BLACK);
                int b = i - 1;
                if (b < 0) {
                    b = maxy - 1;

                }
                int c = i + 1;
                if (c > maxy - 1) {
                    c = 0;

                }
                int d = j - 1;
                if (d < 0) {
                    d = maxx - 1;

                }
                int e = j + 1;
                if (e > maxx - 1) {
                    e = 0;

                }


                if (tab[b][d] == 1) {
                    living_neighbors++;
                }

                if (tab[b][j] == 1) {
                    living_neighbors++;
                }

                if (tab[b][e] == 1) {
                    living_neighbors++;
                }

                if (tab[i][d] == 1) {
                    living_neighbors++;
                }

                if (tab[i][e] == 1) {
                    living_neighbors++;
                }

                if (tab[c][d] == 1) {
                    living_neighbors++;
                }

                if (tab[c][j] == 1) {
                    living_neighbors++;
                }

                if (tab[c][e] == 1) {
                    living_neighbors++;
                }

                if(living_neighbors!=0)
                {
                    System.out.println(living_neighbors);
                }

                if(tab[i][j] ==0 && living_neighbors==3)
                {
                    tab[i][j] = 1;
                }
                else if(tab[i][j]==1 &&living_neighbors >1 && living_neighbors <4)
                {
                    tab[i][j] =1;
                }
                else if(tab[i][j]==1 && living_neighbors>3)
                {
                    tab[i][j] =0;
                }
                else if(tab[i][j] ==1 && living_neighbors<2)
                {
                    tab[i][j]= 0;
                }
                else {
                    tab[i][j] = 0;
                }
                if (tab[i][j] ==1)
                {
                    graphicsContext.fillRect(i*10, j*10, 10, 10);
                    graphicsContext.strokeRect(i*10, j*10, 10, 10);
                }
                else if (tab[i][j] == 0)
                {
                    graphicsContext.setFill(Color.WHITE);
                    graphicsContext.fillRect(i*10, j*10, 10, 10);
                    graphicsContext.strokeRect(i*10, j*10, 10, 10);

                }
            }
        }
    }
    public static int[][] initialize_glider(int[][] tab, GraphicsContext graphicsContext)
    {
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.setStroke(Color.BLACK);
        int x = tab[0].length/2;
        int y = tab.length/2;
        tab[x][y] = 1;
        tab[x][y-1] =1;
        tab[x+1][y-1] =1;
        tab[x+1][y+1] =1;
        tab[x-1][y] =1;
        int i, j;
        for( i = 0; i<tab.length; i++)
        {
            for(j = 0; j<tab[0].length; j++)
            {
                if (tab[i][j] ==1)
                {
                    graphicsContext.fillRect(i*10, j*10, 10, 10);
                    graphicsContext.strokeRect(i*10, j*10, 10, 10);
                }

            }
        }
        return tab;
    }
    public static int[][] initialize_oscylator(int[][]tab,GraphicsContext graphicsContext)
    {
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.setStroke(Color.BLACK);
        int x = tab[0].length/2;
        int y = tab.length/2;
        tab[x][y] = 1;
        tab[x][y+1] =1;
        tab[x][y-1] =1;
        int i, j;
        for( i = 0; i<tab.length; i++)
        {
            for(j = 0; j<tab[0].length; j++)
            {
                if (tab[i][j] ==1)
                {
                    graphicsContext.fillRect(i*10, j*10, 10, 10);
                    graphicsContext.strokeRect(i*10, j*10, 10, 10);
                }

            }
        }
    return tab;
    }
    public static int[][] initialize_constant(int[][]tab,GraphicsContext graphicsContext)
    {
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.setStroke(Color.BLACK);

        int x = tab[0].length/2;
        int y = tab.length/2;
        tab[x][y+1] = 1;
        tab[x+1][y+1] = 1;
        tab[x+2][y] = 1;
        tab[x-1][y] = 1;
        tab[x][y-1] = 1;
        tab[x+1][y-1] = 1;
        int i, j;
        for( i = 0; i<tab.length; i++)
        {
            for(j = 0; j<tab[0].length; j++)
            {
                if (tab[i][j] ==1)
                {
                    graphicsContext.fillRect(i*10, j*10, 10, 10);
                    graphicsContext.strokeRect(i*10, j*10, 10, 10);
                }

            }
        }
        return tab;
    }
    public static int[][] manual_picking(int [][] tab, GraphicsContext graphicsContext, Canvas canvas)

    {
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.setStroke(Color.BLACK);
        final int[] xposition = new int[1];
        final int[] yposition = new int[1];
        canvas.setOnMouseClicked(event -> {
             double x = event.getX();
             double y = event.getY();
             xposition[0] =(int) x/10;
             yposition[0] =(int) y/10;


        tab[xposition[0]][yposition[0]] =1;

        int i, j;
        for( i = 0; i<tab.length; i++)
        {
            for(j = 0; j<tab[0].length; j++)
            {
                if (tab[i][j] ==1)
                {
                    graphicsContext.fillRect(i*10, j*10, 10, 10);
                    graphicsContext.strokeRect(i * 10, j * 10, 10, 10);
                }

            }
        }});
        return tab;
    }
    public static int[][] random_picking(int [][] tab, GraphicsContext graphicsContext)
    {
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.setStroke(Color.BLACK);
        Random rand = new Random();
        int randomNum = rand.nextInt((899) + 1);
        System.out.println(randomNum);
        int i, j, k;
        for(i = 0; i<randomNum; i++)
        {
            int x = rand.nextInt((299) + 1)/10;
            int y = rand.nextInt((299) + 1)/10;
            System.out.println(x+ " "+ y);
            for(j = 0; j<tab.length; j++)
            {
                for(k = 0; k<tab[0].length; k++)
                {
                    if(j == y && k ==x)
                    {
                        tab[j][k] =1;
                        if(tab[j][k] ==1)
                        {
                            graphicsContext.fillRect(j*10, k*10, 10, 10);
                            graphicsContext.strokeRect(j*10, k*10, 10, 10);
                        }
                    }
                }
            }

        }

        return tab;
    }
    public static void clear(int[][] tab, GraphicsContext graphicsContext)
    {
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setFill(Color.WHITE);
        int  i, j;
        for(i =0; i< tab.length; i++)
        {
            for(j=0; j<tab[0].length; j++)
            {
                tab[i][j] =0;

                graphicsContext.fillRect(i*10, j*10, 10, 10);
                graphicsContext.strokeRect(i*10, j*10, 10, 10);

            }
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene Gui = new Scene(root);
        primaryStage.setTitle("Game of life");
        primaryStage.setScene(Gui);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
