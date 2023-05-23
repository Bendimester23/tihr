package hu.bendi.tihr.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.telemetry.TelemetrySender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    /**
     * @author Bendi
     * @reason we don't need telemetry
     */
    @Overwrite
    public TelemetrySender createTelemetrySender() {
        return null;
    }
}
