package test2;

import java.io.File;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RealGame extends Game {
    private int h_num;
    private int v_num;
    private int kong_xvalue;
    private int kong_yvalue;
    private int bushu;
    private ImageView imageView;
    private GridPane gamegGridPane;
    private StackPane rightPane;
    private int[] shuijishuzhu;
    private Pane[] imageViewpPanes;

    RealGame(int h_num, int v_num) {
        this.h_num = h_num;
        this.v_num = v_num;
        this.bushu = 0;
    }

    public int getBushu() {
        return bushu;
    };

    public void setBushu(int bushu) {
        this.bushu = bushu;
    }

    public StackPane getRightPane() {
        return rightPane;
    }

    public GridPane getGamegGridPane() {
        return gamegGridPane;
    }

    public int getKong_xvalue() {
        return kong_xvalue;
    }

    public int getKong_yvalue() {
        return kong_yvalue;
    }

    public void setKong_xvalue(int kong_xvalue) {
        this.kong_xvalue = kong_xvalue;
    }

    public void setKong_yvalue(int kong_yvalue) {
        this.kong_yvalue = kong_yvalue;
    }

    public int getH_num() {
        return h_num;
    }

    public int getV_num() {
        return v_num;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Pane[] getImageViewpPanes() {
        return imageViewpPanes;
    }

    public void setrightPane(StackPane rightPane) {
        rightPane.setPrefHeight(650);
        rightPane.setPrefWidth(280);
        String bushu_string = new String("步数:  " + Integer.toString(this.getBushu()));
        Text text = new Text(bushu_string);
        text.setFill(Color.BLUE);
        text.setFont(new Font("宋体", 28));
        rightPane.getChildren().add(text);
        this.rightPane = rightPane;
    }

    public void setGamegGridPane(GridPane gridPane) {
        int num = 0;
        for (int j = 0; j < this.getH_num(); j++)
            for (int i = 0; i < this.getV_num(); i++) {
                gridPane.add(this.getImageViewpPanes()[num], i, j);
                num++;
            }
        this.gamegGridPane = gridPane;
    }

    public void setShuijishuzhu(int[] shuijishuzhu) {
        this.shuijishuzhu = shuijishuzhu;
    }

    public int[] getShuijishuzhu() {
        return shuijishuzhu;
    }

    public void change_rightPane(StackPane rightPane) {
        String bushu_string = new String("步数:  " + Integer.toString(this.getBushu()));
        Text text = new Text(bushu_string);
        text.setFont(new Font("宋体", 28));
        text.setFill(Color.BLUE);
        rightPane.getChildren().clear();
        rightPane.getChildren().add(text);
    }

    public void tishi_rightPane(StackPane rightPane) {
        String tishi_string = new String("图片位置提示:\n");
        int num = 0;
        for (int i = 0; i < this.getH_num(); i++) {
            for (int j = 0; j < this.getV_num(); j++) {
                tishi_string += (Integer.toString(this.getShuijishuzhu()[num] + 1) + "\t");
                num++;
            }
            tishi_string += "\n";
        }
        Text text = new Text(tishi_string);
        text.setFont(new Font("宋体", 22));
        text.setFill(Color.RED);
        rightPane.getChildren().clear();
        rightPane.getChildren().add(text);
    }

    public void change_GamegGridPane(int from_y, int from_x, int to_y, int to_x, GridPane gridPane) {
        Pane temp1 = new Pane();
        Pane temp2 = new Pane();
        int temp3;
        int num1 = 0, num2 = 0, flag1 = 1, flag2 = 1;
        for (int j = 0; j < this.getH_num(); j++)
            for (int i = 0; i < this.getV_num(); i++) {
                if (i == from_y && j == from_x) {
                    temp1 = this.getImageViewpPanes()[num1];
                    flag1--;
                }
                if (i == to_y && j == to_x) {
                    temp2 = this.getImageViewpPanes()[num2];
                    flag2--;
                }
                if (flag1 == 1) {
                    num1++;
                }
                if (flag2 == 1) {
                    num2++;
                }
            }
        this.getImageViewpPanes()[num1] = temp2;
        this.getImageViewpPanes()[num2] = temp1;
        temp3 = this.getShuijishuzhu()[num1];
        this.getShuijishuzhu()[num1] = this.getShuijishuzhu()[num2];
        this.getShuijishuzhu()[num2] = temp3;
        gridPane.getChildren().remove(temp1);
        gridPane.getChildren().remove(temp2);
        gridPane.add(temp1, to_y, to_x);
        gridPane.add(temp2, from_y, from_x);
    }

    public void setImageViews(Image a) {
        double hang = this.getH_num();
        double lie = this.getV_num();
        int temp, jiaohuan1, jiaohuan2;
        Pane[] imageViewpPanes = new Pane[(int) (hang * lie)];
        int[] shuijishu_biao = new int[(int) (hang * lie)];
        int[] shuijishuzhu = new int[(int) (hang * lie)];
        for (int i = 0; i < (int) (hang * lie); i++)
            shuijishu_biao[i] = i;
        int cs = 0;
        while (cs < 1000) {
            jiaohuan1 = (int) (Math.random() * (hang * lie));
            jiaohuan2 = (int) (Math.random() * (hang * lie));
            if (jiaohuan1 != jiaohuan2 && jiaohuan1 < hang * lie - 1 && jiaohuan2 < hang * lie - 1) {
                cs++;
                temp = shuijishu_biao[jiaohuan1];
                shuijishu_biao[jiaohuan1] = shuijishu_biao[jiaohuan2];
                shuijishu_biao[jiaohuan2] = temp;
            }
        }
        for (int i = 0; i < shuijishuzhu.length; i++)
            shuijishuzhu[shuijishu_biao[i]] = i;
        this.setShuijishuzhu(shuijishuzhu);
        int num = 0;
        for (int j = 0; j < hang; j++)
            for (int i = 0; i < lie; i++) {
                ImageView imageView = new ImageView(a);
                Rectangle2D rectangle = new Rectangle2D((a.getWidth() / lie) * (i), (a.getHeight() / hang) * (j),
                        (a.getWidth() / lie),
                        (a.getHeight() / hang));
                imageView.setViewport(rectangle);
                imageView.setFitHeight(600 / hang);
                imageView.setFitWidth(600 / lie);
                imageViewpPanes[shuijishu_biao[num]] = new Pane();
                imageViewpPanes[shuijishu_biao[num]].getChildren().add(imageView);
                num++;
                if (num == (int) (lie * hang) - 1)
                    break;
            }

        ImageView imageView = new ImageView(new Image("image/white.png"));
        imageView.setFitHeight(600 / hang);
        imageView.setFitWidth(600 / lie);
        imageViewpPanes[num] = new Pane();
        imageViewpPanes[num].getChildren().add(imageView);
        this.imageViewpPanes = imageViewpPanes;
    }

    public static Pane[] play(RealGame realGame, String tupian_dizhi, int[] bushu, Timeline animation) {
        Pane[] gridPane_and_rightPane = new Pane[2];
        GridPane gridPane = new GridPane();
        StackPane rightPane = new StackPane();
        Image a = new Image(tupian_dizhi);
        realGame.setImageViews(a);
        realGame.setGamegGridPane(gridPane);
        realGame.setrightPane(rightPane);
        gridPane = realGame.getGamegGridPane();
        realGame.setKong_xvalue(realGame.getH_num() - 1);
        realGame.setKong_yvalue(realGame.getV_num() - 1);
        File file = new File("music/yd.mp3");
        String url = file.toURI().toString();
        Media media1 = new Media(url);
        File file2 = new File("music/ts.mp3");
        String url2 = file2.toURI().toString();
        Media media2 = new Media(url2);
        File file3 = new File("music/wc.mp3");
        String url3 = file3.toURI().toString();
        Media media3 = new Media(url3);
        gridPane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                case W:
                    if (realGame.getKong_xvalue() == realGame.getH_num() - 1)
                        break;
                    else {
                        MediaPlayer mplayer = new MediaPlayer(media1);
                        mplayer.play();
                        realGame.setBushu(realGame.getBushu() + 1);
                        bushu[0]++;
                        realGame.change_GamegGridPane(realGame.getKong_yvalue(),
                                realGame.getKong_xvalue(),
                                realGame.getKong_yvalue(), realGame.getKong_xvalue() + 1,
                                realGame.getGamegGridPane());
                        realGame.change_rightPane(rightPane);
                        realGame.setKong_xvalue(realGame.getKong_xvalue() + 1);
                        realGame.setKong_yvalue(realGame.getKong_yvalue());
                        if (isover(realGame.shuijishuzhu)) {
                            MediaPlayer mplayer2 = new MediaPlayer(media3);
                            mplayer2.play();
                            animation.pause();
                            realGame.gamegGridPane.getChildren().clear();
                            realGame.gamegGridPane.getChildren()
                                    .add(new ImageView("image/cgfy.png"));
                        }
                    }
                    break;
                case DOWN:
                case S:
                    if (realGame.getKong_xvalue() == 0)
                        break;
                    else {
                        MediaPlayer mplayer = new MediaPlayer(media1);
                        mplayer.play();
                        realGame.setBushu(realGame.getBushu() + 1);
                        bushu[0]++;
                        realGame.change_GamegGridPane(realGame.getKong_yvalue(),
                                realGame.getKong_xvalue(),
                                realGame.getKong_yvalue(), realGame.getKong_xvalue() - 1,
                                realGame.getGamegGridPane());
                        realGame.change_rightPane(rightPane);
                        realGame.setKong_xvalue(realGame.getKong_xvalue() - 1);
                        realGame.setKong_yvalue(realGame.getKong_yvalue());
                        if (isover(realGame.shuijishuzhu)) {
                            MediaPlayer mplayer2 = new MediaPlayer(media3);
                            mplayer2.play();
                            animation.pause();
                            realGame.gamegGridPane.getChildren().clear();
                            realGame.gamegGridPane.getChildren()
                                    .add(new ImageView("image/cgfy.png"));
                        }
                    }
                    break;
                case RIGHT:
                case A:
                    if (realGame.getKong_yvalue() == realGame.getV_num() - 1)
                        break;
                    else {
                        MediaPlayer mplayer = new MediaPlayer(media1);
                        mplayer.play();
                        realGame.setBushu(realGame.getBushu() + 1);
                        bushu[0]++;
                        realGame.change_GamegGridPane(realGame.getKong_yvalue(),
                                realGame.getKong_xvalue(),
                                realGame.getKong_yvalue() + 1, realGame.getKong_xvalue(),
                                realGame.getGamegGridPane());
                        realGame.change_rightPane(rightPane);
                        realGame.setKong_xvalue(realGame.getKong_xvalue());
                        realGame.setKong_yvalue(realGame.getKong_yvalue() + 1);
                        if (isover(realGame.shuijishuzhu)) {
                            MediaPlayer mplayer2 = new MediaPlayer(media3);
                            mplayer2.play();
                            animation.pause();
                            realGame.gamegGridPane.getChildren().clear();
                            realGame.gamegGridPane.getChildren()
                                    .add(new ImageView("image/cgfy.png"));
                        }
                    }
                    break;
                case LEFT:
                case D:
                    if (realGame.getKong_yvalue() == 0)
                        break;
                    else {
                        MediaPlayer mplayer = new MediaPlayer(media1);
                        mplayer.play();
                        realGame.setBushu(realGame.getBushu() + 1);
                        bushu[0]++;
                        realGame.change_GamegGridPane(realGame.getKong_yvalue(),
                                realGame.getKong_xvalue(),
                                realGame.getKong_yvalue() - 1, realGame.getKong_xvalue(),
                                realGame.getGamegGridPane());
                        realGame.change_rightPane(rightPane);
                        realGame.setKong_xvalue(realGame.getKong_xvalue());
                        realGame.setKong_yvalue(realGame.getKong_yvalue() - 1);
                        if (isover(realGame.shuijishuzhu)) {
                            MediaPlayer mplayer2 = new MediaPlayer(media3);
                            mplayer2.play();
                            animation.pause();
                            realGame.gamegGridPane.getChildren().clear();
                            realGame.gamegGridPane.getChildren()
                                    .add(new ImageView("image/cgfy.png"));
                        }
                    }
                    break;
                case SPACE:
                    MediaPlayer mplayer = new MediaPlayer(media2);
                    mplayer.play();
                    realGame.tishi_rightPane(rightPane);
                default:
                    break;
            }
        });
        gridPane_and_rightPane[0] = gridPane;
        gridPane_and_rightPane[1] = rightPane;
        return gridPane_and_rightPane;
    }
}