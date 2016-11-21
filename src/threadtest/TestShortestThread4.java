/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

/**
 *
 * @author ialsmadi
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;
import java.util.concurrent.TimeUnit;
//import junit.framework.TestCase;


public class TestShortestThread4 {

	static final String FILEPATH = "C:\\Users\\ialsmadi\\Desktop\\Desktop_August_10_2016\\Applications_Programming\\sf12010placedistance25miles.csv";
//	static String FILEPATH_WRITE = "C:\\Users\\ialsmadi\\Desktop\\Desktop_August_10_2016\\Applications_Programming";
	static volatile File fileToWrite;
	//static volatile RandomAccessFile file;
	static volatile String fileContentsIter;
	static volatile int position = 0;
 public static ArrayList<ArrayList<String>> vertices1= new ArrayList<ArrayList<String>>();
     
     public static  ArrayList<ArrayList<WeightedEdge>> edges1= new ArrayList<ArrayList<WeightedEdge>>();
      static ArrayList<String> vertices2;
      static ArrayList<WeightedEdge> edges2;
	public static void main(String[] args) throws IOException, InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();
                System.out.println("starting time..."+  currentTimeMillis);
                File file1=null;
                PrintWriter printWriter;
                Thread thread1=null;
                int counter=0;
                int counter1=0;
                String readLine=null;
		try {
                    file1=null;
                    printWriter=null;
                    file1 = new File ("out"+counter+counter1+".csv");
                 //   FILEPATH_WRITE=FILEPATH_WRITE+"\\out"+counter+".csv";
		//	fileToWrite = new PrintWriter(new File(FILEPATH_WRITE)); //for random write,independent of thread obstacles 
			RandomAccessFile file = new RandomAccessFile(FILEPATH, "r");//for random read,independent of thread obstacles 
			
                      //  while (true) {
                            while ((readLine = file.readLine()) != null) {
                                
                        if(counter>10000){
                            counter1++;
                            printWriter.close();
                              //        thread1.stop();
                            file1 = new File ("out"+counter+counter1+".csv");
                            counter=0;
                        }
                        
                        if(counter==0){
                            try{
                    int size = counter/10;
                   
                   Runnable printA = new TestPath(file1);
    //Runnable printB = new PrintChar('b', 100);
    //Runnable print100 = new PrintNum(100);

    // Create threads
    thread1 = new Thread(printA);
   

    // Start threads
    thread1.start();
   // thread2.start();
    //thread3.start();
                       // seriouslyReadProcessAndWriteAsynch1(file1);
                }
                catch(Exception ex){
                    
                }
                     //       counter=0;}
                     //   if(counter==0){
                       //     counter1++;
                            
             printWriter = new PrintWriter (file1);
             vertices2= new ArrayList<String>();
             vertices1.add(vertices2);
     edges2= new ArrayList<WeightedEdge>();
     edges1.add(edges2);
    // thread1.start();
                         //   FILEPATH_WRITE=FILEPATH_WRITE+"\\out"+counter+".csv";
			//fileToWrite = new PrintWriter(new File(FILEPATH_WRITE));
                        }
		//	String readLine = file.readLine();
                     //   if(readLine!=null && readLine.length()>5){
                        printWriter.println(readLine); //.writeUTF(readLine); 
                      //  }
                        //fileToWrite.writeBytes(System.getProperty("line.separator"));
                        counter++;
                       
                        }
                        
                        
		//}
                        
                } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName());
		long currentTimeMillis2 = System.currentTimeMillis();
                
                System.out.println("starting time..."+  currentTimeMillis2);
		double time_seconds = (currentTimeMillis2 - currentTimeMillis) / 1000.0;
		System.out.println("Total time required for reading the text in seconds " + time_seconds);

	}

        public static void readFromFile(String fileName) throws IOException {
    BufferedReader bufferedReader = null;
    try {
        String sCurrentLine;
        bufferedReader = new BufferedReader(new FileReader(fileName));
        while ((sCurrentLine = bufferedReader.readLine()) != null) {
          //  System.out.println(sCurrentLine);
        }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    } finally {
        bufferedReader.close();
    }
}
	/**
	 * @throws IOException
	 * Something  asynchronously serious
	 */
	public static void seriouslyReadProcessAndWriteAsynch(RandomAccessFile file) throws IOException {
             List<String> vertices1= new ArrayList<String>();
     int[][] edges =new int[1000][1000];
     List<WeightedEdge> edges1= new ArrayList<WeightedEdge>();
  //  String csvFile = "C:\\Users\\ialsmadi\\Desktop\\Desktop_August_10_2016\\Applications_Programming\\sf12010placedistance25miles.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try{
		ExecutorService executor = Executors.newFixedThreadPool(10);//pls see for explanation in comments section of the class
		int counter=0;
        int counter1=0;
        

         //   br = new BufferedReader(new FileReader(file.));
          //  int counter1=0;
           // while ((line = br.readLine()) != null) {
                System.out.println(line);
                while (true) {
			String readLine = file.readLine();
                        if(counter==0){
                    counter++;
                   continue;
               }
			if (readLine == null) {
				break;
			}
			Runnable genuineWorker = new Runnable() {
				@Override
				public void run() {
                                    try{
					// do hard processing here in this thread,i have consumed
					// some time and ignore some exception in write method.
				//	writeToFile(FILEPATH_WRITE, readLine);
                                        try{
                                        System.out.println(readLine);
                                        }
                catch(Exception ex){
                             System.out.println("ex6..."+ ex.getMessage());
                        }
              //  try{
               
              
              
                // use comma as separator
                String[] city = readLine.split(cvsSplitBy);
                int edge1= Integer.parseInt(city[1]);
                int edge2= Integer.parseInt(city[4]);
                long result = Math.round(Double.parseDouble(city[2]));
                WeightedEdge edge= new WeightedEdge(edge1,edge2,Double.parseDouble(city[2]));
                edges1.add(edge);
                //edges[edge1][edge2]=Integer.parseInt(String.valueOf(result));
                 boolean exist=false;
                 if(vertices1.size()==0){
                     vertices1.add(city[1]);
                 }
                 for(int m2 =0; m2< vertices1.size(); m2++ ){
                 if(vertices1.contains(city[1])==false){
                     
                 vertices1.add(city[1]);
                 }
                 }
					// System.out.println(" :" +
					// Thread.currentThread().getName());
                   }
                                catch(Exception ex){
                             System.out.println("ex2..."+ ex.getMessage());
                        }
				}
                                
			};
                                
			
                                try{
                                executor.execute(genuineWorker);
                                }
                catch(Exception ex){
                             System.out.println("ex4..."+ ex.getMessage());
                        }
		}
                try{
		executor.shutdown();}
                catch(Exception ex){
                             System.out.println("ex3..."+ ex.getMessage());
                        }
		while (!executor.isTerminated()) {
		}
        }
        catch(Exception ex){
            System.out.println("ex1..."+ ex.getMessage());
        }
		System.out.println("Finished all threads");
		file.close();
		//fileToWrite.close();
                WeightedGraph<String> graph2 = 
      new WeightedGraph<>(vertices1, edges1);
    WeightedGraph<String>.ShortestPathTree tree1 = 
      graph2.getShortestPath(graph2.getIndex("01"));
    tree1.printAllPaths();

    // Display shortest paths from Houston to Chicago
    System.out.print("Shortest path from Houston to Chicago: ");
    java.util.List<String> path 
      = tree1.getPath(graph2.getIndex("06"));
    for (String s: path) {
      System.out.print(s + " ");
    }

    
    WeightedGraph<Integer> graph3 = new WeightedGraph<>(edges, 5);
    WeightedGraph<Integer>.ShortestPathTree tree2 = 
      graph3.getShortestPath(3);
    System.out.println("try....."+"\n");
    tree2.printAllPaths();
	}
