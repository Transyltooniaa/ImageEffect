package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class HueSaturation implements ParameterizableEffect{

    private float Hueparameter;
    private float Saturationparameter;

    @Override
    public void setParameter(String paramName, float value ) throws IllegalParameterException {

        if(paramName.equals("hue") && (value < 0 || value > 100))
            throw new IllegalParameterException("Illegal parameter for HueSaturation effect");

        if(paramName.equals("saturation") && (value < 0 || value > 100))
            throw new IllegalParameterException("Illegal parameter for HueSaturation effect");

        if(paramName.equals("hue"))
            this.Hueparameter = value;

        else if(paramName.equals("saturation"))
            this.Saturationparameter = value;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        String hue = String.valueOf(Hueparameter);
        String saturation = String.valueOf(Saturationparameter);
        loggingService.addLog(fileName, "HueSaturation", "H:" + hue + " S:" + saturation);
        return com.iiitb.imageEffectApplication.libraryInterfaces.HueSaturationInterface.applyHueSaturation(image, Hueparameter, Saturationparameter);

    }
}
