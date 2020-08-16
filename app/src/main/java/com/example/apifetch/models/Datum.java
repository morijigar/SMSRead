package com.example.apifetch.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Datum implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("datetime")
    @Expose
    private Integer datetime;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("cover_width")
    @Expose
    private Integer coverWidth;
    @SerializedName("cover_height")
    @Expose
    private Integer coverHeight;
    @SerializedName("account_url")
    @Expose
    private String accountUrl;
    @SerializedName("account_id")
    @Expose
    private Integer accountId;
    @SerializedName("privacy")
    @Expose
    private String privacy;
    @SerializedName("layout")
    @Expose
    private String layout;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("ups")
    @Expose
    private Integer ups;
    @SerializedName("downs")
    @Expose
    private Integer downs;
    @SerializedName("points")
    @Expose
    private Integer points;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("is_album")
    @Expose
    private Boolean isAlbum;
    @SerializedName("vote")
    @Expose
    private Object vote;
    @SerializedName("favorite")
    @Expose
    private Boolean favorite;
    @SerializedName("nsfw")
    @Expose
    private Boolean nsfw;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("comment_count")
    @Expose
    private Integer commentCount;
    @SerializedName("favorite_count")
    @Expose
    private Integer favoriteCount;
    @SerializedName("topic")
    @Expose
    private String topic;
    @SerializedName("topic_id")
    @Expose
    private Integer topicId;
    @SerializedName("images_count")
    @Expose
    private Integer imagesCount;
    @SerializedName("in_gallery")
    @Expose
    private Boolean inGallery;
    @SerializedName("is_ad")
    @Expose
    private Boolean isAd;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("ad_type")
    @Expose
    private Integer adType;
    @SerializedName("ad_url")
    @Expose
    private String adUrl;
    @SerializedName("in_most_viral")
    @Expose
    private Boolean inMostViral;
    @SerializedName("include_album_ads")
    @Expose
    private Boolean includeAlbumAds;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("ad_config")
    @Expose
    private AdConfig adConfig;
    @SerializedName("f_image")
    @Expose
    private String firstImage;


    protected Datum(Parcel in) {
        id = in.readString();
        title = in.readString();
        if (in.readByte() == 0) {
            datetime = null;
        } else {
            datetime = in.readInt();
        }
        cover = in.readString();
        if (in.readByte() == 0) {
            coverWidth = null;
        } else {
            coverWidth = in.readInt();
        }
        if (in.readByte() == 0) {
            coverHeight = null;
        } else {
            coverHeight = in.readInt();
        }
        accountUrl = in.readString();
        if (in.readByte() == 0) {
            accountId = null;
        } else {
            accountId = in.readInt();
        }
        privacy = in.readString();
        layout = in.readString();
        if (in.readByte() == 0) {
            views = null;
        } else {
            views = in.readInt();
        }
        link = in.readString();
        if (in.readByte() == 0) {
            ups = null;
        } else {
            ups = in.readInt();
        }
        if (in.readByte() == 0) {
            downs = null;
        } else {
            downs = in.readInt();
        }
        if (in.readByte() == 0) {
            points = null;
        } else {
            points = in.readInt();
        }
        if (in.readByte() == 0) {
            score = null;
        } else {
            score = in.readInt();
        }
        byte tmpIsAlbum = in.readByte();
        isAlbum = tmpIsAlbum == 0 ? null : tmpIsAlbum == 1;
        byte tmpFavorite = in.readByte();
        favorite = tmpFavorite == 0 ? null : tmpFavorite == 1;
        byte tmpNsfw = in.readByte();
        nsfw = tmpNsfw == 0 ? null : tmpNsfw == 1;
        section = in.readString();
        if (in.readByte() == 0) {
            commentCount = null;
        } else {
            commentCount = in.readInt();
        }
        if (in.readByte() == 0) {
            favoriteCount = null;
        } else {
            favoriteCount = in.readInt();
        }
        topic = in.readString();
        if (in.readByte() == 0) {
            topicId = null;
        } else {
            topicId = in.readInt();
        }
        if (in.readByte() == 0) {
            imagesCount = null;
        } else {
            imagesCount = in.readInt();
        }
        byte tmpInGallery = in.readByte();
        inGallery = tmpInGallery == 0 ? null : tmpInGallery == 1;
        byte tmpIsAd = in.readByte();
        isAd = tmpIsAd == 0 ? null : tmpIsAd == 1;
        if (in.readByte() == 0) {
            adType = null;
        } else {
            adType = in.readInt();
        }
        adUrl = in.readString();
        byte tmpInMostViral = in.readByte();
        inMostViral = tmpInMostViral == 0 ? null : tmpInMostViral == 1;
        byte tmpIncludeAlbumAds = in.readByte();
        includeAlbumAds = tmpIncludeAlbumAds == 0 ? null : tmpIncludeAlbumAds == 1;
        firstImage = in.readString();
    }

    public static final Creator<Datum> CREATOR = new Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Integer getDatetime() {
        return datetime;
    }

    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getCoverWidth() {
        return coverWidth;
    }

    public void setCoverWidth(Integer coverWidth) {
        this.coverWidth = coverWidth;
    }

    public Integer getCoverHeight() {
        return coverHeight;
    }

    public void setCoverHeight(Integer coverHeight) {
        this.coverHeight = coverHeight;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getIsAlbum() {
        return isAlbum;
    }

    public void setIsAlbum(Boolean isAlbum) {
        this.isAlbum = isAlbum;
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

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(Integer imagesCount) {
        this.imagesCount = imagesCount;
    }

    public Boolean getInGallery() {
        return inGallery;
    }

    public void setInGallery(Boolean inGallery) {
        this.inGallery = inGallery;
    }

    public Boolean getIsAd() {
        return isAd;
    }

    public void setIsAd(Boolean isAd) {
        this.isAd = isAd;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Integer getAdType() {
        return adType;
    }

    public void setAdType(Integer adType) {
        this.adType = adType;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public Boolean getInMostViral() {
        return inMostViral;
    }

    public void setInMostViral(Boolean inMostViral) {
        this.inMostViral = inMostViral;
    }

    public Boolean getIncludeAlbumAds() {
        return includeAlbumAds;
    }

    public void setIncludeAlbumAds(Boolean includeAlbumAds) {
        this.includeAlbumAds = includeAlbumAds;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public AdConfig getAdConfig() {
        return adConfig;
    }

    public void setAdConfig(AdConfig adConfig) {
        this.adConfig = adConfig;
    }

    public String getFirstImage() {
        if (images != null && images.size() > 0) {
            return images.get(0).getLink();
        }else {
            return  "";
        }
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }

    @BindingAdapter("imageUrlMed")
    public static void loadImageMed(ImageView view, String imageUrl) {
        Log.e("Image", imageUrl + "");
        Glide.with(view.getContext())
                .load(imageUrl)/*.apply(RequestOptions().circleCrop())*/
                .apply(RequestOptions.centerCropTransform())
                .override(200, 200)
                .into(view);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Log.e("Image", imageUrl + "");
        Glide.with(view.getContext())
                .load(imageUrl)/*.apply(RequestOptions().circleCrop())*/
                .apply(RequestOptions.centerCropTransform())
                .into(view);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        if (datetime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(datetime);
        }
        dest.writeString(cover);
        if (coverWidth == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(coverWidth);
        }
        if (coverHeight == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(coverHeight);
        }
        dest.writeString(accountUrl);
        if (accountId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(accountId);
        }
        dest.writeString(privacy);
        dest.writeString(layout);
        if (views == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(views);
        }
        dest.writeString(link);
        if (ups == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ups);
        }
        if (downs == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(downs);
        }
        if (points == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(points);
        }
        if (score == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(score);
        }
        dest.writeByte((byte) (isAlbum == null ? 0 : isAlbum ? 1 : 2));
        dest.writeByte((byte) (favorite == null ? 0 : favorite ? 1 : 2));
        dest.writeByte((byte) (nsfw == null ? 0 : nsfw ? 1 : 2));
        dest.writeString(section);
        if (commentCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(commentCount);
        }
        if (favoriteCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(favoriteCount);
        }
        dest.writeString(topic);
        if (topicId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(topicId);
        }
        if (imagesCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imagesCount);
        }
        dest.writeByte((byte) (inGallery == null ? 0 : inGallery ? 1 : 2));
        dest.writeByte((byte) (isAd == null ? 0 : isAd ? 1 : 2));
        if (adType == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(adType);
        }
        dest.writeString(adUrl);
        dest.writeByte((byte) (inMostViral == null ? 0 : inMostViral ? 1 : 2));
        dest.writeByte((byte) (includeAlbumAds == null ? 0 : includeAlbumAds ? 1 : 2));
        dest.writeString(firstImage);
    }
}