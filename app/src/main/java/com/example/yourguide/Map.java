package com.example.yourguide;

public class Map {
    //Instance fields.
    private final String mLatitude;
    private final String mLongitude;

    /**
     * Construct a Map object to store the coordinates for each location.
     * @param mLatitude is field to store latitude for each location.
     * @param mLongitude is field to store longitude for each location.
     */
    public Map(String mLatitude, String mLongitude) {
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
    }

    /**
     * Gets latitude for each location
     * @return latitude
     */
    public String getLatitude() {
        return mLatitude;
    }

    /**
     * Gets longitude for each location
     * @return longitude
     */
    public String getLongitude() {
        return mLongitude;
    }
}
