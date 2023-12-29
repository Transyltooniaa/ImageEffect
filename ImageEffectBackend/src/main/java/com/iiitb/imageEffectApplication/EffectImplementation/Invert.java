package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class Invert implements SingleValueDiscreteEffect {

    private int parameter;


    @Override
    public void setParameterValue(int parameterValue) throws IllegalParameterException {

        if(parameterValue < 0 || parameterValue > 1)
            throw new IllegalParameterException("Illegal parameter for Invert effect");

        this.parameter = parameterValue;

    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
            loggingService.addLog(fileName, "Invert", "None");
            return com.iiitb.imageEffectApplication.libraryInterfaces.InvertInterface.applyInvert(image);
    }
}
