package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.BrightnessInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class Brightness implements SingleValueParameterizableEffect
{

    // Private member parameter for the effect
    private float parameter;

    // Setter and getter for the parameter
    public float getParameter() {
        return parameter;
    }

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException{

        if (parameterValue < -255 || parameterValue > 255) {
            throw new IllegalParameterException("Illegal parameter for Brightness effect");
        }

        this.parameter = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService)
    {
        loggingService.addLog(fileName, "Brightness",  Float.toString(parameter));
        return BrightnessInterface.applyBrightness(image, parameter);
    }
}
