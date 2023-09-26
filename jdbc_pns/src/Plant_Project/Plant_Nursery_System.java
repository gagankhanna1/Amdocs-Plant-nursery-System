package Plant_Project;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

import com.amdocs.pnsdao.*;

import com.amdocs.pns.*;

import com.amdocs.pnsdb.*;

import com.amdocs.pns.Plant;
import com.amdocs.pns.exception.exception1;
import com.amdocs.pnsdao.PlantDao;

import com.amdocs.pnsdb.DatabaseConnection;





public class Plant_Nursery_System {

public static void main(String args[]) throws exception1 {

Connection conn = DatabaseConnection.getConnection();

String jdbcUrl = "jdbc:mysql://localhost:3306/plantdb";

       String username = "root";

       String password = "";

       String query1;

       String query2;

       ResultSet rs;

try {

        // Load the MySQL JDBC driver

Class.forName("oracle.jdbc.OracleDriver"); //registration

System.out.println("Inside try after class.forname");

conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger"); //connection



        // Check if the connection is successful

        if (conn != null) {

            System.out.println("Connected to the MySQL database!");

            // You can perform database operations here

        } else {

            System.out.println("Failed to connect to the database.");

        }

       

       

       

        Statement stmt = conn.createStatement();

        Scanner sc=new Scanner(System.in);

        int choice;

       

        do {

            System.out.println("---------------------------------");
        	System.out.println("Press 1 to add new plant");
        	System.out.println("---------------------------------");
        	System.out.println("Press 2 to update plant cost");
        	System.out.println("---------------------------------");
        	System.out.println("Press 3 to delete plant");
        	System.out.println("---------------------------------");
        	System.out.println("Press 4 to view all plants");
        	System.out.println("---------------------------------");
        	System.out.println("Press 5 to find plant by origin country name");
        	System.out.println("---------------------------------");
        	System.out.println("Press 6 to find outdoor plants which requires sunlight");
        	System.out.println("---------------------------------");
        	System.out.println("Press 7 to count plants by water supply frequency");
        	System.out.println("---------------------------------");
        	System.out.println("Press 8 to exit");
        	System.out.println("---------------------------------");
        	System.out.println("Please enter your choice");
        	System.out.println("\n");

        choice=sc.nextInt();

        switch(choice) {

        case 1:

        System.out.println("Enter all details");
        System.out.println("\n");

        System.out.print("Enter Plant ID: ");
        System.out.println("\n");
        

        int id = sc.nextInt();
        if(id<0 ) {
      	   throw new exception1("Negative id is not allowed ");
         }


        sc.nextLine(); // Consume the newline character
       

        System.out.print("Enter Plant Name: ");
        System.out.println("\n");

        String pname = sc.nextLine();



        System.out.print("Enter Origin Country Name: ");
        System.out.println("\n");

        String cname = sc.nextLine();



        System.out.print("Enter Sunlight Required (1 for true, 0 for false): ");
        System.out.println("\n");

        int sun = sc.nextInt();

        sc.nextLine(); // Consume the newline character



        System.out.print("Enter Water Supply Frequency: ");
        System.out.println("\n");

        String water = sc.nextLine();



        System.out.print("Enter Plant Type (indoor/outdoor): ");
        System.out.println("\n");

        String type = sc.nextLine();



        System.out.print("Enter Cost: ");
        System.out.println("\n");

        double cost = sc.nextDouble();

        sc.nextLine(); // Consume the newline character



        PlantDao p=new PlantDao(id,pname,type,cname,water,cost,sun);

        

        p.addPlant(p);

//         query2="insert into plant values('103','neem','india',1,'5','outdoor',100.78)";

//         stmt.executeUpdate(query2);

        break;

        case 2:

        System.out.println("Enter updated cost");
        System.out.println("\n");

        double ucost=sc.nextDouble();
        if(ucost<=0 ) {
     	   throw new exception1("Negative cost is not allowed ");
        }

        sc.nextLine();

        System.out.println("Enter plant id where updation needs to be done");
        System.out.println("\n");

    	   int plid=sc.nextInt();
      
        PlantDao p3=new PlantDao();

        boolean b= p3.updatePlantCost(plid, ucost);

//         query2 = "UPDATE plant SET cost=" + ucost + " WHERE plantId='" + plid + "'";

//         int rows=stmt.executeUpdate(query2);

        break;
       
        case 3:

        System.out.println("Enter the id of plant which has to be deleted");
        System.out.println("\n");

        int plid2=sc.nextInt();

        PlantDao p1=new PlantDao();

        p1.deletePlant(plid2);

//         query2="delete from plant where plantId='"+plid+"'";

//         stmt.executeUpdate(query2);

        break;

        case 4:

//         query1="select * from plant";

//         rs = stmt.executeQuery(query1);

//                    while (rs.next()) {

//                        // Retrieve by column name

//                        

//                        System.out.print("Name: " + rs.getString("plantName"));

//                        System.out.println(" Cost: " + rs.getDouble("cost"));

//                     }

        PlantDao p2=new PlantDao();

        List<Plant> arr=p2.showAllPlants();

        break;

        case 5:

        System.out.println("Enter origin country name");
        System.out.println("\n");

        sc.nextLine();

        String cntry=sc.nextLine();

        PlantDao p5=new PlantDao();

        List<Plant> arr2=p5.searchByOriginCountryName(cntry);

//         query1="select * from plant where originCountryName='"+cntry+"'";

//         rs = stmt.executeQuery(query1);

//                    while (rs.next()) {

//                        // Retrieve by column name

//                        

//                        System.out.print("Name: " + rs.getString("plantName"));

//                        System.out.println(" Cost: " + rs.getDouble("cost"));

//                     }

        break;

        case 6:

        PlantDao p4=new PlantDao();

        List<Plant> arr3=p4.searchOutdoorPlantsWithSunlight();

//         query1="select * from plant where plantType='outdoor' && sunlightRequired='1'";

//         rs = stmt.executeQuery(query1);

//                    while (rs.next()) {

//                        // Retrieve by column name

//                        

//                        System.out.print("Name: " + rs.getString("plantName"));

//                        System.out.println(" Cost: " + rs.getDouble("cost"));

//                     }

        break;

        case 7:

        PlantDao p6=new PlantDao();

        System.out.println("Enter whether search is to be daily, weekly or monthly ");
        System.out.println("\n");

        sc.nextLine();

        String water1=sc.nextLine();

        int ans=p6.countPlantsByWaterSupplyFrequency(water1);

        System.out.println("Total plants with your condition "+water1+" is "+ans);
        System.out.println("\n");

        break;

        case 8:

        System.out.println("Exiting from system");
        System.out.println("\n");

        break;

        default:

        System.out.println("Invalid choice");
        System.out.println("\n");

        break;

        }

        } while(choice!=8);

        // Close the connection when done

        conn.close();

    } catch (ClassNotFoundException | SQLException e) {

        e.printStackTrace();

    }

}



   

}