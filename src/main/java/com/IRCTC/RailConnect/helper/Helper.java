package com.IRCTC.RailConnect.helper;

public class Helper {
    public static String getFilePathName(String folder, String originalFileName) {
        return folder + "/" + System.currentTimeMillis() + "_" + originalFileName.replaceAll(" ", "_");
    }
}
