package hu.bendi.tihr.mixin;

import hu.bendi.tihr.Tihr;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.tutorial.TutorialStep;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Mixin(GameOptions.class)
public abstract class GameOptionsMixin {
    @Shadow public boolean skipMultiplayerWarning;

    @Shadow public TutorialStep tutorialStep;

    @Shadow @Final private SimpleOption<Boolean> autoJump;

    @Shadow @Final private SimpleOption<Integer> guiScale;

    @Shadow public abstract void setSoundVolume(SoundCategory category, float volume);

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init$skipMultiplayerDisclaimer(MinecraftClient client, File optionsFile, CallbackInfo ci) {
        this.skipMultiplayerWarning = true;
        this.tutorialStep = TutorialStep.NONE;
        this.guiScale.setValue(2);
        try {
            if (new File(client.runDirectory, "tihr-ran-before").createNewFile()) {
                this.autoJump.setValue(false);
                this.setSoundVolume(SoundCategory.MUSIC, 0.0f);
            }
        } catch (IOException e) {
            Tihr.LOGGER.error("Failed to create file {}.", e.getMessage());
        }
    }
}
