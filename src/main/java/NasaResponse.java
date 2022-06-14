import com.fasterxml.jackson.annotation.JsonProperty;

public class NasaResponse {
    private final String copyright;
    private final String date;
    private final String explanation;
    private final String hdUrl;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;
    public NasaResponse(
            @JsonProperty("copyright")       String copyright,
            @JsonProperty("date")            String date,
            @JsonProperty("explanation")     String explanation,
            @JsonProperty("hdurl")           String hdUrl,
            @JsonProperty("media_type")      String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title")           String title,
            @JsonProperty("url")             String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdUrl = hdUrl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return  "copyright: " + copyright +
                "\ndate: " + date +
                "\nexplanation: " + explanation +
                "\nhdurl: " + hdUrl +
                "\nmedia_type: " + mediaType +
                "\nservice_version: " + serviceVersion +
                "\ntitle: " + title +
                "\nurl: " + url;
    }
}
