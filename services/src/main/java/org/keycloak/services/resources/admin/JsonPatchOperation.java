package org.keycloak.services.resources.admin;

import java.util.Arrays;

public class JsonPatchOperation {
    public String op;
    public String path;
    public Object value;
    public String from;

    public String[] parsePath() {
        return parsePointer(path);
    }

    public String[] parseFrom() {
        return parsePointer(from);
    }

    public static String[] parsePointer(String pointer) {
        if (pointer == null || pointer.isEmpty()) {
            return null;
        } else if (pointer.equals("/")) {
            return new String[0];
        }
        return Arrays.stream(pointer.substring(1).split("/"))
                .toArray(String[]::new);
    }
}
