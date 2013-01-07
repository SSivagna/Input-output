package com.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.almanacka.planning.InputPlanning;
import com.almanacka.planning.OutputLesson;
import com.almanacka.planning.OutputPlanning;

public class InsertOutputLessonInDB
{
	static public void InsertOutputLesson(Connection connection, InputPlanning input, int p) throws SQLException
	{
		OutputPlanning a = OutputLesson.createOutputPlanning(input, p);
		for(int i = 0; i < a.getLessons().size(); i++ )
		{
			String sql = "INSERT INTO almanacka.lessonfortest (lessonId, idPlace, begDate, block, endDate, idIntensity , idPersonMonitor) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			try
			{
				OutputLesson lesson = a.getLessons().get(i);
			
	     		java.sql.Date sqlBegDate = new Date(lesson.getBegDate().getTime());
				java.sql.Date sqlEndDate = new Date(lesson.getEndDate().getTime());
				
			    preparedStatement.setInt(1,Integer.parseInt(lesson.getLessonId()));
				preparedStatement.setInt(2, Integer.parseInt(lesson.getPlaceWrapId()));
				preparedStatement.setDate(3, sqlBegDate );
				preparedStatement.setBoolean(4, false);
				preparedStatement.setDate(5, sqlEndDate);
				
				// créer les mêmes variables pour idIntensity et idpersonMonitor CREER HOY
				preparedStatement.setInt(6, Integer.parseInt(lesson.getMonitorId()));
				preparedStatement.setInt(7, Integer.parseInt(lesson.getIntensityId()));
				
				System.out.println(preparedStatement.toString());
				System.out.println("sqlBegDate : " + sqlBegDate);
				System.out.println("sqlEndDate : " + sqlEndDate);
				
				int rSet = preparedStatement.executeUpdate();
				System.out.println("Valeur du int rSet :" + rSet);	
				System.out.println("   ");
			}
			catch (Exception e)
			{
				System.out.println("Erreur lors de l'insertion de l'OuputLesson dans la base de données !!! ");
			}
			finally
			{
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
			}
		}
	}
}