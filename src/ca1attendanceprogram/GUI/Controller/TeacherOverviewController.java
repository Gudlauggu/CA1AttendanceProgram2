/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca1attendanceprogram.GUI.Controller;

import ca1attendanceprogram.BE.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mecaa
 */
public class TeacherOverviewController implements Initializable
{

    @FXML
    private TableView<Student> tblAllLessons;
    @FXML
    private TableColumn<Student, String> clmName;
    @FXML
    private TableColumn<Student, String> clmAbsence;
    @FXML
    private TableColumn<Student, String> clmAttending;
    @FXML
    private ComboBox<String> CBLesson;
    @FXML
    private Button btnLogOff;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        makeAStudent();
        updateFields();
        cbChoicer();
        addListener();

      }

    @FXML
    private void logOff(ActionEvent event)
      {
        Stage stage = (Stage) btnLogOff.getScene().getWindow();
        stage.close();
      }

    private void updateFields()
      {
        clmName.setCellValueFactory(
                new PropertyValueFactory("name"));
        clmAbsence.setCellValueFactory(
                new PropertyValueFactory("absencePercentage"));
        clmAttending.setCellValueFactory(
                new PropertyValueFactory("attendingTest"));
        
      }

    private void makeAStudent()
      {
        for (int i = 0; i < 13; i++)
          {
            tblAllLessons.getItems().add(new Student("stefaan" + i, "steven@gmail.com", 1 + i, "***", "Steven Nielssen"));
          }
      }
    
    
    public void addListener()
      {
        CBLesson.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
        {
            public void changed(ObservableValue ov, Number value, Number new_value)
              {
                CBLesson.getSelectionModel().select(new_value.intValue());
                tblAllLessons.getItems().clear();
                makeAStudent();
                updateFields();
                tblAllLessons.refresh();
              }

        });
      }
    
    
    
    private void cbChoicer()//Sets the items in the choicebox
      {
        ObservableList<String> groups = FXCollections.observableArrayList("SCO", "ITO", "SDE");
        CBLesson.setItems(groups);
      }
    
    

}
