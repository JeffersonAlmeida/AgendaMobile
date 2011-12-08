/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;

/**
 *
 * @author Jefferson
 */
public class SplitString {
    
    private static SplitString splitString;
    
    private SplitString(){
        super();
    }
    
    public static synchronized SplitString getInstance(){
        if(splitString==null){
            splitString = new SplitString();
        }
        return splitString;
    }
    
    // metodo em para quebrar a string e retornar um vetor de strings
     public static String[] split(String original, String separa) {
            
                Vector nodes = new Vector();
                String separator = separa;
                // Parse nodes into vector
                int index = original.indexOf(separator);
                while(index>=0){
                        nodes.addElement( original.substring(0, index) );
                        original = original.substring(index+separator.length());
                        index = original.indexOf(separator);
                }
                // Get the last node
                nodes.addElement( original );
                // Create splitted string array
                String[] result = new String[ nodes.size() ];
                if( nodes.size()>0 ) {
                        for(int loop=0; loop<nodes.size(); loop++){
                            result[loop] = (String)nodes.elementAt(loop);
                        }
                }
                return result;     
        }
}
