package hu.bendi.tihr;

import net.minecraft.client.util.telemetry.TelemetrySender;
import net.minecraft.client.util.telemetry.WorldSession;
import net.minecraft.world.GameMode;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;

public class FakeWorldSession extends WorldSession {
    public FakeWorldSession(TelemetrySender sender, boolean newWorld, @Nullable Duration worldLoadTime) {
        super(sender, newWorld, worldLoadTime);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void setTick(long tick) {

    }

    @Override
    public void setBrand(String brand) {

    }

    @Override
    public void setGameMode(GameMode gameMode, boolean hardcore) {

    }

    @Override
    public void onUnload() {

    }
}
