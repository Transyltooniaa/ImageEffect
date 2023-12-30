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

@Service
public class LoggingService {

    public void addLog(String fileName, String effectName, String optionValues) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String currentTime = localDateTime.toString();

        try
        {
            File logFile = new File("logfile.txt");

            FileWriter fileWriter = new FileWriter("logfile.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(fileName + " " + effectName + " " + optionValues + " " + currentTime);
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();
        }

        catch (IOException e)
        {
            System.out.println("Exception occurred while writing to log file.");
            System.out.println(e);
        }

        return;
    }

    public List<LogModel> getAllLogs() {

        List<LogModel> allLogs = new ArrayList<LogModel>();

        try
        {
            File logFile = new File("logfile.txt");

            FileReader fileReader = new FileReader(logFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                String sp[] = line.split(" ");
                String fileName = sp[0];
                String effectName = sp[1];
                String optionValues;
                String timestamp;

                if(effectName.equals("HueSaturation"))
                {

                    optionValues = sp[2] + " " + String.format("%.2f",Double.parseDouble(sp[3])) + " " + sp[4] + " " +  String.format("%.2f",Double.parseDouble(sp[5]));;
                    timestamp = sp[6];
                }

                else{

                    optionValues =  sp[2];
                    timestamp = sp[3];
                }

                LogModel logModel = new LogModel(timestamp, fileName, effectName, optionValues);
                allLogs.add(logModel);
            }
        }

        catch (IOException e)
        {
            System.out.println("Error occurred while reading log file.");
            System.out.println(e);
        }

        return allLogs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {

        List<LogModel> logsByEffect = new ArrayList<LogModel>();

        logsByEffect = getAllLogs().stream().filter(log -> log.getEffectName().equalsIgnoreCase(effectName)).collect(Collectors.toList());

        return logsByEffect;
    }

    public void clearLogs() {

        try
        {
            new FileWriter("logfile.txt", false).close();
        }

        catch (IOException e)
        {
            System.out.println("Error occurred while deleting logs.");
            System.out.println(e);
        }

        return;
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {

        List<LogModel> logsBetweenTimestamps= new ArrayList<LogModel>();

        logsBetweenTimestamps = getAllLogs();

        for(int i = 0; i < logsBetweenTimestamps.size(); i++)
        {
            LocalDateTime timestamp = LocalDateTime.parse(logsBetweenTimestamps.get(i).getTimestamp());

            if (timestamp.isBefore(startTime) || timestamp.isAfter(endTime))
            {
                logsBetweenTimestamps.remove(i);
                i--;
            }
        }


        return logsBetweenTimestamps;
    }
}
