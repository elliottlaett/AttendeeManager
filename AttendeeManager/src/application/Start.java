package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;
import javafx.stage.FileChooser;
import static javafx.application.Application.launch;

public class Start extends Application {

	private final CheckComboBox gradeComboBoxPrio1 = new CheckComboBox();

	private final CheckComboBox gradeComboBoxPrio2 = new CheckComboBox();

	private final CheckComboBox gradeComboBoxPrio3 = new CheckComboBox();

	private final CheckComboBox programComboBoxPrio1 = new CheckComboBox();

	private static final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");

	private final ObjectProperty<TableRow<Attendee>> dragSource = new SimpleObjectProperty<>();

	private final TableView<Attendee> acceptedTable = new TableView<>();

	private final ObservableList<Attendee> data = FXCollections.observableArrayList();

	private final TableView<Attendee> reserveTable = new TableView<>();
	private final ObservableList<Attendee> data2 = FXCollections.observableArrayList();

	private final TableView<Attendee> notAcceptedTable = new TableView<>();
	private final ObservableList<Attendee> data3 = FXCollections.observableArrayList();

	final HBox hb = new HBox();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("Table View Sample");
		stage.setWidth(1300);
		stage.setHeight(550);

		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		// set Stage boundaries to visible bounds of the main screen
		stage.setX(primaryScreenBounds.getMinX());
		stage.setY(primaryScreenBounds.getMinY());
		stage.setWidth(primaryScreenBounds.getWidth());
		stage.setHeight(primaryScreenBounds.getHeight());

