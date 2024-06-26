package net.pulsir.arcane.message.type;

public enum MessageType {

    LEGACY("Legacy"), COMPONENT("Component");

    final String name;

    MessageType(String name) {
        this.name = name;
    }
}