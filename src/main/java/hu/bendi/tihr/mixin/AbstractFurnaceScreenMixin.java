package hu.bendi.tihr.mixin;

import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AbstractFurnaceScreen.class)
public abstract class AbstractFurnaceScreenMixin<T extends AbstractFurnaceScreenHandler> extends HandledScreen<T> {
    @Shadow private boolean narrow;

    public AbstractFurnaceScreenMixin(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public void init() {
        super.init();
        this.narrow = this.width < 379;
        this.x = (this.width - this.backgroundWidth) / 2;
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }


    /**
     * @author Bendi
     * @reason yes
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
        return  super.mouseClicked(mouseX, mouseY, button);
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
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return super.keyPressed(keyCode, scanCode, modifiers);
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
    public boolean charTyped(char chr, int modifiers) {
        return super.charTyped(chr, modifiers);
    }

    /**
     * @author Bendi
     * @reason yes
     */
    @Overwrite
    public void refreshRecipeBook() {

    }
}
