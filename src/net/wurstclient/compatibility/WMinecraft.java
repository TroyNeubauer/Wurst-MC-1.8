package net.wurstclient.compatibility;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;

public final class WMinecraft
{
	public static final String VERSION = "1.8";
	public static final boolean REALMS = false;
	public static final boolean COOLDOWN = false;
	
	public static final NavigableMap<Integer, String> PROTOCOLS;
	static
	{
		TreeMap<Integer, String> protocols = new TreeMap<>();
		protocols.put(47, "1.8");
		PROTOCOLS = Collections.unmodifiableNavigableMap(protocols);
	}
	
	private static final Minecraft mc = Minecraft.getMinecraft();
	
	public static EntityPlayerSP getPlayer()
	{
		return mc.thePlayer;
	}
	
	public static WorldClient getWorld()
	{
		return mc.theWorld;
	}
}
