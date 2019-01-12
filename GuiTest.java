/**@author Isaac Angle
 * this class creates and runs the GUI that the city 
 * runs on. It allows for the user to move people around
 * and to check the description of names and places*/
package HW2.edu.whitworth.spokane;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import javax.swing.JLayeredPane;

public class GuiTest extends JFrame implements MouseMotionListener{
	//creating the teachers,kids,police,and buildings
	Teacher[] SchoolEmployees = {new Teacher("Darek", "209-888-9087",34,5,"Doctrite",100),
			new Teacher("John", "209-888-5555",25,2,"Masters",50)};
	
	Kid[] students = {new Kid("Jack","208-666-7777",8,"Butterfinger"),new Kid("susie","208-664-6689",8,"KitKat"),
			new Kid("Steve","208-004-6789",8,"KitKat"), new Kid("Isabelle","208-669-6689",8,"KitKat")};
	
	Police[] lawEnforcers = {new Police("John","208-900-9999",45,Role.CHIEF, 400),
			 new Police("Carter","208-900-0009",20,Role.SARGENT, 400)};
	
	Police dan = new Police("Dan", "208-999-2345", 34, Role.CAPTAIN, 50);
	
	Teacher Isabella = new Teacher("Isabella", "208-888-9000", 35, 6, "Doctrite", 70);
	
	Kid toby = new Kid("toby", "208-999-9900", 5, "Crunch");
	
	Building[] city = {new CityHall("City Hall", "2245 N West Str",lawEnforcers),
			new School("University Highschool", "4121 N University",SchoolEmployees,students)};
	
	private JFrame frame;
	private JLabel PoliceLabel;
	private JLabel TeacherLabel;
	private JLabel label;
	private JLabel schoolLabel;
	private JLabel cityHallLabel;
	private JLabel txtBox;
	int counter = 0,numCounter = 0;
	private JLabel label_1;
	private JLayeredPane layeredPane;
	private JLabel policeDes;
	private JLabel TeacherDes;
	private JLabel KidDes;
	private JLabel SchoolDes;
	private JLabel CityHallDes;

