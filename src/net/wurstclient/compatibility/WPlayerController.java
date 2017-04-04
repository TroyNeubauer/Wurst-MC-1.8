/*
 * Copyright � 2014 - 2017 | Wurst-Imperium | All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.wurstclient.compatibility;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3d;

public final class WPlayerController
{
	private static PlayerControllerMP getPlayerController()
	{
		return Minecraft.getMinecraft().playerController;
	}
	
	public static void processRightClick()
	{
		getPlayerController().processRightClick(WMinecraft.getPlayer(),
			WMinecraft.getWorld(),
			WMinecraft.getPlayer().getCurrentEquippedItem());
	}
	
	public static void processRightClickBlock(BlockPos pos, EnumFacing side,
		Vec3d hitVec)
	{
		getPlayerController().processRightClickBlock(WMinecraft.getPlayer(),
			WMinecraft.getWorld(),
			WMinecraft.getPlayer().getCurrentEquippedItem(), pos, side, hitVec);
	}
}
