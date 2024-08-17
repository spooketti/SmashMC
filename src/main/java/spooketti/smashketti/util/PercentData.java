package spooketti.smashketti.util;

import net.minecraft.nbt.NbtCompound;

public class PercentData {
    public static double changePercent(SaveEntityData player, double amount)
    {
        NbtCompound nbt = player.getPersistentData();
        double percent = nbt.getDouble("percent");
        percent += amount;
        percent = Math.max(0, Math.min(999, percent)); // clamp from 0 to 999 percent
        nbt.putDouble("percent",percent);
        return percent;
    }

    public static double getPercent(SaveEntityData player)
    {
        NbtCompound nbt = player.getPersistentData();
        double percent = nbt.getDouble("percent");
        return percent;
    }
}