		final Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));

		acceptedTable.setEditable(true);

		TableColumn dateCol = new TableColumn("Date");
		dateCol.setMinWidth(100);
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

		TableColumn nameCol = new TableColumn("Name");
		nameCol.setMinWidth(200);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn programCol = new TableColumn("Program");
		programCol.setMinWidth(200);
		programCol.setCellValueFactory(new PropertyValueFactory<>("program"));

		TableColumn gradeCol = new TableColumn("Grade");
		gradeCol.setMinWidth(20);
		gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));

		TableColumn alergiesCol = new TableColumn("Alergies");
		alergiesCol.setMinWidth(200);
		alergiesCol.setCellValueFactory(new PropertyValueFactory<>("alergies"));

		TableColumn emailCol = new TableColumn("Email");
		emailCol.setMinWidth(200);
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

		TableColumn phoneNumCol = new TableColumn("PhoneNum");
		phoneNumCol.setMinWidth(200);
		phoneNumCol.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));

		TableColumn motivationCol = new TableColumn("Motivation");
		motivationCol.setMinWidth(200);
		motivationCol.setCellValueFactory(new PropertyValueFactory<>("motivation"));

		TableColumn participatedCol = new TableColumn("Member");
		participatedCol.setMinWidth(20);
		participatedCol.setCellValueFactory(new PropertyValueFactory<>("member"));

		acceptedTable.getColumns().addAll(dateCol, nameCol, programCol, gradeCol, alergiesCol, emailCol, phoneNumCol,
				motivationCol, participatedCol);

		reserveTable.setEditable(true);

		TableColumn dateCol2 = new TableColumn("Date");
		dateCol2.setMinWidth(100);
		dateCol2.setCellValueFactory(new PropertyValueFactory<>("date"));

		TableColumn nameCol2 = new TableColumn("Name");
		nameCol2.setMinWidth(200);
		nameCol2.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn programCol2 = new TableColumn("Program");
		programCol2.setMinWidth(200);
		programCol2.setCellValueFactory(new PropertyValueFactory<>("program"));

		TableColumn gradeCol2 = new TableColumn("Grade");
		gradeCol2.setMinWidth(20);
		gradeCol2.setCellValueFactory(new PropertyValueFactory<>("grade"));

		TableColumn alergiesCol2 = new TableColumn("Alergies");
		alergiesCol2.setMinWidth(200);
		alergiesCol2.setCellValueFactory(new PropertyValueFactory<>("alergies"));

		TableColumn emailCol2 = new TableColumn("Email");
		emailCol2.setMinWidth(200);
		emailCol2.setCellValueFactory(new PropertyValueFactory<>("email"));

		TableColumn phoneNumCol2 = new TableColumn("PhoneNum");
		phoneNumCol2.setMinWidth(200);
		phoneNumCol2.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));

		TableColumn motivationCol2 = new TableColumn("Motivation");
		motivationCol2.setMinWidth(200);
		motivationCol2.setCellValueFactory(new PropertyValueFactory<>("motivation"));

		TableColumn participatedCol2 = new TableColumn("Member");
		participatedCol2.setMinWidth(20);
		participatedCol2.setCellValueFactory(new PropertyValueFactory<>("member"));

		reserveTable.getColumns().addAll(dateCol2, nameCol2, programCol2, gradeCol2, alergiesCol2, emailCol2,
				phoneNumCol2, motivationCol2, participatedCol2);

		notAcceptedTable.setEditable(true);

		TableColumn dateCol3 = new TableColumn("Date");
		dateCol3.setMinWidth(100);
		dateCol3.setCellValueFactory(new PropertyValueFactory<>("date"));

		TableColumn nameCol3 = new TableColumn("Name");
		nameCol3.setMinWidth(200);
		nameCol3.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn programCol3 = new TableColumn("Program");
		programCol3.setMinWidth(200);
		programCol3.setCellValueFactory(new PropertyValueFactory<>("program"));

		TableColumn gradeCol3 = new TableColumn("Grade");
		gradeCol3.setMinWidth(20);
		gradeCol3.setCellValueFactory(new PropertyValueFactory<>("grade"));

		TableColumn alergiesCol3 = new TableColumn("Alergies");
		alergiesCol3.setMinWidth(200);
		alergiesCol3.setCellValueFactory(new PropertyValueFactory<>("alergies"));

		TableColumn emailCol3 = new TableColumn("Email");
		emailCol3.setMinWidth(200);
		emailCol3.setCellValueFactory(new PropertyValueFactory<>("email"));

		TableColumn phoneNumCol3 = new TableColumn("PhoneNum");
		phoneNumCol3.setMinWidth(200);
		phoneNumCol3.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));

		TableColumn motivationCol3 = new TableColumn("Motivation");
		motivationCol3.setMinWidth(200);
		motivationCol3.setCellValueFactory(new PropertyValueFactory<>("motivation"));

		TableColumn participatedCol3 = new TableColumn("Member");
		participatedCol3.setMinWidth(20);
		participatedCol3.setCellValueFactory(new PropertyValueFactory<>("member"));

		notAcceptedTable.getColumns().addAll(dateCol3, nameCol3, programCol3, gradeCol3, alergiesCol3, emailCol3,
				phoneNumCol3, motivationCol3, participatedCol3);

		Button addToTablesBtn = new Button("Add to tables");

		ObservableList<String> programs = FXCollections.observableArrayList("Don't", "work", "atm");

		ObservableList<Integer> options = FXCollections.observableArrayList(1, 2, 3, 4, 5);

		gradeComboBoxPrio1.getItems().addAll(options);
		gradeComboBoxPrio2.getItems().addAll(options);
		gradeComboBoxPrio3.getItems().addAll(options);
		programComboBoxPrio1.getItems().addAll(programs);

		ObservableList gradeComboBoxPrio1Values = listenToCheckComboBox(gradeComboBoxPrio1);
		ObservableList gradeComboBoxPrio2Values = listenToCheckComboBox(gradeComboBoxPrio2);
		ObservableList gradeComboBoxPrio3Values = listenToCheckComboBox(gradeComboBoxPrio3);
		ObservableList programComboBoxPrio1Values = listenToCheckComboBox(programComboBoxPrio1);

		Label choosedFileLabel = new Label("File choosed: ");

		VBox vBox = new VBox();
		vBox.setSpacing(10);

		HBox topHBox = new HBox();
		topHBox.setSpacing(5);

		Button chooseFileBtn = new Button("Click to select file...");

		topHBox.getChildren().addAll(addToTablesBtn, new Label("Prio 1 grade:"), gradeComboBoxPrio1,
				new Label("Prio 2 grade:"), gradeComboBoxPrio2, new Label("Prio 3 grade:"), gradeComboBoxPrio3,
				new Label("Prio 1 program:"), programComboBoxPrio1, chooseFileBtn, choosedFileLabel);

		VBox tablesBox = new VBox();

		tablesBox.setSpacing(5);
		tablesBox.setPadding(new Insets(0, 0, 0, 0));

		Label acceptedLabel = new Label("Accepted");
		Label reserveLabel = new Label("Reserve");
		Label notAcceptedLabel = new Label("Not accepted");

		Text acceptedMotivationLabel = new Text("Motivation: ");
		Text reserveMotivationLabel = new Text("Motivation: ");
		Text notAcceptedMotivationLabel = new Text("Motivation: ");

		VBox acceptedTableLabels = new VBox();
		acceptedTableLabels.getChildren().addAll(acceptedLabel, acceptedMotivationLabel);

		VBox reserveTableLabels = new VBox();
		reserveTableLabels.getChildren().addAll(reserveLabel, reserveMotivationLabel);

		VBox notAcceptedTableLabels = new VBox();
		notAcceptedTableLabels.getChildren().addAll(notAcceptedLabel, notAcceptedMotivationLabel);

		HBox hboxAcceptTableAndButton = new HBox();
		Button acceptPrintBtn = new Button("<- Press to print table to excel");
		Button acceptedExcelFileOpenBtn = new Button("<- Click to open file in excel");

		HBox hboxReserveTableAndButton = new HBox();
		Button reservePrintBtn = new Button("<- Press to print table to excel");
		Button reserveExcelFileOpenBtn = new Button("<- Click to open file in excel");

		HBox hboxNotAcceptedTableAndButton = new HBox();
		Button notAcceptPrintBtn = new Button("<- Press to print table to excel");
		Button NotAcceptedExcelFileOpenBtn = new Button("<- Click to open file in excel");

		addSpacingHBox(hboxAcceptTableAndButton);
		addSpacingHBox(hboxReserveTableAndButton);
		addSpacingHBox(hboxNotAcceptedTableAndButton);

		VBox acceptPrintBtnsVBox = new VBox();
		acceptPrintBtnsVBox.getChildren().addAll(acceptPrintBtn, acceptedExcelFileOpenBtn);
		acceptPrintBtnsVBox.setSpacing(10);

		VBox reservePrintBtnsVBox = new VBox();
		reservePrintBtnsVBox.getChildren().addAll(reservePrintBtn, reserveExcelFileOpenBtn);
		reservePrintBtnsVBox.setSpacing(10);

		VBox notAcceptedPrintBtnsVBox = new VBox();
		notAcceptedPrintBtnsVBox.getChildren().addAll(notAcceptPrintBtn, NotAcceptedExcelFileOpenBtn);
		notAcceptedPrintBtnsVBox.setSpacing(10);

		hboxAcceptTableAndButton.getChildren().addAll(acceptedTable, acceptPrintBtnsVBox);
		hboxReserveTableAndButton.getChildren().addAll(reserveTable, reservePrintBtnsVBox);
		hboxNotAcceptedTableAndButton.getChildren().addAll(notAcceptedTable, notAcceptedPrintBtnsVBox);

		/*
		 * acceptPrintBtn.setDisable(true); reservePrintBtn.setDisable(true);
		 * notAcceptPrintBtn.setDisable(true);
		 * 
		 * acceptedExcelFileOpenBtn.setDisable(true);
		 * reserveExcelFileOpenBtn.setDisable(true);
		 * NotAcceptedExcelFileOpenBtn.setDisable(true);
		 */
		tablesBox.getChildren().addAll(acceptedTableLabels, hboxAcceptTableAndButton, reserveTableLabels,
				hboxReserveTableAndButton, notAcceptedTableLabels, hboxNotAcceptedTableAndButton);

		dragItemsBetweenTables(acceptedTable, acceptedMotivationLabel);
		dragItemsBetweenTables(reserveTable, reserveMotivationLabel);
		dragItemsBetweenTables(notAcceptedTable, notAcceptedMotivationLabel);

		tableSettings(acceptedTable);
		tableSettings(reserveTable);
		tableSettings(notAcceptedTable);

		chooseFileBtn.setOnAction(event -> {

			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			File file = fileChooser.showOpenDialog(stage);
			if (file != null) {

				ExcelHandlerReadAndWrite.excelFilePath = file.getAbsolutePath();
				choosedFileLabel.setText("File choosed: " + file.getName());
			}
		});

		addToTablesBtn.setOnAction(event -> {

			if (ExcelHandlerReadAndWrite.excelFilePath != null) {
				acceptedTable.getItems().clear();
				reserveTable.getItems().clear();
				notAcceptedTable.getItems().clear();
				addaData(gradeComboBoxPrio1Values, gradeComboBoxPrio2Values, gradeComboBoxPrio3Values,
						programComboBoxPrio1Values);

			} else {
				Stage stage2 = new Stage();
				Scene scene2 = new Scene(new Group(), 200, 100);
				HBox hbox = new HBox();

				Label errorLabel = new Label("Choose file path!");

				hbox.getChildren().addAll(errorLabel);
				((Group) scene2.getRoot()).getChildren().addAll(hbox);

				stage2.setScene(scene2);

				stage2.show();

			}
		});

		printTableToExcel(acceptedTable, acceptPrintBtn, "Accepted list", acceptedExcelFileOpenBtn);
		printTableToExcel(reserveTable, reservePrintBtn, "Reserve list", reserveExcelFileOpenBtn);
		printTableToExcel(notAcceptedTable, notAcceptPrintBtn, "Not accepted list", NotAcceptedExcelFileOpenBtn);

		vBox.getChildren().addAll(topHBox, tablesBox);

		((Group) scene.getRoot()).getChildren().addAll(vBox);

		stage.setScene(scene);

		stage.show();
	}

	public void tableSettings(TableView table) {
		table.setManaged(true);
		table.setTableMenuButtonVisible(true);
		table.setMaxHeight(260);
	}

	public ObservableList listenToCheckComboBox(CheckComboBox checkComboBox) {
		checkComboBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<Integer>() {
			public void onChanged(ListChangeListener.Change<? extends Integer> c) {
			}
		});

		return checkComboBox.getCheckModel().getCheckedItems();
	}

	public void addaData(ObservableList gradeComboBoxPrio1Values, ObservableList gradeComboBoxPrio2Values,
			ObservableList gradeComboBoxPrio3Values, ObservableList programComboBoxPrio1Values) {

		for (Attendee attendee : ExcelHandlerReadAndWrite.readExcelFile()) {

			if (attendee.getGrade() != null) {

				for (Object grade : gradeComboBoxPrio1Values) {

					if ((int) grade == attendee.getGrade()) {

						acceptedTable.getItems()
								.addAll(new Attendee(attendee.getDate(), attendee.getName(), attendee.getProgram(),
										attendee.getGrade(), attendee.getAlergies(), attendee.getEmail(),
										attendee.getPhoneNum(), attendee.getMotivation(), attendee.getMember()));
					}

				}
				for (Object grade : gradeComboBoxPrio2Values) {

					if ((int) grade == attendee.getGrade()) {

						reserveTable.getItems()
								.add(new Attendee(attendee.getDate(), attendee.getName(), attendee.getProgram(),
										attendee.getGrade(), attendee.getAlergies(), attendee.getEmail(),
										attendee.getPhoneNum(), attendee.getMotivation(), attendee.getMember()));
					}

				}

				for (Object grade : gradeComboBoxPrio3Values) {
					if ((int) grade == attendee.getGrade()) {

						notAcceptedTable.getItems()
								.add(new Attendee(attendee.getDate(), attendee.getName(), attendee.getProgram(),
										attendee.getGrade(), attendee.getAlergies(), attendee.getEmail(),
										attendee.getPhoneNum(), attendee.getMotivation(), attendee.getMember()));
					}
				}
				for (Object program : programComboBoxPrio1Values) {
					if (program.equals(attendee.getProgram())) {
						acceptedTable.getItems()
								.add(new Attendee(attendee.getDate(), attendee.getName(), attendee.getProgram(),
										attendee.getGrade(), attendee.getAlergies(), attendee.getEmail(),
										attendee.getPhoneNum(), attendee.getMotivation(), attendee.getMember()));
					}
				}
			}
		}
	}

	public void dragItemsBetweenTables(TableView tView, Text text) {

		tView.setRowFactory(tv -> {

			acceptedTable.setMaxWidth(acceptedTable.getWidth());
			reserveTable.setMaxWidth(reserveTable.getWidth());
			notAcceptedTable.setMaxWidth(notAcceptedTable.getWidth());

			TableRow<Attendee> row = new TableRow<>();

			row.setOnDragDetected(event -> {

				if (!row.isEmpty()) {
					Integer index = row.getIndex();
					Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
					db.setDragView(row.snapshot(null, null));
					ClipboardContent cc = new ClipboardContent();
					cc.put(SERIALIZED_MIME_TYPE, index);
					db.setContent(cc);
					dragSource.set(row);
					event.consume();
				}
			});
			row.setOnDragOver(event -> {

				Dragboard db = event.getDragboard();
				if (db.hasContent(SERIALIZED_MIME_TYPE)) {

					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
					event.consume();
				}
			});

			row.hoverProperty().addListener((observable) -> {
				final Attendee attendee = row.getItem();

				if (row.isHover() && attendee != null) {

					row.setStyle("-fx-background-color: #CCCCCC;" + "    -fx-text-fill: white;");

					text.setText("Motivation: " + attendee.getMotivation());
				} else {
					row.setStyle(null);
					text.setText("Motivation: ");
				}
			});

			row.setOnDragDropped(event -> {

				Dragboard db = event.getDragboard();

				if (db.hasContent(SERIALIZED_MIME_TYPE) && dragSource.get() != null) {

					TableRow<Attendee> dragSourceRow = dragSource.get();

					row.getTableView().getItems().add(dragSourceRow.getItem());

					dragSource.set(null);

					event.setDropCompleted(true);

					event.consume();
				} else {
					event.setDropCompleted(false);
				}
			});

			row.setOnDragDone((DragEvent event) -> {

				if (event.getTransferMode() == TransferMode.MOVE) {

					row.getTableView().getItems().remove(row.getItem());

					if (row.getTableView().getItems().isEmpty()) {

					}

				}

				event.consume();
			});
			row.setOnDragExited((DragEvent event) -> {

				event.consume();
			});

			return row;
		});

	}

	private void addSpacingHBox(HBox hBox) {
		hBox.setSpacing(20);
	}

	private void printTableToExcel(TableView<Attendee> table, Button printBtn, String fileName,
			Button acceptedExcelFileOpenBtn) {

		printBtn.setOnAction(event -> {

			if (!table.getItems().isEmpty()) {

				ExcelHandlerReadAndWrite.fileName = fileName;
				File file = ExcelHandlerReadAndWrite.createNewExcelSheets(table.getItems());

				openFileInDesktop(file, acceptedExcelFileOpenBtn, printBtn);

			} else {
				Stage stage2 = new Stage();
				Scene scene2 = new Scene(new Group(), 200, 100);
				HBox hbox = new HBox();

				Label errorLabel = new Label("Nothing to print");

				hbox.getChildren().addAll(errorLabel);
				((Group) scene2.getRoot()).getChildren().addAll(hbox);

				stage2.setScene(scene2);

				stage2.show();
			}
		});
	}

	private void openFileInDesktop(File file, Button openExcelFileBtn, Button printBtn) {

		openExcelFileBtn.setOnAction(event -> {

			if (file.exists()) {
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException ex) {
					Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {

				Stage stage2 = new Stage();
				Scene scene2 = new Scene(new Group(), 200, 100);
				HBox hbox = new HBox();

				Label errorLabel = new Label("File don't exist");

				hbox.getChildren().addAll(errorLabel);
				((Group) scene2.getRoot()).getChildren().addAll(hbox);

				stage2.setScene(scene2);

				stage2.show();

			}

		});
	}
}
