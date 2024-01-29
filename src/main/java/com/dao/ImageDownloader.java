package com.dao;
import java.io.*;
import java.net.*;

public class ImageDownloader {
    public static void main(String[] args) {
        String imageUrl = "http://localhost:8080/final_library_mgnt/Staff_register.jsp";
        String destinationFile = "image.jpg";

        try {
            URL url = new URL(imageUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");
            InputStream inputStream = httpConn.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(destinationFile);

            int bytesRead;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("Image downloaded successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
