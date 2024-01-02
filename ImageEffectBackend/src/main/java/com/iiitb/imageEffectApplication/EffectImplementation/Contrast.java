package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.multithread.multithread;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.ContrastInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

// Contrast effect class
public class Contrast implements SingleValueParameterizableEffect{

  // Private member parameter for the effect
  private float parameter;

  // Setter and getter for the parameter
  float getParameter(){
    return parameter;
  }

  @Override
  // Set the parameter value for the effect
  public void setParameterValue(float parameterValue) throws IllegalParameterException{

    // Check if the parameter is in the range 0.5 to 2.5
        if (parameterValue < 0.5 || parameterValue > 2.5)
          throw new IllegalParameterException("Illegal parameter for Contrast effect");

        this.parameter = parameterValue;
  }

  @Override

  // Apply the effect
  public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService)
  {


    multithread m = new multithread(loggingService, fileName, "Contrast", Float.toString(parameter));
    m.start();
    Pixel[][] temp =  ContrastInterface.applyContrast(image,parameter);
    try{
      m.join();
    }
    catch(Exception e){
      System.out.println(e);
    }
    return temp;
  }

}
