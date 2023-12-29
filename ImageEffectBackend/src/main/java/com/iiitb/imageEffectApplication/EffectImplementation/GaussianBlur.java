package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.GaussianBlurInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;



public class GaussianBlur implements SingleValueParameterizableEffect {

    private float parameter;

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName, "GaussianBlur", Float.toString(parameter));
        return GaussianBlurInterface.applyGaussianBlur(image, parameter);
    }

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {

        if (parameterValue < 0 || parameterValue > 255) {
            throw new IllegalParameterException("Illegal parameter for Brightness effect");
        }

        this.parameter = parameterValue;

    }
}
