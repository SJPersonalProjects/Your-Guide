package com.example.yourguide;

public class Province {
    private final int mCardImage;
    private final int mCardTitle;
    private final int mCardDescription;
    private final int mCardRating;
    private final String mCardReview;

    /**
     * Constructor a new {@link Province} object.
     * @param mCardImage is the image of the card of punjab province.
     * @param mCardTitle is the title of the card of punjab province.
     * @param mCardDescription is the description of the card of punjab province.
     * @param mCardRating is the rating of the card of punjab province.
     * @param mCardReview is the review of the card beside rating of the punjab province.
     */
    public Province(int mCardImage, int mCardTitle, int mCardDescription,
                    int mCardRating, String mCardReview) {
        this.mCardImage = mCardImage;
        this.mCardTitle = mCardTitle;
        this.mCardDescription = mCardDescription;
        this.mCardRating = mCardRating;
        this.mCardReview = mCardReview;
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

    /**
     * Get the review of the card
     * @return reviews of people
     */
    public String getCardReview() {
        return mCardReview;
    }
}
