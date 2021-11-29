package io.github.kabanfriends.craftgr.handler;

import io.github.kabanfriends.craftgr.CraftGR;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

public class KeyActionHandler {

    public static void toggleMute() {
        if (CraftGR.MC.screen == null) {
            AudioPlayerHandler handler = AudioPlayerHandler.getInstance();

            handler.player.muted = !AudioPlayerHandler.getInstance().player.muted;
            if (handler.player.muted) {
                TextComponent icon = new TextComponent("❌ ");
                icon.withStyle(ChatFormatting.RED);
                TranslatableComponent message = new TranslatableComponent("text.craftgr.message.muted");
                message.withStyle(ChatFormatting.WHITE);

                CraftGR.MC.player.displayClientMessage(icon.append(message), true);
            }else {
                TextComponent icon = new TextComponent("♫ ");
                icon.withStyle(ChatFormatting.GREEN);
                TranslatableComponent message = new TranslatableComponent("text.craftgr.message.unmuted");
                message.withStyle(ChatFormatting.WHITE);

                CraftGR.MC.player.displayClientMessage(icon.append(message), true);
            }

            handler.player.setVolume(1.0F);
        }
    }

}