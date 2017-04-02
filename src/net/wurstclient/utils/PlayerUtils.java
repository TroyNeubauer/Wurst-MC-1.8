/*
 * Copyright � 2014 - 2017 | Wurst-Imperium | All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.wurstclient.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3d;
import net.wurstclient.compatibility.WMinecraft;

public class PlayerUtils
{
	private static final Minecraft mc = Minecraft.getMinecraft();
	
	public static void swingArmClient()
	{
		WMinecraft.getPlayer().swingArm();
	}
	
	public static void swingArmPacket()
	{
		WMinecraft.getPlayer().connection.sendPacket(new CPacketAnimation());
	}
	
	public static float getCooldown()
	{
		return 1;
	}
	
	public static void processRightClick()
	{
		mc.playerController.processRightClick(WMinecraft.getPlayer(),
			WMinecraft.getWorld(),
			WMinecraft.getPlayer().getCurrentEquippedItem());
	}
	
	static void processRightClickBlock(BlockPos pos, EnumFacing side,
		Vec3d hitVec)
	{
		mc.playerController.processRightClickBlock(WMinecraft.getPlayer(),
			WMinecraft.getWorld(),
			WMinecraft.getPlayer().getCurrentEquippedItem(), pos, side, hitVec);
	}
	
	public static void addPotionEffect(Potion potion)
	{
		WMinecraft.getPlayer()
			.addPotionEffect(new PotionEffect(potion.getId(), 10801220));
	}
	
	public static void removePotionEffect(Potion potion)
	{
		WMinecraft.getPlayer().removePotionEffect(potion.getId());
	}
}
