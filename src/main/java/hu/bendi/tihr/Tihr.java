package hu.bendi.tihr;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tihr implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("TIHR");

    @Override
    public void onInitialize() {
        LOGGER.info("Started.");
    }
}
