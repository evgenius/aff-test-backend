package de.affinitas.match_filter.model;

public class Match {

    private int id;
    private String displayName;
    private int age;
    private String jobTitle;
    private int heightInCm;
    private City city;
    private String mainPhoto;
    private float compatibilityScore;
    private int contactsExchanged;
    private boolean favourite;
    private String religion;

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    public City getCity() {
        return city;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public float getCompatibilityScore() {
        return compatibilityScore;
    }

    public int getContactsExchanged() {
        return contactsExchanged;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public String getReligion() {
        return religion;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %s}", displayName, age, jobTitle);
    }
}
