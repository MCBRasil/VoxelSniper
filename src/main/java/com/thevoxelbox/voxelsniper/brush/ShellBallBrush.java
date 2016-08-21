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

import com.thevoxelbox.voxelsniper.Message;
import com.thevoxelbox.voxelsniper.SnipeData;

/**
 * THIS BRUSH SHOULD NOT USE PERFORMERS.
 * http://www.voxelwiki.com/minecraft/Voxelsniper#Shell_Brushes
 *
 * @author Voxel
 */
public class ShellBallBrush extends Brush {

    public ShellBallBrush() {
        this.setName("Shell Ball");
    }

    // @Spongify
//    private void bShell(final SnipeData v, Block targetBlock)
//    {
//        final int brushSize = v.getBrushSize();
//        final int brushSizeDoubled = 2 * brushSize;
//        final int[][][] oldMaterials = new int[2 * (brushSize + 1) + 1][2 * (brushSize + 1) + 1][2 * (brushSize + 1) + 1]; // Array that holds the original materials plus a buffer
//        final int[][][] newMaterials = new int[brushSizeDoubled + 1][brushSizeDoubled + 1][brushSizeDoubled + 1]; // Array that holds the hollowed materials
//
//        int blockPositionX = targetBlock.getX();
//        int blockPositionY = targetBlock.getY();
//        int blockPositionZ = targetBlock.getZ();
//        // Log current materials into oldmats
//        for (int x = 0; x <= 2 * (brushSize + 1); x++)
//        {
//            for (int y = 0; y <= 2 * (brushSize + 1); y++)
//            {
//                for (int z = 0; z <= 2 * (brushSize + 1); z++)
//                {
//                    oldMaterials[x][y][z] = this.getBlockIdAt(blockPositionX - brushSize - 1 + x, blockPositionY - brushSize - 1 + y, blockPositionZ - brushSize - 1 + z);
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
//        int temp;
//
//        // Hollow Brush Area
//        for (int x = 0; x <= brushSizeDoubled; x++)
//        {
//            for (int y = 0; y <= brushSizeDoubled; y++)
//            {
//                for (int z = 0; z <= brushSizeDoubled; z++)
//                {
//                    temp = 0;
//
//                    if (oldMaterials[x + 1 + 1][y + 1][z + 1] == v.getReplaceId())
//                    {
//                        temp++;
//                    }
//                    if (oldMaterials[x + 1 - 1][y + 1][z + 1] == v.getReplaceId())
//                    {
//                        temp++;
//                    }
//                    if (oldMaterials[x + 1][y + 1 + 1][z + 1] == v.getReplaceId())
//                    {
//                        temp++;
//                    }
//                    if (oldMaterials[x + 1][y + 1 - 1][z + 1] == v.getReplaceId())
//                    {
//                        temp++;
//                    }
//                    if (oldMaterials[x + 1][y + 1][z + 1 + 1] == v.getReplaceId())
//                    {
//                        temp++;
//                    }
//                    if (oldMaterials[x + 1][y + 1][z + 1 - 1] == v.getReplaceId())
//                    {
//                        temp++;
//                    }
//
//                    if (temp == 0)
//                    {
//                        newMaterials[x][y][z] = v.getVoxelId();
//                    }
//                }
//            }
//        }
//
//        // Make the changes
//        final Undo undo = new Undo();
//        final double rSquared = Math.pow(brushSize + 0.5, 2);
//
//        for (int x = brushSizeDoubled; x >= 0; x--)
//        {
//            final double xSquared = Math.pow(x - brushSize, 2);
//
//            for (int y = 0; y <= 2 * brushSize; y++)
//            {
//                final double ySquared = Math.pow(y - brushSize, 2);
//
//                for (int z = 2 * brushSize; z >= 0; z--)
//                {
//                    if (xSquared + ySquared + Math.pow(z - brushSize, 2) <= rSquared)
//                    {
//                        if (this.getBlockIdAt(blockPositionX - brushSize + x, blockPositionY - brushSize + y, blockPositionZ - brushSize + z) != newMaterials[x][y][z])
//                        {
//                            undo.put(this.clampY(blockPositionX - brushSize + x, blockPositionY - brushSize + y, blockPositionZ - brushSize + z));
//                        }
//                        this.setBlockIdAt(blockPositionZ - brushSize + z, blockPositionX - brushSize + x, blockPositionY - brushSize + y, newMaterials[x][y][z]);
//                    }
//                }
//            }
//        }
//        v.owner().storeUndo(undo);
//
//        // This is needed because most uses of this brush will not be sible to the sniper.
//        v.owner().getPlayer().sendMessage(TextColors.AQUA + "Shell complete.");
//    }

    @Override
    protected final void arrow(final SnipeData v) {
//        this.bShell(v, this.getTargetBlock());
    }

    @Override
    protected final void powder(final SnipeData v) {
//        this.bShell(v, this.getLastBlock());
    }

    @Override
    public final void info(final Message vm) {
        vm.brushName(this.getName());
        vm.size();
        vm.voxel();
        vm.replace();
    }

    @Override
    public String getPermissionNode() {
        return "voxelsniper.brush.shellball";
    }
}
