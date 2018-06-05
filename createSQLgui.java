//PHP/SQL GUI to easily create queries, statements,
//and web pages with a table or other db tables imported potentially.

import java.io.*;
import java.util.*;
import javafx.beans.*;
import java.util.Arrays;
import javafx.scene.control.*;
//import javafx.beans.*;


import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.lang.IllegalArgumentException;
 /*
	Interact with a database online
	   put together

	    //design your own tables! - manage pt/clients/etc.
		CREATE - add a table of people.7
		INSERT
		DROP
		UPDATE
		SELECT / display

		//hook up to db
		//find available db's -- create obj arrays out of them.

		-add, remove, modify, etc
		upload csv to become a table... rename? connect to db? create new db?

 */
public class createSQLgui{
/*
assuming from a csv/data table containing columns/rows.
*/
	LinkedList  <TextField> fieldList;
	LinkedList  <LinkedList<TextField>> fieldData;

	private 	int		COL; 	//determined by number of columns across
	private 	int 	ROW; 	//determined by number of rows down


	//Button 	clear;
	//Button 	submit;
    LinkedList <Button> del;

	LinkedList <HBox>  	recordBoxes; 	//rows of records - up to 300
	HBox  			   	fieldBoxes;		// columns of metadata, up to 40
	public VBox			container;		//the Vertical Box to house all headers/data.
	public AnchorPane 	layout;			//final layout pane for the stage.
	public HBox 		delBox;


	//data to potentially work with a database connection
	private 	String 	db;
	private 	String 	table;
	private 	String 	user;
	private		String 	pw;
//--------------------------------------------------------------------------//
		//function: createSQLgui() - default constructor for new calcGUI() objects.
//--------------------------------------------------------------------------//
	//default constructor no parameters.
	protected createSQLgui()
	{
		_default(); //initialize all elements to not-null states.
		initDBvars();

		//setListeners();
	}
//--------------------------------------------------------------------------//
		//function: _default() - no args, no return.
		//Initializes each element with an object/value. Fresh state/constructor.
//--------------------------------------------------------------------------//
	private void initDBvars(){
		db 		="";
		table	="";
		user	="";
		pw		="";

	}
    private void setListeners(){
		//clear.setOnAction (e ->{ Answer.setText("");  });

	}
	private void resetVals(){

	}
	private void setTextListeners(final int x){
		//num[x].setOnAction(e -> {  });
	}
//--------------------------------------------------------------------------//
		//function: _default() - no args, no return.
		//Initializes each element with an object/value. Fresh state/constructor.
//--------------------------------------------------------------------------//




 //---------------------------------------------------------------------------//

//---------------------------------------------------------------------------//
	private void _default(){
	COL =6;
	ROW =3; //start with 3 rows. 2 for records, 1 for table headers.

	init_Boxes();
  //field data is a linked list of individual textField linkedlists
	fieldData 		= new <LinkedList <TextField>> LinkedList();

	//create the 6 starting fieldList text boxes (empty).
	fieldList  	= new <TextField> 	LinkedList(Arrays.asList(new TextField("Labels"),new TextField(""),new TextField(""),new TextField(""),new TextField(""),new TextField("") ));
	del 		    = new <Button> 		  LinkedList(Arrays.asList(new Button("X")  ,new Button("X")  ,new Button("X")  ,new Button("X")  ,new Button("X")  ,new Button("X")   ));

	init_Fdata();
  setLayout();


	//set a title
	//ability to delete by row or column and shift up
	}
//---------------------------------------------------------------------------//

//---------------------------------------------------------------------------//
	public void init_Fdata(){

		for(int c=0; c < COL; c++){
			fieldData.add(new <TextField> LinkedList());
		for(int r=0; r < ROW; r++){

			//grab column's box, add the fieldData column's row to it.
			fieldData.get(c).add(new TextField());
			recordBoxes.get(r).getChildren().add(fieldData.get(c).getLast());
		}
		}
	}
//---------------------------------------------------------------------------//

//---------------------------------------------------------------------------//
  public void init_Boxes(){
    delBox 			  = new HBox ();
    fieldBoxes		= new HBox(5);
  	container 		= new VBox(5);
  	layout 			  = new AnchorPane();

  	recordBoxes   = new <HBox> LinkedList(Arrays.asList(new HBox(5),new HBox(5),new HBox(5)));
  }
//---------------------------------------------------------------------------//

//---------------------------------------------------------------------------//
public void setLayout(){
  //add the first six rows of linked list data for the field (one textfield for each columnn's field).
  for(int y=0; y<COL; y++){
    delBox.getChildren().add(del.get(y));
    fieldBoxes.getChildren().add(fieldList.get(y));
  }

  container.getChildren().addAll(delBox, fieldBoxes,recordBoxes.get(0),recordBoxes.get(1),recordBoxes.get(2));
	layout.getChildren().add(container);
}

//---------------------------------------------------------------------------//

//---------------------------------------------------------------------------//
	public void addCol(){

		fieldData.add(new LinkedList <TextField>(Arrays.asList(new TextField(""))));
    //if < the # of columns
		//..then fill it downwards!
		COL++;
	}
//---------------------------------------------------------------------------//

//---------------------------------------------------------------------------//
	public void addRow(){
    //add a recordBox to hold the new rows.
		recordBoxes.add(new HBox(5));

   //when adding a new row, add   onto each column's next textfield down (keeping associated data types together)
		for(int x=0; x<COL; x++){
			fieldData.get(x).add(new TextField(""));
			//get each HBox row, add the associated fieldData column, very last fieldData boxes.
		}

   //to the recordbox, find the HBox row, add fieldData for each column from the most recent textField added.
		for(int n=0; n<ROW; n++){
		for(int y=0; y<COL; y++){
			recordBoxes.get(n).getChildren().add(fieldData.get(y).getLast());
		}
		}
		ROW++;
	}
//---------------------------------------------------------------------------//

//---------------------------------------------------------------------------//
	//add row empty to list - loop that returns HBox to add.
	//remove row
	//add column
	//remove column


}//end class: createSQLgui
