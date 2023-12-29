package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.FlipInterface;

public class Flip implements DiscreteEffect {

    private int horizontalFlipValue;
    private int verticalFlipValue;


    @Override
    public void selectOptionValue(String optionName, int value) throws IllegalParameterException {

        switch (optionName) {
            case "horizontalFlip" -> horizontalFlipValue = value;
            case "verticalFlip" -> verticalFlipValue = value;
            default -> throw new IllegalParameterException("Illegal parameter for Flip effect");
        }
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {

        if(horizontalFlipValue == 1)
            loggingService.addLog(fileName, "Flip", "Horizontal");
        else if(verticalFlipValue == 1)
            loggingService.addLog(fileName, "Flip", "Vertical");
        else
            loggingService.addLog(fileName, "Flip", "None");

        return FlipInterface.applyFlip(image, horizontalFlipValue, verticalFlipValue);
    }
}
