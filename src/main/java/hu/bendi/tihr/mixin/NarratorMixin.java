package hu.bendi.tihr.mixin;

import com.mojang.text2speech.Narrator;
import hu.bendi.tihr.NarratorDummy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = Narrator.class, remap = false)
public interface NarratorMixin {

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    static Narrator getNarrator() {
        return new NarratorDummy();
    }
}
