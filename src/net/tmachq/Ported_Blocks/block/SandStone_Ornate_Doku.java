package net.tmachq.Ported_Blocks.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class SandStone_Ornate_Doku extends Block {

    public SandStone_Ornate_Doku(int par1, Material par2Material) {
        super(par1, par2Material);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        this.blockIcon = iconReg.registerIcon("Ported_Blocks:SandStone_Ornate_(Doku)");
    }

}