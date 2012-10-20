package com.forgesquared.client;

import net.minecraftforge.client.MinecraftForgeClient;

import com.forgesquared.CommonProxy;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderers()
	{
		MinecraftForgeClient.preloadTexture(TERRAIN_PNG);
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
	}
}
