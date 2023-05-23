package hu.bendi.tihr.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.util.telemetry.TelemetrySender;
import net.minecraft.network.packet.s2c.play.ServerMetadataS2CPacket;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @Redirect(method = "onServerMetadata", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/packet/s2c/play/ServerMetadataS2CPacket;isSecureChatEnforced()Z"))
    public boolean disableInsecurePopup(ServerMetadataS2CPacket instance) {
        //Very secure indeed
        return true;
    }

    @Redirect(method = "onGameJoin", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/telemetry/TelemetrySender;setGameModeAndSend(Lnet/minecraft/world/GameMode;Z)V"))
    public void dontSendTelemetry(TelemetrySender instance, GameMode gameMode, boolean hardcore) {
        //Don't do anything
    }

    @Redirect(method = "onDisconnected", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/telemetry/TelemetrySender;send()V"))
    public void dontSendTelemetry2(TelemetrySender instance) {
        //Don't do anything
    }

    @Redirect(method = "onCustomPayload", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/telemetry/TelemetrySender;setServerBrandAndSend(Ljava/lang/String;)V"))
    public void dontSendTelemetry3(TelemetrySender instance, String brand) {
        //Don't do anything
    }
}
