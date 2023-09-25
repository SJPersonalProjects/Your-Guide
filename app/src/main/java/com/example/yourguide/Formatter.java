package com.example.yourguide;

import java.util.List;

public interface Formatter {

    /**
     * Formats the string by covering the given string with parentheses.
     * @param reviews is the reviews of the users on place, hotel, or any other experience.
     * @return a formatted string.
     */
    default String reviewFormatter(String reviews) {
        return "(" + reviews + ")";
    }


    /**
     * Default implementation of a method.
     * @return a random string from the list.
     */
    default String subHeadingFormatter() {
        String[] subHeadingsList = {
                "Gateway to...",
                "Heart of...",
                "Exploring...",
                "Discovering...",
                "Experiencing...",
                "Unveiling...",
                "Cultural hub of...",
                "A journey through...",
                "Adventures in...",
                "Hidden treasure of..."
        };

        double randomChoice = Math.random() * subHeadingsList.length;
        int randomHeading = (int) randomChoice;
        return subHeadingsList[randomHeading];
    }

    /**
     * Gets the name of the city, historical place, or restaurant
     * clicked by the user and returns the location accordingly.
     * @param name is the name of the place or restaurant
     * @return the location.
     */
    String getLocation(String name);

    /**
     * Gets the name of the city, historical place, or restaurant
     * clicked by the user and returns the description accordingly.
     * @param name is the name of hte place or restaurant.
     * @return the description
     */
    String getDescription(String name);

    String getLatitudeLongitude(String name, List<Map> list);
}
