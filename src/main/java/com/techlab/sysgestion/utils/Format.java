package com.techlab.sysgestion.utils;

public class Format {

    public static String formatName(String name){
        name = name.trim();
        StringBuilder finalName = new StringBuilder();
        String [] words = name.split(" ");
        for(String word: words){
            if(!word.isEmpty()){
                finalName.append(word.toUpperCase().charAt(0)).append(word.substring(1).toLowerCase());
                finalName.append(" ");
            }
        }
        return finalName.toString().trim();
    }
}
