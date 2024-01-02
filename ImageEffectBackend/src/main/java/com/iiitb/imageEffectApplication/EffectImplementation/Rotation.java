package com.iiitb.imageEffectApplication.EffectImplementation;

import com.iiitb.imageEffectApplication.multithread.multithread;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;


// Rotation effect class
public class Rotation implements SingleValueDiscreteEffect {

    // Private member parameter for the effect
    private int parameter;
    @Override

    // Set the parameter value for the effect
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {

        // Differentiate between the different values of the parameter
        if(parameter == 0)
        {
            multithread m = new multithread(loggingService, fileName, "Rotation", "0");
            m.start();
            Pixel[][] temp =  com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface.applyRotation(image,parameter);
            try{
                m.join();
            }
            catch(Exception e){
                System.out.println(e);
            }
            return temp;
        }

        else if(parameter == 1){
            multithread m = new multithread(loggingService, fileName, "Rotation", "90");
            m.start();
            Pixel[][] temp =  com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface.applyRotation(image,parameter);
            try{
                m.join();
            }
            catch(Exception e){
                System.out.println(e);
            }
            return temp;
        }

        else if(parameter == 2){
            multithread m = new multithread(loggingService, fileName, "Rotation", "180");
            m.start();
            Pixel[][] temp =  com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface.applyRotation(image,parameter);
            try{
                m.join();
            }
            catch(Exception e){
                System.out.println(e);
            }
            return temp;
        }


        else if(parameter == 3){
            multithread m = new multithread(loggingService, fileName, "Rotation", "270");
            m.start();
            Pixel[][] temp =  com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface.applyRotation(image,parameter);
            try{
                m.join();
            }
            catch(Exception e){
                System.out.println(e);
            }

            return temp;
        }

        // Apply the effect and return the image
        return com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface.applyRotation(image,parameter);
    }


    // Setter and getter for the parameter
    @Override

    // Set the parameter value for the effect and throw exception if the parameter is not in the range
    public void setParameterValue(int parameterValue) throws IllegalParameterException {
        if(parameterValue < 0 || parameterValue >3)
            // Throw exception if the parameter is not in the range
            throw new IllegalParameterException("Illegal parameter for Rotation effect");

        // Set the parameter
        this.parameter = parameterValue;
    }
}
