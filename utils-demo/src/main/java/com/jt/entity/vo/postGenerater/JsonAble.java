package com.jt.entity.vo.postGenerater;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonAble implements JsonableInterface {

    @Override
    public String toString() {
        String str = this.toJson();
        return str != null ? str : super.toString();
    }

    @Override
    public String toJson() {
        try {
            return (new ObjectMapper()).writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
