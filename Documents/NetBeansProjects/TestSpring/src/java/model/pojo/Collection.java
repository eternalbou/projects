package model.pojo;
// Generated 30.08.2017 15:23:49 by Hibernate Tools 4.3.1



/**
 * Collection generated by hbm2java
 */
public class Collection  implements java.io.Serializable {


     private Integer collectionId;
     private String artist;
     private String album;
     private String yearReleaseOriginal;
     private String yearRelease;
     private String description;
     private String label;
     private String dateBought;
     private String cover;
     private String genres;

    public Collection() {
    }

    public Collection(String artist, String album, String yearReleaseOriginal, String yearRelease, String description, String label, String dateBought, String cover, String genres) {
       this.artist = artist;
       this.album = album;
       this.yearReleaseOriginal = yearReleaseOriginal;
       this.yearRelease = yearRelease;
       this.description = description;
       this.label = label;
       this.dateBought = dateBought;
       this.cover = cover;
       this.genres = genres;
    }
   
    public Integer getCollectionId() {
        return this.collectionId;
    }
    
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }
    public String getArtist() {
        return this.artist;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getAlbum() {
        return this.album;
    }
    
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getYearReleaseOriginal() {
        return this.yearReleaseOriginal;
    }
    
    public void setYearReleaseOriginal(String yearReleaseOriginal) {
        this.yearReleaseOriginal = yearReleaseOriginal;
    }
    public String getYearRelease() {
        return this.yearRelease;
    }
    
    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    public String getDateBought() {
        return this.dateBought;
    }
    
    public void setDateBought(String dateBought) {
        this.dateBought = dateBought;
    }
    public String getCover() {
        return this.cover;
    }
    
    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getGenres() {
        return this.genres;
    }
    
    public void setGenres(String genres) {
        this.genres = genres;
    }




}


