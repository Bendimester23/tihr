package hu.bendi.tihr.mixin;

import net.minecraft.client.tutorial.TutorialManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(TutorialManager.class)
public class TutorialManagerMixin {

    /**
     * @author Bendi
     * @reason Tutorials are disabled.
     */
    @Overwrite
    public void tick() {

    }
}
