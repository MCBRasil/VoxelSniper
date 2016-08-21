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
import org.spongepowered.api.text.format.TextColors;

/**
 * http://www.voxelwiki.com/minecraft/Voxelsniper#The_Overlay_.2F_Topsoil_Brush
 *
 * @author Gavjenks
 */
public class OverlayBrush extends PerformBrush {

    private static final int DEFAULT_DEPTH = 3;
    private int depth = DEFAULT_DEPTH;
    private boolean allBlocks = false;

    // @Spongify
    public OverlayBrush() {
        this.setName("Overlay (Topsoil Filling)");
    }

    private void overlay(final SnipeData v) {
//        final int brushSize = v.getBrushSize();
//        final double brushSizeSquared = Math.pow(brushSize + 0.5, 2);
//
//
//        for (int z = brushSize; z >= -brushSize; z--)
//        {
//            for (int x = brushSize; x >= -brushSize; x--)
//            {
//                // check if column is valid
//                // column is valid if it has no solid block right above the clicked layer
//                final int materialId = this.getBlockIdAt(this.getTargetBlock().getX() + x, this.getTargetBlock().getY() + 1, this.getTargetBlock().getZ() + z);
//                if (isIgnoredBlock(materialId))
//                {
//                    if ((Math.pow(x, 2) + Math.pow(z, 2)) <= brushSizeSquared)
//                    {
//                        for (int y = this.getTargetBlock().getY(); y > 0; y--)
//                        {
//                            // check for surface
//                            final int layerBlockId = this.getBlockIdAt(this.getTargetBlock().getX() + x, y, this.getTargetBlock().getZ() + z);
//                            if (!isIgnoredBlock(layerBlockId))
//                            {
//                                for (int currentDepth = y; y - currentDepth < depth; currentDepth--)
//                                {
//                                    final int currentBlockId = this.getBlockIdAt(this.getTargetBlock().getX() + x, currentDepth, this.getTargetBlock().getZ() + z);
//                                    if (isOverrideableMaterial(currentBlockId))
//                                    {
//                                        this.current.perform(this.clampY(this.getTargetBlock().getX() + x, currentDepth, this.getTargetBlock().getZ() + z));
//                                    }
//                                }
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        v.owner().storeUndo(this.current.getUndo());
    }

//    @SuppressWarnings("deprecation")
//	private boolean isIgnoredBlock(int materialId)
//    {
//        return materialId == 9 || materialId == 8 || Material.getMaterial(materialId).isTransparent() || materialId == Material.CACTUS.getId();
//    }
//
//    @SuppressWarnings("deprecation")
//	private boolean isOverrideableMaterial(int materialId)
//    {
//        if (allBlocks && !(materialId == Material.AIR.getId()))
//        {
//            return true;
//        }
//
//        switch (materialId)
//        {
//            case 1:
//            case 2:
//            case 3:
//            case 12:
//            case 13:
//            case 24:
//            case 48:
//            case 82:
//            case 49:
//            case 78:
//                return true;
//
//            default:
//                return false;
//        }
//    }

