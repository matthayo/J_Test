@Override 
   public void start(Stage stage) { 
      //Drawing a Circle 
      Circle circle = new Circle(); 
      
      //Setting the properties of the circle 
      circle.setCenterX(300.0f); 
      circle.setCenterY(180.0f); 
      circle.setRadius(90.0f);  
      
      //Drawing a text 
      Text text = new Text("This is a colored circle"); 
      
      //Setting the font of the text 
      text.setFont(Font.font("Edwardian Script ITC", 50)); 
      
      //Setting the position of the text 
      text.setX(155); 
      text.setY(50);  
      
      //Setting the radial gradient 
      Stop[] stops = new Stop[] { 
         new Stop(0.0, Color.WHITE),  
         new Stop(0.3, Color.RED), 
         new Stop(1.0, Color.DARKRED) 
      };        
      RadialGradient radialGradient = 
         new RadialGradient(0, 0, 300, 178, 60, false, CycleMethod.NO_CYCLE, stops);  
      
      //Setting the radial gradient to the circle and text 
      circle.setFill(radialGradient); 
      text.setFill(radialGradient);  
      
      //Creating a Group object  
      Group root = new Group(circle, text);  
      
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300); 
      
      //Setting title to the Stage 
      stage.setTitle("Radial Gradient Example");  
      
      //Adding scene to the stage 
      stage.setScene(scene);  
      
      //Displaying the contents of the stage 
      stage.show(); 