package com.example.yourguide.punjab_province;

public class PunjabProvinceCard {
    private final int mCardImage;
    private final int mCardTitle;
    private final int mCardDescription;
    private final int mCardRating;

    /**
     * Constructor a new {@link PunjabProvinceCard} object.
     * @param mCardImage is the image of the card of punjab province.
     * @param mCardTitle is the title of the card of punjab province.
     * @param mCardDescription is the description of the card of punjab province.
     * @param mCardRating is the rating of the card of punjab province.
     */
    public PunjabProvinceCard(int mCardImage, int mCardTitle, int mCardDescription,
                              int mCardRating) {
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
    public int getCardTitle() {
        return mCardTitle;
    }

    /**
     * Get the description of card.
     * @return description.
     */
    public int getCardDescription() {
        return mCardDescription;
    }

    /**
     * Get the rating of the card.
     * @return rating of card.
     */
    public int getCardRating() {
        return mCardRating;
    }
}
