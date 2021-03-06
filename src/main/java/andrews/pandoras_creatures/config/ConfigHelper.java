package andrews.pandoras_creatures.config;

import static andrews.pandoras_creatures.config.ConfigHolder.acidicArchvineSpawning;
import static andrews.pandoras_creatures.config.ConfigHolder.arachnonSpawning;
import static andrews.pandoras_creatures.config.ConfigHolder.bufflonSpawning;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonCurseForgeOffsetX;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonCurseForgeOffsetY;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonDiscordOffsetX;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonDiscordOffsetY;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonFadeInTime;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonPatreonOffsetX;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonPatreonOffsetY;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonTwitchOffsetX;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonTwitchOffsetY;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonYouTubeOffsetX;
import static andrews.pandoras_creatures.config.ConfigHolder.buttonYouTubeOffsetY;
import static andrews.pandoras_creatures.config.ConfigHolder.crabSpawning;
import static andrews.pandoras_creatures.config.ConfigHolder.hellhoundSpawning;
import static andrews.pandoras_creatures.config.ConfigHolder.seahorseSpawning;
import static andrews.pandoras_creatures.config.ConfigHolder.shouldButtonsInCreativeTabBeEnabled;
import static andrews.pandoras_creatures.config.ConfigHolder.shouldShowInvalidJarMessage;
import static andrews.pandoras_creatures.config.ConfigHolder.shouldShowUpdateCheckFailedMessage;
import static andrews.pandoras_creatures.config.ConfigHolder.shouldShowUpdateMessage;

import net.minecraftforge.fml.config.ModConfig;

public class ConfigHelper
{	
	public static ModConfig commonConfig;
	public static ModConfig clientConfig;

	public static void updateCommonConfig(ModConfig config)
	{
		commonConfig = config;
		
		arachnonSpawning = Config.COMMON.arachnonSpawning.get();
		hellhoundSpawning = Config.COMMON.hellhoundSpawning.get();
		crabSpawning = Config.COMMON.crabSpawning.get();
		seahorseSpawning = Config.COMMON.seahorseSpawning.get();
		acidicArchvineSpawning = Config.COMMON.acidicArchvineSpawning.get();
		bufflonSpawning = Config.COMMON.bufflonSpawning.get();
	}
	
	public static void updateClientConfig(ModConfig config)
	{
		clientConfig = config;
		
		shouldShowUpdateMessage = Config.CLIENT.shouldShowUpdateMessage.get();
		shouldShowUpdateCheckFailedMessage = Config.CLIENT.shouldShowUpdateCheckFailedMessage.get();
		shouldShowInvalidJarMessage = Config.CLIENT.shouldShowInvalidJarMessage.get();
		shouldButtonsInCreativeTabBeEnabled = Config.CLIENT.shouldButtonsInCreativeTabBeEnabled.get();
		buttonDiscordOffsetX = Config.CLIENT.buttonDiscordOffsetX.get();
		buttonDiscordOffsetY = Config.CLIENT.buttonDiscordOffsetY.get();
		buttonCurseForgeOffsetX = Config.CLIENT.buttonCurseForgeOffsetX.get();
		buttonCurseForgeOffsetY = Config.CLIENT.buttonCurseForgeOffsetY.get();
		buttonYouTubeOffsetX = Config.CLIENT.buttonYouTubeOffsetX.get();
		buttonYouTubeOffsetY = Config.CLIENT.buttonYouTubeOffsetY.get();
		buttonTwitchOffsetX = Config.CLIENT.buttonTwitchOffsetX.get();
		buttonTwitchOffsetY = Config.CLIENT.buttonTwitchOffsetY.get();
		buttonPatreonOffsetX = Config.CLIENT.buttonPatreonOffsetX.get();
		buttonPatreonOffsetY = Config.CLIENT.buttonPatreonOffsetY.get();
		buttonFadeInTime = Config.CLIENT.buttonFadeInTime.get();
	}
}