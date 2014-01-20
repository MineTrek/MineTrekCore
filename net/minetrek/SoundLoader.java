package net.minetrek;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundLoader {

	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) {

		String[] soundFiles = { "phaser1.wav", "disruptor1.wav" };
		for (int i = 0; i < soundFiles.length; i++) {
			event.manager.soundPoolSounds.addSound("minetrek:" + soundFiles[i]);
		}
	}

}
