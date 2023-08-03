package com.example.yourguide.punjab_province;

public class PunjabProvinceCard {
    private final int mCardImage;
    private final String mCardTitle;
    private final String mCardDescription;
    private final String mCardRating;

    /**
     * Constructor a new {@link PunjabProvinceCard} object.
     * @param mCardImage is the image of the card of punjab province.
     * @param mCardTitle is the title of the card of punjab province.
     * @param mCardDescription is the description of the card of punjab province.
     * @param mCardRating is the rating of the card of punjab province.
     */
    public PunjabProvinceCard(int mCardImage, String mCardTitle, String mCardDescription,
                              String mCardRating) {
        this.mCardImage = mCardImage;
        this.mCardTitle = mCardTitle;
        this.mCardDescription = mCardDescription;
        this.mCardRating = mCardRating;
    }

    /**
     * Get the ID of the image of the card.
     * @return the ID of image.
     */
    public int getCardImage() {
        return mCardImage;
    }

    /**
     * Get the Title of card
     * @return title
     */
    public String getCardTitle() {
        return mCardTitle;
    }

    /**
     * Get the description of card.
     * @return description.
     */
    public String getCardDescription() {
        return mCardDescription;
    }

    /**
     * Get the rating of the card.
     * @return rating of card.
     */
    public String mCardRating() {
        return mCardRating;
    }
}
