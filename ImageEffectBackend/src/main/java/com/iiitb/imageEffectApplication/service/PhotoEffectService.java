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
            HueSaturation hueSaturation = new HueSaturation();

            try {
                hueSaturation.setParameter("hue", (hueAmount-100)/100 + 1);
                hueSaturation.setParameter("saturation", (saturationAmount-100)/100 + 1);
            }

            catch (IllegalParameterException e) {
                e.printStackTrace();
            }

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
            Brightness brightness = new Brightness();

            try{
                brightness.setParameterValue(255*(amount-100)/100);
            }

            catch(IllegalParameterException e) {
                e.printStackTrace();
            }
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
            Contrast contrast = new Contrast();

            try{
                contrast.setParameterValue(((amount-100)/100)+1.5f);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

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
            Flip flip = new Flip();

            try {
                flip.selectOptionValue("horizontalFlip", horizontalFlipValue);
                flip.selectOptionValue("verticalFlip", verticalFlipValue);
            }

            catch (IllegalParameterException e) {
                e.printStackTrace();
            }


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
            GaussianBlur gaussianBlur = new GaussianBlur();

            try{
                gaussianBlur.setParameterValue(radius);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

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
            GrayScale grayScale = new GrayScale();
            
            try{
                grayScale.setParameterValue(1);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

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
            Rotation rotation = new Rotation();

            try{
                rotation.setParameterValue(value);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }


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

            Sepia sepia = new Sepia();

            try{
                sepia.setParameterValue(1);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

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

            Sharpen sharpen = new Sharpen();

            try{
                sharpen.setParameterValue((amount-100)/100+1);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
            }

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
