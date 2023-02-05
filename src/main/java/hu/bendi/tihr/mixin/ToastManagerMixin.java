package hu.bendi.tihr.mixin;

import net.minecraft.client.toast.RecipeToast;
import net.minecraft.client.toast.Toast;
import net.minecraft.client.toast.ToastManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Deque;

@Mixin(ToastManager.class)
public class ToastManagerMixin {

    @Shadow @Final private Deque<Toast> toastQueue;

    /**
     * @author Bendi
     * @reason Never ever show a recipe toast
     */
    @Overwrite
    public void add(Toast toast) {
        if (toast instanceof RecipeToast) {
            return;
        }
        this.toastQueue.add(toast);
    }
}
