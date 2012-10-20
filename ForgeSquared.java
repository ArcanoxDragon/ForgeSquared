package com.forgesquared;

import java.lang.reflect.Field;
import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.IRecipe;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = "ForgeSquared", modid = "ForgeSquared", version = "1.0", useMetadata = true)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ForgeSquared
{
	@Instance("ForgeSquared")
	public static ForgeSquared instance;
	@SidedProxy(serverSide = "com.forgesquared.CommonProxy", clientSide = "com.forgesquared.client.ClientProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();

		// do loading here

		config.save();
	}
	
	@Init
	public void init(FMLInitializationEvent e)
	{
		
	}

	public static void removeRecipeFor(int idToRemove)
	{
		CraftingManager cm = CraftingManager.getInstance();
		try
		{
			Field f = cm.getClass().getDeclaredField("recipes");
			f.setAccessible(true);
			ArrayList<IRecipe> recipes = (ArrayList<IRecipe>) f.get(cm);

			if (recipes != null)
			{
				for (int i = 0; i < recipes.size(); i++)
				{
					IRecipe recipe = recipes.get(i);
					if (recipe.getRecipeOutput().itemID == idToRemove)
					{
						synchronized(recipes)
						{
							recipes.remove(i);
						}
					}
				}
			}
		}
		catch (NoSuchFieldException e1)
		{
			e1.printStackTrace();
		}
		catch (SecurityException e1)
		{
			e1.printStackTrace();
		}
		catch (IllegalArgumentException e1)
		{
			e1.printStackTrace();
		}
		catch (IllegalAccessException e1)
		{
			e1.printStackTrace();
		}
	}
}
