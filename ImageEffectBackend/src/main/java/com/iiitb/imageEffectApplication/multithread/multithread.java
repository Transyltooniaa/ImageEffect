package com.iiitb.imageEffectApplication.multithread;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class multithread extends Thread{
    public LoggingService lx;
    public String fname , ename , opval;
    public multithread(LoggingService lx , String fname , String ename , String opval){
        this.lx = lx;
        this.fname = fname;
        this.ename = ename;
        this.opval = opval;
    }

    @Override public void run(){
        try{
            lx.addLog(fname, ename, opval);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
