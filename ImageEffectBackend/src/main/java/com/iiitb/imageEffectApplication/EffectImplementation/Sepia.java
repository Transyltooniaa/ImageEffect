package com.iiitb.imageEffectApplication.EffectImplementation;


import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.SepiaInterface;


public class Sepia implements SingleValueDiscreteEffect {

    private int parameter;
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName, "Sepia",  "Sepia");
        return SepiaInterface.applySepia(image);
    }

    @Override
    public void setParameterValue(int parameterValue) throws IllegalParameterException {
        if(parameterValue < 0 || parameterValue >1)
            throw new IllegalParameterException("Illegal parameter for Sepia effect");

        this.parameter = parameterValue;

    }
}
