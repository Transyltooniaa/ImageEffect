package com.iiitb.imageEffectApplication.EffectImplementation;


import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.SharpenInterface;

public class Sharpen implements SingleValueParameterizableEffect {

    private float parameter;

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {

        loggingService.addLog(fileName, "Sharpen", Float.toString(parameter));
        return SharpenInterface.applySharpen(image, parameter);
    }


    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if (parameterValue < 0 || parameterValue > 1)
            throw new IllegalParameterException("Illegal parameter for Sharpen effect");

        this.parameter = parameterValue;
    }


}



