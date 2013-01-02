package com.almanacka.planning;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
/*import java.sql.ResultSet;
import java.sql.Statement;*/
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.mysql.ConnectionToDB;
import com.mysql.CreatePlanning;
import com.mysql.DeconnectionToDB;
//import com.mysql.DeconnectionToDB;
//import com.mysql.jdbc.PreparedStatement;
import com.mysql.InsertOutputLessonInDB;

public class Main 
{
	/*
	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException
	{
		System.out.println("bonjour");
		System.out.println("");
		String alpha = "2012-05-01 18:00";
		String beta = "2012-05-20 19:00";
		
		Date date = new SimpleDateFormat("YYYY-MM-dd HH:mm", Locale.ENGLISH).parse(alpha);
		Date date2 = new SimpleDateFormat("YYYY-MM-dd HH:mm", Locale.ENGLISH).parse(beta);
		InputLesson test = new InputLesson("8", false, "0", date, date2);
		InputLesson test1 = new InputLesson("9", false, "1", date, date2);
		InputLesson test2 = new InputLesson("10", false, "2", date, date2);
		InputLesson test3 = new InputLesson("11", false, "3", date, date2);
//		test.toString();    ne fonctionne pas
		test.PrintInfos();
		test1.PrintInfos();
		test2.PrintInfos();
		test3.PrintInfos();
		
		System.out.println("");
		System.out.println("PARTIE INPUTPLANNING");
		System.out.println("");
		
		Connection a = ConnectionToDB.connect();

		if (a != null)
		{			
			System.out.println("avant appel CP");
			InputPlanning IP1 = CreatePlanning.createPlanning(a);
			//IP1.PrintInfos();
			//System.out.println(IP1.getLessons().size());
			System.out.println("après appel CP");

			System.out.println("");
			System.out.println("PARTIE OUTPUTPLANNING");
			System.out.println("");
			
			System.out.println("avant appel createoutputPlanning");
			//	OutputLesson OL = new OutputLesson(test);
			OutputLesson.createOutputPlanning(IP1, 0);
			System.out.println("après appel create output planning");
			
		/*	
			System.out.println("avant appel Optimize");
		//	OutputLesson OL = new OutputLesson(test);
		    InsertOutputLessonInDB.InsertOutputLesson(a, IP1, 5);
			
		    System.out.println("après appel Optimize");*/
			
			
			
			
			
			
			/*
			PreparedStatement preparedStatement = null;
			try
			{
				java.sql.Date sqlBegDate = new java.sql.Date(date.getTime());
				java.sql.Date sqlEndDate = new java.sql.Date(date2.getTime());
				
			    
				String sql = "INSERT INTO almanacka.lessonfortest (lessonId, block ,idPlace, begDate, endDate) VALUES (?, ?, ?, ?, ?)";
				preparedStatement = a.prepareStatement(sql);
				preparedStatement.setString(1, "8");
				preparedStatement.setBoolean(2, false);
				preparedStatement.setString(3, "0");
				preparedStatement.setDate(4, sqlBegDate);
				preparedStatement.setDate(5, sqlEndDate);
				int rSet =	preparedStatement.executeUpdate();
				System.out.println("Insertion réussie dans le main " + rSet);
			}
			catch (Exception e)
			{
				System.out.println("erreur lors de l'insertion ");
			}
			finally
			{
				if( preparedStatement != null)
				{
					//preparedStatement.close();
					DeconnectionToDB.disconnect(a);
				}
			}
		}
		else
		{
			System.out.println("Erreur lors de la connexion depuis le MAIN");
		}
	}*/
	
		
		public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException
		{
			System.out.println("bonjour");
			System.out.println("");
			String alpha = "2012-05-01 18:00";
			String beta = "2012-05-20 19:00";
			String gamma= "2012-12-23 14:30";
			
			Date date = new SimpleDateFormat("YYYY-MM-dd HH:mm", Locale.ENGLISH).parse(alpha);
			Date date2 = new SimpleDateFormat("YYYY-MM-dd HH:mm", Locale.ENGLISH).parse(beta);
			Date date3 = new SimpleDateFormat("YYYY-MM-dd HH:mm", Locale.ENGLISH).parse(gamma);
			
			InputLesson test = new InputLesson("8", false, "0", date, date2);
			InputLesson test1 = new InputLesson("9", false, "1", date, date2);
			InputLesson test2 = new InputLesson("10", false, "2", date, date3);
			InputLesson test3 = new InputLesson("11", false, "3", date, date3);
//			test.toString();    ne fonctionne pas
			
			System.out.println("----Les inputLessons--------");
			/*test.PrintInfos();
			test1.PrintInfos();
			test2.PrintInfos();
			test3.PrintInfos();
			System.out.println(test.toString());*/
			System.out.println("--FIN des inputLessons--------");
			System.out.println("  ");
			
			
			
			Connection a = ConnectionToDB.connect();

			if (a != null)
			{			
				
				System.out.println("PARTIE INPUTPLANNING");
				System.out.println("avant appel createInputPlanning");
				InputPlanning IP1 = CreatePlanning.createPlanning(a);
				//IP1.PrintInfos();
				//System.out.println(IP1.getLessons().size());
				System.out.println("après appel createInputPlanning");
				
				
				System.out.println("   ");
				
				
				System.out.println("PARTIE OUTPUTPLANNING");
				System.out.println("avant appel createOutputPlanning");
				//	OutputLesson OL = new OutputLesson(test);
				OutputLesson.createOutputPlanning(IP1, 0);
				// il faut que l'on ait des inputlesson ds ce IP1 dont monitorintensites et etc qui ne sont pas null!!!
				System.out.println("après appel createOutputplanning");
				
				
				/*System.out.println("avant appel insertOutputlesson");
				InsertOutputLessonInDB.InsertOutputLesson(a, IP1, 0);
				System.out.println("après appel insertOutputlesson");*/
				
			}
			
			
			
			
		}
}
