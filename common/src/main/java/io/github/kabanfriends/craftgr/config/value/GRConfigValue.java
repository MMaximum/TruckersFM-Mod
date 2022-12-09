package io.github.kabanfriends.craftgr.config.value;

import com.google.gson.JsonPrimitive;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.FieldBuilder;

public abstract class GRConfigValue<T> {

    private String key;

    private T defaultValue;
    private T value;

    public GRConfigValue(String key, T value) {
        this.key = key;
        this.defaultValue = value;
        this.value = value;
    }

    public abstract T deserialize(JsonPrimitive jsonValue);

    public abstract JsonPrimitive serialize();

    public abstract FieldBuilder getBuilder(ConfigEntryBuilder builder);

    @SuppressWarnings("unchecked")
    public void setValue(Object value) {
        this.value = (T) value;
    }

    public T getValue() {
        return value;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public String getKey() {
        return key;
    }
}