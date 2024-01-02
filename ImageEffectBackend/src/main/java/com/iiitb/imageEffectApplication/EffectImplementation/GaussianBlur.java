package com.iiitb.imageEffectApplication.EffectImplementation;

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

        // Add the log for the effect
        loggingService.addLog(fileName, "GaussianBlur", Float.toString(parameter));

        // Apply the effect and return the image
        return GaussianBlurInterface.applyGaussianBlur(image, parameter);
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
