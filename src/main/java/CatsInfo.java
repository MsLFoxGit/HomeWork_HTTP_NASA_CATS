import com.fasterxml.jackson.annotation.JsonProperty;

public class CatsInfo {
    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final String upVotes;

    public CatsInfo(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") String upVotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upVotes = upVotes;
    }

    public String getText() {
        return text;
    }

    public String getUpVotes() {
        return upVotes;
    }

    @Override
    public String toString() {
        return
                "id" + id + "\n" +
                        "text: " + text + "\n" +
                        "type: " + type + "\n" +
                        "user: " + user + "\n" +
                        "upvotes: " + upVotes + "\n";
    }
}
