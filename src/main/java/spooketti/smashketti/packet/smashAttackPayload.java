package spooketti.smashketti.packet;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import spooketti.smashketti.networking.PacketConstants;

public record smashAttackPayload(boolean charging, int frames) implements CustomPayload
{
    public static final CustomPayload.Id<smashAttackPayload> smashAttackPacketID = new CustomPayload.Id<>(PacketConstants.SMASH_ATTACK_PACKET);
    public static final PacketCodec<RegistryByteBuf, smashAttackPayload> smashAttackPacketCODEC =
            PacketCodec.tuple(PacketCodecs.BOOL,smashAttackPayload::charging,
                    PacketCodecs.INTEGER, smashAttackPayload::frames,
                    smashAttackPayload::new);
    @Override
    public CustomPayload.Id<? extends CustomPayload> getId()
    {
        return smashAttackPacketID;
    }
}

