package net.tmachq.Ported_Blocks.tileentities.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.tmachq.Ported_Blocks.Ported_Blocks;
import net.tmachq.Ported_Blocks.tileentities.entities.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityBarStool extends BlockContainer {
    
    public TileEntityBarStool(int id) {
        super(id, Material.wood);
        this.setHardness(3.0F);
        this.setCreativeTab(Ported_Blocks.Ported_Blocks_Tab);
        this.setLightOpacity(0);
        this.setBlockBounds(.15F, 0F, .15F, .85F, .71F, .85F);
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
            return new TileEntityBarStoolEntity();
    }
    
    @Override
    public int getRenderType() {
            return -1;
    }
    
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public void registerIcons(IconRegister icon) {
        this.blockIcon = icon.registerIcon("Ported_Blocks:BarStool");
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
        int blockSet = world.getBlockMetadata(x, y, z) / 4;
        int direction = MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        int newMeta = (blockSet * 4) + direction;
        world.setBlockMetadataWithNotify(x, y, z, newMeta, 0);
    }
    
}
