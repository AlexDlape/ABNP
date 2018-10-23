package com.example.android.theguardian;

/**
 * Created by alexd on 17/08/2018.
 */

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class Utils {
    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = Utils.class.getSimpleName();

    /**
     * Create a private constructor.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name Utils.
     */

    private Utils() {
    }


    // Query the Guardian data and return a list of News objects.

    public static List<News> fetchNewsData(String GUARDIAN_REQUEST_URL) throws InterruptedException {

        /*
        * Create URL object
        */

        URL url = returnUrl(GUARDIAN_REQUEST_URL);

        // Perform HTTP request to URL and receive a JSON response
        String jsonResponse = null;
        try {
            // Try to create a HTTP request with the request URL by makeHttpRequest
            jsonResponse = makeHttpRequest(url);

        } catch (IOException e) {
            // In case that request failed, print the error message into log
            Log.e(LOG_TAG, "HTTP request failed.", e);
        }


        // Extract relevant fields from the JSON response and create a list of Education News
        List<News> news = extractFeatureFromJson(jsonResponse);

        // Return the list of news
        return news;
    }

       /*
    *Return new URL object from the given string URL.
     */

    private static URL returnUrl(String stringUrl) {
        URL url = null;
        try {
            // Try to create an URL from String
            url = new URL(stringUrl);

        } catch (MalformedURLException e) {

            // In case that request failed, print the error message into log
            Log.e(LOG_TAG, "URL building problem.", e);
        }
        return url;
    }

    /*
    * Make an HTTP request to the given URL and return a String as the response.
    */

    private static String makeHttpRequest(URL url) throws IOException {

        String jsonResponse = "";

        // If the URL is null then return early.
        if (url == null) {
            return jsonResponse;
        }

        // Initialize variables for the HTTP connection and for the InputStream
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            // Try to establish a HTTP connection with the request URL and set up the properties of the request
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");

            /**Suggestion
             We can save the numbers in the constants. Replacing all significant magic numbers with named constants makes programs easier to read, understand and maintain.
             Here you can read more about magic numbers.*/

            // Send a request to connect
            urlConnection.connect();

            // If the request was successful, then read the Input Stream and parse the response.
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                /**Awesome
                 Great for replacing 200 with HTTP_OK expression!*/

                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                // If the response failed, print it to the Log
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {

            // If the connection was not established, print it to the log
            Log.e(LOG_TAG, "Connection was not established. Problem retrieving JSON News results.", e);
        } finally {

            // Disconnect the HTTP connection if it is not disconnected yet
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            // Close the Input Stream if it is not closed yet
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /*
    / Convert the InputStream into a String which contains the whole JSON response from the server.
    */

    private static String readFromStream(InputStream inputStream) throws IOException {

        // Create a new StringBuilder
        StringBuilder output = new StringBuilder();

        // If the InputStream exists, create an InputStreamReader from it and a BufferedReader from the InputStreamReader
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);

            // Append the data of the BufferedReader line by line to the StringBuilder
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }

        // Convert the output into String and return it
        return output.toString();
    }

    /**
     * Return list of {@link News} objects that has been built up from parsing the given JSON response.
     */
    private static List<News> extractFeatureFromJson(String newsJSON) {

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding news to
        List<News> newsList = new ArrayList<>();

        // Try to parse the JSON response string.
        // In case of any problem with the way the JSON is formatted,
        // a JSONException exception object will be thrown.
        // To avoid app is crashed error message is printed into logs.

        try {
            JSONObject rootObject = new JSONObject(newsJSON);
            JSONObject responseObject = rootObject.getJSONObject("response");
            JSONArray results = responseObject.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                String sectionName = result.getString("sectionName");
                String webPublicationDate = result.getString("webPublicationDate");
                String webTitle = result.getString("webTitle");
                String webUrl = result.getString("webUrl");
                JSONArray tags = result.getJSONArray("tags");
                String author2;
                if (tags.length() > 0) {
                    JSONObject result2 = tags.getJSONObject(0);
                    author2 = result2.getString("webTitle");
                } else {
                    author2 = "";
                }
                newsList.add(new News(webTitle, sectionName, author2, webPublicationDate, webUrl));
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("NewsUtils", "JSON results parsing problem.");
        }

        // Return the list of earthquakes
        return newsList;
    }
}