package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.EffectImplementation.Brightness;
import com.iiitb.imageEffectApplication.EffectImplementation.Contrast;
import com .iiitb.imageEffectApplication.EffectImplementation.Flip;
import com.iiitb.imageEffectApplication.EffectImplementation.Invert;
import com.iiitb.imageEffectApplication.EffectImplementation.Rotation;
import com.iiitb.imageEffectApplication.EffectImplementation.Sepia;
import com.iiitb.imageEffectApplication.EffectImplementation.Sharpen;
import com.iiitb.imageEffectApplication.EffectImplementation.GrayScale;
import com.iiitb.imageEffectApplication.EffectImplementation.GaussianBlur;
import com.iiitb.imageEffectApplication.EffectImplementation.HueSaturation;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.utils.ProcessingUtils;

import java.math.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


// Service class for the application which will be called by the controller
@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService =new LoggingService();

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Instantiate the effect class and set the parameter
            HueSaturation hueSaturation = new HueSaturation();

            // Set the parameter value
            try {
                hueSaturation.setParameter("hue", (hueAmount-100)/100 + 1);
                hueSaturation.setParameter("saturation", (saturationAmount-100)/100 + 1);
            }

            // Catch the exception if the parameter is not in the range
            catch (IllegalParameterException e) {
                e.printStackTrace();
            }

            // Apply the effect and return the image
            Pixel[][] modifiedImage = hueSaturation.apply(inputImage, imageName, loggingService);// Replace this with actual modified image

            // ACTUAL WORK ENDS HERE
            return processingUtils.postProcessing(modifiedImage);


        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Instantiate the effect class and set the parameter
            Brightness brightness = new Brightness();

            // Set the parameter value for the effect
            try{
                brightness.setParameterValue(255*(amount-100)/100);
            }

            // Catch the exception if the parameter is not in the range
            catch(IllegalParameterException e) {
                e.printStackTrace();
            }

            // Apply the effect and return the image
            Pixel[][] modifiedImage = brightness.apply(inputImage, imageName, loggingService);// Replace this with actual modified image

            // ACTUAL WORK ENDS HERE
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO

            // Instantiate the effect class and set the parameter
            Contrast contrast = new Contrast();

            // Set the parameter value for the effect and catch the exception if the parameter is not in the range
            try{
                contrast.setParameterValue(((amount-100)/100)+1.5f);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

            // Apply the effect and return the image
            Pixel[][] modifiedImage = contrast.apply(inputImage, imageName, loggingService);// Replace this with actual modified image

            // ACTUAL WORK ENDS HERE
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO

            // Instantiate the effect class and set the parameter
            Flip flip = new Flip();


            // Set the parameter value for the effect and catch the exception if the parameter is not in the range
            try {
                flip.selectOptionValue("horizontalFlip", horizontalFlipValue);
                flip.selectOptionValue("verticalFlip", verticalFlipValue);
            }

            // Catch the exception if the parameter is not in the range
            catch (IllegalParameterException e) {
                e.printStackTrace();
            }

            // Apply the effect and return the image
            Pixel[][] modifiedImage = flip.apply(inputImage, imageName, loggingService);// Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Instantiate the effect class and set the parameter
            GaussianBlur gaussianBlur = new GaussianBlur();


            //  Set the parameter value for the effect and catch the exception if the parameter is not in the range
            try{
                gaussianBlur.setParameterValue(radius);
            }

            // Catch the exception if the parameter is not in the range
            catch(IllegalParameterException e){
                e.printStackTrace();
            }


            // Apply the effect and return the image
            Pixel[][] modifiedImage = gaussianBlur.apply(inputImage, imageName, loggingService);// Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Instantiate the effect class and set the parameter
            GrayScale grayScale = new GrayScale();

            // Set the parameter value for the effect and catch the exception if the parameter is not in the range
            try{
                grayScale.setParameterValue(1);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

            // Apply the effect and return the image
            Pixel[][] modifiedImage = grayScale.apply(inputImage, imageName, loggingService);// Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            Invert invert = new Invert();

            try{
                invert.setParameterValue(1);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

            Pixel[][] modifiedImage = invert.apply(inputImage, imageName, loggingService);// Replace this with actual modified image
            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Instantiate the effect class and set the parameter
            Rotation rotation = new Rotation();
            
            
            // Set the parameter value for the effect and catch the exception if the parameter is not in the range
            try{
                rotation.setParameterValue(value);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

            // Apply the effect and return the image
            Pixel[][] modifiedImage = rotation.apply(inputImage, imageName, loggingService);// Replace this with actual modified image


            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE
            // TODO

            // Instantiate the effect class and set the parameter
            Sepia sepia = new Sepia();

            //  Set the parameter value for the effect and catch the exception if the parameter is not in the range
            try{
                sepia.setParameterValue(1);
            }

            // Catch the exception if the parameter is not in the range
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

            // Apply the effect and return the image
            Pixel[][] modifiedImage = sepia.apply(inputImage, imageName, loggingService);// Replace this with actual modified image

            // ACTUAL WORK ENDS HERE
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO

            // Instantiate the effect class and set the parameter
            Sharpen sharpen = new Sharpen();

            // Set the parameter value for the effect and catch the exception if the parameter is not in the range
            try{
                sharpen.setParameterValue((amount-100)/100+1);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

            // Apply the effect and return the image
            Pixel[][] modifiedImage = sharpen.apply(inputImage, imageName, loggingService);// Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            Pixel[][] modifiedImage = inputImage; // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
