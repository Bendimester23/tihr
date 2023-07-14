package hu.bendi.tihr.mixin;

import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CraftingScreen.class)
public abstract class CraftingScreenMixin extends HandledScreen<CraftingScreenHandler> {
    @Shadow private boolean narrow;

    public CraftingScreenMixin(CraftingScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    /**
     * @author Bendi
     * @reason Simplify
     */
    @Overwrite
    public void init() {
        super.init();
        this.narrow = this.width < 379;
        this.x = (this.width - this.backgroundWidth) / 2;
        this.titleX = 29;
    }

    /**
     * @author Bendi
     * @reason no recipe book
     */
    @Overwrite
    public void handledScreenTick() {
        super.handledScreenTick();
    }

    /**
     * @author Bendi
     * @reason Simplify
     */
    @Overwrite
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return super.mouseClicked(mouseX, mouseY, button);
    }

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public boolean isClickOutsideBounds(double mouseX, double mouseY, int left, int top, int button) {
        return mouseX < (double)left || mouseY < (double)top || mouseX >= (double)(left + this.backgroundWidth) || mouseY >= (double)(top + this.backgroundHeight);
    }

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public void onMouseClick(Slot slot, int slotId, int button, SlotActionType actionType) {
        super.onMouseClick(slot, slotId, button, actionType);
    }

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public void refreshRecipeBook() {

    }

    /**
     * @author Bendi
     * @reason the game crashes without this
     */
    @Overwrite
    public void removed() {
        super.removed();
    }
}
