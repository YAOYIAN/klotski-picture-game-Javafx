package test2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import javafx.util.Duration;
import javafx.stage.FileChooser;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class A extends Application {
	String file_path;
	VBox vBox = new VBox();
	int[] bushu = new int[1];

	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		HBox hBox1 = new HBox();
		HBox hBox2 = new HBox();
		StackPane pane1kaishi = new StackPane();
		Button start_to_play = new Button("开始游戏");
		start_to_play.setFont(new Font("宋体", 40));
		start_to_play.setMinSize(140, 40);
		start_to_play.setAlignment(Pos.CENTER);
		ImageView beijing = new ImageView(new Image("image/3.png"));
		beijing.setFitHeight(740);
		beijing.setFitWidth(1200);
		pane1kaishi.getChildren().addAll(beijing, start_to_play);
		borderPane.setCenter(pane1kaishi);
		Button chaxuButton = new Button("记录查询");
		chaxuButton.setFont(new Font("宋体", 12));
		ComboBox<Integer> cbo3 = new ComboBox<>();
		cbo3.getItems().addAll(3, 4, 5, 6, 7, 8, 9, 10);
		cbo3.setStyle("-fx-color: white");
		cbo3.setValue(3);
		ComboBox<Integer> cbo4 = new ComboBox<>();
		cbo4.getItems().addAll(3, 4, 5, 6, 7, 8, 9, 10);
		cbo4.setStyle("-fx-color: white");
		cbo4.setValue(3);
		Label label1 = new Label("行数:");
		Label label2 = new Label("列数:");
		ComboBox<Integer> cbo1 = new ComboBox<>();
		cbo1.getItems().addAll(3, 4, 5, 6, 7, 8, 9, 10);
		cbo1.setStyle("-fx-color: white");
		cbo1.setValue(3);
		cbo1.setPrefSize(80, 30);
		ComboBox<Integer> cbo2 = new ComboBox<>();
		cbo2.getItems().addAll(3, 4, 5, 6, 7, 8, 9, 10);
		cbo2.setStyle("-fx-color: white");
		cbo2.setValue(3);
		cbo2.setPrefSize(80, 30);
		Button startplay = new Button("开始游戏/重新开始");
		startplay.setFont(new Font("宋体", 16));
		Button finishButton = new Button("保存游戏记录");
		finishButton.setFont(new Font("宋体", 16));
		Button choose_picture = new Button("选择你的图片");
		choose_picture.setFont(new Font("宋体", 16));
		Text text_time = new Text("时间: " + "00:00:00");
		text_time.setFont(Font.font("Times", 32));
		text_time.setFill(Color.ORANGE);
		Time time = new Time();
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
			time.start();
			text_time.setText("时间: " + time.toString());
		}));
		animation.setCycleCount(Timeline.INDEFINITE);
		chaxuButton.setOnAction(e -> {
			time.clear();
			text_time.setText("时间: " + "00:00:00");
			animation.pause();
			BorderPane pane2tishi = new BorderPane();
			StackPane bottomStackPane = new StackPane();
			bottomStackPane.setPrefHeight(100);
			Text text = new Text("请在下方选择行数，列数以及你要玩的游戏图片");
			text.setFont(new Font("宋体", 28));
			text.setFill(Color.GREEN);
			bottomStackPane.getChildren().addAll(text);
			ImageView weikaishi_ImageView = new ImageView(new Image("image/8.png"));
			pane2tishi.setCenter(weikaishi_ImageView);
			pane2tishi.setBottom(bottomStackPane);
			borderPane.setCenter(pane2tishi);
			TextArea textArea = new TextArea();
			textArea.setPrefHeight(460);
			ScrollPane scrollPane = new ScrollPane(textArea);
			textArea.setFont(Font.font("", 12));
			scrollPane.setPrefHeight(460);
			try (Scanner input = new Scanner(
					new File(Integer.toString(cbo3.getValue()) + "_" + Integer.toString(cbo4.getValue()) +
							".txt"))) {
				String string = new String();
				string = "月" + "\t日" + "\t小时" + "\t分钟" + "\t步数" + "\t 用时" + "\t\t图片地址" + "\n";
				string += input.nextLine();
				while (input.hasNextLine()) {
					string += ("\n" + input.nextLine());
				}
				StackPane chaxunPane = new StackPane();
				VBox chaxunVBox = new VBox();
				HBox anniu_HBox = new HBox();
				anniu_HBox.setAlignment(Pos.TOP_CENTER);
				anniu_HBox.getChildren().addAll(new Label("行数:"), cbo3, new Label("列数:"), cbo4, chaxuButton);
				anniu_HBox.setSpacing(10);
				textArea.setText(string);
				chaxunVBox.setMaxHeight(740);
				chaxunVBox.getChildren().addAll(anniu_HBox, scrollPane);
				chaxunVBox.setAlignment(Pos.TOP_CENTER);
				chaxunPane.getChildren().add(chaxunVBox);
				chaxunPane.setPrefHeight(700);
				chaxunPane.setPrefWidth(280);
				borderPane.setLeft(chaxunPane);
			} catch (FileNotFoundException e1) {
				String string = "文件不存在，没有游戏记录";
				StackPane chaxunPane = new StackPane();
				VBox chaxunVBox = new VBox();
				HBox anniu_HBox = new HBox();
				anniu_HBox.setAlignment(Pos.TOP_CENTER);
				anniu_HBox.getChildren().addAll(new Label("行数:"), cbo3, new Label("列数:"), cbo4, chaxuButton);
				anniu_HBox.setSpacing(10);
				Label chaxun_jieguo = new Label(string);
				chaxunVBox.getChildren().addAll(anniu_HBox, chaxun_jieguo);
				chaxunVBox.setAlignment(Pos.TOP_CENTER);
				chaxunPane.getChildren().add(chaxunVBox);
				chaxunPane.setPrefHeight(500);
				chaxunPane.setPrefWidth(280);
				borderPane.setLeft(chaxunPane);
				e1.printStackTrace();
			}
		});
		start_to_play.setOnAction(e -> {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().add(text_time);
			borderPane.setTop(stackPane);
			ImageView shuomingImageView = new ImageView(new Image("image/6.png"));
			shuomingImageView.setFitHeight(300);
			shuomingImageView.setFitWidth(500);
			StackPane shuoming_StackPane = new StackPane();
			shuoming_StackPane.getChildren().add(shuomingImageView);
			Scene shuoming_Scene = new Scene(shuoming_StackPane, 500, 300);
			Stage shuoming_Stage = new Stage();
			shuoming_Stage.setScene(shuoming_Scene);
			shuoming_Stage.show();

			BorderPane pane2tishi = new BorderPane();
			StackPane bottomStackPane = new StackPane();
			bottomStackPane.setPrefHeight(100);
			Text text = new Text("请在下方选择行数，列数以及你要玩的游戏图片");
			text.setFont(new Font("宋体", 28));
			text.setFill(Color.GREEN);
			bottomStackPane.getChildren().add(text);
			ImageView weikaishi_ImageView = new ImageView(new Image("image/8.png"));
			pane2tishi.setCenter(weikaishi_ImageView);
			pane2tishi.setBottom(bottomStackPane);
			borderPane.setCenter(pane2tishi);
			borderPane.setBottom(vBox);
			StackPane chaxunPane = new StackPane();
			VBox chaxunVBox = new VBox();
			HBox anniu_HBox = new HBox();
			anniu_HBox.setAlignment(Pos.TOP_CENTER);
			anniu_HBox.getChildren().addAll(new Label("行数:"), cbo3, new Label("列数:"), cbo4, chaxuButton);
			anniu_HBox.setSpacing(10);
			Label chaxun_jieguo = new Label();
			chaxunVBox.getChildren().addAll(anniu_HBox, chaxun_jieguo);
			chaxunVBox.setAlignment(Pos.TOP_CENTER);
			chaxunPane.getChildren().add(chaxunVBox);
			chaxunPane.setPrefHeight(500);
			chaxunPane.setPrefWidth(280);
			borderPane.setLeft(chaxunPane);
			Pane rightPane = new Pane();
			rightPane.setPrefWidth(280);
			borderPane.setRight(rightPane);
		});
		finishButton.setOnAction(e -> {
			animation.pause();
			try (FileWriter writer = new FileWriter(
					Integer.toString(cbo1.getValue()) + "_" + Integer.toString(cbo2.getValue()) +
							".txt",
					true)) {
				Calendar calendar = Calendar.getInstance();
				writer.write((calendar.get(Calendar.MONTH) + 1) + "\t"
						+ calendar.get(Calendar.DATE) + "\t" + calendar.get(Calendar.HOUR_OF_DAY) + "\t"
						+ calendar.get(Calendar.MINUTE) + "\t" + Integer.toString(bushu[0]) + "\t" + time.toString()
						+ "\t" + file_path + "\n");
				writer.close();
				Text shuju = new Text((calendar.get(Calendar.MONTH) + 1) + "月 "
						+ calendar.get(Calendar.DATE) + "日 " + calendar.get(Calendar.HOUR_OF_DAY) + "时 "
						+ calendar.get(Calendar.MINUTE) + "分 " + "\n\t步数: " + Integer.toString(bushu[0]) + "\n\t用时: "
						+ time.toString()
						+ "\n"
						+ "\t数据已保存!");
				shuju.setFont(new Font("宋体", 20));
				StackPane stackPane = new StackPane();
				stackPane.getChildren().add(shuju);
				stackPane.setPrefHeight(200);
				stackPane.setPrefWidth(350);
				Scene scene_tanchu = new Scene(stackPane);
				Stage stage = new Stage();
				stage.setScene(scene_tanchu);
				stage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		startplay.setOnAction(e -> {
			time.clear();
			animation.play();
			File file = new File("music/ks.mp3");
			String url = file.toURI().toString();
			Media media1 = new Media(url);
			MediaPlayer mplayer = new MediaPlayer(media1);
			mplayer.play();
			bushu[0] = 0;
			RealGame realGame = new RealGame(cbo1.getValue(), cbo2.getValue());
			Pane[] griPane_and_rightPane = new Pane[2];
			GridPane gridPane = new GridPane();
			StackPane rightPane = new StackPane();
			griPane_and_rightPane = RealGame.play(realGame, "file:" + file_path, bushu, animation);
			gridPane = (GridPane) griPane_and_rightPane[0];
			rightPane = (StackPane) griPane_and_rightPane[1];
			gridPane.setAlignment(Pos.CENTER);
			borderPane.setCenter(gridPane);
			borderPane.setRight(rightPane);
			gridPane.requestFocus();
		});
		choose_picture.setOnAction(e -> {
			time.clear();
			text_time.setText("时间: " + "00:00:00");
			animation.pause();
			FileChooser chooser = new FileChooser();
			file_path = chooser.showOpenDialog(null).getAbsolutePath();
			System.out.println(file_path);
		});
		hBox1.getChildren().addAll(label1, cbo1, label2, cbo2, choose_picture);
		hBox2.getChildren().addAll(startplay, finishButton);
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);
		hBox1.setSpacing(20);
		hBox2.setSpacing(20);
		vBox.getChildren().addAll(hBox1, hBox2);
		vBox.setSpacing(20);
		Scene scene = new Scene(borderPane, 1200,
				740);
		primaryStage.setTitle("MYjavafx");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
