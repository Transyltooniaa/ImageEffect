# 🌈 IMAGE EFFECT APPLICATION 🌟

Our collaborative team has successfully developed a vibrant website, meticulously crafted from an initial code skeleton. This platform serves as a canvas where a multitude of image effects come to life, gracefully dancing and transforming your pictures. From flips to blurs, our repertoire covers a diverse range of visual enhancements.

## ✨ Implemented Effects:

1. **Brightness**
2. **Contrast**
3. **Flip**
4. **Gaussian Blur**
5. **Grayscale**
6. **Hue/Saturation**
7. **Invert**
8. **Rotation**
9. **Sepia**
10. **Sharpen**
    
&nbsp;

## 🚀 CONTRIBUTIONS 🌐

### IMT2022048 AREEN VAGHASIYA
Implemented Image effects Gaussian Blur, Sharpen. Implemented logging service for Gaussian Blur.

### IMT2022559 AJITESH KUMAR
Implemented Image effects Constrast and Hue saturation. Structured the class for the Logging Service with File/IO . Structures the class for Multithreading


### IMT2022081 RUDRA PATHAK
Implemented Image effects Grayscale and Flip.Implemented logging service for Constrast,Hue Saturation, Invert, Rotation.


### IMT2022574 VAIBHAV BAJORIYA
Implemented Image effects Invert and Rotation. Implemented logging service for Sharpen, Grayscale, Flip. Helped in debugging the Makefile and initial setup.


### IMT2022566 ADITYA PRAKASH
Implemented Image effects Sepia. Implemented logging service for Sepia. Implemntation of multithreading

&nbsp;

## 📜 Logs 📊

Explore the logs for each effect gracefully displayed on the website. Navigate to the "Logs" section in the frontend directory to witness the magic. Filter logs by effect name and revel in the timestamps of each enchanting transformation.

&nbsp;


# 🚀 HOW TO RUN IMAGE EFFECT APPLICATION 🚀

### INITIAL SETUP (Common for both Mac as well as Linux Users)

* Cloning the repository on local System

```
git clone https://github.com/Transyltooniaa/ImageEffect/tree/main
```

* Open the project on intellij idea (Community/Ultimate edition) version : 2023.3.2

* Run the following commend on terminal
  
```
npm i
```

With this you done with the initial setup.

&nbsp;

### 🎨 SETUP COMMANDS FOR FRONTEND 🖌️ (Common for both Mac and Linux users)

In your bash terminal, Navigate to  ImageEffectFrontend using the commands given below : 

```bash
cd ImageEffectFrontend
```
&nbsp;
```
npm i 
```
[A folder named nodemodules will be created]
&nbsp;

```
npm start 
```
[It will start the server for Angular at localhost IP address with port number 4200]

&nbsp;

### NOTE : The terminal might indicate :   The port 4200 is already in use. Do you want to change the port number?(Enter y/n) => Enter y

&nbsp;

* Open any modern internet browser supporting angular and paste the below URL.

```
http://localhost:4200/
```


### 🚀 SETUP COMMANDS FOR BACKEND 🌐

Follow these steps to compile and start the enchanting server:

1. **Compile C++ Files 🛠️:**
   - Navigate to the `ImageEffectBackend` directory:
     ```bash
     cd ImageEffectBackend
     ```
   - Ensure the `Makefile` aligns with your Java path and version. Make necessary changes if required.

   - Run the following commands:
     ```bash
     make clean
     make
     ```
  
     #### NOTE : The Makefile present in the folder is for macOS.  You can find the Makefile for Linux in a folder called MakefileLinux.
    
     ##### 💔 POSSIBLE ERROR: JNI.h not found 

     ###### 💡 SOLUTION: check if your jvm has jni.h file. It is generally present in the 'include' folder. Or Ensure the `Makefile` aligns with your Java path and version. Make necessary changes if required.

2. **Using Maven? 🌍:** (For Linux Users)
   - If Maven is already installed on your machine , run:
     ```bash
     sudo mvn clean package
     ```

   - Otherwise, embrace the Maven Wrapper:  [ This command should generate .jar file in the target folder if everything was executed well ]
     ```bash
     ./mvnw clean package
     ```

    &nbsp;

    NOTE : IF THE ABOVE MENTIONED STEPS DON'T WORK FOR YOU, IT IS RECOMMENDED YOU INSTALL MAVEN ON YOUR MACHINE

   
    &nbsp;

    Maven for MacOS users

    - Install brew on your machine if not installed: [brew](https://brew.sh/)
    
    -  Install Maven on system using brew
    ```
    brew install maven
    ```
    
    - Run the following command [ This command should generate .jar file in the target folder if everything was executed well]
    ```
    mvn clean package
    ```

    

4. **Start the Backend Server 🚀:**

   - Finally, execute the spell to launch the backend:
     ```bash
     java -jar target/imageEffectApplication-0.0.1-SNAPSHOT.jar
     ```

     ##### 💔 POSSIBLE ERROR: `imageEffectApplication-0.0.1-SNAPSHOT.jar` file not found 💔

     ###### 💡 SOLUTION: Execute any other jar file generated in the target folder using the command given above 🚀


Feel the magic as your backend comes to life! ✨✨✨


### 🔄 REFRESH THE PROJECT ON THE BROWSER 🌐
