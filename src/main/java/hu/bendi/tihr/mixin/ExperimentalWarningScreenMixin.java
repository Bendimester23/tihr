package hu.bendi.tihr.mixin;

import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.gui.screen.pack.ExperimentalWarningScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

@Mixin(ExperimentalWarningScreen.class)
public class ExperimentalWarningScreenMixin {
    @SuppressWarnings("rawtypes")
    @Inject(method = "<init>", at = @At("TAIL"))
    public void init$skipExperimentalWarning(Collection enabledProfiles, BooleanConsumer callback, CallbackInfo ci) {
        callback.accept(true);
    }
}
