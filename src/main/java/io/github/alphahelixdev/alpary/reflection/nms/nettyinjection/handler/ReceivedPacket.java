package io.github.alphahelixdev.alpary.reflection.nms.nettyinjection.handler;

import io.github.alphahelixdev.alpary.reflection.nms.nettyinjection.channel.ChannelWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class ReceivedPacket extends PacketAbstract {

	public ReceivedPacket(Object packet, Cancellable cancellable, Player player) {
		super(packet, cancellable, player);
	}

	public ReceivedPacket(Object packet, Cancellable cancellable, ChannelWrapper channelWrapper) {
		super(packet, cancellable, channelWrapper);
	}
}
