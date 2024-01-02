package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.multithread.multithread;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.FlipInterface;

// Flip effect class
public class Flip implements DiscreteEffect {

    // Private member parameter for the effect
    private int horizontalFlipValue;
    private int verticalFlipValue;


    // Setter and getter for the parameter
    int getHorizontalFlipValue() {
        return horizontalFlipValue;
    }

    int getVerticalFlipValue() {
        return verticalFlipValue;
    }


    @Override
    // Set the parameter value for the effect
    public void selectOptionValue(String optionName, int value) throws IllegalParameterException {
        // Check if the parameter is in the range 0 to 1
        switch (optionName) {

            // Set the parameter
            case "horizontalFlip" -> horizontalFlipValue = value;
            case "verticalFlip" -> verticalFlipValue = value;

            // Throw exception if the parameter is not in the range
            default -> throw new IllegalParameterException("Illegal parameter for Flip effect");
        }
    }

    // Apply the effect
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {


        // Add the log for the effect
        if (horizontalFlipValue == 1) {
            multithread m = new multithread(loggingService, fileName, "Flip", "Horizontal");
            m.start();
            Pixel[][] temp = FlipInterface.applyFlip(image, horizontalFlipValue, verticalFlipValue);
            try {
                m.join();
            } catch (Exception e) {
                System.out.println(e);
            }
            return temp;
        } else if (verticalFlipValue == 1) {
            multithread m = new multithread(loggingService, fileName, "Flip", "Vertical");
            m.start();
            Pixel[][] temp = FlipInterface.applyFlip(image, horizontalFlipValue, verticalFlipValue);
            try {
                m.join();
            } catch (Exception e) {
                System.out.println(e);
            }
            return temp;
        } else {
            multithread m = new multithread(loggingService, fileName, "Flip", "None");
            m.start();
            Pixel[][] temp = FlipInterface.applyFlip(image, horizontalFlipValue, verticalFlipValue);
            try {
                m.join();
            } catch (Exception e) {
                System.out.println(e);
            }
            return temp;
        }

    }
}
