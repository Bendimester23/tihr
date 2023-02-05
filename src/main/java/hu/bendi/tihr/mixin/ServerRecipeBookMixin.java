package hu.bendi.tihr.mixin;

import com.google.common.collect.Lists;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.UnlockRecipesS2CPacket;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerRecipeBook;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Mixin(ServerRecipeBook.class)
public class ServerRecipeBookMixin {

    /**
     * @author Bendi
     * @reason I don't need that
     */
    @Overwrite
    public int unlockRecipes(Collection<Recipe<?>> recipes, ServerPlayerEntity player) {
        return 0;
    }

    /**
     * @author Bendi
     * @reason Don't need that either
     */
    @Overwrite
    public int lockRecipes(Collection<Recipe<?>> recipes, ServerPlayerEntity player) {
        return 0;
    }

    /**
     * @author Bendi
     * @reason Useless
     */
    @Overwrite
    public NbtCompound toNbt() {
        return new NbtCompound();
    }

    /**
     * @author Bendi
     * @reason Why?
     */
    @Overwrite
    public void readNbt(NbtCompound nbt, RecipeManager recipeManager) {

    }
}
