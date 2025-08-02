package hu.bendi.tihr.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.pack.PackListWidget;
import net.minecraft.client.gui.screen.pack.ResourcePackOrganizer;
import net.minecraft.client.gui.widget.AlwaysSelectedEntryListWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PackListWidget.ResourcePackEntry.class)
public abstract class ResourcePackEntryMixin extends AlwaysSelectedEntryListWidget.Entry<PackListWidget.ResourcePackEntry> {

    @Shadow @Final private ResourcePackOrganizer.Pack pack;

    /**
     * @author Bendi
     * @reason don't need to ask
     */
    @Overwrite
    private boolean enable() {
        this.pack.enable();
        return true;
    }
}
