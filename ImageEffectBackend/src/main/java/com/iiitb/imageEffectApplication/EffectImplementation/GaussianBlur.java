package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.multithread.multithread;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.GaussianBlurInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;



public class GaussianBlur implements SingleValueParameterizableEffect {

    // Private member parameter for the effect
    private float parameter;

    // Setter and getter for the parameter

    public float getParameter() {
        return parameter;
    }


    // Set the parameter value for the effect
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {

        multithread m = new multithread(loggingService, fileName, "GaussianBlur", Float.toString(parameter));
        m.start();
        Pixel[][] temp =  GaussianBlurInterface.applyGaussianBlur(image,parameter);
        try{
            m.join();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return temp;
    }

    // Set the parameter value for the effect
    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        // Check if the parameter is in the range 0 to 255
        if (parameterValue < 0 || parameterValue > 255) {
            // Throw exception if the parameter is not in the range
            throw new IllegalParameterException("Illegal parameter for Brightness effect");
        }
        // Set the parameter
        this.parameter = parameterValue;

    }
}
