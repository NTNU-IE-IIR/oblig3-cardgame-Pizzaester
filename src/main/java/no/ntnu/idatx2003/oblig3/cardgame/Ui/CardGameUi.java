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

import javax.swing.*;
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
      VBox playingCard = new VBox(20);
      playingCard.setPrefSize(100, 200);
      playingCard.setStyle("-fx-background-color: #E9F3E8;");
      playingCard.setAlignment(Pos.CENTER);
      Label cardLabel = new Label(card.cardAsString());
      playingCard.getChildren().add(cardLabel);
      cardBoard.getChildren().add(playingCard);
    }
    centerBox.getChildren().add(cardBoard);
    return centerBox;
  }



  public VBox createTopPane () {
    VBox newBox = new VBox(10);
    Region spacer = new Region();
    spacer.setPrefSize(700, 50);
    HBox.setHgrow(spacer, Priority.NEVER);
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


    Button clearButton = new Button("Clear");
    clearButton.setPrefSize(100, 50);

    clearButton.setOnAction(event -> {
      createWindow();
    });

    Button checkButton = new Button("Check hand");
    checkButton.setPrefSize(100, 50);


    // Distributes objects to border areas
    rightBox.getChildren().addAll(drawButton, clearButton, checkButton);

    return rightBox;
  }

  public VBox createBottomPane() {
    VBox bottomBox = new VBox();


    HBox bottomSepperatedBox = new HBox(10);
    bottomSepperatedBox.setAlignment(Pos.CENTER);
    HBox topSepperatedBox = new HBox(10);
    topSepperatedBox.setAlignment(Pos.CENTER);

    HBox flushBox = flushBox();


    HBox queenOfSpadesBox = queenOfSpadesBox();

    bottomSepperatedBox.getChildren().addAll(flushBox, queenOfSpadesBox);



    HBox sumOfTheFacesBox = sumOfTheFacesBox();


    HBox cardsOfHeartsBox = new HBox();


    topSepperatedBox.getChildren().addAll(sumOfTheFacesBox, cardsOfHeartsBox);

    Region spacer = new Region();
    spacer.setPrefSize(10, 10);
    HBox.setHgrow(spacer, Priority.ALWAYS);

    // Distributes objects to border areas
    bottomBox.getChildren().addAll(topSepperatedBox,spacer, bottomSepperatedBox);

    return bottomBox;
  }

  public HBox flushBox() {
    HBox flushBox = new HBox();
    flushBox.setAlignment(Pos.CENTER);
    Label flushLabel = new Label("Flush: ");
    TextArea flushArea = new TextArea();
    flushArea.setPrefSize(10, 10);
    flushArea.setWrapText(true);
    flushArea.setEditable(false);
    flushBox.getChildren().addAll(flushLabel, flushArea);
    return flushBox;
  }

  public HBox queenOfSpadesBox() {
    HBox queenOfSpadesBox = new HBox();
    queenOfSpadesBox.setAlignment(Pos.CENTER);
    Label queenOfSpadesLabel = new Label("Queen of Spades: ");
    TextArea queenOfSpadesArea = new TextArea();
    queenOfSpadesArea.setPrefSize(10, 10);
    queenOfSpadesArea.setWrapText(true);
    queenOfSpadesArea.setEditable(false);
    queenOfSpadesBox.getChildren().addAll(queenOfSpadesLabel, queenOfSpadesArea);
    return queenOfSpadesBox;
  }

  public HBox sumOfTheFacesBox() {
    HBox sumOfTheFacesBox = new HBox();
    sumOfTheFacesBox.setAlignment(Pos.CENTER);
    Label sumOfTheFacesLabel = new Label("Sum of the faces: ");
    TextArea sumOfTheFacesArea = new TextArea();
    sumOfTheFacesArea.setPrefSize(10, 10);
    sumOfTheFacesArea.setWrapText(true);
    sumOfTheFacesArea.setEditable(false);
    sumOfTheFacesBox.getChildren().addAll(sumOfTheFacesLabel, sumOfTheFacesArea);
    return sumOfTheFacesBox;
  }

  public HBox cardsOfHeartsBox() {
    HBox cardsOfHeartsBox = new HBox();
    cardsOfHeartsBox.setAlignment(Pos.CENTER);
    Label cardsOfHeartsLabel = new Label("Cards of Hearts: ");
    TextArea cardsOfHeartsArea = new TextArea();
    cardsOfHeartsArea.setPrefSize(10, 10);
    cardsOfHeartsArea.setWrapText(true);
    cardsOfHeartsArea.setEditable(false);
    cardsOfHeartsBox.getChildren().addAll(cardsOfHeartsLabel, cardsOfHeartsArea);
    return cardsOfHeartsBox;
  }



}
