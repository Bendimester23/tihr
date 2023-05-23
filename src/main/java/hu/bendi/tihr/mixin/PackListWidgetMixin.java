package hu.bendi.tihr.mixin;

import net.minecraft.client.gui.screen.pack.PackListWidget;
import net.minecraft.resource.ResourcePackCompatibility;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PackListWidget.ResourcePackEntry.class)
public class PackListWidgetMixin {
    @Redirect(method = "mouseClicked", at = @At(value = "INVOKE", target = "Lnet/minecraft/resource/ResourcePackCompatibility;isCompatible()Z"))
    public boolean everythingIsCompatible(ResourcePackCompatibility instance) {
        //What could go wrong?
        return true;
    }
}
