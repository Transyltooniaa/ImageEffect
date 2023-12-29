package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class Rotation implements SingleValueDiscreteEffect {

    private int parameter;
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {

        if(parameter == 0)
            loggingService.addLog(fileName, "Rotation", "None");
        else if(parameter == 1)
            loggingService.addLog(fileName, "Rotation", "90");
        else if(parameter == 2)
            loggingService.addLog(fileName, "Rotation", "180");
        else if(parameter == 3)
            loggingService.addLog(fileName, "Rotation", "270");

        return com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface.applyRotation(image,parameter);
    }


    @Override
    public void setParameterValue(int parameterValue) throws IllegalParameterException {
        if(parameterValue < 0 || parameterValue >3)
            throw new IllegalParameterException("Illegal parameter for Rotation effect");

        this.parameter = parameterValue;
    }
}