	/**
	 * 
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTest window = new GuiTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//sets up the icon for the school and the city hall
		// and also creates several labels to use
		try {
			//creating the school icon
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			URL imgurl = new URL("https://learnmoreeveryday.files.wordpress.com/2013/04/school-house.jpg"); //getClass().getResource("https://learnmoreeveryday.files.wordpress.com/2013/04/school-house.jpg");
			Image img = toolkit.getImage(imgurl);
			img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(img);
			
			//creating the layered pane used to make labels move in front of each other
			layeredPane = new JLayeredPane();
			layeredPane.setBackground(Color.BLACK);
			layeredPane.setBounds(0, 0, 434, 253);
			frame.getContentPane().add(layeredPane);
			
			//creates a teacher label that can move around the screen
			TeacherLabel = new JLabel("New label");
			TeacherLabel.setBounds(60, 208, 87, 14);
			layeredPane.add(TeacherLabel);
			TeacherLabel.setText("Teacher");
			
			//creates a new label for a kid and allows you to drag it around the screen
			label = new JLabel("New label");
			label.setBounds(184, 208, 47, 14);
			layeredPane.add(label);
			label.setText("Kid");
			
			//creates a new label for a kid and allows you to drag it around the screen
			PoliceLabel = new JLabel("New label");
			PoliceLabel.setBounds(252, 208, 57, 14);
			layeredPane.add(PoliceLabel);
			PoliceLabel.setText("Police");
			layeredPane.add(PoliceLabel,1);
			
			//creates a label to keep track of the number of police in city hall
			label_1 = new JLabel("Police in City Hall: 0");
			label_1.setBounds(263, 168, 141, 24);
			layeredPane.add(label_1);
			
			//creates a label to display the policeman's role
			policeDes = new JLabel("Role: " + dan.getRole().name());
			policeDes.setBounds(273, 203, 95, 24);
			layeredPane.add(policeDes);
			
			//creates a label to display the teachers grade level
			TeacherDes = new JLabel("grade level: " + SchoolEmployees[0].getGradeLevel());
			TeacherDes.setBounds(57, 208, 147, 14);
			layeredPane.add(TeacherDes);
			TeacherDes.setVisible(false);
			
			//creates a label to display the kid's favorite candy
			KidDes = new JLabel("fav candy: " + toby.getFavCandy());
			KidDes.setBounds(174, 184, 115, 14);
			layeredPane.add(KidDes);
			KidDes.setVisible(false);
			
			//creates a label that displays the address of the school
			SchoolDes = new JLabel("address: " + city[1].address);
			SchoolDes.setBounds(43, 11, 176, 14);
			layeredPane.add(SchoolDes);
			SchoolDes.setVisible(false);
			
			//creates a name that displays the address of city hall
			CityHallDes = new JLabel("address: " + city[0].address);
			CityHallDes.setBounds(263, 11, 161, 14);
			layeredPane.add(CityHallDes);
			CityHallDes.setVisible(false);
			policeDes.setVisible(false);
			
			//adds the school picture to the screen
			schoolLabel = new JLabel(icon);
			schoolLabel.setBounds(63, 30, 136, 125);
			frame.getContentPane().add(schoolLabel);
			
			//adds the city hall picture to the screen
			Toolkit toolkit2 = Toolkit.getDefaultToolkit();
			URL imgurl2 = new URL("http://worldartsme.com/images/town-hall-building-clipart-1.jpg");
			Image img2 = toolkit2.getImage(imgurl2);
			img2 = img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon icon2 = new ImageIcon(img2);
			
			//adds a label to keep track of the number of people in the school
			txtBox = new JLabel();
			txtBox.setSize(142, 29);
			frame.getContentPane().add(txtBox);
			txtBox.setVisible(true);
			txtBox.setText("People at the school: 0");
			txtBox.setLocation(73, 166);
			
			//adds the city hall label
			cityHallLabel = new JLabel(icon2);
			cityHallLabel.setBounds(258, 30, 150, 125);
			frame.getContentPane().add(cityHallLabel);
			cityHallLabel.setBackground(SystemColor.text);
			
			//allows the user to drag things around the screen
			layeredPane.addMouseMotionListener(this);
			
			
			
			
		}catch(Exception e){
			e.fillInStackTrace();
		}
		
		
		revalidate();
	}
	/**this function allows the labels to be dragged and checks
	 * to see if the labels for the number of people in a building
	 * should be updated
	 * @param MouseEvent e*/
	@Override
	public void mouseDragged(MouseEvent e) {
		//allows the user to drag the police label 
			if(PoliceLabel.getBounds().contains(e.getPoint())) {
				PoliceLabel.setLocation(e.getX() - PoliceLabel.getWidth()/2,e.getY() - PoliceLabel.getHeight()/2);
				repaint();
				revalidate();
			}
			//allows the user to drag the teacher label
			if(TeacherLabel.getBounds().contains(e.getPoint())) {
				TeacherLabel.setLocation(e.getX() - TeacherLabel.getWidth()/2,e.getY() - TeacherLabel.getHeight()/2);
				repaint();
				revalidate();
			}
			//allows the user to move the kid label
			if(label.getBounds().contains(e.getPoint())) {
				label.setLocation(e.getX() - label.getWidth()/2,e.getY() - label.getHeight()/2);
				repaint();
				revalidate();
			}
			
			//keeps the teacher out of city hall
			if(cityHallLabel.getBounds().contains(TeacherLabel.getLocation())) {
				TeacherLabel.setLocation(300, 200);
			//keeps the kid out of city hall
			}else if(cityHallLabel.getBounds().contains(label.getLocation())) {
				label.setLocation(300, 200);
			// sets the people in city hall to 1
			}else if(cityHallLabel.getBounds().contains(PoliceLabel.getLocation())) {
				label_1.setText("Police in City Hall: 1");
			//sets the people in city hall to 0
			} else {
				label_1.setText("Police in City Hall: 0");
			}
			
				//keeps police out of the school
				if(schoolLabel.getBounds().contains(PoliceLabel.getLocation())) {
					PoliceLabel.setLocation(300, 200);
				//updates the number of people in school to 2
				}else if(schoolLabel.getBounds().contains(label.getLocation()) && schoolLabel.getBounds().contains(TeacherLabel.getLocation())) {
					counter = 2;
					//updates the number of people in school to 1
				} else if(schoolLabel.getBounds().contains(label.getLocation())) {
					counter = 1;
					//updates the number of people in school to 1
				}else if(schoolLabel.getBounds().contains(TeacherLabel.getLocation())){
					counter = 1;
					//updates the number of people in school to 0
				} else {
					counter = 0;
				}
				
				//updates the number of people in the school
				switch(counter) {
				case 0:
					txtBox.setText("People at the school: 0");
					break;
				case 1:
					txtBox.setText("People at the school: 1");
					break;
				case 2:
					txtBox.setText("People at the school: 2");
					break;
			}
			
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//makes the police description appear
		if(PoliceLabel.getBounds().contains(e.getPoint())) {
			policeDes.setLocation(PoliceLabel.getLocation().x, PoliceLabel.getLocation().y + 10);
			policeDes.setVisible(true);
		} else {
			policeDes.setVisible(false);
		}
		//makes the teacher description appear
		if(TeacherLabel.getBounds().contains(e.getPoint())) {
			TeacherDes.setLocation(TeacherLabel.getLocation().x, TeacherLabel.getLocation().y + 10);
			TeacherDes.setVisible(true);
		}else {
			TeacherDes.setVisible(false);
		}
		//makes the kid description appear
		if(label.getBounds().contains(e.getPoint())) {
			KidDes.setLocation(label.getLocation().x, label.getLocation().y + 10);
			KidDes.setVisible(true);
		}else {
			KidDes.setVisible(false);
		}
		
		//makes the school description appear
		if(schoolLabel.getBounds().contains(e.getPoint())) {
			SchoolDes.setVisible(true);
		}else {
			SchoolDes.setVisible(false);
		}
		
		//makes the city hall description appear
		if(cityHallLabel.getBounds().contains(e.getPoint())) {
			CityHallDes.setVisible(true);
		}else {
			CityHallDes.setVisible(false);
		}
	}
}