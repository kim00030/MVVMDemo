package mvvmdemo.dankim.com.mvvmdemo.models;

/**
 * Created by Dan Kim on 2019-01-16
 */
public class NicePlace {

    private String title;
    private String imageUrl;

    public NicePlace(String title, String imageUrl) {

        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
