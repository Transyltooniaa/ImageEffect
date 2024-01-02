package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class Invert implements SingleValueDiscreteEffect {

    // Private member parameter for the effect
    private int parameter;


    // Setter and getter for the parameter
    int getParameter(){
        return parameter;
    }

    // Set the parameter value for the effect
    @Override
    public void setParameterValue(int parameterValue) throws IllegalParameterException {

        // Check if the parameter is in the range 0 to 1 if yes then throw exception
        if(parameterValue < 0 || parameterValue > 1)
            throw new IllegalParameterException("Illegal parameter for Invert effect");

        // Set the parameter
        this.parameter = parameterValue;

    }


    // Apply the effect and return the image
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {

            // Add the log for the effect
            loggingService.addLog(fileName, "Invert", "None");

            // Apply the effect and return the image
            return com.iiitb.imageEffectApplication.libraryInterfaces.InvertInterface.applyInvert(image);
    }
}
