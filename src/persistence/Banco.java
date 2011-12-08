/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.microedition.rms.RecordStore;

/**
 *
 * @author Jefferson
 */
public class Banco {
    
    private static Banco banco; // design pattern sigleton.
    private RecordStore recordStore;
    static final String REC_STORE = "AGENDA";
    
    private Banco(){
       super();
    }
    
    //singleton lazy instatiation
    public synchronized static Banco getInstance() {  
        if (banco == null) {  
            banco = new Banco();
        }  
        return banco;  
    }  
    public RecordStore getRecordStore() {
        return recordStore;
    }

    public void setRecordStore(RecordStore recordStore) {
        this.recordStore = recordStore;
    }
    
     public RecordStore openRecStore(){
            try
            {
              // The second parameter indicates that the record store
              // should be created if it does not exist
              recordStore = RecordStore.openRecordStore(REC_STORE, true );
            }
            catch (Exception e)
            {
              db(e.toString());
            }finally{
                return recordStore;
            }
      }    
 
      public void closeRecStore(){
                try
                {
                  recordStore.closeRecordStore();
                }
                catch (Exception e)
                {
                  db(e.toString());
                }
       }
      
      public void deleteRecStore(){
            if (RecordStore.listRecordStores() != null)
            {
              try
              {
                RecordStore.deleteRecordStore(REC_STORE);
              }
              catch (Exception e)
              {
                db(e.toString());
              }
            }      
       }
      
       public void writeRecord(String str){
            byte[] rec = str.getBytes();
            try
            {
              recordStore.addRecord(rec, 0, rec.length);
            }
            catch (Exception e)
            {
              db(e.toString());
            }
      }
       
    public void readRecords() {
            try
             {
              // Intentionally make this too small to test code below
              byte[] recData = new byte[5]; 
              int len;

              for (int i = 1; i <= recordStore.getNumRecords(); i++)      
              {
                if (recordStore.getRecordSize(i) > recData.length)
                  recData = new byte[recordStore.getRecordSize(i)];

                len = recordStore.getRecord(i, recData, 0);
                System.out.println("Record #" + i + ": " + new String(recData, 0, len));
                System.out.println("------------------------------");                        
              }
            }
            catch (Exception e)
            {
              db(e.toString());
             }
      }
   
      private void db(String str){
        System.err.println("Msg: " + str);
      }
  
}
