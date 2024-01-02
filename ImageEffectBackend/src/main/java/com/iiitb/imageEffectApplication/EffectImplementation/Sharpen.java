package com.iiitb.imageEffectApplication.EffectImplementation;


import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.SharpenInterface;

public class Sharpen implements SingleValueParameterizableEffect {

    // Private member parameter for the effect
    private float parameter;

    // Setter and getter for the parameter
    public float getParameter() {
        return parameter;
    }


     // Apply the effect and return the image
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Add the log for the effect
        loggingService.addLog(fileName, "Sharpen", Float.toString(parameter));

        // Apply the effect and return the image
        return SharpenInterface.applySharpen(image, parameter);
    }


    // Set the parameter value for the effect
    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {

        // Check if the parameter is in the range 0 to 1
        if (parameterValue < 0 || parameterValue > 1)
            // Throw exception if the parameter is not in the range
            throw new IllegalParameterException("Illegal parameter for Sharpen effect");

        // Set the parameter value
        this.parameter = parameterValue;
    }


}



