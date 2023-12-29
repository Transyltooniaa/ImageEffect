package com.iiitb.imageEffectApplication.EffectImplementation;


import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.GrayscaleInterface;


public class GrayScale implements SingleValueDiscreteEffect {

    private int parameter;
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName, "GrayScale", "None");
        return GrayscaleInterface.applyGrayscale(image);
    }

    @Override
    public void setParameterValue(int parameterValue) throws IllegalParameterException {
        if(parameterValue < 0 || parameterValue >1)
            throw new IllegalParameterException("Illegal parameter for Sepia effect");

        this.parameter = parameterValue;

    }
}
