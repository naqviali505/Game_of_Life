package com.srccodes.example;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;
import java.io.FileReader;
public class WritetoFile {
		  static void Save(int [][] arr , int R , int C) {
			  try {
			      FileWriter myWriter = new FileWriter("Save.txt");
			     
			      for (int i = 0; i < R; i++)
			        {
			            for (int j = 0; j < C; j++)
			            {
			                if (arr[i][j] == 0)
			                	myWriter.write(".");
			                else
			                	myWriter.write("*");
			            }
			            myWriter.write("\n");
			            System.out.println();
			        }
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		  }
		  static int[][]  Load(int[][] arr , int R , int C) 
		  {
			  FileReader fr=null;
			  try {
				fr = new FileReader("Save.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  for (int i = 0; i < R; i++)
		        {
		            for (int j = 0; j < C; j++)
		            {
		                try {
							if (fr.read() == '.')
								arr[i][j]=0;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                try {
							if (fr.read() == '*')
								arr[i][j]=1;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		            System.out.println();
		        }
			  try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return arr;
		  }
	public static void main(String[] args) {
		int M=10;
		int N=10;
		 int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //DummyFile
	              { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	              { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
	          };
		 Save(grid,M,N);
		 int [][] grid2={ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //DummyFile
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	              { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		 };
		 Load(grid2,10,10);
		 for (int i = 0; i < M; i++)
	        {
	            for (int j = 0; j < N; j++)
	            {
	            	System.out.println(grid2[i][j]);
	            }
	            System.out.println("\n");
	        }
		 Save(grid2,M,N);
	}

}
