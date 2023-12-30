package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.ContrastInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class Contrast implements SingleValueParameterizableEffect{

  // Private member parameter for the effect
  private float parameter;

  // Setter and getter for the parameter
  float getParameter(){
    return parameter;
  }

  @Override
  public void setParameterValue(float parameterValue) throws IllegalParameterException{

        if (parameterValue < -1 || parameterValue > 2.5)
          throw new IllegalParameterException("Illegal parameter for Contrast effect");

        this.parameter = parameterValue;
  }

  @Override
  public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService)
  {
    loggingService.addLog(fileName, "Contrast",  Float.toString(parameter));
    return ContrastInterface.applyContrast(image,parameter);
  }

}
