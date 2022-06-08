import com.fasterxml.jackson.annotation.JsonProperty;

public class CatsInfo {
    private final String id;       // "id": "5b4910ae0508220014ccfe90",
    private final String text;   // "text": "Кошки могут слышать ультразвук и коммуницировать с дельфинами.",
    private final String type;   // "type": "cat",
    private final String user;    // "user": "Alex Petrov",
    private final String upvotes; // "upvotes": 12

    public CatsInfo(
            @JsonProperty("id") String id,       // "id": "5b4910ae0508220014ccfe90",
            @JsonProperty("text") String text,   // "text": "Кошки могут слышать ультразвук и коммуницировать с дельфинами.",
            @JsonProperty("type") String type,   // "type": "cat",
            @JsonProperty("user") String user,    // "user": "Alex Petrov",
            @JsonProperty("upvotes") String upvotes // "upvotes": 12
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getText() {
        return text;
    }

    public String getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return
                "id" + id + "\n" +
                        "text: " + text + "\n" +
                        "type: " + type + "\n" +
                        "user: " + user + "\n" +
                        "upvotes: " + upvotes + "\n";


    }
}
