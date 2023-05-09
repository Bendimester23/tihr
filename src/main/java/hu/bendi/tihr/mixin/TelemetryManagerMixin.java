package hu.bendi.tihr.mixin;

import net.minecraft.client.util.telemetry.TelemetryManager;
import net.minecraft.client.util.telemetry.TelemetrySender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(TelemetryManager.class)
public class TelemetryManagerMixin {

    /**
     * @author Bendi
     * @reason Telemetry bad
     */
    @Overwrite
    private TelemetrySender getSender() {
        return TelemetrySender.NOOP;
    }
}
