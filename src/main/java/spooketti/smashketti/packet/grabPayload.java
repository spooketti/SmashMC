package spooketti.smashketti.packet;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import spooketti.smashketti.networking.PacketConstants;

public record grabPayload() implements CustomPayload
{
    public static final CustomPayload.Id<grabPayload> ID = new CustomPayload.Id<>(PacketConstants.GRAB_PACKET);
    public static final PacketCodec<RegistryByteBuf, grabPayload> grabPacketCODEC =
            PacketCodec.unit(new grabPayload());
    @Override
    public CustomPayload.Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}

