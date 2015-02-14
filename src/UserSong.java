/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.*;

/**
 *
 * @author suryadev
 */

public class UserSong {
    
    
	  private static Hashtable UserClassCountA = new Hashtable();
	  private static Hashtable UserClassCountB = new Hashtable();
	  private static Hashtable UserClassCountC = new Hashtable();
	  private static Hashtable UserClassCountD = new Hashtable();
	  private static Hashtable UserClassCountE = new Hashtable();
	  

     public int getClassCountA(String user){
         
         int temp = (int) UserClassCountA.get(user);
         return temp;
     }
     
     public void putClassCountA(String user,int classcount){
    	 
    	  //System.out.println("hi success");
          UserClassCountA.put(user,(Integer)classcount);
          //System.out.println(UserClassCountA.get(user));
         
     }
     
     public int getClassCountB(String user){
         
        int temp = (int) UserClassCountB.get(user);
         return temp;
     }
     
     public void putClassCountB(String user,int classcount){
    	 
          UserClassCountB.put(user,(Integer)classcount);
         
     }
     
     public int getClassCountC(String user){
         
         int temp = (int) UserClassCountC.get(user);
         return temp;
     }
     
     public void putClassCountC(String user,int classcount){
    	 
          UserClassCountC.put(user,(Integer)classcount);
         
     }
     
     public int getClassCountD(String user){
         
         int temp = (int) UserClassCountD.get(user);
         return temp;
     }
     
     public void putClassCountD(String user,int classcount){
    	 
          UserClassCountD.put(user,(Integer)classcount);
         
     }
     
     
     public int getClassCountE(String user){
         
         int temp = (int) UserClassCountE.get(user);
         return temp;
     }
     
     public void putClassCountE(String user,int classcount){
    	 
          UserClassCountE.put(user,(Integer)classcount);
         
     }
     
     
}
