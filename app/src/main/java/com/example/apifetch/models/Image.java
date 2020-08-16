package com.example.apifetch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Image {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private Object title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("animated")
    @Expose
    private Boolean animated;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("bandwidth")
    @Expose
    private String bandwidth;
    @SerializedName("vote")
    @Expose
    private Object vote;
    @SerializedName("favorite")
    @Expose
    private Boolean favorite;
    @SerializedName("nsfw")
    @Expose
    private Object nsfw;
    @SerializedName("section")
    @Expose
    private Object section;
    @SerializedName("account_url")
    @Expose
    private Object accountUrl;
    @SerializedName("account_id")
    @Expose
    private Object accountId;
    @SerializedName("is_ad")
    @Expose
    private Boolean isAd;
    @SerializedName("in_most_viral")
    @Expose
    private Boolean inMostViral;
    @SerializedName("has_sound")
    @Expose
    private Boolean hasSound;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("ad_type")
    @Expose
    private String adType;
    @SerializedName("ad_url")
    @Expose
    private String adUrl;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("in_gallery")
    @Expose
    private Boolean inGallery;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("comment_count")
    @Expose
    private Object commentCount;
    @SerializedName("favorite_count")
    @Expose
    private Object favoriteCount;
    @SerializedName("ups")
    @Expose
    private Object ups;
    @SerializedName("downs")
    @Expose
    private Object downs;
    @SerializedName("points")
    @Expose
    private Object points;
    @SerializedName("score")
    @Expose
    private Object score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAnimated() {
        return animated;
    }

    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Object getVote() {
        return vote;
    }

    public void setVote(Object vote) {
        this.vote = vote;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Object getNsfw() {
        return nsfw;
    }

    public void setNsfw(Object nsfw) {
        this.nsfw = nsfw;
    }

    public Object getSection() {
        return section;
    }

    public void setSection(Object section) {
        this.section = section;
    }

    public Object getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(Object accountUrl) {
        this.accountUrl = accountUrl;
    }

    public Object getAccountId() {
        return accountId;
    }

    public void setAccountId(Object accountId) {
        this.accountId = accountId;
    }

    public Boolean getIsAd() {
        return isAd;
    }

    public void setIsAd(Boolean isAd) {
        this.isAd = isAd;
    }

    public Boolean getInMostViral() {
        return inMostViral;
    }

    public void setInMostViral(Boolean inMostViral) {
        this.inMostViral = inMostViral;
    }

    public Boolean getHasSound() {
        return hasSound;
    }

    public void setHasSound(Boolean hasSound) {
        this.hasSound = hasSound;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public Boolean getInGallery() {
        return inGallery;
    }

    public void setInGallery(Boolean inGallery) {
        this.inGallery = inGallery;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Object getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Object commentCount) {
        this.commentCount = commentCount;
    }

    public Object getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Object favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Object getUps() {
        return ups;
    }

    public void setUps(Object ups) {
        this.ups = ups;
    }

    public Object getDowns() {
        return downs;
    }

    public void setDowns(Object downs) {
        this.downs = downs;
    }

    public Object getPoints() {
        return points;
    }

    public void setPoints(Object points) {
        this.points = points;
    }

    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }

}