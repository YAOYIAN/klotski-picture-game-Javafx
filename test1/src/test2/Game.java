package test2;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public abstract class Game {
    public abstract void setImageViews(Image a);

    public abstract void setGamegGridPane(GridPane gridPane);

    public abstract void setrightPane(StackPane rightPane);

    public abstract void change_GamegGridPane(int from_y, int from_x, int to_y,
            int to_x, GridPane gridPane);

    public abstract void change_rightPane(StackPane rightPane);

    public abstract void tishi_rightPane(StackPane rightPane);

    public static boolean isover(int[] list) {
        for (int i = 0; i < list.length - 1; i++)
            if (list[i] > list[i + 1])
                return false;
        return true;
    }

    // public static void setlist(int[] a, int[] b) {
    //     for (int i = 0; i < a.length; i++)
    //         b[i] = a[i] + 1;
    // }
}
