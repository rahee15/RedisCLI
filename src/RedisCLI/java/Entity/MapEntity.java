package RedisCLI.java.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapEntity {
    @JsonProperty
    private String key;
    @JsonProperty
    private String value;

    public MapEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
