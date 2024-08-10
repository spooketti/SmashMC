package spooketti.smashketti.util;

import net.minecraft.nbt.NbtCompound;

public class PercentData {
    public static double changePercent(SaveEntityData player, double amount)
    {
        NbtCompound nbt = player.getPersistentData();
        double percent = nbt.getDouble("percent");
        percent += amount;
        nbt.putDouble("percent",percent);
        return percent;
    }
}
