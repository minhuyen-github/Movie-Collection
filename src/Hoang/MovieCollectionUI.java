package Hoang;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import numberlist.InvalidIndexException;

/**
 * This class is a front end application created by using JavaFx so the user can
 * view the application of "Movie Collection".
 *
 * @author Nomingerel Tserenjav
 * @author Phuong Tran
 * @author Uyen Hoang
 * @version 1.0 06/13/2018
 */
public class MovieCollectionUI extends Application {

    MovieCollection mv = new MovieCollection();
    private ScrollPane rightPane = new ScrollPane();
    private FlowPane movieList = new FlowPane();
    TextField textTitle = new TextField();
    TextField textYear = new TextField();
    TextField textPrice = new TextField();
    TextField textGenre = new TextField();
    TextField textRate = new TextField();
    BorderPane rootPane = new BorderPane();

    /**
     * This is the constructor which creates the front end program with panes,
     * buttons and labels to collect and display information of DVD movies.
     *
     * @param primaryStage The primary stage displays all information of DVD
     * movies
     */
    @Override
    public void start(Stage primaryStage) {

        mv.createNewFile(); //create a file to save the data.
        Button[] buttons = new Button[4];
        for (int i = 0; i < 4; i++) {
            buttons[i] = new Button("button " + i);
        }
        mv.readFile(); //read data from the exist file to repopulate the list.

        //create panes to hold nodes.
        HBox topPane = makeTopPane();
        VBox leftPane = makeLeftPane();
        HBox bottomPane = makeBottomPane(buttons);
        rightPane = makeRightPane();

        //repopulate the buttons that have movies' names and movies' info to 
        //right pane.
        try {
            deleteButton();
        } catch (InvalidIndexException ex) {
            Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        //set the stage.
        primaryStage.setX(220);
        primaryStage.setY(60);
        primaryStage.setHeight(600);
        primaryStage.setWidth(930);
        primaryStage.setTitle("Movies Collection");

        rootPane.setBackground(new Background(
                new BackgroundFill(Color.MEDIUMSEAGREEN,
                        CornerRadii.EMPTY, Insets.EMPTY)));
        rootPane.setTop(topPane);
        rootPane.setLeft(leftPane);
        rootPane.setBottom(bottomPane);
        rootPane.setRight(rightPane);

        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        primaryStage.show();
        primaryStage.centerOnScreen();

        //save whatever the list has to a file so when the program is restart, 
        //read data and the list is repopulated.
        primaryStage.setOnCloseRequest(e -> mv.saveFile());
    }

    /**
     * This method creates the top pane, contains sort field: sort by movie,
     * sort by name and sort by genre.
     *
     * @return top pane.
     */
    public HBox makeTopPane() {
        //create the top pane.
        HBox topPane = new HBox();
        topPane.setPadding(new Insets(15, 12, 15, 12));
        topPane.setStyle("-fx-background-color: #3CB371;");
        Image topPic = new Image(getClass().getResourceAsStream("/Image/TopPic.png"));
        ImageView image = new ImageView(topPic);
        topPane.getChildren().add(image);

        // Create the combobox
        ComboBox cb = new ComboBox();
        cb.getItems().addAll("All movies", "Action", "Cartoon", "Horror");
        cb.setPromptText("Movie Genre");
        cb.setEditable(false);
        topPane.getChildren().add(cb);

        // Create the radio button
        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("Sort by name");
        button1.setToggleGroup(group);
        RadioButton button2 = new RadioButton("Sort by year");
        button2.setToggleGroup(group);

        //add radio buttons to the top pane.
        topPane.getChildren().addAll(button1, button2);

        //sort by the title, case is ignored.
        button1.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * This method will sort the movie list by using their titles, and
             * display the sorted list.
             *
             * @param event This is the event which will happen if the button is
             * clicked.
             */
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (button1.isSelected()) {
                        mv.sortByTitle();
                        deleteButton();
                        mv.saveFile();
                        textTitle.clear();
                        textGenre.clear();
                        textRate.clear();
                        textPrice.clear();
                        textYear.clear();
                    }
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        //sort by the year.
        button2.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * This method will sort the movie list by using their published
             * year, and display the sorted list.
             *
             * @param event This is the event which will happen if the button is
             * clicked.
             */
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (button2.isSelected()) {
                        mv.sortByYear();
                        deleteButton();
                        mv.saveFile();
                        textTitle.clear();
                        textGenre.clear();
                        textRate.clear();
                        textPrice.clear();
                        textYear.clear();
                    }
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        // Set the margin.
        HBox.setMargin(image, new Insets(20));
        HBox.setMargin(cb, new Insets(20));
        HBox.setMargin(button1, new Insets(20));
        HBox.setMargin(button2, new Insets(20));

        cb.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * This method will show either a new movie list sorted by their
             * genres or a movie list with every movies.
             *
             * @param event This is the event which will happen if a value of
             * the combo box is selected.
             */
            @Override
            public void handle(ActionEvent event) {
                String selected = cb.getValue().toString();
                //Show the buttons of all movies.
                if ("All movies".equals(selected)) {
                    try {
                        mv.showAllMovies();
                        deleteButton();
                        textTitle.clear();
                        textGenre.clear();
                        textRate.clear();
                        textPrice.clear();
                        textYear.clear();
                    } catch (InvalidIndexException ex) {
                        Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Show the buttons of action movie type only.
                if ("Action".equals(selected)) {
                    try {
                        mv.showAction();
                        deleteButtonAct();
                        textTitle.clear();
                        textGenre.clear();
                        textRate.clear();
                        textPrice.clear();
                        textYear.clear();
                    } catch (InvalidIndexException ex) {
                        Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    try {
//                        mv.clearAct();
//                    } catch (InvalidIndexException ex) {
//                        Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
                //Show the buttons of cartoon movie type only.
                if ("Cartoon".equals(selected)) {
                    try {
                        mv.showCartoon();
                        deleteButtonCart();
                        textTitle.clear();
                        textGenre.clear();
                        textRate.clear();
                        textPrice.clear();
                        textYear.clear();
                    } catch (InvalidIndexException ex) {
                        Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    try {
//                        mv.clearCart();
//                    } catch (InvalidIndexException ex) {
//                        Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
                //Show the buttons of horror movie type only.
                if ("Horror".equals(selected)) {
                    try {
                        mv.showHorror();
                        deleteButtonHor();
                        textTitle.clear();
                        textGenre.clear();
                        textRate.clear();
                        textPrice.clear();
                        textYear.clear();
                    } catch (InvalidIndexException ex) {
                        Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    try {
//                        mv.clearHor();
//                    } catch (InvalidIndexException ex) {
//                        Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
            }

        });

        return topPane;
    }

    /**
     * This method creates a left pane to display title, year, genre, price and
     * rate of sorted DVD movies.
     *
     * @return left pane
     */
    public VBox makeLeftPane() {
        //create a left pane.
        VBox leftPane = new VBox();
        leftPane.setPadding(new Insets(40, 60, 40, 60));
        Label labelTitle = new Label("Title:  ");
        Label labelYear = new Label("Year:  ");
        Label labelPrice = new Label("Price:  ");
        Label labelGenre = new Label("Genre:  ");
        Label labelRate = new Label("Rate:  ");
        //movies' info is shown on these corresponding text fields.
        textTitle.setEditable(false);
        textYear.setEditable(false);
        textPrice.setEditable(false);
        textGenre.setEditable(false);
        textRate.setEditable(false);
        leftPane.getChildren().addAll(labelTitle, textTitle, labelYear, textYear,
                labelPrice, textPrice, labelGenre, textGenre, labelRate, textRate);
        leftPane.setStyle("-fx-background-color: #FFFAFA;");
        return leftPane;
    }

    /**
     * This method creates a HBox which is the bottom pane contains add movie,
     * delete movie, clear movie and exit button
     *
     * @param buttons An array of buttons.
     * @return bottom pane
     */
    public HBox makeBottomPane(Button[] buttons) {
        HBox bottomPane = new HBox();
        for (int i = 0; i < 4; i++) {
            bottomPane.getChildren().add(buttons[i]);
            buttons[i].setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(buttons[i], Priority.ALWAYS);
        }
        //open a second window so the user can type in the movie info.
        buttons[0].setText("Add Movie");
        buttons[0].setOnAction(new EventHandler<ActionEvent>() {
            /**
             * This method will create a second window for the user to add a
             * movie by inputing and selecting information.
             *
             * @param event This is the event will happen if the button is
             * clicked.
             */
            @Override
            public void handle(ActionEvent event) {
                //create the root pane for the second window.
                BorderPane rootP = new BorderPane();
                HBox bottomLayout = new HBox();
                GridPane pane = new GridPane();
                Scene secondScene = new Scene(rootP, 400, 250);

                //create second window.
                Stage newWindow = new Stage();
                rootP.setBottom(bottomLayout);
                rootP.setCenter(pane);

                //Create buttons to add, clear and exit the second window.
                Button button1 = new Button();
                Button button2 = new Button();
                Button button3 = new Button();
                button1.setText("Save");
                button2.setText("Clear");
                button3.setText("Exit");

                //Exit the second window.
                button3.setOnAction(new EventHandler<ActionEvent>() {
                    /**
                     * This method will close the second window when the button
                     * is clicked.
                     *
                     * @param e The event which will happen if the button is
                     * clicked.
                     */
                    @Override
                    public void handle(ActionEvent e) {
                        newWindow.close();
                    }

                });
                //Input movie's title.
                Label lblTitle = new Label("Title:  ");
                pane.add(lblTitle, 0, 1);
                pane.setMargin(lblTitle, new Insets(10));
                TextField txtTitle = new TextField();
                pane.add(txtTitle, 1, 1);

                //Input movie's published year.
                Label lblYear = new Label("Year:  ");
                pane.add(lblYear, 0, 2);
                pane.setMargin(lblYear, new Insets(10));
                TextField txtYear = new TextField();
                pane.add(txtYear, 1, 2);

                //Input DVD movie's price.
                Label lblPrice = new Label("Price:  ");
                pane.add(lblPrice, 0, 3);
                pane.setMargin(lblPrice, new Insets(10));
                TextField txtDollars = new TextField();
                txtDollars.setPrefWidth(40);
                txtDollars.setPromptText("Enter $ amount");
                pane.add(txtDollars, 1, 3);
                TextField txtCents = new TextField();
                txtCents.setPrefWidth(50);
                txtCents.setPromptText("Cents");
                pane.add(txtCents, 2, 3);

                //Select a genre.
                Label lblGenre = new Label("Genre:  ");
                pane.add(lblGenre, 0, 4);
                ComboBox cbGenre = new ComboBox();
                cbGenre.getItems().addAll("Action", "Cartoon", "Horror");
                cbGenre.setPromptText("Select");
                pane.add(cbGenre, 1, 4);
                pane.setMargin(lblGenre, new Insets(10));

                //Select a rate.
                Label lblRate = new Label("Rate:  ");
                pane.add(lblRate, 0, 5);
                ComboBox cbRate = new ComboBox();
                cbRate.setPromptText("Select");
                cbRate.getItems().addAll("PG", "PG13", "G", "R");
                pane.add(cbRate, 1, 5);
                pane.setMargin(lblRate, new Insets(10));

                button1.setOnAction(new EventHandler<ActionEvent>() {
                    /**
                     * This method will add movie with all of the information
                     * inputed by the user to the movie list and display it in
                     * the right pane, save the added movie to the file, and
                     * provide validation for invalid input.
                     *
                     * @param event This is the event will happen if the button
                     * is clicked.
                     */
                    @Override
                    public void handle(ActionEvent event) {
                        txtTitle.requestFocus();
                        boolean invalid = true;
                        //validate the input
                        try {
                            //case 1: empty text field(s).
                            if (txtTitle.getText().isEmpty() || txtYear.getText().isEmpty()
                                    || txtDollars.getText().isEmpty() || txtCents.getText().isEmpty()
                                    || cbGenre.getValue() == null || cbRate.getValue() == null) {
                                invalid = false;
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("Empty field");
                                alert.setHeaderText("One or more required field is not answered!");
                                alert.setContentText("Please enter every required field.");
                                alert.showAndWait();
                            }
                            //case 2: duplicate movie.
                            for (int i = 0; i < mv.size(); i++) {
                                if (txtTitle.getText().equals(mv.getTitle(i))) {
                                    invalid = false;
                                    Alert alert = new Alert(AlertType.WARNING);
                                    alert.setTitle("Duplicate File");
                                    alert.setHeaderText("This movie already exists!");
                                    alert.setContentText("Please enter a different movie.");
                                    alert.showAndWait();
                                    txtTitle.clear();
                                    txtYear.clear();
                                    txtDollars.clear();
                                    txtCents.clear();
                                    cbGenre.setValue("Select");
                                    cbRate.setValue("Select");
                                    txtTitle.requestFocus();
                                }
                            }
                            try {
                                //case 3: out-of-range input.
                                int a = Integer.parseInt(txtYear.getText());
                                if (a < 1800 || a > 2018) {
                                    invalid = false;
                                    Alert alert = new Alert(AlertType.WARNING);
                                    alert.setTitle("Out of range!");
                                    alert.setHeaderText("Your input is out of range!");
                                    alert.setContentText("Please enter a year from 1800 to 2018.");
                                    alert.showAndWait();
                                    txtYear.clear();
                                    txtYear.requestFocus();
                                }
                            } catch (NumberFormatException ex) {
                                //case 4: not a number.
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Input Error");
                                alert.setHeaderText("You have entered an invalid input!");
                                alert.setContentText("Please enter a year from 1800 to 2018.");
                                alert.showAndWait();
                                txtYear.clear();
                                txtYear.requestFocus();
                            }
                            try {
                                //case 3: out-of-range input.
                                int b = Integer.parseInt(txtDollars.getText());
                                if (b < 0 || b > 10000000) {
                                    invalid = false;
                                    Alert alert = new Alert(AlertType.WARNING);
                                    alert.setTitle("Out of range!");
                                    alert.setHeaderText("Your input is out of range!");
                                    alert.setContentText("Please enter dollar from 0 to 10000000.");
                                    alert.showAndWait();
                                    txtDollars.clear();
                                    txtDollars.requestFocus();
                                }
                            } catch (NumberFormatException ex) {
                                //case 4: not a number.
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Input Error");
                                alert.setHeaderText("You have entered an invalid input!");
                                alert.setContentText("Please enter dollar from 0 to 10000000.");
                                alert.showAndWait();
                                txtDollars.clear();
                                txtDollars.requestFocus();
                            }
                            try {
                                //case 3: out-of-range input.
                                int c = Integer.parseInt(txtCents.getText());
                                if (c > 10000000) {
                                    invalid = false;
                                    Alert alert = new Alert(AlertType.WARNING);
                                    alert.setTitle("Out of range!");
                                    alert.setHeaderText("Your input is out of range!");
                                    alert.setContentText("Please enter cent lower than 10000000.");
                                    alert.showAndWait();
                                    txtDollars.clear();
                                    txtDollars.requestFocus();
                                }
                            } catch (NumberFormatException ex) {
                                //case 4: not a number.
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Input Error");
                                alert.setHeaderText("You have entered an invalid input!");
                                alert.setContentText("Please enter cent from 0 to 10000000.");
                                alert.showAndWait();
                                txtCents.clear();
                                txtCents.requestFocus();
                            }
                            //validation completed, proceed to add movie.
                            if (invalid = true) {
                                if (!txtYear.getText().equals("")
                                        && !txtDollars.getText().equals("")
                                        && !txtCents.getText().equals("")
                                        && !txtTitle.getText().equals("")
                                        && cbGenre.getValue() != null && cbRate.getValue() != null) {
                                    mv.addMovie(txtTitle.getText(), cbGenre.getValue().toString(),
                                            cbRate.getValue().toString(), Long.parseLong(txtDollars.getText()),
                                            Byte.parseByte(txtCents.getText()), Integer.parseInt(txtYear.getText()));
                                    addButton(mv.size() - 1);
                                    mv.saveFile();
                                    newWindow.close();
                                }
                            }
                        } catch (InvalidIndexException ex) {
                            Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                button2.setOnAction(new EventHandler<ActionEvent>() {
                    /**
                     * This method clears all of the text fields in the second
                     * window.
                     *
                     * @param arg0 This is the event which will happen if the
                     * button is clicked.
                     */
                    @Override
                    public void handle(ActionEvent arg0) {
                        txtTitle.clear();
                        txtYear.clear();
                        txtDollars.clear();
                        txtCents.clear();
                        cbGenre.getItems().clear();
                        cbRate.getItems().clear();
                    }

                });

                pane.setAlignment(Pos.CENTER);
                bottomLayout.getChildren().addAll(button1, button2, button3);
                HBox.setMargin(button1, new Insets(10));
                HBox.setMargin(button2, new Insets(10));
                HBox.setMargin(button3, new Insets(10));
                bottomLayout.setAlignment(Pos.BOTTOM_CENTER);
                newWindow.setTitle("Add Movie");
                newWindow.setScene(secondScene);
                // Set position of second window, related to primary window.
                newWindow.show();

            }
        });

        buttons[1].setText("Delete Movie");
        buttons[2].setText("Show graph");
        buttons[3].setText("Exit");

        buttons[2].setOnAction(new EventHandler<ActionEvent>() {
            /**
             * This method draws a pie chart to show the proportion of the
             * movies genres.
             *
             * @param event This is the event which will happen if button is
             * clicked.
             */
            @Override
            public void handle(ActionEvent event) {
                BorderPane rootPane1 = new BorderPane();
                //create new window.
                Scene thirdScene = new Scene(rootPane1, 400, 250);
                Stage newWindow2 = new Stage();
                newWindow2.setTitle("Graph");
                newWindow2.setScene(thirdScene);
                // Set position of third window, related to primary window.
                newWindow2.show();
                mv.showAction();
                mv.showCartoon();
                mv.showHorror();
                //creates the pie chart.
                ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                        new PieChart.Data("Action", mv.sizeAction()),
                        new PieChart.Data("Horror", mv.sizeHorror()),
                        new PieChart.Data("Cartoon", mv.sizeCart()));
                PieChart pieChart = new PieChart(pieChartData);
                pieChart.setData(pieChartData);
                pieChart.setTitle("Pie chart of Movie Genres");
                pieChart.setLegendSide(Side.BOTTOM);
                pieChart.setLabelsVisible(true);
                rootPane1.setCenter(pieChart);

                pieChart.setClockwise(false);
                try {
                    mv.clearAct();
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    mv.clearCart();
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    mv.clearHor();
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        //Exit the window.
        buttons[3].setOnAction(e -> {
            mv.saveFile();
            Platform.exit();
        });

        buttons[1].setOnAction(new EventHandler<ActionEvent>() {
            /**
             * This method shows a choice dialog which prompt the user to choose
             * a movie which they want to be deleted.
             *
             * @param event This is the event which will happen if the button is
             * clicked.
             */
            @Override
            public void handle(ActionEvent event) {
                //creates the choice dialog.
                ChoiceDialog<String> choice = new ChoiceDialog<>(mv.getTitle(0), mv.getTitles());
                choice.setTitle("Delete Movie");
                choice.setHeaderText("Are you sure you want to delete a movie?");
                choice.setContentText("Choose a movie:");
                Optional<String> result = choice.showAndWait();
                if (result.isPresent()) {
                    try {
                        mv.deleteMovie(result.get());
                        deleteButton();
                        textTitle.clear();
                        textGenre.clear();
                        textRate.clear();
                        textPrice.clear();
                        textYear.clear();
                        mv.saveFile();
                    } catch (InvalidIndexException ex) {
                        Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });

        bottomPane.setPadding(new Insets(30, 20, 30, 20));
        bottomPane.setStyle("-fx-background-color: #3CB371;");
        return bottomPane;
    }

    /**
     * This method creates a scroll pane to display the DVD movies list.
     *
     * @return right pane
     */
    public ScrollPane makeRightPane() {
        //creates the right pane
        movieList.setStyle("-fx-background-color: #FFFAFA;");
        rightPane.setStyle("-fx-background: #FFFAFA;");
        movieList.setHgap(10);
        movieList.setVgap(10);
        movieList.setAlignment(Pos.TOP_LEFT);

        movieList.setPadding(new Insets(20, 30, 20, 30));
        rightPane.setPadding(new Insets(20, 30, 20, 30));
        rightPane.setContent(movieList);
        rightPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        rightPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rightPane.setSnapToPixel(true);
        return rightPane;
    }

    /**
     * This method adds a new button to the right pane and set its action event
     * handler.
     *
     * @param index This is the position of movie info in the parallel arrays.
     * @throws InvalidIndexException
     */
    public void addButton(int index) throws InvalidIndexException {
        String title = mv.getTitle(index);
        int year = mv.getYear(index);
        Button button = new Button(title + "(" + year + ")");
        button.setId(String.valueOf(index));
        button.setMaxWidth(Double.MAX_VALUE);
        movieList.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * This method set the button action event handler to display info
             * in the text fields.
             *
             * @param event This is the event which will happen if the button is
             * clicked.
             */
            @Override
            public void handle(ActionEvent event) {
                try {
                    textTitle.setText(mv.getTitle(index));
                    textGenre.setText(mv.getGenre(index));
                    textRate.setText(mv.getRate(index));
                    textYear.setText(mv.yearToString(index));
                    textPrice.setText(mv.getPrice(index));
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    /**
     * This method rebuilds a right pane whenever a button was deleted, or
     * added.
     *
     * @throws InvalidIndexException
     */
    public void deleteButton() throws InvalidIndexException {
        int i;
        movieList.getChildren().clear();
        for (i = 0; i < mv.size(); i++) {
            addButton(i);
        }
    }

    /**
     * This method adds a new button which has the genre action only to the
     * right pane and set its action event handler.
     *
     * @param index This is the position of movie info in the parallel arrays.
     * @throws InvalidIndexException
     */
    public void addButtonAct(int index) throws InvalidIndexException {
        String title = mv.getTitleAction(index);
        int year = mv.getYearAction(index);
        Button button = new Button(title + "(" + year + ")");
        button.setId(String.valueOf(index));
        button.setMaxWidth(Double.MAX_VALUE);
        movieList.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    textTitle.setText(mv.getTitleAction(index));
                    textGenre.setText("Action");
                    textRate.setText(mv.getRateAction(index));
                    textYear.setText(mv.yearToStringAction(index));
                    textPrice.setText(mv.getPriceAction(index));
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    /**
     * This method rebuilds a right pane whenever a button of action genre was
     * deleted, or added.
     *
     * @throws InvalidIndexException
     */
    public void deleteButtonAct() throws InvalidIndexException {
        int i;
        movieList.getChildren().clear();
        for (i = 0; i < mv.sizeAction(); i++) {
            addButtonAct(i);
        }
    }

    /**
     * This method adds a new button which has the genre horror only to the
     * right pane and set its action event handler.
     *
     * @param index This is the position of movie info in the parallel arrays.
     * @throws InvalidIndexException
     */
    public void addButtonHor(int index) throws InvalidIndexException {
        String title = mv.getTitleHorror(index);
        int year = mv.getYearHorror(index);
        Button button = new Button(title + "(" + year + ")");
        button.setId(String.valueOf(index));
        button.setMaxWidth(Double.MAX_VALUE);
        movieList.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    textTitle.setText(mv.getTitleHorror(index));
                    textGenre.setText("Horror");
                    textRate.setText(mv.getRateHorror(index));
                    textYear.setText(mv.yearToStringHorror(index));
                    textPrice.setText(mv.getPriceHorror(index));
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    /**
     * This method rebuilds a right pane whenever a button of horror genre was
     * deleted, or added.
     *
     * @throws InvalidIndexException
     */
    public void deleteButtonHor() throws InvalidIndexException {
        int i;
        movieList.getChildren().clear();
        for (i = 0; i < mv.sizeHorror(); i++) {
            addButtonHor(i);
        }
    }

    /**
     * This method adds a new button which has the genre cartoon only to the
     * right pane and set its action event handler.
     *
     * @param index This is the position of movie info in the parallel arrays.
     * @throws InvalidIndexException
     */
    public void addButtonCart(int index) throws InvalidIndexException {
        String title = mv.getTitleCart(index);
        int year = mv.getYearCart(index);
        Button button = new Button(title + "(" + year + ")");
        button.setId(String.valueOf(index));
        button.setMaxWidth(Double.MAX_VALUE);
        movieList.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    textTitle.setText(mv.getTitleCart(index));
                    textGenre.setText("Cartoon");
                    textRate.setText(mv.getRateCart(index));
                    textYear.setText(mv.yearToStringCart(index));
                    textPrice.setText(mv.getPriceCart(index));
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollectionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    /**
     * This method rebuilds a right pane whenever a button of cartoon genre was
     * deleted, or added.
     *
     * @throws InvalidIndexException
     */
    public void deleteButtonCart() throws InvalidIndexException {
        int i;
        movieList.getChildren().clear();
        for (i = 0; i < mv.sizeCart(); i++) {
            addButtonCart(i);
        }
    }
}
