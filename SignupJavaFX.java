import javafx.application.Application;
import javafx.geometry.*; 
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;  
import javafx.stage.Stage;
import javafx.event.*; 
import javafx.scene.text.*;


public class SignupJavaFX extends Application {

   private TextField first = new TextField(); 
   private TextField last = new TextField(); 
   private TextField email = new TextField(); 
   private TextField phone = new TextField(); 
   private TextField birthday = new TextField(); 
   private PasswordField password = new PasswordField();
   public Label error = new Label();  
   public Label title = new Label("Welcome! Please sign up for our form");
   
   @Override
   public void start(Stage primaryStage) {
   
 
      VBox labels = new VBox(); 
      GridPane pane = new GridPane();
      pane.setAlignment(Pos.CENTER);
      labels.setAlignment(Pos.CENTER);
      pane.setPadding(new Insets(10,5,5,5)); 
      labels.setPadding(new Insets(5,5,5,5)); 
      pane.setHgap(45.5);
      pane.setVgap(20.5); 
      
      
      title.setStyle("-fx-font-weight: bold; -fx-font-size:20;"); 
      error.setStyle("-fx-text-fill: red;"); 
      
      labels.getChildren().add(title);
      labels.getChildren().add(error);  
      
      pane.add(new Label("First Name: "), 0,0);
      pane.add(first, 1,0); 
      pane.add(new Label("Last Name: "), 0,1); 
      pane.add(last, 1,1); 
      pane.add(new Label("Email: "), 0,2); 
      pane.add(email, 1,2);  
      pane.add(new Label("Birthday: "), 0,3); 
      pane.add(birthday, 1,3); 
      pane.add(new Label("Phone Number: "), 0,4); 
      pane.add(phone, 1,4); 
      pane.add(new Label("Password: "), 0,5); 
      pane.add(password, 1,5); 
      
      Button btnSubmit = new Button("Submit"); 
      pane.add(btnSubmit,1,6); 
      GridPane.setHalignment(btnSubmit, HPos.RIGHT); 
            
      Scene scene = new Scene(new VBox(labels,pane), 450,525);  
      primaryStage.setTitle("Sign up form"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
      
      
      btnSubmit.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent e)
         {
            String fName = first.getText(); 
            String lName = last.getText(); 
            String userEmail = email.getText(); 
            String userPhone = phone.getText(); 
            String bday = birthday.getText(); 
            String pass = password.getText(); 
            
            error.setText(""); 
            
            checkPass(pass); 
            checkName(fName,lName); 
            checkPhone(userPhone);
            checkBday(bday); 
            checkEmail(userEmail); 
            
            if(error.getText() == "")
            {
               primaryStage.hide();
               resultsPage();
            }
            
         }    
      }); 

      
   }
   
  
   public void resultsPage() 
   {
      Stage resultsStage = new Stage(); 
      VBox results = new VBox(); 
      results.setAlignment(Pos.CENTER);
      results.setPadding(new Insets(10,5,5,5));
      
      Label display = new Label("Congrats! You finished the code for this lab!");
      display.setStyle("-fx-font-weight: bold; -fx-font-size:20; -fx-text-fill:blue;"); 
      results.getChildren().add(display);
      
      Scene scene = new Scene(results, 400,400);  
      resultsStage.setTitle("Results Page"); 
      resultsStage.setScene(scene);
      resultsStage.show(); 
   
   }
   
   public void checkPass (String pass)
   {
      
      if(pass.length() <8 || !pass.matches(".*[A-Z].*") || !pass.matches(".*[a-z].*") || !pass.matches(".*[0-9].*") )
        error.setText(error.getText()+ "\nPassword must contain one uppercase, one lowercase, one number \nand be at least 8 characters");  
   }
   
   public void checkName (String first, String last)
   {
      if(first.length() ==0)
         error.setText(error.getText()+ "\nFirst name required "); 
      else if(first.length()<2)
         error.setText(error.getText()+ "\nInput valid last name ");
      if(last.length()==0)
         error.setText(error.getText()+ "\nLast name required ");  
      else if(last.length()<2)
         error.setText(error.getText()+ "\nInput valid last name ");
   }
   
   public void checkPhone (String phone) 
   {
      if(!phone.matches("\\d{3}-\\d{3}-\\d{4}"))
         error.setText(error.getText()+ "\nPhone number must be in xxx-xxx-xxxx format ");   
      
      
   }
   
   public void checkBday (String bday) 
   {
       if(!bday.matches("\\d{2}\\/\\d{2}\\/\\d{4}"))
         error.setText(error.getText()+ "\nBirthdate must be in MM/DD/YYYY format "); 
      
      
   }
   
   public void checkEmail (String email) 
   {
      if(email.length() == 0) 
         error.setText(error.getText()+ "\nEmail is required");
      else if (!email.matches("[a-zA-Z0-9._-]{2,}@[a-zA-Z0-9-]{2,}.[a-zA-Z]{2,}")) 
         error.setText(error.getText()+ "\nPlease enter valid email address "); 
   }
 
 
   public static void main(String[] args) {
      Application.launch(args);
   }


}