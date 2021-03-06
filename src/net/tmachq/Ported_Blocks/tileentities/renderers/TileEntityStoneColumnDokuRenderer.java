package net.tmachq.Ported_Blocks.tileentities.renderers;

import java.io.DataInputStream;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import net.tmachq.Ported_Blocks.models.ColumnModel;


public class TileEntityStoneColumnDokuRenderer extends TileEntitySpecialRenderer {
    
    private final ColumnModel model;
    
    
    public TileEntityStoneColumnDokuRenderer() {
        this.model = new ColumnModel();
}
    
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        
            GL11.glPushMatrix();
            
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("ported_blocks:textures/texturemaps/Stone_Column_(Doku)_HD.png"));                 
            GL11.glScalef(1.0F, -1F, -1F);
            model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();

    }
    
    private void adjustLightFixture(World world, int i, int j, int k, Block block) {
        Tessellator tess = Tessellator.instance;
        float brightness = block.getBlockBrightness(world, i, j, k);
        int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
    }
    

}