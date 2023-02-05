package hu.bendi.tihr.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(RecipeBookWidget.class)
public class RecipeBookWidgetMixin {

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public void initialize(int parentWidth, int parentHeight, MinecraftClient client, boolean narrow, AbstractRecipeScreenHandler<?> craftingScreenHandler) {

    }

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public void reset() {

    }

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public boolean isOpen() {
        return false;
    }

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public int findLeftEdge(int width, int backgroundWidth) {
        return 0;
    }

    /**
     * @author Bendi
     * @reason Don't crash
     */
    @Overwrite
    public void update() {

    }
}
