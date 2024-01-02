package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;


// Contrast effect class
public class HueSaturation implements ParameterizableEffect{

    // Private member parameter for the effect
    private float Hueparameter;
    private float Saturationparameter;

    // Setter and getter for the parameter

    public float getHueParameter() {
        return Hueparameter;
    }

    public float getSaturationParameter() {
        return Saturationparameter;
    }


    @Override
    public void setParameter(String paramName, float value ) throws IllegalParameterException {


        // Check if the parameter is in the range 0 to 1
        if(paramName.equals("hue") && (value < 0 || value > 1))
            throw new IllegalParameterException("Illegal parameter for HueSaturation effect");
        
        
        // Check if the parameter is in the range 0 to 1
        if(paramName.equals("saturation") && (value < 0 || value > 1))
            throw new IllegalParameterException("Illegal parameter for HueSaturation effect");

        // Set the parameter
        if(paramName.equals("hue"))
            this.Hueparameter = value;

        // Set the parameter
        if(paramName.equals("saturation"))
            this.Saturationparameter = value;
    }


    // Apply the effect and return the image
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {

        // Add the log for the effect
        String hue = String.valueOf(Hueparameter);
        String saturation = String.valueOf(Saturationparameter);
        loggingService.addLog(fileName, "HueSaturation", "Hue: " + hue + " Saturation: " + saturation);

        //  Apply the effect and return the image
        return com.iiitb.imageEffectApplication.libraryInterfaces.HueSaturationInterface.applyHueSaturation(image, Hueparameter, Saturationparameter);

    }
}
