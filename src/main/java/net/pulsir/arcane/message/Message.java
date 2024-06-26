package net.pulsir.arcane.message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.pulsir.arcane.message.type.MessageType;
import org.bukkit.ChatColor;

public class Message {

    private final MessageType messageType;

    public Message(String string) {
        if (string.equalsIgnoreCase("legacy")) {
            messageType = MessageType.LEGACY;
        } else if (string.equalsIgnoreCase("modern")) {
            messageType = MessageType.COMPONENT;
        } else {
            messageType = MessageType.LEGACY;
        }
    }

    public Component getMessage(String message) {
        if (messageType.equals(MessageType.LEGACY)) {
            return LegacyComponentSerializer.legacyAmpersand().deserializeOr(message, Component.empty());
        } else if (messageType.equals(MessageType.COMPONENT)) {
            return MiniMessage.miniMessage().deserialize(message);
        }

        return MiniMessage.miniMessage().deserialize(message);
    }

    public String getComponent(Component component) {
        if (messageType.equals(MessageType.LEGACY)) {
            return LegacyComponentSerializer.legacyAmpersand().serialize(component);
        } else if (messageType.equals(MessageType.COMPONENT)) {
            return MiniMessage.miniMessage().serialize(component);
        }

        return LegacyComponentSerializer.legacyAmpersand().serialize(component);
    }

    @SuppressWarnings("ALL") // Deprecated
    public String forceLegacy(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}