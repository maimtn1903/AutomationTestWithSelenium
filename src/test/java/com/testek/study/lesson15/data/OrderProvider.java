// language: java
package com.testek.study.lesson15.data;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class OrderProvider {

    @DataProvider(name = "LabIT_Order_02")
    public HashMap<String, String>[] LabIT_Order_02(Method method) {
        String resourcePath = "data/sit/json/order_data_test.json";
        var dataList = readDataTestFromJSON(resourcePath, method.getName());
        HashMap<String, String>[] dataArray = new HashMap[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i] = new HashMap(dataList.get(i));
        }
        return dataArray;
    }
    @DataProvider(name = "Mai_Order_02")
    public HashMap<String, String>[] Mai_Order_02(Method method) {
        String resourcePath = "data/sit/json/maiOrderDataTest.json";
        var dataList = readDataTestFromJSON(resourcePath, method.getName());
        HashMap<String, String>[] dataArray = new HashMap[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i] = new HashMap(dataList.get(i));
        }
        return dataArray;
    }

    /**
     * Read data from JSON resource or filesystem then return Data Object
     *
     * @param resourceOrPath : classpath resource path or filesystem path
     * @param tcName         : TC Name (top-level JSON key)
     * @return Data Provider Object
     */
    public List<Hashtable<String, Object>> readDataTestFromJSON(String resourceOrPath, String tcName) {
        List<Hashtable<String, Object>> dataListMap = new ArrayList<>();
        try {
            String content = readResourceOrFile(resourceOrPath);
            if (content == null || content.isEmpty()) {
                System.err.println("No content found for: " + resourceOrPath);
                return dataListMap;
            }

            JSONObject jsonObject = new JSONObject(content);
            if (!jsonObject.has(tcName)) {
                System.err.println("Test case key not found in JSON: " + tcName);
                return dataListMap;
            }

            // Expecting the value for tcName to be an array of objects
            JSONArray arr = jsonObject.getJSONArray(tcName);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                Hashtable<String, Object> rowDataMap = new Hashtable<>();
                for (String key : obj.keySet()) {
                    rowDataMap.put(key, obj.get(key));
                }
                dataListMap.add(rowDataMap);
            }
        } catch (Exception e) {
            System.err.println("VException: " + e.getMessage());
        }
        return dataListMap;
    }

    /**
     * Try to read a file first from the classpath, then fall back to filesystem path.
     *
     * @param resourceOrPath classpath resource (e.g. com/testek/.../file.json) or filesystem path
     * @return file content as String or null if not found
     */
    private String readResourceOrFile(String resourceOrPath) {
        // Try classpath
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try (InputStream is = cl.getResourceAsStream(resourceOrPath)) {
            if (is != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append('\n');
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            // ignore and try filesystem next
        }

        // Fallback: try filesystem path
        try {
            Path p = Path.of(resourceOrPath);
            if (Files.exists(p)) {
                return Files.readString(p, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            System.err.println("Failed to read file from filesystem: " + e.getMessage());
        }

        return null;
    }
}