/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ialsmadi
 */
class TestPath implements Runnable {
    File file;
    public TestPath(File file1) {
   file=file1;
  }
    @Override
				public void run() {
                                    System.out.println("TP1");
                                    int counter=0;
        int counter1=0;
                                   
             BufferedReader bufferedReader = null;
     int[][] edges =new int[1000][1000];
   
  //  String csvFile = "C:\\Users\\ialsmadi\\Desktop\\Desktop_August_10_2016\\Applications_Programming\\sf12010placedistance25miles.csv";
        BufferedReader br = null;
       
        String line = "";
        String cvsSplitBy = ",";
        String sCurrentLine="";
         System.out.println("TP2");
        try{
             System.out.println("TP30");
                                     bufferedReader = new BufferedReader(new FileReader(file));
                                     
                while ((sCurrentLine = bufferedReader.readLine()) != null) {
                    try{
			 System.out.println("TP3");
                        if(counter==0){
                    counter++;
                   continue;
               }
                }
                catch(Exception ex){
                         System.out.println("TP3" + ex.getMessage());
                        }
                 try{
                      System.out.println("TP4");
                System.out.println(" :" +Thread.currentThread().getName() + counter);
               System.out.println(sCurrentLine);        }
                 catch(Exception ex){
                     System.out.println("exx22...."+ ex.getMessage());
                 }
                 try{
                      System.out.println("TP5");
                String[] city = sCurrentLine.split(cvsSplitBy);
                int edge1= Integer.parseInt(city[1]);
                int edge2= Integer.parseInt(city[4]);
                long result = Math.round(Double.parseDouble(city[2]));
                 System.out.println("TP6");
                try{
                 WeightedEdge edge= new WeightedEdge(edge1,edge2,Double.parseDouble(city[2]));
                TestShortestThread4.edges2.add(edge);
                System.out.println("TP60");
                }
                catch(Exception ex){
                     System.out.println("TP66");
                }
                //edges[edge1][edge2]=Integer.parseInt(String.valueOf(result));
                 boolean exist=false;
                 try{
                     System.out.println("TP600");
                 if( TestShortestThread4.vertices2.size()==0){
                      TestShortestThread4.vertices2.add(city[1]);
                 }
                 System.out.println("TP06");
                 for(int m2 =0; m2<  TestShortestThread4.vertices2.size(); m2++ ){
                 if( TestShortestThread4.vertices2.contains(city[1])==false){
                  System.out.println("TP7");
                  TestShortestThread4.vertices2.add(city[1]);
                 }
               //   System.out.println("TP8");
                 }
                 }
                 catch(Exception ex){
                      System.out.println("TP666");
                 }
                 }
                 catch(Exception ex){
                     System.out.println("inside...."+ ex.getMessage());
                 }
                  }}
                catch(Exception ex){
                        System.out.println("run ex.." + ex.getMessage());
                        }
               
					// System.out.println(" :" +
					// Thread.currentThread().getName());
 System.out.println("TP9");
				}
}
