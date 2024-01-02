package com.iiitb.imageEffectApplication.EffectImplementation;


import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.GrayscaleInterface;


// GrayScale effect class
public class GrayScale implements SingleValueDiscreteEffect {

    // Private member parameter for the effect
    private int parameter;

    // Setter and getter for the parameter
    int getParameter(){
        return parameter;
    }

    // Set the parameter value for the effect
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {

        // Add the log for the effect
        loggingService.addLog(fileName, "GrayScale", "None");

        // Apply the effect and return the image
        return GrayscaleInterface.applyGrayscale(image);
    }

    // Set the parameter value for the effect
    @Override
    public void setParameterValue(int parameterValue) throws IllegalParameterException {

        // Check if the parameter is in the range 0 to 1 if yes then throw exception
        if(parameterValue < 0 || parameterValue >1)
            throw new IllegalParameterException("Illegal parameter for Sepia effect");

        // Set the parameter
        this.parameter = parameterValue;

    }
}
