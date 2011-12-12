/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import javax.microedition.rms.RecordComparator;


public class OrdenaRms implements RecordComparator {  
     
   private byte[] record                  = null;    
   private ByteArrayInputStream strmBytes = null;   
   private DataInputStream strmDataType   = null;  
      
   public OrdenaRms() { }  
     
   public void compareClose(){  
          try{  
             if (strmBytes != null)  
                strmBytes.close();  
             if (strmDataType != null)  
                strmDataType.close();  
          }catch (Exception e){}  
   }   
     
   public int compare(byte[] rec1, byte[] rec2){  
          String valor1 = null, valor2 = null;  
          try{        
             int maxsize = Math.max(rec1.length, rec2.length);  
             record = new byte[maxsize];        
             strmBytes = new ByteArrayInputStream(rec1);  
             strmDataType = new DataInputStream(strmBytes);        
             valor1 = strmDataType.readUTF();        
             strmBytes = new ByteArrayInputStream(rec2);  
             strmDataType = new DataInputStream(strmBytes);       
             valor2 = strmDataType.readUTF();        
             int resultado = valor1.compareTo(valor2);  
             if (resultado == 0)  
                return RecordComparator.EQUIVALENT;  
             else if (resultado < 0)  
                return RecordComparator.PRECEDES;  
             else  
                return RecordComparator.FOLLOWS;  
          }catch (Exception e){  
             return RecordComparator.EQUIVALENT;  
           }  
   }    
}  