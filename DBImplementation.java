//package com.company;
import java.sql.*;
import java.util.Scanner;
import BL.*;
import java.awt.*;

public class DBImplementation implements DBInterface {

    String URL = "jdbc:mysql://localhost:3306/Conway";
	String username = "root";
	String password = "Ronaldo7$";
	private Board loadgameinfo;
	private Exception e;
    @Override
    public void delete_state(String Sname)
    {
        try
		{
			Connection connection = DriverManager.getConnection(URL, username, password);
			String Query = "delete from state where SName=?";

			PreparedStatement statement = connection.prepareStatement(Query);

			statement.setString(1, Sname);
			statement.executeQuery();
		}
		catch (Exception e)
		{
			this.e = e;
			this.e.printStackTrace();
		}
    }
	
    public Board getLoadgameinfo() {

		return loadgameinfo;
	}

	public void setLoadgameinfo(Board loadgameinfo) {
		this.loadgameinfo = loadgameinfo;
	}

	@Override
    public void savegameinfo(Board obj,String SName) 
    {
        try {
			Connection connection = DriverManager.getConnection(URL, username, password);
			String SQL1 = "INSERT INTO State(Sname) VALUES (?)";
			String SQL2 = "INSERT INTO Board(Sname, B_Row, B_Col) VALUES (?, ?, ?)";
			String SQL4 = "INSERT INTO cell(Sname, C_Row, C_Col) VALUES (?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(SQL1);
			statement.setString(1,SName);
			statement.executeQuery();
			
			statement = connection.prepareStatement(SQL2);
			statement.setString(1, SName);
		//	statement.setInt(2, obj.getBoard().getWidth());
			statement.setInt(3, obj.getHeight());
			statement.executeQuery();
			
			
		//	for (int i = 0; i < obj.getBoard().getWidth(); i++)
			{
			//	for (int j = 0; j < obj.getBoard().getHeight(); j++)
				{
				//	if (obj.getBoard().getCellAt(i, j).isAlive())
					{
						statement = connection.prepareStatement(SQL4);
						statement.setString(1, SName);
					//	statement.setInt(2, i);
					//	statement.setInt(3, j);
						statement.executeQuery();
					}
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}    
        
    }

    @Override
    public Board loadgameinfo(String Sname) 
	{
        
        Board obj = new Board(20, 75);
		try {
			Connection connection = DriverManager.getConnection(URL, username, password);
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("Select C_Row, C_Col from cell ");
			while (resultSet.next()!=false)
			{
			//	obj.getBoard().getCellAt(Integer.parseInt(resultSet.getString("C_Row")), Integer.parseInt(resultSet.getString("C_Col")));
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

    @Override
    public String viewstate() 
	{

        String str = " ";
		try {
			Connection connection = DriverManager.getConnection(URL, username, password);
			String Query="Select * from state";
			PreparedStatement statement = connection.prepareStatement(Query);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()!=false) {
				str+= resultSet.getString("Sname") + "\n";
			}
			try (Scanner myObj = new Scanner(System.in)){
				
				System.out.println("Do you wish to load any of the saved states(Y/N)?\n");
				String choice = myObj.nextLine();
				if(choice=="Y" || choice=="yes")
				{
					System.out.println("Enter state name\n");
					try (Scanner input = new Scanner(System.in)) 
					{
						String state=input.nextLine();
						setLoadgameinfo(loadgameinfo(state));
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}

				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}

	public static void main(String[] args) {
	}

};
