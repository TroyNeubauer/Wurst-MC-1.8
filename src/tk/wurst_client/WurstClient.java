/*
 * Copyright � 2014 - 2017 | Wurst-Imperium | All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

import tk.wurst_client.analytics.AnalyticsManager;
import tk.wurst_client.events.EventManager;
import tk.wurst_client.features.commands.CmdManager;
import tk.wurst_client.features.mods.ModManager;
import tk.wurst_client.features.special_features.SpfManager;
import tk.wurst_client.files.ConfigFiles;
import tk.wurst_client.files.FileManager;
import tk.wurst_client.files.WurstFolders;
import tk.wurst_client.font.Fonts;
import tk.wurst_client.hooks.FrameHook;
import tk.wurst_client.navigator.Navigator;
import tk.wurst_client.options.FriendsList;
import tk.wurst_client.options.KeybindManager;
import tk.wurst_client.options.OptionsManager;
import tk.wurst_client.update.Updater;

public enum WurstClient
{
	INSTANCE;
	
	public static final String VERSION = "2.28";
	public static final String MINECRAFT_VERSION = "1.8";
	
	public static final NavigableMap<Integer, String> PROTOCOLS;
	static
	{
		TreeMap<Integer, String> protocols = new TreeMap<>();
		protocols.put(47, "1.8");
		PROTOCOLS = Collections.unmodifiableNavigableMap(protocols);
	}
	
	public static final boolean ENABLE_REALMS = false;
	
	public AnalyticsManager analytics;
	public CmdManager commands;
	public EventManager events;
	public FileManager files;
	public FriendsList friends;
	public ModManager mods;
	public Navigator navigator;
	public KeybindManager keybinds;
	public OptionsManager options;
	public SpfManager special;
	public Updater updater;
	
	private boolean enabled = true;
	
	public void startClient()
	{
		events = new EventManager();
		mods = new ModManager();
		commands = new CmdManager();
		special = new SpfManager();
		files = new FileManager();
		updater = new Updater();
		keybinds = new KeybindManager();
		options = new OptionsManager();
		friends = new FriendsList();
		navigator = new Navigator();
		
		WurstFolders.initialize();
		ConfigFiles.initialize();
		files.init();
		
		navigator.sortFeatures();
		Fonts.loadFonts();
		updater.checkForUpdate();
		analytics =
			new AnalyticsManager("UA-52838431-5", "client.wurstclient.net");
		ConfigFiles.OPTIONS.save();
		
		FrameHook.maximize();
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}
	
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
		if(!enabled)
		{
			mods.panicMod.setEnabled(true);
			mods.panicMod.onUpdate();
		}
	}
}
