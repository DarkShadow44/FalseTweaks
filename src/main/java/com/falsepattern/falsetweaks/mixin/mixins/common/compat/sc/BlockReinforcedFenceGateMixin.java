/*
 * This file is part of FalseTweaks.
 *
 * Copyright (C) 2022-2024 FalsePattern
 * All Rights Reserved
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * FalseTweaks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FalseTweaks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FalseTweaks. If not, see <https://www.gnu.org/licenses/>.
 */

package com.falsepattern.falsetweaks.mixin.mixins.common.compat.sc;

import net.geforcemods.securitycraft.blocks.reinforced.BlockReinforcedFenceGate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockStainedGlassPane;
import cpw.mods.fml.common.ObfuscationReflectionHelper;

@Mixin(BlockReinforcedFenceGate.class)
public abstract class BlockReinforcedFenceGateMixin extends BlockFenceGate {
    @Redirect(method = "<init>",
              at = @At(value = "INVOKE",
                       target = "Lcpw/mods/fml/common/ObfuscationReflectionHelper;setPrivateValue(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;I)V"),
              require = 0,
              expect = 0)
    private <T, E> void fixPriv(Class<T> classToAccess, T instance, E value, int index) {
        ObfuscationReflectionHelper.setPrivateValue(classToAccess, instance, value, "field_149764_J", "blockMaterial");
    }
}
