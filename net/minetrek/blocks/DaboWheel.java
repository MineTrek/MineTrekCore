package MineTrekCore.net.minetrek.blocks;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class DaboWheel extends Block
{

	public DaboWheel(int par1) {
		super(par1, Material.iron);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("DaboWheel");
		setTextureName("minetrek:DaboWheel");
		LanguageRegistry.addName(this, "DaboWheel");
		this.setResistance(500.0F);
		}

}
