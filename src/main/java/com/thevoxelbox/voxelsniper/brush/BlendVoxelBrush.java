/*
 * This file is part of VoxelSniper, licensed under the MIT License (MIT).
 *
 * Copyright (c) The VoxelBox <http://thevoxelbox.com>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.thevoxelbox.voxelsniper.brush;

import com.thevoxelbox.voxelsniper.SnipeData;
import org.spongepowered.api.text.format.TextColors;

/**
 * http://www.voxelwiki.com/minecraft/Voxelsniper#Blend_Brushes
 */
public class BlendVoxelBrush extends BlendBrushBase {

    /**
     *
     */
    public BlendVoxelBrush() {
        this.setName("Blend Voxel");
    }

    @SuppressWarnings("deprecation")
    @Override
    protected final void blend(final SnipeData v) {
        // @Spongify
//        final int brushSize = v.getBrushSize();
//        final int brushSizeDoubled = 2 * brushSize;
//        // Array that holds the original materials plus a buffer
//        final int[][][] oldMaterials = new int[2 * (brushSize + 1) + 1][2 * (brushSize + 1) + 1][2 * (brushSize + 1) + 1];
//        // Array that holds the blended materials
//        final int[][][] newMaterials = new int[brushSizeDoubled + 1][brushSizeDoubled + 1][brushSizeDoubled + 1];
//
//        // Log current materials into oldmats
//        for (int x = 0; x <= 2 * (brushSize + 1); x++)
//        {
//            for (int y = 0; y <= 2 * (brushSize + 1); y++)
//            {
//                for (int z = 0; z <= 2 * (brushSize + 1); z++)
//                {
//                    oldMaterials[x][y][z] = this.getBlockIdAt(this.getTargetBlock().getX() - brushSize - 1 + x, this.getTargetBlock().getY() - brushSize - 1 + y, this.getTargetBlock().getZ() - brushSize - 1 + z);
//                }
//            }
//        }
//
//        // Log current materials into newmats
//        for (int x = 0; x <= brushSizeDoubled; x++)
//        {
//            for (int y = 0; y <= brushSizeDoubled; y++)
//            {
//                for (int z = 0; z <= brushSizeDoubled; z++)
//                {
//                    newMaterials[x][y][z] = oldMaterials[x + 1][y + 1][z + 1];
//                }
//            }
//        }
//
//        // Blend materials
//        for (int x = 0; x <= brushSizeDoubled; x++)
//        {
//            for (int y = 0; y <= brushSizeDoubled; y++)
//            {
//                for (int z = 0; z <= brushSizeDoubled; z++)
//                {
//                    final int[] materialFrequency = new int[BlendBrushBase.getMaxBlockMaterialID() + 1]; // Array that tracks frequency of materials neighboring given block
//                    int modeMatCount = 0;
//                    int modeMatId = 0;
//                    boolean tiecheck = true;
//
//                    for (int m = -1; m <= 1; m++)
//                    {
//                        for (int n = -1; n <= 1; n++)
//                        {
//                            for (int o = -1; o <= 1; o++)
//                            {
//                                if (!(m == 0 && n == 0 && o == 0))
//                                {
//                                    materialFrequency[oldMaterials[x + 1 + m][y + 1 + n][z + 1 + o]]++;
//                                }
//                            }
//                        }
//                    }
//
//                    // Find most common neighboring material.
//                    for (int i = 0; i <= BlendBrushBase.getMaxBlockMaterialID(); i++)
//                    {
//                        if (materialFrequency[i] > modeMatCount && !(this.excludeAir && i == Material.AIR.getId()) && !(this.excludeWater && (i == Material.WATER.getId() || i == Material.STATIONARY_WATER.getId())))
//                        {
//                            modeMatCount = materialFrequency[i];
//                            modeMatId = i;
//                        }
//                    }
//                    // Make sure there'world not a tie for most common
//                    for (int i = 0; i < modeMatId; i++)
//                    {
//                        if (materialFrequency[i] == modeMatCount && !(this.excludeAir && i == Material.AIR.getId()) && !(this.excludeWater && (i == Material.WATER.getId() || i == Material.STATIONARY_WATER.getId())))
//                        {
//                            tiecheck = false;
//                        }
//                    }
//
//                    // Record most common neighbor material for this block
//                    if (tiecheck)
//                    {
//                        newMaterials[x][y][z] = modeMatId;
//                    }
//                }
//            }
//        }
//
//        final Undo undo = new Undo();
//
//        // Make the changes
//        for (int x = brushSizeDoubled; x >= 0; x--)
//        {
//            for (int y = 0; y <= brushSizeDoubled; y++)
//            {
//                for (int z = brushSizeDoubled; z >= 0; z--)
//                {
//                    if (!(this.excludeAir && newMaterials[x][y][z] == Material.AIR.getId()) && !(this.excludeWater && (newMaterials[x][y][z] == Material.WATER.getId() || newMaterials[x][y][z] == Material.STATIONARY_WATER.getId())))
//                    {
//                        if (this.getBlockIdAt(this.getTargetBlock().getX() - brushSize + x, this.getTargetBlock().getY() - brushSize + y, this.getTargetBlock().getZ() - brushSize + z) != newMaterials[x][y][z])
//                        {
//                            undo.put(this.clampY(this.getTargetBlock().getX() - brushSize + x, this.getTargetBlock().getY() - brushSize + y, this.getTargetBlock().getZ() - brushSize + z));
//                        }
//                        this.setBlockIdAt(this.getTargetBlock().getZ() - brushSize + z, this.getTargetBlock().getX() - brushSize + x, this.getTargetBlock().getY() - brushSize + y, newMaterials[x][y][z]);
//
//                    }
//                }
//            }
//        }
//        v.owner().storeUndo(undo);
    }

    @Override
    public final void parameters(final String[] par, final SnipeData v) {
        if (par[1].equalsIgnoreCase("info")) {
            v.sendMessage(TextColors.GOLD, "Blend Voxel Parameters:");
            v.sendMessage(TextColors.AQUA, "/b bv water -- toggle include or exclude (default) water");
            return;
        }

        super.parameters(par, v);
    }

    @Override
    public String getPermissionNode() {
        return "voxelsniper.brush.blendvoxel";
    }
}
