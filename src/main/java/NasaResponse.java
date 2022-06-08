import com.fasterxml.jackson.annotation.JsonProperty;

public class NasaResponse {
    private final String copyright;         // ?????????????
    private final String date;              //"date": "2020-07-17",
    private final String explanation;       //"explanation": "After local midnight on July 14 comet NEOWISE was still above the horizon for Goldenrod, Alberta, Canada, just north of Calgary, planet Earth. In this snapshot it makes for an awesome night with dancing displays of the northern lights. The long-tailed comet and auroral displays are beautiful apparitions in the north these days. Both show the influence of spaceweather and the wind from the Sun. Skygazers have widely welcomed the visitor from the Oort cloud, though C/2020 F3 (NEOWISE) is in an orbit that is now taking it out of the inner Solar System.  Comet NEOWISE Images: July 16 | July 15 | July 14 | July 13 | July 12 | July 11 | July 10 & earlier",
    private final String hdurl;             //"hdurl": "https://apod.nasa.gov/apod/image/2007/DSC1028_PetersNEOWISEAuroralSpike.jpg",
    private final String media_type;        //"media_type": "image",
    private final String service_version;   //"service_version": "v1",
    private final String title;             //"title": "NEOWISE of the North",
    private final String url;               //"url": "https://apod.nasa.gov/apod/image/2007/DSC1028_PetersNEOWISEAuroralSpike_800.jpg"
    public NasaResponse(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
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
                "\nhdurl: " + hdurl +
                "\nmedia_type: " + media_type +
                "\nservice_version: " + service_version +
                "\ntitle: " + title +
                "\nurl: " + url;
    }
}
