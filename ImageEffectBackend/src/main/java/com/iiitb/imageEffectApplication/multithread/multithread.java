package com.iiitb.imageEffectApplication.multithread;
import com.iiitb.imageEffectApplication.service.LoggingService;


// This class is used to create a thread for adding logs to the database
public class multithread extends Thread{
    public LoggingService lx;
    public String fname , ename , opval;

    // Constructor
    public multithread(LoggingService lx , String fname , String ename , String opval){

        this.lx = lx;
        this.fname = fname;
        this.ename = ename;
        this.opval = opval;
    }

    // This method is used to add logs to the database
    @Override public void run(){
        try{
            lx.addLog(fname, ename, opval);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
