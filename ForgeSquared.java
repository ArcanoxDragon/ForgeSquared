package com.forgesquared;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name="ForgeSquared", modid="ForgeSquared", version="1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ForgeSquared
{
	@Instance("ForgeSquared")
	public static ForgeSquared instance;
	@SidedProxy(serverSide="com.forgesquared.CommonProxy")
	public static CommonProxy proxy;
}