public static void seriouslyReadProcessAndWriteAsynch1(File file) throws IOException {
              List<String> vertices1= new ArrayList<String>();
                List<WeightedEdge> edges1= new ArrayList<WeightedEdge>();
        //try{
		ExecutorService executor = Executors.newFixedThreadPool(10);//pls see for explanation in comments section of the class
		
        
           //   readFromFile(file);
         //   br = new BufferedReader(new FileReader(file.));
          //  int counter1=0;
           // while ((line = br.readLine()) != null) {
             //   System.out.println(line);
             //    String sCurrentLine;
                 
			
			Runnable genuineWorker = new Runnable() {
				@Override
				public void run() {
                                    int counter=0;
        int counter1=0;
                                   
             BufferedReader bufferedReader = null;
     int[][] edges =new int[1000][1000];
   
  //  String csvFile = "C:\\Users\\ialsmadi\\Desktop\\Desktop_August_10_2016\\Applications_Programming\\sf12010placedistance25miles.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String sCurrentLine="";
        try{
                                     bufferedReader = new BufferedReader(new FileReader(file));
                while ((sCurrentLine = bufferedReader.readLine()) != null) {
			
                        if(counter==0){
                    counter++;
                   continue;
               }
                        try{
                System.out.println(" :" +Thread.currentThread().getName());
               System.out.println(sCurrentLine);         
                String[] city = sCurrentLine.split(cvsSplitBy);
                int edge1= Integer.parseInt(city[1]);
                int edge2= Integer.parseInt(city[4]);
                long result = Math.round(Double.parseDouble(city[2]));
                WeightedEdge edge= new WeightedEdge(edge1,edge2,Double.parseDouble(city[2]));
                edges1.add(edge);
                //edges[edge1][edge2]=Integer.parseInt(String.valueOf(result));
                 boolean exist=false;
                 if(vertices1.size()==0){
                     vertices1.add(city[1]);
                 }
                 for(int m2 =0; m2< vertices1.size(); m2++ ){
                 if(vertices1.contains(city[1])==false){
                     
                 vertices1.add(city[1]);
                 }
                 }
                        }
                        catch(Exception ex){
                        System.out.println("exxyy.."+ ex.getMessage());
                        }
                  }}
                catch(Exception ex){
                        System.out.println("exxxxx.."+ ex.getMessage());
                        }
               
					// System.out.println(" :" +
					// Thread.currentThread().getName());

				}
			};
			executor.execute(genuineWorker);
		
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished Pool/Thread..."+Thread.currentThread().getName());
		//file.close();
		//fileToWrite.close();
                WeightedGraph<String> graph2 = 
      new WeightedGraph<>(vertices1, edges1);
    WeightedGraph<String>.ShortestPathTree tree1 = 
      graph2.getShortestPath(graph2.getIndex("01"));
    tree1.printAllPaths();

    // Display shortest paths from Houston to Chicago
    System.out.print("Shortest path from Houston to Chicago: ");
    java.util.List<String> path 
      = tree1.getPath(graph2.getIndex("06"));
    for (String s: path) {
      System.out.print(s + " ");
    }

    /*
    WeightedGraph<Integer> graph3 = new WeightedGraph<>(edges, 5);
    WeightedGraph<Integer>.ShortestPathTree tree2 = 
      graph3.getShortestPath(3);
    System.out.println("\n");
    tree2.printAllPaths(); */
	}

	/**
	 * @param filePath
	 * @param data
	 * @param position
	 */
	private static void writeToFile(String filePath, String data) {
		try {
			// fileToWrite.seek(position);
			data = "\n" + data;
			if (!data.contains("Randomization")) {
				return;
			}
			System.out.println("Let us do something time consuming to make this thread busy"+(position++) + "   :" + data);
			System.out.println("Lets consume through this loop");
			int i=1000;
			while(i>0){
			
				i--;
			}
			//fileToWrite.write(data.getBytes());
			throw new Exception();
		} catch (Exception exception) {
			System.out.println("exception was thrown but still we are able to proceeed further"
					+ " \n This can be used for marking failure of the records");
			//exception.printStackTrace();

		}

	}
}

