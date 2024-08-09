package spooketti.smashketti.packet;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import spooketti.smashketti.networking.PacketConstants;

public record doubleJumpPayload() implements CustomPayload
{
    public static final CustomPayload.Id<doubleJumpPayload> ID = new CustomPayload.Id<>(PacketConstants.DOUBLE_JUMP_PACKET);
    public static final PacketCodec<RegistryByteBuf, doubleJumpPayload> doubleJumpPacketCODEC =
            PacketCodec.unit(new doubleJumpPayload());
    @Override
    public CustomPayload.Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}

