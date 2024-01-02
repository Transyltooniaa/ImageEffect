package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


// Logging service class to add logs for the effects
@Service
public class LoggingService {

    // Add log for the effect with the parameters
    public void addLog(String fileName, String effectName, String optionValues) {

        // Get the current time stamp
        LocalDateTime localDateTime = LocalDateTime.now();

        // Convert the time stamp to string
        String currentTime = localDateTime.toString();

        //  Write the log to the file
        try
        {
            // Create a file object  for the log file
            File logFile = new File("logfile.txt");

            // Create a file writer object for the log file in append mode
            FileWriter fileWriter = new FileWriter("logfile.txt", true);

            // Create a buffered writer object for the file writer
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the log to the file in the format "fileName effectName optionValues timestamp"
            bufferedWriter.write(fileName + " " + effectName + " " + optionValues + " " + currentTime);
            bufferedWriter.newLine();

            // Close the buffered writer and file writer objects
            bufferedWriter.close();
            fileWriter.close();
        }

        // Catch the exception if any
        catch (IOException e)
        {
            // Print the exception if any
            System.out.println("Exception occurred while writing to log file.");
            System.out.println(e);
        }

        return;
    }

    // Get all the logs from the log file and return the list of logs as a list of log model objects
    public List<LogModel> getAllLogs() {

        // Create a list of log model objects to store all the logs from the log file
        List<LogModel> allLogs = new ArrayList<LogModel>();

        // Read the log file and store the logs in the list of log model objects
        try
        {
            // Create a file object for the log file
            File logFile = new File("logfile.txt");

            // Create a file reader object for the log file
            FileReader fileReader = new FileReader(logFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the log file line by line
            String line;

            // Split the line into the file name, effect name, option values and timestamp and store them in the log model object
            while ((line = bufferedReader.readLine()) != null)
            {
                // Split the line into the file name, effect name, option values and timestamp
                String sp[] = line.split(" ");
                String fileName = sp[0];
                String effectName = sp[1];
                String optionValues;
                String timestamp;

                // Check if the effect name is HueSaturation and if yes then store the option values in the format "hue saturation"
                if(effectName.equals("HueSaturation"))
                {
                    optionValues = sp[2] + " " + String.format("%.2f",Double.parseDouble(sp[3])) + " " + sp[4] + " " +  String.format("%.2f",Double.parseDouble(sp[5]));;
                    timestamp = sp[6];
                }

                //for other effects store the option values in the format "optionValue"
                else{

                    optionValues =  sp[2];
                    timestamp = sp[3];
                }

                // Create a log model object and add it to the list of log model objects
                LogModel logModel = new LogModel(timestamp, fileName, effectName, optionValues);
                allLogs.add(logModel);
            }
        }


        // Catch the exception if any
        catch (IOException e)
        {
            // Print the exception if any
            System.out.println("Error occurred while reading log file.");
            System.out.println(e);
        }

        // Return the list of log model objects
        return allLogs;
    }

    // Get all the logs for the given file name and return the list of logs as a list of log model objects
    public List<LogModel> getLogsByEffect(String effectName) {

        // Create a list of log model objects to store all the logs for the given file name
        List<LogModel> logsByEffect = new ArrayList<LogModel>();

        // Get all the logs from the log file and store the logs for the given file name in the list of log model objects
        logsByEffect = getAllLogs().stream().filter(log -> log.getEffectName().equalsIgnoreCase(effectName)).collect(Collectors.toList());

        return logsByEffect;
    }

    // Get all the logs for the given file name and return the list of logs as a list of log model objects
    public void clearLogs() {

        // Clear the log file
        try
        {
            new FileWriter("logfile.txt", false).close();
        }

        // Catch the exception if any
        catch (IOException e)
        {
            System.out.println("Error occurred while deleting logs.");
            System.out.println(e);
        }

        return;
    }


    // Get all the logs for the given file name and return the list of logs as a list of log model objects based on the start and end time
    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {

        // Create a list of log model objects to store all the logs for the given file name
        List<LogModel> logsBetweenTimestamps= new ArrayList<LogModel>();

        // Get all the logs from the log file and store the logs for the given file name in the list of log model objects
        logsBetweenTimestamps = getAllLogs();

        // Remove the logs which are not between the start and end time
        for(int i = 0; i < logsBetweenTimestamps.size(); i++) {
            LocalDateTime timestamp = LocalDateTime.parse(logsBetweenTimestamps.get(i).getTimestamp());

            if (timestamp.isBefore(startTime) || timestamp.isAfter(endTime)) {
                logsBetweenTimestamps.remove(i);
                i--;
            }
        }

        // Return the list of log model objects
        return logsBetweenTimestamps;
    }
}