    private void overlayTwo(final SnipeData v) {
//        final int brushSize = v.getBrushSize();
//        final double brushSizeSquared = Math.pow(brushSize + 0.5, 2);
//        final int[][] memory = new int[brushSize * 2 + 1][brushSize * 2 + 1];
//
//        for (int z = brushSize; z >= -brushSize; z--)
//        {
//            for (int x = brushSize; x >= -brushSize; x--)
//            {
//                boolean surfaceFound = false;
//                for (int y = this.getTargetBlock().getY(); y > 0 && !surfaceFound; y--)
//                { // start scanning from the height you clicked at
//                    if (memory[x + brushSize][z + brushSize] != 1)
//                    { // if haven't already found the surface in this column
//                        if ((Math.pow(x, 2) + Math.pow(z, 2)) <= brushSizeSquared)
//                        { // if inside of the column...
//                            if (this.getBlockIdAt(this.getTargetBlock().getX() + x, y - 1, this.getTargetBlock().getZ() + z) != 0)
//                            { // if not a floating block (like one of Notch'world pools)
//                                if (this.getBlockIdAt(this.getTargetBlock().getX() + x, y + 1, this.getTargetBlock().getZ() + z) == 0)
//                                { // must start at surface... this prevents it filling stuff in if
//                                    // you click in a wall and it starts out below surface.
//                                    if (!this.allBlocks)
//                                    { // if the override parameter has not been activated, go to the switch that filters out manmade stuff.
//
//                                        switch (this.getBlockIdAt(this.getTargetBlock().getX() + x, y, this.getTargetBlock().getZ() + z))
//                                        {
//                                            case 1:
//                                            case 2:
//                                            case 3:
//                                            case 12:
//                                            case 13:
//                                            case 14:
//                                            case 15:
//                                            case 16:
//                                            case 24:
//                                            case 48:
//                                            case 82:
//                                            case 49:
//                                            case 78:
//                                                for (int d = 1; (d < this.depth + 1); d++)
//                                                {
//                                                    this.current.perform(this.clampY(this.getTargetBlock().getX() + x, y + d, this.getTargetBlock().getZ() + z)); // fills down as many layers as you specify
//                                                    // in parameters
//                                                    memory[x + brushSize][z + brushSize] = 1; // stop it from checking any other blocks in this vertical 1x1 column.
//                                                }
//                                                surfaceFound = true;
//                                                break;
//
//                                            default:
//                                                break;
//                                        }
//                                    }
//                                    else
//                                    {
//                                        for (int d = 1; (d < this.depth + 1); d++)
//                                        {
//                                            this.current.perform(this.clampY(this.getTargetBlock().getX() + x, y + d, this.getTargetBlock().getZ() + z)); // fills down as many layers as you specify in
//                                            // parameters
//                                            memory[x + brushSize][z + brushSize] = 1; // stop it from checking any other blocks in this vertical 1x1 column.
//                                        }
//                                        surfaceFound = true;
//                                    }
//
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        v.owner().storeUndo(this.current.getUndo());
    }

    @Override
    protected final void arrow(final SnipeData v) {
        this.overlay(v);
    }

    @Override
    protected final void powder(final SnipeData v) {
        this.overlayTwo(v);
    }

    @Override
    public final void info(final Message vm) {
        vm.brushName(this.getName());
        vm.size();
    }

    @Override
    public final void parameters(final String[] par, final SnipeData v) {
        for (int i = 1; i < par.length; i++) {
            final String parameter = par[i];

            if (parameter.equalsIgnoreCase("info")) {
                v.sendMessage(TextColors.GOLD, "Overlay brush parameters:");
                v.sendMessage(TextColors.AQUA, "d[number] (ex:  d3) How many blocks deep you want to replace from the surface.");
                v.sendMessage(TextColors.BLUE,
                        "all (ex:  /b over all) Sets the brush to overlay over ALL materials, not just natural surface ones (will no longer ignore trees and buildings).  The parameter /some will set it back to default.");
                return;
            }
            if (parameter.startsWith("d")) {
                try {
                    this.depth = Integer.parseInt(parameter.replace("d", ""));

                    if (this.depth < 1) {
                        this.depth = 1;
                    }

                    v.sendMessage(TextColors.AQUA, "Depth set to " + this.depth);
                } catch (NumberFormatException e) {
                    v.sendMessage(TextColors.RED, "Depth isn't a number.");
                }
            } else if (parameter.startsWith("all")) {
                this.allBlocks = true;
                v.sendMessage(TextColors.BLUE, "Will overlay over any block." + this.depth);
            } else if (parameter.startsWith("some")) {
                this.allBlocks = false;
                v.sendMessage(TextColors.BLUE, "Will overlay only natural block types." + this.depth);
            } else {
                v.sendMessage(TextColors.RED, "Invalid brush parameters! use the info parameter to display parameter info.");
            }
        }
    }

    @Override
    public String getPermissionNode() {
        return "voxelsniper.brush.overlay";
    }
}
