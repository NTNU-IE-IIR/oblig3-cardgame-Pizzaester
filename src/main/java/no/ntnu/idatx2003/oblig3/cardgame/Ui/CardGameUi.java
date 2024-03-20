package no.ntnu.idatx2003.oblig3.cardgame.Ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

import java.util.Collection;


public class CardGameUi extends Application {

  DeckOfCards deckOfCards;
  PlayingCard playingCard;
  private Stage primaryStage;

  private static final int CARD_TO_DRAW = 5;


  /**
   * Method that starts the application by calling the lanuch method.
   *
   * @param args
   */
  public static void appMain(String[] args) {
    launch();
  }


  /**
   * Start method that creates gui and the gui components.
   *
   * @param primaryStage the stage to be shown
   * @throws Exception if something goes wrong
   */
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    createWindow();
  }




 public void createWindow() {
    // Create a BorderPane
    BorderPane root = new BorderPane();

    root.setRight(createRightPane());
    root.setTop(createTopPane());
    root.setBottom(createBottomPane());
    root.setCenter(createCenterPane());

    Scene scene = new Scene(root, 999, 700);

    this.primaryStage.setTitle("Card Game");
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

  public void createWindow(Collection<PlayingCard> drawnCard) {
    // Create a BorderPane
    BorderPane root = new BorderPane();

    root.setRight(createRightPane());
    root.setTop(createTopPane());
    root.setBottom(createBottomPane());
    root.setCenter(createCenterPane(drawnCard));

    Scene scene = new Scene(root, 999, 700);

    this.primaryStage.setTitle("Card Game");
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }


  /**
   * Method that stops and exits the application.
   */
  @Override
  public void stop() {
    System.exit(0);
  }

  public VBox createCenterPane () {
    VBox centerBox = new VBox(20);
    centerBox.setStyle("-fx-background-color: #355E3B;");
    centerBox.setPrefSize(700, 500);
    centerBox.setAlignment(Pos.CENTER);
    HBox cardBoard = new HBox(10);
    cardBoard.setAlignment(Pos.CENTER);
    centerBox.getChildren().add(cardBoard);
    return centerBox;
  }

  public VBox createCenterPane(Collection<PlayingCard> drawnCards) {
    VBox centerBox = new VBox(20);
    centerBox.setStyle("-fx-background-color: #355E3B;");
    centerBox.setPrefSize(700, 500);
    centerBox.setAlignment(Pos.CENTER);
    HBox cardBoard = new HBox(10);
    cardBoard.setAlignment(Pos.CENTER);
    for (PlayingCard card : drawnCards) {
      Label cardLabel = new Label(card.cardAsString());
      cardBoard.getChildren().add(cardLabel);
    }
    centerBox.getChildren().add(cardBoard);
    return centerBox;
  }



  public VBox createTopPane () {
    VBox newBox = new VBox(10);
    Region spacer = new Region();
    spacer.setPrefSize(700, 50);
    HBox.setHgrow(spacer, Priority.ALWAYS);
    newBox.getChildren().addAll(spacer);

    return newBox;
  }


  public VBox createRightPane() {
    VBox rightBox = new VBox(50);
     rightBox.setAlignment(Pos.CENTER_RIGHT);

    // Creates buttons
    Button drawButton = new Button("Draw");
    drawButton.setPrefSize(100, 50);

    drawButton.setOnAction(event -> {

      DeckOfCards deck = new DeckOfCards(); // Create an instance of the DeckOfCards
      Collection<PlayingCard> drawnCards = deck.dealHand(CARD_TO_DRAW);
      createWindow(drawnCards);

    });






    Button showButton = new Button("Show");
    showButton.setPrefSize(100, 50);

    // Distributes objects to border areas
    rightBox.getChildren().addAll(drawButton, showButton);

    return rightBox;
  }

  public VBox createBottomPane() {
    VBox bottomBox = new VBox();

    HBox bottomSepperatedBox = new HBox(10);
    HBox topSepperatedBox = new HBox(10);

    TextArea bottomLeft = new TextArea();
    bottomLeft.setPrefSize(300, 50);
    bottomLeft.setWrapText(true);
    bottomLeft.setEditable(false);
    bottomLeft.setText("This is the bottom left area");

    TextArea bottomRight = new TextArea();
    bottomRight.setPrefSize(400, 50);
    bottomRight.setWrapText(true);
    bottomRight.setEditable(false);
    bottomRight.setText("This is the bottom right area");

    bottomSepperatedBox.getChildren().addAll(bottomLeft, bottomRight);

    HBox spacer = new HBox();
    spacer.setPrefSize(700, 50);

    IndexedCell topLeft = new IndexedCell();
    IndexedCell topRight = new IndexedCell();
    topSepperatedBox.getChildren().addAll(topLeft, topRight);

    // Creates buttons
    Button button1 = new Button("Test1");
    Button button2 = new Button("Test2");
    topSepperatedBox.getChildren().addAll(button1, button2);

    // Distributes objects to border areas
    bottomBox.getChildren().addAll(topSepperatedBox, bottomSepperatedBox, spacer);

    return bottomBox;
  }

  public HBox Card() {
    HBox card = new HBox();



    return card;
  }

  public void updateCardBox() {

  }


}
