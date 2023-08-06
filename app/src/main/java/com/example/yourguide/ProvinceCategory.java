package com.example.yourguide;

public class ProvinceCategory {
    //Instance fields.
    private String mProvinceName;
    private int mProvinceDescription;
    private String mNumberOfHistoricalPlaces;
    private String mNumberOfPopularPlaces;
    private String mNumberOfCities;
    private final int mProvinceImageID;
    private int mProvinceBackgroundTint;

    /**
     * Create a new ProvinceData object to store into the list
     * @param mProvinceName is the name of the province in the list item
     * @param mProvinceDescription is the description of the province in the list item
     * @param mNumberOfHistoricalPlaces is the number of historical places in the list item
     * @param mNumberOfPopularPlaces is the number of popular places in the list item
     * @param mNumberOfCities is the number of cities in the list item
     * @param mImageOfProvince is the specific background image for each province list item
     * @param mProvinceBackgroundTint is the specific background tint for each province list item
     */
    public ProvinceCategory(String mProvinceName, int mProvinceDescription,
                            String mNumberOfHistoricalPlaces, String mNumberOfPopularPlaces,
                            String mNumberOfCities, int mImageOfProvince, int mProvinceBackgroundTint) {
        this.mProvinceName = mProvinceName;
        this.mProvinceDescription = mProvinceDescription;
        this.mNumberOfHistoricalPlaces = mNumberOfHistoricalPlaces;
        this.mNumberOfPopularPlaces = mNumberOfPopularPlaces;
        this.mNumberOfCities = mNumberOfCities;
        this.mProvinceImageID = mImageOfProvince;
        this.mProvinceBackgroundTint = mProvinceBackgroundTint;
    }

    /**
     * Accessor Methods to get and set the data.
     *
     * Set the province name to rename it.
     * @param mProvinceName is the name of the province in the provincial list items
     */
    public void setProvinceName(String mProvinceName) {
        this.mProvinceName = mProvinceName;
    }

    /**
     * Get the province name to display on the list item
     * @return province name
     */
    public String getProvinceName() {
        return mProvinceName;
    }

    /**
     * Set the province description to update it
     * @param mProvinceDescription is the province description
     */
    public void setProvinceDescription(int mProvinceDescription) {
        this.mProvinceDescription = mProvinceDescription;
    }

    /**
     * Get the province description to display as a list item
     * @return description of the province
     */
    public int getProvinceDescription() {
        return mProvinceDescription;
    }

    /**
     * Set the number of historical places as some numerical data on the list item
     * @param mNumberOfHistoricalPlaces is the actual number that refers to the cities in province.
     */
    public void setNumberOfHistoricalPlaces(String mNumberOfHistoricalPlaces) {
        this.mNumberOfHistoricalPlaces = mNumberOfHistoricalPlaces;
    }

    /**
     * Get the number of historical places to display as the list item
     * @return
     */
    public String getNumberOfHistoricalPlaces() {
        return mNumberOfHistoricalPlaces;
    }

    /**
     * Set the number of popular places as some numerical data on the list item
     * @param mNumberOfPopularPlaces is the actual number that refers to the random popular sights.
     */
    public void setNumberOfPopularPlaces(String mNumberOfPopularPlaces) {
        this.mNumberOfPopularPlaces = mNumberOfPopularPlaces;
    }

    /**
     * Get the number of popular places as some numerical data from the list item
     * @return number of popular places in the province.
     */
    public String getNumberOfPopularPlaces() {
        return mNumberOfPopularPlaces;
    }

    /**
     * Set the number of cities in the province as some numerical data on the list item.
     * @param mNumberOfCities is the number of cities in the list of province.
     */
    public void setNumberOfCities(String mNumberOfCities) {
        this.mNumberOfCities = mNumberOfCities;
    }

    /**
     * Get the number of cities as some numerical data from the list.
     * @return number of cities present in the provincial data.
     */
    public String getNumberOfCities() {
        return mNumberOfCities;
    }

    /**
     * Get the background image of each province.
     * @return the ID of each province background image.
     */
    public int getProvinceImageID() {
        return mProvinceImageID;
    }

    /**
     * Get the background tint for each province list item
     * @return the ID for each province list item's background tint.
     */
    public int getProvinceBackgroundTint() {
        return mProvinceBackgroundTint;
    }
}
