package RedisCLI.java.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ZsetEntity implements Serializable, Comparable {
    @JsonProperty
    private String key;
    @JsonProperty
    private Integer value;

    public ZsetEntity() {
    }

    public ZsetEntity(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Override
    public int compareTo(Object o) {
        return getValue() - (((ZsetEntity) o).getValue());

    }
}
